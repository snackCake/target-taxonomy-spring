package com.target.taxonomy.filter;

import java.util.Iterator;
import java.util.Stack;

import com.target.taxonomy.model.Tag;
import com.target.taxonomy.model.TaxonomyNode;

public class TaxonomyFilterManager 
{
	public static String ROOT_NODE = "root";
	public static String STANDARD_NODE = "standard";
	public static String VIRTUAL_NODE = "virtual";

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

	// Assumes that the structure is root -> standard and virtual
	public TaxonomyNode filterNodes(TaxonomyNode root, FilterCriteria filterCriteria)
	{
		// Deep copy original tree
		TaxonomyNode resultSet = new TaxonomyNode();

		// Preorder traversal through tree
		if(resultSet == null)
			return resultSet;

		Stack<TaxonomyNode> stack = new Stack<TaxonomyNode>();
		stack.push(resultSet);

		// Start at root
		while(!stack.empty())
		{
			TaxonomyNode n = stack.pop();

			// If root or top levels, go ahead
			for (Iterator<TaxonomyNode> it = n.getChildNodes().iterator(); it.hasNext();)
			{
				TaxonomyNode taxoNode = it.next();

				if (VIRTUAL_NODE.equalsIgnoreCase(n.getNodeId()) 
						|| ROOT_NODE.equalsIgnoreCase(n.getNodeId())
						|| STANDARD_NODE.equalsIgnoreCase(n.getNodeId()))
				{
					stack.push(taxoNode);
				}
				else if (checkCriteria(filterCriteria, taxoNode))
				{
					stack.push(taxoNode);
				}
				else
				{
					it.remove();
				}
			}
		}

		return resultSet;

	}

	private boolean checkCriteria(FilterCriteria filterCriteria, TaxonomyNode taxoNode) 
	{
		for (Tag tag : filterCriteria.getRequiredTag())
		{
			if (!taxoNode.getTags().contains(tag))
			{
				return false;
			}
		}
		
		for (Tag tag : filterCriteria.getExcludeTag())
		{
			if (taxoNode.getTags().contains(tag))
			{
				return false;
			}
		}
		
		boolean containsOne = false;
		if (filterCriteria.getIncludeTag().size() > 0)
		{
			for (Tag tag : filterCriteria.getIncludeTag())
			{
				if (taxoNode.getTags().contains(tag))
				{
					containsOne = true;
					break;
				}
			}
		}
		else
		{
			// No includes requested
			return true;
		}
		
		return containsOne;
	}
}
