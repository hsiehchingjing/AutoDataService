package hayaa.dataservice.model;

public enum FilterType {
	Equal("="),//相等
	NotEqual("<>"),//不相等
	GreaterThan(">"),//大于
	LessThan("<"),//小于
	GreaterEqualThan(">="),//大于等于
	LessEqualThan("<="),//小于等于
	Between("between"),//区间
	In("in"),//在指定的值中的元素
	NotIn("not in"),//不在指定值中的元素
	Exists("exists");//used to express the where exists(xxx), for e.g. in wd: wd has aggregation measure filter, which means we use aggregation measure filter to filter some dimension in commonquery, we use the exists type, and set Filter.FilterValues to the sql which express the filter meaning.

	private String g_value;	 
    private FilterType(String value) {
        this.g_value = value;
    } 
    public String getValue() {
        return g_value;
    }
}
