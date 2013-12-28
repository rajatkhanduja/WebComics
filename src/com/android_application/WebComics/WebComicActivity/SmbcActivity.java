package com.android_application.WebComics.WebComicActivity;

import android.app.Activity;
import android.os.Bundle;
import com.android_application.WebComics.WebComicCrawler.SmbcCrawler;

/**
 * User: rajat
 * Date: 28/12/13
 */
public class SmbcActivity extends WebComicActivity {
    @Override
    protected void setCrawler() {
        crawler = new SmbcCrawler();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}