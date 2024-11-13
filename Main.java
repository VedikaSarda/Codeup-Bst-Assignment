package BinarySearchTree;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        ModifyTree newTree = new ModifyTree();
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
        System.out.println("Binary Search Tree Structure:");
        tree.printTree();

        System.out.println("Do you want to modify the tree? (yes/no)");
        String modify = input.next();

        if (modify.equalsIgnoreCase("yes")) {
            System.out.println("Enter the new root value:");
            if (input.hasNextInt()) {
                int newRoot = input.nextInt();
               newTree.changeRoot(newRoot);
                System.out.println("Changed root to: " + newRoot);
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }

        System.out.println("Updated Binary Search Tree Structure:");
        newTree.printTree();

    }
}

