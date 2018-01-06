package com.example.adam.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class InformationAdapter  extends ArrayAdapter<InformationRow>{
    TextView informationDate ;
    TextView informationDetails ;
    TextView informationArea ;

    public InformationAdapter(Context context, List<InformationRow> informationRowList) {
        super(context, 0, informationRowList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.information_row, parent, false);
        }
        informationDate = (TextView) convertView.findViewById(R.id.inforamtionDate);
        informationDetails = (TextView) convertView.findViewById(R.id.inforamtionDetails);
        informationArea = (TextView) convertView.findViewById(R.id.informationArea);

        InformationRow informationRow = getItem(position);

        informationDate.setText(informationRow.getDate());
        informationDetails.setText(informationRow.getDetails());
        informationArea.setText(informationRow.getArea());

        return convertView;
    }

}
