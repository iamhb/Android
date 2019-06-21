package dummymain.com.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

        Spinner sp;
        String s1, s2, a2, a1;
        EditText e1;
        Button b1;


        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sp = (Spinner) findViewById(R.id.sp);

        List<String> list = new ArrayList<String>();
        list.add("--select--");
        list.add("O+ve");
        list.add("O-ve");
        list.add("A+ve");
        list.add("A-ve");
        list.add("B+ve");
        list.add("B-ve");
        list.add("AB+ve");
        list.add("AB-ve");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);

        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(dataAdapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                s1 = String.valueOf(sp.getSelectedItem());
                // Toast.makeText(Main3Activity.this,record+,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b1 = (Button) findViewById(R.id.b1);
        e1 = (EditText) findViewById(R.id.e1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                s2 = e1.getText().toString();
                Intent in = new Intent(MainActivity.this, MainActivity2.class);
                a1 = s1;
                a2 = s2;
                in.putExtra("value", a1);
                in.putExtra("value1", a2);
                startActivity(in);
                finish();
            }
        });
    }


}
