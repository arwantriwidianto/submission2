package com.example.filmapp.movies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.filmapp.R;

public class DetailMovies extends AppCompatActivity {

    public static final String EXTRA_MOVIES = "extra_movies";
    private ImageView imgMoviesBannerDetail, imgMoviesDetail;
    private TextView detailTitleMovies, detailDescMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movies);

        imgMoviesBannerDetail = findViewById(R.id.img_banner_movies);
        imgMoviesDetail = findViewById(R.id.img_detail_movies);
        detailTitleMovies = findViewById(R.id.detail_title_movies);
        detailDescMovies = findViewById(R.id.detail_desc_movies);

        showMovieDetail();
    }

    private void showMovieDetail(){
        ParcelMovies parcelMovies = getIntent().getParcelableExtra(EXTRA_MOVIES);
        if (parcelMovies != null && getSupportActionBar() != null){

            getSupportActionBar().setTitle(parcelMovies.getTitle());

            detailTitleMovies.setText(parcelMovies.getTitle());
            detailDescMovies.setText(parcelMovies.getDesc());

            Glide.with(this)
                    .load(parcelMovies.getImage())
                    .into(imgMoviesDetail);
            Glide.with(this)
                    .load(parcelMovies.getBanner())
                    .into(imgMoviesBannerDetail);
        }
    }
}
