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
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class CastDancingLightsContinue extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        if (dbHandler.getLastClass(1).equalsIgnoreCase("CastDancingLights")) {
            dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1), "CastDancingLightsContinue", "CastDancingLights");
        } else if (dbHandler.getLastClass(1).equalsIgnoreCase("StayInTheCover")) {
            dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1), "CastDancingLightsContinue", "StayInTheCover");
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_dancing_lights_continue);

        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: " + dbHandler.getHealth(1) + " Spell Slots: " + dbHandler.getSpell(1) + "<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollCastDancingLightsContinue);
        String text = "“I guess there’s nothing else to do,” you think.\n" +
                "\tThe flames looks ghostly dancing on the tree tops above you. Every step you take toward the fire your heart beats faster.\n" +
                "\t“What am I even supposed to do?” you think.\n" +
                "\tNoone instructed you to simply scare them and then they would scatter. If you use nearly any magic it should frighten them out of there ceremony. You just hope they haven’t killed anyone yet.\n" +
                "\tYou notice figures around the fire. They’re chanting in a thick, guttural language you’ve never heard. It sounds inhuman. From behind a tree, you can see maybe fifteen of them. They are dancing around the fire. Some of them are humans, there are some jackals, but there are also other things. An uneasy mixture of the two.\n" +
                "You see four unconscious people lying on the ground around the fire.\n" +
                "\t“Noone said they could only put people to sleep for a few minutes. They must have done something else to them.” You think.\n" +
                "\tYou see one of the half jackals pick up one of the people lying on the ground. \n" +
                "\t“I have to do it now. What should I do?”\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);



        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonF = findViewById(R.id.button_ForceBolt201);
        Button buttonStr = findViewById(R.id.button_ForceStrike202);
        Button buttonDancing = findViewById(R.id.button_DancingLights);


        // when the button is clicked

        buttonF.setOnClickListener(this);
        buttonDancing.setOnClickListener(this);
        buttonStr.setOnClickListener(this);


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
        switch (item.getItemId()) {
            case R.id.goback:
                intent = new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;
            case R.id.action_startChapterOver:
                intent = new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1, 5, 2, "Book1Activity", "HomeActivity");
                startActivity(intent);
                break;
            case R.id.action_lastCheckPoint:
                intent = new Intent(this, FollowTheLight1611Continue.class);
                startActivity(intent);
                break;
        }


        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.button_ForceBolt201:
                intent = new Intent(this, ForceBolt201.class);
                startActivity(intent);
                break;
            case R.id.button_ForceStrike202:
                if (dbHandler.getSpell(1) <= 0) {
                    Toast.makeText(this, "You do not have enough spell slot!", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(this, "You have lost 1 spell slot!", Toast.LENGTH_SHORT).show();

                    dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1) - 1, "CastDancingLightsContinue", dbHandler.getBeforeLast(1));
                    intent = new Intent(this, ForceStrike202.class);
                    startActivity(intent);
                }
                break;

            case R.id.button_DancingLights:
                intent = new Intent(this, DancingLights.class);
                startActivity(intent);
                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "CastDancingLightsContinue");
        startActivity(intent);

    }

}
