package com.example.chilldrenofpatria;

import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ComponentActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Book1Activity extends AppCompatActivity implements View.OnClickListener {


    Intent intent;
    DBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbHandler = new DBHandler(this, null);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book1);
        // this is a tricky line of code. Be wary
        // we need to check that both the first and second activity are Main activity and Home activity
        // if it is not, then do not add  this hierarchy
        if(dbHandler.getLastClass(1).equalsIgnoreCase("HomeActivity")&&dbHandler.getBeforeLast(1).equalsIgnoreCase("MainActivity")){
            dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
        }
        if(dbHandler.getLastClass2(1).equalsIgnoreCase("HomeActivity")&&dbHandler.getBeforeLast2(1).equalsIgnoreCase("MainActivity")){
            dbHandler.updateChapter2(1,5,2,"Book1Activity","HomeActivity");
        }


//        dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");

        Toolbar toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textViewChapter1=findViewById(R.id.toolbar_textview);
        setTitle("Book of Bennet Baker");



        toolbar.setBackgroundColor((Color.parseColor("#262626")));
        // to make the back arrow available (do not forget to go to manifest to set the parent of the activity)
//        getSupportActionBar().setTitle("The Book of Bennett Baker");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // Not working


        // Implement the Onclick listener so that only one method will take care of everything
        Button buttonChapter1 = findViewById(R.id.button_chapter1);
        Button buttonChapter2 = findViewById(R.id.button_chapter2);
        Button buttonChapter3 = findViewById(R.id.button_chapter3);

        buttonChapter1.setOnClickListener(this);
        buttonChapter2.setOnClickListener(this);
        buttonChapter3.setOnClickListener(this);


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_book1, menu);
        MenuItem menuItem1=menu.findItem(R.id.action_lastCheckPoint);
        MenuItem menuItem2=menu.findItem(R.id.action_startChapterOver);
        menuItem1.setVisible(false);
        menuItem2.setVisible(false);
        return true;
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.button_chapter1:
                if(dbHandler.getLastClass(1).equalsIgnoreCase("HomeActivity")) {
                    intent = new Intent(this, Chapter1Activity.class);
                    startActivity(intent);
                }
                else if(dbHandler.getLastClass(1).equalsIgnoreCase("Book1Activity")) {
                    intent = new Intent(this, Chapter1Activity.class);
                    startActivity(intent);
                }
                else if(dbHandler.getLastClass(1).equalsIgnoreCase("Chapter1Activity")) {
                    intent = new Intent(this, Chapter1Activity.class);
                    startActivity(intent);
                }

                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("CastDancingLights")) {
                    intent = new Intent(this, CastDancingLights.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("CastDancingLightsContinue")) {
                    intent = new Intent(this, CastDancingLightsContinue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("Chapter1Contiinue")) {
                    intent = new Intent(this, Chapter1Contiinue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("CheckTheBody")) {
                    intent = new Intent(this, CheckTheBody.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("CheckTheBody1612")) {
                    intent = new Intent(this, CheckTheBody1612.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("CheckTheBody1612Continue")) {
                    intent = new Intent(this, CheckTheBody1612Continue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("DancingLights")) {
                    intent = new Intent(this, DancingLights.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("DoleKakaw")) {
                    intent = new Intent(this, DoleKakaw.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("DoleKakawContinue")) {
                    intent = new Intent(this, DoleKakawContinue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("DoNothing")) {
                    intent = new Intent(this, DoNothing.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowHer")) {
                    intent = new Intent(this, FollowHer.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLight")) {
                    intent = new Intent(this, FollowTheLight.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLIght1611")) {
                    intent = new Intent(this, FollowTheLIght1611.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLight1611Continue")) {
                    intent = new Intent(this, FollowTheLight1611Continue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("FollowTheLightAgain")) {
                    intent = new Intent(this, FollowTheLightAgain.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt")) {
                    intent = new Intent(this, ForceBolt.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt6")) {
                    intent = new Intent(this, ForceBolt6.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt8")) {
                    intent = new Intent(this, ForceBolt8.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBolt201")) {
                    intent = new Intent(this, ForceBolt201.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceBotCantrip")) {
                    intent = new Intent(this, ForceBotCantrip.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceStrike")) {
                    intent = new Intent(this, ForceStrike.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceStrike2")) {
                    intent = new Intent(this, ForceStrike2.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceStrike9")) {
                    intent = new Intent(this, ForceStrike9.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ForceStrike202")) {
                    intent = new Intent(this, ForceStrike202.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("forceStrikeBolt")) {
                    intent = new Intent(this, forceStrikeBolt.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("GoToSleep")) {
                    intent = new Intent(this, GoToSleep.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("GoToTownHall")) {
                    intent = new Intent(this, GoToTownHall.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("GoToTownHallContinue")) {
                    intent = new Intent(this, GoToTownHallContinue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("HelpMeeNoone")) {
                    intent = new Intent(this, HelpMeeNoone.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("KillSomeone")) {
                    intent = new Intent(this, KillSomeone.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("Meet_5")) {
                    intent = new Intent(this, Meet_5.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("NO")) {
                    intent = new Intent(this, NO.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ReachWithShield15131")) {
                    intent = new Intent(this, ReachWithShield15131.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("ReactWithShield")) {
                    intent = new Intent(this, ReactWithShield.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("RunOutAndSee")) {
                    intent = new Intent(this, RunOutAndSee.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("SitAndWait")) {
                    intent = new Intent(this, SitAndWait.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("SpeakToTheMan")) {
                    intent = new Intent(this, SpeakToTheMan.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("StayAndWatchBakery")) {
                    intent = new Intent(this, StayAndWatchBakery.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("StayAndWatchBakeryContinue")) {
                    intent = new Intent(this, StayAndWatchBakeryContinue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("StayInBed")) {
                    intent = new Intent(this, StayInBed.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("StayInTheCover")) {
                    intent = new Intent(this, StayInTheCover.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("StayInTheCoverContinue")) {
                    intent = new Intent(this, StayInTheCoverContinue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("TryToDodge")) {
                    intent = new Intent(this, TryToDodge.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("TryToDodge15132")) {
                    intent = new Intent(this, TryToDodge15132.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("TryToRunOut")) {
                    intent = new Intent(this, TryToRunOut.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("TryToSpeakToHim")) {
                    intent = new Intent(this, TryToSpeakToHim.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("WhatDoYouWantFromME")) {
                    intent = new Intent(this, WhatDoYouWantFromME.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("WhatIsThat")) {
                    intent = new Intent(this, WhatIsThat.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("WhatIsThatContinue")) {
                    intent = new Intent(this, WhatIsThatContinue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("WhoAreYou")) {
                    intent = new Intent(this, WhoAreYou.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("WhoAreYouContinue")) {
                    intent = new Intent(this, WhoAreYouContinue.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("WhyAreYouHelping")) {
                    intent = new Intent(this, WhyAreYouHelping.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("YesIDo")) {
                    intent = new Intent(this, YesIDo.class);
                    startActivity(intent);
                }
                else  if(dbHandler.getLastClass(1).equalsIgnoreCase("YesIDoContinue")) {
                    intent = new Intent(this, YesIDoContinue.class);
                    startActivity(intent);
                }
                // if all these cases do not work, go to chapter1 activity
//                intent = new Intent(this, Chapter1Activity.class);
//                startActivity(intent);
                break;
            case R.id.button_chapter2:
                // first check if the user has finished reading the first chapter
                if(dbHandler.getStatusChapter1(1)<=0){
                    Toast.makeText(this, "Finish Chapter 1 first!", Toast.LENGTH_SHORT).show();
                } else {
                    if(dbHandler.getLastClass2(1).equalsIgnoreCase("Book1Activity")) {
                        intent = new Intent(this, C2_1.class);
                        startActivity(intent);
                    }

                   else  if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_1")) {
                        intent = new Intent(this, C2_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_2")) {
                        intent = new Intent(this, C2_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_3_1")) {
                        intent = new Intent(this, C2_3_1.class);
                        startActivity(intent);
                    }

                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_3_2")) {
                        intent = new Intent(this, C2_3_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_3_3")) {
                        intent = new Intent(this, C2_3_3.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_4_1")) {
                        intent = new Intent(this, C2_4_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_4_2")) {
                        intent = new Intent(this, C2_4_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_5_1")) {
                        intent = new Intent(this, C2_5_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_5_2")) {
                        intent = new Intent(this, C2_5_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_6_1")) {
                        intent = new Intent(this, C2_6_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_7_1")) {
                        intent = new Intent(this, C2_7_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_8_1")) {
                        intent = new Intent(this, C2_8_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_9_1")) {
                        intent = new Intent(this, C2_9_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_9_2")) {
                        intent = new Intent(this, C2_9_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_9_3")) {
                        intent = new Intent(this, C2_9_3.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_9_4")) {
                        intent = new Intent(this, C2_9_4.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_10_1")) {
                        intent = new Intent(this, C2_10_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_11_1")) {
                        intent = new Intent(this, C2_11_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_12_1")) {
                        intent = new Intent(this, C2_12_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_13_1")) {
                        intent = new Intent(this, C2_13_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_14_1")) {
                        intent = new Intent(this, C2_14_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_14_2")) {
                        intent = new Intent(this, C2_14_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_14_3")) {
                        intent = new Intent(this, C2_14_3.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_14_4")) {
                        intent = new Intent(this, C2_14_4.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_14_5")) {
                        intent = new Intent(this, C2_14_5.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_14_6")) {
                        intent = new Intent(this, C2_14_6.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_14_7")) {
                        intent = new Intent(this, C2_14_7.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_14_8")) {
                        intent = new Intent(this, C2_14_8.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_15_1")) {
                        intent = new Intent(this, C2_15_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_16_1")) {
                        intent = new Intent(this, C2_16_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_17_1")) {
                        intent = new Intent(this, C2_17_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_17_2")) {
                        intent = new Intent(this, C2_17_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_18_1")) {
                        intent = new Intent(this, C2_18_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_18_2")) {
                        intent = new Intent(this, C2_18_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_18_3")) {
                        intent = new Intent(this, C2_18_3.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_18_4")) {
                        intent = new Intent(this, C2_18_4.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_18_5")) {
                        intent = new Intent(this, C2_18_5.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_19_1")) {
                        intent = new Intent(this, C2_19_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_20_1")) {
                        intent = new Intent(this, C2_20_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_21_1")) {
                        intent = new Intent(this, C2_21_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_22_1")) {
                        intent = new Intent(this, C2_22_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_23_1")) {
                        intent = new Intent(this, C2_23_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_23_2")) {
                        intent = new Intent(this, C2_23_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_1")) {
                        intent = new Intent(this, C2_24_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_2")) {
                        intent = new Intent(this, C2_24_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_3")) {
                        intent = new Intent(this, C2_24_2.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_4")) {
                        intent = new Intent(this, C2_24_4.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_5")) {
                        intent = new Intent(this, C2_24_5.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_6")) {
                        intent = new Intent(this, C2_24_6.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_7")) {
                        intent = new Intent(this, C2_24_7.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_8")) {
                        intent = new Intent(this, C2_24_8.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_9")) {
                        intent = new Intent(this, C2_24_9.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_10")) {
                        intent = new Intent(this, C2_24_10.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_11")) {
                        intent = new Intent(this, C2_24_11.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_12")) {
                        intent = new Intent(this, C2_24_12.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_13")) {
                        intent = new Intent(this, C2_24_13.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_14")) {
                        intent = new Intent(this, C2_24_14.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_15")) {
                        intent = new Intent(this, C2_24_15.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_16")) {
                        intent = new Intent(this, C2_24_16.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_17")) {
                        intent = new Intent(this, C2_24_17.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_18")) {
                        intent = new Intent(this, C2_24_18.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_19")) {
                        intent = new Intent(this, C2_24_19.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_20")) {
                        intent = new Intent(this, C2_24_20.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_21")) {
                        intent = new Intent(this, C2_24_21.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_22")) {
                        intent = new Intent(this, C2_24_22.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_23")) {
                        intent = new Intent(this, C2_24_23.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_24")) {
                        intent = new Intent(this, C2_24_24.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_25")) {
                        intent = new Intent(this, C2_24_25.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_26")) {
                        intent = new Intent(this, C2_24_26.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_24_27")) {
                        intent = new Intent(this, C2_24_27.class);
                        startActivity(intent);
                    }else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_25_1")) {
                        intent = new Intent(this, C2_25_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_26_1")) {
                        intent = new Intent(this, C2_26_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_27_1")) {
                        intent = new Intent(this, C2_27_1.class);
                        startActivity(intent);
                    }
                    else if(dbHandler.getLastClass2(1).equalsIgnoreCase("C2_28_1")) {
                        intent = new Intent(this, C2_28_1.class);
                        startActivity(intent);
                    }







                }
                break;
            case R.id.button_chapter3:
                Toast.makeText(this, "Coming very soon!", Toast.LENGTH_SHORT).show();
                break;


        }
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()){
            case R.id.goback:
                intent= new Intent(this, HomeActivity.class);
                startActivity(intent);
                break;
            case R.id.action_startChapterOver:
                dbHandler.deleteChapterContent();
                dbHandler.addChapter(5, 2, "MainActivity", "");
                dbHandler.updateChapter(1,5,2,"Book1Activity","HomeActivity");
                intent= new Intent(this, Book1Activity.class);
                break;
        }



        return true;
    }
    public void onBackPressed(){
        // if the back button is pressed more than once, at the home activity
        // get out of the screen
        intent= new Intent(this, HomeActivity.class);
        startActivity(intent);


    }

    public void findLastChoice(String last){
        if(last.equalsIgnoreCase("HomeActivity")) {
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        else if(last.equalsIgnoreCase("Book1Activity")) {
            intent = new Intent(this, Book1Activity.class);
            startActivity(intent);
        }
        else if(last.equalsIgnoreCase("Chapter1Activity")) {
            intent = new Intent(this, Chapter1Activity.class);
            startActivity(intent);
        }

        else  if(dbHandler.getLastClass(1).equalsIgnoreCase("CastDancingLights")) {
            intent = new Intent(this, CastDancingLights.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("CastDancingLightsContinue")) {
            intent = new Intent(this, CastDancingLightsContinue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("Chapter1Contiinue")) {
            intent = new Intent(this, Chapter1Contiinue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("CheckTheBody")) {
            intent = new Intent(this, CheckTheBody.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("CheckTheBody1612")) {
            intent = new Intent(this, CheckTheBody1612.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("CheckTheBody1612Continue")) {
            intent = new Intent(this, CheckTheBody1612Continue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("DancingLights")) {
            intent = new Intent(this, DancingLights.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("DoleKakaw")) {
            intent = new Intent(this, DoleKakaw.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("DoleKakawContinue")) {
            intent = new Intent(this, DoleKakawContinue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("DoNothing")) {
            intent = new Intent(this, DoNothing.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("FollowHer")) {
            intent = new Intent(this, FollowHer.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("FollowTheLight")) {
            intent = new Intent(this, FollowTheLight.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("FollowTheLIght1611")) {
            intent = new Intent(this, FollowTheLIght1611.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("FollowTheLight1611Continue")) {
            intent = new Intent(this, FollowTheLight1611Continue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("FollowTheLightAgain")) {
            intent = new Intent(this, FollowTheLightAgain.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceBolt")) {
            intent = new Intent(this, ForceBolt.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceBolt6")) {
            intent = new Intent(this, ForceBolt6.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceBolt8")) {
            intent = new Intent(this, ForceBolt8.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceBolt201")) {
            intent = new Intent(this, ForceBolt201.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceBotCantrip")) {
            intent = new Intent(this, ForceBotCantrip.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceStrike")) {
            intent = new Intent(this, ForceStrike.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceStrike2")) {
            intent = new Intent(this, ForceStrike2.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceStrike9")) {
            intent = new Intent(this, ForceStrike9.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ForceStrike202")) {
            intent = new Intent(this, ForceStrike202.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("forceStrikeBolt")) {
            intent = new Intent(this, forceStrikeBolt.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("GoToSleep")) {
            intent = new Intent(this, GoToSleep.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("GoToTownHall")) {
            intent = new Intent(this, GoToTownHall.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("GoToTownHallContinue")) {
            intent = new Intent(this, GoToTownHallContinue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("HelpMeeNoone")) {
            intent = new Intent(this, HelpMeeNoone.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("KillSomeone")) {
            intent = new Intent(this, KillSomeone.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("Meet_5")) {
            intent = new Intent(this, Meet_5.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("NO")) {
            intent = new Intent(this, NO.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ReachWithShield15131")) {
            intent = new Intent(this, ReachWithShield15131.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("ReactWithShield")) {
            intent = new Intent(this, ReactWithShield.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("RunOutAndSee")) {
            intent = new Intent(this, RunOutAndSee.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("SitAndWait")) {
            intent = new Intent(this, SitAndWait.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("SpeakToTheMan")) {
            intent = new Intent(this, SpeakToTheMan.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("StayAndWatchBakery")) {
            intent = new Intent(this, StayAndWatchBakery.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("StayAndWatchBakeryContinue")) {
            intent = new Intent(this, StayAndWatchBakeryContinue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("StayInBed")) {
            intent = new Intent(this, StayInBed.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("StayInTheCover")) {
            intent = new Intent(this, StayInTheCover.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("StayInTheCoverContinue")) {
            intent = new Intent(this, StayInTheCoverContinue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("TryToDodge")) {
            intent = new Intent(this, TryToDodge.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("TryToDodge15132")) {
            intent = new Intent(this, TryToDodge15132.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("TryToRunOut")) {
            intent = new Intent(this, TryToRunOut.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("TryToSpeakToHim")) {
            intent = new Intent(this, TryToSpeakToHim.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("WhatDoYouWantFromME")) {
            intent = new Intent(this, WhatDoYouWantFromME.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("WhatIsThat")) {
            intent = new Intent(this, WhatIsThat.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("WhatIsThatContinue")) {
            intent = new Intent(this, WhatIsThatContinue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("WhoAreYou")) {
            intent = new Intent(this, WhoAreYou.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("WhoAreYouContinue")) {
            intent = new Intent(this, WhoAreYouContinue.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("WhyAreYouHelping")) {
            intent = new Intent(this, WhyAreYouHelping.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("YesIDo")) {
            intent = new Intent(this, YesIDo.class);
            startActivity(intent);
        }
        else  if(last.equalsIgnoreCase("YesIDoContinue")) {
            intent = new Intent(this, YesIDoContinue.class);
            startActivity(intent);
        }

    }





}
