package mVCPatternExample;

public class MVCPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Student student = new Student("John Doe", 1, "A");

	        // Create a StudentView
	        StudentView studentView = new StudentView();

	        // Create a StudentController
	        StudentController studentController = new StudentController(student, studentView);

	        // Update the view with initial student details
	        studentController.updateView();

	        // Update student details
	        studentController.setStudentName("Jane Smith");
	        studentController.setStudentGrade("B");

	        // Update the view with new student details
	        studentController.updateView();

	}

}
