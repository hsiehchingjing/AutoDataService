package hayaa.dataservice.model;

public enum ConcatType {
	And(0),//And
	Or(1),//Or
	Not(2);//Not 
	private int g_value;	 
    private ConcatType(int value) {
        this.g_value = value;
    } 
    public int getValue() {
        return g_value;
    }
}
