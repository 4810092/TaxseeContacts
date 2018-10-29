package ganikhodjaev.taxseecontacts;

import android.app.Application;
import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.orhanobut.hawk.Hawk;
import com.squareup.picasso.Picasso;

/**
 * @author Khasan Ganikhodjaev
 */
public class AppDelegate extends Application {

    private static AppDelegate sInstance;

    public static AppDelegate getAppContext() {
        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        Hawk.init(this).build();

        Picasso picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(this))
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
