package com.android_application.WebComics.WebComicActivity;

import android.os.Bundle;
import com.android_application.WebComics.WebComicCrawler.AbstruseGooseCrawler;

/**
 * User: rajat
 * Date: 28/12/13
 */
public class AGActivity extends WebComicActivity {
    @Override
    protected void setCrawler() {
        crawler = new AbstruseGooseCrawler();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}