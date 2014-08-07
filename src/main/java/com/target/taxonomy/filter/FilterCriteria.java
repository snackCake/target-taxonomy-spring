package com.target.taxonomy.filter;

import java.util.ArrayList;
import java.util.List;

import com.target.taxonomy.model.Tag;

/** 
 * Criteria for filtering a Taxonomy node
 * @author z013tp2
 *
 */
public class FilterCriteria 
{
	private List<Tag> includeTag;
	private List<Tag> requiredTag;
	private List<Tag> excludeTag;

    public FilterCriteria(List<Tag> theIncludeTag, List<Tag> theRequiredTag, List<Tag> theExcludeTag) {
        includeTag = theIncludeTag;
        requiredTag = theRequiredTag;
        excludeTag = theExcludeTag;
    }

    public FilterCriteria()
	{
		includeTag = new ArrayList<>();
		requiredTag = new ArrayList<>();
		excludeTag = new ArrayList<>();
	}

	public List<Tag> getIncludeTag() {
		return includeTag;
	}

	public void setIncludeTag(List<Tag> includeTag) {
		this.includeTag = includeTag;
	}

	public List<Tag> getRequiredTag() {
		return requiredTag;
	}

	public void setRequiredTag(List<Tag> requiredTag) {
		this.requiredTag = requiredTag;
	}

	public List<Tag> getExcludeTag() {
		return excludeTag;
	}

	public void setExcludeTag(List<Tag> excludeTag) {
		this.excludeTag = excludeTag;
	}
	
	
}
