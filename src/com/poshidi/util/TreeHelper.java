package com.poshidi.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author dengzhifeng
 * @time 2009-1-7
 */
public class TreeHelper{


    public static String getAllChildrenJSONTrees(List source, String treeid){
        Tree tree = new Tree();
        TreeHelper.getAllChildrenTrees(source, treeid, tree);
        HashMap<String, Object> result=TreeHelper.transTree(tree);
        JSONObject json = JSONObject.fromObject(result);
        return json.toString();
    }

    /**
     * 获取所有孩子树
     *
     * @param source
     * @param treeid
     * @param tree
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Tree getAllChildrenTrees(List source, String treeid, Tree tree) {
        List directChildrenTrees = TreeHelper.getDirectChildrenTrees(source, treeid);
        Map currentTree = TreeHelper.getTree(source, treeid);
        Tree tmp = null;
        if (StringUtils.isEmpty(tree.getId())) {
            TreeHelper.MapToObject(tree, currentTree);
            tmp = tree;
        } else {
            Tree tmptree = new Tree();
            TreeHelper.MapToObject(tmptree, currentTree);
            tmp = new Tree(tmptree.getId(), tmptree.getName(), tree);
        }
        Iterator it = directChildrenTrees.iterator();
        while (it.hasNext()) {
            Map item = (Map) it.next();
            if (TreeHelper.isHaveParent(source, item)) {
                TreeHelper.getAllChildrenTrees(source, item.get("id").toString(),
                        tmp);
            } else {
//				new Tree(currentTree.get("id").toString(), currentTree.get(
//						"text").toString(), currentTree.get("url").toString(),
//						tree);
                Tree tmptree = new Tree();
                TreeHelper.MapToObject(tmptree, currentTree);
                tmp = new Tree(tmptree.getId(), tmptree.getName(), tree);
            }
        }
        return tree;
    }

    /**
     * 把树转为json结构树
     *
     * @param tree
     * @return
     */
    public static HashMap<String, Object> transTree(Tree tree) {
        HashMap<String, Object> value = new HashMap<String, Object>();
        value.put("id", tree.getId());
        value.put("name", tree.getName());
        if (tree.hasChilds()) {
            List<HashMap<String, Object>> childs = new ArrayList<HashMap<String, Object>>();
            Iterator<Tree> itr = tree.getChildIterator();
            while (itr.hasNext()) {
                Tree tmp = itr.next();
                HashMap<String, Object> tmpv = TreeHelper
                        .transTree(tmp);
                childs.add(tmpv);
            }
            value.put("children", childs);
        } else {
            value.put("leaf", true);
        }
        return value;
    }


    /**
     * 判断是否有父结点
     *
     * @param source
     * @param transedTree
     * @return
     */
    @SuppressWarnings("unchecked")
    public static boolean isHaveParent(List source, Map transedTree) {
        boolean result = false;
        if (source.isEmpty() || source.size() < 1 || source == null
                || transedTree.isEmpty() || transedTree == null) {
            return result;
        } else {
            if (transedTree.get("parent_id") == null) {
                result = false;
            } else {
                Map parentTree = TreeHelper.getTree(source, transedTree.get(
                        "parent_id").toString());
                if (null == parentTree || parentTree.isEmpty()) {
                    result = false;
                } else {
                    if (source.contains(parentTree)) {
                        result = true;
                    } else {
                        result = false;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 获取所有的直接孩子结点
     *
     * @param source
     * @param treeid
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List getDirectChildrenTrees(List source, String treeid) {
        List result = new ArrayList();
        Iterator it = source.iterator();
        while (it.hasNext()) {
            Map item = (Map) it.next();
            if (item.get("parent_id") != null) {
                if (item.get("parent_id").toString().equals(treeid)) {
                    result.add(item);
                }
            }
        }
        return result;
    }

    /**
     * 获取结点本身
     *
     * @param source
     * @param treeid
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map getTree(List source, String treeid) {
        Map result = null;
        if (source.isEmpty() || source.size() < 1
                || StringUtils.isEmpty(treeid)) {
            return null;
        }
        Iterator it = source.iterator();
        while (it.hasNext()) {
            Map item = (Map) it.next();
            if (item.get("id").toString().equals(treeid)) {
                result = item;
                break;
            }
        }
        return result;
    }

    private static void MapToObject(Object object, Map<String, String> map) {
        JSONObject json = JSONObject.fromObject(map);
        Object tempobject = JSONObject.toBean(json);
        try {
            BeanUtils.copyProperties(object, tempobject);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
