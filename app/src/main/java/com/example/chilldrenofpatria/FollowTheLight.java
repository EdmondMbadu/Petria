package com.example.chilldrenofpatria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FollowTheLight extends AppCompatActivity implements View.OnClickListener {


    Chapter1Activity sch1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_the_light);


        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("HP: " + sch1.health + "  SS: " + sch1.spellSlot + "<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollFollowTheLight);
        String text = "Tanking a deep breath, you take a few steps toward the light. The floorboards creak. Something breaks downstairs. You freeze, listening in the silence.\n" +
                "The sound of the creaking stairs shatters the silence. You stand as quietly as you can and look at the doorway. The sound is getting close now. You see the end of a sword peeking into the doorframe, followed by the face of a man.\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);


        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent

        Button buttonCastASpell = findViewById(R.id.button_CastASpell);
        Button buttonSitAndWait = findViewById(R.id.button_SitAndWait);
        Button buttonSpeakToTheMan = findViewById(R.id.button_SpeakToTheMan);


        buttonCastASpell.setOnClickListener(this);
        buttonSitAndWait.setOnClickListener(this);
        buttonSpeakToTheMan.setOnClickListener(this);
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
                intent = new Intent(this, Book1Activity.class).putExtra("from", "FollowTheLight");
                startActivity(intent);
                break;
        }


        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.button_CastASpell:
                Button castSpell = (Button) view;
                castSpell.setVisibility(View.GONE);
                // make two button visible on the spot
                Button forceBot = findViewById(R.id.button_ForceBot);
                Button sit= findViewById(R.id.button_SitAndWait);
                sit.setVisibility(View.GONE);
                Button speak= findViewById(R.id.button_SpeakToTheMan);
                speak.setVisibility(View.GONE);
                forceBot.setVisibility(View.VISIBLE);
                Button forceStrike = findViewById(R.id.button_ForceStrike);
                forceStrike.setVisibility(View.VISIBLE);
                forceBot.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent = new Intent(FollowTheLight.this, ForceBotCantrip.class);
                        startActivity(intent);
                    }
                });

                // if the button force strike is clicked, make it disapear
                forceStrike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        sch1.spellSlot -= 1;
                        intent = new Intent(FollowTheLight.this, ForceStrike.class);
                        startActivity(intent);
                    }
                });

                break;

            case R.id.button_SitAndWait:
                intent = new Intent(FollowTheLight.this, SitAndWait.class);
                startActivity(intent);
                break;
            // make the button Speak to the man visible
            case R.id.button_SpeakToTheMan:
                Button speakToTheMan= (Button) view;
                speakToTheMan.setVisibility(View.GONE);
                // make two button visible on the spot
                Button cast= findViewById(R.id.button_CastASpell);
                cast.setVisibility(View.GONE);
                Button sitA= findViewById(R.id.button_SitAndWait);
                sitA.setVisibility(View.GONE);
                Button pleaseLeave= findViewById(R.id.button_PleaseLeave);
                pleaseLeave.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                // this will wait for 5 second before moving to the next intent
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // action to after 5 second
                        intent= new Intent(FollowTheLight.this, SpeakToTheMan.class);
                        startActivity(intent);
                    }
                }, 2000);   //2 seconds or 2000 mili seconds
                break;




        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "FollowTheLight");
        startActivity(intent);

    }

}
