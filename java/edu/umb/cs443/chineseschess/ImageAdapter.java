package edu.umb.cs443.chineseschess;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    public ImageAdapter(Context c) {
        mContext = c;
    }
    public int getCount() {
        return thumbImages.length;
    }
    public Object getItem(int position) {
        return null;
    }
    public long getItemId(int position) {
        return 0;
    }
    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(1, 1, 1, 1);
        imageView.setImageResource(thumbImages[position]);
        return imageView;
    }
    // Add all our images to arraylist
    public Integer[] thumbImages = {
            R.drawable.rook_red, R.drawable.horse_red,
            R.drawable.elephant_red, R.drawable.advisor_red,
            R.drawable.general_red,
            R.drawable.advisor_red, R.drawable.elephant_red,
            R.drawable.horse_red, R.drawable.rook_red,

            null, null, null, null, null, null, null, null, null,

            null, R.drawable.cannon_red, null, null, null, null, null, R.drawable.cannon_red, null,

            R.drawable.solider_red, null, R.drawable.solider_red, null, R.drawable.solider_red, null,
            R.drawable.solider_red, null, R.drawable.solider_red,

            null, null, null, null, null, null, null, null, null,

            null, null, null, null, null, null, null, null, null,

            R.drawable.solider_black, null, R.drawable.solider_black, null, R.drawable.solider_black, null,
            R.drawable.solider_black, null, R.drawable.solider_black,

            null, R.drawable.cannon_black, null, null, null, null, null, R.drawable.cannon_black, null,

            null, null, null, null, null, null, null, null, null,

            R.drawable.rook_black, R.drawable.horse_black,
            R.drawable.elephant_black, R.drawable.advisor_black, R.drawable.general_black,
            R.drawable.advisor_black, R.drawable.elephant_black,
            R.drawable.horse_black, R.drawable.rook_black,
    };
}
