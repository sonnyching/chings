package com.chings.core.interceptors;

import com.chings.core.model.User;
import com.chings.core.utils.Constance;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by sonnyching on 2017/7/12.
 */
public class DefaultInterceptor extends HandlerInterceptorAdapter {

    private List<String> unCheckUrls;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String fromUrl = request.getRequestURI();
        if(unCheckUrls!=null && !unCheckUrls.isEmpty()){
            boolean flag = false;
            for (String url:unCheckUrls) {
                if(url.endsWith("*")){
                    flag = fromUrl.startsWith(url.substring(0,url.length()-1));
                }else{
                    flag = fromUrl.equals(url);
                }
                if(flag){
                    break;
                }
            }
            if(flag){
                return true;
            }
        }

        //登陆拦截
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute(Constance.PRE_LOGIN+session.getId());
        if(user==null){
            //进入登陆页
            response.sendRedirect("/user/login");
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    public List<String> getUnCheckUrls() {
        return unCheckUrls;
    }

    public void setUnCheckUrls(List<String> unCheckUrls) {
        this.unCheckUrls = unCheckUrls;
    }
}
