package com.example.databindingdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.example.databindingdemo.databinding.ActivityListMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String[] images = {"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775527&di=44a1f37c1cbc3457002627eed27529cf&imgtype=0&src=http%3A%2F%2Fimg3.3lian.com%2F2013%2Fs4%2F32%2Fd%2F84.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775526&di=a4d1fbdb5f930f8c5d8e72a6f1c10abd&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F131%2Fd%2F271.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775526&di=8a8d260f3452bb3aa32e0341d3ca81ac&imgtype=0&src=http%3A%2F%2Fpic28.nipic.com%2F20130416%2F4908302_160551036000_2.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775525&di=017ac5351b8dd39d807a77d73754cc6a&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fa1%2F21%2Fd%2F81.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775524&di=405d2ea3d911a6c80abbbc1d75adf7ba&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2Fimg013%2Fv4%2F69%2Fd%2F10.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775519&di=9b9a488acf1b22c8d4aa3618cbcc03a0&imgtype=0&src=http%3A%2F%2Fimg15.3lian.com%2F2015%2Fh1%2F57%2Fd%2F61.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775518&di=ab2859781d20e7d6ccb284cbc844c76d&imgtype=0&src=http%3A%2F%2Fimg4q.duitang.com%2Fuploads%2Fitem%2F201411%2F20%2F20141120150628_HUyuP.jpeg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775517&di=f1f7deceb15f433dce6a375ef49a672a&imgtype=0&src=http%3A%2F%2Fimg15.3lian.com%2F2015%2Fa1%2F10%2Fd%2F108.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775517&di=882caa69af124f5ec9e46be2d81b45a9&imgtype=0&src=http%3A%2F%2Ftupian.enterdesk.com%2F2013%2Flxy%2F06%2F22%2F4.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775516&di=9fc18cb0768596c9e3bc498fe4fb4c0b&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2Fimg013%2Fv5%2F17%2Fd%2F12.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775516&di=792dcded047ede8d3cc3115239835b09&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2F2015%2Fw5%2F69%2Fd%2F25.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775516&di=d89a7d636a2fdf100780136cf9c2eb1c&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F41%2F37%2F57S58PICMKa_1024.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775516&di=ef171f90242d2a5cb05cb7083eb67129&imgtype=0&src=http%3A%2F%2Fwww.juzi2.com%2Fuploads%2Fallimg%2F130521%2F1_130521121334_1.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775515&di=0a89999dd703863417317f7b9e05171f&imgtype=0&src=http%3A%2F%2Fimg3.3lian.com%2F2013%2Fc1%2F91%2Fd%2F29.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775515&di=cab39cd7ba89f4309d4f52d7a49127ad&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2Fimg013%2Fv2%2F60%2Fd%2F102.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775514&di=b6d660c4bfe69a6f9bcb3ae2bd8217f0&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2Fimg013%2Fv5%2F17%2Fd%2F10.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775512&di=74cac3f9601c48d45bcdc29f476053ff&imgtype=0&src=http%3A%2F%2Fpic.nipic.com%2F2008-03-25%2F2008325121527690_2.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775512&di=0569e04dc83942bb16a3c41276c0a8b5&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2Fimg013%2Fv5%2F17%2Fd%2F7.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775512&di=0569e04dc83942bb16a3c41276c0a8b5&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2Fimg013%2Fv5%2F17%2Fd%2F7.jpg"
    , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1490097775512&di=0569e04dc83942bb16a3c41276c0a8b5&imgtype=0&src=http%3A%2F%2Fimg1.3lian.com%2Fimg013%2Fv5%2F17%2Fd%2F7.jpg"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityListMainBinding viewDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_list_main);
////        User user = new User("张三", "18");
////        viewDataBinding.setUser(user);
        int num = 20;
        List<ContactsModel> list = new ArrayList<ContactsModel>();
        for (int i = 0; i < num; i++){
            ContactsModel contactsModel = new ContactsModel();
            contactsModel.setHeaderImg(images[i]);
            contactsModel.setName("张三" + i);
            contactsModel.setPhone("12334354343");
            list.add(contactsModel);
        }
        ContactsAdapter<ContactsModel> contactsAdapter = new ContactsAdapter<ContactsModel>(MainActivity.this, list, R.layout.activity_list_item, BR.contacts);
        viewDataBinding.setAdapter(contactsAdapter);

        viewDataBinding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ContactsModel contactsModel = (ContactsModel) ((ContactsAdapter) parent.getAdapter()).getItem(position);
                Toast.makeText(MainActivity.this, contactsModel.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
