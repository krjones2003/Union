package for_homework_six;
import java.util.*;

//Kristin Jones
//Running Time: theta (list1 size + list2 size)

public class TestUnion {

	//a method that takes two sorted lists of any type and returns a new, united list 
	//containing all items in their natural ordering
	public static <AnyType extends Comparable<AnyType>> List<AnyType>
		union (List<AnyType> list1, List<AnyType> list2) {
	
		LinkedList<AnyType> myNewList = new LinkedList<>();
		
		java.util.Iterator<AnyType> itrtr = list1.iterator();
		java.util.Iterator<AnyType> itrtrTwo = list2.iterator();
		
		
		AnyType myItem, myOtherItem;
		if (itrtr.hasNext())
			myItem = itrtr.next();
		else
			myItem = null;
		if (itrtrTwo.hasNext())
			myOtherItem = itrtrTwo.next();
		else
			myOtherItem = null;
		
		// Iterate until reach ends of both lists
		while(myItem!=null || myOtherItem!=null) {
			if(myOtherItem==null) {
				myNewList.add(myItem);
				if (itrtr.hasNext())
					myItem = itrtr.next();
				else
					myItem = null;
			} 
			else if (myItem == null) {
				myNewList.add(myOtherItem);
				if (itrtrTwo.hasNext())
					myOtherItem = itrtrTwo.next();
				else
					myOtherItem = null;
			}
			else if(myItem.compareTo(myOtherItem) < 0) { 
				myNewList.add(myItem);
				if (itrtr.hasNext())
					myItem = itrtr.next();
				else
					myItem = null;
			} 
			else if(myItem.compareTo(myOtherItem) >= 0) {
				myNewList.add(myOtherItem);
				if (itrtrTwo.hasNext())
					myOtherItem = itrtrTwo.next();
				else
					myOtherItem = null;
			}
			
		}
		
		return myNewList;
	}
		
	
	public static void main(String[] args) {

		LinkedList<Integer> list1 = new LinkedList<>();
		for (int i = 0; i < 20; i++)
			list1.add(i);
		System.out.println("List 1: " + list1);
	
		LinkedList<Integer> list2 = new LinkedList<>();
		for (int i = -6; i < list1.size() + 10; i = i + 3)
			list2.add(i);
		System.out.println("List 2: " + list2);
	
		List<Integer> resultList = union(list1, list2);
		System.out.println("Union is: " + resultList);
	
		resultList = union(list2, list1);
		System.out.println("Union is: " + resultList);
		
		//testing with String objects
		LinkedList<String> list3 = new LinkedList<>();
		list3.add("apple");
		list3.add("banana");
		list3.add("banana");
		list3.add("dork");
		list3.add("fork");
		list3.add("road");
		list3.add("zebra");
		System.out.println("List 3:" + list3);
		
		LinkedList<String> list4 = new LinkedList<>();
		list4.add("apartment");
		list4.add("banana");
		list4.add("berzerk");
		list4.add("dorknob");
		list4.add("grab");
		list4.add("street");
		list4.add("zebra");
		System.out.println("List 4:" + list4);
		
		List<String> resultStringList = union(list3, list4);
		System.out.println("Union is: " + resultStringList);
	
		resultStringList = union(list4, list3);
		System.out.println("Union is: " + resultStringList);
		
		LinkedList<Integer> list5 = new LinkedList<>();
		System.out.println("List 5:" + list5);
		
		List<Integer> resultSList = union(list2, list5);
		System.out.println("Union is: " + resultSList);
		
		resultSList = union(list5, list2);
		System.out.println("Union is:" + resultSList);
	}

}
