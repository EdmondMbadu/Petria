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

public class FollowHer extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowHer","HelpMeeNoone");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_her);
        sch1= new Chapter1Activity();


        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));

        TextView textView = (TextView) findViewById(R.id.text_scrollFollowHer);
        String text="You get out of bed and walk toward her. She smiles and walks through the puzzling door. You follow her through into a small room. The room has four smooth granite walls. The room has no windows, and the only door is the one closing behind you. Its shuts, but makes no noise upon closing.\n" +
                "“Now that we have some privacy we can talk properly,” she says. “As you may have assumed my name is Noone. Is it alright if I call you Ben or would you prefer your full name?” Asks Noone. \n" +
                "“Uh, Ben is fine. Could I call you Noone?” You ask.\n" +
                " “I suppose,” she smiles. “Now. On to the matter at hand. There are creatures that have wandered too close to Blackborough, and have been killing some of the people here.”\n" +
                "“You keep calling them creatures. Do they have names?” You ask.\n" +
                "She smiles.\n" +
                "“Yes, they do. Each one has their own name.” says Noone. “In fact the three in your house are named, Delard, Madey, and Sheples. Madey is in you room looking for you now.”\n" +
                "You look at the shadow door.\n" +
                "“Don’t worry he can’t see the door. He’s about to leave,” she says.\n" +
                "Her eyes seem to find yours and you realize you’re staring at her instead of the door. You blink and look at her ivory face but you find yourself coming back to her emerald eyes.\n" +
                "“More to your point, the common term for them is werejackal.” She says. “Unfortunately,  a large pack of them became displaced after an incident in one of the mountains to the west. They’ve been making sacrifices to their gods for guidance. Four days ago in desperation they started sacrificing humans.”\n" +
                "She gestures for you to sit. You turn around to find a wooden chair you don’t remember seeing. You sit down to find Noone sitting in a chair.\n" +
                "You sit as you’re told. You struggle to focus; you’re absorbed in her eyes.\n" +
                "“No. This won’t do at all.” She says.\n" +
                "The snap of her fingers echoes in your mind. You feel cold, and scared. Shivers run across your body. You can think much clearer, and become more uneasy.\n" +
                "“I forget sometimes when I’m talking to a human how easily they can be enchanted. It’s foolish of me really; I spend too much time with immortals I suppose,” she says.\n" +
                "She looks at you. You don’t know what to do. Looking back at her, you feel melancholy.\n" +
                "“Before we start, do you have any questions?” Noone asks.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonWhoAreYou= findViewById(R.id.button_whoAreYou);
        Button buttonWhyAreYouHelping= findViewById(R.id.button_whyAreYouHelping);
        Button buttonWhatDoYouWantFromMe= findViewById(R.id.button_whatDoYouWantFromMe);
        Button buttonNo= findViewById(R.id.button_No);

        buttonWhoAreYou.setOnClickListener(this);
        buttonWhyAreYouHelping.setOnClickListener(this);
        buttonWhatDoYouWantFromMe.setOnClickListener(this);
        buttonNo.setOnClickListener(this);

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "FollowHer");
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
            case R.id.button_whoAreYou:
                intent = new Intent(this, WhoAreYou.class);
                startActivity(intent);
                break;
            case R.id.button_whyAreYouHelping:
                intent = new Intent(this, WhyAreYouHelping.class);
                startActivity(intent);
                break;
            case R.id.button_whatDoYouWantFromMe:
                intent = new Intent(this, WhatDoYouWantFromME.class);
                startActivity(intent);
                break;
            case R.id.button_No:
                intent = new Intent(this, NO.class);
                startActivity(intent);
                break;
        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "FollowHer");
        startActivity(intent);


    }

}
