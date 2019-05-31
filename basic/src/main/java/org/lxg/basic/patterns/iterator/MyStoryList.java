package org.lxg.basic.patterns.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public class MyStoryList implements SongList{
    private List<Song> list = new ArrayList<>();

    public MyStoryList(List<Song> list) {
        this.list = list;
    }

    @Override
    public Iterator getIterator() {
        return new SongListIterator();
    }

    private class SongListIterator implements Iterator {

        private int cursor;

        @Override
        public Song first() {
            cursor = 0;
            return list.get(cursor);
        }

        @Override
        public Song next() {
            Song song = null;
            cursor++;
            if(hashNext()) {
                song = list.get(cursor);
            }
            return song;
        }

        @Override
        public boolean hashNext() {
            return cursor != list.size();
        }

        @Override
        public Song currentItem() {
            return list.get(cursor);
        }
    }


}
