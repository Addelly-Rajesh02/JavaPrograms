package java8features.optionalclass;

import java.util.Optional;

public class OptionalExample
{
    public static Optional<String> findUserName(int userId) {
        if (userId == 1) {
            return Optional.of("Alice");
        } else {
            return Optional.empty();
        }
    }

    public static void main(String[] args) {
        Optional<String> user1 = findUserName(1);
        if (user1.isPresent()) {
            System.out.println("User found: " + user1.get());
        } else {
            System.out.println("User not found.");
        }
        Optional<String> user2 = findUserName(2);
        String userName = user2.orElse("Guest");
        System.out.println("User name: " + userName);
    }
}