package com.target.taxonomy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.target.taxonomy.service.TaxonomyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Josh Klun (jklun@nerdery.com)
 */
@Controller
@RequestMapping("/taxonomy")
public class TaxonomyController {

    @Autowired
    private TaxonomyService taxonomyService;


}
