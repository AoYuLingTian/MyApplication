package com.example.databindingdemo;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2017/3/21.
 */

public class ContactsModel {

    private String headerImg;

    private String name;

    private String phone;

    public ContactsModel() {
    }

    public ContactsModel(String headerImg, String name, String phone) {
        this.headerImg = headerImg;
        this.name = name;
        this.phone = phone;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher)
                .transform(new PicassoRoundTransform())
                .into(view);
    }

}
