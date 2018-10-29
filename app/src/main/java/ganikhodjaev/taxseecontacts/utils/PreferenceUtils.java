package ganikhodjaev.taxseecontacts.utils;

import android.support.annotation.NonNull;

import com.orhanobut.hawk.Hawk;

/**
 * @author Khasan Ganikhodjaev
 */
public final class PreferenceUtils {


    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    private PreferenceUtils() {
    }


    public static void saveLogin(@NonNull String login) {
        Hawk.put(LOGIN, login);
    }

    public static void savePassword(@NonNull String password) {
        Hawk.put(PASSWORD, password);
    }

    @NonNull
    public static String getLogin() {
        return Hawk.get(LOGIN, "");
    }

    @NonNull
    public static String getPassword() {
        return Hawk.get(PASSWORD, "");
    }

    public static void removePassword() {
        Hawk.delete(PASSWORD);
    }
}
