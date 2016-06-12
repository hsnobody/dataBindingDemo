package com.example;

import android.databinding.*;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.hundsun.myapplication.BR;

//重命名设置 改变的是 属性名 本来由 android:test   改成app:renamedSettersText ， 所针对调用的函数都是 setText
@BindingMethods({
        @BindingMethod(type = android.widget.TextView.class,
                attribute = "app:renamedSettersText",
                method = "setText"),
})
public class User extends BaseObservable {

    private ArrayAdapter<CharSequence> aaadapter;
    private  String firstName;
    private  String lastName;
    private int age;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, int age) {
        this(firstName, lastName);
        this.age=age;
    }


    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyChange();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyChange();
    }
    @Bindable
    public ArrayAdapter<CharSequence> getAaadapter() {
        return aaadapter;

    }

    public void setAaadapter(ArrayAdapter<CharSequence> aaadapter) {
        this.aaadapter = aaadapter;
    }
        @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        notifyPropertyChanged(BR.firstName);
    }

    //自定义setting属性，

    /**
     *         <TextView android:layout_width="wrap_content"
                 android:layout_height="wrap_content"
                 app:customerAge="@{user.age}"/>

     Caused by: java.lang.IllegalStateException: Required DataBindingComponent is null in class MainActivityBinding. A BindingAdapter in com.example.User is not static and requires an object to use, retrieved from the DataBindingComponent. If you don't use an inflation method taking a DataBindingComponent, use DataBindingUtil.setDefaultComponent or make all BindingAdapter methods static.

     * @param view
     */
    @BindingAdapter({"customerAge"})
    public static void setCustomerAge(TextView view, int age) {
        System.out.println("fuck  asdfklaklsdfklakl df");
        view.setText(String.valueOf(age));
    }

}