package bala.retrofitsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.List;

import bala.retrofitsample.api.AllApi;
import bala.retrofitsample.api.ApiClient;
import bala.retrofitsample.model.Movie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    AllApi apiInitialize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        apiInitialize = ApiClient.getClient().create(AllApi.class);

        Call<List<Movie>> call = apiInitialize.getHeroes();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {

                List<Movie> heroList = response.body();

                Toast.makeText(MainActivity.this, heroList.get(0).getName(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
