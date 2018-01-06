package com.example.adam.myapplication.info;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adam.myapplication.R;

import java.util.ArrayList;

public class InformationListActivity extends AppCompatActivity {

    private ListView informationListView;
    private ArrayAdapter<InformationRow> arrayAdapter;

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
                return true;
            case R.id.item_menu_settings:
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
