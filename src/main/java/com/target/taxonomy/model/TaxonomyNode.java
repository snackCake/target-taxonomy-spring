package com.target.taxonomy.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
public class TaxonomyNode 
{
    private String title;
    private String nodeId;
    private String seoUrl;
    private List<TaxonomyNode> childNodes;
    private Set<Tag> tags;
    
    public TaxonomyNode()
    {
    	childNodes = new ArrayList<>();
    	tags = new HashSet<>();
    }
    
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

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
}
