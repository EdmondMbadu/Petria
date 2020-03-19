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

public class TryToSpeakToHim extends AppCompatActivity  implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1),"TryToSpeakToHim", "ForceStrike" );

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_to_speak_to_him);
        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollTryToSpeakToHim);
        String text="“Hold on, stop!” You say.\n" +
                "\tThe man ignores you and tries to stand as he reaches the stairs. He fails, and his legs buckle. He disappears from your sight, the wooden stairs creaking as he tumbles down. Peaking into the hallway, you look down the stairs and see the man twisted at the bottom of the stairs.\n" +
                "\t“Oh…” you say.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonfollowTheLight= findViewById(R.id.button_FollowTheLight);
        Button buttonCheckTheBody= findViewById(R.id.button_CheckTheBody);



        // when the button is clicked
        buttonfollowTheLight.setOnClickListener(this);
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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "TryToSpeakToHim");
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
            case R.id.button_FollowTheLight:
                intent = new Intent(this, FollowTheLightAgain.class).putExtra("from", "TryToSpeakToHim");
                startActivity(intent);
                break;
            case R.id.button_CheckTheBody:
                intent= new Intent(this, CheckTheBody.class).putExtra("from", "TryToSpeakToHim");
                startActivity(intent);
                break;




        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "TryToSpeakToHim");
        startActivity(intent);

    }

}
