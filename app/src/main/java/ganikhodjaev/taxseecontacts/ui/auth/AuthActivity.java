package ganikhodjaev.taxseecontacts.ui.auth;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import ganikhodjaev.taxseecontacts.R;
import ganikhodjaev.taxseecontacts.databinding.ActivityAuthBinding;
import ganikhodjaev.taxseecontacts.ui.main.MainActivity;

/**
 * @author Khasan Ganikhodjaev
 */
public class AuthActivity extends AppCompatActivity implements AuthView {


    private AuthPresenter mPresenter;


    public static void start(@NonNull Activity activity) {
        Intent intent = new Intent(activity, AuthActivity.class);
        activity.startActivity(intent);
    }

    ActivityAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth);
        binding.setAuthActivity(this);

        mPresenter = new AuthPresenter(this);
        mPresenter.init();
    }

    public void onLogInButtonClick(View view) {
        String login = binding.loginEdit.getText().toString();
        String password = binding.passwordEdit.getText().toString();
        mPresenter.tryLogIn(login, password);
    }

    @Override
    public void setLogin(String login) {
        binding.loginEdit.setText(login);
    }

    @Override
    public void setPassword(String password) {
        binding.passwordEdit.setText(password);
    }

    @Override
    public void showLoginError() {
        binding.loginInputLayout.setError(getString(R.string.error));

    }

    @Override
    public void showPasswordError() {
        binding.passwordInputLayout.setError(getString(R.string.error));

    }

    @Override
    public void openMainScreen() {
        MainActivity.start(this);
        finish();
    }

    @Override
    public void showLoading() {
        binding.pb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        binding.pb.setVisibility(View.GONE);
    }

    public void lockActions(View view) {
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
