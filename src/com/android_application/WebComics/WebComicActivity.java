package com.android_application.WebComics;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.ImageView;
import com.android_application.WebComics.R;
import com.android_application.WebComics.WebComicCrawler.WebComicCrawler;
import com.android_application.WebComics.WebComicsInformationContainer;

import java.io.IOException;

/**
 * User: rajat
 * Date: 28/12/13
 */
public class WebComicActivity extends Activity {
    protected WebComicCrawler crawler;

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
        private ProgressDialog progressDialog = ProgressDialog.show(WebComicActivity.this, "Loading",
                                                    comicIndex == -1 ? "Fetching latest comic" : "Fetching comic " + comicIndex);

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
                progressDialog.setMessage("Error fetching comic");
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
            imageView.setImageBitmap(bitmap);
        }
    }

    private void updateImage(){
        FetchImageTask fetchTask = new FetchImageTask();
        ImageView comic= (ImageView) findViewById(R.id.imageView);
        fetchTask.execute(new ImageViewIntegerPair(comic, comicIndex));
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Remove title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.webcomic_display);
        final int comicType = getIntent().getIntExtra("comic_type", -1);
        crawler = WebComicsInformationContainer.getInstance().getCrawler(comicType);
        updateImage();

        ImageView comic= (ImageView) findViewById(R.id.imageView);
        comic.setOnTouchListener(new OnSwipeTouchListener(){

            private void loadPage(){
                Intent intent = new Intent(WebComicActivity.this, WebComicActivity.class);
                intent.putExtra("comic_type", comicType);
            }

            @Override
            public void onSwipeLeft() {
                comicIndex++;
                updateImage();
            }

            @Override
            public void onSwipeRight() {
                comicIndex--;
                updateImage();
            }
        });
    }
}