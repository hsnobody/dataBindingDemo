package com.hundsun.myapplication;

import android.databinding.DataBindingUtil;
import android.databinding.PropertyChangeRegistry;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import com.example.User;
import com.hundsun.myapplication.databinding.MainActivityBinding;
//(说白了 数据绑定  就是 绑定的对象发生改变 触发 对应的属性的函数执行)
//android:text={user.lastName}   user.lastName 发生改变的时候  触发 android:text属性对应的setText函数执行
public class MainActivity extends AppCompatActivity {

    MainActivityBinding binding;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        user = new User("Test", "User");
        ArrayAdapter<CharSequence> adapter=new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"user1","user2","user3"});
        user.setAaadapter(adapter);
        binding.setUser(user);
    }
    //以下都是方法改变触发 页面控件 更新数据
    //按钮 回调
    public void testAutomaticSetters(View view){
        ArrayAdapter<CharSequence> adapter=new ArrayAdapter<CharSequence>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"changed1","changed2","changed3"});
        user.setAaadapter(adapter);

        user.setFirstName("firstName changed ");

    }
    //按钮 回调
    public void testRenamedSetters(View view){
        user.setLastName("lastName changed ");

    }
    //按钮 回调
    public void testCustomerSetters(View view){

        user.setAge(18);

    }
}
