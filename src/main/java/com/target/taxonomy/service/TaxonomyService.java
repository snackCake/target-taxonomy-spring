package com.target.taxonomy.service;

import com.target.taxonomy.model.TaxonomyNode;

import java.io.IOException;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
public interface TaxonomyService {
    TaxonomyNode buildRootNode(String nodePath) throws IOException;
    TaxonomyNode buildVirtualNode(String path) throws IOException;
    TaxonomyNode buildStandardNode(String path) throws IOException;
}
