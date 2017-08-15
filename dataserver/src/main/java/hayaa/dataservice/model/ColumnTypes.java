package hayaa.dataservice.model;

public enum ColumnTypes {
	None(0),//无
	IsOptionMeta(1),//指示该列是否是一个Option元数据
	CanFilter(2),//指示该列是否可以被过滤
	CanSort(4),//指示该列是否可以被排序
	CanGroupBy(8),//指示该列是否可以被分组
	CanQuery(16),//指示该列是否可以被查询
	CanDisplay(32);//指示该列是否可以被显示 
	private int g_value;	 
    private ColumnTypes(int value) {
        this.g_value = value;
    } 
    public int getValue() {
        return g_value;
    }
}
