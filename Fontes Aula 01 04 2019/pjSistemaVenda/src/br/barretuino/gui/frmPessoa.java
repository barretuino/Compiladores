package br.barretuino.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.barretuino.modelagem.Endereco;
import br.barretuino.modelagem.Estado;
import br.barretuino.modelagem.Pessoa;
import br.barretuino.modelagem.SituacaoCadastral;
import br.barretuino.persistencia.Repositorio;
import br.barretuino.utils.Utils;

public class frmPessoa extends JInternalFrame implements ActionListener {

	//Atributos
	//1º Passo Declaração dos Objetos
	JLabel lbCodigo, lbNome, lbEmail, lbEndLogradouro, lbEndNumero, lbEndBairro, lbEndCidade, lbEndCep, lbEndCaixaPostal, lbEndEstado, lbEndPais, lbSituacao, lbPeso;
	JTextField txtCodigo, txtNome, txtEmail, txtEndLogradouro, txtEndNumero, txtEndBairro, txtEndCidade, txtEndCep, txtEndCaixaPostal, txtEndPais, txtPeso;
	JComboBox<SituacaoCadastral> cbxSituacao;
	JComboBox<Estado> cbxEndEstado;
	JButton btCadastrar, btPesquisar, btExcluir, btSair;
	JPanel pnCampos, pnEndereco, pnBotoes;
	GridLayout gridCampos, gridEndereco, gridBotoes;
	Pessoa pessoa;
	List<Pessoa> listPessoa = new ArrayList<Pessoa>();
	
	private static final String url = "./arquivos/saida.txt";
	
