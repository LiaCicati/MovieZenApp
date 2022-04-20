package com.example.moviezenapp.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moviezenapp.R;
import com.example.moviezenapp.models.Movie;
import com.example.moviezenapp.models.Watchlist;
import com.example.moviezenapp.repositories.WatchlistRepository;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movie> movies;
    private final OnMovieClickListener onMovieClickListener;
    WatchlistRepository watchlistRepository;

    public MovieAdapter(List<Movie> movies, OnMovieClickListener onMovieClickListener) {
        this.movies = movies;
        this.onMovieClickListener = onMovieClickListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item, parent,
                false);
        return new MovieViewHolder(view, onMovieClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,int position) {
        // Image view: Using Glide Library
        Glide.with(holder.itemView.getContext()).load("https://image.tmdb.org/t/p/w500/" + movies.get(position).getPoster_path())
                .into((((MovieViewHolder) holder).imageView));
//        ((MovieViewHolder)holder).ratingBar.setRating((movies.get(position).getVote_average())/2);

//       ((MovieViewHolder) holder).watchlist.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//              addToWatchlist(movies.get(holder.getAbsoluteAdapterPosition()));
//           }
//       });
    }

    private void addToWatchlist(Movie movie) {
        Watchlist watchlist = new Watchlist();
        watchlist.setId(movie.getId());
        watchlist.setTitle(movie.getTitle());

        watchlistRepository.insertWatchlistItem(watchlist);
    }

    @Override
    public int getItemCount() {

        if (movies != null) {
            return movies.size();
        }
        return 0;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setMovies(List<Movie> movies) {
        this.movies = movies;
        notifyDataSetChanged();
    }

    // Getting the id of the movie click

    public Movie getSelectedMovie(int position) {
        if (movies != null) {
            if (movies.size() > 0) {
                return movies.get(position);
            }
        }
        return null;
    }
}
