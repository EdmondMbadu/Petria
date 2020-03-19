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

public class ForceBolt extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1), "ForceBolt", "ForceBotCantrip");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_bolt);

        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollForceBolt);
        String text = "“Dole Kakaw.”\n" +
                "\tAgain a bolt of blue energy shrieks from your mouth, this time striking the man in the shoulder. The hit buckles him, but he still approaches you. He swings his sword at you.\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonReactWithShield = findViewById(R.id.button_ReactWithShield);
        Button buttontryToDodge = findViewById(R.id.button_TrytoDodge);


        // when the button is clicked
        //15.1.1.4
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
                intent = new Intent(this, Book1Activity.class).putExtra("from", "ForceBolt");
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
//                dbHandler.getSpell(1)
                if (dbHandler.getSpell(1)<= 0) {
                    Toast.makeText(this, "You do not have enough spell slot!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "You have lost 1 spell slot!", Toast.LENGTH_SHORT).show();
                    dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1)-1,"ForceBolt", "ForceBotCantrip");
                    //15.1.1.4
                    intent = new Intent(this, ReactWithShield.class);
                    startActivity(intent);
                }
                break;
            case R.id.button_TrytoDodge:
                Toast.makeText(this, "You have  taken 3 damage!", Toast.LENGTH_SHORT).show();
                dbHandler.updateChapter(1,dbHandler.getHealth(1)-3,dbHandler.getSpell(1),"ForceBolt", "ForceBotCantrip");


//                sch1.setHealth(sch1.getHealth() - 3);

                //15.1.1.5
                intent = new Intent(this, TryToDodge.class);
                startActivity(intent);
                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "ForceBolt");
        startActivity(intent);

    }

}
