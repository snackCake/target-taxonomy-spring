package com.target.taxonomy.model;

import java.util.List;
import java.util.ArrayList;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
public class TaxonomyNode {
    private String title;
    private String nodeid;
    private String seourl;
    private List<TaxonomyNode> childnodes;
    private List<Tag> tags;

    public TaxonomyNode() {
        childnodes = new ArrayList<TaxonomyNode>();
        tags = new ArrayList<Tag>();
    }

    public TaxonomyNode(TaxonomyNode original) {
        this();
        title = original.title;
        nodeid = original.nodeid;
        seourl = original.seourl;
        for (TaxonomyNode childNode : original.childnodes) {
            childnodes.add(new TaxonomyNode(childNode));
        }
        for (Tag tag : original.tags) {
            tags.add(new Tag(tag.getName(), tag.getTagType()));
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String theTitle) {
        title = theTitle;
    }

    public String getNodeid() {
        return nodeid;
    }

    public void setNodeid(String theNodeid) {
        nodeid = theNodeid;
    }

    public String getSeourl() {
        return seourl;
    }

    public void setSeourl(String theSeourl) {
        seourl = theSeourl;
    }

    public List<TaxonomyNode> getChildnodes() {
        return childnodes;
    }

    public void setChildnodes(List<TaxonomyNode> theChildnodes) {
        childnodes = theChildnodes;
    }

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
}
