package hayaa.dataservice.model;

public final class Column {
	public ColumnTypes ColumnTypes;//获取或设置列的类型 
	public DataType 	DataType;//获取或设置列的类型
	public String Key;//获取或设置列的键，所有的查询、过滤、排序、分组都是使用该键进行指定的 
	public String Name;//获取或设置列的名称 
	public Object Tag;//获取或者设置用户自定义的属性 
}
