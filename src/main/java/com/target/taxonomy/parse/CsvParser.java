package com.target.taxonomy.parse;


import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.target.taxonomy.model.TaxonomyNode;

import java.io.File;
import java.io.IOException;

public class CsvParser {


    public static TaxonomyNode parse(String path) throws IOException {
        //V1,Tags,Title,Site URL,Mobile URL,,
        CsvSchema schema = CsvSchema.builder()
                .addColumn("v1")
                .addColumn("tags")
                .addColumn("title")
                .addColumn("desktopUrl")
                .addColumn("mobileUrl")
                .build();
        CsvMapper mapper = new CsvMapper();
        TaxonomyNode parent = new TaxonomyNode();
        ObjectReader reader = mapper.reader(TaxonomyNode.class).with(schema);
        MappingIterator<TaxonomyNode> nodes = reader.readValues(new File(path));
        for(;nodes.hasNextValue();)
        {
            parent.addChildNode(nodes.nextValue());
        }
        return parent;
    }
}
