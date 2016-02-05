package application;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.google.appengine.api.NamespaceManager;

public class MonFiltreMultitenancy implements Filter{
	
	private String localNameSpace = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		String nameSpace = req.getParameter("etablissement");
		String currentNameSpace = NamespaceManager.get();
		
		System.out.println("doFilter : entre, currentNameSpace : " + currentNameSpace + ", nameSpace : " + nameSpace);
		if(currentNameSpace == null){
			if(nameSpace!=null){
				localNameSpace = nameSpace;
				NamespaceManager.set(nameSpace);
				System.out.println("doFilter : set namespace : " + nameSpace);
			}
			else if (localNameSpace!=null){
				NamespaceManager.set(localNameSpace);
				System.out.println("doFilter : set namespace to localNameSpace : " + localNameSpace);
			}
		}
		
		System.out.println("doFilter : sort, currentNameSpace : " + NamespaceManager.get() + ", nameSpace : " + nameSpace);
		chain.doFilter(req, resp);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("filter : init");
		
	}

}