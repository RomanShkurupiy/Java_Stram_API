import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(new User("Roman", "Klin", 25, "roivanov@gmail.com"),
                                   new User("Igor", "Petrov", 55, "igpetrov@gmail.com"),
                                   new User("Maxim", "Petrenko", 18, "mpetrenko@gmail.com"),
                                   new User("Maxim2", "Petrov", 39, "m2petrov@gmail.com"),
                                   new User("Oleg", "Petrov", 61, "opetrov@gmail.com"),
                                   new User("Igor", "Anonim", 20, "ianonim@gmail.com"),
                                   new User("Olga", "Petrenko", 19, "opetrenko@gmail.com"),
                                   new User("Anna", "Clarkinson", 25, "aclark@gmail.com"),
                                   new User("Ganna", "Longsurname", 32, "glongsurname@gmail.com"));

        // task 1 - filter by age and show unique surnames
        users.stream()
                .filter(age -> age.getAge()>20)
  //              .filter(name->name.getName().contains("an"))
                .map(surname->surname.getSurname())
                .distinct()
                .forEach(System.out::println);
        System.out.println();


        //task 2  - filter by surname length (less than 8), show name and show only first result - if any -show my exception
        Optional<?> op = users.stream()
                .filter(surname->surname.getSurname().length() < 8)
                .map(name->name.getName())
                .findFirst();
        try {
            System.out.println(op.orElseThrow(()->new noUserException("No users were found")));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println();


        //       task 3.1 - filter by email length, delete 3 firs results, show age from sorted list
        users.stream()
                .filter(email->email.getEmail().length() > 17)
                .map(age->age.getAge())
                .sorted()
                .skip(3)
                .forEach(System.out::println);
        System.out.println();

        //       task 3.2 - filter by email length, delete 3 firs results, show age of birth from sorted list
        users.stream()
                .filter(email->email.getEmail().length() > 17)
                .map(age-> 2023 - age.getAge())
                .sorted()
                .skip(3)
                .forEach(System.out::println);
    }
}