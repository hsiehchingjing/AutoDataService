package hayaa.dataservice.model;

public enum FilterType {
	Equal(0),//相等
	NotEqual(1),//不相等
	GreaterThan(2),//大于
	LessThan(3),//小于
	GreaterEqualThan(4),//大于等于
	LessEqualThan(5),//小于等于
	Between(6),//区间
	Contains(7),//字符串中包含指定的字符串
	In(8),//在指定的值中的元素
	NotIn(9),//不在指定值中的元素
	StartWith(10),//以某字符串开始
	NotStartWith(11),//不以某字符串开始
	EndWith(12),//以某字符串结束
	NotEndWith(13),//不以某字符串结束
	IsEmpty(14),//是空字符串
	IsNotEmpty(15),//不是空字符串
	IsNull(16),//为空
	IsNotNull(17),//不为空
	None(18),//特殊说明：当FilterItemType!=Single时， 此FilterItem的FilterType是不起作用的，因为其只是一个包含嵌套过滤的父亲结点，此时的FilterType均应设置为None. --by hongchao
	Exists(19),//used to express the where exists(xxx), for e.g. in wd: wd has aggregation measure filter, which means we use aggregation measure filter to filter some dimension in commonquery, we use the exists type, and set Filter.FilterValues to the sql which express the filter meaning.
	NotContains(20);//不包含 
	private int g_value;	 
    private FilterType(int value) {
        this.g_value = value;
    } 
    public int getValue() {
        return g_value;
    }
}
