# guice introduce

## 注入方式

- 构造注入

- 属性注入

- 函数(setter)注入

## Module 依赖注册

需要继承至AbstractModule，实现configure方法.用Binder配置依赖

- 基本配置：binder.bind(serviceClass).to(implClass).in(Scopes.[SINGLETON | NO_SCOPE]);

- 无base类、接口配置：binder.bind(implClass).in(Scopes.[SINGLETON | NO_SCOPE]);

- service实例配置：binder.bind(serviceClass).toInstance(servieInstance).in(Scopes.[SINGLETON | NO_SCOPE]);

- 多个实例按名注入：binder.bind(serviceClass).annotatedWith(Names.named(“name”)).to(implClass).in(Scopes.[SINGLETON | NO_SCOPE]);

- 运行时注入：利用@Provides标注注入方法，相当于spring的@Bean。

- @ImplementedBy：或者在实现接口之上标注@ImplementedBy指定其实现类。这种方式有点反OO设计，抽象不该知道其实现类。