package ganikhodjaev.taxseecontacts.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ganikhodjaev.taxseecontacts.ui.auth.AuthActivity;

/**
 * @author Khasan Ganikhodjaev
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AuthActivity.start(this);
        finish();
    }

}
