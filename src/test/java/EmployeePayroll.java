import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
public class EmployeePayroll {
    public void JDBCConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/Employeepayroll2";
        String user = "root";
        String pwd = "  ";
//Step 2: Establish the connection (path)
        Connection con = DriverManager.getConnection(url,user,pwd);

// Step3: Create a statement object
        Statement st = con.createStatement();

// Step 4: Execute query to get ResultSet
       // String sql = "  SELECT * FROM Employeepayroll";
        //String sql="  ALTER TABLE Employeepayroll ADD emp_id int(15) NOT NULL;"
        //String sql="INSERT INTO Employeepayroll(first_name,last_name,address,city,state,zip,phone_num,email,emp_id) VALUES('aruna','gandhi','chhatarpur','delhi','UP',109198,79384908,'gandhi_arudu@gmail.com',03)";
         // String sql="  UPDATE Employeepayroll set emp_id=02 WHERE first_name='Shiya'";
          // String sql=" DELETE FROM Employeepayroll WHERE first_name='aruna' and last_name='gandhi'";
            String sql="  SELECT * FROM Employeepayroll";
        ResultSet rs = st.executeQuery(sql);

// Step 5: Iterate
        while(rs.next()){
            System.out.println( " Emp id: "+ rs.getString(1)+
                    "FirstName: " + rs.getString(2)+
                    "LastName: " + rs.getString(3) +
                    " Address:"+rs.getString(4)+
                    " City: "+ rs.getString(5)+
                    " Emp_contact: "+ rs.getString(6)+
                    " EmailId "+ rs.getString(7)
            );
        }
// Step 6: Close the connection object
        con.close();
    }

    public static void main(String[] args) throws Exception {
// step 1: load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        EmployeePayroll epr = new EmployeePayroll();
        epr.JDBCConnection();
    }

}
