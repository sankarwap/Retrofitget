package bala.retrofitsample.api;

import java.util.List;

import bala.retrofitsample.model.Movie;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Mindmade technologies on 06-05-2017.
 */
public interface AllApi {
    String BASE_URL = "https://simplifiedcoding.net/demos/";

    @GET("marvel")
    Call<List<Movie>> getHeroes();
}
