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

import br.ufba.poo.sip.core.Professor;

public class TelaLoginProfessor extends JFrame implements ActionListener, InterfaceGrafica{

	
	private static final long serialVersionUID = 1L;
	private JMenuBar MenuBar;
	private JMenu MenuCadastro, MenuFerramentas;
	private JMenuItem mitNotas,  mitEditar, mitSair;
	private JLabel lbBemVindo, lbBemVProf, lbNome, lbMateria, lbNRegistro;
	private JLabel lbEndereco, lbIFBA;
	private JPanel jpExt, jpNorth, jpNorthInt, jpCenter, jpCenterInt, jpSouth; 
	private BoxLayout blExt, blNorthInt, blCenterInt;
	private FlowLayout flNorth, flCenter;
	private JPanel [] Fakes = new JPanel[10];
	private Professor professor;
	TelaLoginProfessor(Professor professor){
		super("Bem vindo, Professor " + professor.getNome());
		this.professor = professor;
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
		conteudo.add(MenuBar,BorderLayout.NORTH);
		MenuBar.add(MenuCadastro);
		MenuBar.add(MenuFerramentas);
		MenuCadastro.add(mitNotas);
		
		MenuFerramentas.add(mitEditar);
		MenuFerramentas.add(mitSair);
		
		mitEditar.addActionListener(this);
		mitSair.addActionListener(this);
		mitNotas.addActionListener(this);
		
		
		conteudo.add(jpExt);
		jpExt.add(Fakes[0]);
		jpExt.add(jpNorth);
		jpExt.add(jpCenter);
		for (int i = 1; i<4; i++)
			jpExt.add(Fakes[i]);
		jpExt.add(jpSouth);
		jpNorth.add(jpNorthInt);
		jpCenter.add(jpCenterInt);
		jpSouth.add(lbIFBA);
		jpNorthInt.add(lbBemVindo);
		jpNorthInt.add(lbBemVProf);
		jpCenterInt.add(lbNome);
		jpCenterInt.add(lbMateria);
		jpCenterInt.add(lbNRegistro);
		jpCenterInt.add(lbEndereco);
		
		
	}
	
	@Override
	public void adicionarAlinhamento(){
		flNorth = ((FlowLayout)jpNorth.getLayout());
		flNorth.setAlignment(FlowLayout.CENTER);
		flCenter = ((FlowLayout)jpCenter.getLayout());
		flCenter.setAlignment(FlowLayout.LEFT);
		
		blExt = new BoxLayout(jpExt, BoxLayout.Y_AXIS);
		jpExt.setLayout(blExt);
		blNorthInt = new BoxLayout(jpNorthInt, BoxLayout.Y_AXIS);
		jpNorthInt.setLayout(blNorthInt);
		blCenterInt = new BoxLayout(jpCenterInt, BoxLayout.Y_AXIS);
		jpCenterInt.setLayout(blCenterInt);
		
	}
	
	@Override
	public void iniciarVariaveis(){
		MenuBar = new JMenuBar();
		MenuCadastro = new JMenu("Cadastrar    ");
		MenuFerramentas = new JMenu("Ferramentas");
		mitNotas = new JMenuItem("Notas");
		
		mitEditar = new JMenuItem("Editar Notas");
		mitSair = new JMenuItem("Sair");
		for (int i = 0; i<10; i++)
			Fakes[i] = new JPanel();
		jpExt = new JPanel(); jpNorth = new JPanel(); jpNorthInt = new JPanel();
		jpCenter = new JPanel();jpCenterInt= new JPanel();jpSouth= new JPanel();
		jpSouth.setBackground(Color.BLACK);
		
		lbBemVindo = new JLabel ("Bem vindo,");
		lbBemVindo.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 35));
		lbBemVProf = new JLabel("       professor " + professor.getNome());
		lbBemVProf.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 30));
		lbNome = new JLabel("Nome: " + professor.getNome());
		lbNome.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 16));
		lbMateria = new JLabel("Disciplina: " + professor.getDisciplina());
		lbMateria.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 16));
		lbNRegistro = new JLabel("Matrícula SIAPE: " + professor.getMatricula());
		lbNRegistro.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 16));
		lbEndereco = new JLabel("Endereço: " + professor.getEndereco());
		lbEndereco.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 16));
		lbIFBA = new JLabel("SIP - Sistema de Provas");
		lbIFBA.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 17));
		lbIFBA.setForeground(Color.GREEN);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == mitSair)
			this.dispose();
		else if(event.getSource() == mitNotas) {
			System.out.println("Notas");
		}
		else if(event.getSource() == mitEditar) {
			System.out.println("Editar");
		}			
	}
	@Override
	public void montarTela(){
		setSize(550,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
