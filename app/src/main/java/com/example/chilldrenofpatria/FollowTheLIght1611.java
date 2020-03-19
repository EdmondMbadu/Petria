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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class FollowTheLIght1611 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        MobileAds.initialize(this,getString(R.string.app_id));
        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceStrike2")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowTheLIght1611","ForceStrike2");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("forceStrikeBolt")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowTheLIght1611","forceStrikeBolt");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt6")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowTheLIght1611","ForceBolt6");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceStrike9")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowTheLIght1611","ForceStrike9");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt8")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"FollowTheLIght1611","ForceBolt8");
        }

//        dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1),"FollowTheLIght1611" ,"ForceStrike2");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_the_light1611);


        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollFollowTheLight1611);
        String text="Slowly you take a breath. You look at the ball of light and begin to walk toward it. You get just close enough to touch it. It begins moving away from you. Down the stairway to the first floor, you follow the light. It takes you out into the town square.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        interstitialAd = new InterstitialAd(this);
        // Unit Id ( not to confuse with the app id)still need to get this one
        interstitialAd.setAdUnitId(getString(R.string.ad_unit_id));
        AdRequest request=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        interstitialAd.loadAd(request);

        // set a listener, if the user closes the ads, go to the following activity
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClicked() {
                intent = new Intent(FollowTheLIght1611.this, FollowTheLight1611Continue.class);
                startActivity(intent);
            }
        });

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "FollowTheLIght1611");
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
            case R.id.button_FollowTheLight1611Continue:
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                else {
                    intent = new Intent(this,  FollowTheLight1611Continue.class);
                    startActivity(intent);
                }
                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "FollowTheLIght1611");
        startActivity(intent);

    }

}
