package com.example.adam.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by adam on 04.01.18.
 */

public class InformationAdapter  extends ArrayAdapter<Information>{
    TextView informationDate ;
    TextView informationDetails ;
    TextView informationArea ;

    public InformationAdapter(Context context, List<Information> informationList) {
        super(context, 0, informationList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.information_row, parent, false);
        }
        informationDate = (TextView) convertView.findViewById(R.id.inforamtionDate);
        informationDetails = (TextView) convertView.findViewById(R.id.inforamtionDetails);
        informationArea = (TextView) convertView.findViewById(R.id.informationArea);

        Information information = getItem(position);

        informationDate.setText(information.getDate());
        informationDetails.setText(information.getDetails());
        informationArea.setText(information.getArea());

        return convertView;
    }

}
