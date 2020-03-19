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

public class C2_12_1 extends AppCompatActivity implements View.OnClickListener {

    DBHandler dbHandler;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_12_1);
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_12_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_12_1);

        String text ="“Well?” she asks.\n" +
                "\t“I think the clothes are wonderful, especially the boots,” you reply.\n" +
                "\t“You must attune the staff. Once you do, the spells you cast can come from the enchanted jewel if you wish, even if you do not have possession of the staff,” she says. “But that will take about an hour. It is very easy, so you won’t need me to teach you.”\n" +
                "\tShe stands and walks toward you. Her emerald eyes seem so bright, so dazzling. She fixes your cloak and looks at you for a moment.\n" +
                "\t“You may make a wizard yet. According to Yemo, you have been studying your little spell book incessantly. I’ll give you a few more spells soon. You can hand a few more, I think,” she says. “I wish I had a little more time, but I’m in a terrible hurry. The last thing I must do before I go is introduce you to Yemo.”\n" +
                "\tA little person with butterfly wings appears. He looks a little upset.\n" +
                "\t“What is that, a pixie?” you ask.\n" +
                "\tThe little man snorts.\n" +
                "\t“I’m a fucking fairy. Pixies are our cousins, and we have a few more tricks than them,” he says.\n" +
                "\t“Now, now, no more of that language. We don’t need to pass on bad habits,” Noone says. “This intrepid little spit fire is Yemo. He will be helping you, giving you my instructions and teaching you anything you need to know. And with this introduction, I must go.” \n" +
                "\tShe kisses you on the cheek, then snaps her fingers, disappearing and leaving you in the warm room with Yemo.\n" +
                "\t“Uh, hello Yemo. It’s nice to meet you,” you say.\n" +
                "\t“Call me Mo. We ain’t got time to talk. People need savin’. Follow me,” he says.\n" +
                "\tHe grabs the door handle with both his hands, spinning his whole body in a circle and opening the door. You smile a little when you see this.\n" +
                "\tHe flies out the door, and you follow him into your bedroom.\n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC13_1= findViewById(R.id.button_C13_1);


        butonC13_1.setOnClickListener(this);


    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C13_1:
                intent= new Intent(this, C2_13_1.class);
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
