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

import info.androidhive.retrofit.R;
import info.androidhive.retrofit.activity.MainActivity;
import info.androidhive.retrofit.model.pojo.trailers_teaser;

public class TrailerTeaserAdapter extends RecyclerView.Adapter<TrailerTeaserAdapter.MovieViewHolder> implements View.OnClickListener {

    private List<trailers_teaser> movies;
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

    public TrailerTeaserAdapter(List<trailers_teaser> movies, int rowLayout, Context context, MainActivity instance) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
        this.instance = instance;

    }

    @Override
    public TrailerTeaserAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                                   int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.movieDescription.setText(movies.get(position).getShortDescription());
        holder.subItem.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    @Override
    public void onClick(View v) {


    }

}