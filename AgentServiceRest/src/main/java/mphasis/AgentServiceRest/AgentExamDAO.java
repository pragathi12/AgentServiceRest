package mphasis.AgentServiceRest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





public class AgentExamDAO {
	Connection connection;
	PreparedStatement pst;
	public String updateAgent(AgentExam agentexam) throws ClassNotFoundException, SQLException {
		AgentExam agentexamFound = searchAgent(agentexam.getAgentid());
		if (agentexamFound != null) {
			String cmd = "Update AgentExam set Name=?, Gender=?, City=?, MaritalStatus=?, Premium=? "
					+ " Where AgentID=?";
			connection = ConnectionHelper.getConnection();
			pst = connection.prepareStatement(cmd);
			pst.setString(1, agentexam.getName());
			pst.setString(2, agentexam.getGender());
			pst.setString(3, agentexam.getCity());
			pst.setInt(4, agentexam.getMaritalstatus()); 
			pst.setDouble(5, agentexam.getPremium());
			pst.setInt(6, agentexam.getAgentid());
			pst.executeUpdate();
			return "Record Updated...";
		}
		return "Record Not Found...";
	}
	public String deleteAgent(int agentid) throws ClassNotFoundException, SQLException {
		AgentExam agentexam = searchAgent(agentid);
		if (agentexam != null) {
			connection = ConnectionHelper.getConnection();
			String cmd = "Delete from AgentExam where agentid=?";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, agentid);
			pst.executeUpdate();
			return "Record Deleted...";
		}
		return "Record Not Found...";
	}
	
	
	public String addAgent(AgentExam agentexam) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Insert into AgentExam(agentid,name,gender,city,maritalstatus,premium) "
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentexam.getAgentid());
		pst.setString(2, agentexam.getName());
		pst.setString(3, agentexam.getGender());
		pst.setString(4, agentexam.getCity());
		pst.setInt(5, agentexam.getMaritalstatus()); 
		pst.setDouble(6,agentexam.getPremium());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	public AgentExam[] showAgent() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from AgentExam";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<AgentExam> agentexamList = new ArrayList<AgentExam>();
		AgentExam agentexam = null;
		while(rs.next()) {
			agentexam = new AgentExam();
			agentexam.setAgentid(rs.getInt("agentid"));
			agentexam.setName(rs.getString("name"));
			agentexam.setGender(rs.getString("gender"));
			agentexam.setCity(rs.getString("city"));
            agentexam.setMaritalstatus(rs.getInt("maritalstatus"));
			agentexam.setPremium(rs.getDouble("premium"));
			agentexamList.add(agentexam);
		}
	    return agentexamList.toArray(new AgentExam[agentexamList.size()]);
	}
	public AgentExam searchAgent(int agentid) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from AgentExam where agentid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, agentid);
		ResultSet rs = pst.executeQuery();
		AgentExam agentexam = null;
		if (rs.next()) {
			agentexam = new AgentExam();
            agentexam.setAgentid(rs.getInt("agentid"));
			agentexam.setName(rs.getString("name"));
			agentexam.setGender(rs.getString("gender"));
			agentexam.setCity(rs.getString("city"));
            agentexam.setMaritalstatus(rs.getInt("maritalstatus"));
			agentexam.setPremium(rs.getDouble("premium"));
		}
		return agentexam;
	}

}
