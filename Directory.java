import java.util.*;

class Person {
    private String name;
    private String address;
    private String telephoneNumber;
    private String mobileNumber;
    private String headOfFamily;
    private String uniqueID;

    public Person(String name, String address, String telephoneNumber, String mobileNumber, String headOfFamily, String uniqueID) {
        this.name = name;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.mobileNumber = mobileNumber;
        this.headOfFamily = headOfFamily;
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getHeadOfFamily() {
        return headOfFamily;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nTelephone Number: " + telephoneNumber + "\nMobile Number: " + mobileNumber + "\nHead of Family: " + headOfFamily + "\nUnique ID: " + uniqueID;
    }
}

public class Directory {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Person> directory = new HashMap<>();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create a database entry");
            System.out.println("2. Edit an entry");
            System.out.println("3. Search by keyword");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.println("\n");
            
            switch (choice) {
                case 1:
                    createEntry();
                    break;
                case 2:
                    editEntry();
                    break;
                case 3:
                    searchByKeyword();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void createEntry() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter telephone number (if available with STD code): ");
        String telephoneNumber = scanner.nextLine();
        System.out.print("Enter mobile number (if available): ");
        String mobileNumber = scanner.nextLine();
        System.out.print("Enter head of family: ");
        String headOfFamily = scanner.nextLine();
        System.out.print("Enter unique ID: ");
        String uniqueID = scanner.nextLine();
        System.out.println("\n");

        if (directory.containsKey(uniqueID)) {
            System.out.println("Error: Unique ID already exists.");
            return;
        }
        directory.put(uniqueID, new Person(name, address, telephoneNumber, mobileNumber, headOfFamily, uniqueID));
        System.out.println("Entry added successfully.");
    }

    private static void editEntry() {
        System.out.print("Enter unique ID of the entry to edit: ");
        String uniqueID = scanner.nextLine();

        if (!directory.containsKey(uniqueID)) {
            System.out.println("Error: Entry not found.");
            return;
        }
        Person person = directory.get(uniqueID);

        System.out.println("Current details:");
        System.out.println(person);

        System.out.println("Enter new details:");

        System.out.print("Name: ");
        person = new Person(scanner.nextLine(), person.getAddress(), person.getTelephoneNumber(), person.getMobileNumber(), person.getHeadOfFamily(), person.getUniqueID());

        System.out.print("Address: ");
        person = new Person(person.getName(), scanner.nextLine(), person.getTelephoneNumber(), person.getMobileNumber(), person.getHeadOfFamily(), person.getUniqueID());

        System.out.print("Telephone number: ");
        person = new Person(person.getName(), person.getAddress(), scanner.nextLine(), person.getMobileNumber(), person.getHeadOfFamily(), person.getUniqueID());

        System.out.print("Mobile number: ");
        person = new Person(person.getName(), person.getAddress(), person.getTelephoneNumber(), scanner.nextLine(), person.getHeadOfFamily(), person.getUniqueID());

        System.out.print("Head of family: ");
        person = new Person(person.getName(), person.getAddress(), person.getTelephoneNumber(), person.getMobileNumber(), scanner.nextLine(), person.getUniqueID());

        directory.put(uniqueID, person);
        System.out.println("Entry edited successfully.");
    }
    private static void searchByKeyword() {
        System.out.print("Enter keyword: ");
        String keyword = scanner.nextLine();

        System.out.println("Search results:");
        for (Person person : directory.values()) {
            if (person.getName().contains(keyword) || person.getAddress().contains(keyword) || person.getTelephoneNumber().contains(keyword) || person.getMobileNumber().contains(keyword) || person.getHeadOfFamily().contains(keyword) || person.getUniqueID().contains(keyword)) {
                System.out.println(person);
                System.out.println();
            }
        }
    }
}
