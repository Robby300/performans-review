package question4153;

import java.io.Serializable;
import java.util.Objects;


public class Employee implements Serializable {
    static final long serialVersionUID = 8129437039424566964L;

    private String name;
    private int number;
//    private String firstName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return number == employee.number
                && Objects.equals(name, employee.name);
//                && Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }
}
