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

import typy.WierszOplaty;
import controller.ControllerWprowadzanieDanychOplaty;
import model.ModelBD;

public class WidokWprowadzanieDanychOplaty extends JDialog implements ActionListener{
	
	WierszOplaty wierszOplaty;
	
	JLabel textFieldId;
	JTextField textFieldData;
	JTextField textFieldOpis;
	JTextField textFieldTerminPlatnosci;
	JTextField textFieldNrFaktury;
	JTextField textFieldKwota;
	JCheckBox checkBoxStanAdministrator;
	JTextField textFieldDataOplaceniaAdministrator;
	JCheckBox checkBoxStanWynajmujacy;
	JTextField textFieldDataOplaceniaWynajmujacy;
	JButton anuluj;
	JButton zatwierdz;
	
	
	public WidokWprowadzanieDanychOplaty(JFrame owner, WierszOplaty wO, ModelBD modelBD){
		super(owner, "Wprowadzanie danych - Mieszkanie", true);
		wierszOplaty = new WierszOplaty();
		ControllerWprowadzanieDanychOplaty cwdo = new ControllerWprowadzanieDanychOplaty();
		if(wO == null)
		{
			wierszOplaty.setId(-1);
			wierszOplaty.setData("");
			wierszOplaty.setOpis("");
			wierszOplaty.setTerminPlatnosci("");
			wierszOplaty.setNrFaktury("");
			wierszOplaty.setKwota(-1.0);
			wierszOplaty.setStanAdministrator(false);
			wierszOplaty.setDataOplaceniaAdministrator("");
			wierszOplaty.setStanWynajmujacy(false);
			wierszOplaty.setDataOplaceniaWynajmujacy("");
		}
		else
		{
			wierszOplaty.setId(wO.getId());
			wierszOplaty.setData(wO.getData());
			wierszOplaty.setOpis(wO.getOpis());
			wierszOplaty.setTerminPlatnosci(wO.getTerminPlatnosci());
			wierszOplaty.setNrFaktury(wO.getNrFaktury());
			wierszOplaty.setKwota(wO.getKwota());
			wierszOplaty.setStanAdministrator(wO.getStanAdministrator());
			wierszOplaty.setDataOplaceniaAdministrator(wO.getDataOplaceniaAdministrator());
			wierszOplaty.setStanWynajmujacy(wO.getStanWynajmujacy());
			wierszOplaty.setDataOplaceniaWynajmujacy(wO.getDataOplaceniaWynajmujacy());
		}

		setLayout(null);
		JPanel panelDialogu = new JPanel(new GridLayout(11, 2));
		panelDialogu.setBorder(new EmptyBorder(10,10,10,10));
		JLabel labelId = new JLabel("Id");
		JLabel labelData = new JLabel("Data");
		JLabel labelOpis = new JLabel("Opis");
		JLabel labelTerminPlatnosci = new JLabel("Termin platnosci");
		JLabel labelNrFaktury = new JLabel("Numer faktury");
		JLabel labelKwota = new JLabel("Kwota");
		JLabel labelStanAdministrator = new JLabel("Stan oplacenia - Administrator");
		JLabel labelDataOplaceniaAdministrator = new JLabel("Data oplacenia - Administrator");
		JLabel labelStanWynajmujacy = new JLabel("Stan oplacenia - Wynajmujacy");
		JLabel labelDataOplaceniaWynajmujacy = new JLabel("Data oplacenia - Wynajmujacy");
		
		textFieldId = new JLabel(wierszOplaty.getId()==-1?"":Integer.toString(wierszOplaty.getId()));
		textFieldData = new JTextField(wierszOplaty.getData());
		textFieldOpis = new JTextField(wierszOplaty.getOpis());
		textFieldTerminPlatnosci = new JTextField(wierszOplaty.getTerminPlatnosci());
		textFieldNrFaktury = new JTextField(wierszOplaty.getNrFaktury());
		textFieldKwota = new JTextField(wierszOplaty.getKwota()==-1.0?"":Double.toString(wierszOplaty.getKwota()));
		checkBoxStanAdministrator = new JCheckBox();
		textFieldDataOplaceniaAdministrator = new JTextField(wierszOplaty.getDataOplaceniaAdministrator());
		checkBoxStanWynajmujacy = new JCheckBox();
		textFieldDataOplaceniaWynajmujacy = new JTextField(wierszOplaty.getDataOplaceniaAdministrator());

		if(wierszOplaty.getDataOplaceniaAdministrator().equals("")){
			checkBoxStanAdministrator.setSelected(false);
			textFieldDataOplaceniaAdministrator.setEditable(false);
		}
		else
		{
			checkBoxStanAdministrator.setSelected(true);
			textFieldDataOplaceniaAdministrator.setEditable(true);
		}
		if(wierszOplaty.getDataOplaceniaWynajmujacy().equals("")){
			checkBoxStanWynajmujacy.setSelected(false);
			textFieldDataOplaceniaWynajmujacy.setEditable(false);
		}
		else
		{
			checkBoxStanAdministrator.setSelected(true);
			textFieldDataOplaceniaWynajmujacy.setEditable(true);
			
		}
		
		checkBoxStanAdministrator.addActionListener(this);
		checkBoxStanWynajmujacy.addActionListener(this);
		
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
		panelDialogu.add(labelNrFaktury);
		panelDialogu.add(textFieldNrFaktury);
		panelDialogu.add(labelKwota);
		panelDialogu.add(textFieldKwota);
		panelDialogu.add(labelStanAdministrator);
		panelDialogu.add(checkBoxStanAdministrator);
		panelDialogu.add(labelDataOplaceniaAdministrator);
		panelDialogu.add(textFieldDataOplaceniaAdministrator);
		panelDialogu.add(labelStanWynajmujacy);
		panelDialogu.add(checkBoxStanWynajmujacy);
		panelDialogu.add(labelDataOplaceniaWynajmujacy);
		panelDialogu.add(textFieldDataOplaceniaWynajmujacy);
		panelDialogu.add(anuluj);
		panelDialogu.add(zatwierdz);
		cwdo.addView(this);
		cwdo.addModel(modelBD);
		zatwierdz.addActionListener(cwdo);
		anuluj.addActionListener(this);
		
		setContentPane(panelDialogu);
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	};
	
