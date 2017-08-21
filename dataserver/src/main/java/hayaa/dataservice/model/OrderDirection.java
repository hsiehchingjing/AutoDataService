package hayaa.dataservice.model;

public enum OrderDirection {
	Asc("asc"),//升序
	Desc("desc");//降序 
	private String g_value;	 
    private OrderDirection(String value) {
        this.g_value = value;
    } 
    public String getValue() {
        return g_value;
    }
}
