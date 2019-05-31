package org.lxg.basic.patterns.command;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class PlayCommand implements Command {

    private StoryPlayer mPlayer;

    public PlayCommand(StoryPlayer mPlayer) {
        this.mPlayer = mPlayer;
    }

    @Override public void execute() {
        mPlayer.play();
    }

}
