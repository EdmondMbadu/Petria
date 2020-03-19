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

public class ReactWithShield extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    //15.1.1.4
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt")) {
            dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1),"ReactWithShield" ,"ForceBolt");

        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("TryToRunOut")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"ReactWithShield","TryToRunOut");
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_react_with_shield);

        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollReachWithShield);
        String text = "“Cha.”\n" +
                "\tA shield of energy surrounds you just as the man begins to swing. The sword breaks through the shield but misses, coming down on the floor next to you.\n" +
                "\tHe falls to the floor with his weapon, but begins to stagger back to his feet. He’s right in front of you now. He looks very weak.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonForceBolt6 = findViewById(R.id.button_ForceBolt6);
        Button buttontryToRunOut = findViewById(R.id.button_TryToRunOut);


        // when the button is clicked
        //15.1.1.4
        buttonForceBolt6.setOnClickListener(this);
        buttontryToRunOut.setOnClickListener(this);
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
                intent = new Intent(this, Book1Activity.class).putExtra("from", "ReactWithShield");
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
            case R.id.button_ForceBolt6:
                //15.1.1.6
                intent = new Intent(this, ForceBolt6.class);
                startActivity(intent);

                break;
            case R.id.button_TryToRunOut:

                dbHandler.updateChapter(1,dbHandler.getHealth(1)-7,dbHandler.getSpell(1),"ReactWithShield",dbHandler.getBeforeLast(1));
                Toast.makeText(this, "You have  taken 7 damage!", Toast.LENGTH_SHORT).show();


                //15.1.1.5
                intent = new Intent(this, TryToRunOut.class);
                startActivity(intent);
                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "ReactWithShield");
        startActivity(intent);

    }

}
