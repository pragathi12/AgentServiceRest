package mphasis.AgentServiceRest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agent")
public class AgentService {
	@POST
	@Path("/addagent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addAgent(AgentExam agentexam) throws ClassNotFoundException, SQLException {
		AgentExamDAO dao = new AgentExamDAO();
		return dao.addAgent(agentexam);
	}

	@GET
	@Path("/showagent")
	@Produces(MediaType.APPLICATION_JSON)
	public AgentExam[] showAgent() throws ClassNotFoundException, SQLException {
		AgentExamDAO dao = new AgentExamDAO();
		AgentExam[] emps = dao.showAgent();
		return emps;
	}
	
	@GET
	@Path("/searchagent/{agentid}")
	@Produces(MediaType.APPLICATION_JSON)
	public AgentExam searchAgent(@PathParam("agentid") int agentid) throws ClassNotFoundException, SQLException {
		AgentExamDAO dao = new AgentExamDAO();
		AgentExam agent = dao.searchAgent(agentid);
		return agent;
	}
}
