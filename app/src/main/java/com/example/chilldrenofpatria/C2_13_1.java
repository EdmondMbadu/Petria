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

public class C2_13_1 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_13_1);
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_13_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_13_1);

        String text ="“Leave the bakery and wait outside. I wanna check up on your parents,” Mo says.\n" +
                "\tDoing your best to be sneaky, you walk down the creaking stairs and out the door to wait a few moments outside. There isn’t anyone around, but you’re still worried that someone will see you in these clothes.\n" +
                "\tFinally Mo pops out of thin air in front of you.\n" +
                "\t“Your parents are fine, but they’ll be worried sick about you when they wake up and you’re gone.”\n" +
                "\t“I’m not coming back?” you ask.\n" +
                "\t“Not by the end of the night,” Mo says. “You don’t know what you signed up for, kid, but you’ll find out soon. Your whole world is about to change. Now follow me, I’m gonna change into a ball of light. It’s less suspicious than a little winged man.”\n" +
                "\tMo turns into a glowing ball of white light and leads you into the woods. Even with the little ball of light leading you, the night is too dark to see. After tripping over roots for the fifth time, you decide to cast dancing lights, letting the four little balls hover above the ground in front of your feet as you walk. It doesn’t take long before your curiosity gets the better of you and you start asking questions.\n";

        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC14_1= findViewById(R.id.button_C14_1);
        Button butonC14_2= findViewById(R.id.button_C14_2);
        Button butonC14_3= findViewById(R.id.button_C14_3);
        Button butonC14_4= findViewById(R.id.button_C14_4);



        butonC14_1.setOnClickListener(this);
        butonC14_2.setOnClickListener(this);
        butonC14_3.setOnClickListener(this);
        butonC14_4.setOnClickListener(this);


    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C14_1:
                intent= new Intent(this, C2_14_1.class);
                startActivity(intent);
                break;
            case R.id.button_C14_2:
                intent= new Intent(this, C2_14_2.class);
                startActivity(intent);
                break;
            case R.id.button_C14_3:
                intent= new Intent(this, C2_14_3.class);
                startActivity(intent);
                break;
            case R.id.button_C14_4:
                intent= new Intent(this, C2_14_4.class);
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
