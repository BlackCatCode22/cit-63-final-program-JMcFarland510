// SearchComplexity.java
// Starter code for final programming assignment in CIT-63 Java Programming Spring 2024


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchComplexity {

    // Linear Search Method with initialized iterations counter to track number of iterations it takes
    // to find target or output not found
    public static int linearSearch(int[] array, int target) {
        int iterations = 0; // initialized iterations counter to track
        for (int i = 0; i < array.length; i++) {
            iterations++;
            if (array[i] == target) {
                System.out.println("Linear search iterations: " + iterations);
                return i;  // Returns index of found element
            }
        }
        System.out.println("Linear search iterations: " + iterations);
        return -1;  // Target not found
    }

    // Recursive binary Search Method
    public static int recursiveBinarySearch(int[] array, int target, int left, int right, int iterations) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            iterations++;
            if (array[mid] == target) {
                System.out.println("recursive binary search iterations: " + iterations);
                return mid;
            }
            if (array[mid] < target) {
                return recursiveBinarySearch(array, target, mid + 1, right, iterations);
            } else {
                return recursiveBinarySearch(array, target, left, mid - 1, iterations);
            }
        }
        System.out.println("Recursive binary search iterations: " + iterations);
        return -1; // target not found
    }

    // Error handling for non-integer Inputs with added getInput method for non integer inputs using a
    // try catch block
    public static int getInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer");
                scanner.nextInt(); // Clears the invalid input
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of elements in array:");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("Enter target number to search:");
        int target = getInput(scanner);

        // Linear Search with iteration count measure and print time taken for both linear and binary search
        // methods to execute. Help compare the performance of both algorithms

        long startTimeLinear = System.nanoTime();
        int linearResult = linearSearch(array, target);
        long endTimeLinear = System.nanoTime();
        long linearTime = endTimeLinear - startTimeLinear;
        System.out.println((linearResult == -1) ? "Target not found by linear search." :
                "Target found by linear search at index: " + linearResult);

        // Binary Search with iteration count
        Arrays.sort(array);
        long startTimeBinary = System.nanoTime();
        int binaryResult = recursiveBinarySearch(array, target, 0, array.length - 1, 0);
        long endTimeBinary = System.nanoTime();
        long binaryTime = endTimeBinary - startTimeBinary;
        System.out.println((binaryResult == -1) ? "Target not found by binary search." :
                "Target found by binary search at index: " + binaryResult);

        System.out.println("Time taken for linear search: " + linearTime + "nanoseconds");
        System.out.println("Time taken for binary search: " + binaryTime + "nanoseconds");


        scanner.close();
    }
}

