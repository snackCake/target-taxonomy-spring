package com.target.taxonomy.service;

import com.target.taxonomy.parse.CsvParser;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.taxonomy.model.TaxonomyNode;
import java.io.File;
import java.io.IOException;
import com.target.taxonomy.filter.FilterCriteria;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Service
public class FileTaxonomyService implements TaxonomyService {

    private TaxonomyNode virtualNode;
    private TaxonomyNode standardNode;

    @Override
    public TaxonomyNode buildRootNode(String nodePath, FilterCriteria criteria) throws IOException {
        ensureRootTreeLoaded(nodePath);
        return mergeTaxonomyNode(criteria);
    }

    private TaxonomyNode mergeTaxonomyNode(FilterCriteria criteria) {
        TaxonomyNode rootNode = new TaxonomyNode();
        rootNode.setTitle("root");
        rootNode.addChildNode(standardNode);
        rootNode.addChildNode(virtualNode);
        return rootNode;
    }

    @Override
    public TaxonomyNode buildVirtualNode(String path) throws IOException {
        if(virtualNode == null)
        {
           virtualNode = CsvParser.parse(path);

        }
        return virtualNode;
    }

    @Override
    public TaxonomyNode buildStandardNode(String path) throws IOException {
        if (standardNode == null) {
            File jsonRoot = new File(path);
            ObjectMapper jsonMapper = new ObjectMapper();
            standardNode = jsonMapper.readValue(jsonRoot, TaxonomyNode.class);
        }
        return standardNode;
    }

    private void ensureRootTreeLoaded(String nodePath) throws IOException {
        //make regular
        buildStandardNode(nodePath + "/TreeCategory.json");
        //make virtual
        buildVirtualNode(nodePath + "/Mega_Super_Taxonomy_Tool_V2.csv");

    }

}
