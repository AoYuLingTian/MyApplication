package com.example.databindingdemo;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/3/21.
 */
public class ContactsAdapter<T> extends BaseAdapter {

    private Context context;

    private List<ContactsModel> modelList;

    private int layoutId;

    private int variableId;

    public ContactsAdapter(Context context, List<ContactsModel> modelList, int layoutId, int variableId) {
        this.context = context;
        this.modelList = modelList;
        this.layoutId = layoutId;
        this.variableId = variableId;
    }

    @Override
    public int getCount() {
        return modelList.size() > 0 ? modelList.size() : 0;
    }
    @Override
    public Object getItem(int position) {
        return modelList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding viewDataBinding = null;
        if (convertView == null){
            viewDataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), layoutId, parent, false);
        } else {
            viewDataBinding = DataBindingUtil.getBinding(convertView);
        }
        viewDataBinding.setVariable(variableId, modelList.get(position));
        return viewDataBinding.getRoot();
    }

}
