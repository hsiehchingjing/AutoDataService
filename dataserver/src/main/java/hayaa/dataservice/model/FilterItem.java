package hayaa.dataservice.model;

public final class FilterItem {
	FilterItem[] Children;//获取或设置子过滤器FilterItem
	ConcatType ConcatType;//获取或设置过滤器间ConcatType，该属性只有在过滤类型为分组的时候被使用 
	FilterItemType	FilterItemType;//获取或设置FilterItemType信息 
	String FilterOn;//获取或设置过滤的列，该列必须是元数据中的列的键 
	FilterType FilterType;//获取或设置FilterType信息
	Object[] FilterValues;//获取或设置过滤器的数据，该数据只有过滤类型为单一类型的时候	
}
