package mohamed.com.myretrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohamed on 22/03/2018.
 */

public class Contact {

    @SerializedName("Name")
    private String name;

    @SerializedName("Mail")
    private String mail;

    public Contact(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
