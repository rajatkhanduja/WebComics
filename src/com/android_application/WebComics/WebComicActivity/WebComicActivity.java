package com.android_application.WebComics.WebComicActivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.ImageView;
import com.android_application.WebComics.R;
import com.android_application.WebComics.WebComicCrawler.WebComicCrawler;

import java.io.IOException;

/**
 * User: rajat
 * Date: 28/12/13
 */
public abstract class WebComicActivity extends Activity {
    protected WebComicCrawler crawler;

    protected abstract void setCrawler();
    private int comicIndex = 1;

    private class ImageViewIntegerPair{
        public ImageView imageView;
        public int index;

        private ImageViewIntegerPair(ImageView imageView, int index) {
            this.imageView = imageView;
            this.index = index;
        }
    }

    private class FetchImageTask extends AsyncTask<ImageViewIntegerPair, Void, Bitmap>{
        private ImageView imageView;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Bitmap doInBackground(ImageViewIntegerPair... params) {
            imageView = params[0].imageView;
            try {
                return crawler.getComic(comicIndex);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("Exception", e.getMessage());
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageView.setImageBitmap(bitmap);
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.webcomic_display);
        setCrawler();
        FetchImageTask fetchTask = new FetchImageTask();
        ImageView comic= (ImageView) findViewById(R.id.imageView);
        fetchTask.execute(new ImageViewIntegerPair(comic, comicIndex));

        //comic.setOnTouchListener((View.OnTouchListener) new GestureDetector.SimpleOnGestureListener());
    }
}