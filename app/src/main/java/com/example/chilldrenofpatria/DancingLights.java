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

public class DancingLights extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1),"DancingLights","CastDancingLightsContinue");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dancing_lights);
        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollDancingLights);
        String text="“Tawlay geemmen.”\n" +
                "\tYou summon the four lights and make them drift towards the fire. \n" +
                "\t“I wander if I could make them merge together,” you think.\n" +
                "\tConcentrating, you bring them together. They merge into one much larger ball. \n" +
                "\t“Huh,” you think. “I’ll have to see what else I can do with this.”\n" +
                "\tThe ball of magic drifts into the clearing. Everything, the drums, the dancing, the singing stops. The half jackal holding the human looks at the light. The mutant thing drops who it is holding, you get so distracted looking at who’s lying on the ground the spell ends and the light disappears. They all start screaming. You can barely stand the sound of it. They all change into jackals and dash off into the woods.\n" +
                "\n" +
                "\t“Oh shit. That worked?” You think, surprised.\n" +
                "\tAfter a few more moments, you walk into the clearing. The twisting fire warms your skin. The people on the ground, you know who they are. The light dances on their faces, your parents and another couple, Hans and Gwyneth. Are they dead?\n" +
                "\t“They are in fact alive my dear.” Noone says.\n" +
                "\tYou twist in every direction looking for her, but cannot see you.\n" +
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
        Button buttonDancing= findViewById(R.id.button_DancingLightsEnd);





        // when the button is clicked
        buttonDancing.setOnClickListener(this);


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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "DancingLights");
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
            case R.id.button_DancingLightsEnd:
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

        intent= new Intent(this, Book1Activity.class).putExtra("from", "DancingLights");
        startActivity(intent);

    }

}
