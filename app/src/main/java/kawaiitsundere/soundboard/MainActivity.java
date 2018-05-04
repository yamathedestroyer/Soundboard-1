package kawaiitsundere.soundboard;

import android.content.res.AssetFileDescriptor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

import kawaiitsundere.soundboard.audiostack.MediaPlayFramework;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Custom title font
        TextView titleText = (TextView) findViewById(R.id.titleText);
        Typeface ralewayFont = Typeface.createFromAsset(getAssets(), "fonts/raleway_medium.ttf");
        titleText.setTypeface(ralewayFont);


    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void playAudioTest(View view){
        // Test purposes for now
        MediaPlayFramework mpv = new MediaPlayFramework("testaudio.mp3", this);

        if (mpv.playback() == 0) {
            Log.e(this.getClass().getName(), "Playback failed");
        }
    }
}
