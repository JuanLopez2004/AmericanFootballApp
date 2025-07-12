package edu.cs.niu.jlopez.americanfootball;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    private MediaPlayer americMP;
    private Button americBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        americBtn = findViewById(R.id.americButton);

        americMP = new MediaPlayer();
        americMP.reset();
        americMP = MediaPlayer.create(this, R.raw.nevermnt);

    } // end on create

    //method to handle clicking the drums button
    public void playFootball(View view)
    {
        //if the drums mp3 is playing
        if(americMP.isPlaying())
        {
            //pause the mp3 and change the label on the button
            americMP.pause();
            americBtn.setText(R.string.play_football);
        }
        else //drums mp3 is not playing
        {

            //start the drums mp3 and change the button label
            americMP.start();
            americBtn.setText(R.string.pause_football);
        }

    } //end play drums
}