package com.example.samsung.p0701_saveinstancestate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";
    int cnt = 0;
    MyObject myObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(LOG_TAG, getString(R.string.on_create));

        if (myObject == null) {
            //Чтение объекта из межэкранного состояния
            myObject = (MyObject) getLastCustomNonConfigurationInstance();
            Log.d(LOG_TAG, getString(R.string.get_last_lustom_non_configuration_instance));
            if (myObject != null) {
                String message = getString(R.string.my_object_is) + myObject.getString()
                        + ":" + myObject.getInteger();
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, getString(R.string.on_destroy));
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, getString(R.string.on_pause));
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, getString(R.string.on_restart));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //Чтение значения межэкранного состояния
        cnt = savedInstanceState.getInt(getString(R.string.count_out_state));
        Log.d(LOG_TAG, getString(R.string.on_restore_instance_state));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, getString(R.string.on_resume));
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(LOG_TAG, getString(R.string.on_post_resume));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //Сохранение значения межэкранныого состояния
        outState.putInt(getString(R.string.count_out_state), cnt);
        Log.d(LOG_TAG, getString(R.string.on_save_instance_state));
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        //Запись объекта в межэкранное состояние
        Log.d(LOG_TAG, getString(R.string.on_retain_custom_non_configuration_instance));
        return myObject;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, getString(R.string.on_start));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, getString(R.string.on_stop));
    }

    public void onClicButton(View view) {
        Toast.makeText(this, getString(R.string.toast_count) + ++cnt, Toast.LENGTH_SHORT).show();
        myObject = new MyObject("text", 111111);
    }
}
