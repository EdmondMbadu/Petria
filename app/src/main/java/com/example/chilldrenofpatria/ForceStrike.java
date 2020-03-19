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

public class ForceStrike extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("GoToSleep")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"ForceStrike","GoToSleep");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLight")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"ForceStrike","FollowTheLight");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("ReachWithShield15131")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"ForceStrike","ReachWithShield15131");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_strike);
        Toast.makeText(this, "You have lost 1 spell slot!", Toast.LENGTH_SHORT).show();


        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollForceStrike);
        String text="“Reshega Kakaw.”\n" +
                "A spear of energy launches from your mouth as you speak. It strikes the man in the chest. He flies backward hitting the wall then drops to the floor. For a few moments, you sit and watch his unmoving body. As you think about what to do next, you hear him gasp. His body begins stumbling to its feet. Blood is streaming from his chest. He begins stumbling towards the stairs.\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonForceBolt= findViewById(R.id.button_forceBolt);
        Button buttonTryToSpeakToHIm= findViewById(R.id.button_TryToSpeakToHim);



        // when the button is clicked
        buttonForceBolt.setOnClickListener(this);
        buttonTryToSpeakToHIm.setOnClickListener(this);
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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "ForceStrike");
                startActivity(intent);
                break;
            case R.id.action_startChapterOver:
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;
        }



        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.button_forceBolt:
                intent = new Intent(this, forceStrikeBolt.class);
                startActivity(intent);
                break;
            case R.id.button_TryToSpeakToHim:
                intent= new Intent(this, TryToSpeakToHim.class);
                startActivity(intent);
                break;




        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "ForceStrike");
        startActivity(intent);

    }

}
