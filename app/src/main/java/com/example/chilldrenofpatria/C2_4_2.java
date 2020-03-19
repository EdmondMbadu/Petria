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

public class C2_4_2 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_4_2);
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_4_2",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_4_2);

        String noonGiftPart1 ="“I can hear town the other way,” you reply.\n" +
                "\tDavid looks at you. He tilts his head slightly, listening.\n" +
                "\t“I can’t hear anything but the birds and the trees. What are you hearing?” he asks.\n" +
                "\t“The smithy working on the anvil. It’s really faint, but the sharp sound is unmistakable,” you reply.\n" +
                "\tHilda looks at David, then they both look at you.\n" +
                "\t“Well, lead the way then,” Hilda says.\n" +
                "\tA little surprised, you start walking back to town. Before long you can actually start hearing the smithy, and a few sounds from town. The bonfire was not very far from town, and within two hours of walking, you find yourself stepping onto a very familiar dirt road. Even though you’re barefoot, the trip wasn’t that bad in spite of one thorn and a few missteps onto stones. Hilda, on the other hand, is having a much harder time. She leans on David and walks with a limp.\n" +
                "\t“We were a little skeptical, I must admit, but you saved us quite some trouble. If we would have followed the Fletchers, we would not be even halfway to Millborough by now,” Hilda says.\n" +
                "\t“Good job, son,” David says.\n" +
                "\t“Uh, thanks,” you reply.\n" +
                "\tYou look down and smile to yourself. They start walking to the bakery, but stop at the edge of the road and look into the woods.\n" +
                "\t“Tawlay geemmen.”\n" +
                "\tA blue ball, faint in the daylight, flickers behind a tree. You smile and begin walking again. Turning back to your parents, you see David looking at you.\n" +
                "\t“Come on, son, let’s see what’s happened to the bakery,” David says.\n" +
                "\tYou say nothing more, walking just behind Hilda. A smile comes to your face.\n" +
                "\t“I’m a wizard,” you think.\n";
        textViewScroll.setText(Format(noonGiftPart1), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC5_2= findViewById(R.id.button_C5_2);

        butonC5_2.setOnClickListener(this);

    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C5_2:
                intent= new Intent(this, C2_5_2.class);
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
