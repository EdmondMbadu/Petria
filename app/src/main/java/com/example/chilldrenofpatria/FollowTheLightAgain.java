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

public class FollowTheLightAgain extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_the_light_again);
        dbHandler = new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1, dbHandler.getHealth2(1), dbHandler.getSpell(1), "FollowTheLightAgain", dbHandler.getLastClass(1));


        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollFollowTheLightAgain);
        String text="Slowly, you take a breath. You turn your attention back to the light. You follow it outside of the bakery into the town square. ";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonfollowTheLightContinue= findViewById(R.id.button_FollowTheLight1611Continue);




        // when the button is clicked
        buttonfollowTheLightContinue.setOnClickListener(this);

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "FollowTheLightAgain");
                startActivity(intent);
                break;
        }



        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.button_FollowTheLight1611Continue:
                intent = new Intent(this, FollowTheLight1611Continue.class);
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

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "FollowTheLightAgain");
        startActivity(intent);

    }

}
