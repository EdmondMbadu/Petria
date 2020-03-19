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

public class TryToDodge extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    Chapter1Activity sch1;
    DBHandler dbHandler;

    //15.1.1.5
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1),"TryToDodge" ,"ForceBolt");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_to_dodge);



        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
        sch1 = new Chapter1Activity();
        textViewChapter1.setTextSize(15);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textViewChapter1.setText(Html.fromHtml("Health: "+dbHandler.getHealth(1)+" Spell Slots: "+dbHandler.getSpell(1)+"<sup><small>1st<small><sup>"));

        TextView textView = (TextView) findViewById(R.id.text_scrollTryToDodge);
        String text = "Shifting your feet, you keep the blade from cutting you, but his elbow strikes your head. Falling backward on the floor, you look up at the man. Blood stains his shirt. He raises his sword.\n";
        textView.setText(sch1.Format(text), TextView.BufferType.SPANNABLE);

        // if the button on Go to town hall continue
        // is clicked, go to the meet 5 intent
        Button buttonForceBolt8 = findViewById(R.id.button_forceBolt8);
        Button buttonforceStrike9 = findViewById(R.id.button_ForceStrike9);


        // when the button is clicked
        //15.1.1.4
        buttonForceBolt8.setOnClickListener(this);
        buttonforceStrike9.setOnClickListener(this);
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
                intent = new Intent(this, Book1Activity.class).putExtra("from", "TryToDodge");
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
            case R.id.button_forceBolt8:
                //15.1.1.6
                intent = new Intent(this, ForceBolt8.class).putExtra("from", "TryToDodge");
                startActivity(intent);

                break;
            case R.id.button_ForceStrike9:

                if(dbHandler.getSpell(1)<=0){
                    Toast.makeText(this, "You do not have enough spell slot!", Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(this, "You have 1 spell slot!", Toast.LENGTH_SHORT).show();

                    dbHandler.updateChapter(1, dbHandler.getHealth(1), dbHandler.getSpell(1)-1,"TryToDodge" ,"ForceBolt");

                    intent = new Intent(this, ForceStrike9.class).putExtra("from", "TryToDodge");
                    startActivity(intent);
                }
                break;


        }

    }

    // if the button back button pressed
    public void onBackPressed() {
        // if the back button is pressed, the home activity is summoned

        intent = new Intent(this, Book1Activity.class).putExtra("from", "TryToDodge");
        startActivity(intent);

    }

}
