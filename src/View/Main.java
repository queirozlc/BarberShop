/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Agendamento;
import Model.Cliente;
import Model.Servico;
import Model.Usuario;

/**
 *
 * @author Lucas
 */
public class Main {
    public static void main(String[] args) {
        Servico servico = new Servico(0, "Barba e corte", 30);
        System.out.println(servico.getDescricao());
        System.out.println(servico.getValor());
        
        Cliente cliente = new Cliente(1, "Lucas", "Rua teste", "29140100");
        
        System.out.println(cliente.getNome());
        
        Usuario usuario = new Usuario(0, "Barbeiro", "senha");
        
        System.out.println(usuario.getNome());
        
        Agendamento agendamento = new Agendamento(1, cliente, servico, 0, "04/05/2022 15:45");
        
        System.out.println(agendamento.getData());
    }
    
}
