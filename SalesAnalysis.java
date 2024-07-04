import java.util.Scanner;
public class SalesAnalysis {
    Scanner scanner = new Scanner(System.in);
    String[] productNames = {"Product A", "Product B", "Product C", "Product D"};
    int[] northSales = new int[4];
    int[] southSales = new int[4];
    int[] eastSales = new int[4];

    public void enterData(){
        System.out.println("Enter sales data for each product:");
        for (int i = 0; i < productNames.length; i++) {
            System.out.println(productNames[i] + " sales:");
            System.out.print("North: ");
            northSales[i] = scanner.nextInt();
            System.out.print("South: ");
            southSales[i] = scanner.nextInt();
            System.out.print("East: ");
            eastSales[i] = scanner.nextInt();
        }
    }
    private static int findBestSellingIndex(int[] sales) {
        int maxIndex = 0;
        for (int i = 1; i < sales.length; i++) {
            if (sales[i] > sales[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public void printStat(){
        int bestNorthIndex = findBestSellingIndex(northSales);
        int bestSouthIndex = findBestSellingIndex(southSales);
        int bestEastIndex = findBestSellingIndex(eastSales);

        System.out.println("Best-selling product in North: " + productNames[bestNorthIndex]);
        System.out.println("Best-selling product in South: " + productNames[bestSouthIndex]);
        System.out.println("Best-selling product in East: " + productNames[bestEastIndex]);

        int[] totalSales = new int[productNames.length];
        for (int i = 0; i < productNames.length; i++) {
            totalSales[i] = northSales[i] + southSales[i] + eastSales[i];
        }
        int overallBestIndex = findBestSellingIndex(totalSales);

        System.out.println("Overall best-selling product: " + productNames[overallBestIndex]);
    }
    public static void main(String[] args) {
        SalesAnalysis salesAnalysis = new SalesAnalysis();
        salesAnalysis.enterData();
        salesAnalysis.printStat();
    }
}
