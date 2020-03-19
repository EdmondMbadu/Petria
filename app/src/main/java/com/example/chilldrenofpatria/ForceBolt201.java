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
import android.widget.Toast;

public class ForceBolt201 extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1),"ForceBolt201","CastDancingLightsContinue");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_force_bolt201);

        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollForceBolt201);
        String text="“Dole kakaw.”\n" +
                "\tThe blue bolt shrieks through the air. It connects with the half jackal’s shoulder. It yelps and drops the person to the ground. Everything, the drums, the dancing, the singing stops. They all start screaming. You can barely stand the sound of it. They all change into jackals and dash off into the woods. \n" +
                "\t“It really worked,” you think.\n" +
                "\tAfter a few more moments, you walk into the clearing. The twisting fire warms your skin. The light dances unconscious faces, your parents, David and Gwyneth, and another couple. “Are they dead?” you think.\n" +
                "\t“They are in fact alive my dear,” Noone says.\n" +
                "\tYou twist in every direction looking for her, but cannot see her.\n" +
                "\t“Where are you?” you ask.\n" +
                "\t“I’m around,” she replies. “They are just asleep. Hide your book and your amulet under your clothes, but don’t take off the ring. You can just say you found it in the woods when you woke up. I’m going to put you to sleep with them so you all wake up together.”\n" +
                "\t“What?” you ask. “Why?”\n" +
                "\t“Just trust me, act like it was all a dream and don’t use any magic, I’ll come back to talk with you in three days,” she says.\n" +
                "\tYou do as she says and hide your things. You look at the people on the ground.\n" +
                "\t“But,” you begin to speak.\n" +
                "\t“Good night.”\n" +
                "\tNoone cuts you off before you can finish, and you feel lightheaded and sink to the floor. Before you realize, you are asleep.\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonCast= findViewById(R.id.button_ForceBolt201End);





        // when the button is clicked
        buttonCast.setOnClickListener(this);


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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "ForceBolt201");
                startActivity(intent);
                break;
            case R.id.action_startChapterOver:
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;
            case R.id.action_lastCheckPoint:
                intent= new Intent(this, FollowTheLight1611Continue.class);
                startActivity(intent);
                break;
        }



        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()){
            case R.id.button_ForceBolt201End:
                Toast.makeText(this, "END OF CHAPTER 1", Toast.LENGTH_SHORT).show();
                intent= new Intent(this, Book1Activity.class);
                dbHandler.deleteChapterContent();
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapterDone(1,5,2,"Book1Activity","HomeActivity");
                startActivity(intent);
                break;



        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "ForceBolt201");
        startActivity(intent);

    }

}
