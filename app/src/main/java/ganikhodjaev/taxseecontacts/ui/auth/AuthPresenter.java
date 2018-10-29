package ganikhodjaev.taxseecontacts.ui.auth;

import android.support.annotation.NonNull;

import ganikhodjaev.taxseecontacts.api.ApiFactory;
import ganikhodjaev.taxseecontacts.utils.PreferenceUtils;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author Khasan Ganikhodjaev
 */
public class AuthPresenter {
    private AuthView authView;

    private CompositeDisposable disposable = new CompositeDisposable();


    public AuthPresenter(AuthView authView) {
        this.authView = authView;
    }

    void init() {

        String savedLogin = PreferenceUtils.getLogin();
        String savedPassword = PreferenceUtils.getPassword();

        authView.setLogin(savedLogin);
        authView.setPassword(savedPassword);

        if (!savedLogin.trim().isEmpty() && !savedPassword.trim().isEmpty())
            tryLogIn(savedLogin, savedPassword);

    }

    public void tryLogIn(@NonNull String login, @NonNull String password) {

        if (login.trim().isEmpty()) {
            authView.showLoginError();
            return;
        }

        if (password.trim().isEmpty()) {
            authView.showPasswordError();
            return;
        }

        authView.showLoading();

        disposable.add(ApiFactory.getTaxseeService()
                .authorize(login, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(authorization -> {
                    authView.hideLoading();

                    if (authorization.isSuccess()) {
                        PreferenceUtils.saveLogin(login);
                        PreferenceUtils.savePassword(password);
                        authView.openMainScreen();
                    } else showError();
                }, throwable -> {
                    authView.hideLoading();
                    showError();
                }));

    }

    private void showError() {
        authView.showLoginError();
        authView.showPasswordError();
    }


    void onDestroy() {
        disposable.dispose();
    }


}
