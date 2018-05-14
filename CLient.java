package chatclientsever;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.net.Socket;

import java.awt.event.ActionEvent;

public class CLient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	    Socket clientsocket;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CLient frame = new CLient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CLient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 414, 239);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(27, 189, 273, 20);
		panel.add(textField);
		textField.setColumns(10);
		JTextArea textArea = new JTextArea();
		textArea.setBounds(27, 11, 377, 168);
		panel.add(textArea);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					 clientsocket = new Socket("localhost", 8003);
					//tao dataoutputstream de gui du lieeu tu client toi server
					String a=textField.getText().toString();
				    DataOutputStream outputclient = new DataOutputStream(clientsocket.getOutputStream());
					outputclient.writeBytes(a+"\n");
					DataInputStream inputclient = new DataInputStream(clientsocket.getInputStream());
			    String dulieu=inputclient.readLine();
			   
			       textArea.setText(dulieu);
			       String dulieu2=inputclient.readLine();
			       textArea.setText(dulieu2);
					outputclient.close();
					inputclient.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnSend.setBounds(310, 188, 89, 23);
		panel.add(btnSend);
		
		
	

}

	
	}

