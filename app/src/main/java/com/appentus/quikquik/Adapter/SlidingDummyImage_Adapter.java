package com.appentus.quikquik.Adapter;

import android.app.Activity;
import android.content.Context;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.appentus.quikquik.R;

import java.util.ArrayList;

public class SlidingDummyImage_Adapter extends PagerAdapter {


    private ArrayList<Integer> images;
    private LayoutInflater inflater;
    private Context context;

    public SlidingDummyImage_Adapter(Activity context, ArrayList<Integer> imagesArray) {
        this.context = context;
        this.images =imagesArray;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slidingimages_layout, view, false);
        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.imgintro);
        imageView.setImageResource(images.get(position));
       // imageView.setBackground(ContextCompat.getDrawable(context, images.get(position)));
        view.addView(imageLayout, 0);
        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}