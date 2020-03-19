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

public class C2_24_18 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    private InterstitialAd interstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_24_18);
        MobileAds.initialize(this,getString(R.string.app_id));
        dbHandler = new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1, dbHandler.getHealth2(1), dbHandler.getSpell2(1), "C2_24_18", dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2 = findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: " + dbHandler.getHealth2(1) + " Spell Slots: " + dbHandler.getSpell2(1) + "<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_24_18);

        String text ="“Reshga Kakaw”\n" +
                "The blue sphere of energy ripples at it flies toward the jackal. It ducks under the spell, which crashes into a tree behind it. The force of the spell breaks the trunk of the tree. The tree falls toward you but comes short of hitting you. It does not fall short of falling onto the jackal coming toward you. The trunk slams down onto the jackal, crushing it.\n" +
                "Looking around to check there isn’t any more, you find the wolf laying dead next to the fire place. You look at Meytheo, who is dragging one of the jackals to the fire pit. She throws it on the fire and walks to the next body.\n" +
                "You didn’t notice how fast your heart was beating until now. You’re breathing quickly, and you feel sick. \n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        interstitialAd = new InterstitialAd(this);
        // Unit Id ( not to confuse with the app id)still need to get this one
        interstitialAd.setAdUnitId(getString(R.string.ad_unit_id));
        AdRequest request=new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        interstitialAd.loadAd(request);

        // set a listener, if the user closes the ads, go to the following activity
        interstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClicked() {
                intent = new Intent(C2_24_18.this, C2_25_1.class);
                startActivity(intent);
            }
        });

        Button butonC24_2 = findViewById(R.id.button_C25_1);
//        Button butonC24_3 = findViewById(R.id.button_C24_20);



        butonC24_2.setOnClickListener(this);
//        butonC24_3.setOnClickListener(this);


    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_C25_1:
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                else {
                    intent = new Intent(this, C2_25_1.class);
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
        switch (item.getItemId()) {
            case R.id.goback:
                intent = new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;

            case R.id.action_startChapterOver:
                dbHandler.deleteChapterContent2();
                dbHandler.addChapter2(7, 2, "MainActivity", "");
                dbHandler.updateChapter2(1, 7, 2, "Book1Activity", "HomeActivity");
                intent = new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;
            case R.id.action_lastCheckPoint:
                dbHandler.deleteChapterContent2();
                dbHandler.addChapter2(7, 2, "MainActivity", "");
                dbHandler.updateChapter2(1,7,2,dbHandler.getLastClass2(1),dbHandler.getBeforeLast2(1));
                intent= new Intent(this, C2_22_1.class);
                startActivity(intent);
                break;

            default:
                super.onOptionsItemSelected(item);
        }


        return true;
    }

    public void onBackPressed() {
        // if the back button is pressed more than once, at the home activity
        // get out of the screen
        // putExtra does really matter here,because I used the database to handler it
        // we will keep it just in case
        intent = new Intent(this, Book1Activity.class).putExtra("from", "Chapter1Activity");
        startActivity(intent);


    }

    /**
     * @param sentence the string to format
     * @return a formated string. Mainly, the spaces between paragraphs are coordinated
     */
    public SpannableString Format(String sentence) {

        String formattedText = sentence.replaceAll("\n", "\n\n");
        SpannableString spannableString = new SpannableString(formattedText);

        Matcher matcher = Pattern.compile("\n\n").matcher(formattedText);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), matcher.start() + 1, matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return spannableString;
    }
}