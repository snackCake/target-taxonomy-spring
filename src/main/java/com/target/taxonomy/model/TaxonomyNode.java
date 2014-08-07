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
    private String nodeid;
    private String seourl;
    private List<TaxonomyNode> childnodes;
    private Set<Tag> tags;

    public TaxonomyNode() 
    {
        childnodes = new ArrayList<TaxonomyNode>();
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

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
}
