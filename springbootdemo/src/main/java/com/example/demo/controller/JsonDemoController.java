package com.example.demo.controller;

import com.example.demo.bean.DemoBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试返回json数据
 */
@RestController
@RequestMapping("/demo")
public class JsonDemoController {
    /**
     * 返回demo数据
     * 请求地址：http://localhost:8080/demo/getDemo
     * @return
     */
    @RequestMapping("/getDemo")
    public DemoBean getDemo(){
        DemoBean demoBean=new DemoBean();
        demoBean.setId(12);
        demoBean.setName("测试");
        return demoBean;
    }
}
