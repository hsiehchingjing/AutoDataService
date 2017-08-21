package hayaa.dataservice.model;

public final class FilterItem {
	public FilterItemType	FilterItemType;//获取或设置FilterItemType信息 
	public String FilterOn;//获取或设置过滤的列，该列必须是元数据中的列的键 
	public FilterType FilterType;//获取或设置FilterType信息
	public Object[] FilterValues;//获取或设置过滤器的数据，该数据只有过滤类型为单一类型的时候	
	public boolean IsQuote;//数值是否需要单引号
}
