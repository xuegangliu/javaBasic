package org.lxg.basic.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author xuegangliu
 *  4/29/2018 2:33 PM
 *  方法引用
 * @version: v1.0
 */
public class MethodReference {
    public static void main(String[] args) {
        List names = new ArrayList();

        names.add("Google");
        names.add("Runoob");
        names.add("Taobao");
        names.add("Baidu");
        names.add("Sina");

        names.forEach(System.out::println);

        // 构造器引用：它的语法是Class::new，或者更一般的Class< T >::new
        final Car car = Car.create( Car::new );
        final List< Car > cars = Arrays.asList( car );

        // 静态方法引用：它的语法是Class::static_method
        cars.forEach( Car::collide );

        // 特定类的任意对象的方法引用：它的语法是Class::method
        cars.forEach( Car::repair );

        // 特定对象的方法引用：它的语法是instance::method
        final Car police = Car.create( Car::new );
        cars.forEach( police::follow );
    }
}

class Car {
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Car create(final Supplier<Car> supplier) {
        return supplier.get();
    }

    public static void collide(final Car car) {
        System.out.println("Collided " + car.toString());
    }

    public void follow(final Car another) {
        System.out.println("Following the " + another.toString());
    }

    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
}
