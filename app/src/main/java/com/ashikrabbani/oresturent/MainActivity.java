package com.ashikrabbani.oresturent;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {


    TextView menu, mtv, btv, ftv, rtv, fitv, dtv;
    TextView mptv, bptv, fptv, rptv, fiptv, dptv;
    String choices = "";
    String prices, usd_price_string;
    double usd_price = 0;
    Button biriyani, Momos, fried, plain, firni, drinks;

    //removing button

    Button rm_biriyani, rm_momos, rm_fried, rm_firni, rm_plain, rm_drinks, order;

    int bp = 0, mp = 0, pp = 0, drp = 0, frp = 0, fip = 0;
    int tbp = 0, tmp = 0, tpp = 0, tdrp = 0, tfrp = 0, tfip = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = findViewById(R.id.menuTv);
        mtv = findViewById(R.id.momos_textView);
        btv = findViewById(R.id.biriyani_textView);
        ftv = findViewById(R.id.fried_textView);
        rtv = findViewById(R.id.plain_textView);
        fitv = findViewById(R.id.firni_textView);
        dtv = findViewById(R.id.drinks_textView);
//button of iteams add

        biriyani = (Button) findViewById(R.id.biriyani_button);
        Momos = (Button) findViewById(R.id.momos_button);
        fried = (Button) findViewById(R.id.fried_button);
        plain = (Button) findViewById(R.id.plain_button);
        firni = (Button) findViewById(R.id.firni_button);
        drinks = (Button) findViewById(R.id.drinks_button);

        // removing button identifing

        rm_biriyani = (Button) findViewById(R.id.biriyani_button_rm);
        rm_momos = (Button) findViewById(R.id.momos_button_rm);
        rm_fried = (Button) findViewById(R.id.fried_button_rm);
        rm_firni = (Button) findViewById(R.id.firni_button_rm);
        rm_plain = (Button) findViewById(R.id.plain_button_rm);
        rm_drinks = (Button) findViewById(R.id.drinks_button_rm);


        /// order Button

        order = (Button) findViewById(R.id.order_button);


        mptv = findViewById(R.id.momos_price);
        bptv = findViewById(R.id.biriyani_price);
        fptv = findViewById(R.id.fried_price);
        rptv = findViewById(R.id.plain_price);
        fiptv = findViewById(R.id.firni_price);
        dptv = findViewById(R.id.drinks_price);

        Typeface french_font = ResourcesCompat.getFont(this, R.font.french);
        Typeface gatholic = ResourcesCompat.getFont(this, R.font.gatholic);

        menu.setTypeface(french_font);

        mtv.setTypeface(french_font);
        btv.setTypeface(french_font);
        ftv.setTypeface(french_font);
        rtv.setTypeface(french_font);
        fitv.setTypeface(french_font);
        dtv.setTypeface(french_font);


        mptv.setTypeface(gatholic);
        bptv.setTypeface(gatholic);
        fptv.setTypeface(gatholic);
        rptv.setTypeface(gatholic);
        fiptv.setTypeface(gatholic);
        dptv.setTypeface(gatholic);

        // setting order button font

        order.setTypeface(gatholic);

    }


    public void place_order(View view) {

        balancesheet();
        Intent i = new Intent(MainActivity.this, orderDetails.class);
        Bundle bundle = new Bundle();
        bundle.putString("choice_iteams", choices);
        bundle.putString("bdt_price", prices);
        bundle.putString("usd_price", usd_price_string);
        i.putExtras(bundle);
        startActivity(i);
        choices = "";
    }


    public void add_to_list(View view) {
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //SharedPreferences.Editor editor = prefs.edit();


        if (view == findViewById(R.id.momos_button)) {
            Toast.makeText(this, "Momos Added", Toast.LENGTH_SHORT).show();
            mp = mp + 1;

            //choices = (choices+"\nHaleem\t (1) Bowl.").toString();

            Momos.setText(Integer.toString(mp));

        } else if (view == findViewById(R.id.biriyani_button)) {
            Toast.makeText(this, "Biriyani Added", Toast.LENGTH_SHORT).show();
            // = (choices+"\nBiriyani\t (1) plate.").toString();
            bp = bp + 1;

            biriyani.setText(Integer.toString(bp));

        } else if (view == findViewById(R.id.fried_button)) {
            Toast.makeText(this, "Fried Rice Added", Toast.LENGTH_SHORT).show();
            //choices = (choices+"\nTikkas\t (1) pieces.").toString();
            frp = frp + 1;
            fried.setText(Integer.toString(frp));

        } else if (view == findViewById(R.id.plain_button)) {
            Toast.makeText(this, "Rice Added", Toast.LENGTH_SHORT).show();
            //choices = (choices+"\nBiriyani\t (1) plate.").toString();
            pp = pp + 1;

            plain.setText(Integer.toString(pp));
        } else if (view == findViewById(R.id.firni_button)) {
            Toast.makeText(this, "Firni Added", Toast.LENGTH_SHORT).show();
            //choices = (choices+"\nTikkas\t (1) pieces.").toString();
            fip = fip + 1;

            firni.setText(Integer.toString(fip));
        } else if (view == findViewById(R.id.drinks_button)) {
            Toast.makeText(this, "Drinks Added", Toast.LENGTH_SHORT).show();
            // choices = (choices+"\nTikkas\t (1) pieces.").toString();

            drp = drp + 1;

            drinks.setText(Integer.toString(drp));
        }

    }

    // removing iteam

    public void rmv_from_list(View view) {
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //SharedPreferences.Editor editor = prefs.edit();


        if (view == findViewById(R.id.momos_button_rm)) {
            if (mp > 0) {

                mp = mp - 1;
                Momos.setText(Integer.toString(mp));
                Toast.makeText(this, "Momos Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Iteams First", Toast.LENGTH_SHORT).show();

            //choices = (choices+"\nHaleem\t (1) Bowl.").toString();

        } else if (view == findViewById(R.id.biriyani_button_rm)) {

            // = (choices+"\nBiriyani\t (1) plate.").toString();
            if (bp > 0) {
                bp = bp - 1;

                biriyani.setText(Integer.toString(bp));
                Toast.makeText(this, "Biriyani Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Iteams First", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.fried_button_rm)) {

            //choices = (choices+"\nTikkas\t (1) pieces.").toString();

            if (frp > 0) {

                frp = frp - 1;
                fried.setText(Integer.toString(frp));
                Toast.makeText(this, "Fried Rice Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Iteams First", Toast.LENGTH_SHORT).show();

        } else if (view == findViewById(R.id.plain_button_rm)) {

            //choices = (choices+"\nBiriyani\t (1) plate.").toString();
            if (pp > 0) {

                pp = pp - 1;
                plain.setText(Integer.toString(pp));
                Toast.makeText(this, "Rice Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Iteams First", Toast.LENGTH_SHORT).show();


        } else if (view == findViewById(R.id.firni_button_rm)) {

            //choices = (choices+"\nTikkas\t (1) pieces.").toString();
            if (fip > 0) {

                fip = fip - 1;
                firni.setText(Integer.toString(fip));
                Toast.makeText(this, "Firni Removed", Toast.LENGTH_SHORT).show();
            }
            Toast.makeText(this, "Add Iteams First", Toast.LENGTH_SHORT).show();


        } else if (view == findViewById(R.id.drinks_button_rm)) {

            // choices = (choices+"\nTikkas\t (1) pieces.").toString();
            if (drp > 0) {
                drp = drp - 1;
                drinks.setText(Integer.toString(drp));
                Toast.makeText(this, "Drinks Removed", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(this, "Add Iteams First", Toast.LENGTH_SHORT).show();

        }

    }

    public void balancesheet() {
        tbp = bp * 250;
        tdrp = drp * 35;
        tfip = fip * 50;
        tfrp = frp * 220;
        tmp = mp * 80;
        tpp = pp * 150;
        total = tbp + tdrp + tfip + tmp + tpp + tfrp;
        usd_price = total / 80;
        prices = Integer.toString(total);
        usd_price_string = Double.toString(usd_price);

        if (bp > 0) {
            choices = choices + "Biriyani       (" + bp + " x 250) = " + tbp;
        }

        if (drp > 0) {
            choices = choices + "\n\nCold Drinks  (" + drp + " x 35) = " + tdrp;
        }

        if (fip > 0) {
            choices = choices + "\n\nFirni      (" + fip + " x 50) = " + tfip;
        }

        if (frp > 0) {
            choices = choices + "\n\nFried Rice (" + frp + " x 220) = " + tfrp;
        }
        if (mp > 0) {
            choices = choices + "\n\nMomos     (" + mp + " x 80) = " + tmp;
        }

        if (pp > 0) {
            choices = choices + "\n\nRice       (" + pp + " x 150) = " + tpp;
        }


    }

    public void banner_about(View view) {

        final Dialog dialog = new Dialog(this); // Context, this, etc.
        dialog.setContentView(R.layout.about_dialogue);
        dialog.setTitle("About Canteen");
        dialog.show();



        final Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                dialog.dismiss(); // when the task active then close the dialog
                t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
            }
        }, 800000);
    }
}
