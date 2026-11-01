package application;

import model.exceptions.DomainException;
import models.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    static void main(){
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int number = sc.nextInt();
            System.out.print("Check-in date (dd/mm/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(checkIn, checkOut, number);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/mm/yyyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Check-out date (dd/mm/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reservation: " + reservation);
        }
        catch (ParseException e){ // Erro do sdf.parse
            System.out.println("Invalid date format.");
        }
        catch(DomainException e){
            System.out.println("Error in reservation " + e.getMessage()); //e.getMessage = Error in reservation: Reservation dates for update must be future.
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        sc.close();

    }
}
