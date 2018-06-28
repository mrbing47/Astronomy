package garg.sarthik.fragmentpager;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

public class PlanetAdaptor extends RecyclerView.Adapter<PlanetAdaptor.ViewHolder> {

    private ArrayList<PlanetDetails> planetDetails;
    private Context ctx;

    public PlanetAdaptor(ArrayList<PlanetDetails> planetDetailsArrayList, Context ctx) {
        this.planetDetails = planetDetailsArrayList;
        this.ctx = ctx;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li = LayoutInflater.from(ctx);
        View view = li.inflate(R.layout.layout_itemlist,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        final PlanetDetails pd = planetDetails.get(position);

        holder.tvNamelist.setText(pd.getName());
        Picasso.get()
                .load(pd.getImageURL())
                .placeholder(R.drawable.ic_wallpaper)
                .error(R.drawable.ic_error)
                .resize(250,250)
                .into(holder.ivImagelist);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int orientation = ctx.getResources().getConfiguration().orientation;
                MainActivity ma = (MainActivity)ctx;

                if(orientation == Configuration.ORIENTATION_PORTRAIT)
                     ma.addIntent(pd);
               else
                {
                    if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        ma.getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.containerDetail, new Frag_Detail(pd))
                                .commit();
                    }
                }
            }
        });
      }

    @Override
    public int getItemCount() {
        return planetDetails.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvNamelist;
        ImageView ivImagelist;

        public ViewHolder(View itemView) {
            super(itemView);

            tvNamelist = itemView.findViewById(R.id.tvListName);
            ivImagelist = itemView.findViewById(R.id.ivlistImage);
        }
    }
}
