package com.luv2code.component.model;

import javax.persistence.*;

@Entity
@Table(name="student")
public class CollegeStudent implements Student{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(name="email_address")
    private String emailAddress;

   // private StudentGrades studentGrades;

    public CollegeStudent()
    {}

    public CollegeStudent(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

//    public StudentGrades getStudentGrades() {
//        return studentGrades;
//    }
//    public void setStudentGrades(StudentGrades studentGrades) {
//        this.studentGrades = studentGrades;
//    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }



    @Override
    public String toString() {
        return "CollegeStudent{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +

                '}';
        //", studentGrades=" + studentGrades +
    }

    @Override
    public String studentInformation() {
        return studentFullName()+" "+getEmailAddress();
    }

    @Override
    public String studentFullName() {
        return getFirstName()+" "+getLastName();
    }

    private String getFirstNameAndId()
    {
        return getFirstName()+" "+getId();
    }
}
