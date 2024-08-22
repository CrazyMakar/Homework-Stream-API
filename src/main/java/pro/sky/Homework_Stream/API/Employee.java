package pro.sky.Homework_Stream.API;

import static org.apache.commons.lang3.StringUtils.capitalize;

public record Employee(String firstName, String lastName, int salary, int departmentId) {
    public Employee(String firstName, String lastName, int salary, int departmentId) {
        this.firstName = capitalize(firstName.toLowerCase());
        this.lastName = capitalize(lastName.toLowerCase());
        this.salary = salary;
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", departmentId=" + departmentId +
                '}';
    }
}