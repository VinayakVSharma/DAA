import java.util.*;
class Assignment1_2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of elements: ");
		String s[]=new String[sc.nextInt()];
		System.out.println("Enter the elements of String array");
		for (int i=0; i< s.length ; i++ ) {
			s[i]=sc.next();
		}
		Arrays.sort(s);
		Assignment1_2 obj=new Assignment1_2();
		for (int i=0; i< s.length ; i++ ) {
			System.out.println("String "+(i+1)+" is "+s[i]);
		}
	}
}