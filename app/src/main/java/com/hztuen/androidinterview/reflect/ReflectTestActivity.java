package com.hztuen.androidinterview.reflect;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.hztuen.androidinterview.R;

import java.lang.reflect.Type;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class ReflectTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect_test);
//        testGetClassesMethod();
//        testIsInterfaceMethod();
//          testIsArrayMethod();
//        testIsPrimitive();
//        testIsAnnotation();
//        testGetSuperclassMethod();
//        testGetGenericSuperclass();
//        testGetInterfaces();
        testGetGenericInterfaces();
    }
    //测试getClasses()方法
    public void testGetClassesMethod(){
        try {
            // returns the Class object associated with this class
            Class cls = Class.forName("com.hztuen.androidinterview.reflect.ClassDemo");
         /* returns the array of Class objects representing the public
            members of this class */
            Class[] classes = cls.getClasses();
            for (int i = 0; i < classes.length; i++) {
                Log.e("zhouguizhi","Class found = " + classes[i].getName());
            }
        } catch (ClassNotFoundException e) {
            Log.e("zhouguizhi","ClassNotFoundException " +e.getMessage());
            System.out.println(e.toString());
        }
    }
    public void testIsInterfaceMethod(){
        try {
            // returns the Class object associated with this class
            Class cls = Class.forName("com.hztuen.androidinterview.reflect.TestInterfaces");
         /* returns the array of Class objects representing the public
            members of this class */
           Log.e("zhouguizhi","是否是接口:"+cls.isInterface());
        } catch (ClassNotFoundException e) {
            Log.e("zhouguizhi","ClassNotFoundException " +e.getMessage());
            System.out.println(e.toString());
        }
    }
    public void testIsArrayMethod(){
        List<String> list = new ArrayList<>();
        Class cls = list.getClass();
        Log.e("zhouguizhi","是不是数组 " +cls.isArray());
        int[] arr = new int[]{1,2,3};
        Class cls2 = arr.getClass();
        Log.e("zhouguizhi","是不是数组 " +cls2.isArray());
    }
    //测试isPrimitive() 表示是不是原始类型 jdk源码定义的
    /**
     * * @see     java.lang.Boolean#TYPE
     *      * @see     java.lang.Character#TYPE
     *      * @see     java.lang.Byte#TYPE
     *      * @see     java.lang.Short#TYPE
     *      * @see     java.lang.Integer#TYPE
     *      * @see     java.lang.Long#TYPE
     *      * @see     java.lang.Float#TYPE
     *      * @see     java.lang.Double#TYPE
     *      * @see     java.lang.Void#TYPE
     *      * @since JDK1.1
     */
    public void testIsPrimitive(){
        Person person = new Person(18);
        int age = person.getAge();
        Class cls = int.class;
        Log.e("zhouguizhi","是不是原始类型:"+cls.isPrimitive());
        Class pCls =  person.getClass();
        Log.e("zhouguizhi","是不是原始类型:"+pCls.isPrimitive());
    }
    //判断是不是注解
    public void testIsAnnotation(){
        try {
            Class cls =  Class.forName("com.hztuen.androidinterview.reflect.Table");
            Log.e("zhouguizhi","  是不是注解:"+cls.isAnnotation());
            Person person = new Person(18);
            Class pCls =  person.getClass();
            Log.e("zhouguizhi","是不是原始类型:"+pCls.isAnnotation());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void testGetSuperclassMethod(){
        Person person = new Person(18);
        Class pCls =  person.getClass();

        Stu stu = new Stu(19);
        Class sCls = stu.getClass();
        Log.e("zhouguizhi","getSuperclass:"+pCls.getSuperclass());
        Class cls = ReflectTestActivity.class;
        Log.e("zhouguizhi","getSuperclass:"+sCls.getSuperclass());
    }

    public void testGetGenericSuperclass(){
        Person person = new Person(18);
        Class pCls =  person.getClass();
        Log.e("zhouguizhi","getSuperclass:"+pCls.getGenericSuperclass());
        Class cls = Dog.class;
        Log.e("zhouguizhi","getSuperclass:"+cls.getGenericSuperclass());
        //com.hztuen.androidinterview.reflect.Anim<java.lang.String>
    }
    public void testGetInterfaces(){
        Person person = new Person(18);
        Class pCls =  person.getClass();
        Class<?>[] interfaces = pCls.getInterfaces();
        for(Class cls:interfaces){
            Log.e("zhouguizhi","getSuperclass:"+cls.getName());
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void testGetGenericInterfaces(){
        Person person = new Person(18);
        Class pCls =  person.getClass();
        Type[] types = pCls.getGenericInterfaces();
        for(Type type:types){
            Log.e("zhouguizhi","getTypeName:"+type.getTypeName());
        }
    }
}
