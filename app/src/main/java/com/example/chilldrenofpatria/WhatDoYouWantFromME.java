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

public class WhatDoYouWantFromME extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("StayInBed")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"WhatDoYouWantFromME","StayInBed");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowHer")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"WhatDoYouWantFromME","FollowHer");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_do_you_want_from_me);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));

        TextView textView = (TextView) findViewById(R.id.text_scrollWhatDoYouWantFromMe);
        String text="“What do you want from me?” You ask.\n" +
                "She smiles.\n" +
                "“Oh, darling, I want the world from you. I’ll settle for some consideration when we’re done,” she says. “This will all be free of charge, no bargains or favors, but I would like to have a discussion with you after this is all over. If that’s not too much to ask.”\n" +
                "“I guess not,” you reply.\n" +
                "“Good. Then there’s no reason to wait. Let us get started.”\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonWhatDoYouWantFromMeContinue= findViewById(R.id.button_whatDoYouWantFromMeContinue);

        buttonWhatDoYouWantFromMeContinue.setOnClickListener(this);


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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "WhatDoYouWantFromME");
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
            case R.id.button_whatDoYouWantFromMeContinue:
                intent = new Intent(this, WhoAreYouContinue.class);
                startActivity(intent);
                break;

        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "WhatDoYouWantFromME");
        startActivity(intent);


    }

}
