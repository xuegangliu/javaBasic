利用JMX统计远程JAVA进程的CPU和Memory
---
|名称|描述|日期|作者|
|---|---|---|---|
|JMX统计|jVM managerment API|2019-01-07|by xuegangliu|

java.lang.management 包，包里提供了许多MXBean的接口类
可以很方便的获取到JVM的内存、GC、线程、锁、class、甚至操作系统层面的各种信息,一种利用JMX对JAVA进程进行CPU、堆内存使用的监控

## 需要开启的参数
被测程序必须开放JMXREMOTE端口，具体使用参数：

```
-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=[开放的端口]
-Dcom.sun.management.jmxremote.authenticate=false 
-Dcom.sun.management.jmxremote.ssl=false
```