package com.android_application.WebComics.WebComicActivity;

import android.os.Bundle;
import com.android_application.WebComics.WebComicActivity.WebComicActivity;
import com.android_application.WebComics.WebComicCrawler.XkcdCrawler;

/**
 * User: rajat
 * Date: 28/12/13
 */
public class XkcdActivity extends WebComicActivity {
    @Override
    protected void setCrawler() {
        crawler = new XkcdCrawler();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}