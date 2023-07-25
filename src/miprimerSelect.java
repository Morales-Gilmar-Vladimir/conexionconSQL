import java.sql.*;

public class miprimerSelect {
    static final String DB_URL="jdbc:mysql://localhost/Almacenamiento";
    static final String USER="root";
    static final String PASS="root_bas3";
    static final String QUERY="SELECT * FROM Estudiantes";

    public static void main(String[] args) {
    try(
            Connection conn= DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(QUERY);

            ){
        while(rs.next()){
            System.out.println("ID: "+rs.getInt("ID"));
            System.out.println("Nombre: "+rs.getString("Nombre"));
            System.out.println("Edad: "+rs.getInt("edad"));
            System.out.println("Ciudad: "+rs.getString("ciudad"));
            System.out.println("Cedula: "+rs.getInt("cedula"));
        }
    }catch (SQLException e){
        throw new RuntimeException(e);
    }
    }
}
