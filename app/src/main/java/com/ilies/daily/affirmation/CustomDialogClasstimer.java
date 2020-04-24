package com.ilies.daily.affirmation;


import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

public class CustomDialogClasstimer extends Dialog implements
        View.OnClickListener {

    public Activity c;
    public Dialog d;
    public LinearLayout choice1,choice2,choice3;
    public Button close ;

    public CustomDialogClasstimer(Activity a) {
        super(a);
        // TODO Auto-generated constructor stub
        this.c = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_timer);

        close = (Button) findViewById(R.id.btn_close);
        choice1 = (LinearLayout) findViewById(R.id.choice1);
        choice2 = (LinearLayout) findViewById(R.id.choice2);
        choice3 = (LinearLayout) findViewById(R.id.choice3);

        close.setOnClickListener(this);
        choice1.setOnClickListener(this);
        choice2.setOnClickListener(this);
        choice3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.choice2:
                //
                //Toast.makeText(c, "15 min", Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse("market://details?id=" + getContext().getPackageName());
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                // To count with Play market backstack, After pressing back button,
                // to taken back to our application, we need to add following flags to intent.
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    c.startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    c.startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://play.google.com/store/apps/details?id=" + getContext().getPackageName())));
                }


                break;

            case R.id.choice1:
                Intent myIntent = new Intent(c, notepad.class);
                c.startActivity(myIntent);
                //
                //Toast.makeText(c, "30 min", Toast.LENGTH_SHORT).show();



                break;

            case R.id.choice3:
                //open Notepad :
                //Toast.makeText(c, "1 h", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "ilyasdzair1@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "تطبيق توكيدات يومية");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                c.startActivity(Intent.createChooser(intent, ""));
                break;

            case R.id.btn_close:
                //
                dismiss();
                break;

            default:
                break;
        }
        dismiss();
    }
}