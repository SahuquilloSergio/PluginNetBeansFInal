package com.samuel.git;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category="File",
        id="com.samuel.git.Main"
)
@ActionRegistration(
        iconBase="com/samuel/git/github.png",
        displayName="#CTL_CrearRepositorio"
)
@ActionReference(path="Menu/Versioning", position=0)
@Messages("CTL_CrearRepositorio=Crear Repositorio GitHub")

public final class Main implements ActionListener{
    /**
     * Se crea un repositorio con el nombre indicado el un JOptionPane.
     * Recibe el usuario y contraseña de los JOptionPane
     * @param e 
     */
    @Override public void actionPerformed(ActionEvent e){
        
        String nombre = JOptionPane.showInputDialog("Nombre del Repositorio:");
        GHCreateRepositoryBuilder builder;
        
        try{
            GitHub github = GitHub.connectUsingPassword(JOptionPane.showInputDialog("Usuario"), JOptionPane.showInputDialog("Contraseña: "));
            
            builder=github.createRepository(nombre);
            builder.create();
        }catch(IOException ex){}
    }
}
