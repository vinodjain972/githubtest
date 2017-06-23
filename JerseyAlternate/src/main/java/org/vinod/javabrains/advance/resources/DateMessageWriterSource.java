//For Branch Only
package org.vinod.javabrains.advance.resources;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("datemessagewritersource")
public class DateMessageWriterSource {

	@GET
	@Produces("date/shortdate")
	public Date getTodaysDate()
	{
		Date date = Calendar.getInstance().getTime();
		return date;
	}
}
