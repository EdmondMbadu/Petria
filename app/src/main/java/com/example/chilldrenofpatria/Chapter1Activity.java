package com.example.chilldrenofpatria;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Chapter1Activity extends AppCompatActivity implements View.OnClickListener {

    int health=5;
    // the spell slot arises when she kisses him;
    int spellSlot=2;
    boolean audioClicked=false;
    boolean audioPause=false;
    boolean playPressed= false;
    Intent intent;

    DBHandler dbHandler;
    // getter and setters
    public void setSpellSlot(int spellSlot){
        this.spellSlot=spellSlot;
    }
    public int getSpellSlot(){
        return this.spellSlot;
    }

    public void setHealth(int health){
        this.health=health;
    }
    public int getHealth(){
        return this.health;
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,5,2,"Chapter1Activity","Book1Activity");
//        dbHandler.addChapter(5,2,"MainActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1);
        // the support toolbar is for elements in the menu bar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // set the title of the tool bar as Chapter 1
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
//
        textViewChapter1.setTextSize(15);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));
        // how to make the set title
//        setTitle("Health: "+health+" SS: "+spellSlot);



//        textViewChapter1.setTextColor(Color.parseColor("#fff"));

        // Write the first message using text scroll
        // cast the text view

        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollChapter1);

        String noonGiftPart1 = "A tall pale woman draped in a thin white cloak levitates in the air above the center of town. A fairy flutters just above her shoulder. \n" +
                "\t“No. She just doesn’t have the intelligence, otherwise she would work fine.” The fairy says.\n" +
                "\t“Well, shit,” the woman says. “What are we going to do, then?”\n" +
                "\t“I’ve already told you, the only person capable of what you want here,” the fairy says, pointing to a young man selling bread in front of the bakery, “is that one.”\n" +
                "\t“It’s a shame, I was hoping for a woman,” she says.\n" +
                "\t“You’re lucky you got anything. He’s the only one here,” the fairy replies. “He’ll fit right in. You know, he was orphaned at seven…”\n" +
                "\t“Fine, fine. You’ve convinced me. How much time do we have?” she asks.\n" +
                "\t“None at all. They’re already here,” says the fairy.\n" +
                "\tThe sound of a bell reverberates in the air. The bustling people stop. They look at the bell above the town hall. Abandoning their tasks, they all file into the town hall.\n" +
                "\t“Hmm, seems like they’ve already started killing people.”\n";





        textViewScroll.setText(Format(noonGiftPart1), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button  butonContinue= findViewById(R.id.button_continueChapter1);


        butonContinue.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_continueChapter1:
                intent= new Intent(this, Chapter1Contiinue.class);
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
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                intent= new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;
            case  R.id.action_lastCheckPoint:
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;
            // since this button can be clicked multiple times, we need to reinitialize it often
//            case R.id.audio_off:
//                    audioClicked= true;
//                    Toast.makeText(this, "The Audio is on!", Toast.LENGTH_SHORT).show();
//                    // once the audio is on, the pause button is showing too. So, in this sense, it is also on.
//                    audioPause=true;
//                invalidateOptionsMenu();
//                break;
//            case R.id.audio_on:
//                audioClicked= false;
//                Toast.makeText(this, "The Audio is off!", Toast.LENGTH_SHORT).show();
//                invalidateOptionsMenu();
//                break;
//                // if the play button is clicked, switch to the pause button and mention that the audio is resumed
//            case R.id.audio_play:
//                audioPause=true;
//                playPressed = false;
//                Toast.makeText(this, "The Audio is resumed", Toast.LENGTH_SHORT).show();
//                invalidateOptionsMenu();
//                break;
//                // if the pause button is clicked, switch to the play button and mention that the audio has been stopped
//            case R.id.audio_pause_real:
//                audioPause=false;
//                playPressed =true;
//                Toast.makeText(this, "The Audio is paused", Toast.LENGTH_SHORT).show();
//                invalidateOptionsMenu();
//                break;
            default:
                super.onOptionsItemSelected(item);
        }



        return true;
    }
    // this method updates the menu bar
    // we will reuse this method later
//    @Override
//    public boolean onPrepareOptionsMenu(Menu menu) {
//        if(audioClicked && audioPause) {
//            menu.findItem(R.id.audio_off).setVisible(false);
//            menu.findItem(R.id.audio_on).setVisible(true);
//            menu.findItem(R.id.audio_play).setVisible(false);
//            menu.findItem(R.id.audio_pause_real).setVisible(true);
//        }
//        else if(audioClicked&& playPressed){
//            menu.findItem(R.id.audio_off).setVisible(false);
//            menu.findItem(R.id.audio_on).setVisible(true);
//            menu.findItem(R.id.audio_play).setVisible(true);
//            menu.findItem(R.id.audio_pause_real).setVisible(false);
//        }
//
//        else{
//            menu.findItem(R.id.audio_off).setVisible(true);
//            menu.findItem(R.id.audio_on).setVisible(false);
//            menu.findItem(R.id.audio_pause_real).setVisible(false);
//        }
//
//
//        return super.onPrepareOptionsMenu(menu);
//    }
    public void onBackPressed(){
        // if the back button is pressed more than once, at the home activity
        // get out of the screen
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
