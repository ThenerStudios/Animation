package com.thener.animation;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Welcome extends AppCompatActivity {

    Animation Updown, Downup, buttons;
    TextView welcome, designer, thenername;
    ImageView logo, thener;
    Button Mproceed;
    LinearLayout linearLayout;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Updown = AnimationUtils.loadAnimation(this, R.anim.updown);
        Downup = AnimationUtils.loadAnimation(this, R.anim.downtop);
        buttons = AnimationUtils.loadAnimation(this, R.anim.buttons);

        welcome = findViewById(R.id.Welcome);
        welcome.startAnimation(Updown);

        linearLayout = findViewById(R.id.poweredByAi);
        linearLayout.startAnimation(buttons);

        logo = findViewById(R.id.logo);
        logo.startAnimation(Updown);

        designer = findViewById(R.id.DesignedBy);
        designer.startAnimation(Downup);

        thenername = findViewById(R.id.thenername);
        thenername.startAnimation(Downup);

        thener = findViewById(R.id.ThenerLogo);
        thener.startAnimation(Downup);

        Mproceed = findViewById(R.id.Proceed);
        Mproceed.startAnimation(buttons);



    }
}
