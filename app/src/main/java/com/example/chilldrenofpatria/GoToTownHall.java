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

public class GoToTownHall extends AppCompatActivity implements View.OnClickListener {


    DBHandler dbHandler;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,5,2,"GoToTownHall","Chapter1Contiinue");

        Chapter1Activity sch1= new Chapter1Activity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_town_hall);

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        textViewChapter1.setTextSize(15);
//        textViewChapter1.setText("Chapter 1");
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));

        TextView textView = (TextView) findViewById(R.id.text_scrollChapter1GoToTown);
        String gotoTownHall="Every other shop is abandoned, and no one is around to steal anything. \n" +
                "“There’s no reason I can’t go and listen to what’s going on,” you think. “Just to be safe though, I should lock the doors and put the copper in my coin pouch.”\n" +
                "Once the doors are locked, you put the key and the coin pouch inside your pants and walk until you reach the town hall. You slip through one of the servant doors on the side of the building.\n" +
                "\tAll the servants are in the main chamber of the town hall so no one is around to question what you’re doing. You ease through one of the doors that leads to the main chamber and stay in the back to avoid being seen. The sheriff of the Blackborough, Godwin Clark, stands on a raised platform on the back wall of the hall. He has long, dark hair peppered with grey and a clean back robe. He raises his hands and waits for the crowd of people to quiet down.\n" +
                "“I’ve rung the bell to inform you that the curfew will come before sunset until told otherwise, and to explain my reasoning,” Clark announces.\n" +
                "The crowd erupts. They shout, concerned with their own businesses and angry for the inconvenience.\n" +
                "“Enough!” Clark shouts.\n" +
                "He raises his hands again and waits until the crowd settles.\n" +
                "“We’ve had five of our own people disappear within the week, and I don’t mean drunks and passersby, either! James Cook, Elena Tanner, Milo Fletcher, Ode Cook and Nathan Rolfe have all gone missing,” he continues.\n" +
                "\tWhispers fill the room. Clark lets the people talk amongst themselves for a moment before raising his hands back in the air.\n" +
                "\t“We have no idea what has been happening, but from now on, I ask us to look after each other and to and go to your homes once the curfew bell is rung,” Clark says.\n" +
                "\tYou realize that this is the time to leave before you are spotted and you start moving toward the exit.\n" +
                "\t“If you have any questions, you are welcome to ask now,” Clark calls, “but otherwise, you are dismissed.” \n" +
                "\tYou make a dash for the servant entrance and run out toward the Bakery. You make it back and when you turn to look at the crowd, you find David and Hilda speaking to each other fervently. They walk to the bakery without noticing anyone else.\n" +
                "\t“What was that about?” You ask when they enter the shop.\n" +
                "“Close the bakery first,” he instructs, “and I’ll tell you upstairs.”\n" +
                "\tYou exhale once you see them walk up the stairs, looking down at the bread stand. \n" +
                "\t“That’s odd,” you think as you notice that two loaves of bread are gone. “Who was here to take it?”\n";

        textView.setText(sch1.Format(gotoTownHall), TextView.BufferType.SPANNABLE);
        Button button= findViewById(R.id.button_GoTownHallContinue);
        button.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_GoTownHallContinue:
                intent= new Intent(this, GoToTownHallContinue.class);
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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "GoToTownHall");
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
        intent= new Intent(this, Book1Activity.class).putExtra("from", "GoToTownHall");
        startActivity(intent);


    }
}
