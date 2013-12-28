package com.android_application.WebComics;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

/**
 * User: rajat
 * Date: 28/12/13
 */
public class ImageTextAdapter extends BaseAdapter {

    private Context mContext;

    public ImageTextAdapter(Context context){
        mContext = context;
    }

    @Override
    public int getCount() {
        return WebComicsInformationContainer.getInstance().getNumberOfComics();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        RelativeLayout relativeLayout;

        if (convertView == null){
            relativeLayout = (RelativeLayout) View.inflate(mContext, R.layout.comic_icon, null);
        }
        else{
            relativeLayout = (RelativeLayout) convertView;
        }

        int imageId = WebComicsInformationContainer.getInstance().getImageSource(WebComicsInformationContainer.COMIC.values()[position]);
        String label = WebComicsInformationContainer.getInstance().getComicName(WebComicsInformationContainer.COMIC.values()[position]);


        ((ImageView)relativeLayout.findViewById(R.id.imageView)).setImageResource(imageId);
        ((TextView)relativeLayout.findViewById(R.id.textView)).setText(label);

        return relativeLayout;
    }
}
