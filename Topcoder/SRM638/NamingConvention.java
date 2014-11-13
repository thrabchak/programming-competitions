package SRM638;

public class NamingConvention {
	
	public String toCamelCase(String variableName){
		StringBuffer outString = new StringBuffer();
		boolean needToUpper = false;
		for(int i = 0; i < variableName.length(); i++){
			char c = variableName.charAt(i);
			if(i==0)
				outString.append(Character.toLowerCase(c));
			else if(needToUpper){
				outString.append(Character.toUpperCase(c));
				needToUpper = false;
			} else if(c == '_'){
				needToUpper = true;
			}else{
				outString.append(c);
			}
			
			
		}
		
		
		return outString.toString();
	}

	public static void main(String[] args) {
		NamingConvention n = new NamingConvention();
		
		System.out.println(n.toCamelCase("sum_of_two_numbers"));

	}

}
