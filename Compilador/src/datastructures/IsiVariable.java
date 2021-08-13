package datastructures;

public class IsiVariable extends IsiSymbol{
	public static final int INTEGER = 0;
	public static final int DECIMAL = 1;
	public static final int TEXT = 2;
	public static final int ARRAY = 3;
	public static final int SET = 4;
	
	private int type;
	private String value;
	
	public IsiVariable(String name, int type, String value) {
		super(name);
		this.type=type;
		this.value=value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "IsiVariable [type=" + type + ", value=" + value + ", name=" + name + "]";
	}

	@Override
	public String generateJavaCode() {	
		String str;
		if(type==DECIMAL) {
			str = "double ";
		}
		else {
			str="String ";
		}
		return str+" "+super.name+";";
	}

	@Override
	public String generateCCode() {
		switch(type) {
			case TEXT:
				return "char "+super.name+"[256];";
			case INTEGER:
				return "int "+super.name+";";
			case DECIMAL:
				return "double "+super.name+";";
			case ARRAY:
				return "int "+super.name+"["+value+"];";
			case SET:
				return "set "+super.name+";";
		}
		return null;
	}
	
	

}
