package org.lxg;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**************************
 * @description: SampleTest
 * @user: xuegangliu
 * @date: 2019/1/16
 ***************************/
public class SampleTest {

    @Test
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
