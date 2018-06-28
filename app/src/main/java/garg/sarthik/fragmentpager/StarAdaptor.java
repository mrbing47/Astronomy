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

public class StarAdaptor extends RecyclerView.Adapter<StarAdaptor.ViewHolder> {

    private ArrayList<StarDetails> starDetails;
    private Context ctx;

    public StarAdaptor(ArrayList<StarDetails> starDetails, Context ctx) {
        this.starDetails = starDetails;
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
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final StarDetails sd = starDetails.get(position);
        holder.tvNamelist.setText(sd.getName());
        Picasso.get()
                .load(sd.getImageURL())
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
                    ma.addIntent(sd);

                }
                else
                {
                    if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
                        MainActivity ma = (MainActivity) ctx;
                        ma.getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.containerDetail, new Frag_Detail(sd))
                                .commit();
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return starDetails.size();
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
