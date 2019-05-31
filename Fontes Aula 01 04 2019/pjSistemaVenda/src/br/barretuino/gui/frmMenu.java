package br.barretuino.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class frmMenu extends JFrame implements ActionListener {
	//1º Passo Declarando Objetos Visuais
	JMenuBar menuBar;
	JMenu menuCadastro, menuPesquisa;
	JMenuItem mnItemPessoa;
	
	public frmMenu(){
		 	setTitle("Menu Example");
	        setSize(800, 600);
	         
	        // Cria uma barra de menu para o JFrame
	        menuBar = new JMenuBar();
	         
	        // Adiciona a barra de menu ao  frame
	        setJMenuBar(menuBar);
	        
	        menuCadastro = new JMenu("Cadastro");
	        menuCadastro.setMnemonic('C');
	        
	        menuPesquisa = new JMenu("Pesquisa");
	        menuPesquisa.setMnemonic('P');
	        
	        mnItemPessoa = new JMenuItem("Pessoa");
	        mnItemPessoa.addActionListener(this);
	        
	        menuCadastro.add(mnItemPessoa);
	        
	        
	        menuBar.add(menuCadastro);
	        menuBar.add(menuPesquisa);
	         
	       setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == mnItemPessoa) {
			frmPessoa form = new frmPessoa();		
			form.show();
		}
	}
	
	public static void main(String[] args) {
		frmMenu aplicacao = new frmMenu();
		aplicacao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}