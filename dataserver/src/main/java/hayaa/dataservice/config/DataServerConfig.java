package hayaa.dataservice.config;

public class DataServerConfig {
	private String g_DataServerConnenction="jdbc:mysql://127.0.0.1:3306/dataserver";
	public String getDataServerConnenction() {
		return g_DataServerConnenction;
	}
	private String g_DatabaseUser="root";
	public String getDatabaseUser() {
		return g_DatabaseUser;
	}
	private String g_DatabaseUserPwd="123456";
	public String getDatabaseUserPwd() {
		return g_DatabaseUserPwd;
	}
}
