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
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C2_11_1 extends AppCompatActivity implements View.OnClickListener {

    DBHandler dbHandler;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_11_1);
        Toast.makeText(this, "Checkpoint Reached!", Toast.LENGTH_SHORT).show();


        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_11_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_11_1);

        String text ="“Normal is relative,” Noone says. \n" +
                "\tYou sit up and look around the room. No one’s in it.\n" +
                "\t“I must be losing it,” you mutter.\n" +
                "\t“No, you’ve lost nothing. You’ve gained,” she replies. “You are about to gain much more. If you are interested, that is.”\n" +
                "\t“Yes, I am interested,” you say.\n" +
                "\t“Good.”\n" +
                "\tShe appears in front of you, floating in the air. She gives you a smile, and you smile back.\n" +
                "\t“That’s the spirit,” she says. “Now, the first thing we’ve got to give you is some clothes befitting a novice. Come with me.”\n" +
                "\tShe turns and snaps her fingers. A shadowy door appears on your wall again. She opens the door and you jump out of bed and follow her.\n" +
                "\t“Oh… The room is different,” you say.\n" +
                "\tInstead of the cold stone, reddish wood is covering the four walls, cherry maybe. The floor is the same, though covered, in many deerskin rugs, and one very large bearskin. There’s even a fireplace, though the room is windowless.\n" +
                "\t“Yes, quite right. It is a different room. If you know the spell, as many of these little rooms can be created as you’d like. I may teach you this spell in time, but not yet,” she says.\n" ;

               ;
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

        text="She closes the door and sits down on a wooden chair. She motions to a chest near the fireplace.\n" +
                "\t“In that chest you will find a few things you may like,” she says.\n" +
                "\tThe warmth of the fire surrounds you as you walk to the chest. Opening it, you find a black cloak, dark blue pants and shirt, black leather boots and a black staff with a blue stone fixed at its top.\n" +
                "\t“I hope you like the color. I know you enjoy blue,” she says. “Well go on, try them out!”\n" +
                "\tYou look at her with discomfort. She smiles and spins around so she’s not looking at you. Slipping the nightgown off, you put the dark clothes on. They fit wonderfully and feel like rabbit fur. Noone turns round once you finish lacing your pants, and watches you as you finish dressing.\n";
//        textViewScroll.setText(formattedText);
        TextView textViewScroll1 = (TextView) findViewById(R.id.text_scrollC2_11_1B);
        textViewScroll1.setText(Format(text), TextView.BufferType.SPANNABLE);

        Button butonC12_1= findViewById(R.id.button_C12_1);


        butonC12_1.setOnClickListener(this);


    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C12_1:
                intent= new Intent(this, C2_12_1.class);
                startActivity(intent);
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
