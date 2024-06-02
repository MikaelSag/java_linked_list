

public class removeHalf {

	public static void main(String[] args) 
	{
		SingleLinkedList list = new SingleLinkedList();
		list.add(2);
		list.add(5);
		list.add(10);
		list.add(1);
		list.add(15);
		list.add(4);
		list.add(21);
		list.add(44);
		list.print();
		System.out.println("initial size: " + list.size());
		list.remSecondHalf();
		list.print();
		System.out.println("size after removing second half: " + list.size());
	}

}
