package org.lxg.basic.patterns.visitor;

/**
 * @author xuegangliu
 * @date 2017/3/16 0016.
 */
public interface Player {

    /**
     * visit
     * @param machine
     */
    void visit(Shooting machine);

    /**
     * visit
     * @param machine
     */
    void visit(Dancing machine);

    /**
     * visit
     * @param machine
     */
    void visit(Driving machine);
}
