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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C2_2 extends AppCompatActivity implements View.OnClickListener {

    DBHandler dbHandler;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_2);
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_2","C2_1");

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_2);

        String noonGiftPart1 = "“Wake up, son,” David says.\n" +
                "You open your eyes and see the trees swaying above you. You jump to your feet.\n" +
                "“Easy, you’re alright. I think we’re safe,” David says. “Wake up your mother, and I’ll get Hans and Gwyneth.”\n" +
                "You do as David says. Hilda is nearly hysterical. The Fletchers talk to David for a while, then begin walking away. They are walking in the opposite direction of town. David and Hilda walk over to you. You’ve been standing awkwardly just out of earshot of their conversation.\n" +
                "“The Fletchers remember just the same as your mother and I. Men broke into our houses and knocked us out somehow,” David says. “Hans said they hit him with a club, but we don’t remember them doing that to us. We just looked at them and fell asleep. What do you remember?”\n";



        textViewScroll.setText(Format(noonGiftPart1), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC3_1= findViewById(R.id.button_C3_1);
        Button butonC3_2= findViewById(R.id.button_C3_2);
        Button butonC3_3= findViewById(R.id.button_C3_3);


        butonC3_1.setOnClickListener(this);
        butonC3_2.setOnClickListener(this);
        butonC3_3.setOnClickListener(this);

    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C3_1:
                intent= new Intent(this, C2_3_1.class);
                startActivity(intent);
                break;
            case R.id.button_C3_2:
                intent= new Intent(this, C2_3_2.class);
                startActivity(intent);
                break;
            case R.id.button_C3_3:
                intent= new Intent(this, C2_3_3.class);
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
