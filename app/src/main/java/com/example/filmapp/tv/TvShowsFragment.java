package com.example.filmapp.tv;


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
public class TvShowsFragment extends Fragment {

    private String[] titleTV;
    private String[] descTV;
    private TypedArray imageTV;
    private TypedArray bannerTV;
    private ArrayList<ParcelTV> tv;


    public TvShowsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv_shows, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView rvTV = view.findViewById(R.id.show_tv);

        prepareItem();
        addItem();

        rvTV.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerTV recyclerTV = new RecyclerTV(tv);
        rvTV.setAdapter(recyclerTV);

        recyclerTV.setOnItemClickCallback(new RecyclerTV.OnItemClickCallback() {
            @Override
            public void onItemClicked(ParcelTV tvData) {
                showIntentTVDetail(tvData);
            }
        });
    }

    private void prepareItem(){
        titleTV = getResources().getStringArray(R.array.title_tv_shows);
        descTV = getResources().getStringArray(R.array.desc_tv_shows);
        imageTV = getResources().obtainTypedArray(R.array.image_tv_shows);
        bannerTV = getResources().obtainTypedArray(R.array.image_tv_banner);
    }

    private void addItem(){
        tv = new ArrayList<>();
        for (int i = 0; i < titleTV.length; i++){
            ParcelTV parcelTV = new ParcelTV();
            parcelTV.setTitle(titleTV[i]);
            parcelTV.setDesc(descTV[i]);
            parcelTV.setImage(imageTV.getResourceId(i, -1));
            parcelTV.setBanner(bannerTV.getResourceId(i, -1));
            tv.add(parcelTV);
        }
    }
    private void showIntentTVDetail(ParcelTV tv){
        Intent intent = new Intent(getActivity(), DetailTVShows.class);
        intent.putExtra(DetailTVShows.EXTRA_TV, tv);
        startActivity(intent);
    }
}
