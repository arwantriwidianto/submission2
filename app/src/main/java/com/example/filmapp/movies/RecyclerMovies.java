package com.example.filmapp.movies;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.filmapp.R;

import java.util.ArrayList;

public class RecyclerMovies extends RecyclerView.Adapter<RecyclerMovies.ListViewHolder>  {

    private RecyclerMovies.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private ArrayList<ParcelMovies> listMovies;

    public RecyclerMovies(ArrayList<ParcelMovies> list){
        this.listMovies = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_movies, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        holder.bindMovies(listMovies.get(position));
    }

    @Override
    public int getItemCount() {
        return listMovies.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMovies;
        private TextView titleMovies, descMovies;

        public ListViewHolder(View itemView) {
            super(itemView);
            imgMovies = itemView.findViewById(R.id.image_movies);
            titleMovies = itemView.findViewById(R.id.title_movies);
            descMovies = itemView.findViewById(R.id.desc_movies);
        }
        void bindMovies (final ParcelMovies parcelMovies){
            titleMovies.setText(parcelMovies.getTitle());
            descMovies.setText(parcelMovies.getDesc());
            Glide.with(itemView.getContext())
                    .load(parcelMovies.getImage())
                    .into(imgMovies);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickCallback.onItemClicked(listMovies.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(ParcelMovies moviesData);
    }
}
