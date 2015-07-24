/**
 * 
 */
package com.bgpublish.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author ps
 *
 */
//@Component
public class UserTokenFilter extends OncePerRequestFilter {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserTokenFilter.class);

	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		LOGGER.info("所有请求都要经过我哟,:"+request.getRequestURI());
		filterChain.doFilter(request, response);
		/*if (doCheck(request, response)) {
        } else {
        	_logger.error(MessageFormat.format("[doFilterInternal] - access denied [{0}]", request.getRequestURI()));
            setResponse(response);
            return;
        }*/
	}
	
	/*private boolean doCheck(HttpServletRequest request , HttpServletResponse response){
    	if(!checkWhitelist(request, response)) 
    		return checkToken(request, response);
    	else 
    		return true;
    }
	
	private boolean checkWhitelist(HttpServletRequest request , HttpServletResponse response){
    	boolean result = whitelistUrlChecker.check(request.getRequestURI());
    	if(result){
    		LOGGER.debug(MessageFormat.format("[checkWhitelist] - 用户可匿名访问uri:{0}", request.getRequestURI()));
    	}
    	return result;
    }
	
	private boolean checkToken(HttpServletRequest request,HttpServletResponse response){
        String token = request.getHeader("X-ACCESS-TOKEN");
        if(StringUtils.isBlank(token)){
        	return false;
        }
        
        String userId = redisService.get(PlatformConstant.USER_ACCESS_TOKEN_PREFIX + token);
        //_logger.info("redis userid = " + userId);
        if(StringUtils.isEmpty(userId)){
        	return false;
        }
        	
        
        redisService.expire(token, RedisService.ONE_MONTH);
        
        bindUser(request, Integer.valueOf(userId));
        
        return true;
    }
	
	private void bindUser(HttpServletRequest request , Integer userId){
    	request.setAttribute("curr_user_id", userId);
    }
	
	private void setResponse(HttpServletResponse response) throws IOException{
		OutputStream os = null;
		try {
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			
			os = response.getOutputStream();
			
			String text = JSON.toJSONString(buildErrors());
			byte[] bytes = text.getBytes("UTF-8");
			
			os.write(bytes);
		} catch (Exception e) {
			LOGGER.error("[setResponseBody] - fail to set response body" , e);
		} finally {
			if(os != null){
				os.flush();
			}
		}
	}*/

}
