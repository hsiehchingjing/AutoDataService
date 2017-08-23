package hayaa.dataservice.dataserver;

import hayaa.dataservice.dataaccess.DataAccessDal;

import hayaa.dataservice.model.*;

public class DataServiceProvider implements IDataServiceProvider {
	/*
	 * 
	 * @see 获取查询数据服务的结果
	 */
	public DataResult QueryService(CommonQuery queryInfo, String actionName) {
		Sqldataservice sqldataservice = ServiceFactory.getInstance()
				.getService(actionName);
		String sql = SqlHelper.GetQuerySql(queryInfo,
				sqldataservice.getDataScript());
		DataResult result = DataAccessDal.getInstance().query(sql,
				sqldataservice.getDatabaseConnection(),
				sqldataservice.getDatabaseUser(),
				sqldataservice.getDatabasePwd());
		return result;
	}

	public MetaDataResult GetQueryMetaData(MetaDataQuery metaDataQuery) {
		// TODO Auto-generated method stub
		return null;
	}

}
