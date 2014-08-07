package com.target.taxonomy.service;

import com.target.taxonomy.model.TaxonomyNode;
import com.target.taxonomy.filter.FilterCriteria;

import java.io.IOException;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
public interface TaxonomyService {
    TaxonomyNode buildRootNode(String nodePath, FilterCriteria criteria) throws IOException;
    TaxonomyNode buildVirtualNode(String path) throws IOException;
    TaxonomyNode buildStandardNode(String path) throws IOException;
}
