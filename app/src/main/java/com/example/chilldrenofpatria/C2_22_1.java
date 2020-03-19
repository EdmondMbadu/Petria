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

public class C2_22_1 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c2_22_1);
        Toast.makeText(this, "Checkpoint Reached!", Toast.LENGTH_SHORT).show();
        dbHandler= new DBHandler(this, null);
        //update the database with another s
        dbHandler.updateChapter2(1,dbHandler.getHealth2(1),dbHandler.getSpell2(1),"C2_22_1",dbHandler.getLastClass2(1));

//        Initialize the toolbar
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter2=findViewById(R.id.toolbar_textview);
        textViewChapter2.setTextSize(15);
        textViewChapter2.setText(Html.fromHtml("Health: "+dbHandler.getHealth2(1)+" Spell Slots: "+dbHandler.getSpell2(1)+"<sup><small>1st<small><sup>"));


        TextView textViewScroll = (TextView) findViewById(R.id.text_scrollC2_22_1);

        String text ="You spend the next hour attuning to your staff. It is very natural, but feels very foreign. Energy from your body can leave into the staff, though it doesn’t feel any more draining than kneading dough. Doing it leaves you with a sense of wonder.\n" +
                "\t“It’s time to be on our way. Bennett, stay behind me. Don’t cast a spell until I strike their leader down. Then cast as much as you can. Chase them if you have to. No one say another word.”\n" +
                "\tShe looks at you.\n" +
                "\t“When I turn around, you get rid of those lights and follow exactly behind me. I will touch your shoulder. When I do, do not move until I attack,” she says.\n" +
                "\tThe blue lights fall to your feet with a thought. She turns and walks away. Her feet touch the ground softly, silently as they fade out of your sight. She is much more graceful than you, much quieter.\n" +
                "Insert Image Here\n" +
                "\n" +
                "\tThe walk is long and the lack of sleep begins to sink in. While your body is tired, your mind is sharp. Your eyes never stop moving, looking at everything you can see. She turns and you stop a few steps behind her. The lights hanging at your feet vanish. She takes your hand. Her skin is callus, strong, though her grip is gentle. Each step she takes you follow as best you can.\n" +
                "\tThere is light coming from below. A small valley dips below the forest floor. You can see the jackals, and the bodies of a few dozen deer littering the valley.\n" +
                "\tShe turns and touches your shoulder, then wanders off. You can hear Mo’s wings fluttering next to your head, but he’s invisible. The trees are dense here, even in the valley. You look down and see a man next to the fire looking into it. The fire is very close to a few trees, the bark on one is even chard.\n" +
                "\t“Should I get closer?” you think.\n";
        textViewScroll.setText(Format(text), TextView.BufferType.SPANNABLE);

//        textViewScroll.setText(formattedText);

        Button butonC23_1= findViewById(R.id.button_C23_1);
        Button butonC23_2= findViewById(R.id.button_C23_2);

        butonC23_1.setOnClickListener(this);
        butonC23_2.setOnClickListener(this);



    }



    public void onClick(View view) {

        switch(view.getId()){
            case R.id.button_C23_1:
                intent= new Intent(this, C2_23_1.class);
                startActivity(intent);
                break;
            case R.id.button_C23_2:
                intent= new Intent(this, C2_23_2.class);
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
