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

public class C2_27_1 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_27_1);
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_27_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_27_1);

        String text ="Your steps clatter against pebbles as you follow Noone down the path. Each step she takes is silent. Even when you stop walking and listen, the smooth pebbles make no sound as her feet touch them.\n" +
                "\t“How do you walk so quietly?” you ask.\n" +
                "\t“It’s a bit of a mixture,” she says. “I walk barefoot in such a way as to be very quiet, but I also use a cantrip that lets me stifle sound, in a manner of speaking. If I wanted to I could make noise.” She kicks her foot up, scattering a few pebbles, and they clatter across the path. “I find it is best to avoid making unnecessary noise,” she continues.\n" +
                "\tThe path leads through pools of steaming water, then up a rocky hill. At the top of the hill stands a large tree shading three Dryads, clothed in brown robes, standing around a boulder cut into a table. \n" +
                "\t“I wonder why they have clothes on now,” you think.\n" +
                "\t“It’s a formality. They find it’s better to be clothed when having serious meetings with outsiders,” Noone replies telepathically.\n" +
                "\t“Is that a cantrip, too? Reading my mind?” you think.\n" +
                "\t“No, that’s a more powerful spell I’m afraid. I’m also going to cast a spell that lets you understand Sylvan, since that’s all they will be speaking in this meeting,” Noone replies. “Now give me your hand and follow my direction.”\n" +
                "\tHer fingers slide into your palm. Taking her hand, she leads you to the stone table and greets the dryads.\n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC24_1= findViewById(R.id.button_C28_1);

        butonC24_1.setOnClickListener(this);



    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C28_1:
                intent= new Intent(this, C2_28_1.class);
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
                intent= new Intent(this, C2_26_1.class);
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
