/**
 * 
 */
package com.bgpublish.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;

/**
 * 此类可以自定义错误页面,但目前来说暂时没用,待用吧;
 * 其中error方法是关键
 * @see BasicErrorController
 * @author ps
 *
 */
public class CustomErrorController implements ErrorController {
	private static final String PATH = "/error";

	@Value("${debug}")
    private boolean debug;

    @Autowired
    private ErrorAttributes errorAttributes;

   /* @RequestMapping(value = PATH)
    Error error(HttpServletRequest request, HttpServletResponse response) {
        // Appropriate HTTP response code (e.g. 404 or 500) is automatically set by Spring. 
        // Here we just define response body.
        return new Error(response.getStatus(), getErrorAttributes(request, debug));
    }*/

    @Override
    public String getErrorPath() {
        return PATH;
    }

    /*private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }*/

}
