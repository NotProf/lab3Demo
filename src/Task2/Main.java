package Task2;

import javax.crypto.ExemptionMechanismException;

public class Main {
    public static void main(String[] args) {
        Address address1 = new Address("Lviv", "Gorododstka");
        Address address2 = new Address("Lviv", "LP");

        User user1 = new User("Oleh", "Greva", 19, "Developer", address1);
        User user2 = new User("Ol", "Greva", 19, "Developer", address1);
        User user3 = new User("Olehich", "Greva", 19, "Developer", address2);

        try {
            user1.validate();
        } catch (ValidateException e) {
            System.out.println(e.getMessage() + " Status " + e.getStatus());
        }

        try {
            user2.validate();
        } catch (ValidateException e) {
            System.out.println(e.getMessage() + " Status " + e.getStatus());
        }

        try {
            user3.validate();
        } catch (ValidateException e) {
            System.out.println(e.getMessage() + " Status " + e.getStatus());
        }

    }
}
