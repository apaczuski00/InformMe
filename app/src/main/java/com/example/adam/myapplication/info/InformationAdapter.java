package com.example.adam.myapplication.info;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adam.myapplication.R;

import java.util.List;


public class InformationAdapter  extends ArrayAdapter<InformationRow>{
    private TextView informationDate ;
    private TextView informationDetails ;
    private TextView informationArea ;
    private ImageView informationImage;

    public InformationAdapter(Context context, List<InformationRow> informationRowList) {
        super(context, 0, informationRowList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.information_row, parent, false);
        }
        informationImage = convertView.findViewById(R.id.informationImage);
        informationDate =  convertView.findViewById(R.id.inforamtionDate);
        informationDetails =  convertView.findViewById(R.id.inforamtionDetails);
        informationArea =  convertView.findViewById(R.id.informationArea);

        InformationRow informationRow = getItem(position);

        informationDate.setText(informationRow.getDate());
        informationDetails.setText(informationRow.getDetails());
        informationArea.setText(informationRow.getArea());

        return convertView;
    }

}
