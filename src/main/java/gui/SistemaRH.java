package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class SistemaRH extends JFrame implements ActionListener{
	
	private JMenuBar menuPrincipalMB;
	private JMenu cadastrosM;
	private JMenu relatoriosM;
	private JMenu ajudaM;
	private JMenu sairM;
	private JMenuItem funcionarioMI;
	private JMenuItem clienteMI;
	
	
	private JPanel painelCentro;
	private FuncionarioPanel painelFuncionario;
	private ClientePanel painelCliente;
	
	public SistemaRH()  {
		getContentPane().setLayout(new BorderLayout());
		
		painelCentro = new JPanel();
		painelCentro.setLayout(new BorderLayout());
		 painelFuncionario = new FuncionarioPanel();
		 painelCliente = new ClientePanel();
		 
		 
		menuPrincipalMB = new JMenuBar();
		
		funcionarioMI = new JMenuItem("Cadastro de Funcionário");
		funcionarioMI.addActionListener(this);
		clienteMI = new JMenuItem("Cadastro de Cliente");
		clienteMI.addActionListener(this);
		cadastrosM = new JMenu("Cadastros");
		relatoriosM = new JMenu("Relatórios");
		ajudaM = new JMenu("Ajuda");
		sairM = new JMenu("Sair");
		menuPrincipalMB.add(cadastrosM);
		menuPrincipalMB.add(relatoriosM);
		menuPrincipalMB.add(ajudaM);
		menuPrincipalMB.add(sairM);
		cadastrosM.add(funcionarioMI);		
		cadastrosM.add(clienteMI);

		getContentPane().add(painelCentro, BorderLayout.CENTER);
		getContentPane().add(menuPrincipalMB, BorderLayout.NORTH);
		
		
	}
	public static void main(String[] args) {
		SistemaRH rh = new SistemaRH();
		rh.setSize(640, 200);
		rh.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == funcionarioMI){
			System.out.println("deve colocar o container");
			painelCentro.removeAll();
			painelCentro.add(painelFuncionario, BorderLayout.CENTER);
			revalidate();
		}	
		if (e.getSource() == clienteMI){
			System.out.println("deve colocar o container cliente");
			painelCentro.removeAll();
			painelCentro.add(painelCliente, BorderLayout.CENTER);
			revalidate();
			
		}
        
		
	}
}
