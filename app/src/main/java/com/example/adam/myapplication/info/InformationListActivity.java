package com.example.adam.myapplication.info;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adam.myapplication.R;
import com.example.adam.myapplication.create.CreateInformationActivity;

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

public class InformationListActivity extends AppCompatActivity {

    private ListView informationListView;
    private ArrayAdapter<InformationRow> arrayAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }


    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
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

    private class HttpRequestTask extends AsyncTask<Void, Void, Greeting> {
        @Override
        protected Greeting doInBackground(Void... params) {
            try {

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                restTemplate.getMessageConverters().add(byteArrayHttpMessageConverter() );
                restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
                restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                restTemplate.getMessageConverters().add(new ResourceHttpMessageConverter());
                restTemplate.getMessageConverters().add(new SourceHttpMessageConverter<Source>());
                final String url = "http://rest-service.guides.spring.io/greeting";
                Greeting greeting = restTemplate.getForObject(url, Greeting.class);

                HttpHeaders headers = new HttpHeaders();
                headers.setAccept(Arrays.asList(MediaType.APPLICATION_OCTET_STREAM));
                HttpEntity<String> entity = new HttpEntity<String>(headers);

                ResponseEntity<Resource> response = restTemplate.exchange(
                        "http://10.0.2.2:2990/files/adam.png",
                        HttpMethod.GET, entity,Resource.class, "1");


//                final String url2 = "http://10.0.2.2:2990/files/adam.png";
//                ResponseEntity<Resource> result = restTemplate.getForObject(url2, ResponseEntity.class);

                return greeting;
            } catch (Exception e) {
                Log.e("MainActivity", e.getMessage(), e);
            }

            return null;
        }

        @Override
        protected void onPostExecute(Greeting greeting) {
            //Log.e("MainActivity", greeting, null);

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item_menu_add_information:
                new HttpRequestTask().execute();
                Intent intent = new Intent(getApplicationContext(), CreateInformationActivity.class);
                startActivity(intent);
                return true;
            case R.id.item_menu_information_list:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_list_activity);

        informationListView = (ListView) findViewById(R.id.informationListView);
        arrayAdapter = new InformationAdapter(this,initInformationListView());

        informationListView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    private ArrayList<InformationRow> initInformationListView(){
        ArrayList<InformationRow> informationRowList = new ArrayList<InformationRow>();
        informationRowList.add(new InformationRow("poniedzialek","kradzież","Warszawa"));
        informationRowList.add(new InformationRow("wtorek","włamania","Warszawa"));
        informationRowList.add(new InformationRow("sroda","inne","Warszawa"));
        informationRowList.add(new InformationRow("czwartek","pożar","Warszawa"));
        informationRowList.add(new InformationRow("piątek","pobicie","Węgrów"));
        informationRowList.add(new InformationRow("poniedzialek","kradzież","Warszawa"));
        informationRowList.add(new InformationRow("wtorek","włamania","Warszawa"));
        informationRowList.add(new InformationRow("sroda","inne","Warszawa"));
        informationRowList.add(new InformationRow("czwartek","pożar","Warszawa"));
        informationRowList.add(new InformationRow("piątek","pobicie","Węgrów"));
        informationRowList.add(new InformationRow("poniedzialek","kradzież","Warszawa"));
        informationRowList.add(new InformationRow("wtorek","włamania","Warszawa"));
        informationRowList.add(new InformationRow("sroda","inne","Warszawa"));
        informationRowList.add(new InformationRow("czwartek","pożar","Warszawa"));
        informationRowList.add(new InformationRow("piątek","pobicie","Węgrów"));
        informationRowList.add(new InformationRow("poniedzialek","kradzież","Warszawa"));
        informationRowList.add(new InformationRow("wtorek","włamania","Warszawa"));
        informationRowList.add(new InformationRow("sroda","inne","Warszawa"));
        informationRowList.add(new InformationRow("czwartek","pożar","Warszawa"));
        informationRowList.add(new InformationRow("piątek","pobicie","Węgrów"));

        return informationRowList;
    }
}
