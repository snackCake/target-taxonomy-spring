package com.target.taxonomy.service;

import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.target.taxonomy.model.TaxonomyNode;
import java.io.File;
import java.io.IOException;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Service
public class FileTaxonomyService implements TaxonomyService {

    private TaxonomyNode referenceRootNode;

    @Override
    public TaxonomyNode buildRootNode(String nodePath) throws IOException {
        ensureRootTreeLoaded(nodePath);

        return new TaxonomyNode(referenceRootNode);
    }

    private void ensureRootTreeLoaded(String nodePath) throws IOException {
        if (referenceRootNode == null) {
            File jsonRoot = new File(nodePath);
            ObjectMapper jsonMapper = new ObjectMapper();
            referenceRootNode = jsonMapper.readValue(jsonRoot, TaxonomyNode.class);
        }
    }

}
