package org.vinod.javabrains.advance.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("{pathParams}/myalternateresource")
public class MyAlternateResource {
	private int count = 0;
	//path params can not be injected in case of singletone beans
	@PathParam("pathParams")
	private int pathParams;
	@QueryParam("queryParams")
	private int queryParams;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMessage() {
		String out = "query param used is "+queryParams+" path params used is "+pathParams;
		count++;
		return "inside alternate message called " + count + "times " + out ;
	}

}
