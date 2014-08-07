package com.target.taxonomy.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import com.target.taxonomy.model.Tag;
import com.target.taxonomy.model.Tag.TagType;
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

	public TaxonomyNode buildFullTree(TaxonomyNode root, FilterCriteria filterCriteria)
	{
		// Get the standard tree and virtual tree
		TaxonomyNode standardTree = TaxonomyNode.findNode(root, STANDARD_NODE);
		TaxonomyNode virtualTree = TaxonomyNode.findNode(root, VIRTUAL_NODE);
		
		// Deep copy stajdard tree
		TaxonomyNode resultSet = new TaxonomyNode(standardTree);
		
		// Filter the virtual nodes, and add them to the right place
		
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
			for (Iterator<TaxonomyNode> it = n.getChildnodes().iterator(); it.hasNext();)
			{
				TaxonomyNode taxoNode = it.next();
				stack.push(taxoNode);
				
				// Get the L1 title
				String nodeTitle = n.getTitle();
				
				// Get all virtuals with this in the name
				FilterCriteria newFilterCriteria = new FilterCriteria();
				newFilterCriteria.getIncludeTag().add(new Tag(taxoNode.getTitle(), TagType.CATEGORY_TYPE));
				List<TaxonomyNode> virtualNodes = filterNodesFlat(taxoNode, newFilterCriteria);
				
				n.getChildnodes().addAll(virtualNodes);
				
			}
		}

		return resultSet;

	}
	
	public List<TaxonomyNode> filterNodesFlat(TaxonomyNode root, FilterCriteria filterCriteria)
	{
		// Deep copy original tree
		TaxonomyNode resultSet = new TaxonomyNode(root);
		List<TaxonomyNode> returnSet = new ArrayList<>();
		
		// Preorder traversal through tree
		if(resultSet == null)
			return returnSet;

		Stack<TaxonomyNode> stack = new Stack<TaxonomyNode>();
		stack.push(resultSet);

		// Start at root
		while(!stack.empty())
		{
			TaxonomyNode n = stack.pop();

			// If root or top levels, go ahead
			for (Iterator<TaxonomyNode> it = n.getChildnodes().iterator(); it.hasNext();)
			{
				TaxonomyNode taxoNode = it.next();

				if (VIRTUAL_NODE.equalsIgnoreCase(n.getNodeid()) 
						|| ROOT_NODE.equalsIgnoreCase(n.getNodeid())
						|| STANDARD_NODE.equalsIgnoreCase(n.getNodeid()))
				{
					stack.push(taxoNode);
					returnSet.add(n);
				}
				else if (checkCriteria(filterCriteria, taxoNode))
				{
					stack.push(taxoNode);
					returnSet.add(n);
				}

			}
		}

		return returnSet;
	}
	
	// Assumes that the structure is root -> standard and virtual
	public TaxonomyNode filterNodes(TaxonomyNode root, FilterCriteria filterCriteria)
	{
		// Deep copy original tree
		TaxonomyNode resultSet = new TaxonomyNode(root);

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
			for (Iterator<TaxonomyNode> it = n.getChildnodes().iterator(); it.hasNext();)
			{
				TaxonomyNode taxoNode = it.next();

				if (VIRTUAL_NODE.equalsIgnoreCase(n.getNodeid()) 
						|| ROOT_NODE.equalsIgnoreCase(n.getNodeid())
						|| STANDARD_NODE.equalsIgnoreCase(n.getNodeid()))
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

	public boolean checkCriteria(FilterCriteria filterCriteria, TaxonomyNode taxoNode) 
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
