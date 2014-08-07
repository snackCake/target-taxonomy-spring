package com.target.taxonomy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
public class TaxonomyNode {
    private String title;
    private String nodeid;
    private String seourl;
    private String desktopUrl;
    private String mobileUrl;
    private String v1;
    private List<TaxonomyNode> childnodes;
    private String tagsString;
    private HashSet<Tag> tags;

    public TaxonomyNode() 
    {
        childnodes = new ArrayList<>();
        tags = new HashSet<>();
    }

    public TaxonomyNode(TaxonomyNode original) 
    {
        this();
        title = original.getTitle();
        nodeid = original.getNodeid();
        seourl = original.getSeourl();
        
        for (TaxonomyNode childNode : original.childnodes) 
        {
            childnodes.add(new TaxonomyNode(childNode));
        }
        for (Tag tag : original.tags)
        {
            tags.add(new Tag(tag.getName(), tag.getTagType()));
        }
    }
    
    /**
     * Find a node
     * @param node
     * @param nodeid
     * @return
     */
    public static TaxonomyNode findNode(TaxonomyNode node, String nodeid)
    {
    	TaxonomyNode resultNode = null;
    	if (node.nodeid.equalsIgnoreCase(nodeid))
    	{
    		resultNode = node;
    	}
    	else
    	{
    		if (node.getChildnodes() == null || node.getChildnodes().size() == 0)
    		{
    			return null;
    		}
    		else
    		{
    			for (TaxonomyNode taxoNode : node.getChildnodes())
    			{
    				resultNode = findNode(taxoNode, nodeid);
    				if (resultNode != null) 
    				{
    					return resultNode;
    				}
    			}
    		}
    	}
    		
    	return resultNode;
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

    public String getDesktopUrl() {
        return desktopUrl;
    }

    public void setDesktopUrl(String desktopUrl) {
        this.desktopUrl = desktopUrl;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public HashSet<Tag> getTags() {
        return tags;
    }

    public void setTags(HashSet<Tag> tags) {
        this.tags = tags;
    }

    public void addChildNode(TaxonomyNode taxonomyNode) {
        if(childnodes == null)
        {
            childnodes = new ArrayList<TaxonomyNode>();
        }
        childnodes.add(taxonomyNode);
    }

    public String getTagsString() {
        return tagsString;
    }

    public void setTagsString(String tagsString) {
        this.tagsString = tagsString;
    }

    public void addTag(Tag tag) {
        if(tags == null)
        {
            tags = new HashSet<>();
        }
        tags.add(tag);
    }
}
