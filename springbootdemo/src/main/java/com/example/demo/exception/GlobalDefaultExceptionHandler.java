package com.example.demo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    private final static Logger logger= LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * 增加注解ExceptionHandler，注解ExceptionHandler中value的值是要处理的异常类，
     * 返回json数据或者String数据需要在方法上加上注解 @ResponseBody
     * 返回视图，定义一个ModelAndView即可，然后return；定义视图文件（如：error.html,error.ftl,error.jsp）
     * @param request
     * @param e
     * @return 返回值String
     */
    @ExceptionHandler(value = ArithmeticException.class)
    @ResponseBody
    public String defaultErrorHandler(HttpServletRequest request,Exception e){
        logger.info("全局错误捕捉url:"+request.getRequestURI());
        logger.error(e.getMessage(),e);
        return "url:"+request.getRequestURI()+"数据运算错误："+e.getMessage();
    }

    /**
     * 统一处理错误返回视图
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView errorHandler(HttpServletRequest request, Exception e){
        logger.info("全局错误捕捉url:"+request.getRequestURI());
        logger.error(e.getMessage(),e);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
