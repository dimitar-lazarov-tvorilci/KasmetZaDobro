package com.tvorilci.mitko.kasmetzadobro.data;


import android.support.annotation.NonNull;

/**
 * TODO: Documentation to be created
 */
public final class AlarmEntry {

    @NonNull
    private long alarmTime;

    @NonNull
    private boolean active;

    @NonNull
    private boolean intuitive;

    public AlarmEntry(@NonNull long alarmTime, @NonNull boolean active, @NonNull boolean intuitive) {
        this.alarmTime = alarmTime;
        this.active = active;
        this.intuitive = intuitive;
    }

    /**
     * @return the time in milliseconds which the alarm was scheduled for
     */
    @NonNull
    public long getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(@NonNull long alarmTime) {
        this.alarmTime = alarmTime;
    }

    /**
     * @return whether or not the alarm is still to be executed
     */
    @NonNull
    public boolean isActive() {
        return active;
    }

    public void setActive(@NonNull boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object obj) {
        //TODO: implement equality
        return super.equals(obj);
    }

    @NonNull
    public boolean isIntuitive() {
        return intuitive;
    }

    public void setIntuitive(@NonNull boolean intuitive) {
        this.intuitive = intuitive;
    }
}
