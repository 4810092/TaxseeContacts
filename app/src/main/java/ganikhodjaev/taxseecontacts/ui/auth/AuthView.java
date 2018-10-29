package ganikhodjaev.taxseecontacts.ui.auth;


import ganikhodjaev.taxseecontacts.ui.base.LoadingView;

/**
 * @author Khasan Ganikhodjaev
 */
public interface AuthView extends LoadingView {


    void openMainScreen();

    void showLoginError();

    void showPasswordError();

    void setLogin(String login);

    void setPassword(String password);
}
