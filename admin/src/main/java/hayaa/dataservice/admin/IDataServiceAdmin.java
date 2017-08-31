package hayaa.dataservice.admin;
/**
 * @see 定义管理接口
 * @author hsieh
 *
 */


import hayaa.dataservice.admin.model.MethodDtataResult;
import hayaa.dataservice.admin.model.MethodResult;
import hayaa.dataservice.model.GridPager;
import hayaa.dataservice.model.Sqldataservice;

public interface IDataServiceAdmin {
	public MethodDtataResult<Integer> createDataService(Sqldataservice info);
	public MethodResult updateDataService(Sqldataservice info);
	public MethodDtataResult<Sqldataservice> getDataService(int id);
	public MethodResult deleteDataService(int id);
	public MethodResult enableDataService(int id,boolean enable);
	/**
	 * 
	 * @param pageSize
	 * @param pageIndex
	 * @param dutyorId 负责人id
	 * @param title 搜索展示标题
	 * @return
	 */
	public GridPager<Sqldataservice> getPager(int pageSize,int pageIndex,
			int dutyorId,String title);
}
