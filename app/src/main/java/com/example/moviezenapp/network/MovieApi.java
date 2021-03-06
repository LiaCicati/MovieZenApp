package com.example.moviezenapp.network;

import com.example.moviezenapp.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {
    //search for movies
    @GET("/3/search/movie")
    Call<MovieResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );

    // search movie by id
    @GET("3/movie/{movie_id}?")
    Call<Movie> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

    // get popular movies
    @GET("3/movie/popular")
    Call<MovieResponse> getPopularMovies(
            @Query("api_key") String key,
            @Query("page") int page
    );
}
