package br.ufba.poo.sip.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import br.ufba.poo.sip.core.Aluno;



public class TelaLoginAluno extends JFrame implements ActionListener, InterfaceGrafica {
	
	
	
	private JMenuBar menuBar;
	private JMenu MenuOpcoes;
	private JMenuItem mitVerNotas, mitSair;
	private JLabel lbBemVindo, lbBemVAluno, lbNome, lbEndereco, lbCPF, lbNMatric; 
	private JLabel lbIFBA;
	private JPanel jpNorth, jpNorthint, jpCenter, jpCenterInt, jpSouth, jpExt;
	private FlowLayout flNorth, flCenter;
	private BoxLayout blNorthint, blCenterInt, blExt;
	private JPanel [] Fakes = new JPanel[20];
	private Aluno aluno;
	

	
	TelaLoginAluno(Aluno aluno){
		super("Bem vindo, " + aluno.getNome());
		this.aluno = aluno; 
		configurarTela();
	}
	
	@Override
	public void configurarTela(){
		iniciarVariaveis();
		adicionarAlinhamento();
		adicionarElementos();
		montarTela();
	}
	
	@Override
	public void adicionarElementos(){
		Container conteudo = getContentPane();
		conteudo.add(menuBar, BorderLayout.NORTH);
		menuBar.add(MenuOpcoes);
		MenuOpcoes.setFont(new Font("Serif", Font.PLAIN + Font.BOLD, 16));
		MenuOpcoes.add(mitVerNotas);
		MenuOpcoes.add(mitSair);
		
		mitVerNotas.addActionListener(this);
		mitSair.addActionListener(this);
		
		
		conteudo.add(jpExt);
	    jpExt.add(Fakes[0]);
		jpExt.add(jpNorth);
		jpExt.add(Fakes[5]);
		jpExt.add(jpCenter);
		for (int i =1; i<5; i++)
			jpExt.add(Fakes[i]);
		jpExt.add(jpSouth);
		jpNorth.add(jpNorthint);
		jpCenter.add(jpCenterInt);
		jpNorthint.add(lbBemVindo);
		jpNorthint.add(lbBemVAluno);
		jpCenterInt.add(lbNome);
		jpCenterInt.add(lbEndereco);
		jpCenterInt.add(lbCPF);
		jpCenterInt.add(lbNMatric);
		jpSouth.add(lbIFBA);
		
		
	}
	
	
	@Override
	public void adicionarAlinhamento(){
		blExt = new BoxLayout(jpExt, BoxLayout.Y_AXIS);
		jpExt.setLayout(blExt);
		blNorthint = new BoxLayout(jpNorthint, BoxLayout.Y_AXIS);
		jpNorthint.setLayout(blNorthint);
		blCenterInt = new BoxLayout(jpCenterInt, BoxLayout.Y_AXIS);
		jpCenterInt.setLayout(blCenterInt);
		
		flNorth = ((FlowLayout)jpNorth.getLayout());
		flNorth.setAlignment(FlowLayout.CENTER);
		flCenter = ((FlowLayout)jpCenter.getLayout());
		flCenter.setAlignment(FlowLayout.LEFT);
		
	}
	
	@Override
	public void iniciarVariaveis(){
		menuBar = new JMenuBar();
		MenuOpcoes = new JMenu("Opcoes");
		mitVerNotas = new JMenuItem("Minhas Notas");
		mitSair = new JMenuItem("Sair");
		
		for (int i = 0; i<20; i++)
			Fakes[i] = new JPanel();
		jpNorth = new JPanel(); jpNorthint = new JPanel(); jpCenter = new JPanel();
		jpSouth = new JPanel(); jpExt = new JPanel(); jpCenterInt = new JPanel();
		
		lbBemVindo = new JLabel("Bem Vindo,");
		lbBemVindo.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 35));
		
		lbBemVAluno = new JLabel("      "+aluno.getNome());
		lbBemVAluno.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 30));
		
		lbNome = new JLabel("Nome: " + aluno.getNome());
		lbNome.setFont(new Font("DialogInput", Font.BOLD + Font.ITALIC, 16));
		
		lbEndereco = new JLabel("Endereço: " + aluno.getEndereco());
		lbEndereco.setFont(new Font("DialogInput", Font.BOLD + Font.ITALIC, 16));
		
		lbCPF = new JLabel("CPF: " + aluno.getCpf());
		lbCPF.setFont(new Font("DialogInput", Font.BOLD + Font.ITALIC, 16));
		
		lbNMatric = new JLabel("Matrícula: " + aluno.getMatricula());
		lbNMatric.setFont(new Font("DialogInput", Font.BOLD + Font.ITALIC, 16));
		
		lbIFBA = new JLabel("SIP - Sistema de Provas");
		lbIFBA.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 16));
		lbIFBA.setForeground(Color.GREEN);
		jpSouth.setBackground(Color.BLACK);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if (event.getSource() == mitSair)
			this.dispose();
		else if(event.getSource() == mitVerNotas){
			
		}else {
			
		}	
	}
	@Override
	public void montarTela(){
		setSize(550,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
	}
	

}
