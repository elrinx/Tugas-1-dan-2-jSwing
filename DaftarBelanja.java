import javax.swing.*;
import java.awt.*;

public class DaftarBelanja extends JFrame {

    public DaftarBelanja() {

        super("Daftar Belanja");

        JTextField txtBelanja = new JTextField(15);

        JButton btnTambah = new JButton("Tambah");
        JButton btnHapus = new JButton("Hapus Terpilih");

        DefaultListModel<String> model =
            new DefaultListModel<>();

        JList<String> daftar = new JList<>(model);

        JScrollPane scroll = new JScrollPane(daftar);

        setLayout(new BorderLayout(10, 10));

        JPanel panelAtas = new JPanel();

        panelAtas.add(txtBelanja);
        panelAtas.add(btnTambah);

        JPanel panelBawah = new JPanel();
        panelBawah.add(btnHapus);

        add(panelAtas, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBawah, BorderLayout.SOUTH);

        btnTambah.addActionListener(e -> {

            String barang = txtBelanja.getText();

            if (!barang.isEmpty()) {
                model.addElement(barang);
                txtBelanja.setText("");
            } else {
                JOptionPane.showMessageDialog(
                    this, "Masukkan nama barang!"
                );
            }
        });

        btnHapus.addActionListener(e -> {

            int index = daftar.getSelectedIndex();

            if (index != -1) {
                model.remove(index);
            } else {
                JOptionPane.showMessageDialog(
                    this, "Pilih barang yang ingin dihapus!"
                );
            }
        });

        setSize(450, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DaftarBelanja();
    }
}