package hayaa.dataservice.admin.config;

import java.io.IOException;
import java.util.Properties;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

public class ConfigHelper {
	private static ConfigHelper g_instance = new ConfigHelper();

	public static ConfigHelper getInstance() {
		return g_instance;
	}

	static {

	}
	
	// 获取服务资源配置
	private DataserviceAdminConfig g_ServerConfig = null;

	public DataserviceAdminConfig getServerConfig() {
		if (g_ServerConfig == null) {
			Properties props = System.getProperties();
			String baseDirectory = props.getProperty("java.class.path");
			try {
				g_ServerConfig = JsonConvert.DeserializeObject(
						FileHelper
								.ReadAllText(baseDirectory + "/serveradmin.config"),
								DataserviceAdminConfig.class);
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return g_ServerConfig;
	}
}
