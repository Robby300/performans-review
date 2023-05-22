package question4153;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InvalidClassException;

import static org.junit.Assert.assertEquals;

public class SerializableTest {
    private Employee employee;
    @Before
    public void init() {
        employee = new Employee();
        employee.setName("Иван");
        employee.setNumber(1);
    }


    // сериализую - десериализую Ивана
    @Test
    public void serialisationTest() throws IOException, ClassNotFoundException {
        Serialisator.serialize(employee);
        Employee deserializedEmployee = (Employee) Serialisator.deserialize();
        assertEquals(employee, deserializedEmployee);
    }

    // но поменяв serialVersionUID попытка десериализовать  - кинет исключение.
    @Test(expected = InvalidClassException.class)
    public void serialisationTestShouldThrow() throws IOException, ClassNotFoundException {
        Employee deserializedEmployee = (Employee) Serialisator.deserialize();
    }
}
