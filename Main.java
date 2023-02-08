import java.util.Scanner;


public class Main {

    public static void main(String args[]){

        LinkedList<Product> productList = new LinkedList<Product>();

        System.out.print("Operations on List\n"+
                "1. Make Empty\n"+
                "2. Find ID\n"+
                "3. Insert At Front\n"+
                "4. Delete From Front\n"+
                "5. Delete ID\n"+
                "6. Print All Records\n"+
                "7. Done\n"+
                "Your Choice: ");

        Scanner scan = new Scanner(System.in);

        int userChoice;
        userChoice=scan.nextInt();

        //Iterate while user is not done
        while(userChoice!=7){

            int productID;
            String productName, supplierName;
            IDedObject object;
            Product product;

            // Switch case

            switch(userChoice){
                case 1:

                    //Empty the list
                    productList.makeEmpty();
                    break;

                case 2:

                    //Find product ID in the list
                    System.out.print("Enter Product ID: ");
                    productID = scan.nextInt();
                    Product m = productList.findID(productID);
                    if(m!=null){
                        //Print found product details
                        m.printID();
                    }
                    else{
                        //Print product not found
                        System.out.println("No product found");
                    }
                    break;

                case 3:
                    //Enter product into the list
                    System.out.print("Enter Product ID: ");
                    productID = scan.nextInt();
                    System.out.print("Enter Product Name: ");
                    scan.nextLine();  // Consume newline left-over

                    productName = scan.nextLine();
                    System.out.print("Enter Supplier Name: ");
                    supplierName = scan.nextLine();

                    product = new Product(productID, productName, supplierName);
                    //Insert product
                    if(productList.insertAtFront(product)){
                        System.out.println("Product Added");
                    }
                    else{
                        //If product already present
                        System.out.println("Product Already Present");
                    }
                    break;

                case 4:
                    //Delete record from front of the list
                    object = productList.deleteFromFront();
                    if(object!=null){
                        System.out.println("Product Deleted");
                        object.printID();
                    }
                    else{
                        System.out.println("List is empty");
                    }
                    break;

                case 5:

                    //Delete record with ID
                    System.out.print("Enter Product ID to delete: ");
                    productID = scan.nextInt();
                    object = productList.delete(productID);
                    if(object!=null){
                        System.out.println("Product Deleted");
                        object.printID();
                    }
                    else{
                        //No such record found
                        System.out.println("Product Not Found");
                    }
                    break;

                case 6:

                    //Print all records
                    productList.printAllRecords();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }

            //Input userChoice again
            System.out.print("Operations on List\n"+
                    "1. Make Empty\n"+
                    "2. Find ID\n"+
                    "3. Insert At Front\n"+
                    "4. Delete From Front\n"+
                    "5. Delete ID\n"+
                    "6. Print All Records\n"+
                    "7. Done\n"+
                    "Your Choice: ");
            userChoice = scan.nextInt();
        }
    }

}