package mohamed.com.myretrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by mohamed on 22/03/2018.
 */

public interface ApiClient {
    public static  String BASE_URL ="https://127.0.0.1/";

    @GET("contact_info.php")
    Call<Contact>AddInfo();
}
