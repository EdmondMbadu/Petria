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

public class DoNothing extends AppCompatActivity implements View.OnClickListener {

    Chapter1Activity sch1;
    Intent intent;
    DBHandler dbHandler;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"DoNothing","Meet_5");
        sch1= new Chapter1Activity();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_nothing);
        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        Toolbar toolbar= findViewById(R.id.toolbar);
        textViewChapter1.setTextSize(15);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));


        TextView textView = (TextView) findViewById(R.id.text_scrollDoNothing);
        String text="You lie back down in your bed and roll over in your covers.\n" +
                "“It’s just a dream,” you think.\n" +
                "“This is no dream darling,” She says.\n" +
                "“It has to be,” you think. “How else could she read my mind? I’m just going to lie in my bed until morning.”\n" +
                "“Oh, well. We’ll find someone else,” she says. “Have fun.”\n" +
                "You lay in your bed for a short time listening to the noises in the hall.\n" +
                "It becomes silent.\n" +
                "You hear the knob of the door to your little room turn.\n" +
                "“I’m dreaming. I just have to keep my eyes closed.” \n" +
                "You hear the door opening, and the wooden floorboards creaking. Each sound becomes louder and louder, until you are too scared to keep your eyes shut. You open them to see a man standing above you. You lock eyes and for a few moments you seem strangely sleepy. The feeling dissolves, replaced with terror. \n" +
                "The man looks at you angrily. He raises the sword in his hand and strikes you on the head.\n";

        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);


        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonGoBackCheckPoint= findViewById(R.id.button_GoBackCheckpoint);

        buttonGoBackCheckPoint.setOnClickListener(this);


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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "DoNothing");
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
            case R.id.button_GoBackCheckpoint:
                intent = new Intent(this,Meet_5.class);
                startActivity(intent);
                break;
//            case R.id.button_GoBackLastChoice:
//                intent = new Intent(this, RunOutAndSee.class);
//                startActivity(intent);
//                break;
        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "DoNothing");
        startActivity(intent);
    }

}
