package hayaa.dataservice.model;

public enum FilterItemType {
	Group(0),//指示过滤器是一个过滤器组
	Single(1);//指示过滤器为一个单一过滤器 
	private int g_value;	 
    private FilterItemType(int value) {
        this.g_value = value;
    } 
    public int getValue() {
        return g_value;
    }
}
