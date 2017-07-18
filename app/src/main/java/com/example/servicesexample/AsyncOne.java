package com.example.servicesexample;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.widget.TextView;

/**
 * Created by Praful Dhabekar on 7/10/2017.
 */

public class AsyncOne extends AsyncTask {
    TextView res;
    FloatingActionButton button;


    public AsyncOne(TextView textView, FloatingActionButton fab) {

        this.res = textView;
        this.button = fab;
    }

    // onPreExecute() is setting text before any execution of background task
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        button.setEnabled(false);
        res.setText("Download is about to start..");
    }

    /* doInBackground() is running in background and displaying result on UI */
    @Override
    protected Object doInBackground(Object[] objects) {

        for (int i=0;i<=100;i++){
            publishProgress(i);

            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* onProgressUpdate() is setting the value on the UI */
    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
        int Widget_ProgressBar_Horizontal;

        res.setText("Downloaded: "+values[0]+"%");
    }


    /* onPostExecute() is displaying message after the background task is completed */
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        button.setEnabled(true);
        res.setText("Download completed!");
    }
}