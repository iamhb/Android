package dummymain.com.intentdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    String c,d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        c = getIntent().getExtras().getString("value");
        d = getIntent().getExtras().getString("value1");
        Toast.makeText(getApplicationContext(),c+"/n"+d, Toast.LENGTH_LONG).show();
    }

}
