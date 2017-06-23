package org.vinodjain.javabrains.personservice;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errMessage = new ErrorMessage(ex.getMessage(), 404, "content is not present on server");
		return Response.status(Status.NOT_FOUND).entity(errMessage).build();
	}

}
