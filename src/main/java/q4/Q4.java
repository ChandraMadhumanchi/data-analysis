package q4;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4 {
// https://www.safaribooksonline.com/library/view/data-algorithms/9781491906170/ch04.html
    static List<ResultDS> leftOuterJoin(List<Employee> employees, Map<String,Salary> salaries) {
        List<ResultDS> leftouterDS = new ArrayList<ResultDS>();
        for(Employee e : employees){
        	if (salaries.containsKey(e.getId())) {
        		
        		Salary sal = salaries.get(e.getId());
    			
        		leftouterDS.add(new ResultDS(e.getId(), e.getFirst_name(),e.getLast_name(),sal.getSalary(),sal.getBonus()));
    		} else {
    			leftouterDS.add(new ResultDS(e.getId(), e.getFirst_name(),e.getLast_name(),"",""));
    		}
        }
        return leftouterDS;
    }

    private static List<Employee> getEmployeeTable(InputStream is) throws IOException {
        List<Employee> employees = new ArrayList<Employee>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
            String[] tokenizedLine = line.split(",", -1); ///You can specify to apply the pattern as often as possible with:
            if(! tokenizedLine[0].toString().equals("id"))
            	employees.add(new Employee(tokenizedLine[0], tokenizedLine[1],tokenizedLine[2]));
        }
        return employees;
    }

    private static Map<String,Salary> getSalaryTable(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        Map<String,Salary> salaries = new HashMap<String,Salary>();
        String line;
        while ((line = reader.readLine()) != null && line.length() != 0) {
        	String[] tokenizedLine = line.split(",", -1);
        	
        	if(!tokenizedLine[0].toString().equals("id")){
        		salaries.put(tokenizedLine[0], new Salary(tokenizedLine[0], tokenizedLine[1], tokenizedLine[2]));
        	}
        }
        return salaries;
    }

    public static void main(String... args) throws IOException {
     
    	List<Employee> employee_names = Q4.getEmployeeTable(new FileInputStream(args[0]));
        
        Map<String,Salary> employee_pay = Q4.getSalaryTable(new FileInputStream(args[1]));

        List<ResultDS> leftouterDS = leftOuterJoin(employee_names, employee_pay);
        
        for(ResultDS record: leftouterDS){
        	System.out.println(record.toString());
        }
    }
}
