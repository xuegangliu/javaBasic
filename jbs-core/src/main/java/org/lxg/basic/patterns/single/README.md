# 单例模式

## 定义

确保一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。

## 类型

创建类模式

## 要素

- 私有的构造方法

- 指向自己实例的私有静态引用

- 以自己实例为返回值的静态的公有的方法

## 单例模式的优点：

- 在内存中只有一个对象，节省内存空间。

- 避免频繁的创建销毁对象，可以提高性能。

- 避免对共享资源的多重占用。

- 可以全局访问。

## 适用场景

由于单例模式的以上优点，所以是编程中用的比较多的一种设计模式。我总结了一下我所知道的适合使用单例模式的场景：

- 需要频繁实例化然后销毁的对象。

- 创建对象时耗时过多或者耗资源过多，但又经常用到的对象。

- 有状态的工具类对象。

- 频繁访问数据库或文件的对象。

- 以及其他我没用过的所有要求只有一个对象的场景。

##  单例模式注意事项：

  - 只能使用单例类提供的方法得到单例对象，不要使用反射，否则将会实例化一个新对象。

  - 不要做断开单例类对象与类中静态引用的危险操作。

  - 多线程使用单例使用共享资源时，注意线程安全问题。

## 例子

- Single_1.java ：饿汉模式

- Single_2.java ：懒汉模式(线程不安全，不可用)

- Single_3.java ：懒汉模式(线程安全，但效率低，不推荐使用)

- Single_4.java ：懒汉模式双重校验锁

- Single_5.java ：静态内部类实现单例模式

- Single_6.java ：枚举实现单例模式

- Single_7.java ：使用容器实现单例模式