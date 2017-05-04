package com.two95.sooraj.messanger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.glassfish.jersey.server.Uri;

import com.two95.sooraj.messanger.model.Message;
import com.two95.sooraj.messanger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResources {

	MessageService service = new MessageService();

	@GET

	public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start,
			@QueryParam("size") int size) {
		if (year > 0) {
			return service.getAllMessagesPerYear(year);
		}
		if (start >= 0 && size > 0) {
			return service.getAllMessagesPaginated(start, size);
		}
		return service.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId, @Context UriInfo uriInfo) {
		Message message= service.getMessage(messageId);
		message.addLinks(getUriForSelf(uriInfo, message),"self");
		message.addLinks(getUriForProfile(uriInfo, message),"profile");
		message.addLinks(getUriForComment(uriInfo, message),"comment");
		return message;
	}

	private String getUriForProfile(UriInfo uriInfo, Message message) {
		URI uri=uriInfo.getBaseUriBuilder().
				path(ProfileResources.class).
				path(message.getAuthor()).
				build();
		return uri.toString();
	}

	private String getUriForComment(UriInfo uriInfo, Message message) {
		URI uri=uriInfo.getBaseUriBuilder().
				path(MessageResources.class).
				path(MessageResources.class, "getInstanceOfCommentResource").
				path(CommentResource.class).
				resolveTemplate("messageId", message.getId()).
				path(message.getAuthor()).
				build();
		return uri.toString();
	}

	private String getUriForSelf(UriInfo uriInfo, Message message) {
		URI uri=uriInfo.getBaseUriBuilder().
				path(MessageResources.class).
				path(Long.toString(message.getId())).
				build();
		return uri.toString();
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {
		Message newMessage = service.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();

	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return service.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		service.removeMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource getInstanceOfCommentResource(@PathParam("messageId") int messageId) {
		return new CommentResource();
	}

}
