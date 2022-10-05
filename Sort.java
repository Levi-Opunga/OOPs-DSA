import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static final int MAXIM_ARRAY_SIZE = 100;
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        // declare the arrays used
        Scanner scanner = new Scanner(System.in);
        int[] inputArray = new int[MAXIM_ARRAY_SIZE];
        int[] descendingArray;
        int[] ascendingArray;
        int[] originalArray;

        System.out.println("How many numbers dou you want to sort??");
        int capacity = scanner.nextInt();
        //if capacity check fails a recursive call is done
        if(capacity <0 || capacity>100){
            System.out.println("Capacity can not be less than 0 or more than 100 ");
            run();
        }

        //read input
        System.out.println("\nEnter the numbers you want to sort");
        for (int i = 0; i < capacity; i++) {
            System.out.print("Number " + (i + 1) + " : ");
            inputArray[i] = scanner.nextInt();
        }

        // assign values to arrays and call sorting functions
        originalArray = Arrays.copyOf(inputArray, capacity);
        ascendingArray = ascendingSort(inputArray, capacity);
        descendingArray = descendingSort(inputArray, capacity);

       //display output
        System.out.println("\n==================================================");

        System.out.printf("%-15s%-15s%-15s \n", "Unsorted", "Ascending", "Descending");
        System.out.println("===================================================");

        for (int i = 0; i < capacity; i++) {

            System.out.printf("%-15d%-15d%-15d \n", originalArray[i], ascendingArray[i], descendingArray[i]);

        }
        System.out.println("===================================================\n");

        //prompt to terminate or rerun
       System.out.println("Do you wish to continue sorting more numbers?? [y/n]");
        String option = scanner.next().trim();
        if(option.equals("y") || option.equals("Y")){
            run();
        }else{
            System.out.print("Exiting Application .............");
        }

    }
// function to sort in ascending order
    public static int[] ascendingSort(int[] array, int capacity) {
        for (int current = 0; current < capacity; current++) {
            for (int next = current + 1; next < capacity; next++) {
                if (array[current] > array[next]) {
                    int temp = array[current];
                    array[current] = array[next];
                    array[next] = temp;

                }
            }
        }

        return Arrays.copyOf(array, capacity);
    }
// function to sort in descending order 
    public static int[] descendingSort(int[] array, int capacity) {
        for (int current = 0; current < capacity; current++) {
            for (int next = current + 1; next < capacity; next++) {
                if (array[current] < array[next]) {
                    int temp = array[current];
                    array[current] = array[next];
                    array[next] = temp;
                }
            }
        }

        return Arrays.copyOf(array, capacity);
    }
}
