package hayaa.dataservice.dataserver;

import hayaa.dataservice.model.*;


public interface IDataServiceProvider {
	public DataResult QueryService(CommonQuery queryInfo,String actionName);
	public MetaDataResult GetQueryMetaData(MetaDataQuery metaDataQuery);

}
