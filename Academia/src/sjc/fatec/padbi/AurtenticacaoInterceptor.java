package sjc.fatec.padbi;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AurtenticacaoInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		 String uri = request.getRequestURI();
//	      if(uri.endsWith("login") || uri.endsWith("logar") || uri.contains("bootstrap"))
	        return true;
		
//		if (request.getSession().getAttribute("atorLogado") != null){
//			return true;
//		}
		
//		response.sendRedirect("login");
//		return false;
	}
	
}
