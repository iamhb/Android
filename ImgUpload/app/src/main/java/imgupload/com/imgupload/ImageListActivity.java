package imgupload.com.imgupload;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ImageListActivity extends AppCompatActivity {


    private DatabaseReference mDatabaseRef;
    private List<ImageUpload> imgList;
    private ListView lv;
    public int count=0;
    private ImageListAdapter adapter;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);
        imgList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.ListViewImage);
        //show progress dialog during list image loading
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("please wait loading list image..");
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(MainActivity.FB_DATABASE_PATH);
        final String temp= "-LDPzUZy4z6q4yzMfQ8m";
        //line 43 and 44 for attu-needhi-hb project, here 47 line object newobj
        // can be replaced with mDatabaseRef
        DatabaseReference hbreftest = FirebaseDatabase.getInstance().getReference();
        DatabaseReference newobj=hbreftest.child("image2");


        newobj.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                //fetch image data from firebase database
                for(DataSnapshot snapshot: dataSnapshot.getChildren()){
                    //imageupload class require default constructor
                    ImageUpload img= snapshot.getValue(ImageUpload.class);
                    //String temp= img.name.toString();
                    if(img.name.equals("aabasa gp")) {
                        Toast.makeText(getBaseContext(),""+img.name,Toast.LENGTH_SHORT).show();
                        imgList.add(img);
                    }
                    try {
                        FileOutputStream out = new FileOutputStream(String.valueOf(img));
                        Bitmap bmp;
                        //bmp.compress(Bitmap.CompressFormat.PNG, 100, out); //100-best quality
                        out.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    imgList.add(img );
                    count++;
                    Toast.makeText(getBaseContext(),""+ count+ "-" +img.name,Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(getBaseContext(),"value"+count,Toast.LENGTH_SHORT).show();
                //init adapter
                adapter = new ImageListAdapter(ImageListActivity.this,R.layout.image_item,imgList);
                //set adapter for listview
                lv.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                    progressDialog.dismiss();
            }
        });
    }

}
