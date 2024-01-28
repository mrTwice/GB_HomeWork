package ru.MyHomework.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Entity
@Table(name = "PersonDB.Persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private  int id;

    @Column(name="FirstName")
    @Getter
    @Setter
    private  String firstName;

    @Column(name="LastName")
    @Getter
    @Setter
    private  String lastName;

    @Column(name="BirthdayDate")
    @Getter
    private String birthdayDate;

    public Person() {
    }

    public Person(String firstName, String lastName, LocalDate birthdayDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdayDate = birthdayDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public int getAge(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale( Locale.US );
        LocalDate date = LocalDate.parse(birthdayDate, formatter);
        return Period.between(date, LocalDate.now()).getYears();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return new EqualsBuilder()
                .append(firstName, person.firstName)
                .append(lastName, person.lastName)
                .append(birthdayDate, person.birthdayDate)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(firstName)
                .append(lastName)
                .append(birthdayDate)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("birthdayDate", birthdayDate)
                .toString();
    }
}
