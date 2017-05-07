package com.tvorilci.mitko.kasmetzadobro.alarms;

import android.content.Context;
import android.content.Intent;
import com.tvorilci.mitko.kasmetzadobro.data.AlarmEntry;


public class PopupIntuitiveAlarmReceiver extends PopupAlarmReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    void setNextAlarm(Context context, AlarmEntry previousEntry) {
        AlarmHelper.getInstance().setNextIntuitiveAlarm(context, previousEntry);
    }

    @Override
    AlarmEntry getExecutingAlarmEntry(Intent intent) {

        //TODO: get the alarm entry from database
        long randomTime = 8937284;
        boolean randomActive = true;
        boolean randomIntuitive = false;
        return new AlarmEntry(randomTime, randomActive, randomIntuitive);
    }
}
