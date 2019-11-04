package com.lxg.problem.skills.jdk7;

import com.lxg.problem.skills.jdk7.SumTask;
import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * @author xuegangliu
 *  8/21/2018 10:09 AM
 *
 * @version: v1.0
 */
public class SumTaskTest {

    @Test
    public void sumTest(){
        // 创建随机数组成的数组:
        long[] array = new long[400];
        fillRandom(array);
        // fork/join task:
        ForkJoinPool fjp = new ForkJoinPool(4); // 最大并发数4
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        Long result = fjp.invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    public void fillRandom(long[] array){
        for(int i=0;i<array.length;i++){
//            array[i]= (long) Math.random()*100;
            array[i]= i;
        }

    }


//    @Test
    public void testNio() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("D:\\workspace\\lxg\\javaBasic\\src\\test\\resources\\data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(1024); // 分配内存

        int bytesRead = inChannel.read(buf);// 从Channel写数据到Buffer
        while (bytesRead != -1) {

            System.out.println(String.format("Read:[%s]", bytesRead));
            buf.flip();//从写模式调整为读模式

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear(); //清空 clear()所有 compact()清空已读数据
            bytesRead = inChannel.read(buf);
        }

        aFile.close();

        FileChannel t = new RandomAccessFile("D:\\workspace\\lxg\\javaBasic\\src\\test\\resources\\data1.txt","rw").getChannel();
        t.write(buf);

    }
}
