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

public class ForceBolt6 extends AppCompatActivity implements View.OnClickListener {


    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1),"ForceBolt6" ,"ReactWithShield");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_bolt6);
        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);

        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollForceBolt6);
        String text = " “Dole Kakaw.”\n" +
                "\tThe energy you speak into existence leaps from your mouth, striking the man in the head. You hear a snap as his neck twists and his body falls to the floor. You didn’t realize before how much he was bleeding. Blood covers the floor where he lay motionless.\n" +
                "\t“What should I do now?” you think.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonFollowTheLIght = findViewById(R.id.button_FollowTheLight1611);
        Button buttonCheckTheBody = findViewById(R.id.button_CheckTheBody1612);


        // when the button is clicked
        //15.1.1.4
        buttonFollowTheLIght.setOnClickListener(this);
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
        switch (item.getItemId()) {
            case R.id.goback:
                intent = new Intent(this, Book1Activity.class).putExtra("from", "ForceBolt6");
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
            case R.id.button_FollowTheLight1611:
                intent = new Intent(this,FollowTheLIght1611.class);
                startActivity(intent);
                break;
            case R.id.button_CheckTheBody1612:
                intent = new Intent(this, CheckTheBody1612.class);
                startActivity(intent);
                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "ForceBolt6");
        startActivity(intent);

    }

}
