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

public class StayInBed extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"StayInBed","HelpMeeNoone");
        sch1= new Chapter1Activity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_in_bed);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));

        TextView textView = (TextView) findViewById(R.id.text_scrollStayInBed);
        String text="You sit in your bed, frozen.\n" +
                "She looks at you.\n" +
                "“No. You’ve already decided. You can’t just sit there and hope everything goes away. I’m going to help you,” she says.\n" +
                "She snaps her fingers twice. Something pulls your blanket off you and begins folding it. Your legs are pulled to the side of the bed and placed to the floor. You sit up.\n" +
                "\t“What is this!” You ask.\n" +
                "\t“Now, now. There is no need to raise your voice. I’m simply helping you along,” she says. “Now, come on. This way.”\n" +
                "Your folded blanket sets itself neatly onto the foot of your bed.\n" +
                "You get out of bed and walk toward her. She smiles and walks through the puzzling door. You follow her through into a small room. The room has four smooth granite walls. The room has no windows, and the only door is the one closing behind you. It shuts, but makes no noise upon closing.\n" +
                "“Now that we have some privacy, we can talk properly,” she says.\n" +
                "“As you may have assumed, my name is Noone. Is it alright if I call you Ben or would you prefer your full name?” asks Noone. \n" +
                "“Um, Ben is fine. Could I call you Noone?” you ask.\n" +
                " “I suppose.” she smiles. “Now, on to the matter at hand. There are creatures that have wandered too close to Blackborough, and have been killing some of the people here.”\n" +
                "“You keep calling them creatures. Do they have names?” you ask.\n" +
                " “Yes, they do. Each one has their own name,” she answers. “In fact the three in your house are named, Delard, Madey, and Sheples. Madey is in you room looking for you now.”\n" +
                "You look at the shadow door.\n" +
                "“Don’t worry, he can’t see the door. He’s about to leave,” she says.\n" +
                "Her eyes seem to find yours and you realize you’re staring at her instead of the door. You blink and look at her ivory face but you find yourself coming back to her emerald eyes.\n" +
                "“More to your point, the common term for them is werejackal,” she says. “Unfortunately a large pack of them became displaced after an incident in one of the mountains to the south. They’ve been making sacrifices to their gods for guidance. Four days ago they started sacrificing humans in desperation.”\n" +
                "She gestures for you to sit. You turn around to find a wooden chair you don’t remember seeing. You sit down to find Noone sitting in a chair.\n" +
                "You sit as you’re told. You struggle to focus; you’re absorbed in her eyes.\n" +
                "“No. This won’t do at all,” she says.\n" +
                "The snap of her fingers echoes in your mind. You feel cold and scared. Shivers run across your body. You can think much clearer, but become more uneasy.\n" +
                "“I forget sometimes when I’m talking to a human how easily they can be enchanted. It’s foolish of me really; I spend too much time with immortals I suppose,” she says.\n" +
                "She looks at you. You don’t know what to do. Looking back at her, you feel melancholy.\n" +
                "“Before we start, do you have any questions?” she asks.\n";

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "StayInBed");
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

        intent= new Intent(this, Book1Activity.class).putExtra("from", "StayInBed");
        startActivity(intent);


    }

}
