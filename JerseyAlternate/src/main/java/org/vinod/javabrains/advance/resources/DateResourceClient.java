package org.vinod.javabrains.advance.resources;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DateResourceClient {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		Response response=client.target("http://localhost:8080/JerseyAlternate/webapi/dateResource/yesterday").request().get();
		System.out.println(response.readEntity(String.class));
		
		
		Client client1 = ClientBuilder.newClient();
		WebTarget baseTarget= client1.target("http://localhost:8080/JerseyAlternate/webapi/");
		WebTarget webtarget=baseTarget.path("dateResource");
		WebTarget singleTarget = webtarget.path("{day}");
		String response1= singleTarget.resolveTemplate("day", "yesterday").request(MediaType.TEXT_PLAIN).get(String.class);
		System.out.println(response1);
		
		Client client2 = ClientBuilder.newClient();
		WebTarget baseTarget2= client2.target("http://localhost:8080/JerseyAlternate/webapi/");
		WebTarget webtarget2=baseTarget2.path("dateResource");
		WebTarget singleTarget2 = webtarget2.path("{day}");
		Invocation response2= singleTarget2.resolveTemplate("day", "yesterday").request(MediaType.TEXT_PLAIN).buildGet();
		System.out.println(response2.invoke().readEntity(String.class));
	}

}
