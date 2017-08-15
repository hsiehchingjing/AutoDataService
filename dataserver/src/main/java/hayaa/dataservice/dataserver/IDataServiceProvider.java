package hayaa.dataservice.dataserver;

import hayaa.dataservice.model.*;


public interface IDataServiceProvider {
	DataResult CallService(CommonQuery queryInfo);
	Column[] GetQueryMetaData(MetaDataQuery metaDataQuery);
}
