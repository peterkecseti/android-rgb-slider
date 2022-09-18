package com.szorgalmi.rgbslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.slider.Slider;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private TextView textView;
    private TextView rectangleRGB;
    private Slider sliderR;
    private Slider sliderG;
    private Slider sliderB;
    private double r = 0;
    private double g = 0;
    private double b = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        sliderR.addOnChangeListener(new Slider.OnChangeListener(){

            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
            r = sliderR.getValue();
            updateData();
            }
        });
        sliderG.addOnChangeListener(new Slider.OnChangeListener(){

            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                g = sliderG.getValue();
                updateData();
            }
        });
        sliderB.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                b = sliderB.getValue();
                updateData();
            }
        });

    }
    private void init(){
    relativeLayout = findViewById(R.id.RelativeLayout);
    textView = findViewById(R.id.TextViewRGB);
    sliderR = findViewById(R.id.SliderColorR);
    sliderG = findViewById(R.id.SliderColorG);
    sliderB = findViewById(R.id.SliderColorB);
    rectangleRGB = findViewById(R.id.ColorRectangle);

    }

    private void updateData(){
        rectangleRGB.setBackgroundColor(Color.rgb((int)r, (int)g, (int)b));
        textView.setText("Red: " + (int)r + "\nGreen: " + (int)g + "\nBlue: " + (int)b);
        rectangleRGB.setText("(" + (int)r + ", " + (int)g + ", " + (int)b + ")");
    }
}