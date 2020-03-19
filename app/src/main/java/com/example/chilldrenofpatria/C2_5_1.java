package com.example.chilldrenofpatria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C2_5_1 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
 private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Ap Id
        MobileAds.initialize(this,getString(R.string.app_id));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_5_1);
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_5_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_5_1);

        String text ="\n" +
                "\t“Three days. Keep it a secret for three days,” you think. “She’ll come around and teach me more.”\n" +
                "\tWhen it was all happening, it was all too much. Too overwhelming. Now that you’ve had time to digest it, you want more. Much more.\n" +
                "\tThe sun touches the mountaintops as you find your way to Millborough. David’s tone is harsher than usual as he talks to Hilda.\n" +
                "\t“This is fine for the Fletchers. They have cousins here. What are we supposed to do tonight?” he asks.\n" +
                "\tHe’s pacing alongside the road at the edge of town. Hilda stands unmoving for a while, arms crossed as they often are when she thinks. The sun is about to disappear when Hilda grabs David’s arm.\n" +
                "\t“A king’s mill is here. There is some official here we can speak with isn’t there?” Hilda asks.\n" +
                "\tDavid smiles at her.\n" +
                "\t“Come on, son, we best find his house. I think there’s a Sheriff here that would be ideal,” David says.\n" +
                "\tA few lanterns sit hung on metal poles in the street as you walk through Millborough. The road is thankfully dry as you walk in bare feet; it hasn’t rained in nearly two weeks. Hilda is having a hard time walking, though. Her age is showing, and she’s both exhausted and staggering from the wounds on her feet from the day’s travel. David holds her up as you walk toward the stone building next to the mill.\n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);
        interstitialAd = new InterstitialAd(this);
        // Unit Id ( not to confuse with the app id)t
        interstitialAd.setAdUnitId(getString(R.string.ad_unit_id));
        AdRequest request=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        interstitialAd.loadAd(request);

        // set a listener, if the user closes the ads, go to the following activity
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClicked() {
                intent = new Intent(C2_5_1.this, C2_6_1.class);
                startActivity(intent);
            }
        });

        Button butonC6_1= findViewById(R.id.button_C6_1);

        butonC6_1.setOnClickListener(this);

    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C6_1:
                if(interstitialAd.isLoaded()){
                  interstitialAd.show();
                }
                else {
                    intent = new Intent(this, C2_6_1.class);
                    startActivity(intent);
                }
                break;



        }

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
                intent= new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;

            case R.id.action_startChapterOver:
                dbHandler.deleteChapterContent2();
                dbHandler.addChapter2(7, 2, "MainActivity", "");
                dbHandler.updateChapter2(1,7,2,"Book1Activity","HomeActivity");
                intent= new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;
            case  R.id.action_lastCheckPoint:
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent2();
                dbHandler.addChapter2(7, 2, "MainActivity", "");
                dbHandler.updateChapter2(1,7,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;

            default:
                super.onOptionsItemSelected(item);
        }



        return true;
    }

    public void onBackPressed(){
        // if the back button is pressed more than once, at the home activity
        // get out of the screen
        // putExtra does really matter here,because I used the database to handler it
        // we will keep it just in case
        intent= new Intent(this, Book1Activity.class).putExtra("from", "Chapter1Activity");
        startActivity(intent);


    }

    /**
     *
     * @param sentence the string to format
     * @return a formated string. Mainly, the spaces between paragraphs are coordinated
     */
    public SpannableString Format(String sentence){

        String formattedText = sentence.replaceAll("\n", "\n\n");
        SpannableString spannableString = new SpannableString(formattedText);

        Matcher matcher = Pattern.compile("\n\n").matcher(formattedText);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), matcher.start() + 1, matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return spannableString;
    }
}
