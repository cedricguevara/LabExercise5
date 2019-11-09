package com.guevara.labexercise5;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.List;

public class Adapter extends ArrayAdapter<Data> {
    private Context context;
    private int resource;

    public Adapter(Context context, int resource, List<Data> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
    }



    @Override
    public View getView(int i, @Nullable View convertView, ViewGroup parent) {
        int logo = getItem(i).getLogo();
        String version = getItem(i).getComName();
        String date = getItem(i).getCountry();
        String ceo = getItem(i).getCeoName();
        String industry = getItem(i).getIndustry();


        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        ImageView img = convertView.findViewById(R.id.labLogo);
        TextView comName = convertView.findViewById(R.id.labName);
        TextView industrY = convertView.findViewById(R.id.labIndustry);
        TextView ceoName = convertView.findViewById(R.id.labCeo);
        TextView country = convertView.findViewById(R.id.labCountry);

        img.setImageResource(logo);
        comName.setText(version);
        industrY.setText(industry);
        ceoName.setText(ceo);
        country.setText(date);
        return convertView;
    }
}

