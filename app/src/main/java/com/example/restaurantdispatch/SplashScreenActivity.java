package com.example.restaurantdispatch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.restaurantdispatch.AllOrders.MainActivity;

public class SplashScreenActivity extends AppCompatActivity {

    Animation fromBottom;
    Animation rotateCrown;

    private AppCompatImageView crownImageView;
    private AppCompatImageView nameImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        fromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom);
        rotateCrown = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);

        crownImageView = findViewById(R.id.launcherLogoImageCrown);
        nameImageView = findViewById(R.id.launcherLogoImageName);

        crownImageView.setAnimation(rotateCrown);
        nameImageView.setAnimation(fromBottom);
        startNext();
    }

    private void startNext() {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }, 3000);
    }
}
