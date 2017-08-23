package hayaa.dataservice.dataserver;



import java.util.HashMap;
import java.util.List;

import hayaa.dataservice.config.ConfigHelper;
import hayaa.dataservice.config.ServerRoureceConfig;
import hayaa.dataservice.dataaccess.DataServiceDal;
import hayaa.dataservice.model.Sqldataservice;

/*
 * @see 服务工厂,存储服务对象，加载、重新载入服务对象
 */
final class ServiceFactory {
	private static ServiceFactory g_instance=new ServiceFactory();
	static ServiceFactory getInstance() {
		return g_instance;
	}
	private ServiceFactory() {
		loadService();
	}
	private HashMap<String, Sqldataservice> g_ServiceStore=new HashMap<String, Sqldataservice>();
	/*
	 * @see 加载服务进入内存
	 */
	 void loadService() {
		//获取服务器配置
		 ServerRoureceConfig config=ConfigHelper.getInstance().getServerConfig();
		//获取服务器可发布的服务数据
		 List<Sqldataservice> list=DataServiceDal.getInstance().GetServerServiceList(config.getServerRourceID());
		 for(Sqldataservice obj:list) {
			 g_ServiceStore.put(obj.getActionName(), obj);
		 }
	}
	/**
	 * @see 获取制定方法名的服务
	 * @param actionName
	 * @return
	 */
	 Sqldataservice getService(String actionName) {
		 if(g_ServiceStore.containsKey(actionName)) {
			 return g_ServiceStore.get(actionName);
		 }
		 return null;
	 }
	 void reloadService() {
		 g_ServiceStore.clear();
		 loadService();
	 }
}
