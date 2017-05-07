package com.tvorilci.mitko.kasmetzadobro.data;

import android.provider.BaseColumns;

public abstract class DatabaseContract implements BaseColumns {
    /* Little Lucks */
    public static final String LITTLE_LUCKS_TABLE_NAME = "LittleLucks";
    public static final String LITTLE_LUCKS_GOOD_THOUGHT = "goodThought";
    public static final String LITTLE_LUCKS_GOOD_DEED = "goodDeed";
    public static final String LITTLE_LUCKS_TIMES_SHOWN = "timesShown";

    /* User Params */
    public static final String PARAMETERS_TABLE_NAME = "Parameters";
    public static final String PARAMETERS_NAME = "name";
    public static final String PARAMETERS_VALUE = "value";


    /* Alarms */
    public static final String ALARMS_TABLE_NAME = "Alarms";
    public static final String ALARMS_TIME = "alarmTime";
    public static final String ALARMS_ACTIVE = "active";
    public static final String ALARMS_INTUITIVE = "intuitive";
}
