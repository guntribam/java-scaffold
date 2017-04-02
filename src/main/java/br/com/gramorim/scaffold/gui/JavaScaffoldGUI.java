package br.com.gramorim.scaffold.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JSplitPane;
import java.awt.ComponentOrientation;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

public class JavaScaffoldGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaScaffoldGUI window = new JavaScaffoldGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaScaffoldGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 609, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane Templates = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(Templates, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Templates.addTab("Templates", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel listaDeTemplates = new JPanel();
		listaDeTemplates.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		FlowLayout fl_listaDeTemplates = (FlowLayout) listaDeTemplates.getLayout();
		fl_listaDeTemplates.setHgap(40);
		panel.add(listaDeTemplates, BorderLayout.WEST);

		JList list = new JList();
		list.setVisibleRowCount(12);
		listaDeTemplates.add(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] { "Crud", "Angular", "Test" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
																																																																																																		
																																																																																																				JPanel dadosTemplate = new JPanel();
																																																																																																				panel.add(dadosTemplate, BorderLayout.CENTER);
																																																																																																				dadosTemplate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
																																																																																																				
																																																																																																						JPanel basePkgPanel = new JPanel();
																																																																																																						dadosTemplate.add(basePkgPanel);
																																																																																																						
																																																																																																								JLabel basePkg = new JLabel("Base Package");
																																																																																																								basePkgPanel.add(basePkg);
																																																																																																								
																																																																																																										textField = new JTextField();
																																																																																																										basePkgPanel.add(textField);
																																																																																																										textField.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																																										textField.setColumns(28);
																																																																																																										
																																																																																																												JButton btnNewButton = new JButton("Selecione");
																																																																																																												basePkgPanel.add(btnNewButton);
																																																																																																												
																																																																																																														JPanel templateEditorPanel = new JPanel();
																																																																																																														dadosTemplate.add(templateEditorPanel);
																																																																																																														
																																																																																																																TextArea textArea = new TextArea();
																																																																																																																templateEditorPanel.add(textArea);
																																																																																																																
																																																																																																																		JPanel variableDefinitionPanel = new JPanel();
																																																																																																																		dadosTemplate.add(variableDefinitionPanel);
																																																																																																																		
																																																																																																																				JLabel lblVarivel = new JLabel("Variável");
																																																																																																																				variableDefinitionPanel.add(lblVarivel);
																																																																																																																				
																																																																																																																						textField_1 = new JTextField();
																																																																																																																						textField_1.setHorizontalAlignment(SwingConstants.LEFT);
																																																																																																																						textField_1.setColumns(40);
																																																																																																																						variableDefinitionPanel.add(textField_1);
																																																																																																																						
																																																																																																																								JPanel newVariablePanel = new JPanel();
																																																																																																																								dadosTemplate.add(newVariablePanel);
																																																																																																																								
																																																																																																																										JButton btnNewButton_1 = new JButton("Nova Variável");
																																																																																																																										newVariablePanel.add(btnNewButton_1);
																																																																																																																										
																																																																																																																										JSeparator separator = new JSeparator();
																																																																																																																										dadosTemplate.add(separator);
																																																																																																																										
																																																																																																																										JPanel optionsPane = new JPanel();
																																																																																																																										panel.add(optionsPane, BorderLayout.SOUTH);
																																																																																																																										optionsPane.setLayout(new BoxLayout(optionsPane, BoxLayout.X_AXIS));
																																																																																																																										
																																																																																																																										JPanel createTemplatePane = new JPanel();
																																																																																																																										createTemplatePane.setPreferredSize(new Dimension(2, 10));
																																																																																																																										createTemplatePane.setAlignmentX(Component.LEFT_ALIGNMENT);
																																																																																																																										createTemplatePane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
																																																																																																																										optionsPane.add(createTemplatePane);
																																																																																																																										createTemplatePane.setLayout(new GridLayout(0, 1, 0, 0));
																																																																																																																										
																																																																																																																										JButton btnNewButton_2 = new JButton("Criar Template");
																																																																																																																										btnNewButton_2.setMargin(new Insets(2, 7, 2, 7));
																																																																																																																										createTemplatePane.add(btnNewButton_2);
																																																																																																																										
																																																																																																																										JPanel saveOrCancelPanel = new JPanel();
																																																																																																																										optionsPane.add(saveOrCancelPanel);
																																																																																																																										
																																																																																																																										JButton salvarTemplate = new JButton("Salvar Template");
																																																																																																																										saveOrCancelPanel.add(salvarTemplate);
																																																																																																																										
																																																																																																																										JButton btnNewButton_3 = new JButton("Cancelar");
																																																																																																																										saveOrCancelPanel.add(btnNewButton_3);
	}

}
