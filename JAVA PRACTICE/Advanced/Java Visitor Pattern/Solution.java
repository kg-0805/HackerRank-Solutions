import java.util.ArrayList;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.util.ArrayList;
import java.util.Scanner;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis
{
    public abstract int getResult();
    public abstract void visitNode(TreeNode node);
    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    
    private int result = 0;
    
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
    }

    public void visitLeaf(TreeLeaf leaf) {
          result += leaf.getValue();
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    
    private int result = 1;
    private static long MODULO_FACTOR = ((long) Math.pow(10, 9) + 7);
    public int getResult() {
        return result;
    }

    public void visitNode(TreeNode node) {
          visit(node);
    }

    public void visitLeaf(TreeLeaf leaf) {
          visit(leaf);
    }
    
    private void visit(Tree tree) {
        if (tree.getColor() == Color.RED) {
            long temp = result;
            temp = (temp * tree.getValue());
            result = (int) (temp % MODULO_FACTOR);
            
        }
    }
}

class FancyVisitor extends TreeVis {
    int nonLeafSum = 0;
    int leafSum = 0;
    public int getResult() {
        return (int) Math.abs(nonLeafSum - leafSum);
    }

    public void visitNode(TreeNode node) {
        if (node.getDepth() % 2 == 0) {
            nonLeafSum += node.getValue();
        }
    }

    public void visitLeaf(TreeLeaf leaf) {
        if (leaf.getColor() == Color.GREEN) {
            leafSum += leaf.getValue();    
        }    
    }
}

public class Solution {
  
    public static Tree solve() {
        Scanner sc = new Scanner(System.in);
        Setup setup = new Setup(sc);
        
        Tree[] tree = new Tree[setup.n];
        
        int currentDepth = -1;

        Queue<Context> toVisit = new ArrayDeque<>();

        toVisit.add(new Context(currentDepth, 0, null));


        while (!toVisit.isEmpty()) {
            Context ctx = toVisit.poll();
            if (tree[ctx.index] != null) {
                continue;
            }
            int currentIndex = ctx.index;
            currentDepth =  ctx.depth + 1;
            TreeNode parent = ctx.parent;

            
            List<Integer> child = setup.adjacencies.get(currentIndex);
            List<Integer> filteredIndexes = new ArrayList<>();
            for (int i = 0; i < child.size(); i++) {
                if (tree[child.get(i)] == null) {
                    filteredIndexes.add(child.get(i));
                }
            }

            boolean isLeaf = filteredIndexes.isEmpty();

            if (isLeaf) {
                System.err.println("currentIndex" + currentIndex + " is leaf " + currentDepth);
                tree[currentIndex] = new TreeLeaf(setup.values[currentIndex], setup.colors[currentIndex], currentDepth);
            }
            else {
                System.err.println("currentIndex" + currentIndex + " is not leaf " + currentDepth);
                tree[currentIndex] = new TreeNode(setup.values[currentIndex], setup.colors[currentIndex], currentDepth);
                
                for (Integer filteredIndex : filteredIndexes) {
                toVisit.add(new Context(currentDepth, filteredIndex, (TreeNode) tree[currentIndex]));
            }
            }

           

            if (parent != null) {
                parent.addChild(tree[currentIndex]);
            }
        }
        
        return tree[0];
    }

    static class Context {
        int depth;
        int index;
        TreeNode parent;

        Context(int depth, int index, TreeNode parent) {
            this.depth = depth;
            this.index = index;
            this.parent = parent;
        }
    } 
    
    
    static class Setup {
        int n;
        int[] values;
        Color[] colors;
        Map<Integer, List<Integer>> adjacencies = new HashMap<>();
        
        Setup(Scanner sc) {
            n = sc.nextInt();
            values = new int[n];
            colors = new Color[n];
            adjacencies = new HashMap<>();

            for(int i = 0; i < n; i++) {
                values[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++) {
                colors[i] =  Color.values()[sc.nextInt()];
            }
            for(int i = 0; i < (n - 1); i++) {
                int leftIndex = sc.nextInt() - 1;
                int rightIndex = sc.nextInt() - 1;

                List<Integer> adj = adjacencies.get(leftIndex);
                if (adj == null) {
                    adj = new ArrayList<>();
                    adjacencies.put(leftIndex, adj);
                }
                adj.add(rightIndex);

                List<Integer> adj2 = adjacencies.get(rightIndex);
                if (adj2 == null) {
                    adj2 = new ArrayList<>();
                    adjacencies.put(rightIndex, adj2);
                }
                adj2.add(leftIndex);
            }
        }
    }

    public static void main(String[] args) {
      	Tree root = solve();
		SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
      	ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
      	FancyVisitor vis3 = new FancyVisitor();

      	root.accept(vis1);
      	root.accept(vis2);
      	root.accept(vis3);

      	int res1 = vis1.getResult();
      	int res2 = vis2.getResult();
      	int res3 = vis3.getResult();

      	System.out.println(res1);
     	System.out.println(res2);
    	System.out.println(res3);
	}
}