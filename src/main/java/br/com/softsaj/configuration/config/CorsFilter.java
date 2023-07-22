package br.com.softsaj.configuration.config;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.*;

//@Component
public class CorsFilter{
}
/* implements Filter {
}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		jakarta.servlet.http.HttpServletResponse httpResponse = (jakarta.servlet.http.HttpServletResponse) response;
		        httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
		        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
		        httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
		        chain.doFilter(request, response);
		    }
		
	
  
}*/
