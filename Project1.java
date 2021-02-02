// Read a set of integer data from a file,
// stores that data into a data structure, and
// repeatedly determines whether any 3 items from the data set sum to a target value

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Project1 {
    private static Scanner scan;

    public static void main(String[] args) throws FileNotFoundException {
        // Open the file
        File input1 = new File("input1.text");
        // Create a new scanner to read the file
        scan = new Scanner(input1);
        // Declare an array with length of 100
        int[] array1 = new int[100];
        int i, j, target = 0, sum = 0, first = 0, second = 0, third = 0;
        boolean found;

        // Loop through the file if there is a next int to process it will continue
        // store numbers into an array as reading
        for (i = 0; scan.hasNextInt(); i++) {
            array1[i] = scan.nextInt();
            if (array1[i] == 0) {
                break;
            }
        }
        scan.close();
        // make a new array have exact ele as the file
        int[] array2 = new int[i];
        for (j = 0; j < i; j++) {
            array2[j] = array1[j];
        }
        Arrays.sort(array2);// sort array in increasing order

        // Read in target and output the answer
        for (j = 0; scan.hasNextInt(); j++) {
            target = scan.nextInt();
            found = false;
            if (i < 2) // Base case
            {
                System.out.println(target + " NO");
            } else { // i is # elements in array2
                for (first = 0; first < i - 1; first++) {
                    second = first + 1;
                    third = i - 1;
                    sum = array2[first] + array2[second] + array2[third];

                    while (sum != target && second < third - 1) {
                        if (sum < target) {
                            second++;
                            sum = array2[first] + array2[second] + array2[third];
                        } else if (sum > target) {
                            third--;
                            sum = array2[first] + array2[second] + array2[third];
                        }
                    }
                    if (sum == target) {
                        System.out.println(target + " YES");
                        found = true;
                        break;
                    }
                }
                if (!found)
                    System.out.println(target + " NO");
            }
        }
        // Close the scanner object
        scan.close();
    }
}
