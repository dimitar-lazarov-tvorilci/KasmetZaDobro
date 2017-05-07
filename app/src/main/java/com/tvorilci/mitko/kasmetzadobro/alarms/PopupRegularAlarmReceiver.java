package com.tvorilci.mitko.kasmetzadobro.alarms;

import android.content.Context;
import android.content.Intent;
import com.tvorilci.mitko.kasmetzadobro.data.AlarmEntry;


public class PopupRegularAlarmReceiver extends PopupAlarmReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);
    }

    @Override
    void setNextAlarm(Context context, AlarmEntry previousEntry) {
        AlarmHelper.getInstance().setNextRegularAlarm(context, previousEntry);
    }

    @Override
    AlarmEntry getExecutingAlarmEntry(Intent intent) {
        //TODO: get the alarm entry from database
        return new AlarmEntry();
    }
}
