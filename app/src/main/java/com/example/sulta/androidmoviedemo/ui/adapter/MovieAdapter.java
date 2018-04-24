package com.example.sulta.androidmoviedemo.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sulta.androidmoviedemo.R;
import com.example.sulta.androidmoviedemo.api.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private List<Movie> movies;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;

    public MovieAdapter(Context context,List<Movie> movies) {
        this.movies = movies;
        this.context=context;
        this.mInflater=LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.single_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = movies.get(position);
        Picasso.get().load(movie.getMoviePosterURL()).into(holder.mainImageView);
        Picasso.get().load(movie.getMoviePosterURL()).into(holder.miniImageView);
        holder.movieTitle.setText(movie.getMovieTitle());
        holder.movieRating.setText(String.valueOf(movie.getMovieRating()));
        holder.movieReleaseYear.setText(String.valueOf(movie.getMovieReleaseYear()));
        holder.movieGenre.setText(movie.getMovieGenre());//movie.getMovieGenre()
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
    String getItem(int id) {
        return movies.get(id).getMovieTitle();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.main_image_view)
        ImageView mainImageView;

        @BindView(R.id.mini_image_view)
        ImageView miniImageView;

        @BindView(R.id.movie_title_text_view)
        TextView movieTitle;

        @BindView(R.id.movie_rating_text_view)
        TextView movieRating;

        @BindView(R.id.movie_release_year_text_view)
        TextView movieReleaseYear;

        @BindView(R.id.movie_genre_text_view)
        TextView movieGenre;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) {

                mClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}