package com.example.chilldrenofpatria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class HelpMeeNoone extends AppCompatActivity  implements View.OnClickListener {

    Chapter1Activity sch1;
    Intent intent;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"HelpMeeNoone","Meet_5");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_mee_noone);


        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));

        TextView textView = (TextView) findViewById(R.id.text_scrollHelpMeNoone);
        String text="“Help me, Noone,” you whisper.\n" +
                "The woman snaps her fingers. Something seems odd. “Now, if you would follow me, we could talk somewhere more private,” she says.\n" +
                "\tShe floats gently to the floor, standing at the foot of your bed. She turns and opens…\n" +
                "\t“Where did that door come from?” you ask.\n" +
                "\t“Follow me, darling,” she says.\n" +
                "\t“Ah. This is a dream!” you think, smiling.\n" +
                "\t“Not quite, but I can understand your confusion,” she says.\n" +
                "\t“Wait,” you hesitate. “I didn’t say that out loud.”\n" +
                "\t“No, you didn’t,” she says. She turns and gives you a smile. “Come along, this won’t last forever.”\n";


        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);



        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonFollowHer= findViewById(R.id.button_followHer);
        Button buttonStayInBed= findViewById(R.id.button_StayInBed);
        buttonFollowHer.setOnClickListener(this);
        buttonStayInBed.setOnClickListener(this);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book1, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.goback:
                intent= new Intent(this, Book1Activity.class).putExtra("from", "HelpMeeNoone");
                startActivity(intent);
                break;
            case R.id.action_startChapterOver:
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;
            case  R.id.action_lastCheckPoint:
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                intent= new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;
        }



        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.button_followHer:
                intent = new Intent(this, FollowHer.class);
                startActivity(intent);
                break;
            case R.id.button_StayInBed:
                intent = new Intent(this, StayInBed.class);
                startActivity(intent);
                break;
        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "HelpMeeNoone");
        startActivity(intent);


    }

}
