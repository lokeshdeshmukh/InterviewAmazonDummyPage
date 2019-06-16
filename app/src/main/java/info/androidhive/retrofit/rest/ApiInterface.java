package info.androidhive.retrofit.rest;

import info.androidhive.retrofit.model.pojo.EpisodesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {
    @Headers({"Content-Type: application/json",
            "xAccessToken:abc",
            "user_id:abc"})
    @GET("15000002")
    Call<EpisodesResponse> getTopEpisodes();

    @GET("movie/{id}")
    Call<EpisodesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
