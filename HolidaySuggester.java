import java.util.Scanner;
import java.util.*;

public class HolidaySuggester {
    private static Scanner userInput = new Scanner(System.in);
    public static TreeNode left, right, value, node, next;
    
    public HolidaySuggester(){
        this.next = null;
        this.node = null;
    }
    
    public HolidaySuggester(TreeNode node, TreeNode next){
        this.next = next;
        this.node = node;
    }
    
    public static void main(String[] args){
        //create tree
        QuestionTree tree = new QuestionTree();
        //add nodes 
        tree.root = new TreeNode("Do you like cold weather?");
        tree.root.addRight("Goa");
        tree.root.addLeft("Are you a keen hiker?");
        tree.root.getLeft().addRight("Moscow");
        tree.root.getLeft().addLeft("the Scottish Highlands");

        System.out.println("Welcome to the Post-COVID Holiday Destination Suggester!");
        do {
            tree.current = tree.root;
            runRound(tree);
        } while (askYesNo("Do you want to play again?"));
        
    }
    
    public static boolean askYesNo(String question){
        System.out.println(question + " [y/n]");
        String userAnswer = userInput.nextLine();
        if(userAnswer.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    private static void runRound(QuestionTree tree) {
        while (!tree.current.isLeaf()) {
            boolean answer = askYesNo(tree.current.getValue());
            if (answer) {
                tree.current = tree.current.getLeft();
            } else {
                tree.current = tree.current.getRight();
            }
        }
        System.out.println(tree.current.getValue());
        
        if(!askYesNo("Is this satisfactory?")){
            String newDestination = askQuestion("What would you prefer instead?");
            String newQuestion = askQuestion("What questions differentiates from " + newDestination + "from " + tree.current.getValue() + "?");
            tree.addQuestion(newQuestion, newDestination);
        }
    }
    
    public static String askQuestion(String question){
        System.out.println(question + " [y/n]");
        String userQuestion = userInput.nextLine();
        return userQuestion;
    }
}

class QuestionTree{
    TreeNode root;
    TreeNode current;
    
    //public void printTree(TreeNode node){
    //    if(node != null){
    //        System.out.println(" " + node.value);
    //        printTree(node);
     //   }
   // }
    
   // public void printTreeRight(TreeNode node){
     //   if(node != null){
       //     System.out.println(" " + node.value);
        //    printTreeRight(node.right);
      //  }
    //}
    
   // public void printTreeLeft(TreeNode node){
       // if(node != null){
       //     System.out.println(" " + node.value);
       //     printTreeLeft(node.left);
        //}
    //}
    
    public void addQuestion(String question, String destination){
        TreeNode oldDestination = this.current;
        TreeNode parentNode = current.getParent();
        TreeNode questionNode;
        
        if(parentNode.getLeft() == oldDestination){
            questionNode = parentNode.addLeft(question);
        } else{
            questionNode = parentNode.addRight(question);
        }
        
        questionNode.addLeft(destination);
        questionNode.setRight(oldDestination);
        oldDestination.setParent(questionNode);
    }
}

