package info.androidhive.retrofit.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import info.androidhive.retrofit.Interface.IPlayVideo;
import info.androidhive.retrofit.R;
import info.androidhive.retrofit.adapter.MoviesAdapter;
import info.androidhive.retrofit.adapter.TrailerTeaserAdapter;
import info.androidhive.retrofit.databinding.ActivityMainBinding;
import info.androidhive.retrofit.model.ViewModel.MainActivityViewModel;
import info.androidhive.retrofit.model.pojo.DataObject;

public class MainActivity extends AppCompatActivity implements IPlayVideo {

    private static final String TAG = MainActivity.class.getSimpleName();
    MainActivityViewModel model;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setActivity(this);
        DataObject obj = new DataObject();
        binding.setDataObject(obj);
        binding.setLifecycleOwner(this);

        recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        model = ViewModelProviders.of(this).get(MainActivityViewModel.class);

        model.getMainResponse().observe(this, fruitlist -> {
            // update UI
            binding.setDataObject(fruitlist);
            recyclerView.setAdapter(new MoviesAdapter(fruitlist.getContent_manager(), R.layout.list_item_movie, getApplicationContext(), MainActivity.this));

        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    public void  playVideo(String videoId,int position) {

        Intent playvideo = new Intent(this,PlayVideo.class);
        playvideo.putExtra("videoId",videoId);
        playvideo.putExtra("resolutions",model.getMainResponse().getValue().getContent_manager().get(position).getVideoTranscodeProfiles().getVbrvariable().getResolutions());
        playvideo.putExtra("resolutions_label",model.getMainResponse().getValue().getContent_manager().get(position).getVideoTranscodeProfiles().getVbrvariable().getResolutions_name());

        startActivity(playvideo);
    }
    public void episodeClick(View v)
    {
        findViewById(R.id.button2Highlighter).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.button1Highlighter).setBackgroundColor(Color.WHITE);
        recyclerView.setAdapter(new MoviesAdapter(model.getMainResponse().getValue().getContent_manager(), R.layout.list_item_movie, getApplicationContext(), MainActivity.this));

    }
    public void moredetailsClick(View v)
    {
        findViewById(R.id.button1Highlighter).setBackgroundColor(Color.TRANSPARENT);
        findViewById(R.id.button2Highlighter).setBackgroundColor(Color.WHITE);
        recyclerView.setAdapter(new TrailerTeaserAdapter(model.getMainResponse().getValue().getTrailers_teaser(), R.layout.list_item_movie, getApplicationContext(), MainActivity.this));

    }
}
