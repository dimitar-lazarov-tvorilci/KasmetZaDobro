package com.tvorilci.mitko.kasmetzadobro.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tvorilci.mitko.kasmetzadobro.data.AlarmEntry;
import com.tvorilci.mitko.kasmetzadobro.configurations.AlarmSettings;

import java.util.Calendar;

/**
 *
 */
public class AlarmHelper {
    private static AlarmHelper ourInstance = new AlarmHelper();

    public static AlarmHelper getInstance() {
        return ourInstance;
    }

    private AlarmHelper() {
    }

    public void setPopupAlarm(Context context) {

        if (AlarmSettings.isIntuitive) {
            AlarmHelper.getInstance().setPopupIntuitiveAlarm(context);
        } else {
            AlarmHelper.getInstance().setPopupRegularAlarms(context);
        }
    }

    public void setNextIntuitiveAlarm(Context context, AlarmEntry entry){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(entry.getAlarmTime());
        calendar.add(Calendar.HOUR, 24);

        //TODO: make them random and inside interval
        int hour = 12;
        int minute = 12;
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long nextAlarmTime = calendar.getTimeInMillis();
        AlarmManager alarmManager = getAlarmManager(context);
        PendingIntent pendingIntent = getRefreshAlarmPendingIntent(context, PopupIntuitiveAlarmReceiver.class);
        alarmManager.set(AlarmManager.RTC_WAKEUP, nextAlarmTime, pendingIntent);
    }

    public void setNextRegularAlarm(Context context, AlarmEntry entry){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(entry.getAlarmTime());
        calendar.add(Calendar.HOUR, 24);

        long nextAlarmTime = calendar.getTimeInMillis();
        AlarmManager alarmManager = getAlarmManager(context);
        PendingIntent pendingIntent = getRefreshAlarmPendingIntent(context, PopupRegularAlarmReceiver.class);
        alarmManager.set(AlarmManager.RTC_WAKEUP, nextAlarmTime, pendingIntent);
    }

    /* private methods */

    private void setPopupIntuitiveAlarm(Context context) {

        int hour = 12;
        int minute = 12;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        long nextAlarmTime = calendar.getTimeInMillis();
        AlarmManager alarmManager = getAlarmManager(context);
        PendingIntent pendingIntent = getRefreshAlarmPendingIntent(context, PopupIntuitiveAlarmReceiver.class);
        alarmManager.set(AlarmManager.RTC_WAKEUP, nextAlarmTime, pendingIntent);
    }

    private void setPopupRegularAlarms(Context context) {
        AlarmManager alarmManager = getAlarmManager(context);
        //TODO: is it single pending intent for all or intent-per-entry?
        PendingIntent pendingIntent = getRefreshAlarmPendingIntent(context, PopupRegularAlarmReceiver.class);

        //TODO: get entries from database, checking for active
        for (AlarmEntry entry:
             AlarmSettings.configuredAlarms) {

            long nextAlarmTime = entry.getAlarmTime();

            Calendar calendar = Calendar.getInstance();
            if (calendar.getTimeInMillis() >= nextAlarmTime){
                int shiftHours = 24; //TODO: calculate whether the alarm to be set on the same day or the next
                calendar.setTimeInMillis(nextAlarmTime);
                calendar.add(Calendar.HOUR, shiftHours);
                nextAlarmTime = calendar.getTimeInMillis();
            }

            alarmManager.set(AlarmManager.RTC_WAKEUP, nextAlarmTime, pendingIntent);
        }
    }

    private AlarmManager getAlarmManager(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        return alarmManager;
    }

    private PendingIntent getRefreshAlarmPendingIntent(Context context,
                                                      Class<? extends BroadcastReceiver> broadcastReceiverClass) {
        Intent alarmIntent = new Intent(context, broadcastReceiverClass);
        PendingIntent pendingIntent =
                PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }
}
