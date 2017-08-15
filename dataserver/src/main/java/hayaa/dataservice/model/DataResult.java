package hayaa.dataservice.model;

public final class DataResult {
	Object[][] Data;//获取或设置数据，数据是一个二维结构的数据 
	String[] Headers;//获取或设置列头信息，每一个列头元素必须是元数据中的列的键 
	String Message;//除了ResultCode，还可以返回Message。是否为空，要分2种情况: 可为空：CommonQuery实现着提供了完整的ResultCode-Message参照表，描述了每种ResultCode对应的错误信息; 不可为空：缺失或不完整的ResultCode-Message参照表。这种情况下，需要Message不能为空。 
	Object[] Options;//获取或设置额外的信息，其中的键必须是元数据中的列的键
	String ResultCode;//以字符串形式组织，只能包含字母和数字，全部大写，连接符统一使用“_”。必须值，不能为空 
	int 	TotalCount;//获取或设置查询结果的所有行数
}
