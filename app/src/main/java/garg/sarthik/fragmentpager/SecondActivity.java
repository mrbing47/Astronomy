package garg.sarthik.fragmentpager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvDetail;
    ImageView ivImage;
    FloatingActionButton fab;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_detail);

        Bundle bundle =  getIntent().getExtras();
        String name = bundle.getString("Name");
        String detail = bundle.getString("Detail");
        String imageURL = bundle.getString("ImageURL");
        final String moreURL = bundle.getString("MoreURL");

        tvName = findViewById(R.id.tvName);
        tvDetail = findViewById(R.id.tvDetail);
        ivImage = findViewById(R.id.ivImage);
        fab = findViewById(R.id.fabWiki);

        tvName.setTextSize(40);
        tvName.setText(name);
        tvDetail.setText(detail);
        Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.ic_wallpaper)
                .resize(500,500)
                .error(R.drawable.ic_error)
                .into(ivImage);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(moreURL));
                startActivity(intent);
            }
        });

    }
}
