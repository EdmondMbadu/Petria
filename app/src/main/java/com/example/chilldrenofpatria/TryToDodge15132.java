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

public class TryToDodge15132 extends AppCompatActivity implements View.OnClickListener {


    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);
        if(dbHandler.getLastClass(1).equalsIgnoreCase("SitAndWait")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"TryToDodge15132","SitAndWait");
        }
        else if(dbHandler.getLastClass(1).equalsIgnoreCase("SpeakToTheMan")) {
            dbHandler.updateChapter(1,dbHandler.getHealth(1),dbHandler.getSpell(1),"TryToDodge15132","SpeakToTheMan");
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_to_dodge15132);


        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollTryToDodge15132);
        String text = "Before you can react, his fist strikes your head. Falling to your knees, you try to put your hands to your head. There’s a pain in the back of your head. Your vision fades.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonGoBackCheckPoint = findViewById(R.id.button_GoBackCheckpoint);
        Button buttonRestartChapter = findViewById(R.id.button_RestartChapter);


        // when the button is clicked
        //15.1.1.4
        buttonGoBackCheckPoint.setOnClickListener(this);
        buttonRestartChapter.setOnClickListener(this);
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
        switch (item.getItemId()) {
            case R.id.goback:
                intent = new Intent(this, Book1Activity.class).putExtra("from", "TryToDodge15132");
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
                intent= new Intent(this, DoleKakawContinue.class);
                startActivity(intent);
                break;
        }


        return true;
    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.button_GoBackCheckpoint:
                //15.1.1.6
                intent = new Intent(this, DoleKakawContinue.class).putExtra("from", "TryToDodge15132");
                startActivity(intent);
                break;

            case R.id.button_RestartChapter:
                intent = new Intent(this, Chapter1Activity.class).putExtra("from", "TryToDodge15132");
                dbHandler.deleteChapterContent();
                startActivity(intent);

                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "TryToDodge15132");
        startActivity(intent);

    }

}
