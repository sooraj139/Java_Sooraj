package com.two95.sooraj.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.two95.sooraj.messanger.model.ErrorMessage;
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	

	@Override
	public Response toResponse(DataNotFoundException ex) {
		ErrorMessage errorMessage=new ErrorMessage("Content Not Found", 404,"www.google.com");
		
		return Response.status(Status.NOT_FOUND).
				entity(errorMessage).build();
	}
	

}
