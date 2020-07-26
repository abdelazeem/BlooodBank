package com.semicode.blooodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;


import com.semicode.blooodbank.R;
import com.semicode.blooodbank.data.model.Slider;
import com.semicode.blooodbank.helper.HelperMethod;

import java.util.ArrayList;
import java.util.List;


public class SliderAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater mLayoutInflater;
    public List<Slider> slides = new ArrayList<>();

    public SliderAdapter(Context context, List<Slider> slides) {
        this.context = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.slides = slides;
    }

    public SliderAdapter(Context context) {
        this.context = context;
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void addPage(Integer image, String text) {
        slides.add(new Slider(image, text));
    }

    @Override
    public int getCount() {
        return slides.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_slider, container, false);

        ImageView SliderAdapterIvSliderImage = itemView.findViewById(R.id.item_slider_iv_image);
        TextView SliderAdapterTvSliderText = itemView.findViewById(R.id.item_slider_tv_text);

        SliderAdapterIvSliderImage.setImageResource(slides.get(position).getPhoto());
        SliderAdapterTvSliderText.setText(slides.get(position).getText());


        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
