package androidyoutubeexample.ranjeet.android.com.androidyoutubeexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener,View.OnClickListener {

    private static final int RECOVERY_DIALOG_REQUEST = 1;

    // YouTube player view
    private YouTubePlayerView youTubeView;
    String videoId="qUHc8isBxC8";
    ImageView youtube_image;
    TextView youtube_title;
    ArrayList<YoutubeVideo> arrlist=new ArrayList<YoutubeVideo>();
    Button youtube_next;
    int count=0;
    //your class level attribute to keep reference of player
    YouTubePlayer mYoutubePlayer;
    String videoArr[]={"qUHc8isBxC8","Jk9nh7f5dGs","xFK5RtJZIZc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        youTubeView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        youtube_image = (ImageView) findViewById(R.id.youtube_image);
        youtube_title = (TextView) findViewById(R.id.youtube_title);
        youtube_next= (Button) findViewById(R.id.youtube_next);
        youtube_next.setOnClickListener(this);
        // Initializing video player with developer key
        youTubeView.initialize(Config.YoutubeKey, this);



    }
    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            mYoutubePlayer = player;
            // loadVideo() will auto play video
            // Use cueVideo() method, if you don't want to play it automatically
            mYoutubePlayer.loadVideo(videoId);//Config.YOUTUBE_VIDEO_CODE
//Save reference of initialized player in class level attribute
            // Hiding player controls
            mYoutubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(Config.YoutubeKey, this);
        }
    }

    private YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }



    @Override
    public void onClick(View v) {

        if(v==youtube_next)
        {
            if(count<2)
            {

                videoId= videoArr[count];
                mYoutubePlayer.loadVideo(videoId);//Config.YOUTUBE_VIDEO_CODE
               // getVideoID(arrlist.get(count).title,arrlist.get(count).url);
                count++;
                youtube_next.setText("Next Video");

            }
            else
            {
                youtube_next.setText("Thank you");
                count=0;
            }
        }
    }
}
