package com.chings.core.interceptors;

import com.chings.core.config.Constant;
import com.chings.core.exception.UserNotLogin;
import com.chings.core.model.User;
import com.chings.core.utils.DateUtil;
import com.chings.core.utils.ResponseUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by sonnyching on 2017/7/12.
 */
public class DefaultInterceptor extends HandlerInterceptorAdapter {

    private List<String> unCheckUrls;
    Logger loggger = Logger.getLogger("client access");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        welcomeLog(request);

        if(!Constant.checklogin){
            return true;
        }

        //Log.info((unCheckUrls.size()));
        String fromUrl = request.getRequestURI();
        if(unCheckUrls!=null && !unCheckUrls.isEmpty()){
            boolean flag = false;
            for (String url:unCheckUrls) {
                if(url.endsWith("*")){
                    //Log.info(url+"statr with *");
                    flag = fromUrl.startsWith(url.substring(0,url.length()-1)) || fromUrl.startsWith("/chings"+url.substring(0,url.length()-1));
                }else{
                    flag = fromUrl.equals(url) || fromUrl.equals("/chings"+url);
                }
                if(flag){
                    //Log.info("gogogo");
                    return true;
                }
            }
        }


        //登陆拦截
        //判断用户是否登陆，根据其携带的token-session来判断
      /*  String chings_token = request.getParameter("chings_token");
        if(StringUtils.isEmpty(chings_token)){
            return false;
        }*/

        HttpSession session = request.getSession();
        //Log.info("session:"+session.getId());
        User user = (User)session.getAttribute(session.getId());
        //Log.info("user:"+user);
        if(user==null){
            //进入登陆页
            //response.sendRedirect("/user/login");

            PrintWriter writer = null;
            try {
                response.setCharacterEncoding("utf-8");
                response.setContentType("text/html; charset=utf-8");
                writer = response.getWriter();
                writer.print(ResponseUtils.responseJosn(new UserNotLogin("未登录或登陆过期")));
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

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

    /**
     * 打印控制台访问日志
     */
    public void welcomeLog(HttpServletRequest request){

        String ip = getIpAddress(request);
        String time = DateUtil.getNowDate("yyyy-MM-dd HH:mm:ss");
        String requestURI = request.getRequestURI();
        this.loggger.info(ip+" | "+time+" | "+requestURI );

    }

    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


}
