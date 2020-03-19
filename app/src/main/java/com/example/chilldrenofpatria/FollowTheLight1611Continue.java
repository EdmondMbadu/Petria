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

public class FollowTheLight1611Continue extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(this, "Checkpoint reached!", Toast.LENGTH_SHORT).show();
        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLIght1611")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowTheLight1611Continue","FollowTheLIght1611");

        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("CheckTheBody")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowTheLight1611Continue","CheckTheBody");

        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("CheckTheBody1612")) {
            dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1), "FollowTheLight1611Continue", "CheckTheBody1612");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLightAgain")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowTheLight1611Continue","FollowTheLightAgain");

        }




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_the_light1611_continue);


        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollFollowTheLight1611Continue);
        String text="After it reaches the town square, the light goes off away from the road into the woods. You follow it into the dark cover of the trees.\n" +
                "\t“I don’t know what else I expected, but wandering into the woods isn’t exactly comforting,” you think. “It’s almost too dark to see. Would it be a good idea to give more light?”\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonCast= findViewById(R.id.button_CastDancingLights);
        Button buttonStay= findViewById(R.id.button_StayInTheCover);




        // when the button is clicked
        buttonCast.setOnClickListener(this);
        buttonStay.setOnClickListener(this);

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "FollowTheLight1611Continue");
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
                intent= new Intent(this, FollowTheLight1611Continue.class);
                startActivity(intent);
                break;
        }



        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.button_CastDancingLights:
                intent = new Intent(this, CastDancingLights.class);
                startActivity(intent);
                break;
            case R.id.button_StayInTheCover:
                intent = new Intent(this, StayInTheCover.class);
                startActivity(intent);
                break;



        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "FollowTheLight1611Continue");
        startActivity(intent);

    }

}