	public frmPessoa() throws HeadlessException {
		//2º Passo Instanciar os objetos visuais
		super("Cadastro de Pessoa");
		setSize(400,480);
		setLayout(new BorderLayout());
		
		lbCodigo = new JLabel("Código");
		lbNome = new JLabel("Nome");	
		lbEmail = new JLabel("Email");
		lbEndLogradouro = new JLabel("Logradouro");
		lbEndNumero = new JLabel("Número");
		lbEndBairro = new JLabel("Bairro");
		lbEndCidade = new JLabel("Cidade");
		lbEndCep = new JLabel("Cep");
		lbEndCaixaPostal = new JLabel("Caixa Postal");
		lbEndEstado = new JLabel("Estado");
		lbEndPais = new JLabel("País");		
		lbSituacao = new JLabel("Situação Cadastral");
		lbPeso = new JLabel("Peso");
		txtCodigo = new JTextField(20);
		txtNome = new JTextField(20);
		txtEmail = new JTextField(20);
		txtEndLogradouro = new JTextField(20);
		txtEndNumero = new JTextField(20);
		txtEndBairro = new JTextField(20);
		txtEndCidade = new JTextField(20);
		txtEndCep = new JTextField(20);
		txtEndCaixaPostal = new JTextField(20);		
		txtEndPais = new JTextField("Brasil", 20);
		txtPeso = new JTextField(4);
		//Objeto de Combo
		cbxSituacao = new JComboBox<SituacaoCadastral>(SituacaoCadastral.values());
		
		cbxEndEstado = new JComboBox<Estado>(Estado.values());
		cbxEndEstado.setSelectedItem(Estado.SP);
		
		gridCampos = new GridLayout(5,2,4,4);
		gridEndereco = new GridLayout(8,2,4,4);
		gridBotoes = new GridLayout(1,4,4,4);
		
		btCadastrar = new JButton("Cadastrar");
		btPesquisar = new JButton("Pesquisar");
		btExcluir = new JButton("Excluir");
		btSair = new JButton("Sair");
		
		pnCampos = new JPanel(gridCampos);
		pnEndereco = new JPanel(gridEndereco);
		pnBotoes = new JPanel(gridBotoes);
		
		pnEndereco.setBorder(BorderFactory.createTitledBorder("Endereço"));
		
		//3º Passo adicionando Visualmente os componentes
		pnCampos.add(lbCodigo);
		pnCampos.add(txtCodigo);
		pnCampos.add(lbNome);
		pnCampos.add(txtNome);
		pnCampos.add(lbEmail);
		pnCampos.add(txtEmail);
		pnCampos.add(lbSituacao);
		pnCampos.add(cbxSituacao);
		pnCampos.add(lbPeso);
		pnCampos.add(txtPeso);
		
		pnEndereco.add(lbEndLogradouro);
		pnEndereco.add(txtEndLogradouro);
		pnEndereco.add(lbEndNumero);
		pnEndereco.add(txtEndNumero);
		pnEndereco.add(lbEndBairro);
		pnEndereco.add(txtEndBairro);
		pnEndereco.add(lbEndCidade);
		pnEndereco.add(txtEndCidade);
		pnEndereco.add(lbEndCep);
		pnEndereco.add(txtEndCep);
		pnEndereco.add(lbEndCaixaPostal);
		pnEndereco.add(txtEndCaixaPostal);
		pnEndereco.add(lbEndEstado);
		pnEndereco.add(cbxEndEstado);
		pnEndereco.add(lbEndPais);
		pnEndereco.add(txtEndPais);
		
		pnBotoes.add(btCadastrar);
		pnBotoes.add(btExcluir);
		pnBotoes.add(btPesquisar);
		pnBotoes.add(btSair);
		
		add(pnCampos, BorderLayout.NORTH);
		add(pnEndereco, BorderLayout.CENTER);
		add(pnBotoes, BorderLayout.SOUTH);
		
		/*
		 * Mudando a localização
		 * pnBotoes.setLayout(BorderLayout.NORTH);
		 */
		
		//4º Passo - Adicionando ações (action)
		txtCodigo.addActionListener(this);
		btCadastrar.addActionListener(this);
		btExcluir.addActionListener(this);
		btPesquisar.addActionListener(this);
		btSair.addActionListener(this);
		
		popular();
		
		setVisible(true);		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btCadastrar){
			adicionar();
		}
		if(e.getSource() == btExcluir){
			excluir();
		}
		if(e.getSource() == txtCodigo) {
			pesquisar(true);
		}
		if(e.getSource() == btPesquisar){
			pesquisar(false);
		}
		if(e.getSource() == btSair){
			System.exit(0);
		}
	}

	private void excluir() {
		pesquisar(false);
		if(pessoa != null){
			int opcao = JOptionPane.showConfirmDialog(null, 
					"Deseja excluir a Pessoa Selecionad?");
			switch(opcao){
			case 0:
				listPessoa.remove(pessoa);
				limparDados();
				JOptionPane.showMessageDialog(null, "Excluído com sucesso");
				break;
			}
		}
	}

	private void pesquisar(boolean gatinho) {
		int codigo = Integer.parseInt(txtCodigo.getText());
		pessoa = null;
		for(Pessoa p : listPessoa){
			if(p.getCodigo() == codigo){
				pessoa = p;
				txtNome.setText(p.getNome());
				txtEmail.setText(p.getEmail());
				txtEndLogradouro.setText(p.getEndereco().getLogradouro());
				txtEndNumero.setText(String.valueOf(p.getEndereco().getNumero()));
				txtEndBairro.setText(p.getEndereco().getBairro());
				txtEndCidade.setText(p.getEndereco().getCidade());
				txtEndCep.setText(p.getEndereco().getCep());
				txtEndCaixaPostal.setText(p.getEndereco().getCaixaPostal());
				cbxEndEstado.setSelectedItem(p.getEndereco().getEstado());
				txtEndPais.setText(p.getEndereco().getPais());				
				txtPeso.setText(p.getPeso().toString());
				cbxSituacao.setSelectedItem(p.getSituacaoCadastral());
			}
		}		
		if(pessoa == null){
			if(gatinho) {
				txtNome.requestFocus();
			}
			else {
				JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
				limparDados();
			}
		}
	}

	private void adicionar() {
		//Receber campos visuais e transformar em Objeto
		pessoa = new Pessoa();
		try{			
			pessoa.setCodigo(Integer.parseInt(txtCodigo.getText()));
			pessoa.setNome(txtNome.getText());
			pessoa.setEmail(txtEmail.getText());
			
			Endereco endereco = new Endereco();
			endereco.setLogradouro(txtEndLogradouro.getText());		
			endereco.setNumero(Integer.parseInt(txtEndNumero.getText()));
			endereco.setBairro(txtEndBairro.getText());
			endereco.setCidade(txtEndCidade.getText());
			endereco.setCep(txtEndCep.getText());
			endereco.setCaixaPostal(txtEndCaixaPostal.getText());		
			endereco.setEstado((Estado)cbxEndEstado.getSelectedItem());
			endereco.setPais(txtEndPais.getText());					
			pessoa.setEndereco(endereco);	
			
			pessoa.setSituacaoCadastral((SituacaoCadastral)cbxSituacao.getSelectedItem());
			pessoa.setPeso(Float.parseFloat(txtPeso.getText()));
			
			listPessoa.add(pessoa);
			
			//Adicionando ao arquivo texto
			Repositorio repositorio = new Repositorio(url);			
			try {
				Repositorio.escrever(url, listPessoa);
			} catch (IOException e) {
				e.printStackTrace();
			}	
			
			JOptionPane.showMessageDialog(null, "Inserido com sucesso", "Persistência de Dados", JOptionPane.INFORMATION_MESSAGE);
			limparDados();
			System.out.println(listPessoa);
		}catch(NumberFormatException erro){
			JOptionPane.showMessageDialog(null, "Código Inválido!",
					"Tipo de Dado Incorreto", 
					JOptionPane.ERROR_MESSAGE);
		}		
	}

	private void limparDados() {
		txtCodigo.setText("");
		txtNome.setText("");		
		txtEmail.setText((""));
		cbxSituacao.setSelectedIndex(0);
		txtPeso.setText("");
		txtEndLogradouro.setText("");
		txtEndNumero.setText("");
		txtEndBairro.setText("");
		txtEndCep.setText("");
		txtEndCaixaPostal.setText("");		
		cbxEndEstado.setSelectedItem(Estado.SP);
		txtEndPais.setText("");
		
		txtCodigo.requestFocus();		
	}
	
	private void popular() {
		try {
			List<String> dados = Repositorio.ler(url);
			List<String[]> lista = Utils.popular(dados, ";");
			
			for(String[] conteudo : lista) {
				Pessoa entidade = new Pessoa();
				entidade.setCodigo(Integer.parseInt(conteudo[0]));
				entidade.setNome(conteudo[1]);
				entidade.setEmail(conteudo[2]);
				
				Endereco endereco = new Endereco();
				endereco.setLogradouro(conteudo[3]);
				endereco.setNumero(Integer.parseInt(conteudo[4]));
				endereco.setBairro(conteudo[5]);
				endereco.setCep(conteudo[6]);
				endereco.setCaixaPostal(conteudo[7]);
				endereco.setCidade(conteudo[8]);
				endereco.setEstado(Estado.valueOf(conteudo[9]));
				endereco.setPais(conteudo[10]);
				entidade.setEndereco(endereco);
				
				entidade.setSituacaoCadastral(SituacaoCadastral.valueOf(conteudo[11]));
				entidade.setPeso(Float.parseFloat(conteudo[12]));
				
				listPessoa.add(entidade);
			}
			
		} catch (IOException erro) {
			JOptionPane.showMessageDialog(null, "Falha ao carregar dados do arquivo " + url,
					"Falha no Repositório", 
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		frmPessoa form = new frmPessoa();
		form.setDefaultCloseOperation(JInternalFrame.EXIT_ON_CLOSE);

	}
}