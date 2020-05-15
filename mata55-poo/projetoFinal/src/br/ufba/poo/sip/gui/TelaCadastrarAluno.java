package br.ufba.poo.sip.gui;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.ufba.poo.sip.core.Aluno;
import br.ufba.poo.sip.core.Professor;

public class TelaCadastrarAluno extends JFrame implements ActionListener, InterfaceGrafica{

	
	private long CodigoLogin;
	private JLabel lbTitulo, lbNome, lbTelefone, lbCPF, lbNascimento, lbRG;
	private JLabel lbEndereco, lbEmail, lbSenha, lbSexo, lbCurso, lbAno;
	private JTextField tfNome, tfTelefone, tfCPF, tfNascimento, tfRG, tfEndereco;
	private JTextField tfEmail, tfAno, tfCurso;
	private JRadioButton rbMas, rbFem;
	private ButtonGroup bgSexo;
	private JPasswordField pfSenha;
	private JButton btCancelar, btOK;
	private JPanel jpExterno, jpSouth, jpTitulo, jpCenter, jpNorth, jpDirNorthExt;
	private JPanel jpCenterEast, jpCenterWest, jpDirSouth, jpDirNorth;
	private BoxLayout blExterno, blCentroEast, blCentroWest, blDirNorth;
	private FlowLayout flNorth, flTitulo, flSouth, flCenter, flDirNorth, flDirSouth;
	private JPanel [] jpFakes = new JPanel [70];
	
	private Aluno aluno;
	
	TelaCadastrarAluno(){
		super("SIP - Cadastrar Aluno");
		montarTela();
	}
	


	@Override
	public void iniciarVariaveis(){
		
		for (int i = 0; i<70; i++)
			jpFakes[i] = new JPanel();
		
		lbTitulo = new JLabel("Cadastro de Aluno");
		lbTitulo.setFont(new Font("Serif", Font.BOLD + Font.PLAIN + Font.ITALIC, 40));
		
		lbNome = new JLabel("Nome:");
		lbNome.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbTelefone = new JLabel("Telefone:");
		lbTelefone.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbCPF = new JLabel("CPF:");
		lbCPF.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbNascimento = new JLabel("Data de Nascimento:");
		lbNascimento.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbRG = new JLabel("RG:");
		lbRG.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbEndereco = new JLabel("Endereco:");
		lbEndereco.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbEmail = new JLabel("Email:");
		lbEmail.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbCurso = new JLabel("Curso no qual estuda: ");
		lbCurso.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbSenha = new JLabel ("Senha: ");
		lbSenha.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbSexo = new JLabel ("Sexo:");
		lbSexo.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbAno = new JLabel ("Informe seu semestre: ");
		lbAno.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		// declarando TextField
		
		tfNome = new JTextField(10);
		tfNome.setFont(new Font("Serif",  Font.BOLD, 14));
		
		tfTelefone = new JTextField(10);
		tfTelefone.setFont(new Font("Serif", Font.BOLD, 14));
		
		tfCPF = new JTextField(10);
		tfCPF.setFont(new Font("Serif", Font.BOLD, 14));
		
		tfNascimento = new JTextField(10);
		tfNascimento.setFont(new Font("Serif", Font.BOLD, 14));
		
		tfRG = new JTextField(10);
		tfRG.setFont(new Font("Serif", Font.BOLD, 14));
		
		tfEndereco = new JTextField(10);
		tfEndereco.setFont(new Font("Serif", Font.BOLD, 14));
		
		tfEmail = new JTextField(10);
		tfEmail.setFont(new Font("Serif", Font.BOLD, 14));
		
		tfAno = new JTextField(10);
		tfAno.setFont(new Font("Serif", Font.BOLD, 14));
		
		tfCurso = new JTextField(10);
		tfCurso.setFont(new Font("Serif", Font.BOLD, 14));
		
		pfSenha = new JPasswordField(14);
		pfSenha.setFont(new Font("Serif", Font.BOLD, 14));

		rbMas = new JRadioButton ("Masculino");
		rbFem = new JRadioButton ("Feminino");
		bgSexo = new ButtonGroup();
		bgSexo.add(rbMas);
		bgSexo.add(rbFem);
		
		btCancelar = new JButton ("Cancelar");
		btOK = new JButton("OK");
		btCancelar.addActionListener(this);
		btOK.addActionListener(this);
		
		jpExterno = new JPanel(); jpSouth = new JPanel(); jpTitulo = new JPanel();
		jpCenter = new JPanel(); jpNorth = new JPanel(); jpCenterEast = new JPanel();
		jpCenterWest = new JPanel(); jpDirSouth = new JPanel(); jpDirNorth = new JPanel();
		jpDirNorthExt = new JPanel();
		
		
	}
	
	@Override
	public void montarTela(){
	
		Container conteudo = getContentPane();
		iniciarVariaveis();
		adicionarAlinhamento();
		setCor();
		adicionarElementos();
		conteudo.add(jpExterno);
		jpExterno.add(jpNorth);
		jpExterno.add(jpTitulo);
		jpExterno.add(jpCenter);
		jpCenter.add(jpFakes[51]);
		jpCenter.add(jpCenterEast);
		for (int i =0; i<5; i++)
		jpCenter.add(jpFakes[i]);
		jpCenter.add(jpCenterWest);
		jpCenterWest.add(jpDirNorthExt);
		jpDirNorthExt.add(jpDirNorth);
		for (int i = 6; i<23; i++)
			jpCenterWest.add(jpFakes[i]);
		jpCenterWest.add(jpDirSouth);
		jpExterno.add(jpSouth);
		
		
		
		configurarTela();
	}
	
