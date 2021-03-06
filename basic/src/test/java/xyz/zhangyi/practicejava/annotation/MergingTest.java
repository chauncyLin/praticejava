package xyz.zhangyi.practicejava.annotation;

import lombok.Data;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MergingTest {
    @Data
    class Address {
        private String country;
        private String city;

        public Address(String country, String city) {
            this.country = country;
            this.city = city;
        }
    }

    @Data
    class Email {
        private String value;

        public Email(String value) {
            this.value = value;
        }
    }

    @Data
    class Score {
        private int value;

        public Score(int value) {
            this.value = value;
        }
    }

    class Printer {
        String print() {
            return "print";
        }
    }

    class SubPrinter extends Printer {
        @Override
        String print() {
            return "sub printer";
        }
    }

    @Data
    class Employee implements Merging<Employee> {
        @MergeOn(level = Level.Ignore)
        private String name;
        private Address address;
        @MergeOn(level = Level.Mandatory)
        private Email email;
        @MergeOn(level = Level.Required)
        private int age;
        @MergeOn(level = Level.Mandatory)
        private List<Score> scores;
        @MergeOn(level = Level.Ignore)
        private Printer printer = new Printer();

        public Employee(String name, Address address, int age) {
            this.name = name;
            this.address = address;
            this.age = age;
        }
    }

    @Test
    public void should_merge_new_employee() {
        Address oldAddress = new Address("china", "chengdu");
        List<Score> oldScores = Arrays.asList(new Score(60), new Score(90));
        Employee employee = new Employee("bruce", oldAddress, 30);
        employee.setEmail(new Email("zhangyi@163.com"));
        employee.setScores(oldScores);

        Address newAddress = new Address("china", "chongqing");
        Employee newEmployee = new Employee("zhangyi", newAddress, 40);
        List<Score> newScores = Arrays.asList(new Score(80), new Score(100), new Score(99));
        newEmployee.setScores(newScores);
        newEmployee.setPrinter(new SubPrinter());

        employee.mergeWith(newEmployee);

        assertThat(employee.name).isEqualTo("bruce");
        assertThat(employee.address.getCity()).isEqualTo("chongqing");
        assertThat(employee.email).isNull();
        assertThat(employee.age).isEqualTo(40);
        assertThat(employee.scores.size()).isEqualTo(3);
        assertThat(employee.scores.get(0).value).isEqualTo(80);
        assertThat(employee.scores.get(2).value).isEqualTo(99);
        assertThat(employee.printer.print()).isEqualTo("print");
    }

}