package com.target.taxonomy.model;

/**
 * Type for a tag, which can be attached to taxonomy nodes
 * @author z013tp2
 *
 */
public class Tag 
{
	private String name;
	private TagType tagType;
	
	public enum TagType 
	{
		DISPLAY_GROUP, CATEGORY_TYPE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TagType getTagType() {
		return tagType;
	}

	public void setTagType(TagType tagType) {
		this.tagType = tagType;
	}
	
	
}
