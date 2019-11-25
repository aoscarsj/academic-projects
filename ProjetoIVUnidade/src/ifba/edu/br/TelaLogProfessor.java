package ifba.edu.br;

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

public class TelaLogProfessor extends JFrame implements ActionListener{

	private JMenuBar MenuBar;
	private JMenu MenuCadastro, MenuFerramentas, MenuQuestoes;
	private JMenuItem mitProva, mitUnica, mitMult, mitNotas, mitEditar, mitSair;
	private JLabel lbBemVindo, lbBemVProf, lbNome, lbMateria, lbNRegistro;
	private JLabel lbEndereco, lbIFBA;
	private JPanel jpExt, jpNorth, jpNorthInt, jpCenter, jpCenterInt, jpSouth; 
	private BoxLayout blExt, blNorthInt, blCenterInt;
	private FlowLayout flNorth, flCenter;
	private JPanel [] Fakes = new JPanel[10];
	
	TelaLogProfessor(){
		super("Bem vindo, Professor xYZ");
	}
	protected void setTela(){
		setVar();
		setLayout();
		setAddAll();
		setCfgTela();
	}
	
	private void setAddAll(){
		Container conteudo = getContentPane();
		conteudo.add(MenuBar,BorderLayout.NORTH);
		MenuBar.add(MenuCadastro);
		MenuBar.add(MenuFerramentas);
		MenuCadastro.add(mitProva);
		MenuCadastro.add(MenuQuestoes);
		MenuQuestoes.add(mitUnica);
		MenuQuestoes.add(mitMult);
		MenuFerramentas.add(mitNotas);
		MenuFerramentas.add(mitEditar);
		MenuFerramentas.add(mitSair);
		mitProva.addActionListener(this);
		mitUnica.addActionListener(this);
		mitMult.addActionListener(this);
		mitNotas.addActionListener(this);
		mitEditar.addActionListener(this);
		mitSair.addActionListener(this);
		
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
	
	private void setLayout(){
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
	
	private void setVar(){
		MenuBar = new JMenuBar();
		MenuCadastro = new JMenu("Cadastrar    ");
		MenuFerramentas = new JMenu("Ferramentas");
		MenuQuestoes = new JMenu("Questoes");
		mitProva = new JMenuItem("Prova");
		mitUnica = new JMenuItem("Questoes de Única Escolha");
		mitMult = new JMenuItem("Questoes de Múltipla Escolha");
		mitNotas = new JMenuItem("Notas dos Alunos");
		mitEditar = new JMenuItem("Editar Questões");
		mitSair = new JMenuItem("Sair");
		for (int i = 0; i<10; i++)
			Fakes[i] = new JPanel();
		jpExt = new JPanel(); jpNorth = new JPanel(); jpNorthInt = new JPanel();
		jpCenter = new JPanel();jpCenterInt= new JPanel();jpSouth= new JPanel();
		jpSouth.setBackground(Color.BLACK);
		
		lbBemVindo = new JLabel ("Bem vindo,");
		lbBemVindo.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 35));
		lbBemVProf = new JLabel("professor x...");
		lbBemVProf.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 30));
		lbNome = new JLabel("Nome: do professor");
		lbNome.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 16));
		lbMateria = new JLabel("Matéria: saidjasidjsa");
		lbMateria.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 16));
		lbNRegistro = new JLabel("Número de Registro: XYZXYXZXYZY");
		lbNRegistro.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 16));
		lbEndereco = new JLabel("Endereco: ");
		lbEndereco.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 16));
		lbIFBA = new JLabel("IFBA - Campus Santo Amaro");
		lbIFBA.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 17));
		lbIFBA.setForeground(Color.GREEN);
	}
	
	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == mitSair)
			this.dispose();
		else if(event.getSource() == mitUnica)
			new TelaQuestUmaEsc().MontarTela();
		else if(event.getSource() == mitMult)
			new TelaQuestMultEsc().MontarTela();
		else if(event.getSource() == mitProva){
			
		}else if(event.getSource() == mitNotas){
			
		}else{
			//mitEditarQuestoes
		}
			
	}
	private void setCfgTela(){
		setSize(550,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
