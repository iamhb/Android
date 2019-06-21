package dummymain.com.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

EditText textbox;
TextView label;
Button button;
    String date;
    int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textbox=(EditText)findViewById(R.id.editText);
        label=(TextView)findViewById(R.id.textView2);
        button=(Button)findViewById(R.id.button);
        a=5/5/1998;
        textbox.setText(a);

       // date= textbox.getText().toString();
        if(date!=null)
        {
            Toast.makeText(MainActivity.this,"got value",Toast.LENGTH_SHORT).show();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"date:"+ date,Toast.LENGTH_SHORT).show();
                label.setText("hello"+date);
                /*Toast.makeText(MainActivity.this,"date:"+ date.substring(0,1),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"month:"+ date.substring(2,3),Toast.LENGTH_SHORT).show();
                Toast.makeText(MainActivity.this,"year:"+ date.substring(4,7),Toast.LENGTH_SHORT).show();*/
            }
        });

    }
}
