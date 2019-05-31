package org.lxg.basic.patterns.command;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class NextCommand implements Command {

    private StoryPlayer mPlayer;

    public NextCommand(StoryPlayer mPlayer) {
        this.mPlayer = mPlayer;
    }

    @Override public void execute() {
        mPlayer.next();
    }

}
