package garg.sarthik.fragmentpager;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Frag_Detail extends Fragment {

    private Object object;
    TextView tvName;
    TextView tvDetails;
    ImageView ivStar;
    FloatingActionButton fab;
    private String name;
    private String detail;
    private String imageURL;
    private String moreURL;

    public Frag_Detail(Object object) {
        this.object = object;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_detail, container, false);

        if(object instanceof PlanetDetails)
        {
            PlanetDetails pd = (PlanetDetails)object;
            name = pd.getName();
            detail = pd.getDetails();
            imageURL = pd.getImageURL();
            moreURL = pd.getMoreURL();

        }
        else{
            if(object instanceof StarDetails){

                StarDetails sd = (StarDetails)object;
                name = sd.getName();
                detail = sd.getDetails();
                imageURL = sd.getImageURL();
                moreURL = sd.getMoreURL();
            }
            else{
                if(object instanceof GalaxyDetails)
                {
                    GalaxyDetails gd = (GalaxyDetails)object;
                    name = gd.getName();
                    detail = gd.getDetails();
                    imageURL = gd.getImageURL();
                    moreURL = gd.getMoreURL();
                }
            }
        }

        tvName = view.findViewById(R.id.tvName);
        tvName.setMovementMethod(new ScrollingMovementMethod());
        tvDetails = view.findViewById(R.id.tvDetail);
        ivStar = view.findViewById(R.id.ivImage);
        fab = view.findViewById(R.id.fabWiki);

        tvName.setText(name);
        tvDetails.setText(detail);

        Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.ic_wallpaper)
                .resize(500, 500)
                .error(R.drawable.ic_error)
                .into(ivStar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setData(Uri.parse(moreURL));
                startActivity(i);
            }
        });

        return view;
    }

  /*  @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {

            MainActivity ma = (MainActivity)getActivity();
            ma.addIntent(object);
        }
    }*/

}
