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

public class ForceBotCantrip extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("GoToSleep")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"ForceBotCantrip","GoToSleep");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLight")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"ForceBotCantrip","FollowTheLight");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("ReachWithShield15131")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"ForceBotCantrip","ReachWithShield15131");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_bot_cantrip);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollForcebotCanTrip);
        String text="“Dole Kakaw.”\n" +
                "Energy beams toward the man striking him in the chest. He staggers back, then looks at you, his eyes fixed on yours.\n" +
                "“He must be trying to put me to sleep,” you think.\n" +
                "He shows his teeth, then charges at you.\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonForceBolt= findViewById(R.id.button_forceBolt);
        Button buttonForceStrike= findViewById(R.id.button_ForceStrike);



        // when the button is clicked
        buttonForceBolt.setOnClickListener(this);
        buttonForceStrike.setOnClickListener(this);
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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "ForceBotCantrip");
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


        switch (view.getId()){
            case R.id.button_forceBolt:
                intent = new Intent(this, ForceBolt.class);
                startActivity(intent);
                break;
            case R.id.button_ForceStrike:
//                dbHandler.getSpell(1)
                if(dbHandler.getSpell(1)<=0){
                    Toast.makeText(this, "You do not have enough spell slot!", Toast.LENGTH_SHORT).show();
                }else {
                    //sch1.setSpellSlot(sch1.getSpellSlot()-1);

//                    if(dbHandler.getBeforeLast(1).equalsIgnoreCase("GoToSleep")) {
//                        Toast.makeText(this, "You have lost 1 spell slot!", Toast.LENGTH_SHORT).show();
//                        dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1)-1,"ForceBotCantrip","GoToSleep");
//                    }
//                    else if(dbHandler.getBeforeLast(1).equalsIgnoreCase("FollowTheLight")) {
//                        Toast.makeText(this, "You have lost 1 spell slot!", Toast.LENGTH_SHORT).show();
//                        dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1)-1,"ForceBotCantrip","FollowTheLight");
//
//                    }

                    Toast.makeText(this, "You have lost 1 spell slot!", Toast.LENGTH_SHORT).show();
                    dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1)-1,"ForceBotCantrip",dbHandler.getBeforeLast(1));

                    // the class is not yet implemented
                    intent = new Intent(this, ForceStrike2.class);
                    startActivity(intent);
                }
                break;




        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "ForceBotCantrip");
        startActivity(intent);

    }

}
