// Class representing a course with a name and a test score
class Course {
    private String courseName;
    private double testScore;

    // Constructor for the Course class
    public Course(String courseName) {
        this.courseName = courseName;
        this.testScore = 0.0; // initializing test score to 0
    }

    // Method to set the test score for a course
    public void setTestScore(double score) {
        this.testScore = score;
    }

    // Method to get the test score of a course
    public double getTestScore() {
        return this.testScore;
    }

    // Method to get the name of the course
    public String getCourseName() {
        return this.courseName;
    }
}

// Class representing a student with a name and courses
class Student {
    private String firstName, lastName;
    private Course[] courses;

    // Default constructor for the Student class
    public Student() {
        this("", "");
    }

    // Overloaded constructor for the Student class with name parameters
    public Student(String first, String last) {
        this.firstName = first;
        this.lastName = last;
        this.courses = new Course[3]; // initializing an array of 3 courses
        for (int i = 0; i < 3; i++) {
            courses[i] = new Course("Course " + (i + 1)); // creating new courses
        }
    }

    // Method to set the test score for a specific course
    public void setTestScore(int courseIndex, double score) {
        if(courseIndex >= 0 && courseIndex < courses.length) {
            courses[courseIndex].setTestScore(score);
        }
    }

    // Method to get the test score for a specific course
    public double getTestScore(int courseIndex) {
        if(courseIndex >= 0 && courseIndex < courses.length) {
            return courses[courseIndex].getTestScore();
        }
        return 0;
    }

    // Method to calculate and return the average score of all courses
    public double getAverage() {
        double sum = 0.0;
        for (Course course : courses) {
            sum += course.getTestScore();
        }
        return sum / courses.length;
    }

    // Overriding the toString method to display student information and scores
    @Override
    public String toString() {
        String result = firstName + " " + lastName + "\n";
        for (Course course : courses) {
            result += course.getCourseName() + " Score: " + course.getTestScore() + "\n";
        }
        result += "Average Score: " + getAverage() + "\n";
        return result;
    }
}

// Driver class to demonstrate the functionality of Student and Course classes
public class School {
    public static void main(String[] args) {
        Student student1 = new Student("John", "Doe");
        student1.setTestScore(0, 85); // Setting score for course 1
        student1.setTestScore(1, 90); // Setting score for course 2
        student1.setTestScore(2, 95); // Setting score for course 3

        // Printing student details including course scores and average
        System.out.println(student1.toString());
    }
}
