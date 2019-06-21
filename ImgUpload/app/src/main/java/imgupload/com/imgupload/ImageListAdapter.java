package imgupload.com.imgupload;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;

import static imgupload.com.imgupload.R.id.tvImageName;

/**
 * Created by hari on 26/05/18.
 */

public class ImageListAdapter extends ArrayAdapter<ImageUpload> {
    private Activity context;
    private int resource;
    private List<ImageUpload> listImage;

    public ImageListAdapter(@NonNull Activity context, int resource, @NonNull List<ImageUpload> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        listImage=objects;
    }
    @NonNull
    @Override

    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater= context.getLayoutInflater();

        View v= inflater.inflate(resource,null);
        TextView tvName= (TextView) v.findViewById(tvImageName);
        ImageView img= (ImageView)v.findViewById(R.id.imgView);


                tvName.setText(listImage.get(position).getName());
                Glide.with(context).load(listImage.get(position).getUrl()).into(img);
            return v;

}
}
