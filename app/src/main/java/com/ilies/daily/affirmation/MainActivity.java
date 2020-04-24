package com.ilies.daily.affirmation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    TextView adsinfo;
    ViewPager viewPager;
    SlideAdapter myadapter;
    public MediaPlayer mediaPlayer;
    boolean musicStat;

    TextView musictxt;
    ImageView musicimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: 4/24/20 send Notifications ; 
        
        //music
        musicStat = true;
        musicimg = findViewById(R.id.musicimg);
        musictxt = findViewById(R.id.musictxt);
        music_fnc();
        //page Viwer :
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        myadapter = new SlideAdapter(this);
        viewPager.setAdapter(myadapter);
        //page Viwer :


        adsinfo = findViewById(R.id.adsinfo);
        adsinfo.setVisibility(View.GONE);


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-8413340411601992/1920275819");

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        mAdView.setVisibility(View.GONE);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                adsinfo.setVisibility(View.VISIBLE);
                mAdView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                AdRequest adRequest = new AdRequest.Builder().build();
                mAdView.loadAd(adRequest);
                adsinfo.setVisibility(View.GONE);
                mAdView.setVisibility(View.GONE);

            }

        });
    }

    public void category(View view) {
        Toast.makeText(this, "توكيدات ايجابية ", Toast.LENGTH_SHORT).show();
    }

    public void alarm(View view) {
        Toast.makeText(this, "ميزة التنبيهات غير متوفرة في النسخة الحاليا ", Toast.LENGTH_LONG).show();

    }

    public void musicbtn(View view) {
        music_fnc();
    }

    public void navigation(View view) {
        CustomDialogClasstimer cdd=new CustomDialogClasstimer(MainActivity.this);
        cdd.show();

    }

    public void playMusic()
    {

        musicStat = true;
        mediaPlayer = MediaPlayer.create(this,R.raw.bgsond);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }
    public void pauseMusic()
    {
        try {
            mediaPlayer.reset();
            mediaPlayer.prepare();
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        musicStat = false;
    }
    public void music_fnc()
    {
        if (!musicStat)
        {
            playMusic();
            musicimg.setImageResource(R.drawable.musicoff);
            musictxt.setText("توقيف");

        }else{
            pauseMusic();
            musicimg.setImageResource(R.drawable.musicon);
            musictxt.setText("تشغيل");
        }
    }
}
