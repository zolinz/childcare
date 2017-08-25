package childcare.jdbc;

import java.sql.*;


public class ConnectURL {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test";

    //  Database credentials
    static final String USER = "admin";
    static final String PASS = "admin";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id_toddler, first_name, last_name FROM toddler";
            ResultSet rs = stmt.executeQuery(sql);


            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id_toddler  = rs.getInt("id_toddler");
                //int age = rs.getInt("age");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");

                //Display values
                System.out.print("ID: " + id_toddler);
                //System.out.print(", Age: " + age);
                System.out.print(", Firstname: " + first_name);
                System.out.println(", Lastname: " + last_name);
            }

            // INSERT DATA  --> Execute a query  --> INSERT
            System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sqlInsert = "INSERT INTO TODDLER " +
                    "VALUES (2, 'Zoltan', 'Kovacs')";
            stmt.executeUpdate(sqlInsert);
            sqlInsert = "INSERT INTO TODDLER " +
                    "VALUES (3, 'Katalin', 'Kovacs')";
            stmt.executeUpdate(sqlInsert);
            sqlInsert = "INSERT INTO TODDLER " +
                    "VALUES (4, 'Reka', 'Kallay')";
            stmt.executeUpdate(sqlInsert);
            sqlInsert = "INSERT INTO TODDLER " +
                    "VALUES(5, 'Bulcsu', 'Kallay')";
            stmt.executeUpdate(sqlInsert);
            System.out.println("Inserted records into the TODDLER table...");


            while(rs.next()){
                //Retrieve by column name
                int id_toddler  = rs.getInt("id_toddler");
                //int age = rs.getInt("age");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");

                //Display values
                System.out.print("ID: " + id_toddler);
                //System.out.print(", Age: " + age);
                System.out.print(", Firstname: " + first_name);
                System.out.println(", Lastname: " + last_name);
            }



            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye my friend!");
    }//end main
}//end FirstExample