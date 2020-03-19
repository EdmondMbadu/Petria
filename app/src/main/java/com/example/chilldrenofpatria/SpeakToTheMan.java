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

public class SpeakToTheMan extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("GoToSleep")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"SpeakToTheMan","GoToSleep");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLight")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"SpeakToTheMan","FollowTheLight");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("TryToDodge15132")) {
            dbHandler.updateChapter(1,7,dbHandler.getSpell(1),"SpeakToTheMan","TryToDodge15132");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak_to_the_man);

        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollSpeakToTheMan);
        String text = "“Please leave,” you say.\n" +
                "He looks at you for some time.\n" +
                "Finally, he walks to you slowly. He swings his fist at you.\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonReactWithShield = findViewById(R.id.button_ReactWithShield);
        Button buttontryToDodge = findViewById(R.id.button_TrytoDodge);


        // when the button is clicked
        buttonReactWithShield.setOnClickListener(this);
        buttontryToDodge.setOnClickListener(this);
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
                intent = new Intent(this, Book1Activity.class).putExtra("from", "SpeakToTheMan");
                startActivity(intent);
                break;
            case R.id.action_startChapterOver:
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;
            case R.id.action_lastCheckPoint:
                intent= new Intent(this, DoleKakawContinue.class);
                startActivity(intent);
                break;
        }


        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.button_ReactWithShield:
                if (sch1.spellSlot <= 0) {

                    Toast.makeText(this, "You do not have enough spell slot!", Toast.LENGTH_SHORT).show();

                } else {
                    //        15.1.3.1
                    Toast.makeText(this, "You have lost a spell slot!", Toast.LENGTH_SHORT).show();
                    dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1)-1,"SpeakToTheMan",dbHandler.getBeforeLast(1));
                    intent = new Intent(this, ReachWithShield15131.class);
                    startActivity(intent);
                }
                break;
            case R.id.button_TrytoDodge:


                Toast.makeText(this, "You have lost 7 health!", Toast.LENGTH_SHORT).show();
                //15.1.3.2
                dbHandler.updateChapter(1,dbHandler.getHealth(1)-7,dbHandler.getSpell(1),"SpeakToTheMan",dbHandler.getBeforeLast(1));
                intent = new Intent(this, TryToDodge15132.class);
                startActivity(intent);
                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "SpeakToTheMan");
        startActivity(intent);

    }

}
