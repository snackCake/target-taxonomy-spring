package com.target.taxonomy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.target.taxonomy.service.TaxonomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
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
    public @ResponseBody TaxonomyNode printWelcome(ModelMap model) throws IOException {
        return taxonomyService.buildRootNode(servletContext.getRealPath("assets/fixture/TreeCategory.json"));
    }

}
