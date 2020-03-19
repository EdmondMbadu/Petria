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

public class CastDancingLights extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1),"CastDancingLights", "FollowTheLight1611Continue");

        MobileAds.initialize(this,getString(R.string.app_id));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cast_dancing_lights);

        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollCastDancingLights);
        String text = "“I think lights would be alright,” you say.\n" +
                "\t“Tawlay geemmen”\n" +
                "\tA little blue ball of light appears. As you move, it doesn’t follow you. You concentrate on it, and after a little practice it moves nearly in sync with you.\n" +
                "\t“If the spell is called dancing lights, I wonder if I can cast more than one,” you think.\n" +
                "\t“Tawlay geemmen”\n" +
                "\tAnother blue light appears in front of you. You think for a moment then cast it again.\n" +
                "\t“Tawlay geemmen”\n" +
                "\tThis time four little lights appear. The other two flicker out.\n" +
                "\t“I guess I can only make four,” you say.\n" +
                "\tPaying attention to the lights has left you distracted. Not sure how long you’ve been following the little light you start to get nervous. Your feeling shifts to anticipation when you hear the beating of drums. This distracts you from the lights, and all five disappear. Once gone though, you can clearly make out the light of a fire. Noone’s light vanishes too.\n" +
                "\t“I guess this is where I’m supposed to be,” you say.\n";
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
                intent = new Intent(CastDancingLights.this, CastDancingLightsContinue.class);
                startActivity(intent);
            }
        });

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonCast = findViewById(R.id.button_CastDancingLightsContinue);


        // when the button is clicked
        buttonCast.setOnClickListener(this);


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
                intent = new Intent(this, Book1Activity.class).putExtra("from", "CastDancingLights");
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


        switch (view.getId()) {
            case R.id.button_CastDancingLightsContinue:
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                else {
                    intent = new Intent(this,  CastDancingLightsContinue.class);
                    startActivity(intent);
                }
                break;




        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "CastDancingLights");
        startActivity(intent);

    }

}
