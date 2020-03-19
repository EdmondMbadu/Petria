package com.example.chilldrenofpatria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ProgressBar progressBar;
    TextView textView;
    // the sqlite database
    DBHandler dbHandler;


    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dbHandler = new DBHandler(this, null);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // check if the database is empty.
//        because if it is not, then you have already been in the app before
        // therefore go right to the home activity
        if (!dbHandler.ISempty()) {
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }


        // if the database is empty, this is the time to create the tables
        dbHandler.addChapter(5, 2, "MainActivity", "");
        dbHandler.addChapter2(7, 2, "MainActivity", "");

        // we won't need this.
        // but for the moment, let's have it. to make sure that we do not create a new database everytime we addChapter
//        if(dbHandler.ISempty()) {
//            dbHandler.addChapter(5, 2, "MainActivity", "");
//            dbHandler2.addChapter(7, 2, "MainActivity", "");
//        }else{
//            dbHandler.updateChapter(1,5, 2, "MainActivity", "");
//        }

        // I don't know what this is for
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // This will be used to get the resource of the bar
        progressBar = findViewById(R.id.progress_bar);
        // This is to get the resource of the text view
        // We need it since it is updating ( from 0% to 100%)
        textView = findViewById(R.id.text_view);

        // the set  max for the percentage increases to reach 100 so that
        // the change grows relatively with the size of the bar

        // I suspect that one of these two methods calls the apply_transformation method in the Progress Bar Animation class
        progressBar.setMax(100);
        // the scale( I am not sure)
        progressBar.setScaleY(3f);

        progressAnimation();
    }

    // This method initiate  the animation in the loading page

    public void progressAnimation() {
        // create an instance of the class Progress Bar Animation and send the parameters to the constructor
        ProgressBarAnimation anim = new ProgressBarAnimation(this, progressBar, textView, 0f, 100f);
        // the animation duration is set to be for 8 seconds
        // I can add the number of seconds if needed
        anim.setDuration(8000);
        // Initiate the animation
        progressBar.setAnimation(anim);
    }
}
