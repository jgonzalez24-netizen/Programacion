package controllers;

import views.AuthView;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class AuthController {

    AuthView view;

    public AuthController(AuthView view){
        this.view = view;
    }

    public void login(){

        String user = view.usuario.getText();
        String pass = new String(view.password.getPassword());

        boolean valido = true;

        if(user.trim().isEmpty() || user.contains(" ")){
            view.usuario.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            valido=false;
        }else{
            view.usuario.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        }

        if(pass.length()<6 || pass.contains(" ")){
            view.password.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            valido=false;
        }else{
            view.password.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        }

        if(valido){
            JOptionPane.showMessageDialog(null,"Bienvenido");
        }else{
            JOptionPane.showMessageDialog(null,"Verifica los datos");
        }
    }

    public void registro(){

        boolean valido = true;

        if(view.txtNombreReg.getText().trim().isEmpty() || view.txtNombreReg.getText().contains(" ")){
            view.txtNombreReg.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            valido=false;
        }else{
            view.txtNombreReg.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        }

        String bio=view.bio_text.getText().trim();

        if(!bio.isEmpty() && bio.length()<5){
            view.bio_text.setBorder(BorderFactory.createLineBorder(Color.RED,2));
            valido=false;
        }else{
            view.bio_text.setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
        }

        if(!view.opt_sweet.isSelected() && !view.opt_salty.isSelected() && !view.opt_healthy.isSelected()){
            valido=false;
        }

        if(!view.accept_terms.isSelected()){
            valido=false;
        }

        if(valido){
            JOptionPane.showMessageDialog(null,"Registro exitoso");
        }
    }
}