import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by famaridon on 22/08/2016.
 */
@Path("/hello")
public class UserRestController
{
	@GET
	@Produces("text/plain")
	public Response doGet()
	{
		return Response.ok("Hello from WildFly Swarm!").build();
	}
}
