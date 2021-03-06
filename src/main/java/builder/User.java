package builder;

// Assumption: User class is immutable. Age, phone, address is optional

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by Michał Gębarowski on 31/07/2018
 */
public class User {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final String phone;
    private final String addresss;


    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.addresss = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddresss() {
        return addresss;
    }

    public static class UserBuilder {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder(String firstName, String lastName) {
            this.firstName = checkNotNull(firstName, "First name cannot be null");
            this.lastName = checkNotNull(lastName, "Last name cannot be null");
        }

        public UserBuilder setAge(int age) {
            checkArgument(age < 120 && age >= 0, "Age out of range");
            this.age = age;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}


