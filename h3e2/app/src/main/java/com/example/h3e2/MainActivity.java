package com.example.h3e2;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.TypeEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//R.color.colorAccent,R.color.colorPrimary
        final ImageView imv=findViewById(R.id.imageView);
        ObjectAnimator anim1= ObjectAnimator.ofInt(imv, "backgroundColor",getResources().getColor(R.color.colorAccent),getResources().getColor(R.color.colorPrimary));
        //getResources().getColor(R.color.colorAccent);getResources().getColor(R.color.colorPrimary);
        anim1.setDuration(100000);//播放时长
        anim1.setRepeatCount(ValueAnimator.INFINITE);//重放次数
        anim1.setRepeatMode(ValueAnimator.REVERSE);
        anim1.start();
        final Animation anim=AnimationUtils.loadAnimation(this, R.anim.anim_set);
        imv.startAnimation(anim);
        final EditText et=findViewById(R.id.editTextNumber2);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                anim.setDuration(Long.parseLong(et.getText().toString()));
                Log.i("mytag", "afterTextChanged: "+et.getText().toString());
                imv.startAnimation(anim);
            }
        });
        /*ValueAnimator anim=ValueAnimator.ofInt(R.color.colorAccent,R.color.colorPrimary);
        anim.setDuration(5000);//播放时长
        anim.setRepeatCount(ValueAnimator.INFINITE);//重放次数
        anim.setRepeatMode(ValueAnimator.RESTART);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                //获取改变后的值
                int currentValue = (int) animation.getAnimatedValue();
                //输出改变后的值
                Log.d("mytag", "onAnimationUpdate: " + currentValue);
                ImageView imv=findViewById(R.id.imageView);
                //改变后的值发赋值给对象的属性值
                imv.setBackgroundColor(currentValue);

                //刷新视图
                imv.requestLayout();
            }
        });
        //启动动画
        anim.start();
         */
    }
}