
package Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DBConnect {
  
    static public Connection con;
    static public Statement st;
    static public PreparedStatement checklogin;
    static public PreparedStatement addstudent;
    static public PreparedStatement getuser;
    static public PreparedStatement updateuser;
    static public PreparedStatement deleteuser;
    static public PreparedStatement studentid;
    static public PreparedStatement studentsignup; 
    static public PreparedStatement studentattendance;
    static public PreparedStatement viewattendance;
    static public PreparedStatement addmentor;
    static public PreparedStatement getmentor;
    static public PreparedStatement studentmentor;
    static public PreparedStatement addmarks;
    static public PreparedStatement viewmarks;
    static public PreparedStatement viewattend;
    static public PreparedStatement monitor;
    
    static{
        try{
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe","admin","admin");
            st=con.createStatement();
            checklogin=con.prepareStatement("select * from admin_login where u_id=? and pass=?");
            addstudent=con.prepareStatement("insert into student_details(admission_no,name,gender,phone_no,email_id,father_name,occupation,mother_name,quali,dob,age,religion,"
                    + "house_no,street,city,district,state,pincode,year)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            getuser=con.prepareStatement("select * from student_details where admission_no like ?");
            updateuser=con.prepareStatement("update student_details set admission_no=?,name=?,gender=?,phone_no=?,email_id=?,father_name=?,occupation=?,mother_name=?,quali=?,dob=?,age=?,"
                    + "religion=?,house_no=?,street=?,city=?,district=?,state=?,pincode=?,year=? where admission_no like ?");
            
            deleteuser=con.prepareStatement("delete student_details where admission_no=?");
            studentid=con.prepareStatement("select * from student_login where user_id=? and pass=?");
            studentsignup=con.prepareStatement("insert into student_login(user_id,pass) values(?,?)");
            studentattendance=con.prepareStatement("insert into student_attendance(admission_no,name,subject,day,attendance,year,semester,date_of)values(?,?,?,?,?,?,?,?)");
            viewattendance=con.prepareStatement("select * from student_attendance");
            addmentor=con.prepareStatement("insert into mentor(name,domain,skill,experience) values(?,?,?,?)");
            getmentor=con.prepareStatement("select * from mentor where  domain like ?");
            studentmentor=con.prepareStatement("insert into selectmentor (name,admission_no,mentor,year,semester,branch)values(?,?,?,?,?,?)" );
            addmarks=con.prepareStatement("insert into marks(name,admission_no,subject,semester,year,subject_code) values(?,?,?,?,?,?)");
            viewmarks=con.prepareStatement("select * from marks where admission_no like ?");
            viewattend=con.prepareStatement("select * from student_attendance where admission_no like ?");
            monitor=con.prepareStatement("insert into monitor (admission_no,name,timein,timeout,hours,date_of) values(?,?,?,?,?,?)");
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    
}
