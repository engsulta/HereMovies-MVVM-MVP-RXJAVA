package com.example.sulta.androidmoviedemo.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sulta.androidmoviedemo.R;
import com.example.sulta.androidmoviedemo.api.model.Movie;
import com.example.sulta.androidmoviedemo.ui.adapter.MovieAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainContract.View, MovieAdapter.ItemClickListener {

    @BindView(R.id.movie_recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.loading_indicator)
    ProgressBar loadingIndicator;

    private List<Movie> movies;
    private Movie movie;
    MovieAdapter adapter;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter=new MainPresenter(this);
        mainPresenter.subscripToRetrofit();
        loadingIndicator.setVisibility(View.VISIBLE);

//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(MovieClient.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        MovieClient api = retrofit.create(MovieClient.class);
//        Call<List<Movie>> call = api.getAllMovies();
//        call.enqueue(new Callback<List<Movie>>() {
//            @Override
//            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
//                movies = response.body();
//                Log.i("MovieDemo", "onResponse: " + movies.size());
//                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
//
//                gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//                    @Override
//                    public int getSpanSize(int position) {
//                        return position % 3 == 0 ? 2 : 1;
//                    }
//                });
//                // RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
//                recyclerView.setLayoutManager(gridLayoutManager);
//                MovieAdapter adapter = new MovieAdapter(MainActivity.this, movies);
//                recyclerView.setHasFixedSize(true);
//                recyclerView.setAdapter(adapter);
//
//                loadingIndicator.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onFailure(Call<List<Movie>> call, Throwable t) {
//                Toast.makeText(MainActivity.this, "Failed to get data!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public void updateUi(List<Movie> movies) {
        if (movies != null) {
            Log.i("MovieDemo", "onResponse: " + movies.size());
            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this, 2);

            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return position % 3 == 0 ? 2 : 1;
                }
            });
            recyclerView.setLayoutManager(gridLayoutManager);
            MovieAdapter adapter = new MovieAdapter(MainActivity.this, movies);
            recyclerView.setHasFixedSize(true);
            recyclerView.setAdapter(adapter);

            loadingIndicator.setVisibility(View.GONE);
        }else{
            Toast.makeText(MainActivity.this, "Failed to get data!", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItemId(position), Toast.LENGTH_SHORT).show();
    }
}
