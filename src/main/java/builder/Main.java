package builder;

public class Main {

    public static void main(String[] args) {

        User user = new User.UserBuilder("Michal", "Gebarowski")
                .setAge(31)
                .setPhone("1234567")
                .setAddress("Leeds")
                .build();
    }
}
