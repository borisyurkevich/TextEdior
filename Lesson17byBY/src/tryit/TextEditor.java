/**
 * TRY IT from LESSON 17
 * 
 * Special thanks to Yakov Fain and 
 * his wonderful book Java Programming 24-Hour Trainer
 * 
 * @author Yakov Fain
 * @author Boris Yurkevich
 */

package tryit;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class TextEditor extends JPanel implements ActionListener {
	
	private JFrame frame;
	private JTextArea editor;	
	private JComboBox font;
	private JComboBox size;
	private JComboBox color;
	private String[] colors = {"Black", "Red", "Green", "Blue"};
	private String[] fonts = {"Arial", "Times New Roman", "Helvetica"};
	private String[] sizes = {"9", "12", "16"};
	
	/**
	 * Constructor creates and ads GUI
	 */
	public TextEditor () {
		initialize();
	}
	
	private void initialize() {
		
		ISavingUserPreferences pref = new ISavingUserPreferences();
		System.out.println("COLOR = " + pref.getColor());
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		editor = new JTextArea();
		editor.setColumns(1);
		editor.setRows(15);
		editor.setBounds(59, 16, 338, 217);
		frame.getContentPane().add(editor);
		
		/**
		 * JCombobox size GUI
		 * Set or change Font Size 
		 */
		size = new JComboBox(sizes);
		size.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		size.setEditable(true);
		size.setToolTipText("Set the font size");
		size.setBounds(186, 245, 56, 27);
		frame.getContentPane().add(size);
		
		/**
		 * Action Listener
		 * Change Font Size
		 * Write Font Size into pref file
		 */
		size.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Size Act Listener");
				System.out.println("FONT = " + (String) font.getSelectedItem() );
					
				String fontChosen;
				int fontSizeChosen;
				
				FileOutputStream fileOut = null;
				ObjectOutputStream objectOut = null;				
				fontChosen = (String) font.getSelectedItem();
				fontSizeChosen = Integer.parseInt((String) size.getSelectedItem());
				
				/**
				 * Write new settings
				 */
				ISavingUserPreferences userPrefs = new ISavingUserPreferences();
				userPrefs.setColor((String) color.getSelectedItem());
				userPrefs.setFont(fontChosen);
				userPrefs.setFontSize(fontSizeChosen);
				
				/**
				 * Read and change On-The-Go
				 */
				editor.setFont(new Font(userPrefs.getFont(), Font.PLAIN, userPrefs.getFontSize() ) );
				
				try {
	
					fileOut = new FileOutputStream("preferences.ser");
					objectOut = new ObjectOutputStream(fileOut);	
					objectOut.writeObject(userPrefs);
					
				} catch (IOException e1) {
					
					try {
						objectOut.flush();
						objectOut.close();
						fileOut.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		}
		);
		
		/**
		 * JCombobox fontFamily GUI
		 * Set or change Font Family 
		 */
		font = new JComboBox(fonts);
		font.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.out.println("Size Act Listener");
				System.out.println("FONT = " + (String) font.getSelectedItem() );
					
				String fontChosen;
				int fontSizeChosen;
				
				FileOutputStream fileOut = null;
				ObjectOutputStream objectOut = null;
				fontChosen = (String) font.getSelectedItem();
				fontSizeChosen = Integer.parseInt((String) size.getSelectedItem());
				ISavingUserPreferences userPrefs = new ISavingUserPreferences();
				userPrefs.setColor((String) color.getSelectedItem());
				userPrefs.setFont(fontChosen);
				userPrefs.setFontSize(fontSizeChosen);
				
				editor.setFont(new Font(fontChosen, Font.PLAIN, userPrefs.getFontSize() ));
				
				/**
				 * Read and change On-The-Go
				 */
				editor.setFont(new Font(userPrefs.getFont(), Font.PLAIN, userPrefs.getFontSize() ) );
				
				try {
					
					fileOut = new FileOutputStream("preferences.ser");
					objectOut = new ObjectOutputStream(fileOut);	
					objectOut.writeObject(userPrefs);
					
				} catch (IOException e1) {
					
					try {
						objectOut.flush();
						objectOut.close();
						fileOut.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
				
			}
		});
		
		font.setToolTipText("Choose the font family");
		font.setBounds(6, 245, 168, 27);
		frame.getContentPane().add(font);		
		color = new JComboBox(colors);
		color.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					
				String fontChosen;
				int fontSizeChosen;
				
				FileOutputStream fileOut = null;
				ObjectOutputStream objectOut = null;
				
				if ((String) color.getSelectedItem() == "Red") {
					editor.setForeground(Color.red);
				} else if ((String) color.getSelectedItem() == "Green") {
					editor.setForeground(Color.green);
				} else if ((String) color.getSelectedItem() == "Blue") {
					editor.setForeground(Color.blue);
				} else if ((String) color.getSelectedItem() == "Cyan") {
					editor.setForeground(Color.cyan);
				} else if ((String) color.getSelectedItem() == "Magenta") {
				editor.setForeground(Color.magenta);
				} else if ((String) color.getSelectedItem() == "Yellow") {
					editor.setForeground(Color.yellow);
				} else if ((String) color.getSelectedItem() == "Black") {
					editor.setForeground(Color.black);
				}
				
				fontChosen = (String) font.getSelectedItem();
				fontSizeChosen = Integer.parseInt((String) size.getSelectedItem());
				ISavingUserPreferences userPrefs = new ISavingUserPreferences();
				userPrefs.setColor((String) color.getSelectedItem());
				userPrefs.setFont(fontChosen);
				userPrefs.setFontSize(fontSizeChosen);
				
				editor.setFont(new Font(fontChosen, Font.PLAIN, userPrefs.getFontSize() ));
				
				/**
				 * Read and change On-The-Go
				 */
				editor.setFont(new Font(userPrefs.getFont(), Font.PLAIN, userPrefs.getFontSize() ) );
				
				try {
					
					fileOut = new FileOutputStream("preferences.ser");
					objectOut = new ObjectOutputStream(fileOut);	
					objectOut.writeObject(userPrefs);
					
				} catch (IOException e1) {
					
					try {
						objectOut.flush();
						objectOut.close();
						fileOut.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});
		
		color.setToolTipText("Choose the text color");
		color.setBounds(254, 245, 103, 27);
		frame.getContentPane().add(color);
	}
	
	public static void main(String[] args) {
		
		/**
		 * Some code for general window app
		 */
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				TextEditor custGUI = new TextEditor();
				custGUI.frame.setVisible(true);
				FileInputStream fileIn = null;
				ObjectInputStream objectIn = null;
				ISavingUserPreferences savedPrefs;
				
				try {
					
					fileIn = new FileInputStream("preferences.ser");
					objectIn = new ObjectInputStream (fileIn);
					
					/**
					 * Reading User Preferences
					 */
					savedPrefs = (ISavingUserPreferences) objectIn.readObject();
					
					try {
						
					
						if (savedPrefs.getColor().contains("Black")) {
							custGUI.editor.setForeground(Color.BLACK);
							custGUI.color.setSelectedItem("Black");
						} else if (savedPrefs.getColor().contains("Green")) {
							custGUI.editor.setForeground(Color.GREEN);
							custGUI.color.setSelectedItem("Green");
						} else if (savedPrefs.getColor().contains("Blue")) {
							custGUI.editor.setForeground(Color.BLUE);
							custGUI.color.setSelectedItem("Blue");
						} else if (savedPrefs.getColor().contains("Red")) {
							custGUI.editor.setForeground(Color.RED);
							custGUI.color.setSelectedItem("Red");
						} 
					
						custGUI.setFont(savedPrefs.getFont(), savedPrefs.getFontSize());
						custGUI.font.setSelectedItem(savedPrefs.getFont());
						custGUI.size.setSelectedItem("" + savedPrefs.getFontSize());
					
					} catch (NullPointerException npe) {
						System.out.println("Kalabanga!");
					}
						
				} catch (FileNotFoundException noFile) {
					//load file defaults
					custGUI.setFont("Arial", 14);
					custGUI.editor.setForeground(Color.BLACK);
				} catch (ClassNotFoundException noPrefs) {
					noPrefs.printStackTrace();
				} catch (IOException e) {
					try {
						objectIn.close();
						fileIn.close();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				} finally {
					if (fileIn != null) {
						try {
							objectIn.close();
							fileIn.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
					
				}
			}
		});
	}
	
	public void setFont (String f, int fs) {
		editor.setFont(new Font(f, Font.PLAIN, fs));
	}

	/**
	 * Action will perform when user click on the one of three JComboBoxes
	 * I created three new action listeners for each JComboBox to simplify GUI
	 * to serialize user's preferences
	 * Without SAVE and CANCEL buttons GUI is more user friendly
	 * 
	 * @author Boris Y.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}