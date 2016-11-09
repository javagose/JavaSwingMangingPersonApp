package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;

import controller.Controller;
import javafx.scene.text.Text;

public class MainFrame extends JFrame {

	private TextPanel textPan;
	private ToolBar toolBar;
	private FormPanel formPanel;
	private JFileChooser fileChooser;
	private Controller controller;
	private TablePanel tablePanel;
	private PrefsDialog prefsDialog;
	private Preferences prefs;
	private JSplitPane splitPane;
	private JTabbedPane tabbedPane;
	private TreePanel treePanel;
	
	public MainFrame() {
		super("Person Managing");
		setLayout(new BorderLayout());
		setJMenuBar(getMyMenuBar());

		textPan = new TextPanel();
		toolBar = new ToolBar();
		formPanel = new FormPanel();
		tablePanel = new TablePanel();
		tablePanel.setToolTipText("Peson DataBase");
		textPan.setToolTipText("Messages");
		controller = new Controller();
		fileChooser = new JFileChooser();
		treePanel = new TreePanel();

		tabbedPane = new JTabbedPane();
		tabbedPane.add("Persons table", tablePanel);
		tabbedPane.add("Messages", textPan);
		tabbedPane.add("Server Tree", treePanel);
		tabbedPane.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createCompoundBorder(
						BorderFactory.createEmptyBorder(1,1,1,1),
						BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED), 
								BorderFactory.createBevelBorder(BevelBorder.LOWERED)) ),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
//		tabbedPane.setTabComponentAt(0, new JLabel(""));
//		tabbedPane.setTabComponentAt(1, new JLabel(""));
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, formPanel, tabbedPane);
		splitPane.setOneTouchExpandable(true);
		
		
		prefsDialog = new PrefsDialog(MainFrame.this);
		prefs = Preferences.systemRoot().node("db");

		fileChooser.addChoosableFileFilter(new FilePersonFilter());
		tablePanel.setData(controller.getData());

		toolBar.setStringListner(new StringListner() {

			public void stringEmmuted(String text) {
				textPan.appendText(text);
			}
		});

		toolBar.setBtnListener(new ToolBarAction() {
			@Override
			public void saveOccured() {
				System.out.println("save");
				File file = new File("");
				try {
					controller.loadFromFile(file);
					
					tablePanel.refresh();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(MainFrame.this,
							"Your Data could Not imported to" 
					+ fileChooser.getSelectedFile().getName() + "file",
					"Error" , JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
			
			@Override
			public void cancelOccured() {
				System.out.println("cancel");
			}
		});
		
		formPanel.setFormAction(new FormAction() {

			public void formoccured(FormEvent formEvent) {
				
				controller.addPerson(formEvent);
				tablePanel.refresh();
			}
		});
		
		// set Table Listener
		tablePanel.SetPersonTableListner(new PersonTableListner() {
			@Override
			public void rowDeleted(int row) {
				controller.removePerson(row);
			}
		});
		// set Dialog Listener 
		prefsDialog.setListner(new PrefsDialogListener() {
			public void PrefsDialogSetDefault(String user, String pass, int port) {
				prefs.put("user", user);
				prefs.put("pass", pass);
				prefs.putInt("port", port);;
			}
		});
		
		/// appeler SetDefault Preferences Dialog 
		prefsDialog.setDefault(prefs.get("user", ""),
				prefs.get("pass", ""), 
				prefs.getInt("port", 3306));
		

		add(toolBar, BorderLayout.PAGE_START);
		add(splitPane, BorderLayout.CENTER);

		setMinimumSize(new Dimension(500, 400));
		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);

	}

	private JMenuBar getMyMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu File = new JMenu("File ");
		JMenuItem exportItem = new JMenuItem("export Data...");
		JMenuItem importItem = new JMenuItem("import Data...");
		JMenuItem exitItem = new JMenuItem("Exit");
		File.add(exportItem);
		File.add(importItem);
		File.addSeparator();
		File.add(exitItem);

		JMenu Window = new JMenu("Window ");
		JMenu show = new JMenu("Show View");
		JCheckBoxMenuItem personForm = new JCheckBoxMenuItem("Person Table");
		JMenuItem personFormwidht = new JMenuItem("Person Form Widht");
		JMenuItem PrefsItem = new JMenuItem("Preferences");
		personForm.setSelected(true);
		
		show.add(personForm);
		Window.add(show);
		Window.add(personFormwidht);
		Window.addSeparator();
		Window.add(PrefsItem);
		////// Set up Mnemonics
		File.setMnemonic(KeyEvent.VK_F);
		exitItem.setMnemonic(KeyEvent.VK_X);
		///// Set Accelerator
		exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, 
				ActionEvent.CTRL_MASK));
		PrefsItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, 
				ActionEvent.CTRL_MASK));
		importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, 
				ActionEvent.CTRL_MASK));
		exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, 
				ActionEvent.CTRL_MASK));
		

		/// Visibilty of FormPanel
		personForm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
				formPanel.setVisible(menuItem.isSelected());
				if(menuItem.isSelected())
					splitPane.setDividerLocation((int)formPanel.getMinimumSize().getWidth());
			}
		});
		/// PrefsDialog Visibilty 
		PrefsItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prefsDialog.setVisible(true);
			}
		});
		
		/// Import and export listener

		importItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = fileChooser.showOpenDialog(MainFrame.this);
				if (i == JFileChooser.APPROVE_OPTION)
					try {
						controller.loadFromFile(fileChooser.getSelectedFile());
						
						tablePanel.refresh();
					} catch (IOException e) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"Your Data could Not imported to" 
						+ fileChooser.getSelectedFile().getName() + "file",
						"Error" , JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}
			}
		});
		exportItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = fileChooser.showSaveDialog(MainFrame.this);

				if (i == JFileChooser.APPROVE_OPTION)
					try {
						controller.saveToFile(fileChooser.getSelectedFile());
					} catch (IOException e) {
						JOptionPane.showMessageDialog(MainFrame.this,
								"Your Data could Not Exported to : " 
						+ fileChooser.getSelectedFile().getName() ,
						"Error" , JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}

			}
		});
		////// Exit Listener
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int option = JOptionPane.showConfirmDialog(MainFrame.this,
						"Do you really want to quite the application? ", "Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
				if (option == JOptionPane.OK_OPTION)
					System.exit(-1);
			}
		});

		menuBar.add(File);
		menuBar.add(Window);

		return menuBar;
	}

}