	@Override
	public void adicionarAlinhamento(){

		//setando BoxLayouts
		blExterno = new BoxLayout(jpExterno, BoxLayout.Y_AXIS);
		jpExterno.setLayout(blExterno);
		blCentroEast = new BoxLayout(jpCenterEast, BoxLayout.Y_AXIS);
		jpCenterEast.setLayout(blCentroEast);
		blCentroWest = new BoxLayout(jpCenterWest, BoxLayout.Y_AXIS);
		jpCenterWest.setLayout(blCentroWest);
		blDirNorth = new BoxLayout(jpDirNorth, BoxLayout.Y_AXIS);
		jpDirNorth.setLayout(blDirNorth);
		
		//Setando BoxLayouts
		flNorth = ((FlowLayout)jpNorth.getLayout());
		flNorth.setAlignment(FlowLayout.LEFT);
		flTitulo = ((FlowLayout)jpTitulo.getLayout());
		flTitulo.setAlignment(FlowLayout.CENTER);
		flSouth = ((FlowLayout)jpSouth.getLayout());
		flSouth.setAlignment(FlowLayout.LEFT);
		flCenter = ((FlowLayout)jpCenter.getLayout());
		flCenter.setAlignment(FlowLayout.LEFT);
		flDirNorth = ((FlowLayout)jpDirNorthExt.getLayout());
		flDirNorth.setAlignment(FlowLayout.CENTER);
		flDirSouth = ((FlowLayout)jpDirSouth.getLayout());
		flDirSouth.setAlignment(FlowLayout.CENTER);
		
	}
	
	@Override
	public void configurarTela(){
		setSize(1070,700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	@Override
	public void adicionarElementos(){
		
		jpNorth.add(jpFakes[50]);
		
		jpTitulo.add(lbTitulo);
		for (int i = 0; i<26; i++)
			jpSouth.add(jpFakes[i]);
		jpSouth.add(btCancelar);
		for (int i = 26; i<50; i++)
			jpSouth.add(jpFakes[i]);
		jpSouth.add(btOK);
		jpDirNorth.add(lbSexo);
		jpDirNorth.add(rbMas);
		jpDirNorth.add(rbFem);
		//talvez um complemento
		
		jpDirSouth.add(lbSenha);
		jpDirSouth.add(pfSenha);
		
		jpCenterEast.add(lbNome);
		jpCenterEast.add(tfNome);
		jpCenterEast.add(lbTelefone);
		jpCenterEast.add(tfTelefone);
		jpCenterEast.add(lbNascimento);
		jpCenterEast.add(tfNascimento);
		jpCenterEast.add(lbRG);
		jpCenterEast.add(tfRG);
		jpCenterEast.add(lbCPF);
		jpCenterEast.add(tfCPF);
		jpCenterEast.add(lbEndereco);
		jpCenterEast.add(tfEndereco);
		jpCenterEast.add(lbEmail);
		jpCenterEast.add(tfEmail);
		jpCenterEast.add(lbAno);
		jpCenterEast.add(tfAno);
		jpCenterEast.add(lbCurso);
		jpCenterEast.add(tfCurso);
		
		jpCenterEast.add(jpFakes[5]);
		
		
		
		
	}
	
	private void setCor(){
		
		btOK.setBackground(Color.GREEN);
		btCancelar.setBackground(Color.WHITE);
		
	}

	private void zerarVariaveis(){
		tfTelefone.setText("");
		tfRG.setText("");
		tfAno.setText("");
		tfCurso.setText("");
		tfNome.setText("");
		tfNascimento.setText("");
		tfEndereco.setText("");
		tfEmail.setText("");
		tfCPF.setText("");
		pfSenha.setText("");
		bgSexo.clearSelection();
		
	}
	

	public void actionPerformed(ActionEvent event) {
		
		String mensagem = "";
		mensagem += tfNome.getText()+ ", Seu cadastro foi concl�ido!";
		boolean simplifica = true;
		boolean testeTF = (tfAno.getText().isEmpty() || tfCurso.getText().isEmpty() || pfSenha.getText().isEmpty() || tfTelefone.getText().isEmpty() || tfRG.getText().isEmpty() || tfNome.getText().isEmpty() || tfNascimento.getText().isEmpty() || tfEndereco.getText().isEmpty() || tfEmail.getText().isEmpty() || tfCPF.getText().isEmpty());
		boolean testeRB = (rbMas.isSelected() || rbFem.isSelected());
		
		if (event.getSource() == btCancelar)
			this.dispose();
		else{
			if(testeTF || !testeRB){
				if(testeTF)
					JOptionPane.showMessageDialog(null, "Retorne e certifique-se que preencheu todos os campos ", "Atenção", 2);
				else if(!testeRB)
					JOptionPane.showMessageDialog(null, "Marque qual é o seu sexo.", "Atenção", 2);
				
				simplifica = false;
			    
			}
				
			else {
		
				JOptionPane.showMessageDialog(null, mensagem);
				cadastrarAluno();
				zerarVariaveis();
			}

			
		
		}
		
	}
	private void cadastrarAluno(){

		char sexo; 
		if(rbMas.isSelected())
			sexo = 'M';
		else
			sexo = 'F';
		
		aluno = new Aluno(tfNome.getText(),tfCPF.getText(), tfRG.getText(), tfEndereco.getText(), tfEmail.getText(),
				tfNascimento.getText(), pfSenha.getText(), tfTelefone.getText(), sexo);
		aluno.cadastrar();		
	}

	
	
}

	
	
