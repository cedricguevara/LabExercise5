package com.guevara.labexercise5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] comName, country, ceo, industry, description;
    int[] logo = {R.drawable.icbc, R.drawable.jpmorgan, R.drawable.ccb, R.drawable.abc, R.drawable.boa, R.drawable.apple, R.drawable.paig, R.drawable.boc, R.drawable.rdshell, R.drawable.wells, R.drawable.exxon, R.drawable.atnt, R.drawable.samsung, R.drawable.citigroup};
    ListView lstVersions;
    ArrayList<Data> versions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comName = getResources().getStringArray(R.array.comName);
        country = getResources().getStringArray(R.array.country);
        ceo = getResources().getStringArray(R.array.ceoName);
        industry = getResources().getStringArray(R.array.industry);
        description = getResources().getStringArray(R.array.description);
        for (int i = 0; i < comName.length; i++) {
            versions.add(new Data(logo[i], comName[i], country[i], ceo[i], industry[i], description[i]));
        }

        Adapter adapter = new Adapter(this, R.layout.newactivity, versions);
        lstVersions = findViewById(R.id.listView);
        lstVersions.setAdapter(adapter);
        lstVersions.setOnItemClickListener(this);
        setTitle("THE TOP 14 GLOBAL COMPANIES");
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
        final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, "company.txt");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            String choice = description[i];
            fos.write(choice.getBytes());
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setIcon(logo[i]);
            dialog.setTitle(comName[i]);
            dialog.setMessage(description[i]);
            dialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, comName[i]+ " " + country[i]+" "+ceo[i], Toast.LENGTH_LONG).show();

                }

            });


            dialog.create().show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}