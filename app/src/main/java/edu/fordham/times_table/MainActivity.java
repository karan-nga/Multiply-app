package edu.fordham.times_table;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> data = new ArrayList<>();
        SeekBar s = (SeekBar) findViewById(R.id.seekBar);

        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                data.clear();
                for(int j = 0; j <= 100; j++){
                    int result = j*progressChangedValue;
                    String r = Integer.toString(progressChangedValue) + " x " + Integer.toString(j) + " = " + Integer.toString(result);
                    Log.i("mobdev",r);
                    data.add(r);
                }
                adapter = new MyAdapter(data);
                recyclerView.setAdapter(adapter);
            }
        });

    }
}