import com.home.modal.Employee;

public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("Addition !!!");
		
		int result;
		
		Employee employee1 = new Employee();
		result = employee1.addition(2, 3, 4);
		
		int c = result + 100;
		
		System.out.println("Output is :: " + c);
		
		Employee employee2 = new Employee();
		employee2.addition(7, 8, 9);
		
		employee1.addition(3, 4, 5);

	}

}
