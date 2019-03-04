lombok使用
---
|名称|描述|日期|作者|
|---|---|---|---|
|lombok|lombok基础用法|@date:2019-01-07|by xuegangliu|

## 网站

- [官网](https://projectlombok.org)
- [日志](https://projectlombok.org/features/log)

## 常用注解
```
@Data 注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
@Setter ：注解在属性上；为属性提供 setting 方法
@Getter ：注解在属性上；为属性提供 getting 方法
@Log4j ：注解在类上；为类提供一个 属性名为log 的 log4j 日志对象
@NoArgsConstructor ：注解在类上；为类提供一个无参的构造方法
@AllArgsConstructor ：注解在类上；为类提供一个全参的构造方法
@Cleanup : 可以关闭流
@Builder ： 被注解的类加个构造者模式
@Synchronized ： 加个同步锁
@SneakyThrows : 等同于try/catch 捕获异常
@NonNull : 如果给参数加个这个注解 参数为null会抛出空指针异常
@Value : 注解和@Data类似，区别在于它会把所有成员变量默认定义为private final修饰，并且不会生成set方法。
@toString：注解在类上；为类提供toString方法（可以添加排除和依赖）
```

## log
```$xslt
//@CommonsLog
private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LogExample.class);
//@JBossLog
private static final org.jboss.logging.Logger log = org.jboss.logging.Logger.getLogger(LogExample.class);
//@Log
private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());
//@Log4j
private static final org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(LogExample.class);
//@Log4j2
private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LogExample.class);
//@Slf4j
private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);
//@XSlf4j
private static final org.slf4j.ext.XLogger log = org.slf4j.ext.XLoggerFactory.getXLogger(LogExample.class);
```