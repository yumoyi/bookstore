package com.bookstore.demo.controlller;

import com.bookstore.demo.service.CategorysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author cy
 * @since 2019-08-20 17:14
 */
@Controller
public class CategorysController {

    @Autowired
    private CategorysService categorysService;
}
