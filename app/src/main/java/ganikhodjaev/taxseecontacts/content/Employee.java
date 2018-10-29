package ganikhodjaev.taxseecontacts.content;

import java.io.Serializable;

import ganikhodjaev.taxseecontacts.BuildConfig;
import ganikhodjaev.taxseecontacts.utils.PreferenceUtils;

/**
 * @author Khasan Ganikhodjaev
 */
public class Employee implements Serializable {
    private String ID;
    private String Name;
    private String Title;
    private String Phone;
    private String Email;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhotoURL() {
        return BuildConfig.API_ENDPOINT_PHOTO
                .replace("{login}", PreferenceUtils.getLogin())
                .replace("{password}", PreferenceUtils.getPassword())
                .replace("{id}", ID);
    }
}
