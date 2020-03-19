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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C2_26_1 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_26_1);
        Toast.makeText(this, "Checkpoint Reached!", Toast.LENGTH_SHORT).show();
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        // it become
        dbHandler.updateChapter2(1,12,3,"C2_26_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_26_1);

        String text ="“Wake up, darling. We’ve got a lot to talk about before I leave,” Noone’s voice echoes.\n" +
                "\tFluttering, your eyes open to see dark curly hair. She turns around and looks at you. Emerald is all you see. Her eyes are entrancing. She smiles, blinking a few times. \n" +
                "\tYou regain focus, looking around at the forest. The lush green around you seems dull compared to her eyes.\n" +
                "\t“Your eyes are brighter than any green thing I can see, and green is everywhere,” you say.\n" +
                "\t“My eyes didn’t always look like this. That’s the only thing I’ve changed about my appearance over the years,” she says. “They really are like that now, though; it’s not an illusion, no trick of the eye, so to speak.” She winks at you.\n" +
                "\tA smile comes to your face. Her clothes have changed. She’s wearing brown pants and a loose white long sleeve blouse. She’s not hovering either, instead walking on the ground in her bare feet.\n" +
                "\t“Come along. We have to have a chat with the dryads. They want to know how we are going to handle Chagama,” she says. “We must illustrate our plan well if they are to buy into it. So you best be prepared, and awake.”\n" +
                "\tShe begins walking away. You get to your feet, fumbling behind her.\n" +
                "\t“Don’t forget your staff. It hasn’t forgotten about you,” she says.\n" +
                "\tYou realize you aren’t holding your staff. \n" +
                "\t“Shit,” you think.\n" +
                "\tWalking back, you grab it from the ground.\n" +
                "\t“My spell book,” you think.\n" +
                "\tIt is inside your shirt, but it takes you a few moments to realize. Noone is looking at you, smiling.\n" +
                "\t“I’m coming!” you say.\n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC24_1= findViewById(R.id.button_C27_1);

        butonC24_1.setOnClickListener(this);



    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C27_1:
                intent= new Intent(this, C2_27_1.class);
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
