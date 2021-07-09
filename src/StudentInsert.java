import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class StudentInsert extends JFrame {
    private JPanel mainPanel;
    private JLabel stdid_label;
    private JLabel stdname_label;
    private JLabel stddept_label;
    private JLabel stdbtc_label;
    private JTextField std_id;
    private JTextField std_name;
    private JTextField std_dept;
    private JTextField std_btc;
    private JButton ok;
    private JLabel response;
    private JLabel info;

    public StudentInsert(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBC dbApp = new JDBC();
                try {
                    dbApp.insertStudent(
                            Integer.parseInt(std_id.getText()),
                            std_name.getText(),
                            std_dept.getText(),
                            Integer.parseInt(std_btc.getText())
                    );
                } catch (SQLException troubles) {
                    troubles.printStackTrace();
                }
                response.setText("1 Student Info has been recorded ::: ");
                info.setText("ID: "+std_id.getText()+", name: "+std_name.getText()+", Dept.: "+std_dept.getText()+", Batch: "+std_btc.getText());
                std_id.setText("");
                std_name.setText("");
                std_dept.setText("");
                std_btc.setText("");
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new StudentInsert("Student Info");
        frame.setVisible(true);
        frame.setSize(700,350);
    }
}
