package com.example.demo.conf;

import com.example.demo.entity.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局配置 实现#WebMvcConfigurer
 *
 * @author Arthur
 * @date 2018-10-25
 */

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{




    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/index.html").setViewName("/index.btl");
        //registry.addRedirectViewController("/**/*.do", "/index.html");
    }

    /**
     * 格式化
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        //自动将字符串转为日期类型java.util.Date
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 跨域访问
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
                //.allowedOrigins("http://domain2.com")
                //.allowedMethods("POST", "GET");
    }

    /**
     * 设置拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //add一个拦截器，检查会话，URL已admin开头都要使用此拦截器
        registry.addInterceptor(new SessionHandlerInterceptor()).addPathPatterns("/admin/**");
    }

    class SessionHandlerInterceptor implements HandlerInterceptor {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                //如果没有登录，重定向到login.htnl
                response.sendRedirect("/login.html");
                return false;
            }
            return true;
        }

        @Override
        public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
            //页面渲染完毕后调用此方法，通常用来清除某些资源，类似Java语法中的finally

        }


    }
}
