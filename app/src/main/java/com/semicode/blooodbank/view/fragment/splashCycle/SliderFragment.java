package com.semicode.blooodbank.view.fragment.splashCycle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.viewpager.widget.ViewPager;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.adapter.SliderAdapter;
import com.semicode.blooodbank.view.activity.AuthCycleActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class SliderFragment extends BaseFragment {


    @BindView(R.id.fragment_slider_vp_slider)
    ViewPager fragmentSliderVpSlider;

    @BindView(R.id.fragment_slider_i_btn_slider_button)
    ImageButton fragmentSliderIBtnSliderButton;
    @BindView(R.id.fragment_slider_tl_slider_tabs)
    ImageView fragmentSliderTlSliderTabs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initFragment();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_slider, container, false);
        ButterKnife.bind(this, view);

//        create adapter for slider
        SliderAdapter sliderAdapter = new SliderAdapter(getActivity());

//        create new page and pass data to it
        sliderAdapter.addPage(R.drawable.second_im_fragment_slider, "لوريم ايبسوم هو نموذج افتراضي يوضع في التصاميم لتعرض علي العميل ليتصور طريقه وضع النصوص بالتصاميم سواء" +
                " كانت تصاميم مطبوعه ... بروشور او فلاير علي سبيل المثال ... او نماذج مواقع");
        sliderAdapter.addPage(R.drawable.second_im_fragment_slider, "لوريم ايبسوم هو نموذج افتراضي يوضع في التصاميم لتعرض علي العميل ليتصور طريقه وضع النصوص بالتصاميم سواء" +
                " كانت تصاميم مطبوعه ... بروشور او فلاير علي سبيل المثال ... او نماذج مواقع");
        sliderAdapter.addPage(R.drawable.third_im_fragment_slider, "لوريم ايبسوم هو نموذج افتراضي يوضع في التصاميم لتعرض علي العميل ليتصور طريقه وضع النصوص بالتصاميم سواء" +
                " كانت تصاميم مطبوعه ... بروشور او فلاير علي سبيل المثال ... او نماذج مواقع");
//set adapter to viewPager
        fragmentSliderVpSlider.setAdapter(sliderAdapter);

//        chage image of imageButton at last page
        fragmentSliderVpSlider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                switch (position) {
                    case 0:
                        fragmentSliderIBtnSliderButton.setImageResource(R.drawable.ic_silder_fragment_arrow);
                        fragmentSliderTlSliderTabs.setImageResource(R.drawable.page_one_im_slider);
                        fragmentSliderIBtnSliderButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentSliderVpSlider.setCurrentItem(fragmentSliderVpSlider.getCurrentItem() + 1);
//
                            }
                        });
                        break;
                    case 1:
                        fragmentSliderIBtnSliderButton.setImageResource(R.drawable.ic_silder_fragment_arrow);
                        fragmentSliderTlSliderTabs.setImageResource(R.drawable.page_two_im_slider);
                        fragmentSliderIBtnSliderButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                fragmentSliderVpSlider.setCurrentItem(fragmentSliderVpSlider.getCurrentItem() + 1);
//
                            }
                        });
                        break;
                    case 2:

                        fragmentSliderVpSlider.setCurrentItem(fragmentSliderVpSlider.getCurrentItem() + 1);
                        fragmentSliderTlSliderTabs.setImageResource(R.drawable.page_three_im_slider);
                        fragmentSliderIBtnSliderButton.setImageResource(R.drawable.ic_silder_fragment_ok);
                        fragmentSliderIBtnSliderButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent myIntent = new Intent(getActivity(), AuthCycleActivity.class);
                                startActivity(myIntent);
                                getActivity().finish();

                            }
                        });
                        break;


                }


            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }

    @OnClick(R.id.fragment_slider_i_btn_slider_button)
    public void onViewClicked() {
        if (fragmentSliderVpSlider.getCurrentItem() == 0) {
            fragmentSliderVpSlider.setCurrentItem(1);
        }

    }

    // on back pressed for this fragment
    @Override
    public void onBack() {
        getActivity().finish();
    }
}