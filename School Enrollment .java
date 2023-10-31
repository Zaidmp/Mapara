//Moe htet paing
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class test {
    public static void main(String[] args) throws IOException {

        int choice, ID, Zip, Courseid, enrollmentid, displaystudent, displaycourse, Year;
        String Firstname, Lastname, Address, City, Coursename, Coursedescription, filename, Semester, Grade;
        Scanner input = new Scanner(System.in);

        FileWriter studentwriter = new FileWriter("Studentfile.csv", true);
        FileWriter Coursewriter = new FileWriter("Coursefile.csv", true);
        FileWriter enrollmentwriter = new FileWriter("Enrollmentfile.csv", true);



        StudentfileManager student = new StudentfileManager("Studentfile.csv");
        StudentfileManager studentobj = new StudentfileManager();


        CourseFileManager cousre = new CourseFileManager("Coursefile.csv");
        CourseFileManager courseobj = new CourseFileManager();

        EnrollmentManager enrollment = new EnrollmentManager("Enrollmentfile.csv");
        EnrollmentManager enrollmentobj = new EnrollmentManager();


        do {

            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Add Course");
            System.out.println("4. Edit Course");
            System.out.println("5. Display Student");
            System.out.println("6. Display Course");
            System.out.println("7. Add Enrollment");
            System.out.println("8. Edit Enrollment");
            System.out.println("9. Display Enrollment");
            System.out.println("10. Exit");
            System.out.println("Please choose");
            choice = input.nextInt();
            input.nextLine();


            switch (choice) {
                case 1: {
                    FileWriter s1writer = new FileWriter("Studentfile.csv", true);
                    PrintWriter outputfile = new PrintWriter(s1writer);


                    System.out.println("Please enter student ID");
                    ID = input.nextInt();
                    input.nextLine();

                    System.out.println("Please enter student Name");
                    Firstname = input.nextLine();

                    System.out.println("Please enter student Address");
                    Address = input.nextLine();

                    System.out.println("Please enter student City");
                    City = input.nextLine();

                    System.out.println("Please enter student Zip");
                    Zip = input.nextInt();

                    boolean addstudent = studentobj.Addstudent(ID, Firstname, Address, City, Zip);
                    if (addstudent == false) {
                        System.out.println("Student ID already exist in the System");
                        break;
                    } else {
                        outputfile.print(ID);
                        outputfile.print(",");
                        outputfile.print(Firstname);
                        outputfile.print(",");
                        outputfile.print(Address);
                        outputfile.print(",");
                        outputfile.print(City);
                        outputfile.print(",");
                        outputfile.print(Zip);
                        outputfile.println("");

                        System.out.println("Data Added");
                    }
                    outputfile.close();
                    break;
                }
                case 2: {
                    FileWriter s1writer = new FileWriter("Studentfile.csv", true);
                    PrintWriter outputfile = new PrintWriter(s1writer);
                    File studentfile = new File("Studentfile.csv");

                    System.out.println("Please enter student ID to edit");
                    int checkid = input.nextInt();
                    input.nextLine();

                    Student updatecheck = studentobj.getstudent(checkid);

                    if (updatecheck != null) {
                        System.out.println("ID Found");

                        System.out.println("Please enter update student Name");
                        Firstname = input.nextLine();

                        System.out.println("Please enter update student Address");
                        Address = input.nextLine();

                        System.out.println("Please enter update student City");
                        City = input.nextLine();

                        System.out.println("Please enter update student Zip");
                        Zip = input.nextInt();

                        boolean update = studentobj.updatestudent(checkid, Firstname, Address, City, Zip, updatecheck, studentfile);

                        if (update) {

                            System.out.println("Data Added");
                            outputfile.close();
                        }
                    }
                    break;
                }
                case 3: {
                    FileWriter c1writer = new FileWriter("Coursefile.csv", true);
                    PrintWriter Coursefile = new PrintWriter(c1writer);


                    System.out.println("Please enter Course ID");
                    Courseid = input.nextInt();
                    input.nextLine();

                    System.out.println("Please enter Course Name");
                    Coursename = input.nextLine();

                    System.out.println("Please enter Course Description");
                    Coursedescription = input.nextLine();

                    boolean Addcourse = courseobj.Addcourse(Courseid, Coursename, Coursedescription);

                    if (Addcourse == false) {
                        System.out.println("Course ID already exist in the System");
                        break;
                    } else {
                        Coursefile.print(Courseid);
                        Coursefile.print(",");
                        Coursefile.print(Coursename);
                        Coursefile.print(",");
                        Coursefile.print(Coursedescription);
                        Coursefile.println("");

                        System.out.println("Data Added");
                        Coursefile.close();
                        break;
                    }

                }
                case 4: {

                    File csfile = new File("Coursefile.csv");
                    FileWriter c1writer = new FileWriter("Coursefile.csv", true);
                    PrintWriter Coursefile = new PrintWriter(c1writer);

                    // FileWriter Coursewriter = new FileWriter("Course1.csv", true);
                    //PrintWriter Coursefile = new PrintWriter(Coursewriter);

                    System.out.println("Please enter Course ID to edit");
                    int checkid = input.nextInt();
                    input.nextLine();

                    Course updatecheck = courseobj.getcourseID(checkid);

                    if (updatecheck != null) {
                        System.out.println("ID Found");

                        System.out.println("Please enter Course Name");
                        String csname = input.nextLine();

                        System.out.println("Please enter Course description");
                        String csdescription = input.nextLine();


                        boolean update = courseobj.updatecourse(checkid, csname, csdescription, updatecheck, csfile);

                        if (update) {

                            System.out.println("Data Added");
                            Coursefile.close();
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    File file = new File("Studentfile.csv");
                    Scanner inputfile = new Scanner(file);
                    int size = (int) file.length();

                    System.out.println("Please enter the student Id number to display");
                    int todiplayid = input.nextInt();
                    //input.nextLine();

                    while (inputfile.hasNext()) {
                        for (int i = 0; i < size; i++) {
                            String Line = inputfile.nextLine();
                            String[] Value = Line.split(",");

                            if (todiplayid == Integer.parseInt(Value[0])) {
                                System.out.println("Student ID is :" + Value[0]);
                                System.out.println("Student Name is :" + Value[1]);
                                System.out.println("Student Address is :" + Value[2]);
                                System.out.println("Student Zip is :" + Value[3]);
                                System.out.println();

                                break;

                            }
                        }
                        break;
                    }
                    break;
                }
                case 6: {
                    File file = new File("Coursefile.csv");
                    Scanner inputfile = new Scanner(file);
                    int size = (int) file.length();

                    System.out.println("Please enter the Course Id to display");
                    int todiplayid = input.nextInt();

                    while (inputfile.hasNext()) {
                        for (int i = 0; i < size; i++) {
                            String Line = inputfile.nextLine();
                            String[] Value = Line.split(",");

                            if (todiplayid == Integer.parseInt(Value[0])) {
                                System.out.println("Course ID is :" + Value[0]);
                                System.out.println("Course Name is :" + Value[1]);
                                System.out.println("Course Description is :" + Value[2]);
                                System.out.println();
                                break;

                            }
                        }
                        break;
                    }
                    break;
                }

                case 7: {
                    int SID, CSID, YEAR, EID;
                    String SEMESTER, GRADE;

                    File efile = new File("Enrollmentfile.csv");
                    FileWriter ewriter = new FileWriter("Enrollmentfile.csv", true);
                    PrintWriter enrollmentoutputfile = new PrintWriter(ewriter);




                    System.out.println("Enter Enrollment ID");
                    EID = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Course ID");
                    CSID = input.nextInt();

                    System.out.println("Enter Student ID");
                    SID = input.nextInt();
                    input.nextLine();

                    System.out.println("Please Enter Semester you wish to enroll");
                    SEMESTER = input.nextLine();

                    System.out.println("Please enter  Year ");
                    YEAR = input.nextInt();
                    input.nextLine();

                    System.out.println("Enter Grade");
                    GRADE = input.nextLine();

                    boolean Addenrollment = enrollmentobj.Addenrollment(EID,CSID,SID, YEAR, SEMESTER, GRADE);

                    if (Addenrollment == false) {
                        System.out.println("Student ID  and Course ID already exist in the System");
                        break;
                    } else {
                        enrollmentoutputfile.print(EID);
                        enrollmentoutputfile.print(",");
                        enrollmentoutputfile.print(CSID);
                        enrollmentoutputfile.print(",");
                        enrollmentoutputfile.print(SID);
                        enrollmentoutputfile.print(",");
                        enrollmentoutputfile.print(YEAR);
                        enrollmentoutputfile.print(",");
                        enrollmentoutputfile.print(SEMESTER);
                        enrollmentoutputfile.print(",");
                        enrollmentoutputfile.print(GRADE);
                        enrollmentoutputfile.println("");

                        System.out.println("Data Added");
                        enrollmentoutputfile.close();
                        break;
                    }


                }

                case 8: {
                    FileWriter ewriter = new FileWriter("Enrollmentfile.csv", true);
                    PrintWriter enrollmentoutputfile = new PrintWriter(ewriter);
                    File efile = new File("Enrollmentfile.csv");

                    System.out.println("Now Please enter Enrollment ID to edit");
                    int Eid = input.nextInt();
                    input.nextLine();

                    System.out.println("Now Please enter Course ID to edit");
                    int Csid = input.nextInt();
                    input.nextLine();


                    System.out.println("Please enter Student ID to edit");
                    int Sid = input.nextInt();
                    input.nextLine();

                    System.out.println("Now Please enter Year  to edit");
                    int yr = input.nextInt();
                    input.nextLine();

                    System.out.println("Now Please enter Semester to edit");
                    String Sem = input.nextLine();


                    Enrolement updatecourse = enrollmentobj.getEnrollment(Eid,Csid,Sid, yr, Sem);

                    if (updatecourse != null) {
                        System.out.println("Student,Course,Enrollment,Semester,Year Found");
                        System.out.println();

                        System.out.println("Please enter New Enrollment ID ");
                        int eid = input.nextInt();
                        input.nextLine();

                        System.out.println("Please enter New Course ID ");
                        int csid = input.nextInt();
                        input.nextLine();

                        System.out.println("Please enter New Student ID ");
                        int sid = input.nextInt();
                        input.nextLine();

                        System.out.println("Please enter Year you wish to enroll ");
                        int year = input.nextInt();
                        input.nextLine();

                        System.out.println("Please enter Semester you wish to enroll ");
                        String sem = input.nextLine();

                        System.out.println("Please enter new Grade ");
                        String grade = input.nextLine();

                        boolean update = enrollmentobj.updateenrollment(eid,csid,sid, year, sem, grade, updatecourse, efile);

                        if (update) {

                            System.out.println("Data Added");
                            enrollmentoutputfile.close();
                            break;
                        }
                    }
                    break;
                }

                case 9:
                {
                    File file = new File("Enrollmentfile.csv");
                    Scanner inputfile = new Scanner(file);
                    int size = (int) file.length();

                    System.out.println("Please enter the Enrollment Id to display");
                    int eid = input.nextInt();

                    System.out.println("Now Please enter the Course Id to display");
                    int csid = input.nextInt();

                    System.out.println("Please enter the Enrollment Id to display");
                    int sid = input.nextInt();


                    while (inputfile.hasNext()) {
                        for (int i = 0; i < size; i++) {
                            String Line = inputfile.nextLine();
                            String[] Value = Line.split(",");

                            if (eid == Integer.parseInt(Value[0]) && csid == Integer.parseInt(Value[1]) && sid == Integer.parseInt(Value[2])) {
                                System.out.println("Enrollment ID is :" + Value[0]);
                                System.out.println("Course ID is :" + Value[1]);
                                System.out.println("Student ID is :" + Value[2]);
                                System.out.println("Year is :" + Value[3]);
                                System.out.println("Semester is :" + Value[4]);
                                System.out.println("Grade is :" + Value[5]);
                                System.out.println();
                                break;

                            }
                        }
                        break;
                    }
                    break;

                }
            }

        }
        while (choice != 10) ;
        System.exit(0);
    }
}

class StudentfileManager {
    File studentfile;
    static ArrayList<Student> studentarray = new ArrayList<Student>();

    StudentfileManager(String student) throws IOException {
        studentfile = new File(student);
        Scanner inputfile = new Scanner(studentfile);
        int size = (int) studentfile.length();


        while (inputfile.hasNext()) {
            String line = inputfile.nextLine();
            String[] Value = line.split(",");

            if (Value.length == 5) {
                int id = Integer.parseInt(Value[0]);
                String name = Value[1];
                String address = Value[2];
                String city = Value[3];
                int Zip = Integer.parseInt(Value[4]);
                Student Stu = new Student(id, name, address, city, Zip);
                studentarray.add(Stu);


            }
        }
        inputfile.close();


    }

    StudentfileManager() {

    }

    boolean Addstudent(int Id, String name, String address, String city, int zip) {
        int AID, AZIP;
        String AName, AAdress, ACity;


        AID = Id;
        AZIP = zip;
        AName = name;
        AAdress = address;
        ACity = city;

        int checkid = Id;

        Student check = getstudent(checkid);

        if (check == null) {
            Student Stu = new Student(Id, name, address, city, zip);
            studentarray.add(Stu);
            return true;
        } else
            return false;
    }


    Student getstudent(int id) {
        Student s1 = new Student();
        if (studentarray.isEmpty()) {
            s1 = null;
        }
        for (Student student : studentarray) {
            if (student.id == id) {
                s1 = student;
                break;
            } else {
                s1 = null;
            }
        }
        if (s1 == null) {
            System.out.println("Student Id doesn't exist");
        }

        return s1;
    }

    boolean updatestudent(int id, String name, String address, String city, int zip, Student update, File studentfile) throws IOException {
        FileWriter studentwriter = new FileWriter("Studentfile.csv", true);
        PrintWriter outputfile = new PrintWriter(studentwriter);
        File sfile=new File("Studentfile.csv");
        Scanner delete=new Scanner(sfile);

        int ID, ZIP;
        String Name, Adress, City;

        studentarray.remove(update);

        ID = id;
        ZIP = zip;
        Name = name;
        Adress = address;
        City = city;

        update.id = ID;
        update.name = Name;
        update.city = City;
        update.address = Adress;
        update.zip = ZIP;

        //Student Stu = new Student(ID, Name, Adress, City, ZIP);
        studentarray.add(update);
        boolean deleteline=deleteStudent(id,sfile);

        if(deleteline)
        {
            for (Student student : studentarray)
            {
                    outputfile.print(student.id);
                    outputfile.print(",");
                    outputfile.print(student.name);
                    outputfile.print(",");
                    outputfile.print(student.address);
                    outputfile.print(",");
                    outputfile.print(student.city);
                    outputfile.print(",");
                    outputfile.print(student.zip);
                    outputfile.print("");
                    outputfile.println();

            }
        }
        outputfile.close();
        return true;
    }

    boolean deleteStudent(int id, File studentfile) throws IOException {
        ArrayList<String> updatedData = new ArrayList<>();
        PrintWriter outputfile = new PrintWriter(studentfile);

        for (Student student : studentarray)
        {
            if (student.id == id)
            {
                break;
            }
            else
            {
                updatedData.add(student.id + "," + student.name + "," + student.address + "," + student.city + "," + student.zip);
            }
        }

        for (String line : updatedData)
        {
                outputfile.println(line);
        }

        System.out.println("Data with ID " + id + " has been deleted.");
        System.out.println("Rewriting new data");
        outputfile.println();
        return true;
    }

}

class CourseFileManager {
    static ArrayList<Course> courseArrayList = new ArrayList<Course>();
    File coursefile;

    CourseFileManager(String course) throws IOException {
        coursefile = new File(course);
        Scanner inputfile = new Scanner(coursefile);
        int size = (int) coursefile.length();


        while (inputfile.hasNext()) {
            String line = inputfile.nextLine();
            String[] Value = line.split(",");

            if (Value.length == 3) {
                int csid = Integer.parseInt(Value[0]);
                String csname = Value[1];
                String csdes = Value[2];

                Course cou = new Course(csid, csname, csdes);
                courseArrayList.add(cou);


            }
        }
        inputfile.close();
    }

    CourseFileManager()
    {

    }
    boolean Addcourse(int csid, String csname, String csdescription) {
        int CSID;
        String CSName, CSDESCRIPTION;


        CSID = csid;
        CSName = csname;
        CSDESCRIPTION = csdescription;

        int checkid = CSID;
        Course check = getcourseID(checkid);


        if (check == null) {
            Course cu = new Course(CSID, CSName, CSDESCRIPTION);
            courseArrayList.add(cu);
            return true;
        } else
            return false;
    }

    Course getcourseID(int id) {
        Course c1 = new Course();
        if(courseArrayList.isEmpty())
        {
            c1=null;
        }
        for (Course course : courseArrayList)
        {
            if (course.courseid == id)
            {
                c1 = course;
                break;
            }
            else
            {
                c1 = null;
            }
        }
        if(c1==null)
        {
            System.out.println("Course Id doesn't exist");
        }

        return c1;
    }

    boolean updatecourse(int csid, String csname, String csdescription,Course update, File coursefile) throws IOException {
        FileWriter coursewriter = new FileWriter("Coursefile.csv", true);
        PrintWriter outputfile = new PrintWriter(coursewriter);
        File csfile=new File("Coursefile.csv");
        Scanner inputfile = new Scanner(csfile);
        boolean found=false;
        int IID=csid;

        int CSID;
        String CSNAME,CSDESCRIPTION;

        courseArrayList.remove(update);

        CSID = csid;
        CSNAME = csname;
        CSDESCRIPTION = csdescription;


        update.courseid = csid;
        update.coursename = csname;
        update.coursedescription = csdescription;


        courseArrayList.add(update);
        boolean deleteline=deletecourse(csid,csfile);

        if(deleteline)
        {
            for (Course course : courseArrayList)
            {
                outputfile.print(course.courseid);
                outputfile.print(",");
                outputfile.print(course.coursename);
                outputfile.print(",");
                outputfile.print(course.coursedescription);
                outputfile.print("");
                outputfile.println();

            }
        }
        outputfile.close();
        return true;
    }
    boolean deletecourse(int id, File coursefile) throws IOException {
        ArrayList<String> updatedData = new ArrayList<>();
        PrintWriter outputfile = new PrintWriter(coursefile);

        for (Course course : courseArrayList)
        {
            if (course.courseid == id)
            {
                break;
            }
            else
            {
                updatedData.add(course.courseid + "," + course.coursename + "," + course.coursedescription);
            }
        }

        for (String line : updatedData)
        {
            outputfile.println(line);
        }

        System.out.println("Data with ID " + id + " has been deleted.");
        System.out.println("Rewriting new data");
        outputfile.println();
        return true;
    }

}

    class Student {
        int id, zip;
        String name, address, city;

        Student(int ID, String Name, String ADDRESS, String CITY, int ZIP) {

            id = ID;
            zip = ZIP;
            name = Name;
            address = ADDRESS;
            city = CITY;
        }

        Student() {
            // id=ID;

        }

        public int getid() {
            return id;

        }
    }

    class EnrollmentFileManager
    {
        EnrollmentFileManager(int sid,int csid)
        {

        }
        EnrollmentFileManager()
        {

        }
    }

class Course
{
    int courseid;
    String coursename,coursedescription;

    Course(int Courseid, String Coursename, String Coursedescription) {

        courseid = Courseid;
        coursename = Coursename;
        coursedescription = Coursedescription;
    }

    Course()
    {

    }

    public int getid()
    {
        return courseid;
    }

}
class EnrollmentManager
{
    File Enrollmentfile;
    static ArrayList<Enrolement> Enrollmentarray = new ArrayList<Enrolement>();
    EnrollmentManager(String enrollment) throws IOException{
        Enrollmentfile = new File(enrollment);
        Scanner inputfile = new Scanner(Enrollmentfile);
        int size = (int) Enrollmentfile.length();


        while (inputfile.hasNext()) {
            String line = inputfile.nextLine();
            String[] Value = line.split(",");

            if (Value.length == 6) {
                int Enrollmentid=Integer.parseInt(Value[0]);
                int CourseID=Integer.parseInt(Value[1]);
                int StudentID=Integer.parseInt(Value[2]);
                int Year = Integer.parseInt(Value[3]);
                String Semester = Value[4];
                String Grade = Value[5];

                Enrolement eu = new Enrolement(Enrollmentid,CourseID,StudentID,Semester, Year, Grade);
                Enrollmentarray.add(eu);

            }
        }
    }
    EnrollmentManager()
    {

    }

    boolean Addenrollment(int eid,int csid,int sid ,int year, String semester,String grade) {
        int SID,CSID,YEAR,EID;
        String SEMESTER,GRADE;


        EID=eid;
        CSID = csid;
        SID=sid;
        YEAR = year;
        SEMESTER = semester;
        GRADE=grade;

        //int SID = ;
        Enrolement check = getEnrollment(EID,CSID,SID,YEAR,SEMESTER);


        if (check == null) {
            Enrolement eu = new Enrolement(EID,CSID,SID,SEMESTER,YEAR,GRADE);
            Enrollmentarray.add(eu);
            return true;
        } else
            return false;
    }

    Enrolement getEnrollment(int eid,int csid ,int sid,int year, String semester) {
        Enrolement e1 = new Enrolement();

        int SID,CSID,YEAR,EID;
        String SEMESTER;


        EID=eid;
        CSID = csid;
        SID=sid;
        YEAR = year;
        SEMESTER = semester;

        if(Enrollmentarray.isEmpty())
        {
            e1=null;
        }
        for (Enrolement enrolement : Enrollmentarray)
        {
            if (enrolement.Studentid == SID && enrolement.Courseid == CSID && enrolement.Year==YEAR && enrolement.Semester.equals(SEMESTER))
            {
                e1 = enrolement;
                break;
            }
            else
            {
                e1 = null;
            }
        }
        if(e1==null)
        {
            System.out.println("Student or Course Id doesn't exist");
        }

        return e1;
    }

    boolean updateenrollment(int Eid,int Cid,int Sid,int year,String sem,String grade,Enrolement update, File efile) throws IOException {

        FileWriter coursewriter = new FileWriter("Enrollmentfile.csv", true);
        PrintWriter outputfile = new PrintWriter(coursewriter);
        File csfile=new File("Enrollmentfile.csv");
        //Course cu=new Course();
        Scanner inputfile = new Scanner(csfile);

        boolean found=false;
        //int IID=csid;

        int SID,CSID,EID,Year;
        String SEMESTER,GRADE;

        Enrollmentarray.remove(update);

        EID = Eid;
        CSID=Cid;
        SID=Sid;
        SEMESTER=sem;
        Year=year;
        GRADE=grade;


        update.Enrollmentid = EID;
        update.Courseid = CSID;
        update.Studentid = SID;
        update.Semester=SEMESTER;
        update.Year=Year;
        update.Grade=GRADE;

        Enrollmentarray.add(update);
        boolean deleteline=deleteenrollment(EID,CSID,SID,Year,SEMESTER,GRADE,efile);

        if(deleteline)
        {
            for (Enrolement enrolement : Enrollmentarray)
            {
                outputfile.print(enrolement.Enrollmentid);
                outputfile.print(",");
                outputfile.print(enrolement.Courseid);
                outputfile.print(",");
                outputfile.print(enrolement.Studentid);
                outputfile.print(",");
                outputfile.print(enrolement.Year);
                outputfile.print(",");
                outputfile.print(enrolement.Semester);
                outputfile.print(",");
                outputfile.print(enrolement.Grade);
                outputfile.print("");
                outputfile.println();

            }
        }
        outputfile.close();
        return true;
    }
    boolean deleteenrollment(int sid,int csid,int eid,int year,String sem,String grade, File coursefile) throws IOException {
        ArrayList<String> updatedData = new ArrayList<>();
        PrintWriter outputfile = new PrintWriter(coursefile);

        for (Enrolement enrolement : Enrollmentarray)
        {
            if (enrolement.Studentid == sid && enrolement.Courseid == csid && enrolement.Year==year && enrolement.Semester.equals(sem))
            {
                break;
            }
            else
            {
                updatedData.add(enrolement.Studentid + "," + enrolement.Courseid + "," + enrolement.Enrollmentid + "," + enrolement.Year + "," + enrolement.Semester + "," + enrolement.Grade);
            }
        }

        for (String line : updatedData)
        {
            outputfile.println(line);
        }

        System.out.println("Old Data has been deleted.");
        System.out.println("Rewriting new data");
        outputfile.println();
        return true;
    }




}

class Enrolement
{
    int Year,Enrollmentid,Studentid,Courseid;
    String Semester,Grade;
    Enrolement(int eid,int csid,int sid,String sem,int year,String grade)
    {
        Enrollmentid=eid;
        Courseid=csid;
        Studentid=sid;
        Semester=sem;
        Year=year;
        Grade=grade;

    }

    Enrolement()
    {

    }

}

