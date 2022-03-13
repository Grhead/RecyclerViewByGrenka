package com.example.listofdogs;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.net.URL;

public class MainThread extends Thread {
    public Bitmap BT;
    public URL newURL;
    MainCallBack mainCallBack;

    public void run() {
        super.run();
        Bitmap mIcon_val = null;
        try {
            mIcon_val = BitmapFactory.decodeStream(newURL.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        BT = mIcon_val;
        mainCallBack.BitLoader(BT);
    }
}
interface MainCallBack{
    void BitLoader(Bitmap BT);
}
