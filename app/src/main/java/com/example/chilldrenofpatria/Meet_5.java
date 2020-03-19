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

public class Meet_5 extends AppCompatActivity  implements View.OnClickListener {

    Chapter1Activity sch1;
    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        // since Meet_5 is an intersection, check where it came from
        // and then decide where to go
        if(dbHandler.getLastClass(1).equalsIgnoreCase("StayAndWatchBakeryContinue")) {
            dbHandler.updateChapter(1,5,2,"Meet_5","StayAndWatchBakeryContinue");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("GoToTownHallContinue")) {
            dbHandler.updateChapter(1,5,2,"Meet_5","GoToTownHallContinue");
        }


        sch1= new Chapter1Activity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meet_5);
        TextView textViewChapter1=findViewById(R.id.toolbar_textview); // this will be not used as of now
//        textViewChapter1.setText("Chapter 1");
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));
        TextView textView = (TextView) findViewById(R.id.text_scrollMeet_5);
        String text="You wake up in the night.\n" +
                "“Did I hear something break?” you think. \n" +
                "You sit up in your bed. The stairs creak.\n" +
                "“Someone is coming up the stairs. It’s probably just David walking back to bed.” You think.\n" +
                "You lay your head back down, but as you look up at the ceiling, you see something you don’t understand. Hovering above you is a pale woman with curly black hair, draped in a thin white cloak. You lay in bed frozen, staring at her emerald eyes.\n" +
                "She drifts closer to you and says in a whisper, “There are four things that snuck into this house tonight. Three will kill you, but the fourth is willing to help”\n" +
                "“What?” you reply.\n" +
                "“The things that kidnapped your mother’s friend are here to take your mother, and your father, and you,” she says.\n" +
                "You hear the door to your parents’ bedroom open. Your eyes flash between your door and the floating woman.\n" +
                "“What do you mean?” you ask.\n" +
                "“Unless you do something, your parents are going to be kidnapped, and probably so will you. They will not be held for ransom,” she says thoughtfully. “It’s not that kind of kidnapping.”\n" +
                "“What am I supposed to do?” you ask.\n" +
                "You hear things falling over in your parents’ room.\n" +
                "“Ask me for help. Now” she says.\n" +
                "“What?” you cry.\n" +
                "“Say, help me, Noone,” she says.\n" +
                "You think for a moment, “What should I do?”\n";


        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);
        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonHelpMe= findViewById(R.id.button_HelpMeNoone);
        Button buttonRunOut= findViewById(R.id.button_RunOutSee);
        Button buttonDoNothing=findViewById(R.id.button_DoNothing);

        buttonHelpMe.setOnClickListener(this);
        buttonRunOut.setOnClickListener(this);
        buttonDoNothing.setOnClickListener(this);

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "Meet_5");
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
            case R.id.button_HelpMeNoone:
                intent = new Intent(this, HelpMeeNoone.class);
                startActivity(intent);
                break;
            case R.id.button_RunOutSee:
                intent = new Intent(this, RunOutAndSee.class);
                startActivity(intent);
                break;
            case R.id.button_DoNothing:
                intent = new Intent(this,DoNothing.class );
                startActivity(intent);
                break;
        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "Meet_5");
        startActivity(intent);


    }

}
