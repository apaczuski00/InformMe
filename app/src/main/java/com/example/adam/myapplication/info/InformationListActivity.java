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
import com.example.adam.myapplication.common.HttpRequestTask;
import com.example.adam.myapplication.common.TMPData;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
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

        informationListView = findViewById(R.id.informationListView);
        arrayAdapter = new InformationAdapter(this, TMPData.initInformationListView());

        informationListView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }


}
