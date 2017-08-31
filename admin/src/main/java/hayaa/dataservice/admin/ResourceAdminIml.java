package hayaa.dataservice.admin;

import hayaa.dataservice.admin.config.ConfigHelper;
import hayaa.dataservice.admin.config.DataserviceAdminConfig;
import hayaa.dataservice.admin.model.MethodDtataResult;
import hayaa.dataservice.admin.model.MethodResult;
import hayaa.dataservice.dataaccess.DataAccessDal;
import hayaa.dataservice.model.GridPager;
import hayaa.dataservice.model.ServerResource;
import hayaa.dataservice.model.Sqldataservice;

public class ResourceAdminIml implements IResourceAdmin {
	private DataAccessDal g_dal=DataAccessDal.getInstance();
	private DataserviceAdminConfig g_config=ConfigHelper.getInstance().getServerConfig();
	public MethodDtataResult<Integer> create(ServerResource info) {
		String sql="INSERT INTO `DataService`.`ServerResource`" + 
				"(`ResourceTitle`," + 
				"`ResourceIP`," + 
				"`ResourcePath`," + 
				"`Status`," + 
				"`IsDelete`," + 
				"`CreateTime`)" + 
				"VALUES(?,?,?,?,?,?)";
		Object[] params=new Object[] {info.ResourceTitle,info.ResourceIP,info.ResourcePath,info.Status,0,new java.util.Date()};
		MethodDtataResult<Integer> result=new MethodDtataResult<Integer>();
		Object id= g_dal.insert(sql, params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd);
		result.Data=Integer.parseInt(id.toString());
		return result;
	}

	public MethodResult update(ServerResource info) {
		String sql="UPDATE `ServerResource` SET" + 
				"`ResourceID` = ?," + 
				"`ResourceTitle` = ?," + 
				"`ResourceIP` = ?," + 
				"`ResourcePath` = ?," +				
				"WHERE `ResourceID` =?;";
		Object[] params=new Object[] {info.ResourceTitle,info.ResourceIP,info.ResourcePath};
		MethodResult result=new MethodResult();
		result.ActionResult=g_dal.update(sql, params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd);
		return result;
	}

	public MethodDtataResult<ServerResource> get(int id) {
		String sql="SELECT * FROM  `ServerResource` where 'ResourceID'=?";
		Object[] params=new Object[] {id};
		ServerResource tr=g_dal.get(sql,params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd, ServerResource.class);
		MethodDtataResult<ServerResource> result=new MethodDtataResult<ServerResource>();
		result.ActionResult=true;
		result.Data=tr;		
		return result;
	}

	public MethodResult delete(int id) {
		String sql="delete  `ServerResource` where 'ResourceID'=?";
		Object[] params=new Object[] {id};
		MethodResult result=new MethodResult();
		result.ActionResult=g_dal.delete(sql,params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd);
	
		return result;
	}

	public MethodResult enable(int id, boolean enable) {
		String sql="UPDATE `ServerResource`" + 
				"SET" + 
				"`status` = ?," + 						
				"WHERE `ResourceID` = ?;";
		Object[] params=new Object[] {enable,id};
		MethodResult result=new MethodResult();
		result.ActionResult=g_dal.update(sql, params, g_config.DataConnection, g_config.DatabaseUser, g_config.DatabasePwd);
		return result;
	}

	public GridPager<ServerResource> getPager(int pageSize, int pageIndex,
			int dutyorId, String title) {
		String sqlForCount="SELECT count(`ResourceID`) FROM  `ServerResource` where 'ResourceTitle' like '%'+?+'%' ";
		String sql="SELECT * FROM  `ServerResource` where 'ResourceTitle' like '%'+?+'%' order by 'ResourceID' desc limit "
			+((pageIndex-1)*pageSize)
				+"  "+pageIndex*pageSize;
		Object[] params=new Object[] {title};
		GridPager<ServerResource> r=g_dal.listPagerQuery(sql,sqlForCount,params, g_config.DataConnection, g_config.DatabaseUser
				, g_config.DatabasePwd, ServerResource.class);	
		return r;
	}

}
