package com.example.chilldrenofpatria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TheConditions extends AppCompatActivity implements View.OnClickListener {

    Chapter1Activity sch1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_conditions);
//        TextView textViewChapter1 = findViewById(R.id.toolbar_textview);
//
//        textViewChapter1.setTextSize(15);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        textViewChapter1.setText(Html.fromHtml(""));

//        TextView textView = (TextView) findViewById(R.id.text_scrollTermsAndServices1);
//        String text = "Hey you, person of the human race! \n" +
//                "Thank you for downloading our app! This was a collaboration of myself, an aspiring writer, and my good friend, an aspiring coder, the last semester of our senior year in college. Other than two poorly paid editors and an artist friend who was kind enough to sketch us a few pictures this was entirely a two-man job from beginning to end! \n" +
//                "There is only one chapter as of right now, but we plan to release more content very soon. I sincerely hope you enjoy the experience, and if you do, it would mean a lot to us if you would leave a rating!\n" +
//                "Have Fun!!!\n";
//        textView.setText(text);
        TextView textView2 = (TextView) findViewById(R.id.text_scrollTermsAndServices2);
//        textView2.setText(Html.fromHtml(getResources().getString(R.string.term_serve)));
//
       textView2.setOnClickListener(this);

//        textView2.setOnClickListener(this);
//
        Button buttonTerm = findViewById(R.id.button_Conditions);


        // when the button is clicked

        buttonTerm.setOnClickListener(this);


    }

    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.button_Conditions:
                Toast.makeText(this, "Enjoy!", Toast.LENGTH_SHORT).show();
                intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.text_scrollTermsAndServices2:
                intent= new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.termsfeed.com/terms-conditions/1d476b9e9b647fc4039a28bf4b80343b"));
                startActivity(intent);
                break;




        }

    }
    public void clicked(String uri){
        intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);


    }

}