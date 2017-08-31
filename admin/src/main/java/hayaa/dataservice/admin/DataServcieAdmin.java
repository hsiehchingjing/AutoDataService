package hayaa.dataservice.admin;

import java.sql.Date;

import hayaa.dataservice.admin.config.ConfigHelper;
import hayaa.dataservice.admin.config.DataserviceAdminConfig;
import hayaa.dataservice.admin.model.MethodDtataResult;
import hayaa.dataservice.admin.model.MethodResult;
import hayaa.dataservice.dataaccess.DataAccessDal;
import hayaa.dataservice.model.GridPager;
import hayaa.dataservice.model.Sqldataservice;

public class DataServcieAdmin implements IDataServiceAdmin {
private DataAccessDal g_dal=DataAccessDal.getInstance();
private DataserviceAdminConfig g_config=ConfigHelper.getInstance().getServerConfig();
	public MethodDtataResult<Integer> createDataService(Sqldataservice info) {
		String sql="INSERT INTO `SqlDataService`" + 
				"(`DataServiceTitle`," + 
				"`DataScript`," + 
				"`DataModel`," + 
				"`ActionName`," + 
				"`DatabaseUser`," + 
				"`DatabasePwd`," + 
				"`DatabaseConnection`," + 
				"`Status`," + 
				"`IsDelete`," + 
				"`CreateTime`)" + 
				"VALUES (?,?,?,?,?,?,?,?,?,?)";
		Object[] params=new Object[] {info.getDataservicetitle(),info.getDataScript(),info.getDataModel()
				,info.getActionName(),info.getDatabaseUser(),info.getDatabasePwd(),info.getDatabaseConnection()
				,info.getStatus(),0,new java.util.Date()};
		MethodDtataResult<Integer> result=new MethodDtataResult<Integer>();
		Object id= g_dal.insert(sql, params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd);
		result.Data=Integer.parseInt(id.toString());
		return result;
	}

	public MethodResult updateDataService(Sqldataservice info) {
		String sql="UPDATE `SqlDataService`" + 
				"SET" + 
				"`DataServiceTitle` = ?," + 
				"`DataScript` = ?," + 
				"`DataModel` = ?," + 
				"`ActionName` = ?," + 
				"`DatabaseUser` = ?," + 
				"`DatabasePwd` =?," + 
				"`DatabaseConnection` = ?," + 			
				"WHERE `DataServiceID` = ?;";
		Object[] params=new Object[] {info.getDataservicetitle(),info.getDataScript(),info.getDataModel()
				,info.getActionName(),info.getDatabaseUser(),info.getDatabasePwd(),info.getDatabaseConnection()
				,info.getDataserviceid()};
		MethodResult result=new MethodResult();
		result.ActionResult=g_dal.update(sql, params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd);
		return result;
	}

	public MethodDtataResult<Sqldataservice> getDataService(int id) {
		String sql="SELECT * FROM  `SqlDataService` where 'DataServiceID'=?";
		Object[] params=new Object[] {id};
		Sqldataservice tr=g_dal.get(sql,params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd, Sqldataservice.class);
		MethodDtataResult<Sqldataservice> result=new MethodDtataResult<Sqldataservice>();
		result.ActionResult=true;
		result.Data=tr;		
		return result;
	}

	public MethodResult deleteDataService(int id) {
		String sql="delete  `SqlDataService` where 'DataServiceID'=?";
		Object[] params=new Object[] {id};
		MethodResult result=new MethodResult();
		result.ActionResult=g_dal.delete(sql,params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd);
	
		return result;
	}

	public MethodResult enableDataService(int id,boolean enable) {
		String sql="UPDATE `SqlDataService`" + 
				"SET" + 
				"`status` = ?," + 						
				"WHERE `DataServiceID` = ?;";
		Object[] params=new Object[] {enable,id};
		MethodResult result=new MethodResult();
		result.ActionResult=g_dal.update(sql, params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd);
		return result;
	}

	public GridPager<Sqldataservice> getPager(int pageSize, int pageIndex,
			int dutyorId, String title) {
		String sqlForCount="SELECT count(`DataServiceID`) FROM  `SqlDataService` where 'DataServiceTitle' like '%'+?+'%' ";
		String sql="SELECT * FROM  `SqlDataService` where 'DataServiceTitle' like '%'+?+'%' order by 'DataServiceID' desc limit "
			+((pageIndex-1)*pageSize)
				+"  "+pageIndex*pageSize;
		Object[] params=new Object[] {title};
		GridPager<Sqldataservice> r=g_dal.listPagerQuery(sql,sqlForCount,params, g_config.DataConnection, g_config.DatabaseUser
				, g_config.DatabasePwd, Sqldataservice.class);	
		return r;
	}

}
