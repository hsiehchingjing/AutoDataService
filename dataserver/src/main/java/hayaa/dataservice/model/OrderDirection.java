package hayaa.dataservice.model;

public enum OrderDirection {
	Asc(0),//升序
	Desc(1);//降序 
	private int g_value;	 
    private OrderDirection(int value) {
        this.g_value = value;
    } 
    public int getValue() {
        return g_value;
    }
}
