package com.example.adam.myapplication.common;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.ResourceHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.SourceHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.transform.Source;

/**
 * Created by adam on 07.01.18.
 */

public class HttpRequestTask extends AsyncTask<Void, Void, String> {
    @Override
    protected String doInBackground(Void... params) {
        try {
            RestTemplate restTemplate = getRestTemplate();
            HttpHeaders headers = getHttpHeaders();
            HttpEntity<String> entity = getHttpEntity(headers);

            ResponseEntity<Resource> response = restTemplate.exchange(
                                            "http://10.0.2.2:2990/files/adam.png",
                                            HttpMethod.GET,
                                            entity,
                                            Resource.class);

            return "WORK_ASYNC";
        } catch (Exception e) {
            Log.e("Data from server_ERROR", e.getMessage(), e);
        }
        return "ERROR - NOT WORK_ASYNC";
    }

    private ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
        return arrayHttpMessageConverter;
    }

    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.IMAGE_JPEG);
        list.add(MediaType.IMAGE_PNG);
        list.add(MediaType.APPLICATION_OCTET_STREAM);
        return list;
    }

    private RestTemplate getRestTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getMessageConverters().add(byteArrayHttpMessageConverter() );
        restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
        restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        restTemplate.getMessageConverters().add(new ResourceHttpMessageConverter());
        restTemplate.getMessageConverters().add(new SourceHttpMessageConverter<Source>());
        return restTemplate;
    }

    private HttpHeaders getHttpHeaders(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
        return headers;
    }

    private HttpEntity<String> getHttpEntity(HttpHeaders headers){
        return new HttpEntity<String>(headers);
    }

}

