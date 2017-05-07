package com.tvorilci.mitko.kasmetzadobro.configurations;


import com.tvorilci.mitko.kasmetzadobro.data.AlarmEntry;

import java.util.ArrayList;

public class AlarmSettings {
    public static ArrayList<AlarmEntry> configuredAlarms = new ArrayList<>();

    public static boolean isIntuitive = false;

    public static int intuitiveAlarmMinHour = 8;

    public static int intuitiveAlarmMaxHour = 20;
}
