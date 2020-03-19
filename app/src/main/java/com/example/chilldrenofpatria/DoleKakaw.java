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

public class DoleKakaw extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"DoleKakaw","YesIDoContinue");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dole_kakaw);

        MobileAds.initialize(this,getString(R.string.app_id));

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollDoleKakaw);
        String text="“No! I thought you said it could kill someone!” you protest.\n" +
                "\tShe smiles.\n" +
                "\t“I said it could easily kill a man. I’m not a man,” she says. “Trust me.”\n" +
                "\t“Alright,” you reply.\n" +
                "“Dole Kakaw.” you say.\n" +
                "The bolt shrieks from your mouth toward Noone. Before it can strike her, a blue prismic wall envelopes her. The bolt hits the shield and flies off toward the ceiling. The wall lingers for a few moments before going away.\n" +
                "“That was beautiful,” you say.\n" +
                "“I suppose it was.” She replies. “Now. You only need two more things.”\n" +
                "“I get more stuff?” you ask.\n" +
                "She turns to look at you. “I suppose this is a lot,” she replies. “What I’m about to give you are necessities though. I’ll make it quick.”\n" +
                "She puts out both of her hands. In one hand is a black ring, in the other is a pendant shaped into an open eye. You take the ring from her hand and roll it around in your palm.\n" +
                "“There is celestial on written on the ring!” you say.\n" +
                "“Yes there is, how astute. It is an enchanted ring. Once you put it on you will attune to it. Once you attune to the ring do not take it off unless you are about to die. If you are going to die then take off the ring and it will keep you safe.” She says.\n" +
                "You put it on; it glows faintly for a few moments then shifts into a smooth ring, free of marks.\n" +
                "“It looks nice,” you say. “What does the necklace do?”\n" +
                "“It protects you against being magically put to sleep. While the ability isn’t entirely effective werejackals can charm you sleep for a few minutes. As long as you wear this you cannot be put to sleep,” she replies.\n" +
                "You take the pendant and put it around your neck. You don’t feel any different.\n" +
                "“Now, your task is to find the werejackals and interrupt their ritual. If it is interrupted, then they will not kill the humans they have. Once you interrupt the sacrifice, they will view the ground as desecrated and leave at once and never return there. Their tribe is particularly superstitious. I will lead your way by a dancing light, follow it and you will find them,” she says.\n" +
                "Questions fill your mind, but before you can ask them she vanishes. Your eyes dart around the room. She’s gone, but there is a little orb of light floating in front of the door. You only have one choice; sitting in this room isn’t really an option.\n";


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
                intent = new Intent(DoleKakaw.this, DoleKakawContinue.class);
                startActivity(intent);
            }
        });
        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonDoleKakaw= findViewById(R.id.button_DoleKakawContinue);


        buttonDoleKakaw.setOnClickListener(this);
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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "DoleKakaw");
                startActivity(intent);
                break;
            case R.id.action_startChapterOver:
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;
            case  R.id.action_lastCheckPoint:
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                intent= new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;
        }



        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.button_DoleKakawContinue:
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                else {
                    intent = new Intent(this, DoleKakawContinue.class);
                    startActivity(intent);
                }
                break;

        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "DoleKakaw");
        startActivity(intent);

    }

}
