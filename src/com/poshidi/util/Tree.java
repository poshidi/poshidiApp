package com.poshidi.util;

/**
 * Created by Administrator on 2015/10/12.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author qinshenghui
 * @descrip Ê÷½Úµã
 * @time 2015-09-30
 */
public class Tree {
    private String id;
    private String name;
    private Tree parent;
    private List<Tree> childs = new ArrayList<Tree>();

    public Tree() {
    }


    public Tree(String id, String name, Tree parent) {
        this.id = id;
        this.name = name;
        this.parent = parent;
        if (this.parent != null) {
            this.parent.addChild(this);
        }
    }

    public boolean addChild(Tree Tree) {
        return this.childs.add(Tree);
    }

    public Iterator<Tree> getChildIterator() {
        return childs.iterator();
    }

    public List<Tree> getChilds() {
        return this.childs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    public int level() {
        int result = 0;
        while (this.parent != null) {
            result++;
        }
        return result;
    }

    public boolean hasChilds() {
        return !this.childs.isEmpty();
    }

    public Tree getFirstLeaf() {
        if (this.hasChilds()) {
            return this.childs.get(0).getFirstLeaf();
        }
        return this;
    }

    public Tree getTopParent() {
        if (this.parent == null) {
            return this;
        } else {
            return this.parent.getTopParent();
        }
    }

    public List<Tree> getTreePath() {
        List<Tree> list = new ArrayList<Tree>();
        Tree tmp = this.getParent();
        while (tmp != null) {
            list.add(tmp);
            tmp = tmp.getParent();
        }
        return list;
    }

    public String getStringPath() {
        StringBuffer sb = new StringBuffer();
        List<Tree> tmp = this.getTreePath();
        for (int i = tmp.size() - 1; i >= 0; i--) {
            Tree Tree = tmp.get(i);
            sb.append(Tree.getName() + ".");
        }
        sb.append(this.getName());
        return sb.toString();
    }
}
