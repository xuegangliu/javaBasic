package org.lxg.basic.patterns.iterator;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class Song {

    private String name;

    private String singer;

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name;}

    public String getSinger() { return singer; }

    public void setSinger(String singer) { this.singer = singer; }

    @Override public String toString() {
        return "【歌名】" + name + " - " + singer;
    }
}
