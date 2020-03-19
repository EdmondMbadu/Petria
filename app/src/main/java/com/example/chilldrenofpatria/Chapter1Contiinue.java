package com.example.chilldrenofpatria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Chapter1Contiinue extends AppCompatActivity  implements View.OnClickListener {

    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,5,2,"Chapter1Contiinue","Chapter1Activity");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter1_contiinue);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Chapter1Activity sch1= new Chapter1Activity();

        // set the title of the tool bar as Chapter 1
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will used again and again
        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
//        textViewChapter1.setText("Chapter 1");
        textViewChapter1.setTextSize(15);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));
//        setTitle("Health: "+sch1.health+" SS: "+sch1.spellSlot+"1st");

//        setTitle("Chapter 1");

        TextView textViewScrollContinue= (TextView) findViewById(R.id.text_scrollChapter1ContinueAgain);

        String noonGiftPart1 = "You look up at the bell tower, confused. “I haven’t heard the bell ring before curfew since the wheat fields were set on fire.”\n" +
                "“Stay here and watch the store, Ben, Hilda and I are going to see what this is about,” David says.\n" +
                "Without saying another word, your adoptive parents leave the bakery to you. “At least they stopped baking already.” You think. Then another thought crosses your mind. “I bet there are enough people in there that David and Hilda would never see me.”\n";

        // the Format method is in Chapter1 Continue
        textViewScrollContinue.setText(sch1.Format(noonGiftPart1), TextView.BufferType.SPANNABLE);
//        textViewScrollContinue.setText(noonGiftPart1);

        Button buttonStay= findViewById(R.id.button_stayWatchBakery);
        Button buttonGo= findViewById(R.id.button_GoTownHall);

        buttonStay.setOnClickListener(this);;
        buttonGo.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_stayWatchBakery:
                intent= new Intent(this,StayAndWatchBakery.class);
                startActivity(intent);
                break;
            case R.id.button_GoTownHall:
                intent = new Intent(this, GoToTownHall.class);
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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "Chapter1Contiinue");
                startActivity(intent);
                break;
            case R.id.action_startChapterOver:
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;
            case  R.id.action_lastCheckPoint:
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                intent= new Intent(this, Book1Activity.class);
                startActivity(intent);
                break;

        }



        return true;
    }

    public void onBackPressed(){
        // if the back button is pressed more than once, at the home activity
        // get out of the screen
        intent= new Intent(this, Book1Activity.class).putExtra("from", "Chapter1Contiinue");
        startActivity(intent);


    }
}
