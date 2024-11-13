package BinarySearchTree;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        System.out.println("Enter values for the tree (between 0 and 999), or 'q' to quit:");
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                int value = input.nextInt();
                if (value >= 0 && value <= 999) {
                    tree.root = tree.insert(tree.root, value);
                } else {
                    System.out.println("Please enter a number between 0 to 999");
                }
            } else {
                String quit = input.next();
                if (quit.equalsIgnoreCase("q")) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter an integer between 0 and 999 or 'q' to quit.");
                }
            }
        }
        // print the Binary Tree Structure 
        System.out.println("Binary Search Tree Structure:");
        tree.printTree();
     }
}

