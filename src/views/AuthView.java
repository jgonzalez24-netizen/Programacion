package views;

import javax.swing.*;
import java.awt.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import controllers.AuthController;

public class AuthView extends JFrame {

    public JTextField usuario;
    public JPasswordField password;

    public JTextField txtNombreReg;
    public JTextArea bio_text;
    public JCheckBox opt_sweet;
    public JCheckBox opt_salty;
    public JCheckBox opt_healthy;
    public JRadioButton accept_terms;
    public JRadioButton reject_terms;
    public JButton register_btn;
    public JButton ingresar;

    AuthController controller;

    public AuthView() {

        controller = new AuthController(this);

        setTitle("Sistema");
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        try {
            Image iconImage = ImageIO.read(getClass().getResource("/imagen/gato.png"));
            setIconImage(iconImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        router("login");

        setVisible(true);
    }

    public void router(String target) {

        getContentPane().removeAll();

        if (target.equals("login")) login();
        if (target.equals("registrarse")) registro();

        repaint();
        revalidate();
    }

    public void login() {

        JPanel panelLogin = new JPanel();
        panelLogin.setBounds(0,0,400,450);
        panelLogin.setLayout(null);
        add(panelLogin);

        ImageIcon fondo = new ImageIcon(getClass().getResource("/imagen/fondo.jpg"));
        JLabel fondoLabel = new JLabel(fondo);
        fondoLabel.setBounds(0,0,400,450);
        panelLogin.add(fondoLabel);

        JLabel titulo = new JLabel("Login");
        titulo.setBounds(150,40,200,40);
        titulo.setFont(new Font("Arial",Font.BOLD,28));
        titulo.setForeground(Color.WHITE);
        fondoLabel.add(titulo);

        JLabel lblUser = new JLabel("Usuario:");
        lblUser.setBounds(100,100,200,20);
        lblUser.setForeground(Color.WHITE);
        fondoLabel.add(lblUser);

        usuario = new JTextField();
        usuario.setBounds(100,130,200,32);
        fondoLabel.add(usuario);

        JLabel lblPass = new JLabel("Contraseña:");
        lblPass.setBounds(100,160,200,20);
        lblPass.setForeground(Color.WHITE);
        fondoLabel.add(lblPass);

        password = new JPasswordField();
        password.setBounds(100,180,200,32);
        fondoLabel.add(password);

        ingresar = new JButton("Acceder");
        ingresar.setBounds(140,240,120,35);
        fondoLabel.add(ingresar);

        JButton registrarse = new JButton("Registrarse");
        registrarse.setBounds(140,290,120,35);
        fondoLabel.add(registrarse);

        JButton recuperar = new JButton("Recuperar");
        recuperar.setBounds(140,340,120,35);
        fondoLabel.add(recuperar);

        registrarse.addActionListener(e -> router("registrarse"));

        ingresar.addActionListener(e -> controller.login());
    }

    public void registro() {

        JPanel panelRegistro = new JPanel();
        panelRegistro.setBounds(0,0,400,450);
        panelRegistro.setBackground(new Color(25,42,86));
        panelRegistro.setLayout(null);
        add(panelRegistro);

        JPanel rgs_container = new JPanel();
        rgs_container.setBounds(0,0,400,450);
        rgs_container.setBackground(new Color(25,42,86));
        rgs_container.setLayout(null);
        panelRegistro.add(rgs_container);

        JLabel tituloRegistro = new JLabel("REGISTRO");
        tituloRegistro.setBounds(90,15,220,45);
        tituloRegistro.setHorizontalAlignment(SwingConstants.CENTER);
        tituloRegistro.setOpaque(true);
        tituloRegistro.setBackground(new Color(30,30,30));
        tituloRegistro.setForeground(Color.WHITE);
        tituloRegistro.setFont(new Font("Arial",Font.BOLD,24));
        rgs_container.add(tituloRegistro);

        JLabel lblNombreReg = new JLabel("NOMBRE DE USUARIO:");
        lblNombreReg.setBounds(50,75,300,28);
        lblNombreReg.setOpaque(true);
        lblNombreReg.setBackground(new Color(255,200,0));
        lblNombreReg.setHorizontalAlignment(SwingConstants.CENTER);
        lblNombreReg.setFont(new Font("Arial",Font.BOLD,13));
        rgs_container.add(lblNombreReg);

        txtNombreReg = new JTextField();
        txtNombreReg.setBounds(50,108,300,28);
        rgs_container.add(txtNombreReg);

        bio_text = new JTextArea();
        bio_text.setBounds(50,175,300,65);
        rgs_container.add(bio_text);

        opt_sweet = new JCheckBox("Dulces");
        opt_sweet.setBounds(50,280,90,25);
        rgs_container.add(opt_sweet);

        opt_salty = new JCheckBox("Salado");
        opt_salty.setBounds(155,280,90,25);
        rgs_container.add(opt_salty);

        opt_healthy = new JCheckBox("Saludable");
        opt_healthy.setBounds(260,280,100,25);
        rgs_container.add(opt_healthy);

        accept_terms = new JRadioButton("Acepto los términos");
        accept_terms.setBounds(50,340,160,25);
        rgs_container.add(accept_terms);

        reject_terms = new JRadioButton("No acepto los términos");
        reject_terms.setBounds(210,340,180,25);
        rgs_container.add(reject_terms);

        ButtonGroup terms = new ButtonGroup();
        terms.add(accept_terms);
        terms.add(reject_terms);

        register_btn = new JButton("Crear cuenta");
        register_btn.setBounds(50,380,300,35);
        rgs_container.add(register_btn);

        JButton volver = new JButton("Volver");
        volver.setBounds(50,420,300,30);
        rgs_container.add(volver);

        volver.addActionListener(e -> router("login"));

        register_btn.addActionListener(e -> controller.registro());
    }
}