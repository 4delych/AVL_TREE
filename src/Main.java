import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DbException {
        AvlTree avlTree = new AvlTree();
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            File file = new File("src/file.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                numbers.add(number);
            }
            scanner.close();

        } catch (IOException e) {
            throw new DbException("wrong!!!");
        }


        for (int key : numbers) {
            double startTime = System.nanoTime();
            avlTree.insert(avlTree.getRoot(), key);
            double endTime = System.nanoTime();
//            System.out.println((int)(endTime - startTime));
        }

        for (int j = 3; j < 100; j += 5) {
            double startTime1 = System.nanoTime();
            avlTree.find(numbers.get(j));
            double endTime1 = System.nanoTime();
//            System.out.println((int)(endTime1 - startTime1));
        }

        for (int i = 1; i < 1000; i++) {
            double startTime2 = System.nanoTime();
            avlTree.delete(avlTree.getRoot(), numbers.get(i));
            double endTime2 = System.nanoTime();
//          System.out.println((int) (endTime2 - startTime2));
        }
    }
}