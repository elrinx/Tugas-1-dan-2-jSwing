import javax.swing.*;
import java.awt.*;

public class FormLogin extends JFrame {

    public FormLogin() {

        super("Form Login");

        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblUsername = new JLabel("Username");
        JLabel lblPassword = new JLabel("Password");

        JTextField txtUsername = new JTextField(15);
        JPasswordField txtPassword = new JPasswordField(15);

        JButton btnMasuk = new JButton("Masuk");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsername, gbc);

        gbc.gridx = 1;
        add(txtUsername, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblPassword, gbc);

        gbc.gridx = 1;
        add(txtPassword, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(btnMasuk, gbc);

        btnMasuk.addActionListener(e -> {

            if (txtUsername.getText().isEmpty()
                || txtPassword.getPassword().length == 0) {

                JOptionPane.showMessageDialog(
                    this, "Username dan Password tidak boleh kosong!"
                );

            } else {

                JOptionPane.showMessageDialog(
                    this, "Login berhasil!"
                );
            }
        });

        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormLogin();
    }
}