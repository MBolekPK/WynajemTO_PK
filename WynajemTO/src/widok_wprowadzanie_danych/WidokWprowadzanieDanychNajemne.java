package widok_wprowadzanie_danych;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

import typy.WierszNajemne;
import controller.ControllerWprowadzanieDanychNajemne;
import model.ModelBD;

public class WidokWprowadzanieDanychNajemne extends JDialog implements ActionListener{
	
	private WierszNajemne wierszNajemne;
	
	private JLabel textFieldId;
	private JTextField textFieldData;
	private JTextField textFieldOpis;
	private JTextField textFieldTerminPlatnosci;
	private JTextField textFieldKwota;
	private JCheckBox checkBoxStan;
	private JTextField textFieldDataOplacenia;
	private JButton anuluj;
	private JButton zatwierdz;
	
	
	public WidokWprowadzanieDanychNajemne(JFrame owner, WierszNajemne wN, ModelBD modelBD){
		super(owner, "Wprowadzanie danych - Najemne", true);
		wierszNajemne = new WierszNajemne();
		ControllerWprowadzanieDanychNajemne cwdn = new ControllerWprowadzanieDanychNajemne();
		cwdn.addView(this);
		if(wN == null)
		{
			wierszNajemne.setId(-1);
			wierszNajemne.setData("");
			wierszNajemne.setOpis("");
			wierszNajemne.setTerminPlatnosci("");
			wierszNajemne.setKwota(-1.0);
			wierszNajemne.setStan(false);
			wierszNajemne.setDataOplacenia("");
		}
		else
		{
			wierszNajemne.setId(wN.getId());
			wierszNajemne.setData(wN.getData());
			wierszNajemne.setOpis(wN.getOpis());
			wierszNajemne.setTerminPlatnosci(wN.getTerminPlatnosci());
			wierszNajemne.setKwota(wN.getKwota());
			wierszNajemne.setStan(wN.getStan());
			wierszNajemne.setDataOplacenia(wN.getDataOplacenia());
		}
		
		setLayout(null);
		JPanel panelDialogu = new JPanel(new GridLayout(8, 2));
		panelDialogu.setBorder(new EmptyBorder(10,10,10,10));
		JLabel labelId = new JLabel("Id");
		JLabel labelData = new JLabel("Data");
		JLabel labelOpis = new JLabel("Opis");
		JLabel labelTerminPlatnosci = new JLabel("Termin platnosci");
		JLabel labelKwota = new JLabel("Kwota");
		JLabel labelStan = new JLabel("Stan oplacenia");
		JLabel labelDataOplacenia = new JLabel("Data oplacenia");
		
		textFieldId = new JLabel(wierszNajemne.getId()==-1?"":Integer.toString(wierszNajemne.getId()));
		textFieldData = new JTextField(wierszNajemne.getData());
		textFieldOpis = new JTextField(wierszNajemne.getOpis());
		textFieldTerminPlatnosci = new JTextField(wierszNajemne.getTerminPlatnosci());
		textFieldKwota = new JTextField(wierszNajemne.getKwota()==-1.0?"":Double.toString(wierszNajemne.getKwota()));
		checkBoxStan = new JCheckBox();
		textFieldDataOplacenia = new JTextField(wierszNajemne.getDataOplacenia());
		if(wierszNajemne.getDataOplacenia().equals("")){
			checkBoxStan.setSelected(false);
			textFieldDataOplacenia.setEditable(false);
		}
		else
		{
			checkBoxStan.setSelected(true);
			textFieldDataOplacenia.setEditable(true);
		}
		
		checkBoxStan.addActionListener(this);
		checkBoxStan.addActionListener(this);
		
		anuluj = new JButton("Anuluj");
		zatwierdz = new JButton("Ok");
		
		panelDialogu.add(labelId);
		panelDialogu.add(textFieldId);
		panelDialogu.add(labelData);
		panelDialogu.add(textFieldData);
		panelDialogu.add(labelOpis);
		panelDialogu.add(textFieldOpis);
		panelDialogu.add(labelTerminPlatnosci);
		panelDialogu.add(textFieldTerminPlatnosci);
		panelDialogu.add(labelKwota);
		panelDialogu.add(textFieldKwota);
		panelDialogu.add(labelStan);
		panelDialogu.add(checkBoxStan);
		panelDialogu.add(labelDataOplacenia);
		panelDialogu.add(textFieldDataOplacenia);
		panelDialogu.add(anuluj);
		panelDialogu.add(zatwierdz);
		cwdn.addView(this);
		cwdn.addModel(modelBD);
		zatwierdz.addActionListener(cwdn);
		anuluj.addActionListener(this);
		
		setContentPane(panelDialogu);
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){ //Co ja pacze...
		if 
		(e.getSource() == checkBoxStan){
			if(checkBoxStan.isSelected()){
				textFieldDataOplacenia.setEditable(true);
			}
				else{
					textFieldDataOplacenia.setEditable(false);
				}
			}

		else if (e.getSource() == anuluj)
		{
			this.dispose();
		}
	}
	public void pokazOknoDialogoweBD()
	{
		JOptionPane.showMessageDialog(this, "Prosze wypelnic wszystkie pola obowiazkowe.");	
	}
	public void pokazOknoDialogoweND()
	{
		JOptionPane.showMessageDialog(this, "Prosze wprowadzic poprawne dane.");
	}
	
	public WierszNajemne getWierszNajemne(){
		return this.wierszNajemne;	
	}

	public JLabel getTextFieldId() {
		return textFieldId;
	}

	public JTextField getTextFieldData() {
		return textFieldData;
	}

	public JTextField getTextFieldOpis() {
		return textFieldOpis;
	}

	public JTextField getTextFieldTerminPlatnosci() {
		return textFieldTerminPlatnosci;
	}

	public JTextField getTextFieldKwota() {
		return textFieldKwota;
	}

	public JTextField getTextFieldDataOplacenia() {
		return textFieldDataOplacenia;
	}

	public JCheckBox getCheckBoxStan() {
		return checkBoxStan;
	}

}
