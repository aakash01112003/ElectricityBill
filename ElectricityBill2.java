import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Bill {
    String name, address;
    int meterId, units;
    float dueAmount, month, total;

    void calculateBill() {
        if (units <= 100)
            month = units * 1.0f;
        else if (units <= 250)
            month = (100 * 1.0f) + (units - 100) * 1.80f;
        else
            month = (100 * 1.0f) + (150 * 1.80f) + (units - 250) * 2.2f;

        total = month + dueAmount;
    }

    void displayBill() {
        // Generate and format current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = now.format(formatter);

        System.out.println("\n===== ELECTRICITY BILL =====");
        System.out.println("Generated On : " + formattedDate);
        System.out.println("Name         : " + name);
        System.out.println("Address      : " + address);
        System.out.println("Meter ID     : " + meterId);
        System.out.println("Units Used   : " + units);
        System.out.println("-----------------------------");
        System.out.println("Previous Due     : Rs." + dueAmount);
        System.out.println("This Month Bill  : Rs." + month);
        System.out.println("Total Bill       : Rs." + total);
        System.out.println("=============================\n");
    }
}

class ElectricityBill2 extends Bill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ElectricityBill2 bill = new ElectricityBill2();

        System.out.print("Enter Customer Name: ");
        bill.name = sc.nextLine();

        System.out.print("Enter Address: ");
        bill.address = sc.nextLine();

        System.out.print("Enter Meter ID: ");
        bill.meterId = sc.nextInt();

        System.out.print("Enter Units Consumed: ");
        bill.units = sc.nextInt();

        System.out.print("Enter Previous Due Amount (₹0 if none): ");
        bill.dueAmount = sc.nextFloat();

        // If first 200 units are free
        if (bill.units <= 200) {
            System.out.println("\nFirst 200 units are free of cost!");
            bill.month = 0;
            bill.total = bill.dueAmount;  // Only due needs to be paid
        } else {
            bill.calculateBill();
        }

        bill.displayBill();
        sc.close();
    }
}