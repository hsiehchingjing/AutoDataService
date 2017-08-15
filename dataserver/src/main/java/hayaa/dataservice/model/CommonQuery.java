package hayaa.dataservice.model;

public class CommonQuery {
	Column[] Columns;//获取或设置查询的列，其中的元素必须是元数据中的列的键 
	FilterItem  Filter;//获取或设置过滤信息，过滤的键必须是元数据中的列的键 
	String[] GroupBys;//获取或设置分组列，其中的元素必须是元数据中的列的键 
	OrderBy[] OrderBys;//获取或设置排序信息
	Paging Paging;//获取或设置分页信息 注意：Paging是否允许为空，各产品自己决定，但是CommonQuery协议说明中强调其重要性，实现者一定要明确为空和不为空对结果的影响，不允许只返回部分数据。要么返回全量，要么返回错误。 
	public CommonQuery Clone() {
		CommonQuery r= new CommonQuery();
		return r;
	}
}
