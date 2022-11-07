package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class TestTab extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tab);

        LinearLayout aCustom=findViewById(R.id.customlayout);
        float[] radius1 = {20.0f, 20.0f, 20.0f, 20.0f, 20.0f,
                20.0f, 20.0f, 20.0f};
        GradientDrawable gd1 = new GradientDrawable();
        gd1.setShape(GradientDrawable.RECTANGLE);
        gd1.setColor(Color.parseColor("#009688"));
        gd1.setStroke(1, Color.parseColor("#009688"));
        gd1.setCornerRadii(radius1);
        aCustom.setBackground(gd1);

        TextView aViewone=findViewById(R.id.r1);
        TextView aViewTwo=findViewById(R.id.r2);
        TextView aViewThree=findViewById(R.id.r3);
        aViewTwo.setBackgroundColor(Color.parseColor("#FFFFFF"));
        aViewThree.setBackgroundColor(Color.parseColor("#FFFFFF"));
        aViewone.setTypeface(Typeface.DEFAULT_BOLD);

        aViewone.setTextColor(Color.parseColor("#FFFFFF"));
        aViewTwo.setTextColor(Color.parseColor("#696b6e"));
        aViewThree.setTextColor(Color.parseColor("#696b6e"));

        aViewone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aViewone.setBackgroundColor(Color.parseColor("#009688"));
                aViewTwo.setBackgroundColor(Color.parseColor("#FFFFFF"));
                aViewThree.setBackgroundColor(Color.parseColor("#FFFFFF"));
                aViewone.setTextColor(Color.parseColor("#FFFFFF"));
                aViewTwo.setTextColor(Color.parseColor("#000000"));
                aViewThree.setTextColor(Color.parseColor("#000000"));
                aViewone.setTypeface(Typeface.DEFAULT_BOLD);
                aViewTwo.setTypeface(Typeface.DEFAULT);
                aViewThree.setTypeface(Typeface.DEFAULT);
                aViewone.setTextColor(Color.parseColor("#FFFFFF"));
                aViewTwo.setTextColor(Color.parseColor("#696b6e"));
                aViewThree.setTextColor(Color.parseColor("#696b6e"));
            }
        });
        aViewTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aViewone.setBackgroundColor(Color.parseColor("#FFFFFF"));
                aViewTwo.setBackgroundColor(Color.parseColor("#009688"));
                aViewThree.setBackgroundColor(Color.parseColor("#FFFFFF"));
                aViewone.setTextColor(Color.parseColor("#000000"));
                aViewTwo.setTextColor(Color.parseColor("#FFFFFF"));
                aViewThree.setTextColor(Color.parseColor("#000000"));
                aViewone.setTypeface(Typeface.DEFAULT);
                aViewTwo.setTypeface(Typeface.DEFAULT_BOLD);
                aViewThree.setTypeface(Typeface.DEFAULT);
                aViewone.setTextColor(Color.parseColor("#696b6e"));
                aViewTwo.setTextColor(Color.parseColor("#FFFFFF"));
                aViewThree.setTextColor(Color.parseColor("#696b6e"));
            }
        });

        aViewThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aViewone.setBackgroundColor(Color.parseColor("#FFFFFF"));
                aViewTwo.setBackgroundColor(Color.parseColor("#FFFFFF"));
                aViewThree.setBackgroundColor(Color.parseColor("#009688"));
                aViewone.setTextColor(Color.parseColor("#000000"));
                aViewTwo.setTextColor(Color.parseColor("#000000"));
                aViewThree.setTextColor(Color.parseColor("#FFFFFF"));
                aViewone.setTypeface(Typeface.DEFAULT);
                aViewTwo.setTypeface(Typeface.DEFAULT);
                aViewThree.setTypeface(Typeface.DEFAULT_BOLD);
                aViewone.setTextColor(Color.parseColor("#696b6e"));
                aViewTwo.setTextColor(Color.parseColor("#696b6e"));
                aViewThree.setTextColor(Color.parseColor("#FFFFFF"));
            }
        });


        ((SegmentedGroup) findViewById(R.id.group_one)).setOnSegmentedGroupListener(new SegmentedGroup.OnSegmentedGroupListener() {
            @Override
            public void onSegmentedTabSelected(SegmentedTab tab, int checkedId) {
                Toast.makeText(TestTab.this, tab.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}