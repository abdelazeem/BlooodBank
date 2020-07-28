package com.semicode.blooodbank.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.semicode.blooodbank.R;
import com.semicode.blooodbank.data.model.GeneralResponseData;


import java.util.ArrayList;
import java.util.List;

public class MySpinnerAdapter extends BaseAdapter {

    private Context context;
    private List<GeneralResponseData> generalResponseDataList = new ArrayList<>();
    private LayoutInflater inflter;
    public int selectedId = 0;

    public MySpinnerAdapter(Context applicationContext) {
        this.context = applicationContext;
        this.generalResponseDataList = generalResponseDataList;
        inflter = (LayoutInflater.from(applicationContext));
    }

    public void setData(List<GeneralResponseData> generalResponseDataList, String hint) {
        this.generalResponseDataList = generalResponseDataList;
        this.generalResponseDataList.add(new GeneralResponseData(generalResponseDataList.size(), hint));

    }

    @Override
    public int getCount() {
        return generalResponseDataList.size();
    }

    @Override
    public Object getItem(int i) {
        return generalResponseDataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.item_spinner_item, null);

        TextView names =  view.findViewById(R.id.textView_spinner);

        names.setText(generalResponseDataList.get(i).getName());
        selectedId = generalResponseDataList.get(i).getId();

        return view;
    }


}