import java.util.ArrayList;

public class Student extends Person{
    
    private String studentId;
    private ArrayList<String> courses;
    private ArrayList<Double> marks;

    public Student(String studentId, String name){
        super(name); //think super as go to  my parent class
        
        this.studentId = studentId;

        courses =  new ArrayList<>();
        marks = new ArrayList<>();
    }

    public void addCourse(String course){
        courses.add(course);
        return;
    }
    
    public void addMark(double mark){
        marks.add(mark);
        return;
    }

    public double calculateAvg(){
        if(marks.isEmpty()){
            return 0;
        }
        double sum =0;

        for(double mark: marks){ //For every mark inside the marks ArrayList, take one mark at a time.
            sum= sum+mark;
        }

        return sum/ marks.size();
    }

    public String determineGrade(){
        double average = calculateAvg();

        if (average >= 85){
            return "HD";
        }
        else if (average >=75){
            return "D";
        }

        else if (average >= 65){
            return "C";
        }
        
        else if(average >=50){
            return "P";
        }
        else {
            return "FF";
        }
        
    }

    public void displayTranscript(){

        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + getName());
        System.out.println("Courses and Marks:");

        for (int i = 0; i < courses.size(); i++) {
        System.out.println(courses.get(i) + ": " + marks.get(i));
        }
    }
}
