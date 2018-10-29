package ganikhodjaev.taxseecontacts.utils;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ganikhodjaev.taxseecontacts.AppDelegate;

/**
 * @author Khasan Ganikhodjaev
 */
public class ImageViewAdapters {

    @BindingAdapter("android:src")
    public static void setImageUrl(@NonNull ImageView imageView, @NonNull String url) {
        if (TextUtils.isEmpty(url)) {
            return;
        }
        Picasso.with(AppDelegate.getAppContext())
                .load(url)
                .noFade()
                .into(imageView);
    }

}
