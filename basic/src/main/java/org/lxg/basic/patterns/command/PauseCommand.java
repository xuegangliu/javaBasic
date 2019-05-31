package org.lxg.basic.patterns.command;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class PauseCommand implements Command {

    private StoryPlayer mPlayer;

    public PauseCommand(StoryPlayer mPlayer) {
        this.mPlayer = mPlayer;
    }

    @Override public void execute() {
        mPlayer.pause();
    }

}
