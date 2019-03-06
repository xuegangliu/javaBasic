package com.lxg.core.tools;

import com.lxg.core.util.ClassUtils;
//import com.sun.tools.attach.AgentInitializationException;
//import com.sun.tools.attach.AgentLoadException;
//import com.sun.tools.attach.AttachNotSupportedException;
//import com.sun.tools.attach.VirtualMachine;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.File;
import java.io.IOException;
import java.lang.management.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**************************
 * @description: ToolsTest
 * @author: xuegangliu
 * @date: 2019/3/1 9:45
 ***************************/
@Slf4j
public class ToolsTest {

    private final static String JMX_URL="service:jmx:rmi:///jndi/rmi://127.0.0.1:9999/jmxrmi";

    @Test
    public void testHostServer() throws IOException, InvocationTargetException, IllegalAccessException {
        // 获取到JVM Manage信息
        // 监控应用与被监控应用位于同一JVM
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        printInfo(server);
    }

    @Test
    public void testJMXConnector() throws IOException, InvocationTargetException, IllegalAccessException {
        // 获取到JVM Manage信息
        // 连接到代理上
        JMXServiceURL url = new JMXServiceURL(JMX_URL);
        JMXConnector connector = JMXConnectorFactory.connect(url);
        printInfo(connector.getMBeanServerConnection());
    }

//    @Test
//    public void testAttach() throws IOException, AttachNotSupportedException, AgentLoadException, AgentInitializationException, InvocationTargetException, IllegalAccessException {
//        // 监控应用与被监控应用不位于同一JVM但在同一物理主机上
//        // 通过进程Attach
//
//        //Attach 到5656的JVM进程上，后续Attach API再讲解 lib/tools.jar
//        VirtualMachine virtualmachine = VirtualMachine.attach("5524");
//        //让JVM加载jmx Agent，后续讲到Java Instrutment再讲解
//        String javaHome = virtualmachine.getSystemProperties().getProperty("java.home");
//        String jmxAgent = javaHome + File.separator + "lib" + File.separator + "management-agent.jar";
//        virtualmachine.loadAgent(jmxAgent, "com.sun.management.jmxremote");
//        //获得连接地址
//        Properties properties = virtualmachine.getAgentProperties();
//        String address = (String)properties.get("com.sun.management.jmxremote.localConnectorAddress");
//        //Detach
//        virtualmachine.detach();
//        JMXServiceURL url = new JMXServiceURL(address);
//        JMXConnector connector = JMXConnectorFactory.connect(url);
//        printInfo(connector.getMBeanServerConnection());
//    }

    public void printInfo(MBeanServerConnection connection) throws IOException, InvocationTargetException, IllegalAccessException {
        RuntimeMXBean runtimeMXBean = ManagementFactory.newPlatformMXBeanProxy(connection,
                ManagementFactory.RUNTIME_MXBEAN_NAME,
                RuntimeMXBean.class);
        ClassUtils.excuteObjMethod(runtimeMXBean);

        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.newPlatformMXBeanProxy(connection,
                ManagementFactory.CLASS_LOADING_MXBEAN_NAME, ClassLoadingMXBean.class);
        ClassUtils.excuteObjMethod(classLoadingMXBean);

        MemoryMXBean memoryMXBean = ManagementFactory.newPlatformMXBeanProxy(connection,
                ManagementFactory.MEMORY_MXBEAN_NAME, MemoryMXBean.class);
        ClassUtils.excuteObjMethod(memoryMXBean);

        ThreadMXBean threadMXBean = ManagementFactory.newPlatformMXBeanProxy(connection,
                ManagementFactory.THREAD_MXBEAN_NAME, ThreadMXBean.class);
        ClassUtils.excuteObjMethod(threadMXBean);

        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.newPlatformMXBeanProxy(connection,
                ManagementFactory.OPERATING_SYSTEM_MXBEAN_NAME, OperatingSystemMXBean.class);
        ClassUtils.excuteObjMethod(operatingSystemMXBean);
    }
}
