package hayaa.dataservice.dataserver;

import hayaa.dataservice.dataaccess.DataServiceDal;
import hayaa.dataservice.model.*;


public class DataServiceProvider implements IDataServiceProvider{

	public DataResult QueryService(CommonQuery queryInfo,String actionName) {
		Sqldataservice sqlTmpl=DataServiceDal.GetSqldataservice(actionName);
		String sql=SqlHelper.GetQuerySql(queryInfo, sqlTmpl.getDataScript());
		
		return null;
	}

	public MetaDataResult GetQueryMetaData(MetaDataQuery metaDataQuery) {
		// TODO Auto-generated method stub
		return null;
	}

}
