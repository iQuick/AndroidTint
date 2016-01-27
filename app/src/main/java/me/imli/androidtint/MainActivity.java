package me.imli.androidtint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;

import me.imli.tintlib.helper.MDTintHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatEditText et1 = (AppCompatEditText) findViewById(R.id.et_1);
        AppCompatEditText et2 = (AppCompatEditText) findViewById(R.id.et_2);

        MDTintHelper.setTint(et1, 0xffff00ff);
        MDTintHelper.setTint(et2, 0xff00ffff);


        AppCompatP
    }

}
