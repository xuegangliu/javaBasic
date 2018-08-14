package org.lxg.basic.jdk5;

import com.lxg.test.jdk5.annotation.MethodInfo;
import com.lxg.test.jdk5.api.TestImpl;
import com.lxg.test.jdk5.api.TestService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Max
 * @date: 2018/4/6 12:03
 * @DES: 注解作用
 * ①编写文档：通过代码里标识的元数据生成文档【生成文档doc文档】
 * ②代码分析：通过代码里标识的元数据对代码进行分析【使用反射】
 * ③编译检查：通过代码里标识的元数据让编译器能够实现基本的编译检查【Override】
 */
public class OverrideDemoTest extends TestImpl implements TestService {

//    @Override它的作用是对覆盖超类中方法的方法进行标记，如果被标记的方法并没有实际覆盖超类中的方法，则编译器会发出错误警告。
//    @Override
    public String tostring() {
        return "测试注解";
    }

    @Override
    public void hello(){

    }

//    @Deprecated它的作用是对不应该再使用的方法添加注解，当编程人员使用这些方法时，将会在编译时显示提示信息
    @Deprecated
    public static void DeprecatedMethod() {
        System.out.println("DeprecatedMethod");
    }

    public static void main(String[] args) {
        OverrideDemoTest.DeprecatedMethod();
    }

//    @SuppressWarnings
//    其参数有：
//    deprecation，使用了过时的类或方法时的警告
//    unchecked，执行了未检查的转换时的警告
//    fallthrough，当 switch 程序块直接通往下一种情况而没有 break 时的警告
//    path，在类路径、源文件路径等中有不存在的路径时的警告
//    serial，当在可序列化的类上缺少serialVersionUID 定义时的警告
//    finally ，任何 finally 子句不能正常完成时的警告
//    all，关于以上所有情况的警告
    public static List list = new ArrayList();
    @SuppressWarnings("unchecked")
    @MethodInfo( author = "Max",date="201803")
    public void add(String data) {
        list.add(data);
    }
    @MethodInfo( author = "Max",date="201803")
    public void xx(){
        System.out.println("111");
    }
}
