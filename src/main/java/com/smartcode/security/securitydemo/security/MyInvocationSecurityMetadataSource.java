package com.smartcode.security.securitydemo.security;

/**
 * Created by panjingp on 2/15/2017.
 */

import com.smartcode.security.securitydemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
@Component
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    RoleService roleService;
    //private PathMatcher urlMatcher = new AntPathMatcher();

    /**
     * string -> resource
     * Collection<ConfigAttribute> -> role
     */
    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;







    public void updateResource() {
        synchronized (resourceMap) {
            resourceMap.clear();
            loadMap();
        }
    }


    private void loadMap() {

		/*
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

		Collection<ConfigAttribute> atts1 = new ArrayList<ConfigAttribute>();
		Collection<ConfigAttribute> atts2 = new ArrayList<ConfigAttribute>();
		Collection<ConfigAttribute> atts3 = new ArrayList<ConfigAttribute>();

		ConfigAttribute ca1 = new SecurityConfig("ROLE_ADMIN");
		ConfigAttribute ca2 = new SecurityConfig("ROLE_USER");
		ConfigAttribute ca3 = new SecurityConfig("ROLE_DEMO");

		atts1.add(ca1);


		resourceMap.put("/categorieses?form", atts1);
		resourceMap.put("/categorieses**", atts1);

		resourceMap.put("/forums?form", atts1);
		resourceMap.put("/forums**", atts1);


		resourceMap.put("/accounts?form", atts1);
		resourceMap.put("/accounts**", atts1);

		resourceMap.put("/permissions?form", atts1);
		resourceMap.put("/permissions**", atts1);


		resourceMap.put("/accountroles?form", atts1);
		resourceMap.put("/accountroles**", atts1);


		resourceMap.put("/roles?form", atts1);
		resourceMap.put("/roles**", atts1);

		resourceMap.put("/messages?form", atts1);
		resourceMap.put("/messages**", atts1);
		resourceMap.put("/rolepermissions?form", atts1);
		resourceMap.put("/rolepermissions**", atts1);



		atts2.add(ca2);
		resourceMap.put("/messages?form", atts2);
		resourceMap.put("/messages**", atts2);
		resourceMap.put("/forums?form", atts2);
		resourceMap.put("/forums**", atts2);


		atts3.add(ca3);
		atts3.add(ca2);

		resourceMap.put("/messages?form", atts3);
		resourceMap.put("/messages**", atts3);

		*/
        resourceMap = roleService.findAllPermission();
        System.out.print("test1======================"+resourceMap+"=====================");

        //System.out.print("test2======================"+resourceMapTest+"=====================");

    }


    /**
     * return 资源对应的可以访问的所有角色
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (resourceMap == null) {
            loadMap();
        }
        HttpServletRequest url = ((FilterInvocation) object).getHttpRequest();
        //String url = ((FilterInvocation)object).getRequestUrl();
        Iterator<String> ite = resourceMap.keySet().iterator();
        while (ite.hasNext()) {
            String resURL = ite.next();
            RequestMatcher urlMatcher = new AntPathRequestMatcher(resURL);
            // PathMatcher urlMatcher = new AntPathMatcher();


            /*
            if (urlMatcher.match(resURL,url)) {
                return resourceMap.get(resURL);
             }
            */

            // System.out.println("the restful request url"+resURL);
            // System.out.println("the request url"+url);

            if (urlMatcher.matches(url))
            {
                return resourceMap.get(resURL);
            }

        }

        //return resourceMap.get(url);
        return null;
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<ConfigAttribute>();
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }


}

