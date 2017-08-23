package hayaa.dataservice.dataserver;

import java.util.HashMap;

import hayaa.dataservice.config.ConfigHelper;
import hayaa.dataservice.config.ServerRoureceConfig;
import hayaa.dataservice.model.Sqldataservice;

/*
 * @see 服务工厂,存储服务对象，加载、重新载入服务对象
 */
final class ServiceFactory {
	private HashMap<String, Sqldataservice> g_ServiceStore=new HashMap<String, Sqldataservice>();
	/*
	 * @see 加载服务进入内存
	 */
	 void loadService() {
		//获取服务器配置
		 ServerRoureceConfig config=ConfigHelper.getInstance().getServerConfig();
		//获取服务器可发布的服务数据
		 
	}
}
