package com.example.adam.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView informationListView;
    private ArrayAdapter<Information> arrayAdapter;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        informationListView = (ListView) findViewById(R.id.informationListView);
        arrayAdapter = new InformationAdapter(this,initInformationListView());

        informationListView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();
    }

    private ArrayList<Information> initInformationListView(){
        ArrayList<Information> informationList = new ArrayList<Information>();
        informationList.add(new Information("poniedzialek","kradzież","Warszawa"));
        informationList.add(new Information("wtorek","włamania","Warszawa"));
        informationList.add(new Information("sroda","inne","Warszawa"));
        informationList.add(new Information("czwartek","pożar","Warszawa"));
        informationList.add(new Information("piątek","pobicie","Węgrów"));
        informationList.add(new Information("poniedzialek","kradzież","Warszawa"));
        informationList.add(new Information("wtorek","włamania","Warszawa"));
        informationList.add(new Information("sroda","inne","Warszawa"));
        informationList.add(new Information("czwartek","pożar","Warszawa"));
        informationList.add(new Information("piątek","pobicie","Węgrów"));
        informationList.add(new Information("poniedzialek","kradzież","Warszawa"));
        informationList.add(new Information("wtorek","włamania","Warszawa"));
        informationList.add(new Information("sroda","inne","Warszawa"));
        informationList.add(new Information("czwartek","pożar","Warszawa"));
        informationList.add(new Information("piątek","pobicie","Węgrów"));
        informationList.add(new Information("poniedzialek","kradzież","Warszawa"));
        informationList.add(new Information("wtorek","włamania","Warszawa"));
        informationList.add(new Information("sroda","inne","Warszawa"));
        informationList.add(new Information("czwartek","pożar","Warszawa"));
        informationList.add(new Information("piątek","pobicie","Węgrów"));

        return informationList;
    }
}
