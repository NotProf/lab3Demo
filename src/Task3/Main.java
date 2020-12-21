package Task3;

import Task2.Address;
import Task2.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Lviv", "Gorododstka");

        User user1 = new User("Oleh", "Greva", 50, "Developer", address);
        User user2 = new User("Olena", "Grevachovich", 29, "Developer", address);
        User user3 = new User("Katya", "Ivanova", 33, "Developer", address);
        User user4 = new User("Katya", "Ivanova", 33, "Developer", address);
        User user5 = new User("Katya", "Ivanova", 33, "Developer", address);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);

        Stream<User> stream = users.stream();
        Stream<Integer> integerStream = stream.map((user -> user.getAge() + 20));

        integerStream.forEach(System.out::println);

        users.stream().filter((x) -> x.getFirstname().equals("Oleh")).forEach(System.out::println);
        System.out.println("________________________________________________________________");
        User user = users.stream().sorted(Comparator.comparing(User::getAge)).findFirst().get();
        System.out.println(user);
        System.out.println("________________________________________________________________");
        List<User> collect = users.stream().distinct().peek(User::validate).collect(Collectors.toList());
        System.out.println("1_______________________________________________________________");

        Integer integer = users.stream().map(User::getAge).reduce((accumulator, element) -> {
            System.out.println("ACC - " + accumulator + "El - " + element);
            return accumulator + element;
        }).get();
        System.out.println("1_______________________________________________________________");
        users.stream().map(User::getFirstname).limit(2).forEach(System.out::println);

    }
}
