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

public class GoToTownHallContinue extends AppCompatActivity implements View.OnClickListener {

    Chapter1Activity sch1;
    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,5,2,"GoToTownHallContinue","GoToTownHall");
        sch1= new Chapter1Activity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_town_hall_continue);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
//        textViewChapter1.setText("Chapter 1");

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setTextSize(15);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));

        TextView textView = (TextView) findViewById(R.id.text_scrollChapter1GoToTownContinue);
        String gotoTownHall="You do as David says; you close up the shop. You finish as the last of the sunlight disappears. The town bell rings again. \n" +
                " “It will take me a few days to get used to that sound so early,” you think.\n" +
                "You lock the doors to the bakery and put the copper back where it belongs.\n" +
                "“Make sure the windows are locked too, Ben,” David says.\n" +
                "“Shit,” you say.\n" +
                "You lock all the windows and then rush upstairs to ask David what happened. He’s talking in a whisper to Hilda. \n" +
                "“So what happened?” you ask. “Why did they make the curfew night fall?”\n" +
                "David looks at you; he’s holding Hilda’s hand. “A few people have gone missing; one of them was your mother’s friend Elena.” He says. “I want the shop closed and you inside before night fall from now on until I say otherwise. If someone wants to do business during, or after, closing come and get me no matter who it is. Understand?”\n" +
                "“Yes, Father,” you say.\n" +
                "You look down at the ground.\n" +
                "David gives a melancholy smile. “Good, thank you,” he sighs, then looks at you. “Have you seen anything out of ordinary?”\n" +
                " “No, I haven’t seen anything odd,” you say.\n" +
                "“I didn’t expect you to, I haven’t seen anything out of order myself,” David says. “Go get some food, then go to bed early. We have a lot to talk about.”\n" +
                "“Have a good night Ben.” Hilda says.\n" +
                "You do as they say and once you finish eating, you go to your room, not much larger than a closet, and lay on your bed. Every so often, their voices echo in the house as you drift to asleep.\n";

        textView.setText(sch1.Format(gotoTownHall), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button button= findViewById(R.id.button_GoTownHallContinue2);
        button.setOnClickListener(this);

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "GoToTownHallContinue");
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_GoTownHallContinue2:
                intent= new Intent(this, Meet_5.class);
                startActivity(intent);
                break;
        }

    }

    public void onBackPressed(){
        // if the back button is pressed more than once, at the home activity
        // get out of the screen
        intent= new Intent(this, Book1Activity.class).putExtra("from", "GoToTownHallContinue");
        startActivity(intent);


    }

}
