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

public class C2_24_5 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_24_5);
        dbHandler = new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1, dbHandler.getHealth2(1), dbHandler.getSpell2(1), "C2_24_5", dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2 = findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: " + dbHandler.getHealth2(1) + " Spell Slots: " + dbHandler.getSpell2(1) + "<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_24_5);

        String text = "“Reshga Kakaw”\n" +
                "The mass of energy lights the forest blue. Like a shooting star, it soars through the sky, striking the jackal. The jackal tumbles to the ground, the vines still gripping its paws.\n" +
                "The lion bites its jackal’s neck. The jackal twists and kicks, then falls limp to the ground.\n" +
                "The jackal struck by you staggers to its feet. The mountain lion looks at it and drops the dead jackal from its mouth.\n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC24_2 = findViewById(R.id.button_C24_10);
        Button butonC24_3 = findViewById(R.id.button_C24_11);

        butonC24_2.setOnClickListener(this);
        butonC24_3.setOnClickListener(this);


    }


    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_C24_10:
                intent = new Intent(this, C2_24_10.class);
                startActivity(intent);
                break;
            case R.id.button_C24_11:

                intent = new Intent(this, C2_24_11.class);
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
        switch (item.getItemId()) {
            case R.id.goback:
                intent = new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;

            case R.id.action_startChapterOver:
                dbHandler.deleteChapterContent2();
                dbHandler.addChapter2(7, 2, "MainActivity", "");
                dbHandler.updateChapter2(1, 7, 2, "Book1Activity", "HomeActivity");
                intent = new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;
            case R.id.action_lastCheckPoint:
                dbHandler.deleteChapterContent2();
                dbHandler.addChapter2(7, 2, "MainActivity", "");
                dbHandler.updateChapter2(1,7,2,dbHandler.getLastClass2(1),dbHandler.getBeforeLast2(1));
                intent= new Intent(this, C2_22_1.class);
                startActivity(intent);
                break;

            default:
                super.onOptionsItemSelected(item);
        }


        return true;
    }

    public void onBackPressed() {
        // if the back button is pressed more than once, at the home activity
        // get out of the screen
        // putExtra does really matter here,because I used the database to handler it
        // we will keep it just in case
        intent = new Intent(this, Book1Activity.class).putExtra("from", "Chapter1Activity");
        startActivity(intent);


    }

    /**
     * @param sentence the string to format
     * @return a formated string. Mainly, the spaces between paragraphs are coordinated
     */
    public SpannableString Format(String sentence) {

        String formattedText = sentence.replaceAll("\n", "\n\n");
        SpannableString spannableString = new SpannableString(formattedText);

        Matcher matcher = Pattern.compile("\n\n").matcher(formattedText);
        while (matcher.find()) {
            spannableString.setSpan(new AbsoluteSizeSpan(12, true), matcher.start() + 1, matcher.end(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return spannableString;
    }
}
