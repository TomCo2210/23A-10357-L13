package com.example.a23a_10357_l13;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;

import java.util.Random;

public class DayView extends FrameLayout {

    public static final int DEFAULT_AMOUNT_OF_SECTIONS = 24;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private int orientation = HORIZONTAL;
    private int sections = DEFAULT_AMOUNT_OF_SECTIONS;


    public DayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public DayView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.DayView);
        orientation = typedArray.getInt(R.styleable.DayView_orientation,DayView.HORIZONTAL);
        sections = typedArray.getInt(R.styleable.DayView_sections,DayView.DEFAULT_AMOUNT_OF_SECTIONS);
        typedArray.recycle();

        setBackgroundColor(Color.parseColor("#FF6200EE"));
        LinearLayoutCompat linearLayoutCompat = new LinearLayoutCompat(context);
        linearLayoutCompat.setBackgroundColor(Color.parseColor("#FF03DAC5"));
        linearLayoutCompat.setOrientation(orientation == DayView.HORIZONTAL?
                LinearLayoutCompat.HORIZONTAL:
                LinearLayoutCompat.VERTICAL);

        for (int i = 0; i < sections; i++) {
            View view = new View(context);
            LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(
                    orientation == DayView.HORIZONTAL ? 0 : MATCH_PARENT,
                    orientation == DayView.HORIZONTAL ? MATCH_PARENT : 0
            );
            params.weight = 1;
            view.setLayoutParams(params);
            view.setBackgroundColor(Color.rgb(new Random().nextInt(256),new Random().nextInt(256),new Random().nextInt(256)));
            linearLayoutCompat.addView(view);
        }

        addView(linearLayoutCompat);
    }

}
