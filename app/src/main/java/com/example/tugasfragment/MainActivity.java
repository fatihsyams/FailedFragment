package com.example.tugasfragment;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tugasfragment.fragment.Bandungfragment;
import com.example.tugasfragment.fragment.Depokfragment;
import com.example.tugasfragment.fragment.Jakartafragment;
import com.example.tugasfragment.fragment.Medanfragment;
import com.example.tugasfragment.fragment.Padangfragment;

public class MainActivity extends AppCompatActivity {

    Spinner sp;
    FragmentManager fm;
    RelativeLayout fl;

    private String[] listKota = {
            "Bandung", "Jakarta", "Depok", "Medan", "Padang"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = findViewById(R.id.spinner);
        fl = findViewById(R.id.container);
        fm = getSupportFragmentManager();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,
                listKota);

        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(MainActivity.this, "Bandung", Toast.LENGTH_SHORT).show();
                        fm.beginTransaction()
                                .add(R.id.container, new Bandungfragment())
                                .commit();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Jakarta", Toast.LENGTH_SHORT).show();
                        fm.beginTransaction()
                                .add(R.id.container, new Jakartafragment())
                                .commit();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Depok", Toast.LENGTH_SHORT).show();
                        fm.beginTransaction()
                                .add(R.id.container, new Depokfragment())
                                .commit();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Medan", Toast.LENGTH_SHORT).show();
                        fm.beginTransaction()
                                .add(R.id.container, new Medanfragment())
                                .commit();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "Padang", Toast.LENGTH_SHORT).show();
                        fm.beginTransaction()
                                .add(R.id.container, new Padangfragment())
                                .commit();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
