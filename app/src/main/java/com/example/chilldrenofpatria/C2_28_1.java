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

public class C2_28_1 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_28_1);
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_28_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_28_1);

        String text ="“I greet you, and show respect to your goal,” Noone says.\n" +
                "\tThe experience is jumbling. The language they are speaking isn’t anything you’ve heard before. The words are light, and they flow smoothly. Even though you don’t know the language, you understand what she says.\n" +
                "\t“We are here to listen to what you have to say. If Chagama really is working his way to these hot springs, we see no way of stopping him,” a Dryad says.\n" +
                "\tLooking at them, you see one is Meytheo.\n" +
                "\t“The thing that is most important is that you do not die. If they take the hot springs, we can always take them back. Chagama must die, and you must continue living. If Chagama is to die, then the lizard folk will soon abandon his god,” Noone says.\n" +
                "\t“Sarash is not our only concern. Lizard folk do not belong in these springs,” the dryad says.\n" +
                "\t“We can deal with them as I said, but surely it can be agreed that their removal is of a lower priority,” Noone replies.\n" +
                "\tThe dryads look at each other.\n" +
                "\t“We agree. Now tell us your plan,” says the dryad.\n" +
                "\t“As you know, they are coming up from the Saydon desert. That is why the werejackals are here,” Noone says. “They fled north running from them. We wait until they are just outside the forest. They will go through Blackborough, when they are attacking the town is when we will hit them. Ideally, they will flee into the northern woods where there will be a trap for them.”\n" +
                "\t“Who will be reasonable for the main attack, and who will be responsible for the ambush?” The dryad asks.\n" +
                "Noone turns, her dazzling eyes look at you.\n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC24_1= findViewById(R.id.button_C28_1End);

        butonC24_1.setOnClickListener(this);



    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C28_1End:
                Toast.makeText(this, "END OF CHAPTER II ", Toast.LENGTH_SHORT).show();
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent2();
                dbHandler.addChapter2(7, 2, "MainActivity", "");
                dbHandler.updateChapter2Done(1,7,2,"Book1Activity","HomeActivity");
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
