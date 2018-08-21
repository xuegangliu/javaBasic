package org.lxg.basic.patterns.command;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuegangliu
 * @date: 8/21/2018 11:35 AM
 * @DES:
 * @version: v1.0
 */
public class ClientTest {

    @Test
    public void storyTest(){
        //实例化播放列表
        List<Story> mList = new ArrayList<>();
        mList.add(new Story("白雪公主","aaaaa"));
        mList.add(new Story("青蛙的愿望","bbbbb"));
        mList.add(new Story("驴和妈","ccccc"));
        mList.add(new Story("小青蛙的烦恼","ddddd"));
        mList.add(new Story("三字经","eeeee"));

        //实例化接收者
        StoryPlayer mPlayer = new StoryPlayer();

        //实例化命令对象
        Command setListCommand = new SetListCommand(mPlayer);
        Command playCommand = new PlayCommand(mPlayer);
        Command pauseCommand = new PauseCommand(mPlayer);
        Command nextCommand = new NextCommand(mPlayer);
        Command preCommand = new PreCommand(mPlayer);

        //实例化请求者
        Invoker invoker = new Invoker();
        invoker.setSetListCommand((SetListCommand) setListCommand);
        invoker.setPlayList(mList);
        invoker.setPlayCommand((PlayCommand) playCommand);
        invoker.setPauseCommand((PauseCommand) pauseCommand);
        invoker.setNextCommand((NextCommand) nextCommand);
        invoker.setPreCommand((PreCommand) preCommand);

        //测试调用
        invoker.play();
        invoker.next();
        invoker.next();
        invoker.next();
        invoker.next();
        invoker.next();
        invoker.pause();
        invoker.play();
    }
}
