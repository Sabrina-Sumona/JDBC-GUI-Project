import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StudentDelete extends JFrame {
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton searchButton;
    private JLabel label1;
    private JTextArea textArea1;

    public StudentDelete(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBC dbApp = new JDBC();
                try {
                    String res = dbApp.deleteStudent(
                            Integer.parseInt(textField1.getText())
                    );
                    textArea1.setText(res);
                    textField1.setText("");
                } catch (SQLException troubles) {
                    troubles.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new StudentDelete("Student Delete");
        frame.setVisible(true);
        frame.setSize(400,350);
    }
}

