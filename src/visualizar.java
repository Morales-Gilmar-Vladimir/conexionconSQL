import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class visualizar {
    private JButton QUERYButton;
    private JLabel imprimir;
    private JPanel rootPanel;

    public visualizar() {
        QUERYButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String DB_URL = "jdbc:mysql://localhost/Almacenamiento";
                String USER = "root";
                String PASS = "root_bas3";
                String QUERY = "SELECT * FROM Estudiantes";

                try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                     Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery(QUERY)) {

                    StringBuilder output = new StringBuilder();

                    while (rs.next()) {
                        output.append("ID: ").append(rs.getInt("ID")).append("<br>");
                        output.append("Nombre: ").append(rs.getString("Nombre")).append("<br>");
                        output.append("Edad: ").append(rs.getInt("edad")).append("<br>");
                        output.append("Ciudad: ").append(rs.getString("ciudad")).append("<br>");
                        output.append("Cedula: ").append(rs.getInt("cedula")).append("<br>");
                        output.append("<br>");
                    }

                    imprimir.setText("<html>" + output.toString() + "</html>");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("visualizar");
        frame.setContentPane(new visualizar().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}