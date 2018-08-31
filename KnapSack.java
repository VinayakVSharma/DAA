import java.util.*;
class CompareByProfit implements Comparator{
	public int compare(Object o1,Object o2){
		Item i1=(Item)o1;
		Item i2=(Item)o2;
		if (i1.profit==i2.profit) {
			return 0;
		}else if (i1.profit>i2.profit) {
			return 1;
		}else{
			return -1;
		}
	}
}

class CompareByWeight implements Comparator{
	public int compare(Object o1,Object o2){
		Item i1=(Item)o1;
		Item i2=(Item)o2;
		if (i1.weight==i2.weight) {
			return 0;
		}else if (i1.weight>i2.weight) {
			return 1;
		}else{
			return -1;
		}
	}
}

class CompareByRatio implements Comparator{
	public int compare(Object o1,Object o2){
		Item i1=(Item)o1;
		Item i2=(Item)o2;
		if (i1.ratio==i2.ratio) {
			return 0;
		}else if (i1.ratio>i2.ratio) {
			return 1;
		}else{
			return -1;
		}
	}
}

class Item{
	float weight,profit;
	float ratio;
	float getWeight(){
		return this.weight;
	}
	float getProfit(){
		return this.profit;
	}
	float getRatio(){
		return this.ratio;
	}
	void setWeight(float weight){
		this.weight=weight;
	}
	void setProfit(float profit){
		this.profit=profit;
	}
	void setRatio(){
		ratio=profit/weight;
	}

}

class KnapSack{
	static void display(ArrayList<Item> item_list){
		ListIterator lit=item_list.listIterator();
		while(lit.hasNext()){
			Item i=(Item) lit.next();
			System.out.println("Profit: "+i.profit+" Weight: "+i.weight+" Ratio: "+i.ratio );
		}
	}


	static float knapSack(ArrayList item_list){
		float m=20,curr_weight=0,profit=0;
		ListIterator lit=item_list.listIterator();
		while(lit.hasNext()){
			Item i=(Item) lit.next();
			if ( (curr_weight+i.weight) <= m ) {
				curr_weight+=i.weight;
				profit+=i.profit;
			}else if(curr_weight <= m){
				float capacity=m-curr_weight;
				curr_weight+=i.weight;
				profit+=((capacity/i.weight)*i.profit);
			}else
			break;
		}
		return profit;

	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Item> item_list=new ArrayList<Item>();
		System.out.println("Enter total elements: ");
		int n=sc.nextInt();
		for (int i=0;i< n ; i++ ) {
			Item item=new Item();
			System.out.println("Enter the profit and weight respectively: ");
			item.setProfit(sc.nextInt());
			item.setWeight(sc.nextInt());
			item.setRatio();
			item_list.add(item);
		}
		display(item_list);
		int ch=0;
		do{
			System.out.println("1.Largest Profit strategy \n2.Smallest Weight strategy \n3.Larget profit-weight ratio");
			ch=sc.nextInt();
			switch(ch){
				case 1:
				Collections.sort(item_list,Collections.reverseOrder(new CompareByProfit()) );
				display(item_list);
				System.out.println("The profit is : "+knapSack(item_list));
				break;
				case 2:
				Collections.sort(item_list, new CompareByWeight());
				display(item_list);
				System.out.println("The profit is : "+knapSack(item_list));
				break;
				case 3:
				Collections.sort(item_list,Collections.reverseOrder(new CompareByRatio()) );
				display(item_list);
				System.out.println("The profit is : "+knapSack(item_list));
				break;
			}
		}while(ch<4);
	}
}