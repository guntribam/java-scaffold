package br.com.gramorim.scaffold.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JSeparator;
import javax.swing.JTree;
import java.awt.GridLayout;
import javax.swing.Box;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;

public class JavaScaffoldGUI {

	private JFrame frame;
	private JTextField basePkgTextField;
	private JTextField variavelTextField;

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
		frame.setBounds(100, 100, 681, 463);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane Templates = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(Templates, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		Templates.addTab("Templates", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));

		criaListaTemplates(panel);

		criaOpcoesInferiores(panel);

		cadastrarTemplate(panel);
	}

	private void criaOpcoesInferiores(JPanel panel) {
		JPanel optionsPane = new JPanel();
		panel.add(optionsPane, BorderLayout.SOUTH);
		optionsPane.setLayout(new BoxLayout(optionsPane, BoxLayout.X_AXIS));

		JPanel createTemplatePane = new JPanel();
		createTemplatePane.setPreferredSize(new Dimension(1, 10));
		createTemplatePane.setAlignmentX(Component.LEFT_ALIGNMENT);
		createTemplatePane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		optionsPane.add(createTemplatePane);
		createTemplatePane.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton criarTemplate = new JButton("Criar Template");
		criarTemplate.setMargin(new Insets(2, 7, 2, 7));
		createTemplatePane.add(criarTemplate);

		JButton criarTemplateMaster = new JButton("Criar Master Template");
		criarTemplateMaster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		criarTemplateMaster.setMargin(new Insets(2, 7, 2, 7));
		createTemplatePane.add(criarTemplateMaster);

		JPanel saveOrCancelPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) saveOrCancelPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		optionsPane.add(saveOrCancelPanel);

		JButton salvarTemplate = new JButton("Salvar Template");
		saveOrCancelPanel.add(salvarTemplate);

		JButton btnNewButton_3 = new JButton("Cancelar");
		saveOrCancelPanel.add(btnNewButton_3);
	}

	private void cadastrarTemplate(JPanel panel) {
		JLayeredPane dadosTemplate = new JLayeredPane();
		panel.add(dadosTemplate, BorderLayout.CENTER);
		dadosTemplate.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel basePkgPanel = new JPanel();
		dadosTemplate.add(basePkgPanel);

		JLabel basePkg = new JLabel("Base Package");
		basePkgPanel.add(basePkg);

		basePkgTextField = new JTextField();
		basePkgPanel.add(basePkgTextField);
		basePkgTextField.setHorizontalAlignment(SwingConstants.LEFT);
		basePkgTextField.setColumns(28);

		JButton selecionaTemplateButton = new JButton("Selecione");
		basePkgPanel.add(selecionaTemplateButton);

		JPanel templateEditorPanel = new JPanel();
		dadosTemplate.add(templateEditorPanel);

		TextArea templateCode = new TextArea();
		templateEditorPanel.add(templateCode);

		JPanel variableDefinitionPanel = new JPanel();
		dadosTemplate.add(variableDefinitionPanel);

		JLabel variavelLabel = new JLabel("Variável");
		variableDefinitionPanel.add(variavelLabel);

		variavelTextField = new JTextField();
		variavelTextField.setHorizontalAlignment(SwingConstants.LEFT);
		variavelTextField.setColumns(40);
		variableDefinitionPanel.add(variavelTextField);

		JPanel newVariablePanel = new JPanel();
		dadosTemplate.add(newVariablePanel);

		JButton novaVariavelButton = new JButton("Nova Variável");
		newVariablePanel.add(novaVariavelButton);
	}

	private void criaListaTemplates(JPanel panel) {
		JPanel listaDeTemplates = new JPanel();
		listaDeTemplates.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel.add(listaDeTemplates, BorderLayout.WEST);
		listaDeTemplates.setLayout(new BoxLayout(listaDeTemplates, BoxLayout.Y_AXIS));
		
		JScrollPane scrollMasterTemplates = new JScrollPane();
		scrollMasterTemplates.setMinimumSize(new Dimension(200, 200));
		scrollMasterTemplates.setMaximumSize(new Dimension(200, 200));
		listaDeTemplates.add(scrollMasterTemplates);
		
		JPanel masterTemplatesPanel = new JPanel();
		masterTemplatesPanel.setMaximumSize(new Dimension(200, 200));
		masterTemplatesPanel.setMinimumSize(new Dimension(200, 200));
		scrollMasterTemplates.setViewportView(masterTemplatesPanel);
		masterTemplatesPanel.setLayout(new CardLayout(0, 0));
		
		JTree masterTemplatesTree = new JTree();
		masterTemplatesTree.setMinimumSize(new Dimension(100, 100));
		masterTemplatesTree.setMaximumSize(new Dimension(72, 200));
		masterTemplatesTree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Master Templates") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Crud");
						node_1.add(new DefaultMutableTreeNode("Entity"));
						node_1.add(new DefaultMutableTreeNode("Service"));
						node_1.add(new DefaultMutableTreeNode("Test"));
						node_1.add(new DefaultMutableTreeNode("Cmd"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Angular");
						node_1.add(new DefaultMutableTreeNode("Component"));
						node_1.add(new DefaultMutableTreeNode("Route"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Angular");
						node_1.add(new DefaultMutableTreeNode("Component"));
						node_1.add(new DefaultMutableTreeNode("Route"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Angular");
						node_1.add(new DefaultMutableTreeNode("Component"));
						node_1.add(new DefaultMutableTreeNode("Route"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Angular");
						node_1.add(new DefaultMutableTreeNode("Component"));
						node_1.add(new DefaultMutableTreeNode("Route"));
					add(node_1);
				}
			}
		));
		masterTemplatesPanel.add(masterTemplatesTree, "name_993316876030844");
		
		JScrollPane scrollTemplates = new JScrollPane();
		scrollTemplates.setMinimumSize(new Dimension(200, 150));
		scrollTemplates.setMaximumSize(new Dimension(200, 150));
		listaDeTemplates.add(scrollTemplates);
		
		JPanel templatesPanel = new JPanel();
		templatesPanel.setMaximumSize(new Dimension(200, 200));
		templatesPanel.setMinimumSize(new Dimension(200, 200));
		scrollTemplates.setViewportView(templatesPanel);
		templatesPanel.setLayout(new CardLayout(0, 0));
		
		JList templatesList = new JList();
		templatesPanel.add(templatesList, "name_993300326109969");
		templatesList.setModel(new AbstractListModel() {
			String[] values = new String[] {"ziggy", "bob", "marley", "ziggy", "bob", "marley", "ziggy", "bob", "marley", "ziggy", "bob", "marley", "ziggy", "bob", "marley", "ziggy"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}

}
