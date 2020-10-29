package classroom;

public class Student {
    public String firstName;
    public String lastName;
    public String bestSubject;

    public Student(String firstName, String lastName, String bestSubject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bestSubject = bestSubject;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getBestSubject() {
        return this.bestSubject;
    }

    @Override
    public String toString() {
        return String.format("Student: First Name= %s, Last Name= %s, Best Subject= %s"
                , this.firstName, this.lastName, this.bestSubject);
    }

    //Student
    //First, write a Java class Student with the following fields:
    //•	firstName: String
    //•	lastName: String
    //•	bestSubject: String
    //The class constructor should receive (firstName, lastName and bestSubject).
    //The class also should have the methods:
    //•	getFirstName()
    //•	getLastName()
    //•	getBestSubject()
    //•	Override the toString() method in the following format:
    //"Student: First Name= {firstName}, Last Name= {lastName}, Best Subject= {bestSubject}"
}
