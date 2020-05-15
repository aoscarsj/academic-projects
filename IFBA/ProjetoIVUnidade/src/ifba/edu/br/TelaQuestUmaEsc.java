package ifba.edu.br;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class TelaQuestUmaEsc extends JFrame implements ActionListener{
	
	
	private JLabel lbTipo, lbPergunta, lbInstrucoes, lbInstrucoes2, lbAlternativa;
	private JLabel lbDificuldade, lbProfessor, lbMateria, lbRegras, lbInstrucoes3, lbInstrucoes4;
	private JRadioButton rbA, rbB, rbC, rbD, rbE; 
	private ButtonGroup bgAlternativas, bgDificuldade;
	private JRadioButton rbD1, rbD2, rbD3, rbD4, rbD5;
	private JTextField tfProfessor, tfMateria, tfQuestao, tfA, tfB, tfC, tfD, tfE;
	private JButton btCadastrar, btCancelar;
	private JPanel jpExt, jp1, jp2, jp21, jp22, jp3, jp4,jp5;
	private JPanel jpLetraA, jpLetraB, jpLetraC, jpLetraD, jpLetraE;
	private JPanel jp6, jp61, jp7;
	private BoxLayout blExt, bl2, bl4, bl42, bl43, bl61;
	private FlowLayout fl1, fl21, fl22, fl3, fl4, fl5, fl6, fl7;
	private FlowLayout flA, flB, flC, flD, flE;
	private Border bdBlackline;
    private QuestoesUni Questao = new QuestoesUni();
	private JPanel [] Fakes = new JPanel [12];
	private ImageIcon img = new ImageIcon("LogoIFBA.jpeg");
	
	private JLabel lbImagem = new JLabel(img);
	
	// Fonts: Serif, SansSerif, Monospaced, Dialog, DialogInput
	TelaQuestUmaEsc(){
		super("Cadastro de Questões");
	}
	
	private void setVar (){
		
		lbTipo = new JLabel ("Questões de única Escolha");
		lbTipo.setFont(new Font("Serif", Font.BOLD + Font.ITALIC + Font.PLAIN, 40));
		
		lbProfessor = new JLabel ("Professor: ");
		lbProfessor.setFont(new Font("Times New Roma", Font.ITALIC + Font.PLAIN, 15));
		lbMateria = new JLabel ("Matéria: ");
		lbMateria.setFont(new Font("Times New Roma", Font.ITALIC + Font.PLAIN, 15));
		lbPergunta = new JLabel ("Pergunta: ");
		lbRegras = new JLabel("Regras: ");
		lbInstrucoes = new JLabel ("1. *Em 'Pergunta' escreva o título da questão. ");
		lbInstrucoes2 = new JLabel("2. *Em 'Respostas' digite em cada caixa quais serão as alternativas e assinale a correta.");
		lbInstrucoes3 = new JLabel("3. *A questão só será cadastrada se todos os campos estiverem preenchidos.");
		lbInstrucoes4 = new JLabel("4. *Ao clicar em 'Sair', a questão não será cadastrada e retornará ao Menu principal.");
		lbAlternativa = new JLabel ("Alternativas: ");
		lbDificuldade = new JLabel ("Dificuldade");
		
		rbA = new JRadioButton("a)");
		rbB = new JRadioButton("b)");
		rbC = new JRadioButton("c)");
		rbD = new JRadioButton("d)");
		rbE = new JRadioButton("e)");
		bgAlternativas = new ButtonGroup();
		bgAlternativas.add(rbA);
		bgAlternativas.add(rbB);
		bgAlternativas.add(rbC);
		bgAlternativas.add(rbD);
		bgAlternativas.add(rbE);
		
		rbD1 = new JRadioButton("1");
		rbD2 = new JRadioButton("2");
		rbD3 = new JRadioButton ("3");
		rbD4 = new JRadioButton ("4");
		rbD5 = new JRadioButton("5");
		bgDificuldade = new ButtonGroup();
		bgDificuldade.add(rbD1);
		bgDificuldade.add(rbD2);
		bgDificuldade.add(rbD3);
		bgDificuldade.add(rbD4);
		bgDificuldade.add(rbD5);
		
		//Esses dados virão da TelaAutenticacao e do vetor de professores cadastrados
		
		tfProfessor = new JTextField(16);
		tfProfessor.setFont(new Font("", Font.BOLD + Font.PLAIN, 14));
		tfProfessor.setText("Alexandre Franco");
		tfProfessor.setEditable(false);
		tfMateria = new JTextField (10);
		tfMateria.setFont(new Font("Times New Roma", Font.BOLD + Font.PLAIN, 14));
		tfMateria.setText("Algorítmos");
		tfMateria.setEditable(false);
		
		tfQuestao = new JTextField(90);
		tfA = new JTextField(70);
		tfB = new JTextField(70);
		tfC = new JTextField(70);
		tfD = new JTextField(70);
		tfE = new JTextField(70);
		tfQuestao.setFont(new Font("Times New Roma",  Font.ITALIC, 14));
		tfA.setFont(new Font("Times New Roma",  Font.BOLD, 14));
		tfB.setFont(new Font("Times New Roma",  Font.BOLD, 14));
		tfC.setFont(new Font("Times New Roma",  Font.BOLD, 14));
		tfD.setFont(new Font("Times New Roma",  Font.BOLD, 14));
		tfE.setFont(new Font("Times New Roma",  Font.BOLD, 14));
		
		btCadastrar = new JButton("Cadastrar questão");
		btCancelar = new JButton ("Sair");
		btCadastrar.setBorderPainted(true);
		btCancelar.setBorderPainted(true);
		btCancelar.setForeground(Color.BLACK);
		btCadastrar.setForeground(Color.BLACK);
		btCadastrar.addActionListener(this);
		btCancelar.addActionListener(this);
		
		bdBlackline = BorderFactory.createLineBorder(Color.black);
		
		jpExt = new JPanel(); jp1 = new JPanel(); jp2 = new JPanel(); 
		jp21 = new JPanel(); jp22 = new JPanel();
		jp3 = new JPanel(); jp4 = new JPanel(); jp5 = new JPanel();
		jp6 = new JPanel(); jp61 = new JPanel(); jp7 = new JPanel();
		jpLetraA = new JPanel(); jpLetraB = new JPanel(); jpLetraC = new JPanel();
		jpLetraD = new JPanel(); jpLetraE = new JPanel();
		jp1.setBackground(Color.CYAN);
		jp7.setBackground(Color.BLACK);
		jpExt.setBorder(bdBlackline);
		jp7.setBorder(bdBlackline);
		
		for (int i = 0; i<12; i++)
			Fakes[i] = new JPanel();

	}
	
	public void MontarTela(){
		Container conteudo = getContentPane();
		
		setVar();

		setLayout();
		
		conteudo.add(jpExt);
		jpExt.add(jp1);
		jpExt.add(jp2);
		jpExt.add(jp3);
		jpExt.add(jp4);
		jpExt.add(jp5);
		jpExt.add(jp6);
		jpExt.add(jp7);
		
		setCor(); //Responsável pelas cores dos Panels.

		setAddAll(); //Responsável por adcionar os componentes aos seus determinados Panels.
		
		configTela(); //Responsável pelo aparecimento da tela
	}
	
	
	@Override

	public void actionPerformed(ActionEvent event) {
		String Mensagem = "";
		Mensagem += tfProfessor.getText()+ ", Questão cadastrada com sucesso!";
		boolean simplifica = true;
		boolean testeTF = (tfA.getText().isEmpty() || tfB.getText().isEmpty() || tfC.getText().isEmpty() || tfD.getText().isEmpty() || tfE.getText().isEmpty() || tfQuestao.getText().isEmpty());
		boolean testeRBD = ( ( rbD1.isSelected() || rbD2.isSelected() || rbD3.isSelected() || rbD4.isSelected() || rbD5.isSelected() ));
		boolean testeRBA = (rbA.isSelected() || rbB.isSelected() || rbC.isSelected() || rbD.isSelected() || rbE.isSelected() );
		if (event.getSource() == btCancelar)
			this.dispose();
		else{
			if(testeTF || !testeRBD || !testeRBA){
				if(testeTF)
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de cadastrar a questão.", "Atenção", 2);
				else if(!testeRBD)
					JOptionPane.showMessageDialog(null, "Marque qual o nível de dificuldade da questão.", "Atenção", 2);
				else if (!testeRBA)
					JOptionPane.showMessageDialog(null, "Assinale a alternativa correta..", "Atenção", 2);

				simplifica = false;
			    
			}
				
			else {
		
				JOptionPane.showMessageDialog(null, Mensagem);
				
				//Antes do método abaixo, passar esses dados para o banco de dados.
				setZerarVar();
			}
				
		}
		// TODO Auto-generated method stub
		

		
	}


    private void setAddAll(){
		jp1.add(lbImagem);
		for(int i = 0; i<12; i++)
			jp1.add(Fakes[i]);
		
		jp1.add(lbTipo);
		
		jp2.add(jp21);
		jp2.add(jp22);
		
		jp3.add(lbPergunta);
		jp3.add(tfQuestao);
		
		jp4.add(lbAlternativa);
		jp4.add(jpLetraA);
		jp4.add(jpLetraB);
		jp4.add(jpLetraC);
		jp4.add(jpLetraD);
		jp4.add(jpLetraE);
		
		jp5.add(lbDificuldade);
		jp5.add(rbD1);
		jp5.add(rbD2);
		jp5.add(rbD3);
		jp5.add(rbD4);
		jp5.add(rbD5);
		
		jp6.add(lbRegras);
		jp6.add(jp61);
		
		jp7.add(btCancelar);
		jp7.add(btCadastrar);
		
		jp21.add(lbProfessor);
		jp22.add(lbMateria);
		jp21.add(tfProfessor);
		jp22.add(tfMateria);
		
		jpLetraA.add(rbA);
		jpLetraA.add(tfA);
		jpLetraB.add(rbB);
		jpLetraB.add(tfB);
		jpLetraC.add(rbC);
		jpLetraC.add(tfC);
		jpLetraD.add(rbD);
		jpLetraD.add(tfD);
		jpLetraE.add(rbE);
		jpLetraE.add(tfE);
		
		jp61.add(lbInstrucoes);
		jp61.add(lbInstrucoes2);
		jp61.add(lbInstrucoes3);
		jp61.add(lbInstrucoes4);
		
    }
	
	private void configTela(){

		setSize(1310,707);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}


	private void setCor(){
		
		jp1.setBackground(Color.WHITE);
		jp2.setBackground(Color.WHITE);
		jp3.setBackground(Color.WHITE);
		jp4.setBackground(Color.WHITE);
		jp5.setBackground(Color.WHITE);
		jp6.setBackground(Color.WHITE);
		jp21.setBackground(Color.WHITE);
		jp22.setBackground(Color.WHITE);
		jp61.setBackground(Color.WHITE);
		jpLetraA.setBackground(Color.WHITE);
		jpLetraB.setBackground(Color.WHITE);
		jpLetraC.setBackground(Color.WHITE);
		jpLetraD.setBackground(Color.WHITE);
		jpLetraE.setBackground(Color.WHITE);
		rbA.setBackground(Color.WHITE);
		rbB.setBackground(Color.WHITE);
		rbC.setBackground(Color.WHITE);
		rbD1.setBackground(Color.WHITE);
		rbD2.setBackground(Color.WHITE);
		rbD3.setBackground(Color.WHITE);
		rbD4.setBackground(Color.WHITE);
		rbD5.setBackground(Color.WHITE);
		rbD.setBackground(Color.WHITE);
		rbE.setBackground(Color.WHITE);
		tfProfessor.setBackground(Color.WHITE);
		tfMateria.setBackground(Color.WHITE);
		tfA.setBackground(Color.white);
		tfB.setBackground(Color.white);
		tfC.setBackground(Color.white);
		tfD.setBackground(Color.white);
		tfE.setBackground(Color.white);
		tfQuestao.setBackground(Color.lightGray);
		
		
		for (int i = 0; i<12; i++)
			Fakes[i].setBackground(Color.WHITE);
	}

	private void setLayout(){
		//setando BoxLayouts
				blExt = new BoxLayout(jpExt, BoxLayout.Y_AXIS);
				jpExt.setLayout(blExt);
				bl2 = new BoxLayout(jp2, BoxLayout.Y_AXIS);
				jp2.setLayout(bl2);
				/*
				bl42 = new BoxLayout(jp42, BoxLayout.Y_AXIS);
				jp42.setLayout(bl42);
				bl43 = new BoxLayout(jp43, BoxLayout.Y_AXIS);
				jp43.setLayout(bl43);
				*/
				bl61 = new BoxLayout(jp61, BoxLayout.Y_AXIS);
				jp61.setLayout(bl61);
				bl4 = new BoxLayout(jp4, BoxLayout.Y_AXIS);
				jp4.setLayout(bl4);
				
				//setando FlowLayouts
				fl1 = ((FlowLayout)jp1.getLayout());
				fl1.setAlignment(FlowLayout.LEFT);
				fl21 = ((FlowLayout)jp21.getLayout());
				fl21.setAlignment(FlowLayout.LEFT);
				fl22 = ((FlowLayout)jp22.getLayout());
				fl22.setAlignment(FlowLayout.LEFT);
				fl3 = ((FlowLayout)jp3.getLayout());
				fl3.setAlignment(FlowLayout.LEFT);
				//fl4 = ((FlowLayout)jp4.getLayout());
				//fl4.setAlignment(FlowLayout.LEFT);
				fl5 = ((FlowLayout)jp5.getLayout());
				fl5.setAlignment(FlowLayout.LEFT);
				fl6 = ((FlowLayout)jp6.getLayout());
				fl6.setAlignment(FlowLayout.LEFT);
				fl7 = ((FlowLayout)jp7.getLayout());
				fl7.setAlignment(FlowLayout.CENTER);
				
				flA = ((FlowLayout)jpLetraA.getLayout());
				flA.setAlignment(FlowLayout.LEFT);
				flB = ((FlowLayout)jpLetraB.getLayout());
				flB.setAlignment(FlowLayout.LEFT);
				flC = ((FlowLayout)jpLetraC.getLayout());
				flC.setAlignment(FlowLayout.LEFT);
				flD = ((FlowLayout)jpLetraD.getLayout());
				flD.setAlignment(FlowLayout.LEFT);
				flE = ((FlowLayout)jpLetraE.getLayout());
				flE.setAlignment(FlowLayout.LEFT);

	}private void setQuestao(){
		//Questao.setProfessor(get);
	}

	private void setZerarVar (){
		tfA.setText("");
		tfB.setText("");
		tfC.setText("");
		tfD.setText("");
		tfE.setText("");
		tfQuestao.setText("");
		
		rbA.setSelected(false);
		rbB.setSelected(false);
		rbC.setSelected(false);
		rbD.setSelected(false);
		rbE.setSelected(false);
		bgAlternativas.clearSelection();
		
		
		rbD1.setSelected(false);
		rbD2.setSelected(false);
		rbD3.setSelected(false);
		rbD4.setSelected(false);
		rbD5.setSelected(false);
		bgDificuldade.clearSelection();
	}


	
}
