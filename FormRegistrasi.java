import javax.swing.*;
import java.awt.*;

public class FormRegistrasi extends JFrame {

    JTextField txtNama, txtEmail;
    JPasswordField txtSandi;
    JRadioButton rbLaki, rbPerempuan;
    JComboBox<String> cbProdi;
    JCheckBox cbMusik, cbOlahraga, cbGame;

    public FormRegistrasi() {

        setTitle("Form Registrasi Mahasiswa");
        setSize(450, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Judul
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(new JLabel("FORM REGISTRASI"), gbc);

        gbc.gridwidth = 1;

        // Nama
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nama"), gbc);

        gbc.gridx = 1;
        txtNama = new JTextField(20);
        add(txtNama, gbc);

        // Email
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email"), gbc);

        gbc.gridx = 1;
        txtEmail = new JTextField(20);
        add(txtEmail, gbc);

        // Sandi
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Sandi"), gbc);

        gbc.gridx = 1;
        txtSandi = new JPasswordField(20);
        add(txtSandi, gbc);

        // Gender
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(new JLabel("Gender"), gbc);

        gbc.gridx = 1;

        rbLaki = new JRadioButton("Laki-laki");
        rbPerempuan = new JRadioButton("Perempuan");

        ButtonGroup gender = new ButtonGroup();
        gender.add(rbLaki);
        gender.add(rbPerempuan);

        JPanel panelGender = new JPanel();
        panelGender.add(rbLaki);
        panelGender.add(rbPerempuan);

        add(panelGender, gbc);

        // Prodi
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(new JLabel("Program Studi"), gbc);

        gbc.gridx = 1;

        String[] prodi = {
            "Informatika",
            "Manajemen",
            "Akuntansi",
            "Sistem Informasi"
        };

        cbProdi = new JComboBox<>(prodi);
        add(cbProdi, gbc);

        // Hobi
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(new JLabel("Hobi"), gbc);

        gbc.gridx = 1;

        cbMusik = new JCheckBox("Musik");
        cbOlahraga = new JCheckBox("Olahraga");
        cbGame = new JCheckBox("Game");

        JPanel panelHobi = new JPanel();
        panelHobi.add(cbMusik);
        panelHobi.add(cbOlahraga);
        panelHobi.add(cbGame);

        add(panelHobi, gbc);

        // Tombol daftar
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        JButton btnDaftar = new JButton("Daftar");
        add(btnDaftar, gbc);

        btnDaftar.addActionListener(e -> {

            String genderDipilih = "";

            if (rbLaki.isSelected()) {
                genderDipilih = "Laki-laki";
            } else if (rbPerempuan.isSelected()) {
                genderDipilih = "Perempuan";
            }

            String hobi = "";

            if (cbMusik.isSelected()) hobi += "Musik ";
            if (cbOlahraga.isSelected()) hobi += "Olahraga ";
            if (cbGame.isSelected()) hobi += "Game ";

            if (txtNama.getText().isEmpty()
                || txtEmail.getText().isEmpty()
                || txtSandi.getPassword().length == 0
                || genderDipilih.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this, "Mohon lengkapi data!"
                );

                return;
            }

            String hasil =
                "Nama: " + txtNama.getText() +
                "\nEmail: " + txtEmail.getText() +
                "\nGender: " + genderDipilih +
                "\nProdi: " + cbProdi.getSelectedItem() +
                "\nHobi: " + hobi;

            JOptionPane.showMessageDialog(
                this, hasil, "Data Registrasi",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new FormRegistrasi();
    }
}