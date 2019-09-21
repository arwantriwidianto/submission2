package com.example.filmapp.tv;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.filmapp.R;

public class DetailTVShows extends AppCompatActivity {

    public static final String EXTRA_TV = "extra_tv";
    private ImageView imgTVBannerDetail, imgTVDetail;
    private TextView detailTitleTV, detailDescTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tvshows);

        imgTVBannerDetail = findViewById(R.id.img_banner_tv);
        imgTVDetail = findViewById(R.id.img_detail_tv);
        detailTitleTV = findViewById(R.id.detail_title_tv);
        detailDescTV = findViewById(R.id.detail_desc_tv);

        showTVDetail();
    }

    private void showTVDetail(){
        ParcelTV parcelTV = getIntent().getParcelableExtra(EXTRA_TV);
        if (parcelTV != null && getSupportActionBar() != null){

            getSupportActionBar().setTitle(parcelTV.getTitle());
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            detailTitleTV.setText(parcelTV.getTitle());
            detailDescTV.setText(parcelTV.getDesc());

            Glide.with(this)
                    .load(parcelTV.getImage())
                    .into(imgTVDetail);
            Glide.with(this)
                    .load(parcelTV.getBanner())
                    .into(imgTVBannerDetail);
        }
    }
}
