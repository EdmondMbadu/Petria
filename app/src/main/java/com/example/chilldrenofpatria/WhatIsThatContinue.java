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

public class WhatIsThatContinue extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,dbHandler.getHealth(1)+2,dbHandler.getSpell(1),"WhatIsThatContinue","WhatIsThat");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_is_that_continue);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollWhatIsThatContinue);
        String text= "\t“Unfortunately, we don’t have the time to train you conventionally, becoming a wizard by reading books and practicing spells for months is not an option. We are going to have to cheat,” she says.\n" +
                "\t“What do you mean by cheat?” you ask.\n" +
                "\t“I’m going to give you a few gifts. Nothing too special, just enough so you get yourself immediately killed,” she says. \n" +
                "\tShe walks up to you and puts her hand on your face.\n" +
                "\t“The first gift is a kiss,” she says.\n" +
                "\tShe presses her lips against yours. You close your eyes and feel the soft warmth of her skin. The warmth grows until it rages. You open your eyes finding white light shining from your body spreading out from her lips. Emerald shines from her eyes as they open, and the light slowly begins to fade as she backs away from you. After a few moments of gazing at the fading white flowing from you skin, you look around. It seems brighter than before. In awe, you look at Noone. She smiles. Her smile make you feel like a child, and you look away.\n" +
                "\t“What I just gave you is complicated. Whenever you speak Celestial, you cast the spell associated with the words you speak,” she says.\n" +
                "\t“Celestial?” you ask.\n" +
                "\t“Yes, don’t worry, darling, you don’t actually have to speak it, you just have to memorize the sounds of each word. Now here, take this.” she says, giving you a black book. Its cover has no markings and doesn’t seem to be made of leather. It’s thin and nearly fits in your hand. You look at her, and she nods at the book. You open it to find thin blank pages, more then you expected.\n" +
                "\t“What is it made of?” you ask.\n" +
                "\t“It is made of no natural material,” she says. “It’s a magic book. It’s linked to this one.” she shows her own. You look at the book in her hand. It’s pure white but otherwise seems identical to yours.\n" +
                "\t“Anything I write in this book, you can see in yours, and likewise, if you write anything in your book I can see it in mine.” she says. “I’m going to write five spells in this book, three cantrips, and two first level spells.”\n" +
                "\tLooking down at the book in your hand, you run your finger across the cover and open it. The first page is blank. You turn to the second page and find symbols you’ve never seen before.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent

        Button buttonWhatIsThatContinue2= findViewById(R.id.button_whatIsThatContinue2);

        buttonWhatIsThatContinue2.setOnClickListener(this);


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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "WhatIsThatContinue");
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
            case R.id.button_whatIsThatContinue2:
                intent = new Intent(this, YesIDoContinue.class).putExtra("from", "WhatIsThatContinue");
                startActivity(intent);
                break;

        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned
        intent= new Intent(this, Book1Activity.class).putExtra("from", "WhatIsThatContinue");
        startActivity(intent);


    }

}
