package com.poshidi.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Created by poshidi on 2015/10/14.
 */
@Controller
@RequestMapping("/main")
public class MainController {
    protected static Logger logger = Logger.getLogger("controller");

    /**
     * 跳转到commonpage页面
     *
     * @return
     */
    @RequestMapping(value = "/common", method = RequestMethod.GET)
    public String getCommonPage() {
        logger.debug("Received request to show common page");
        return "/securty/commonpage";
    }

    /**
     * 跳转到adminpage页面
     *
     * @return
     */
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String getAadminPage() {
        logger.debug("Received request to show admin page");
        return "/securty/adminpage";

    }
}
