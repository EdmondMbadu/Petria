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

public class RunOutAndSee extends AppCompatActivity  implements View.OnClickListener {

    Chapter1Activity sch1;
    Intent intent;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"RunOutAndSee","Meet_5");
        super.onCreate(savedInstanceState);
        sch1= new Chapter1Activity();
        setContentView(R.layout.activity_run_out_and_see);
        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)));
        textViewChapter1.setTextSize(15);
        TextView textView = (TextView) findViewById(R.id.text_scrollRunOutAndSee);
        String text="You look at the door, then back at Noone.\n" +
                "You leap out of bed and open the door. You find two men carrying your unconscious mother and father out of their bedroom. \n" +
                "You look at one of them. He locks eyes with you. You feel dizzy.\n" +
                "Your eyes close as you slump to the floor.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);




        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonGoBackCheckPoint= findViewById(R.id.button_GoBackCheckpoint);
//        Button buttonGoBackLastChoice =findViewById(R.id.button_GoBackLastChoice);
        buttonGoBackCheckPoint.setOnClickListener(this);
//        buttonGoBackLastChoice.setOnClickListener(this);

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
                intent= new Intent(this, Book1Activity.class).putExtra("from", "RunOutAndSee");
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
                intent = new Intent(this, Meet_5.class);
                startActivity(intent);
                break;
//            case R.id.button_GoBackLastChoice:
//                intent = new Intent(this, Meet_5.class);
//                startActivity(intent);
//                break;

        }

    }

    // if the button back button pressed
    public void onBackPressed(){
        // if the back button is pressed, the home activity is summoned

        intent= new Intent(this, Book1Activity.class).putExtra("from", "RunOutAndSee");
        startActivity(intent);


    }

}
