package com.example.filmapp.tv;

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

public class RecyclerTV extends RecyclerView.Adapter<RecyclerTV.ListViewHolder> {

    private RecyclerTV.OnItemClickCallback onItemClickCallback;
    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    private ArrayList<ParcelTV> listTV;

    public RecyclerTV(ArrayList<ParcelTV> list){
        this.listTV = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tv, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        holder.bindMovies(listTV.get(position));
    }

    @Override
    public int getItemCount() {
        return listTV.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgTV;
        private TextView titleTV, descTV;

        public ListViewHolder(View itemView) {
            super(itemView);
            imgTV = itemView.findViewById(R.id.image_tv);
            titleTV = itemView.findViewById(R.id.title_tv);
            descTV = itemView.findViewById(R.id.desc_tv);
        }
        void bindMovies (final ParcelTV parcelTV){
            titleTV.setText(parcelTV.getTitle());
            descTV.setText(parcelTV.getDesc());
            Glide.with(itemView.getContext())
                    .load(parcelTV.getImage())
                    .into(imgTV);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickCallback.onItemClicked(listTV.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(ParcelTV tvData);
    }
}
