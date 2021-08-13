package ast;

public class CommandOperacaoConjunto extends AbstractCommand{

	public static final int UNION=0;
	public static final int INTERSECTION=1;
	public static final int DIFFERENCE=2;
	public static final int INCLUDE=3;
	
	private String id;
	private String firstOperator;
	private String secondOperator;
	private int opType;
	
	public CommandOperacaoConjunto(String id, String fOP, String sOP, int opType) {
		this.id=id;
		this.firstOperator=fOP;
		this.secondOperator=sOP;
		this.opType=opType;
	}
	
	@Override
	public String generateJavaCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateCCode() {
		String operation = null;
		switch(opType) {
			case UNION:
				operation="setUnion";
			break;
			case INTERSECTION:
				operation="setIntersection";
			break;
			case DIFFERENCE:
				operation="setDifference";
			break;
			case INCLUDE:
				operation="setInclude";
			break;
		}
		return id+"="+operation+"("+firstOperator+","+secondOperator+");";
	}

}
