package org.vinodjain.javabrains.personservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.vinodjain.javabrains.personservice.Person;
import org.vinodjain.javabrains.personservice.PersonService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource {

	PersonService personService = new PersonService();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 * 
	 * @param <Person>
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersonList() {
		return personService.getPersonList();

	}

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 * 
	 * @param <Person>
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{personId}")
	public Person getPerson(@PathParam("personId") int personId) {
		for (Person person : personService.getPersonList()) {
			if (person.getId()==(personId)) {
				return person;
			}
		}
		 throw new DataNotFoundException("Person with id "+personId+"not found");

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> addPerson(Person person) {
		personService.getPersonList().add(person);
		return personService.getPersonList();

	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> updatePerson(Person personToUpdate) {
		for (Person personExist : personService.getPersonList()) {
			if (personExist.getId()==personToUpdate.getId()) {
				personExist.setCity(personToUpdate.getCity());
				personExist.setName(personToUpdate.getName());
				personExist.setZipcode(personToUpdate.getZipcode());
			}
		}

		return personService.getPersonList();

	}
}
