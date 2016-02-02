package com.example.christianzam.basketballleagueapp;

/**
 * Created by christianzam on 12/28/2015.
 */

import android.util.Log;

import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.net.URL;
import java.io.IOException;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.MalformedURLException;

/**
 * Created by cfsuman on 31/05/2015.
 */
public class HTTPDataHandler {

    static String stream = null;

    public HTTPDataHandler() {
    }

    public String GetHTTPData(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            // Check the connection status
            if (urlConnection.getResponseCode() == 200) {
                // if response code = 200 ok
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                // Read the BufferedInputStream
                BufferedReader r = new BufferedReader(new InputStreamReader(in));
                StringBuilder sb = new StringBuilder();
                String line;
                String playerID;
                while ((line = r.readLine()) != null) {
                    sb.append(line);
                   Log.i("URl Conn line fetched","This is the line" + " "+ line);
                }
                stream = sb.toString();
                    Log.i("Url Conn final string", "This is the final string" + " "+ stream);
                // End reading...............

                // Disconnect the HttpURLConnection
                urlConnection.disconnect();
            } else {
                // Do something
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
        // Return the data from specified url
        return stream;
    }
}