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

    public Tag(String theName, TagType theTagType) {
        name = theName;
        tagType = theTagType;
    }

    public Tag(String theName)
    {
        if("women".equals(theName))
        {
            tagType =TagType.CATEGORY_TYPE;
        }
        else
        {
            tagType = TagType.DISPLAY_GROUP;
        }
        this.name = theName;

    }

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((tagType == null) ? 0 : tagType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tag other = (Tag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (tagType != other.tagType)
			return false;
		return true;
	}
	
	
	
}
