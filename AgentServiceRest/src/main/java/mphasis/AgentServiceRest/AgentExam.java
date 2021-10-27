package mphasis.AgentServiceRest;

public class AgentExam {
	private int agentid;
	private String name;
	private String city;
	private String gender;
	private int maritalstatus;
	private double premium;
	public int getAgentid() {
		return agentid;
	}
	public void setAgentid(int agentid) {
		this.agentid = agentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(int maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	@Override
	public String toString() {
		return "AgentExam [agentid=" + agentid + ", name=" + name + ", city=" + city + ", gender=" + gender
				+ ", maritalstatus=" + maritalstatus + ", premium=" + premium + "]";
	}
	
	
}
