package org.vinod.javabrains.advance.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.vinod.javabrains.advance.resources.MyDate;;
@Path("dateResource/{day}")
public class DateResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getConvertedDate(@PathParam("day") MyDate date)
	{
		return "today is "+date.toString();
	}
	
}
