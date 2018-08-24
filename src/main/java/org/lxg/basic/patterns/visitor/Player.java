package org.lxg.basic.patterns.visitor;

/**
 * Created by Administrator on 2017/3/20 0020.
 */

public interface Player {

    void visit(Shooting machine);

    void visit(Dancing machine);

    void visit(Driving machine);
}
