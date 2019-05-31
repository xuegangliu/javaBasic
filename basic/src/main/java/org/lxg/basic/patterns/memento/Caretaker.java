package org.lxg.basic.patterns.memento;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
