package getvalhb.com.getvalue;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseReference ref= FirebaseDatabase.getInstance().getReference();
        String var = "-LAPBTw5Bt4j_kCOwsWA";
        final String uname="Hari";
        final String uno="9003361236";
        DatabaseReference objhb= ref.child("").child(var).child("name");

        //next 3 lines to delete a particular uid
        DatabaseReference delobj = FirebaseDatabase.getInstance().getReference("students").child("-LHsf38UbhHwO9dI7s7s");
        delobj.removeValue();
        Toast.makeText(MainActivity.this,"deleted",Toast.LENGTH_SHORT).show();

        DatabaseReference newobj=ref.child("students");
        //FirebaseUser user;
        //String Userid=user.getUid();

        objhb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String herename = dataSnapshot.getValue(String.class);
                //Toast.makeText(MainActivity.this,"today",Toast.LENGTH_SHORT).show();
                //Toast.makeText(MainActivity.this,herename,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        newobj.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override//datasnapshot take a snapshot like process, it carry the copy of data, here it takes copy of newobj data,where newobj refers entire db
            public void onDataChange(DataSnapshot dataSnapshot) {
              ArrayList<String> Userlist1 = new ArrayList<String>();
              ArrayList<String> Userlist2 = new ArrayList<String>();//creating two arraylist to fetch all name and phno from firebase,

                for(DataSnapshot dsp : dataSnapshot.getChildren()){
                 Userlist1.add(dsp.child("name").getValue().toString());//adding value in arrraylist (similar to array)
                  Userlist2.add(dsp.child("phno").getValue().toString());
                  // palaya work agura code Userlist.add(String.valueOf(dsp.getValue()));
              }
                //Toast.makeText(MainActivity.this,uname,Toast.LENGTH_SHORT).show();
                int n=Userlist1.size();
                for(int i=0;i<n;i++)
                {
                    //String temp = Userlist1.get(i);
                    //if(Userlist2.get(i).equals(uno))
                    {
                        Toast.makeText(MainActivity.this,"user found"+ Userlist2.get(i),Toast.LENGTH_SHORT).show();
                    }
                   // else
                    //{
                   //    //Toast.makeText(MainActivity.this,"user not found"+ Userlist1.get(i),Toast.LENGTH_SHORT).show();
                    //}
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
}
