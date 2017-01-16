package com.alnton.myFrameResource.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alnton.myFrameResource.R;

/**
 * <相册浏览适配器>
 * @author  王乾州
 */
public class GalleryAdapter extends BaseAdapter
{
    private LayoutInflater inflater;
    
    ArrayList<Bitmap> images;
    
    private int layoutId;
    
    public GalleryAdapter(Context context, ArrayList<Bitmap> images, int layout)
    {
        this.inflater = LayoutInflater.from(context);
        this.images = images;
        this.layoutId = layout;
    }
    
    public final class Holder
    {
        ImageView image;
    }
    
    @Override
    public int getCount()
    {
        return images.size();
    }
    
    @Override
    public Object getItem(int position)
    {
        return images.get(position);
    }
    
    @Override
    public long getItemId(int position)
    {
        return position;
    }
    
    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        final Holder holder;
        if (view == null)
        {
            holder = new Holder();
            view = inflater.inflate(layoutId, null);
            holder.image = (ImageView)view.findViewById(R.id.image);
            view.setTag(holder);
        }
        else
        {
            holder = (Holder)view.getTag();
        }
        holder.image.setImageBitmap(images.get(position));
        return view;
    }
    
    public ArrayList<Bitmap> getImages()
    {
        return images;
    }
    
    public void setImages(ArrayList<Bitmap> images)
    {
        this.images = images;
    }
}