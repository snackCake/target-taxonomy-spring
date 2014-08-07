package com.target.taxonomy.model;

import java.util.ArrayList;
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
    private String tags;

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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public String getDesktopUrl() {
        return desktopUrl;
    }

    public void setDesktopUrl(String desktopUrl) {
        this.desktopUrl = desktopUrl;
    }

    public String getV1() {
        return v1;
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public void addChildNode(TaxonomyNode taxonomyNode) {
        if(childnodes == null)
        {
            childnodes = new ArrayList<TaxonomyNode>();
        }
        childnodes.add(taxonomyNode);
    }
}
