package is.ru.stringcalculator;

public class Calculator {
public static String NLDelimiter = "\n";


	public static int add(String text){
		String delm = ",";
		if (text.startsWith("//"))
			{
			char temp = text.charAt(2);	
			String tempstring = String.valueOf(temp);
			delm = tempstring;
			
			}
		if(text.equals("")){
			return 0;
		}		
		else
			return sum(splitNumbers(text, delm));	
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers, String Ndel){
	    String linewithnewdel = "[" +NLDelimiter+Ndel+ "]";
		return numbers.split(linewithnewdel);
		
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
			if(negative(number)) 
			{
              throw new IllegalArgumentException("Negatives not allowed: "+number);
            } 
			else if(isitanumer(number)) 
			{
             total += toInt(number);
            }
		}
		return total;
    }
	private static boolean isitanumer ( String text){
	
		return text.matches("[0-9]?[0-9]?[0-9]");
	}
	
	private static boolean negative(String numbers) {
                return numbers.contains("-");
        }
	
		



}
