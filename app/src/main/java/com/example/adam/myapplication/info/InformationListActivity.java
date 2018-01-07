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
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;

public class InformationListActivity extends AppCompatActivity {

    private ListView informationListView;
    private ArrayAdapter<InformationRow> arrayAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        new HttpRequestTask().execute();
    }

    private class HttpRequestTask extends AsyncTask<Void, Void, Greeting> {
        @Override
        protected Greeting doInBackground(Void... params) {
            try {

                RestTemplate restTemplate = new RestTemplate();
                restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());

                final String url = "http://rest-service.guides.spring.io/greeting";
                Greeting greeting = restTemplate.getForObject(url, Greeting.class);


                final String url2 = "http://10.0.2.2:2990/image-resource";
                byte[] bytes = restTemplate.getForObject(url2   , byte[].class);

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
