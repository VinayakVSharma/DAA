import java.util.*;
class Assignment1_2 {

	void sort(String[] arr){
		 for (int i = 0; i < arr.length; i++) 
        {
            for (int j = i + 1; j < arr.length; j++) 
            {
                if (arr[i].compareTo(arr[j])>0) 
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of Strings: ");
		String s[]=new String[sc.nextInt()];
		System.out.println("Enter the elements of String array");
		for (int i=0; i< s.length ; i++ ) {
			s[i]=sc.next();
		}
		Assignment1_2 obj=new Assignment1_2();
		obj.sort();
		for (int i=0; i< s.length ; i++ ) {
			System.out.println("String "+(i+1)+" is "+s[i]);
		}	
	}
}