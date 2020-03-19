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

public class C2_15_1 extends AppCompatActivity implements View.OnClickListener {

    DBHandler dbHandler;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_15_1);
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_15_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_15_1);

        String text ="Instead of asking any more questions, you spend a while thinking about the ones you’ve asked. The air tonight is cold, and if it wasn’t for your new clothes you would be shivering. Even the hood on your cloak does a lot to keep you warm.\n" +
                "\tYou catch the smell of a flower. It’s sweet, sweeter than any flower you’ve known.\n" +
                "\t“What kind of flowers bloom here Mo?” you ask.\n" +
                "\t“There are many, though no plants flower at night this time of year, so you won’t find any. Why?” Mo replies.\n" +
                "\t“Oh, maybe it wasn’t a flower. I caught the scent of something very nice. I have no idea what though,” you say.\n" +
                "\t“Well, I suppose she’s found us then,” Mo says. “You have nothing to fear from Bennett. He’s harmless for now.”\n" +
                "\t“What? Who are you?” You say.\n" +
                "\tBefore you can finish your thought, a woman comes out of the tree in front of you and takes your staff. She looks at you, and though it’s dark you can tell she’s not human. You raise your dancing lights to illuminate her. She has rough dark brown skin and her hair is branches of weeping willows falling down her back. You look in her amber eyes, and you smile. \n" +
                "Insert Image Here\n" +
                "\tShe gives you back your staff.\n" +
                "\t“Thank you, I’m Ben,” you say.\n" +
                "\t“Meytheo,” she replies.\n" +
                "\tMo changes back to his normal form and greets her with a bow.\n" +
                "\t“Good to see you Theo, it’s been too long,” Mo says.\n" +
                "\t“It’s been ten days Mo,” she says.\n" +
                "\t“Ah! So you’ve been counting!” Mo says.\n" +
                "\tShe rolls her eyes.\n" +
                "\t“You act worse than this one, and I have him charmed,” she says.\n" +
                "\tShe looks at you.\n" +
                "\t“What is he doing here anyway? One of Noone’s charity cases?” she asks.\n" +
                "\t“He’s a little sharper than he looks,” Mo replies. “He’ll be dangerous once he gets a little practice. He’s only been a wizard for a few days.”\n" +
                "\t“He’ll get plenty of practice tonight. The jackals have been causing a fucking mess up here. I’ve never seen such dirty wild animals as these. Making them humanoid doesn’t help, I’m sure. We need to introduce him to the rest of our extermination crew. Follow behind me.”\n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC16_1= findViewById(R.id.button_C16_1);

        butonC16_1.setOnClickListener(this);


    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C16_1:
                intent= new Intent(this, C2_16_1.class);
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
