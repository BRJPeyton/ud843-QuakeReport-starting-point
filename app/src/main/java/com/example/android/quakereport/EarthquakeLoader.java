package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

/**
 * Created by Brandon on 8/30/2016.
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    // Tag for log messages
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String mUrl;

    /**
     * constructs a new EarthquakeLoader
     *
     * @param context of activity
     * @param url to load data from
     */
    public EarthquakeLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading(){
        Log.i(LOG_TAG, "Test: onStartLoading() called ...");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<Earthquake> loadInBackground(){

        Log.i(LOG_TAG, "Test: loadInBackground() called ...");
        if (mUrl == null){
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(mUrl);
        return earthquakes;
    }
}
