package hayaa.dataservice.admin;

import hayaa.dataservice.admin.model.MethodDtataResult;
import hayaa.dataservice.admin.model.MethodResult;
import hayaa.dataservice.model.GridPager;
import hayaa.dataservice.model.ServerResource;


public interface IResourceAdmin {
	public MethodDtataResult<Integer> create(ServerResource info);
	public MethodResult update(ServerResource info);
	public MethodDtataResult<ServerResource> get(int id);
	public MethodResult delete(int id);
	public MethodResult enable(int id,boolean enable);
	/**
	 * 
	 * @param pageSize
	 * @param pageIndex
	 * @param dutyorId 负责人id
	 * @param title 搜索展示标题
	 * @return
	 */
	public GridPager<ServerResource> getPager(int pageSize,int pageIndex,
			int dutyorId,String title);
}
