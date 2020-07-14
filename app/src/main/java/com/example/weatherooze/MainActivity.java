package com.example.weatherooze;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
ImageView img1, img2;
TextView heyTxt, greetingTxt, titleTxt, sloganTxt;
Animation topAnim, leftAnim, rightAnim, fade, fade_img;
LinearLayout weatherIconCon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(44, 49, 172));
        setContentView(R.layout.activity_main);

        Calendar calendar = Calendar.getInstance();

        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);


        topAnim = AnimationUtils.loadAnimation(this,R.anim.to_animation);
        fade_img = AnimationUtils.loadAnimation(this,R.anim.fadeimg);
        leftAnim = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        rightAnim = AnimationUtils.loadAnimation(this,R.anim.lefttoright);
        fade = AnimationUtils.loadAnimation(this,R.anim.fadein);

        img1 = findViewById(R.id.image1);
        img2 = findViewById(R.id.image2);
        weatherIconCon = findViewById(R.id.weather_icon);
        heyTxt = findViewById(R.id.hey_txt);
       greetingTxt = findViewById(R.id.time_of_day);
       titleTxt = findViewById(R.id.title_txt);
       sloganTxt = findViewById(R.id.slogan_txt);

       img1.setAnimation(fade_img);
       img2.setAnimation(rightAnim);
       weatherIconCon.setAnimation(fade);
       heyTxt.setAnimation(fade);
        greetingTxt.setAnimation(fade);
        titleTxt.setAnimation(fade);
        sloganTxt.setAnimation(fade);


        if (timeOfDay >= 0 && timeOfDay < 12){
            weatherIconCon.setBackground(getDrawable(R.drawable.icons_sun));
            greetingTxt.setText(getString(R.string.greeting));
        }else if(timeOfDay >= 12 && timeOfDay < 16){
            weatherIconCon.setBackground(getDrawable(R.drawable.icons_sun));
            greetingTxt.setText(getString(R.string.afternoon));
        }else if(timeOfDay >= 16 && timeOfDay < 24){
            weatherIconCon.setBackground(getDrawable(R.drawable.icons_night_landscape));
            greetingTxt.setText(getString(R.string.evening));
        }
    }
}