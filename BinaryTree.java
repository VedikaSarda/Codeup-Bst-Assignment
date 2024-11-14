/**
* Binary Search Tree Implementation and Visuliazation
* Author: Vedika Sarda
* Date: 11th November 2024
* This program implements binary search tree and hepls us to visulize it in tree format.
*/
package BinarySearchTree;
import java.util.ArrayList;
import java.util.List;
public class BinaryTree {
    TreeNode root;
    // Insert values into the BST
    TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        }
        return node;
    }
    // Print the tree with hierarchical format and branches
    public void printTree() {
        List<List<String>> levels = new ArrayList<>();
        List<TreeNode> currentLevel = new ArrayList<>();
        List<TreeNode> nextLevel = new ArrayList<>();
        // Start with the root node  
        currentLevel.add(root);
        int widest = 0; // To track the widest node (longest string length)
        int nonNullNodes = 1; // To track non-null nodes in the current level
        
        // Process nodes level by level until there are no more nodes to process 
        while (nonNullNodes != 0) {
            List<String> line = new ArrayList<>();
            nonNullNodes = 0;

            for (TreeNode node : currentLevel) {
                if (node == null) {
                    line.add(null);
                    nextLevel.add(null);
                    nextLevel.add(null);
                } else {
                    String valueStr = String.valueOf(node.data);
                    line.add(valueStr);
                    if (valueStr.length() > widest) widest = valueStr.length();

                    nextLevel.add(node.left);
                    nextLevel.add(node.right);

                    if (node.left != null) nonNullNodes++;
                    if (node.right != null) nonNullNodes++;
                }
            }

            levels.add(line);
            currentLevel = nextLevel;
            nextLevel = new ArrayList<>();
        }

        int perPiece = levels.get(levels.size() - 1).size() * (widest + 4);
        for (int i = 0; i < levels.size(); i++) {
            List<String> line = levels.get(i);
            int halfPiece = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '|' : '_';
                        } else if (line.get(j) != null) {
                            c = '_';
                        }
                    }
                    System.out.print(c);

                    if (line.get(j) == null) {
                        for (int k = 0; k < perPiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < halfPiece; k++) {
                            System.out.print(j % 2 == 0 ? " " : "_");
                        }
                        System.out.print(j % 2 == 0 ? "_" : " ");
                        for (int k = 0; k < halfPiece; k++) {
                            System.out.print(j % 2 == 0 ? "_" : " ");
                        }
                    }
                }
                System.out.println();
            }
            // Print the values of the nodes in the current line  
            for (String nodeValue : line) {
                if (nodeValue == null) nodeValue = "";
                int leftPadding , rightPadding;
                rightPadding=leftPadding = (int) Math.floor(perPiece / 2f - nodeValue.length() / 2f);

                for (int k = 0; k < leftPadding; k++) {
                    System.out.print(" ");
                }
                System.out.print(nodeValue);
                for (int k = 0; k < rightPadding; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            // Halve the piece width for the next level  
            perPiece /= 2;
        }
    }
}

