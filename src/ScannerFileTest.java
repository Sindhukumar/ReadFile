import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class ScannerFileTest {
	public static void main(String[] args) {
		LinkedList<Customer> customers = new LinkedList<Customer>();
		File file = new File("/home/oracle/workspace/ReadFile/customers.txt");
		String arr[] = new String[11];
		try {
			Scanner sc = new Scanner(file);
			sc.useDelimiter("\\t|\\n");// you must escape the slash of the tab
			sc.nextLine();
			int i = 0;//, j = 0;
			while (sc.hasNext()) {
				String s = sc.next();
				arr[i] = s;
				i++;
				if (i == 11) {
					Customer c = new Customer(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8],
							arr[9], arr[10]);
					customers.add(c);
					i = 0;
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (Customer c : customers) {
			System.out.println("Full name:" + c.getFullName());
			System.out.println("Email: " + c.email + "\n");
		}

	}
}