	public void actionPerformed(ActionEvent e){ //Co ja pacze...
		if 
		(e.getSource() == checkBoxStanAdministrator){
			if(checkBoxStanAdministrator.isSelected()){
				textFieldDataOplaceniaAdministrator.setEditable(true);
			}
				else{
					textFieldDataOplaceniaAdministrator.setEditable(false);
				}
			}
		else if (e.getSource() == checkBoxStanWynajmujacy){
			if(checkBoxStanWynajmujacy.isSelected()){
				textFieldDataOplaceniaWynajmujacy.setEditable(true);
			}
				else{
					textFieldDataOplaceniaWynajmujacy.setEditable(false);
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
	
	public WierszOplaty getWierszOplaty(){
		return this.wierszOplaty;	
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

	public JTextField getTextFieldNrFaktury() {
		return textFieldNrFaktury;
	}

	public JTextField getTextFieldKwota() {
		return textFieldKwota;
	}

	public JTextField getTextFieldDataOplaceniaAdministrator() {
		return textFieldDataOplaceniaAdministrator;
	}

	public JTextField getTextFieldDataOplaceniaWynajmujacy() {
		return textFieldDataOplaceniaWynajmujacy;
	}

	public JCheckBox getCheckBoxStanAdministrator() {
		return checkBoxStanAdministrator;
	}

	public JCheckBox getCheckBoxStanWynajmujacy() {
		return checkBoxStanWynajmujacy;
	}
	
}