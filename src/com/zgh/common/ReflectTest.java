package com.zgh.common;

import com.zgh.entity.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException {
        User user1 = new User();
        //得到User对象的Class对象
        Class cls1 = user1.getClass();
        //获取User类中名为id的成员变量
        Field id = cls1.getDeclaredField("id");
        //设置暴力反射
        id.setAccessible(true);
        //设置值
        id.set(user1,"xxx1");
        //获取值
        System.out.println("Field对象获取：" + id.get(user1));


//使用类名.class获取User类的Class对象
        Class<User> cls2 = User.class;
        //使用getConstructor()方法获取Constructor对象,并传入有参构造器参数类型的Class对象
        Constructor<User> constructor = cls2.getConstructor(String.class, String.class);
        //调用newInstance("xxx1", "老鬼")方法来创建User对象并给它的成员变量赋值
        User user2 = constructor.newInstance("xxx1", "老鬼");
        System.out.println("创建有参构造：" + user2 + "\n");
        //使用空参构造方法，简化创建对象
        User user3 = cls2.newInstance();
        System.out.println("创建无参构造：" + user3);

        //使用Class.forName("类的全路径")获取类的Class对象
        Class cls3 = Class.forName("com.zgh.entity.User");
        //获取User类中的play方法,并传入参数的Class类
        Method play = cls3.getMethod("play", String.class);
        //执行playGame方法,并传入实参
        play.invoke(cls3.newInstance(),"games");
        //获取方法名
        System.out.println("方法名：" + play.getName());
    }
}
