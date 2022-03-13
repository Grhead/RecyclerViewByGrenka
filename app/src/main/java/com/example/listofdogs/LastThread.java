package com.example.listofdogs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class LastThread extends Thread {
    public Boolean BT;
    public URL newURL;
    LastCallBack LastCallBack;

    public void run() {
        super.run();
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) newURL.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.setRequestMethod("HEAD");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }
        int responseCode = 0;
        try {
            responseCode = connection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (responseCode != 200) {
            BT = false;
        } else{
            BT = true;
        }
        LastCallBack.BitLoader(BT);
    }
}

interface LastCallBack{
    void BitLoader(Boolean BT);
}
