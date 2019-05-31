package org.lxg.basic.patterns.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class SetListCommand implements Command {

    private StoryPlayer mPlayer;

    private List<Story> mList = new ArrayList<>();

    public SetListCommand(StoryPlayer mPlayer) {
        this.mPlayer = mPlayer;
    }

    @Override public void execute() {
        mPlayer.setPlayList(mList);
    }

    public void setPlayList(List<Story> list) {
        this.mList = list;
    }
}
