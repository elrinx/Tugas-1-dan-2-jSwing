import javax.swing.*;
import java.awt.*;

public class MenuDemo extends JFrame {

    public MenuDemo() {

        super("Aplikasi Menu");

        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenu menuBantuan = new JMenu("Bantuan");

        JMenuItem keluar = new JMenuItem("Keluar");
        JMenuItem tentang = new JMenuItem("Tentang");

        menuFile.add(keluar);
        menuBantuan.add(tentang);

        menuBar.add(menuFile);
        menuBar.add(menuBantuan);

        setJMenuBar(menuBar);

        JLabel label = new JLabel(
            "Selamat Datang di Aplikasi Java Swing"
        );

        label.setHorizontalAlignment(JLabel.CENTER);

        add(label);

        keluar.addActionListener(e -> {
            System.exit(0);
        });

        tentang.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                this,
                "Aplikasi Java Swing\nDibuat untuk Tugas 2"
            );
        });

        setSize(450, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MenuDemo();
    }
}