package com.target.taxonomy.parse;


import com.target.taxonomy.model.TaxonomyNode;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CsvParseTest {

    @Test
    public void testParse() throws IOException {
        Resource file = new ClassPathResource("Mega_Super_Taxonomy_Tool_V2.csv");
       TaxonomyNode node = CsvParser.parse(file.getFile().getPath());
        assertEquals(23, node.getChildnodes().size());

        List<TaxonomyNode> nodes =node.getChildnodes();
        System.out.println("blah");
    }
}
