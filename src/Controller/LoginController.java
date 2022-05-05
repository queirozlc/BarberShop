/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helpers.LoginHelper;
import Model.DAO.UsuarioDAO;
import Model.Usuario;
import View.Login;
import View.MenuPrincipal;

/**
 *
 * @author Lucas
 */
public class LoginController {

    private final Login view;
    private final LoginHelper helper;

    public LoginController(Login view) {
        this.view = view;
        this.helper = new LoginHelper(view);
    }
    
    public void entrarNoSistema(){
        // Pegar usuario da view
        Usuario usuario = helper.obterModelo();
        
        // Pesquisar usuario no banco de dados
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioAutenticado = usuarioDAO.selectPorNomeESenha(usuario);
        
        // Se o usuario da view tiver o mesmo username e senha que o usuario vindo do banco, direcionar para menu
        if(usuarioAutenticado != null){
            MenuPrincipal menu = new MenuPrincipal();
            menu.setVisible(true);
            this.view.dispose();
            
        }else{
            // Senao, mostrar uma mensagem de "usuario ou senha invalidos"
            view.exibeMensagem("Usuario ou senha invalidos.");
        }
        
        
        
    }

    
}
