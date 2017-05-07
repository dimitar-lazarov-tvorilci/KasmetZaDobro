package com.tvorilci.mitko.kasmetzadobro.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tvorilci.mitko.kasmetzadobro.PopupActivity;
import com.tvorilci.mitko.kasmetzadobro.data.AlarmEntry;


public abstract class PopupAlarmReceiver extends BroadcastReceiver {
    abstract void setNextAlarm(Context context, AlarmEntry previousEntry);

    abstract AlarmEntry getExecutingAlarmEntry(Intent intent);

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent activityIntent = new Intent(context, PopupActivity.class);
        activityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(activityIntent);

        AlarmEntry currentEntry = getExecutingAlarmEntry(intent);

        setNextAlarm(context, currentEntry);
    }
}
