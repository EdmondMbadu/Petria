package com.example.chilldrenofpatria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


// we implemented OnclickListener so that  only one method handles
// all the buttons.
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    int backButtonCount;
    DBHandler dbHandler;


    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);


//        dbHandler.updateChapter(1,5,2,"HomeActivity","MainActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Give the buttons functionality.
        Button button1 = findViewById(R.id.button_book1);
        Button button2 = findViewById(R.id.button_book2);
        Button button3 = findViewById(R.id.button_book3);


        // if button 1, 2, 3 is click
        // the listener will call initiate the Onclick method
        // and apply the transformation
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_book1:
                //this for  chatper 1 if the last class is main activity
                if(dbHandler.getLastClass(1).equalsIgnoreCase("MainActivity")){
                dbHandler.updateChapter(1,5,2,"HomeActivity","MainActivity");

            }
                // this is for before chapter 2
                if(dbHandler.getLastClass2(1).equalsIgnoreCase("MainActivity")){
                    dbHandler.updateChapter2(1,7,2,"HomeActivity","MainActivity");

                }

                intent = new Intent(this, Book1Activity.class).putExtra("from", "Home");
                startActivity(intent);
                break;
            case R.id.button_book2:
                Toast.makeText(this, "Coming soon!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_book3:
                Toast.makeText(this, "Coming very soon!", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    /**
     * When the back button is pressed at the home activity, for the first time, display a toast saying that the second press
     * will exit the program
     * Later on,
     * Implement the back button for every activity so that when clicked the button behaves just like the back button on the menu bar
     */
    public void onBackPressed(){
        // if the back button is pressed more than once, at the home activity
        // get out of the screen
        if(backButtonCount >= 1)
        {
            // this is kind of obscure. I need to double ckeck the specification later
            //
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
    }




}
