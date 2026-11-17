import javax.swing.*;
import java.awt.*;

public class LayoutDemo extends JFrame {

    public LayoutDemo() {

        super("Contoh Layout");

        JButton btn1 = new JButton("Tombol 1");
        JButton btn2 = new JButton("Tombol 2");
        JButton btn3 = new JButton("Tombol 3");
        JButton btnUbah = new JButton("Ubah Layout");

        setLayout(new FlowLayout());

        add(btn1);
        add(btn2);
        add(btn3);
        add(btnUbah);

        btnUbah.addActionListener(e -> {
            setLayout(new GridLayout(1, 3));

            remove(btnUbah);

            revalidate();
            repaint();
        });

        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new LayoutDemo();
    }
}