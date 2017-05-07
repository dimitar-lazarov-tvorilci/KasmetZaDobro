package com.tvorilci.mitko.kasmetzadobro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.tvorilci.mitko.kasmetzadobro.data.LittleLuck;
import com.tvorilci.mitko.kasmetzadobro.data.Repository;

public class PopupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        LittleLuck selectedLuck = Repository.getInstance(PopupActivity.this).getRandomLuck();
    }
}
