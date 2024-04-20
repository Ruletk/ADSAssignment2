import list.MyArrayList;
import list.MyList;

import java.util.Iterator;


public class Main {
    public static void main(String[] args) {
        MyList<Integer> myArrayList = new MyArrayList<>();

        myArrayList.add(10);
        myArrayList.add(1, 0);
        myArrayList.add(2, 1);
        myArrayList.add(5);
        System.out.println(myArrayList);

        myArrayList.remove(0);
        System.out.println(myArrayList);

        System.out.println(myArrayList.get(2));

        Iterator<Integer> itr = myArrayList.iterator();

        System.out.println(myArrayList);

        while(itr.hasNext())
            System.out.print(itr.next() + " ");

        myArrayList.sort();

        System.out.println(myArrayList);
    }

}
