package vista;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

public class FrmPrincipal extends JFrame {
    private int i = 0;

    public FrmPrincipal() {
        initComponents();
    }

    private void initComponents() {
        System.out.println("Hola");
        JPanel panel = new JPanel();
        JLabel lblTitulo = new JLabel("AHORCADITO");
        JLabel lblImagen = new JLabel();
        JLabel lblDisplay = new JLabel("_ _ _ _ _");
        JLabel lblLetra = new JLabel("Letra");
        JTextField txtLetra = new JTextField();
        txtLetra.setPreferredSize(new Dimension(50, 30));
        txtLetra.setMaximumSize(new Dimension(50, 30));
        JButton btnNuevo = new JButton("Nuevo");

        JButton btnVerificar = new JButton("Verificar");
        JButton btnSalir = new JButton("Salir");
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/ahorcadito7.png"));
        lblImagen.setIcon(icono);
        lblTitulo.setFont(new Font("Segoe UI", 1, 36));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);
        lblImagen.setHorizontalAlignment(JLabel.CENTER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 255, 255));
        panel.setPreferredSize(new Dimension(400, 600));

        panel.add(lblTitulo, BorderLayout.NORTH);
        panel.add(lblImagen, BorderLayout.CENTER);

        panel.add(btnSalir, BorderLayout.SOUTH);

        this.setTitle("Juego Ahorcadito");

        this.add(panel);
        this.setSize(400, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        JPanel panel2 = new JPanel();

        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBackground(new Color(255, 255, 255));
        panel2.setPreferredSize(new Dimension(400, 200));

        btnNuevo.setAlignmentX(Component.CENTER_ALIGNMENT);
        // lblDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);
        // lblDisplay.setHorizontalAlignment(JLabel.CENTER);
        // lblLetra.setHorizontalAlignment(JLabel.CENTER);
        // txtLetra.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel2.add(btnNuevo);
        panel2.add(lblDisplay);
        panel2.add(lblLetra);
        panel2.add(txtLetra);
        panel2.add(btnVerificar);

        panel.add(panel2, BorderLayout.SOUTH);

        // JPanel panel3= new JPanel();
        // panel3.setPreferredSize(new Dimension(80,50));
        // panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));

        // panel.add(panel3,BorderLayout.EAST);

        btnNuevo.addActionListener(e -> {
            i++;
            String archivo = "ahorcadito" + i + ".png";
            System.out.println(getClass().getResource("/imagenes/ahorcadito7.png"));
            ImageIcon icono2 = new ImageIcon(getClass().getResource("../imagenes/ahorcadito7.png"));
            lblImagen.setIcon(icono2);
            pack();
            System.out.println("Botón presionado");
        });
    }
}
