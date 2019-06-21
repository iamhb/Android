package imgupload.com.imgupload;

import android.widget.Toast;

/**
 * Created by hari on 25/05/18.
 */

public class ImageUpload {

    public String name;
    public String url;

    public String getName()
    {
        return name;
    }

    public String getUrl()
    {
        return url;
    }

    public ImageUpload(String name,String url)
    {

        this.name=name;
        this.url=url;
    }
    public ImageUpload(){}
}
