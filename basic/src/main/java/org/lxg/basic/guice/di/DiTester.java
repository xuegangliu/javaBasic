package org.lxg.basic.guice.di;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.lxg.basic.guice.di.base.SomeService;
import org.lxg.basic.guice.di.base.impl.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class DiTester {
    private static final String STR1 = "first";
    private static final String STR2 = "second";
    private DiTester() {
    }

    public static void main(String[] args) {
        SomeService service;

        Injector injector = Guice.createInjector(new DataModule());
        Collection<Class> services = new ArrayList<Class>();
        services.add(SomeServiceImpl.class);
        services.add(TestConstructorDiServiceImpl.class);
        services.add(TestMethodDiServiceImpl.class);
        services.add(TestFieldDiServiceImpl.class);
        services.add(TestCustomAnnotationServiceImpl.class);

        for (Class serviceName : services) {
            service = (SomeService) injector.getInstance(serviceName);
            System.out.println(service.getClass().getSimpleName() + " " + service.processData(STR1, STR2));
        }

    }
}
