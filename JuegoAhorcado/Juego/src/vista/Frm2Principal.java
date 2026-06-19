package vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import modelo.JuegoAhorcado;

public class Frm2Principal extends JFrame {
    // private int i=0;
    JuegoAhorcado juego;

    public Frm2Principal() {
        initComponents();
    }

    private void initComponents() {
        JLabel lblTitulo = new JLabel("AHORCADITO");
        JLabel lblImagen = new JLabel();
        JLabel lblDisplay = new JLabel("_ _ _ _ _");
        JLabel lblLetra = new JLabel("Letra");
        JTextField txtLetra = new JTextField();
        JButton btnNuevo = new JButton("Nuevo");
        JButton btnVerificar = new JButton("Verificar");
        JButton btnSalir = new JButton("Salir");

        // Imagen
        ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/ahorcadito7.png"));
        lblImagen.setIcon(icono);

        // Título
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblTitulo.setHorizontalAlignment(JLabel.CENTER);

        // Display de la palabra
        lblDisplay.setFont(new Font("Segoe UI", Font.BOLD, 48));
        lblDisplay.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Etiqueta letra
        lblLetra.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Campo de captura
        txtLetra.setMaximumSize(new Dimension(80, 35));
        txtLetra.setPreferredSize(new Dimension(80, 35));
        txtLetra.setHorizontalAlignment(JTextField.CENTER);
        txtLetra.setFont(new Font("Segoe UI", Font.BOLD, 20));
        txtLetra.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Centrar imagen
        lblImagen.setHorizontalAlignment(JLabel.CENTER);

        // Panel principal
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.WHITE);

        // Panel de controles
        JPanel panelControles = new JPanel();
        panelControles.setLayout(new BoxLayout(panelControles, BoxLayout.Y_AXIS));
        panelControles.setBackground(Color.WHITE);
        panelControles.setBorder(new EmptyBorder(10, 10, 20, 10));

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(Color.WHITE);
        panelBotones.add(btnNuevo);
        panelBotones.add(btnVerificar);
        panelBotones.add(btnSalir);

        // Panel de controles
        panelControles.add(lblDisplay);
        panelControles.add(Box.createVerticalStrut(15));
        lblLetra.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelControles.add(lblLetra);
        panelControles.add(Box.createVerticalStrut(10));
        panelControles.add(txtLetra);
        panelControles.add(Box.createVerticalStrut(15));
        panelControles.add(panelBotones);

        // Agregar al panel principal
        panelPrincipal.add(lblTitulo, BorderLayout.NORTH);
        panelPrincipal.add(lblImagen, BorderLayout.CENTER);
        panelPrincipal.add(panelControles, BorderLayout.SOUTH);

        // Configuración de la ventana
        setTitle("Juego Ahorcadito");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        add(panelPrincipal);
        setSize(450, 650);
        setLocationRelativeTo(null);

        // Eventos
        /*
         * btnNuevo.addActionListener(e -> {
         * i++;
         * if (i > 7) {
         * i = 1;
         * }
         * String archivo = "/imagenes/ahorcadito" + i + ".png";
         * var url = getClass().getResource(archivo);
         * if (url != null) {
         * lblImagen.setIcon(new ImageIcon(url));
         * } else {
         * System.out.println("No se encontró: " + archivo);
         * }
         * });
         * btnSalir.addActionListener(e -> System.exit(0));
         */
        btnNuevo.addActionListener(e -> {
            juego = new JuegoAhorcado();
            juego.seleccionarPalabra();
            juego.generarDisplay();
            lblDisplay.setText(juego.getDisplay());
            var url = getClass().getResource("/imagenes/ahorcadito1.png");
            if (url != null) {
                lblImagen.setIcon(new ImageIcon(url));
            } else {
                System.err.println("No se encontró el archivo");
            }
        });

        btnVerificar.addActionListener(e -> {
            char letra;
            letra = txtLetra.getText().toUpperCase().charAt(0);
            juego.setLetra(letra);
            if (juego.validar()) {
                juego.generarDisplay();
                lblDisplay.setText(juego.getDisplay());
                if (juego.yaGano()) {
                    JOptionPane.showMessageDialog(this, "Excelente, te has salvado!!");
                }
            } else {
                var url = getClass().getResource("/imagenes/ahorcadito" + juego.getErrores() + ".png");
                if (url != null) {
                    lblImagen.setIcon(new ImageIcon(url));
                } else {
                    System.err.println("No se encontró el archivo");
                }
                if (juego.yaPerdio()) {
                    JOptionPane.showMessageDialog(this, "Losser, estas ahorcado!!" +
                            "\nLa palabra es " + juego.getPalabra());
                }
            }
        });

        btnSalir.addActionListener(e -> {
            System.exit(0);
        });
        setVisible(true);
    }
}