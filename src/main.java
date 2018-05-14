
import java.sql.*;

public class main {

    public static  void cargaDatos() {
        try {
            //1-  Cargar el driver
           Class.forName("com.mysql.jdbc.Driver");
           
           // 2- Establecer la conexion con la BD
           Connection conexion=
                   DriverManager.getConnection("jdbc:mysql://localhost/mediamark","alumno","alumno");
           // 3- Crear el Statement
           Statement s= conexion.createStatement();
           
           // 4- Trabajo con las consultas
           
           ResultSet rs=s.executeQuery("SELECT * FROM productos");
           while(rs.next()){
               System.out.println(rs.getInt("Id")+" "
                       +rs.getString("Nombre")+ " "
                       +rs.getFloat("Precio"));
           }
           
          // 5- Cerrar conexion 
          
          rs.close();
          s.close();
          conexion.close();
           
        } catch (Exception ex) {
            System.out.println("Error al acceder a la base de datos");
           //Muestra la informacion del error
            ex.printStackTrace();
        }
    
        
    }
    
    public static void main(String[] args) {
      
      cargaDatos();
        
        
    }
    
}
