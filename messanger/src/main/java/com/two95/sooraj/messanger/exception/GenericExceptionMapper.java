package com.two95.sooraj.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.two95.sooraj.messanger.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage errorMessage=new ErrorMessage("Content Not Found", 500,"www.google.com");
		
		return Response.status(Status.INTERNAL_SERVER_ERROR).
				entity(errorMessage).build();
	}
	

}