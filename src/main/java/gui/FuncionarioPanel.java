package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import model.EmpregadoAssalariado;
import model.dao.EmpregadoAssalariadoDAO;

public class FuncionarioPanel extends JPanel implements ActionListener{
	
	private JTextField nomeTextField;
	private JTextField cpfTextField;
	private JLabel nomeLabel;
	private JLabel cpfLabel;
	private JButton salvarBtn;
	
	public FuncionarioPanel(){
        TitledBorder titulo = BorderFactory.createTitledBorder("Cadastro de Funcionario");
        this.setBorder(titulo);
        GridLayout gd = new GridLayout(0,2) ;
        setLayout( gd );
        nomeTextField = new JTextField(40);
        cpfTextField = new JTextField(15);
        nomeLabel = new JLabel("Digite o Nome: ");
        cpfLabel = new JLabel("Digite o CPF: ");
        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(this);
        add(nomeLabel);
        add(nomeTextField);
        add(cpfLabel);
        add(cpfTextField);
        add(salvarBtn);
    
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Salvar")){
			System.out.println("Nome: "+nomeTextField.getText());
                        
                        EmpregadoAssalariado ea = new EmpregadoAssalariado();
                        ea.setNome(nomeTextField.getText());
                        ea.setCpf(cpfTextField.getText());
                        
                        EmpregadoAssalariadoDAO dao = new EmpregadoAssalariadoDAO();
                        if (dao.inserir(ea)==true){
                            JOptionPane.showMessageDialog(null,  "ok, o funcionario foi salvo");
                            nomeTextField.setText("");
                            cpfTextField.setText("");
                        }else {
                             JOptionPane.showMessageDialog(null,  "problema ao salvar!");
                        }
                        
		}	
                
  
	}    


}
