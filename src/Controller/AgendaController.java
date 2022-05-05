/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Controller.Helpers.AgendaHelper;
import Model.Agendamento;
import Model.Cliente;
import Model.DAO.AgendamentoDAO;
import static Model.DAO.Banco.servico;
import Model.DAO.ClienteDAO;
import Model.DAO.ServicoDAO;
import Model.Servico;
import View.Agenda;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class AgendaController {
    
    private final Agenda view;
    private final AgendaHelper helper;

    public AgendaController(Agenda view) {
        this.view = view;
        this.helper = new AgendaHelper(view);
    }
    
    
    public void atualizaTabela(){
        
        // Buscar lista de agendamentos no banco de dados
        AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
        ArrayList<Agendamento> agendamentos = agendamentoDAO.selectAll();
        
        //Exibe lista na view
        helper.preencherTabela(agendamentos);
    }
    
    public void atualizaCliente(){
        // Buscar clientes do banco de dados 
        ClienteDAO clienteDAO = new ClienteDAO();
        ArrayList<Cliente> clientes = clienteDAO.selectAll();
        
        // Exibir clientes no Combobox cliente
        helper.preencherClientes(clientes);
    }
    
    public void atualizaServico(){
        // Buscar servico no banco de dados
        ServicoDAO servicoDAO = new ServicoDAO();
        ArrayList<Servico> servicos = servicoDAO.selectAll();
        
        // Exibir servico no ComboBox
        helper.preencherServico(servicos);
    }
    
    public void atualizaValor(){
        
        Servico servico = helper.obterServico();
        
        helper.setarValor(servico.getValor());
    }
    
    public void agendar(){
        // Buscar objeto agendamento da tela
        Agendamento agendamento = helper.obterModelo();
        
        // Salvar objeto no banco de dados
        new AgendamentoDAO().insert(agendamento);
        
        // Atualizar tabela
        atualizaTabela();
        
        //limpa a tela
        helper.limparTela();
    }
}
