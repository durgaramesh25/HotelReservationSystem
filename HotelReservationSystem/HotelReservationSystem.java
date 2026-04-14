import java.util.*;

class Room {

    int roomNumber;
    String roomType;
    boolean available;

    Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.available = true;
    }
}

class Reservation {

    String customerName;
    int roomNumber;
    String paymentType;

    Reservation(String name,int room,String payment){
        this.customerName=name;
        this.roomNumber=room;
        this.paymentType=payment;
    }

}

public class HotelReservationSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {

        rooms.add(new Room(101,"Standard"));
        rooms.add(new Room(102,"Standard"));
        rooms.add(new Room(201,"Deluxe"));
        rooms.add(new Room(202,"Deluxe"));
        rooms.add(new Room(301,"Suite"));

        int choice;

        do {

            System.out.println("\n===============================");
            System.out.println("  HOTEL RESERVATION SYSTEM");
            System.out.println("===============================");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Reservation");
            System.out.println("4. View Reservations");
            System.out.println("5. Exit");
            System.out.println("===============================");
            System.out.print("Enter Choice: ");

            choice = sc.nextInt();

            switch(choice){

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelReservation();
                    break;

                case 4:
                    viewReservations();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice");

            }

        }while(choice!=5);

    }

    static void viewRooms(){

        System.out.println("\nAvailable Rooms:");

        for(Room r:rooms){

            if(r.available){
                System.out.println("Room "+r.roomNumber+" | "+r.roomType);
            }

        }

    }

    static void bookRoom(){

        sc.nextLine(); // fix input bug

        System.out.print("Enter Customer Name: ");
        String name=sc.nextLine();

        System.out.print("Enter Room Number: ");
        int roomNo=sc.nextInt();

        for(Room r:rooms){

            if(r.roomNumber==roomNo && r.available){

                r.available=false;

                System.out.println("\nSelect Payment Method");
                System.out.println("1. Cash");
                System.out.println("2. Card");
                System.out.print("Enter option: ");

                int pay=sc.nextInt();

                String payment;

                if(pay==1){
                    payment="Cash";
                }
                else{
                    payment="Card";
                }

                reservations.add(new Reservation(name,roomNo,payment));

                System.out.println("\nRoom Booked Successfully!");
                return;
            }

        }

        System.out.println("Room not available!");

    }

    static void cancelReservation(){

        System.out.print("\nEnter Room Number to Cancel: ");
        int roomNo=sc.nextInt();

        for(Reservation r:reservations){

            if(r.roomNumber==roomNo){

                reservations.remove(r);

                for(Room rm:rooms){
                    if(rm.roomNumber==roomNo){
                        rm.available=true;
                    }
                }

                System.out.println("Reservation Cancelled Successfully!");
                return;
            }

        }

        System.out.println("Reservation not found");

    }

    static void viewReservations(){

        System.out.println("\nBooking Details:");

        for(Reservation r:reservations){

            System.out.println(
                    "Name: "+r.customerName+
                    " | Room: "+r.roomNumber+
                    " | Payment: "+r.paymentType
            );

        }

    }

}