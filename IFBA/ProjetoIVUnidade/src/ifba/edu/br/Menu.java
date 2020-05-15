package ifba.edu.br;

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

public class Menu extends JFrame implements ActionListener{
	private ButtonGroup bgTipo;
	private JMenuBar MenuBar;
	private JMenu Menu, MenuIntQuestoes, MenuIntPessoa;
	private JMenuItem MitProva, MitProfessor, MitAluno, MitQuesUmaEsc, MitQuesMultEsc;
	private Container conteudo;
	private JRadioButton btProf, btAluno;
	
	private JLabel lbRodape, lbRodape1;
	private JPanel jpRodape;
	
	private BoxLayout blRodape;
	
	
	
	//parte
	private JButton btEntrar;
	private JLabel lbLogin, lbSenha;
	private JTextField tfLogin;
	private JPasswordField pfSenha;
	private JPanel jpLoginExt, jpLogin, jpSenha;
	private JPanel [] Fakes = new JPanel [26];
	private BoxLayout blLogExt;
	private FlowLayout flLog, flSenha;
    private ImageIcon img = new ImageIcon("LogoIFBA.jpeg");
	
	private JLabel lbImagem = new JLabel(img);
	
	
	Menu(){
		super("Menu");
	}
	
	
	
	public void MontarMenu(){
		
		

		
		setVar();
		
		setAlignment();
		
		setAddAll();
		
		
		setConfigTela();
	}

	
	
	private void setVar(){
		
		btProf = new JRadioButton ("Professor");
		btAluno = new JRadioButton("Aluno");
		bgTipo = new ButtonGroup();
		
		bgTipo.add(btProf);
		bgTipo.add(btAluno);
		MenuBar = new JMenuBar();
		Menu = new JMenu("Cadastrar");
		Menu.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 17));
		//MenuIntQuestoes = new JMenu ("Questões");
		MenuIntPessoa = new JMenu ("Pessoa");
		MenuIntPessoa.setFont(new Font("Serif", Font.BOLD+Font.PLAIN, 17));
		//MitProva = new JMenuItem ("Fazer Prova");
		MitProfessor = new JMenuItem ("Professor");
		MitAluno = new JMenuItem ("Aluno");
		MitProfessor.setFont(new Font("DialogInput", Font.BOLD+Font.PLAIN, 17));
		MitAluno.setFont(new Font("Monospaced", Font.BOLD+Font.PLAIN, 17));
		//MitQuesUmaEsc = new JMenuItem ("Questões de Única Escolha");
		//MitQuesMultEsc = new JMenuItem ("Questões de Múltipla Escolha");
		
		//MitQuesUmaEsc.addActionListener(this);
		//MitQuesMultEsc.addActionListener(this);
		MitProfessor.addActionListener(this);
		MitAluno.addActionListener(this);
		
		
		
		//MitProva = new JMenuItem ("Gerar Prova");
		
		
		conteudo = getContentPane();
		
		lbRodape1 = new JLabel("                                          Professor: Alexandre Franco");
		lbRodape = new JLabel("  IFBA - Campus Santo Amaro, Projeto da 4º Unidade");
		lbRodape1.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 13));
		lbRodape.setFont(new Font("SansSerif", Font.BOLD+Font.PLAIN, 13));
		jpRodape = new JPanel();
		jpRodape.setBackground(Color.BLACK);
	    lbRodape1.setForeground(Color.MAGENTA);
	    lbRodape.setForeground(Color.GREEN);
	    btEntrar = new JButton ("Entrar");
	    btEntrar.addActionListener(this);
	    lbLogin = new JLabel ("Nome:             ");
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
	
	
	
	private void setAlignment(){
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
	
	private void setAddAll(){
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
	
	
	private void setConfigTela(){
		setSize(440,440);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		/*if (event.getSource() == MitQuesUmaEsc)
			new TelaQuestUmaEsc().MontarTela();
		else if (event.getSource() == MitQuesMultEsc)
			new TelaQuestMultEsc().MontarTela();*/
		if (event.getSource() == MitProfessor)
			new TelaCadProfessor().MontarTela();
		else if (event.getSource() == MitAluno)
			new TelaCadAluno().MontarTela();
		else if (event.getSource() == btEntrar){
			if(btAluno.isSelected())
				new TelaLogAluno().setTela();
			else if (btProf.isSelected())
				new TelaLogProfessor().setTela();
		}		

			
			
			//Pessoa qualquer [] = new Pessoa[BaseDados.getPessoas().size()];
			/*
			
			Pessoa qualquer;
			int i = 0;
			boolean entra = true;
			System.out.println("A");
			do{
				System.out.println("B");
			qualquer = BaseDados.getPessoas().get(i);
			System.out.println(qualquer.getNome());
			System.out.println(tfLogin.getText());
			if(tfLogin.getText().equals( qualquer.getNome()) ){
				System.out.println("C");
				if(qualquer.getTipo() == true){
					//professor
					System.out.println("D");
					new TelaLogProfessor().setTela();
				}
				else if (qualquer.getTipo() == false){
					//Aluno
					System.out.println("E");
					new TelaLogAluno().setTela();
				}
				System.out.println("F");
				entra = false;
			}
			else
				System.out.println("G");
				i++;
		
			
			}while(i<BaseDados.getPessoas().size() && entra);
			System.out.println("H");
		
		*/	
		}
		
		
	}


	
//}
