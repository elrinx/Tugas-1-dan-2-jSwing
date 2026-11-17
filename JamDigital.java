import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JamDigital extends JFrame {

    public JamDigital() {

        super("Jam Digital");

        JLabel jam = new JLabel();

        jam.setFont(new Font("Arial", Font.BOLD, 35));
        jam.setHorizontalAlignment(JLabel.CENTER);

        add(jam);

        SimpleDateFormat format =
            new SimpleDateFormat("HH:mm:ss");

        Timer timer = new Timer(1000, e -> {
            jam.setText(format.format(new Date()));
        });

        timer.start();

        setSize(350, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JamDigital();
    }
}