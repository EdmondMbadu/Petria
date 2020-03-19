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


public class C2_1 extends AppCompatActivity implements View.OnClickListener {
    Intent intent;

    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler= new DBHandler(this, null);
        // it will always come from Book1 activity
        // the trick is to keep track of what happens in book 1 activity
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_1","Book1Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_1);
//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_1);

        String noonGiftPart1 = "Beams of sunlight trickle through the trees, not yet hitting the forest floor. A few of the beams pass through Noone as she hovers above Bennett and the others sleeping on the ground.\n" +
                "“Is Chagama still bringing his lizardfolk down from the mountains?” Noone asks.\n" +
                "A fairy appears next to her, looking down at those on the ground.\n" +
                "“Unfortunately. They must flee back south soon however. The females are going to have to lay their eggs in a few months,” the fairy says.\n" +
                "“No,” Noone says. “They’re looking for a way to stay this far north.”\n" +
                "“Oh,” says the fairy. “So they know about the hot springs?”\n" +
                "“I’m not sure. If Chagama has been informed about them, then he has to kill him obviously. We cannot allow Hashi to gain a following in this region,” Noone replies.\n" +
                "The sun rises above the treetops, spreading light across the forest. Light strikes David in the face. David’s eyes flutter and he sits up.\n" +
                "“Finally!” the fairy says. “Would you like me to check up on Chagama and see how long until they’ll be passing through?”\n" +
                "“No, I’ll be taking a look myself. Stay with the kid. Don’t let him die, and if everything works out, I may make you his guide,” Noone replies.\n" +
                "She smiles at the little fluttering creature. It crosses its arms and huffs.\n";




        textViewScroll.setText(Format(noonGiftPart1), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonContinue= findViewById(R.id.button_C2_1);


        butonContinue.setOnClickListener(this);

    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C2_1:
                intent= new Intent(this, C2_2.class);
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
     *this method should only be created once, but I will keep it
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
