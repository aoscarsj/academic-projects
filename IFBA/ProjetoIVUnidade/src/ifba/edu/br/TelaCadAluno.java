package ifba.edu.br;

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

public class TelaCadAluno extends JFrame implements ActionListener{

	
	private long CodigoLogin;
	private JLabel lbTitulo, lbNome, lbTelefone, lbCPF, lbNascimento, lbRG;
	private JLabel lbEndereco, lbEmail, lbSenha, lbSexo, lbCurso, lbAno;
	private JTextField tfNome, tfTelefone, tfCPF, tfNascimento, tfRG, tfEndereco;
	private JTextField tfEmail, tfAno, tfCurso;
	private JRadioButton rbMas, rbFem, rbOutros;
	private ButtonGroup bgSexo;
	private JPasswordField pfSenha;
	private JButton btCancelar, btOK;
	private JPanel jpExterno, jpSouth, jpTitulo, jpCenter, jpNorth, jpDirNorthExt;
	private JPanel jpCenterEast, jpCenterWest, jpDirSouth, jpDirNorth;
	private BoxLayout blExterno, blCentroEast, blCentroWest, blDirNorth;
	private FlowLayout flNorth, flTitulo, flSouth, flCenter, flDirNorth, flDirSouth;
	private JPanel [] jpFakes = new JPanel [70];
	
	private ImageIcon img = new ImageIcon("LogoIF.jpeg");

	private JLabel lbImagem = new JLabel(img);
	private Aluno aluno = new Aluno();
	
	TelaCadAluno(){
		super("Cadastro de Alunos");
	}
	
	private void setVar(){
		
		for (int i = 0; i<70; i++)
			jpFakes[i] = new JPanel();
		
		lbTitulo = new JLabel("Cadastro de Alunos");
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
		
		lbCurso = new JLabel("Curso no qual estuda: (Exemplo: Técnico em Informática)");
		lbCurso.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbSenha = new JLabel ("Senha: ");
		lbSenha.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbSexo = new JLabel ("Sexo:");
		lbSexo.setFont(new Font("DialogInput", Font.ITALIC + Font.PLAIN, 15));
		
		lbAno = new JLabel ("Informe a Série e turma que estuda (Exemplo 2º - A):");
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
		rbOutros = new JRadioButton ("Outros");
		bgSexo = new ButtonGroup();
		bgSexo.add(rbMas);
		bgSexo.add(rbFem);
		bgSexo.add(rbOutros);
		
		btCancelar = new JButton ("Cancelar");
		btOK = new JButton("OK");
		btCancelar.addActionListener(this);
		btOK.addActionListener(this);
		
		jpExterno = new JPanel(); jpSouth = new JPanel(); jpTitulo = new JPanel();
		jpCenter = new JPanel(); jpNorth = new JPanel(); jpCenterEast = new JPanel();
		jpCenterWest = new JPanel(); jpDirSouth = new JPanel(); jpDirNorth = new JPanel();
		jpDirNorthExt = new JPanel();
		
		
	}
	
	public void MontarTela(){
	
		Container conteudo = getContentPane();
		setVar();
		setLayout();
		setCor();
		setAddAll();
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
		
		
		
		setConfigTela();
	}
	
	private void setLayout(){

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
	
	private void setConfigTela(){
		setSize(1070,700);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	private void setAddAll(){
		
		jpNorth.add(jpFakes[50]);
		jpNorth.add(lbImagem);
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
		jpDirNorth.add(rbOutros);
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

	private void setZerarVar(){
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
		
		String Mensagem = "";
		Mensagem += tfNome.getText()+ ", Cadastro OK, seu Login é seu nome, não esqueça sua senha!";
		//A class de banco de dados enviará pra cá o número, através de um método
		boolean simplifica = true;
		boolean testeTF = (tfAno.getText().isEmpty() || tfCurso.getText().isEmpty() || pfSenha.getText().isEmpty() || tfTelefone.getText().isEmpty() || tfRG.getText().isEmpty() || tfNome.getText().isEmpty() || tfNascimento.getText().isEmpty() || tfEndereco.getText().isEmpty() || tfEmail.getText().isEmpty() || tfCPF.getText().isEmpty());
		boolean testeRB = ( (rbMas.isSelected() || rbFem.isSelected() || rbOutros.isSelected()));
		
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
		
				JOptionPane.showMessageDialog(null, Mensagem);
				setAluno();
				//Antes do método abaixo, passar esses dados para o banco de dados.
				setZerarVar();
			}

			
		
		}
		
	}
	private void setAluno(){
		aluno.setNome(tfNome.getText());
		aluno.setCPF(tfCPF.getText());
		aluno.setCurso(tfCurso.getText());
		aluno.setDatNascimento(tfNascimento.getText());
		aluno.setEmail(tfEmail.getText());
		aluno.setEndereco(tfEndereco.getText());
		aluno.setTelefone(tfTelefone.getText());
		aluno.setRG(tfRG.getText());
		aluno.setSenha(pfSenha.getText());
		aluno.setSerie(tfAno.getText());
		
		
		BaseDados.setPessoas(aluno);
		
		
		if(rbMas.isSelected())
			aluno.setSexo('M');
		else if(rbFem.isSelected())
			aluno.setSexo('F');
		else
			aluno.setSexo('O');
		
		
		
		
		
		
		
	}
	
}

	
	
