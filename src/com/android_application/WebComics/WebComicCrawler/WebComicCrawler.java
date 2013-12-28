package com.android_application.WebComics.WebComicCrawler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * User: rajat
 * Date: 28/12/13
 */
public abstract class WebComicCrawler {

    class ImageSrcAltTextPair{
        String src;
        String alt;

        ImageSrcAltTextPair(String src, String alt) {
            this.src = src;
            this.alt = alt;
        }
    }

    private Bitmap getImage(String src) throws IOException {
        URL url = new URL(src);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.connect();
        InputStream input = connection.getInputStream();
        return BitmapFactory.decodeStream(input);
    }

    protected abstract ImageSrcAltTextPair getImageUrl(int comicIndex) throws IOException;

    public Bitmap getComic(int comicIndex) throws IOException{
        ImageSrcAltTextPair imageSrcAltTextPair = getImageUrl(comicIndex);
        return getImage(imageSrcAltTextPair.src);
    }
}
