package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class ClientePanel extends JPanel implements ActionListener{
	
	private JTextField nomeTextField;
	private JTextField cpfTextField;
	private JTextField enderecoTextField;
	private JLabel nomeLabel;
	private JLabel enderecoLabel;
	private JLabel cpfLabel;
	private JButton salvarBtn;
	
	public ClientePanel(){
        TitledBorder titulo = BorderFactory.createTitledBorder("Cadastro de Cliente");
        this.setBorder(titulo);
        GridLayout gd = new GridLayout(0,2) ;
        setLayout( gd );
        nomeTextField = new JTextField(40);
        cpfTextField = new JTextField(15);
        enderecoTextField = new JTextField(15);
        nomeLabel = new JLabel("Digite o Nome: ");
        cpfLabel = new JLabel("Digite o CPF: ");
        enderecoLabel = new JLabel("Digite o Endereco: ");
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(this);
        add(nomeLabel);
        add(nomeTextField);
        add(cpfLabel);
        add(cpfTextField);
        add(enderecoLabel);
        add(enderecoTextField);
        add(salvarBtn);
    
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Salvar")){
			System.out.println("Nome: "+nomeTextField.getText());
		}	
	}    


}
