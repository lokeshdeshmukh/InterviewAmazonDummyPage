package info.androidhive.retrofit.activity;

import android.content.DialogInterface;
import android.media.MediaFormat;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import info.androidhive.retrofit.R;

public class PlayVideo extends AppCompatActivity  {


    VideoView myVideoView;
    ArrayList<String> resolutions;
    ArrayList<String> resolutions_label;
    MediaController mc = null;
    String videoId="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.videoplayer);
        videoId=getIntent().getStringExtra("videoId");
        resolutions=getIntent().getStringArrayListExtra("resolutions");
        resolutions_label=getIntent().getStringArrayListExtra("resolutions_label");
        playVideo();

    }
    public void  playVideo() {

        myVideoView = (VideoView)findViewById(R.id.videoPlayer);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mc = new MediaController(this);
        }
        myVideoView.setMediaController(mc);
        String urlStream = "https://s3.ap-south-1.amazonaws.com/gemplex-videos/transcoder/assets/"+videoId+"/HLS/master.m3u8";
        myVideoView.setVideoURI(Uri.parse(urlStream));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            myVideoView.addSubtitleSource(getSubtitleSource(""), MediaFormat.createSubtitleFormat("text/vtt", Locale.ENGLISH.getLanguage()));
        }

        myVideoView.start();

    }



    private InputStream getSubtitleSource(String filepath) {
        InputStream ins = null;
        ins =  getResources().openRawResource(
                getResources().getIdentifier("sample",
                        "raw", getPackageName()));
        return ins;
    }
    public void changeResolution(View view) {
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
        builderSingle.setTitle("Select Resolution");

        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice);
        arrayAdapter.addAll(resolutions_label);


        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                int currentposition=myVideoView.getCurrentPosition();
            myVideoView.setVideoURI(Uri.parse("https://s3.ap-south-1.amazonaws.com/gemplex-videos/transcoder/assets/"+videoId+"/HLS/"+resolutions.get(which)+".m3u8"));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    myVideoView.addSubtitleSource(getSubtitleSource(""), MediaFormat.createSubtitleFormat("text/vtt", Locale.ENGLISH.getLanguage()));
                }

                myVideoView.start();
                myVideoView.seekTo(currentposition);
            }
        });
        builderSingle.show();
    }
}
