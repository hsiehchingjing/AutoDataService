package hayaa.dataservice.dataserver;

import hayaa.dataservice.model.*;


public interface IDataServiceProvider {
	DataResult QueryService(CommonQuery queryInfo,String actionName);
	MetaDataResult GetQueryMetaData(MetaDataQuery metaDataQuery);

}
