package com.target.taxonomy.model;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
public class TaxonomyNode {
    private String title;
    private String nodeId;
    private String seoUrl;
    private List<TaxonomyNode> childNodes;

    public String getTitle() {
        return title;
    }

    public void setTitle(String theTitle) {
        title = theTitle;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String theNodeId) {
        nodeId = theNodeId;
    }

    public String getSeoUrl() {
        return seoUrl;
    }

    public void setSeoUrl(String theSeoUrl) {
        seoUrl = theSeoUrl;
    }

    public List<TaxonomyNode> getChildNodes() {
        return childNodes;
    }

    public void setChildNodes(List<TaxonomyNode> theChildNodes) {
        childNodes = theChildNodes;
    }
}
