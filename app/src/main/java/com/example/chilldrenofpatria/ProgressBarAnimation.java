package com.example.chilldrenofpatria;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

// this class is for the animation that will happen in the loading page
public class ProgressBarAnimation extends Animation {

    Intent intent;
    private Context context;
    private ProgressBar progressBar;   // the progress bar
    private TextView textView;   // the text view which changes from 0 - 100
    private float from; // the lower bound of the progress bar
    private float to; // the upper bound of the progress bar


    /**
     * @param context
     * @param progressBar the progress bar
     * @param textView    the text view. It changes from 0 to 100
     * @param from        The lower bound of the progress bar
     * @param to          The upper bound of the progress bar
     *                    <p>
     *                    This is the constructor. It initializes all the parameter that will be used in the loading page
     */

    public ProgressBarAnimation(Context context, ProgressBar progressBar,
                                TextView textView, float from, float to) {
        this.context = context;
        this.progressBar = progressBar;
        this.textView = textView;
        this.from = from;
        this.to = to;

    }

    /**
     * @param interpolatedTime
     * @param t
     */
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        // This code is mainly to update the loading time ( in this case from 0 to 100 %)
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        progressBar.setProgress((int) value);
        textView.setText((int) value + " %");
        // once the value reach the end ( in this case 100%) go to another page ( in this case the home page)
        if (value == to) {
            context.startActivity(new Intent(context, TheConditions.class));

        }
    }




}
