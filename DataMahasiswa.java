import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataMahasiswa extends JFrame {

    JTable tabel;
    DefaultTableModel model;

    public DataMahasiswa() {

        setTitle("Data Mahasiswa");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Kolom tabel termasuk IPK
        String[] kolom = {
            "NIM", "Nama", "Prodi", "IPK"
        };

        model = new DefaultTableModel(kolom, 0);

        // Contoh data mahasiswa
        model.addRow(new Object[]{
            "3012610001", "Rin", "Informatika", "3.80"
        });

        model.addRow(new Object[]{
            "3012610002", "Andri", "Manajemen", "3.65"
        });

        model.addRow(new Object[]{
            "3012610003", "Zahri", "Akuntansi", "3.50"
        });

        tabel = new JTable(model);

        JScrollPane scroll = new JScrollPane(tabel);

        JButton btnUbah = new JButton("Ubah Data Terpilih");

        btnUbah.addActionListener(e -> {

            int baris = tabel.getSelectedRow();

            if (baris == -1) {
                JOptionPane.showMessageDialog(
                    this, "Pilih data mahasiswa terlebih dahulu!"
                );
                return;
            }

            JTextField nim = new JTextField(
                model.getValueAt(baris, 0).toString()
            );

            JTextField nama = new JTextField(
                model.getValueAt(baris, 1).toString()
            );

            JTextField prodi = new JTextField(
                model.getValueAt(baris, 2).toString()
            );

            JTextField ipk = new JTextField(
                model.getValueAt(baris, 3).toString()
            );

            JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

            panel.add(new JLabel("NIM:"));
            panel.add(nim);

            panel.add(new JLabel("Nama:"));
            panel.add(nama);

            panel.add(new JLabel("Prodi:"));
            panel.add(prodi);

            panel.add(new JLabel("IPK:"));
            panel.add(ipk);

            int hasil = JOptionPane.showConfirmDialog(
                this,
                panel,
                "Ubah Data Mahasiswa",
                JOptionPane.OK_CANCEL_OPTION
            );

            if (hasil == JOptionPane.OK_OPTION) {

                try {
                    double nilaiIPK = Double.parseDouble(ipk.getText());

                    if (nilaiIPK < 0 || nilaiIPK > 4) {
                        throw new NumberFormatException();
                    }

                    model.setValueAt(nim.getText(), baris, 0);
                    model.setValueAt(nama.getText(), baris, 1);
                    model.setValueAt(prodi.getText(), baris, 2);
                    model.setValueAt(nilaiIPK, baris, 3);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        this, "IPK harus berupa angka antara 0 sampai 4!"
                    );
                }
            }
        });

        add(scroll, BorderLayout.CENTER);
        add(btnUbah, BorderLayout.SOUTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        new DataMahasiswa();
    }
}