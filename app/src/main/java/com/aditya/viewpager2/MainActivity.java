package com.aditya.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ViewPager2 imageContainer;
    SliderAdapter sliderAdapter;
    LinearLayout dotContainer;
    int list[];
    TextView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageContainer = findViewById(R.id.image_container);
        dotContainer = findViewById(R.id.dots_container);

        dots = new TextView[5];

        list = new int[5];
        list[0]= getResources().getColor(R.color.BLack);
        list[1]= getResources().getColor(R.color.Yellow);
        list[2]= getResources().getColor(R.color.Orange);
        list[3]= getResources().getColor(R.color.Green);
        list[4]= getResources().getColor(R.color.Blue);

        sliderAdapter = new SliderAdapter(list,MainActivity.this);
        imageContainer.setAdapter(sliderAdapter);

        setIndicator();

        imageContainer.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                selectedDots(position);
                super.onPageSelected(position);
            }
        });
    }

    private void selectedDots(int position) {
        for(int i=0;i<dots.length;i++){
            if(i==position){
                dots[i].setTextColor(list[position]);
            }
            else{
                dots[i].setTextColor(getResources().getColor(R.color.Grey));
            }
        }
    }

    private void setIndicator() {
        for(int i=0;i<dots.length;i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            dotContainer.addView(dots[i]);
        }
    }
}
