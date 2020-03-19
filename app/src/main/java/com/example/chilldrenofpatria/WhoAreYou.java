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

public class WhoAreYou extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        MobileAds.initialize(this,getString(R.string.app_id));

        if(dbHandler.getLastClass(1).equalsIgnoreCase("StayInBed")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"WhoAreYou","StayInBed");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowHer")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"WhoAreYou","FollowHer");
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_who_are_you);


        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));

        TextView textView = (TextView) findViewById(R.id.text_scrollWhoAreYou);
        String text="“Wh-who are you? you ask.\n" +
                "“I think what you really mean to ask is ‘what are you?’” Noone corrects. \n" +
                "She stands up, and her chair disappears. Her fingers snap and her body shimmers, dissipating into a mist. The mist drifts toward you. Leaping up, you stagger backward onto the wall. Shivers pass through you as you press against the cold stone. The mist shimmers, morphing into a glimmering man. As it takes form you turn away from the blinding light. You struggle to look at his shining body. The light fades to reveal a massive painted man with dark braided hair and wings that swallow the room. \n" +
                "“I am beautiful power, blinding light, liberating guidance,” he says.\n" +
                "The sound of his voice shakes you. He flaps his wings and dissipates back into mist. You slide to the floor and look up at the ceiling. Before you can think, the mist begins again taking form. As it takes shape it flickers red. A goliath red humanoid forms before your eyes. Jagged scars cover its rough skin. Leather wings jut from its back scraping the walls. The floor shakes as its tail crashes down. \n" +
                "“I am terrible power, suffocating darkness, subjugating lies,” it says.\n" +
                "You look away from the twisted creature, and cover your ears. When you regain enough courage to open your eyes you find a winged lion before you. Awe inspired, you stand and look at it. You’ve never seen a lion before. It towers over you, unable to fully spread its wings.\n" +
                "“I am beyond your current understanding,” it says.\n" +
                "Its voice, though strong, is soft. Its eyes are white and its fur is umber. You reach out to touch it. The lion fragments, fading into mist once again. Your eyes glaze over for a few moments as you drift back to the wall. \n" +
                "“I’m sorry. I may have shocked you a bit too much.”\n" +
                "Noone is back, her curly, chestnut hair draped over her thin white dress. Air seems a little easier to breath. You stop leaning against the wall.\n" +
                "“I think that’s enough questions for now,” she says.\n";
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
                intent = new Intent(WhoAreYou.this, WhoAreYouContinue.class);
                startActivity(intent);
            }
        });


        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonWhoAreYouContinue= findViewById(R.id.button_whoAreYouContinue);

        buttonWhoAreYouContinue.setOnClickListener(this);


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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "WhoAreYou");
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
            case R.id.button_whoAreYouContinue:
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                else {
                    intent = new Intent(this, WhoAreYouContinue.class);
                    startActivity(intent);
                }
                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "WhoAreYou");
        startActivity(intent);


    }

}
