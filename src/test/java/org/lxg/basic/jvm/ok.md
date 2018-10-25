# Java内存

## 栈内存

1. 线程私有

1. 生命周期和线程相同

1. 主要存放内容

    – 基本数据类型（int,char,float,double…）
    
    – 对象的引用，指向了对象在堆内存中起始地址
    
    – 通过-Xss参数配置

## 堆内存-heap

1. 堆内存是Jvm中空间最大的区域

1. 所有线程共享堆内存

1. 所有的数组以及对象的实例都在此区域分配

1. 堆内存大小通过参数进行配置

    -Xmx：最大堆内存
    
    -Xms：最小堆内存

1. 堆内存构成

    – 新生代：包括三块区域，eden、from survivor(s0)、to survivor(s1)
    
    – 老年代：old gen

比如，Object o = new Object()

其中，o存放在栈内存中，new Object()存放在堆内存中，变量o是Object对象的引用，o上存放了Object对象占用内存的起始地址

## 永久代-PermGen

1. 永久代也叫方法区（Method Area）
    
1. 各线程共享，主要存放类信息、常量、静态变量，如public static int a = 10
    
1. 垃圾回收行为比较少见

## 垃圾回收-GC

1. 新生代引发的GC叫YoungGC

1. 老年代引发的GC叫FullGC

    FullGC会引起整个Jvm的用户线程暂停，待垃圾回收完毕后，才继续运行

## 永久代的回收

1. 永久代回收“性价比”比较低

1. 主要回收
    
    – 废弃的常量
    
    – 无用的类

1. 类的所有实例都已经被回收

1. 加载该类的ClassLoader已经被回收

1. 该类的Class对象没有在任何地方被引用

## 内存溢出

1. 堆内存溢出

    – 堆内存中存在大量对象，这些对象都有被引用，当所有对象占用空间达到堆内存的最大值，就会出现内存溢出OutOfMemory:Java heap space

1. 永久代溢出

    – 类的一些信息，如类名、访问修饰符、字段描述、方法描述等，所占空间大于永久代最大值，就会出现OutOfMemoryError:PermGen space

## 内存泄露检测手段

– Jconsole

– Jvisualvm

– Jstat –gcutil pid 1000 100

– Jmap –histo pid | head -20

– Jmap –heap pid