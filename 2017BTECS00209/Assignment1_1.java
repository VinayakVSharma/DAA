import java.util.*;
class Assignment1_1 {
	int size;
	
	void sort(int arr[],int n){
		for(int i=0; i<n ; i++){
			for (int j=i+1; j< n ; j++ ) {
				if(arr[i]>arr[j]){
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

	void merge(int a[],int b[]){
		for (int i=0;i<b.length ; i++ ) {
			if (size< a.length) {
				a[size]=b[i];
				for (int j=size; j>0 ;j-- ) {
					if(a[j]<a[j-1]){
						a[j]=a[j-1];
						a[j-1]=b[i];
					}
				}
				size++;
			}
		}
	}

	void display(int arr[],int n){
		for (int i=0;i<n ;i++ ) {
			System.out.print(arr[i]+" ");
		}
	}
	public static void main(String[] args) {
		Assignment1_1 obj=new Assignment1_1();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the sixe of array 1 and 2");
		obj.size=sc.nextInt();
		int b[]=new int[sc.nextInt()];
		int a[]=new int[obj.size+b.length];
		System.out.println("Enter elements of first array: ");
		for (int i=0;i<obj.size ; i++ ) {
			a[i]=sc.nextInt();
		}
		System.out.println("Enter elements of b : ");
		for (int i=0; i<b.length ; i++ ) {
			b[i]=sc.nextInt();
		}
		obj.sort(a,obj.size);
		obj.sort(b,b.length);
		obj.merge(a,b);
		System.out.print("Sorted & merged Array: ");
		obj.display(a,a.length);
	}
}