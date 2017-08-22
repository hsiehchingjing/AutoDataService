package hayaa.dataservice.config;

public class ConfigHelper {
	private static ConfigHelper g_instance=new ConfigHelper();
	public static ConfigHelper getInstance() {
		return g_instance;
	}
	private DataServerConfig g_Config = new DataServerConfig();
	public DataServerConfig getConfig() {
		return g_Config;
	}
}
