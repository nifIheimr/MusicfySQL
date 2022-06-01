package musicfysql;

import java.sql.*;

public class MusicfySQL {
    static Connection connection = null;
    static String db = 
                "jdbc:mysql://localhost:3306/" +
                "musicfy";
    static String user = "root";
    static String pwd = "admin";
    
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
        int status;
        String query = "INSERT INTO track VALUES (101, \"Track de prueba\", 0, '0:00', '0000-00-00', \"Musicfy\");";
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

        } catch(InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        connection = DriverManager.getConnection(db, user, pwd);
        
        Statement stmt = connection.createStatement();
        ResultSet rs;
        
        rs = stmt.executeQuery(query);
        
        while(rs.next()) {
            
        }
        
        
        //PreparedStatement ps = connection.prepareStatement(query);
        
        /*
        if((status = ps.executeUpdate()) != 0) {
            System.out.printf("\nCONNECTED TO DATABASE");
            System.out.printf("\nQUERY EXECUTED");
            System.out.printf("\n");
        }
        */
        
        connection.close();
    }
    
    public static boolean connectToDatabase(String connectionURL, String user, String password) {
        try(Connection connection = DriverManager.getConnection(connectionURL, user, password)) {
            return true;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
