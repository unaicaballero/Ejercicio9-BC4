import java.sql.*;

public class MediaSalario {
    public static void main(String[] args) {

        String url ="jdbc:oracle:thin:@localhost:1521:xe";
        String usuario = "RIBERA";
        String contraseña = "ribera";

        String sql = "SELECT TRUNC(AVG(SALARIO), 2) AS MEDIA " +
                    " FROM EJEMPLOCONEXION";

        try(Connection conn = DriverManager.getConnection(url, usuario, contraseña);
            Statement statement = conn.createStatement();) {

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                double media = rs.getDouble("MEDIA");
                System.out.println("Media: " + media);
            }

        }catch(SQLException e ){
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}