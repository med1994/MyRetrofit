package mohamed.com.myretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;

public class MainActivity extends AppCompatActivity {
    EditText name,mail;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.nametextview);
        mail=(EditText)findViewById(R.id.mailtextview);
        btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener((View event) ->{
            Contact contact=new Contact(name.getText().toString(),mail.getText().toString());
            SendNetWorkRequest(contact);
        });

    }
    public void SendNetWorkRequest(Contact contact){
        //retrofit instance
        Retrofit.Builder builder=new Retrofit.Builder().baseUrl(ApiClient.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit=builder.build();
        //get client&callobject for request
        ApiClient client=retrofit.create(ApiClient.class);

        Call<Contact> call=client.AddInfo();
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                Toast.makeText(MainActivity.this, "User name"+response.body().getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Toast.makeText(MainActivity.this, "it's faild", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
