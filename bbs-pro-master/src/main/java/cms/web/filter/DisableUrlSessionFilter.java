package cms.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;
 
/**
 * 去掉URL带的jsessionid  并且设置HttpOnly=true
 * 用户首次登录系统时，会在地址后面加个jsessionid=xxx
 *
 */
@WebFilter(urlPatterns = "/*",filterName = "disableUrlSessionFilter",asyncSupported = true)
public class DisableUrlSessionFilter implements Filter{
 
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
	                     FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		// skip non-http requests
		if (!(request instanceof HttpServletRequest)) {
			chain.doFilter(request, response);
			return;
		}
 
		//从url中删除jsessionid
		// isRequestedSessionIdFromURL():Checks whether the requested session ID came in as part of the request URL.
		if (httpServletRequest.isRequestedSessionIdFromURL()) {
			HttpSession session = httpServletRequest.getSession();
			if (null != session) {
				session.invalidate();
			}
		}
		// wrap response to remove URL encoding
		HttpServletResponseWrapper wrappedResponse = new HttpServletResponseWrapper(httpServletResponse) {
			@Override
			public String encodeRedirectUrl(String url) {
				return url;
			}
			@Override
			public String encodeRedirectURL(String url) {
				return url;
			}
			@Override
			public String encodeUrl(String url) {
				return url;
			}
			@Override
			public String encodeURL(String url) {
				return url;
			}
		};
		// process next request in chain
		chain.doFilter(request, wrappedResponse);
	}
 
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
 
	}
 
	@Override
	public void destroy() {
 
	}
 
}
