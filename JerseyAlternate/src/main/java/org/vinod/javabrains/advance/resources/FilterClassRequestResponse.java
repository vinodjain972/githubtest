package org.vinod.javabrains.advance.resources;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
@Provider
public class FilterClassRequestResponse implements ContainerRequestFilter{

	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Content Type used"+requestContext.getMediaType());
		
	}

}
