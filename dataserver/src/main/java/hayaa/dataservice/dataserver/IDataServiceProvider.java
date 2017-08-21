package hayaa.dataservice.dataserver;

import hayaa.dataservice.model.*;


public interface IDataServiceProvider {
	DataResult QueryService(CommonQuery queryInfo);
	MetaDataResult GetQueryMetaData(MetaDataQuery metaDataQuery);
}
