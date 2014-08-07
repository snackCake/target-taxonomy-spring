package com.target.taxonomy.controller;

import com.target.taxonomy.filter.FilterCriteria;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.target.taxonomy.service.TaxonomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.target.taxonomy.model.TaxonomyNode;
import java.io.IOException;
import javax.servlet.ServletContext;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Controller
@RequestMapping("/taxonomy")
public class TaxonomyController {

    @Autowired
    private ServletContext servletContext;

    @Autowired
    private TaxonomyService taxonomyService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody TaxonomyNode getTaxonomy(@RequestParam(value="exclude[]", required = false) String[] excludeTags,
                                                  @RequestParam(value="required[]", required = false) String[] requiredTags,
                                                  @RequestParam(value="include[]", required = false) String[] includeTags)
                                                  throws IOException {
        FilterCriteria criteria = buildFilterCriteria(excludeTags, requiredTags, includeTags);

        return taxonomyService.buildRootNode(servletContext.getRealPath("assets/fixture/"), criteria);
    }

    private FilterCriteria buildFilterCriteria(String[] excludeTags, String[] requiredTags, String[] includeTags) {
        FilterCriteria criteria = new FilterCriteria();
        return criteria;
    }

}
