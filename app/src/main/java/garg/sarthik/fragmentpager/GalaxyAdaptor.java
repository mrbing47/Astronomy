package garg.sarthik.fragmentpager;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GalaxyAdaptor extends RecyclerView.Adapter<GalaxyAdaptor.ViewHolder> {

    private ArrayList<GalaxyDetails> galaxyDetails;
    private Context ctx;

    public GalaxyAdaptor(ArrayList<GalaxyDetails> galaxyDetails, Context ctx) {
        this.galaxyDetails = galaxyDetails;
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

        final GalaxyDetails gd = galaxyDetails.get(position);
        holder.tvNamelist.setText(gd.getName());
        Picasso.get()
                .load(gd.getImageURL())
                .placeholder(R.drawable.ic_wallpaper)
                .resize(250,250)
                .error(R.drawable.ic_error)
                .into(holder.ivImagelist);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int orientation = ctx.getResources().getConfiguration().orientation;
                if(orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    MainActivity ma = (MainActivity)ctx;
                    ma.addIntent(gd);

                }
                else
                {
                    if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        MainActivity ma = (MainActivity) ctx;
                        ma.getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.containerDetail, new Frag_Detail(gd))
                                .commit();
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return galaxyDetails.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        ImageView ivImagelist;
        TextView tvNamelist;

        public ViewHolder(View itemView) {
            super(itemView);

            ivImagelist = itemView.findViewById(R.id.ivlistImage);
            tvNamelist = itemView.findViewById(R.id.tvListName);
        }
    }


}
