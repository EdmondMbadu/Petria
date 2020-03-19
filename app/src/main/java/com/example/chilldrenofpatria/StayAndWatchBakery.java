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

import org.w3c.dom.Text;

public class StayAndWatchBakery extends AppCompatActivity implements View.OnClickListener {


    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,5,2,"StayAndWatchBakery","Chapter1Contiinue");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay_and_watch_bakery);
        Chapter1Activity sch1= new Chapter1Activity();

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // set the title of the tool bar as Chapter 1
        // the beauty of this part is that I only have one toolbar resource file (toolbar.xml) that I will use again and again
        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
//        textViewChapter1.setText("Chapter 1");

        textViewChapter1.setTextSize(15);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));

        TextView textView = (TextView) findViewById(R.id.text_scrollChapter1StayBakery);
        String stayBakery="They would be furious with you if you left the bakery and something was stolen. \n" +
                "“I’m sure David will let me know what is going on after the bakery closes,” you think.\n" +
                "\tYou stand in front of the bakery, filling your mind with all the things they might be talking about. Every so often you hear sounds of shouting voices, but with the doors closed and the bakery several buildings away from the commotion, there isn’t much to hear. \n" +
                "\tOut of the corner of your eye, you see a man wearing a brown cloak, looking around at the abandoned shops. You don’t recognize him. He must be a traveler. He sees you. He stops and you lock eyes. A strange, dizzy feeling comes over you for a moment, but the feeling passes as quickly as it arrives. For a while, you just stare at each other, but eventually he breaks your gaze, and slips behind the tannery.\n" +
                "\t“How odd, like an animal spotting you in the woods,” you think.\n" +
                "\tUnfortunately, nothing else exciting or interesting happens for the rest of the day. The sun sinks below the town buildings when people finally start trickling out of the town hall. David and Hilda are among the first to leave. They walk quickly to the bakery.\n" +
                "\t“What was that all about, David?” you ask.\n" +
                "\t“Close the bakery first, I’ll tell you upstairs,” he says.\n";


        textView.setText(sch1.Format(stayBakery), TextView.BufferType.SPANNABLE);

        Button button= findViewById(R.id.button_stayWatchBakeryContinue);
        button.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_stayWatchBakeryContinue:
                intent = new Intent(this, StayAndWatchBakeryContinue.class).putExtra("from", "StayAndWatchBakery");
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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "StayAndWatchBakery");
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
        intent= new Intent(this, Book1Activity.class).putExtra("from", "StayAndWatchBakery");
        startActivity(intent);


    }
}
