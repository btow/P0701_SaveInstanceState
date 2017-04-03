package com.example.samsung.p0701_saveinstancestate;

import android.util.Log;

/**
 * Created by samsung on 03.04.2017.
 */

public class MyObject {

    private String LOG_TAG = "myLogs";

    private Integer integer;
    private String string;

    public MyObject(String string, Integer integer) {
        this.string = string;
        this.integer = integer;
        Log.d(LOG_TAG, "Constructor MyObject");
    }

    public String getString() {
        return string;
    }

    public Integer getInteger() {
        return integer;
    }
}
