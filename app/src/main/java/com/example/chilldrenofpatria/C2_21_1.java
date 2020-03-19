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

public class C2_21_1 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    private InterstitialAd interstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_21_1);
        MobileAds.initialize(this,getString(R.string.app_id));
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_21_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_21_1);

        String text ="“We’re here,” she says. “Let me get them, I’ll be back in a moment.”\n" +
                "\tLooking around, you find that you’re standing in a small clearing with a large fallen tree, which is carved into a long table. Wanting to get a better look, you move the lights through the air around you. They spin around each other as they move.\n" +
                "\t“I’m getting better at this,” you think.\n" +
                "\t“Now kid, don’t panic and start throwing force bolts around. They won’t hurt you,” Mo says.\n" +
                "\t“What?” you reply.\n" +
                "\tA grumble comes from behind you. Turning around, you see a black bear sniffing you. You back away. It doesn’t follow you, but instead sits down. A wolf walks up beside the bear and lies on the ground. Turning, you see a mountain lion laying on the table looking at you.\n" +
                "\t“Why are there a bunch of animals looking at me, Mo?” you ask.\n" +
                "\t“What else do they have to look at?” Mo replies.\n" +
                "\t“This is the rest of our party for the night. I think you’ll find them useful, as long as you don’t attack them,” Meytheo says.\n" +
                "\tThe animals seem indifferent toward you. Any one of them could kill you normally.\n" +
                "\t“I’ll tell you all what to do. Don’t get in the way of these animals, and they won’t get in your way. Understand?” Meytheo asks.\n" +
                "\t“Anything you say Theo.” Mo replies.\n" +
                "\t“Umm. Yeah, don’t mess with them. That won’t be a problem,” you reply.\n" +
                "\t“I have food prepared for you all. We will wait an hour before we start. It’s just under an hour walk to where they’re camped out,” Meytheo says.\n" +
                "\tMeytheo hands you a dark berry. You roll it around in the palm of your hand, then look at her. She’s giving three of them to the bear. \n" +
                "\t“I guess I’m supposed to eat this,” you think.\n" +
                "\tThe dark berry is sweet in your mouth, and once you finish it, your hunger vanishes.\n" +
                "\t“Mo, what did she give me?” you ask.\n" +
                "\t“I guess you wouldn’t have eaten one before. She gave you a goodberry. You won’t have to eat anything else until mid-day tomorrow at least,” Mo replies.\n" +
                "\t“How do you grow them?” you ask.\n" +
                "\t“It’s a spell. I’m not sure if you can grow them. I don’t think you can,” Mo continues.\n";

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
                intent = new Intent(C2_21_1.this, C2_22_1.class);
                startActivity(intent);
            }
        });


        Button butonC21_1= findViewById(R.id.button_C22_1);

        butonC21_1.setOnClickListener(this);



    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C22_1:
                if(interstitialAd.isLoaded()){
                    interstitialAd.show();
                }
                else {
                    intent = new Intent(this, C2_22_1.class);
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
                intent= new Intent(this, C2_11_1.class);
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
