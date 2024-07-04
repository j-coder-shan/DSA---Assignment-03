import java.util.Scanner;
public class StemAndLeaf {
    public void inputHeights(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of heights:");
        int numHeights = scanner.nextInt();

        int[] heights = new int[numHeights];
        System.out.println("Enter the heights:");
        for (int i = 0; i < numHeights; i++) {
            heights[i] = scanner.nextInt();
        }
        arrangeList(heights);
    }

    public void arrangeList(int[] heights){
        int maxHeight = 0;
        for (int height : heights) {
            if (height > maxHeight) {
                maxHeight = height;
            }
        }
        int maxStem = maxHeight / 10;

        int[][] stemAndLeaf = new int[maxStem + 1][10];
        int[] leafCount = new int[maxStem + 1];

        for (int height : heights) {
            int stem = height / 10;
            int leaf = height % 10;
            stemAndLeaf[stem][leafCount[stem]++] = leaf;
        }

        printStemAndLeaves(maxStem, stemAndLeaf, leafCount);
    }
    public void printStemAndLeaves(int maxStem, int[][] stemAndLeaf, int[] leafCount){
        System.out.println("Stem | Leaf");
        System.out.println("-----------");

        for (int stem = 0; stem <= maxStem; stem++) {
            if (leafCount[stem] > 0) {
                System.out.print(stem + "   | ");
                for (int i = 0; i < leafCount[stem]; i++) {
                    System.out.print(stemAndLeaf[stem][i] + " ");
                }
                System.out.println();
            }
        }

    }
    public static void main(String[] args) {
           StemAndLeaf stemAndLeaf = new StemAndLeaf();
           stemAndLeaf.inputHeights();
        }
    }

