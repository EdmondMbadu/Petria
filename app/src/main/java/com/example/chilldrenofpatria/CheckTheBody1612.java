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

public class CheckTheBody1612 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceStrike2")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"CheckTheBody1612","ForceStrike2");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("forceStrikeBolt")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"CheckTheBody1612","forceStrikeBolt");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt6")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"CheckTheBody1612","ForceBolt6");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceStrike9")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"CheckTheBody1612","ForceStrike9");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt8")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"CheckTheBody1612","ForceBolt8");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_the_body1612);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollCheckTheBody1612);
        String text="You look over his body hoping to find something of use. The sword laying of the floor catches your eye, but you could never do as much damage with the sword as you could with force bolt alone. He doesn’t have anything else on him, no coin pouch, nothing. It seems a little odd, but then again not much tonight has been ordinary.\n" +
                "\tYou look at the light in the doorway. Slowly you take a breath. You look at the ball of light and begin to walk toward it. You get just close enough to touch it, and it begins moving away from you. Down the stairway to the first floor, you follow the light. It takes you out into the town square.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonCheckTheBody= findViewById(R.id.button_CheckTheBody1612Continue);




        // when the button is clicked
        buttonCheckTheBody.setOnClickListener(this);

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "CheckTheBody1612");
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
            case R.id.button_CheckTheBody1612Continue:
                intent = new Intent(this, FollowTheLight1611Continue.class);
                startActivity(intent);
                break;



        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "CheckTheBody1612");
        startActivity(intent);

    }

}
