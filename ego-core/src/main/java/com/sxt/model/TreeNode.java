package com.sxt.model;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/***
 * 生成zTreeNode树
 * @author Luo
 */
public class TreeNode implements Serializable {

    private String id;
    private String name;
    private boolean isParent;
    private boolean checked;
    private String url;
    /**
     * 子节点
     */
    private List<TreeNode> children;
    private Map<String, Object> attribute;
    private String icon;

    public TreeNode() {
    }

    public TreeNode(String id, String name, boolean isParent, boolean checked, String url, List<TreeNode> children, Map<String, Object> attribute, String icon) {
        this.id = id;
        this.name = name;
        this.isParent = isParent;
        this.checked = checked;
        this.url = url;
        this.children = children;
        this.attribute = attribute;
        this.icon = icon;
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

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public Map<String, Object> getAttribute() {
        return attribute;
    }

    public void setAttribute(Map<String, Object> attribute) {
        this.attribute = attribute;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
