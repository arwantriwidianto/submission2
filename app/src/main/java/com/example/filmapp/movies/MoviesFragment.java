package com.example.filmapp.movies;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filmapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MoviesFragment extends Fragment {

    private String[] titleMovies;
    private String[] descMovies;
    private TypedArray imageMovies;
    private TypedArray bannerMovies;
    private ArrayList<ParcelMovies> movies;


    public MoviesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvMovies = view.findViewById(R.id.show_movies);

        prepareItem();
        addItem();

        rvMovies.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerMovies recyclerMovies = new RecyclerMovies(movies);
        rvMovies.setAdapter(recyclerMovies);

        recyclerMovies.setOnItemClickCallback(new RecyclerMovies.OnItemClickCallback() {
            @Override
            public void onItemClicked(ParcelMovies moviesData) {
                showIntentMovieDetail(moviesData);
            }
        });
    }

    private void prepareItem(){
        titleMovies = getResources().getStringArray(R.array.title_movies);
        descMovies = getResources().getStringArray(R.array.desc_movies);
        imageMovies = getResources().obtainTypedArray(R.array.image_movies);
        bannerMovies = getResources().obtainTypedArray(R.array.image_movies_banner);
    }

    private void addItem(){
        movies = new ArrayList<>();
        for (int i = 0; i < titleMovies.length; i++){
            ParcelMovies parcelMovies = new ParcelMovies();
            parcelMovies.setTitle(titleMovies[i]);
            parcelMovies.setDesc(descMovies[i]);
            parcelMovies.setImage(imageMovies.getResourceId(i,-1));
            parcelMovies.setBanner(bannerMovies.getResourceId(i, -1));
            movies.add(parcelMovies);
        }
    }

    private void showIntentMovieDetail(ParcelMovies movies){
        Intent intent = new Intent(getActivity(), DetailMovies.class);
        intent.putExtra(DetailMovies.EXTRA_MOVIES, movies);
        startActivity(intent);
    }
}
