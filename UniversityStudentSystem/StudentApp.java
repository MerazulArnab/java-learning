public class StudentApp {
    public static void main(String[] args) {
        
        Student arnab = new Student ("c3500012", "Arnab");
        System.out.println("Name: "+ arnab.getName());

        arnab.addCourse("Java");
        arnab.addCourse("Ds");
        System.out.println();

        arnab.addMark(85);
        arnab.addMark(78);
        System.out.println();

        System.out.println("Average: " + arnab.calculateAvg());
        System.out.println("Grade: " + arnab.determineGrade());

        arnab.displayTranscript();
    }
}
