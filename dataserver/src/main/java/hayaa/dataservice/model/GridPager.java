package hayaa.dataservice.model;

import java.util.List;

public class GridPager<T>  {
	public int pageIndex;
	public int pageSize;
	public boolean ActionResult;
	public String Message;
	public List<T> Data;
	public int Total;
	public boolean NextPageEnable;
}
