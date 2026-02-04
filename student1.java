//generate a java code to compplete the student class with attributes name, age, grade and method displayInfo to print student details
class student1 {
    public static void main(String[] args) {
        student1 s1 = new student1("Bob", 21, "B");
        s1.displayInfo();
    }
    // Attributes
    private String name;
    private int age;
    private String grade;

    // Constructor
    public student1(String name, int age, String grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Method to display student information
    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
    }
}

