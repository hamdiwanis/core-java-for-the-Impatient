package ch10;

import java.net.PasswordAuthentication;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex26 {
    public static <T> CompletableFuture<T> repeat(Supplier<T> action, Predicate<T> until) {
        return CompletableFuture.supplyAsync(action).thenApplyAsync(res -> {
            if (until.test(res)) {
                return res;
            } else {
                return repeat(action, until).join();
            }
        });
    }

    public static PasswordAuthentication askForPassword() {
        Scanner in = new Scanner(System.in);
        System.out.print("Please Enter Your Password: ");
        char[] password = in.nextLine().toCharArray();
        return new PasswordAuthentication("USER", password);
    }

    public static boolean validatePassword(PasswordAuthentication authentication) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }

        return new String(authentication.getPassword()).equals("secret");
    }

    public static void main(String[] args) {
        repeat(Ex26::askForPassword, Ex26::validatePassword)
                .thenAccept((a) -> System.out.print("Logged In Successfully"))
                .join();
    }
}
