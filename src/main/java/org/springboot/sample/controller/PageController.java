package org.springboot.sample.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	// 从 application.properties 中读取配置，如取不到默认值为Hello Shanhy
    @Value("${application.hell:Hello Shanhy}")
    private String hello = "Hello Shanhy";

    /**
     * 默认页<br/>
     * @RequestMapping("/") 和 @RequestMapping 是有区别的
     * 如果不写参数，则为全局默认页，加入输入404页面，也会自动访问到这个页面。
     * 如果加了参数“/”，则只认为是根页面。
     *
     * @return
     * @author huangyj
     * @create  2018年12月6日
     */
    @RequestMapping(value = {"/","/index"})
    public String index(Map<String, Object> model){
    	// 页面位置 src/main/resources/templates/index.ftl
        return "index";
    }

    /**
     * 响应到ftl页面page1
     *
     * @return
     * @author huangyj
     * @create  2018年12月6日
     */
    @RequestMapping("/page1")
    public ModelAndView page1(){
        // 页面位置 src/main/resources/templates/page1.ftl
        ModelAndView mav = new ModelAndView("page1");
        return mav;
    }

}
