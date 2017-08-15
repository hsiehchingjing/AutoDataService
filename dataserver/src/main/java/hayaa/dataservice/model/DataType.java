package hayaa.dataservice.model;

public enum DataType {
	Numeric(0),//数字
	String(1),//字符串
	DateTime(2),//时间
	Boolean(3);//布尔值 
	private int g_value;	 
    private DataType(int value) {
        this.g_value = value;
    } 
    public int getValue() {
        return g_value;
    }
}
