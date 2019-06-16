package info.androidhive.retrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import info.androidhive.retrofit.Interface.IPlayVideo;
import info.androidhive.retrofit.R;
import info.androidhive.retrofit.Utils.Utils;
import info.androidhive.retrofit.activity.MainActivity;
import info.androidhive.retrofit.model.pojo.content_manager;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> implements View.OnClickListener {

    private List<content_manager> movies;
    private int rowLayout;
    private Context context;
    private MainActivity instance;



    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView movieDescription;
        LinearLayout subItem;
        TextView sub_item_Description;
        ImageButton playButton;
        TextView releaseDateDesc;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.movies_layout);
            movieTitle = (TextView) v.findViewById(R.id.title);
            movieDescription = (TextView) v.findViewById(R.id.description);
            subItem = (LinearLayout) v.findViewById(R.id.sub_item);
            sub_item_Description = (TextView) v.findViewById(R.id.sub_item_Description);
            playButton = (ImageButton) v.findViewById(R.id.playButton);
            releaseDateDesc = (TextView) v.findViewById(R.id.releaseDateDesc);
        }
    }

    public MoviesAdapter(List<content_manager> movies, int rowLayout, Context context, MainActivity instance) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
        this.instance = instance;

    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.movieDescription.setText(movies.get(position).getShort_desciption());
        holder.sub_item_Description.setText(movies.get(position).getShort_desciption());
        holder.releaseDateDesc.setText("Aired: "+ Utils.formatDate(movies.get(position).getSchedule_date_time()));
        boolean expanded = movies.get(position).isExpanded();
        // Set the visibility based on state
        holder.subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean expanded = movies.get(position).isExpanded();
                // Change the state
                movies.get(position).setExpanded(!expanded);
                // Notify the adapter that item has changed
                notifyItemChanged(position);


            }
        });  // Get the current state of the item


        holder.playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IPlayVideo temp = instance;
                temp.playVideo(movies.get(position).getMedia_manager_id(),position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public void onClick(View v) {


    }

}