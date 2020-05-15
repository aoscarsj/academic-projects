package br.ufba.poo.sip.gui;

import br.ufba.poo.sip.core.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaInicial extends JFrame implements ActionListener, InterfaceGrafica{
	private ButtonGroup bgTipo;
	private JMenuBar MenuBar;
	private JMenu Menu, MenuIntPessoa;
	private JMenuItem MitProfessor, MitAluno;
	private Container conteudo;
	private JRadioButton btProf, btAluno;
	private JLabel lbRodape, lbRodape1;
	private JPanel jpRodape;
	private BoxLayout blRodape;
	private JButton btEntrar;
	private JLabel lbLogin, lbSenha;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private JPanel jpLoginExt, jpLogin, jpSenha;
	private JPanel [] Fakes = new JPanel [26];
	private BoxLayout blLogExt;
	private FlowLayout flLog, flSenha;
    private ImageIcon img; 
    private JLabel lbImagem;
	
	
	
	public TelaInicial(){
		super("SIP - Sistema de Provas");
		img = new ImageIcon("sip-logo.jpg");
		lbImagem = new JLabel(img);
		montarTela();
	}
	
	@Override
	public void montarTela(){

		iniciarVariaveis();
		adicionarAlinhamento();
		adicionarElementos();
		configurarTela();
	}
	
	@Override
	public void iniciarVariaveis(){
		
		btProf = new JRadioButton ("Professor");
		btAluno = new JRadioButton("Aluno");
		bgTipo = new ButtonGroup();
		
		bgTipo.add(btProf);
		bgTipo.add(btAluno);
		MenuBar = new JMenuBar();
		Menu = new JMenu("Cadastrar");
		Menu.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 17));
		MenuIntPessoa = new JMenu ("Pessoa");
		MenuIntPessoa.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 17));
		MitProfessor = new JMenuItem ("Professor");
		MitAluno = new JMenuItem ("Aluno");
		MitProfessor.setFont(new Font("DialogInput", Font.BOLD+Font.PLAIN, 17));
		MitAluno.setFont(new Font("Monospaced", Font.BOLD+Font.PLAIN, 17));
		
		MitProfessor.addActionListener(this);
		MitAluno.addActionListener(this);
		
		
		
		//MitProva = new JMenuItem ("Gerar Prova");
		
		
		conteudo = getContentPane();
		
		lbRodape1 = new JLabel("   Professora: Rita Suzana Maciel");
		lbRodape = new JLabel("   Alunos: Artur Oscar e Luiz Cavalcanti");
		lbRodape1.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 13));
		lbRodape.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 13));
		jpRodape = new JPanel();
		jpRodape.setBackground(Color.BLACK);
	    lbRodape1.setForeground(Color.MAGENTA);
	    lbRodape.setForeground(Color.GREEN);
	    btEntrar = new JButton ("Entrar");
	    btEntrar.addActionListener(this);
	    lbLogin = new JLabel ("CPF:             ");
	    lbSenha = new JLabel ("Senha:");
	    lbLogin.setFont(new Font("", Font.BOLD, 14));
	    lbSenha.setFont(new Font("", Font.BOLD, 14));
	    tfLogin = new JTextField(12);
	    tfLogin.setFont(new Font("SansSerif", Font.BOLD, 16));
	    pfSenha = new JPasswordField(16);
	    pfSenha.setFont(new Font("SansSerif", Font.BOLD, 16));
	    jpLoginExt = new JPanel(); jpLogin = new JPanel(); jpSenha = new JPanel();
	    for(int i =0; i<26; i++)
	    	Fakes[i] = new JPanel();
	}

	@Override
	public void adicionarAlinhamento(){
		blRodape = new BoxLayout(jpRodape, BoxLayout.Y_AXIS);
		jpRodape.setLayout(blRodape);
				
		blLogExt = new BoxLayout(jpLoginExt, BoxLayout.Y_AXIS);
		
		jpLoginExt.setLayout(blLogExt);
		jpLoginExt.setAlignmentX(CENTER_ALIGNMENT);
		flLog = ((FlowLayout)jpLogin.getLayout());
		flLog.setAlignment(FlowLayout.CENTER);
		flSenha = ((FlowLayout)jpSenha.getLayout());
		flSenha.setAlignment(FlowLayout.CENTER);
		flLog.setAlignment(FlowLayout.CENTER);
		Fakes[7].setAlignmentX(LEFT_ALIGNMENT);
		
	}
	
	@Override
	public void adicionarElementos(){
		//Ala norte
		conteudo.add(MenuBar,BorderLayout.NORTH);
		MenuBar.add(Menu);
		//Menu.add(MenuIntQuestoes);
		Menu.add(MenuIntPessoa);
		//Menu.add(MitProva);
		//MenuIntQuestoes.add(MitQuesUmaEsc);
		//MenuIntQuestoes.add(MitQuesMultEsc);
		MenuIntPessoa.add(MitProfessor);
		MenuIntPessoa.add(MitAluno);
		
		
		//Ala Sul
		conteudo.add(jpRodape, BorderLayout.SOUTH);
		jpRodape.add(lbRodape);
		jpRodape.add(lbRodape1);
		
		
        // Centro
		jpLogin.add(lbLogin);
		jpLogin.add(tfLogin);
		jpSenha.add(lbSenha);
		jpSenha.add(pfSenha);

		conteudo.add(jpLoginExt);
		for(int i = 0; i<6; i++)
			jpLoginExt.add(Fakes[i]);
		
		Fakes[1].add(lbImagem);
		Fakes[1].setAlignmentX(RIGHT_ALIGNMENT);
		
		jpLoginExt.add(jpLogin);
		jpLoginExt.add(jpSenha);
		for (int i = 6; i<23; i++)
			jpLoginExt.add(Fakes[i]);
		Fakes[6].add(btAluno);
		Fakes[6].add(btProf);
		Fakes[7].add(btEntrar);
		for (int i =23; i<26; i++)
			Fakes[7].add(Fakes[i]);
	}
	
	@Override
	public void configurarTela(){

		setSize(440,440);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private boolean camposImcompletos() {
		boolean dadosPreenchidos = true;
		if(!tfLogin.getText().equals("") && !pfSenha.getText().equals("") && (btProf.isSelected() || btAluno.isSelected()) )
			dadosPreenchidos = false;
		
		return dadosPreenchidos;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource() == btEntrar){

			if(camposImcompletos()) 
				JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos. ", "ATENÇÃO", 2);			
			else {
				try {
					Pessoa pessoa = BancoDados.buscarPessoa(tfLogin.getText());
					if(pessoa != null) { 
						if(pessoa instanceof Professor && btProf.isSelected()) {
							if(pessoa.getSenha().equals(pfSenha.getText())) 
								new TelaLoginProfessor((Professor)pessoa);
							else
								JOptionPane.showMessageDialog(null, "Senha Incorreta", "ATENÇÃO", 2);
						}
						else if(pessoa instanceof Aluno && btAluno.isSelected()) {
							if(pessoa.getSenha().equals(pfSenha.getText())) 
								new TelaLoginAluno((Aluno)pessoa);
							else
								JOptionPane.showMessageDialog(null, "Senha Incorreta", "ATENÇÃO", 2);
						}
						else
							JOptionPane.showMessageDialog(null, "Usuário não encontrado", "ATENÇÃO", 2);
					}
				}catch(PessoaNaoEncontradaException e) {
					JOptionPane.showMessageDialog(null, "Usuário não encontrado, por favor, verifique os dados ou faça seu cadastro. ", "ATENÇÃO", 2);	
				}
				
			}
		}
		else if(event.getSource() == MitProfessor) {
			new TelaCadadastrarProfessor();
		}
		else if(event.getSource() == MitAluno) {
			new TelaCadastrarAluno();

		}
		
	}
}