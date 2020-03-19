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

public class YesIDoContinue extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("YesIDo")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"YesIDoContinue","YesIDo");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("WhatIsThatContinue")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"YesIDoContinue","WhatIsThatContinue");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes_ido_continue);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollYesIDoContinue1);
        String text="“What does this say?” you ask.\n" +
                "\t“The first spell is commonly called dancing lights, its sounds like this tawlay gemmen. Now you try,” she says.\n" +
                "\t“Tawlay gemmen,” you say.\n" +
                "\tA glowing ball of white light appears from your mouth. You step back. The light is dim, yet it still entrances you. \n" +
                "\t“How?” you ask.\n" +
                "\tShe chuckles.\n" +
                "\t“Magic.” she says. You can do much more with that spell then you are doing now, but we’ve already taken too long. Let’s move on. The next spell can be translated as force bolt. Dole kakaw.”\n" +
                "\t“Dole kakaw,” you repeat.\n" +
                "\tA clear blue bolt streaks from your mouth. It hits the wall near Noone and the ball of light disappears.\n" +
                "\t“That spell is not like dancing lights. It could kill a man very easily,” she says. “Now for the last cantrip. This one is called invisible eye. Tt sounds like this hechet layquow.\n" +
                "\t“Hachet la.. la.” you struggle to say it.\n" +
                "\t“Let me write the spell names and the phonetic spelling down in your language inside the book,” she says.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        TextView textView2 = (TextView) findViewById(R.id.text_scrollYesIDoContinue2);
        String text2="You look in the book and find how to pronounce each spell. Without hesitation you try again, this time succeeding. “Hachet layquow.”\n" +
                "\tAt first you think you didn’t say it right, but when you look around the room, your vision gets confused. \n" +
                "\t“I can’t see right,” you say.\n" +
                "\t“Close your eyes,” she replies.\n" +
                "\tYou close your eyes, but you find you can still see Noone. Before you can ask, Noone speaks.\n" +
                "\t“This spell is tricky. It lets you see things from another perspective. It gives you another eye. You can move the eye around where ever you want as long as it doesn’t get too far away, and you can close the eye or get rid of it so you can use your normal eyes.”\n" +
                "\tShe snaps her figures and the invisible eye goes away. \n" +
                "\t“Finally, as you can see you have two first level spells. You only have the ability to cast two first level spells at the moment, so use these wisely. Reshega kakaw or force strike is a much stronger version of force bolt it is very dangerous. Cha or Shield on the other hand is a protective spell. Here cast force bolt at me,” she says\n";
        textView2.setText(sch1.Format(text2), TextView.BufferType.SPANNABLE);
        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonDoleKakaw= findViewById(R.id.button_DoleKakaw);
        Button buttonKillSomeone= findViewById(R.id.button_KillSomeone);


        buttonDoleKakaw.setOnClickListener(this);
        buttonKillSomeone.setOnClickListener(this);
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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "YesIDoContinue");
                startActivity(intent);
                break;
            case R.id.action_startChapterOver :
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
            case R.id.button_DoleKakaw:
                intent = new Intent(this, DoleKakaw.class).putExtra("from", "YesIDoContinue");;
                startActivity(intent);
                break;
            case R.id.button_KillSomeone:
                intent = new Intent(this, KillSomeone.class).putExtra("from", "YesIDoContinue");;
                startActivity(intent);
                break;
        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "YesIDoContinue");
        startActivity(intent);

    }

}
