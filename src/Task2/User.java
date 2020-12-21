package Task2;

import java.util.Objects;

public class User {
    private String firstname;
    private String lastname;
    private int age;
    private String profession;
    private Address address;

    public User(String firstname, String lastname, int age, String profession, Address address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.profession = profession;
        this.address = address;
    }

    public void validate() {
        boolean firstNameIsNotValid = this.firstname == null || this.firstname.length() < 3;
        boolean lastNameIsNotValid = this.lastname == null || this.lastname.length() < 3;
        boolean ageIsNotValid = this.age <= 0;
        boolean professionIsNotValid = this.profession == null || (this.profession.length() < 3 || this.profession.length() > 20);
        if (firstNameIsNotValid) {
            throw new ValidateException("First name is not valid", Code.STATUS_200);
        }
        if (lastNameIsNotValid) {
            throw new ValidateException("Last name is not valid", Code.STATUS_400);
        }
        if (ageIsNotValid) {
            throw new ValidateException("Age is not valid", Code.STATUS_500);
        }
        if (professionIsNotValid) {
            throw new ValidateException("Profession is not valid", Code.STATUS_500);
        }
        this.validateAddress(this.address);

        System.out.println("USER IS VALID");
    }

    private void validateAddress(Address address) {
        boolean cityIsNotValid = address.getCity().length() < 3;
        boolean streetIsNotValid = address.getStreet().length() < 4;

        if (cityIsNotValid) {
            throw new ValidateException("Address is not valid (field city)", Code.STATUS_400);
        }
        if (streetIsNotValid) {
            throw new ValidateException("Address is not valid (field street)", Code.STATUS_500);
        }
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", profession='" + profession + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(firstname, user.firstname) &&
                Objects.equals(lastname, user.lastname) &&
                Objects.equals(profession, user.profession) &&
                Objects.equals(address, user.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname, age, profession, address);
    }
}
