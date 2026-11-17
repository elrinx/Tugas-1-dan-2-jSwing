import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class EditorTeks extends JFrame {

    JTextArea areaTeks;
    JFileChooser chooser = new JFileChooser();

    public EditorTeks() {

        setTitle("Editor Teks");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaTeks = new JTextArea();

        JScrollPane scroll = new JScrollPane(areaTeks);
        add(scroll, BorderLayout.CENTER);

        // Menu bar
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenu menuEdit = new JMenu("Edit");

        JMenuItem baru = new JMenuItem("Baru");
        JMenuItem buka = new JMenuItem("Buka");
        JMenuItem simpan = new JMenuItem("Simpan");
        JMenuItem keluar = new JMenuItem("Keluar");

        JMenuItem potong = new JMenuItem("Potong");
        JMenuItem salin = new JMenuItem("Salin");
        JMenuItem tempel = new JMenuItem("Tempel");

        menuFile.add(baru);
        menuFile.add(buka);
        menuFile.add(simpan);
        menuFile.addSeparator();
        menuFile.add(keluar);

        menuEdit.add(potong);
        menuEdit.add(salin);
        menuEdit.add(tempel);

        menuBar.add(menuFile);
        menuBar.add(menuEdit);

        setJMenuBar(menuBar);

        // Aksi menu File
        baru.addActionListener(e -> areaTeks.setText(""));

        buka.addActionListener(e -> bukaFile());

        simpan.addActionListener(e -> simpanFile());

        keluar.addActionListener(e -> System.exit(0));

        // Aksi menu Edit
        potong.addActionListener(e -> areaTeks.cut());
        salin.addActionListener(e -> areaTeks.copy());
        tempel.addActionListener(e -> areaTeks.paste());

        // Toolbar
        JToolBar toolbar = new JToolBar();

        JButton btnBaru = new JButton("Baru");
        JButton btnBuka = new JButton("Buka");
        JButton btnSimpan = new JButton("Simpan");

        toolbar.add(btnBaru);
        toolbar.add(btnBuka);
        toolbar.add(btnSimpan);

        add(toolbar, BorderLayout.NORTH);

        btnBaru.addActionListener(e -> areaTeks.setText(""));
        btnBuka.addActionListener(e -> bukaFile());
        btnSimpan.addActionListener(e -> simpanFile());

        setVisible(true);
    }

    void bukaFile() {
        int hasil = chooser.showOpenDialog(this);

        if (hasil == JFileChooser.APPROVE_OPTION) {
            try {
                FileReader reader =
                    new FileReader(chooser.getSelectedFile());

                areaTeks.read(reader, null);
                reader.close();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                    this, "Gagal membuka file!"
                );
            }
        }
    }

    void simpanFile() {
        int hasil = chooser.showSaveDialog(this);

        if (hasil == JFileChooser.APPROVE_OPTION) {
            try {
                FileWriter writer =
                    new FileWriter(chooser.getSelectedFile());

                areaTeks.write(writer);
                writer.close();

                JOptionPane.showMessageDialog(
                    this, "File berhasil disimpan!"
                );

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(
                    this, "Gagal menyimpan file!"
                );
            }
        }
    }

    public static void main(String[] args) {
        new EditorTeks();
    }
}