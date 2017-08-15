package hayaa.dataservice.model;

public class MetaDataQuery {
		String CultureName;//获取或设置语言信息
		Object[] Options;//获取或设置额外的信息 
		String[] QueryKeys;//获取或设置查询键，如果指定了查询的键，那么只会返回在指定键内的键
}
