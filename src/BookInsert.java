import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BookInsert extends JFrame {
    private JPanel mainPanel;
    private JLabel bookid_label;
    private JLabel bookname_label;
    private JLabel author_label;
    private JLabel price_label;
    private JTextField bookid;
    private JTextField bookname;
    private JTextField author;
    private JTextField price;
    private JButton ok;
    private JLabel response;
    private JLabel info;

    public BookInsert(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDBC2 dbApp = new JDBC2();
                try {
                    dbApp.insertBook(
                            Integer.parseInt(bookid.getText()),
                            bookname.getText(),
                            author.getText(),
                            Integer.parseInt(price.getText())
                    );
                } catch (SQLException troubles) {
                    troubles.printStackTrace();
                }
                response.setText("1 Book Info has been recorded ::: ");
                info.setText("ID: "+ bookid.getText()+", name: "+ bookname.getText()+", author: "+ author.getText()+", price: "+ price.getText());
                bookid.setText("");
                bookname.setText("");
                author.setText("");
                price.setText("");
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new BookInsert("Book Info");
        frame.setVisible(true);
        frame.setSize(700,350);
    }
}
