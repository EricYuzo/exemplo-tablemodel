package devsv.exemplo.tablemodel;

import java.awt.EventQueue;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class SocioTableModelTest extends JFrame {

	private JTable tblSocios;
	private SocioTableModel tableModel;
	
	public SocioTableModelTest() {
		super("SocioTableModelTest");
		initialize();
	}

	private void initialize() {
		setSize(400, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new JScrollPane(getTblSocios()));
	}

	private JTable getTblSocios() {
		if (tblSocios == null) {
			tblSocios = new JTable();
			tblSocios.setModel(getTableModel());
			tblSocios.setDefaultRenderer(BigDecimal.class, new MensalidadeCellRenderer());
			tblSocios.setFillsViewportHeight(true);
		}
		return tblSocios;
	}

	private SocioTableModel getTableModel() {
		if (tableModel == null) {
			tableModel = new SocioTableModel(criaSocios());
		}
		return tableModel;
	}

	// cria uma lista com 5 sócios meramente ilustrativos
	private List<Socio> criaSocios() {
		List<Socio> socios = new ArrayList<Socio>();
		for (int i = 1; i <= 5; i++) {
			Socio socio = new Socio();
			socio.setNome("Nome" + i);
			socio.setEndereco("Endereço" + i);
			socio.setAtivo(true);
			socio.setMensalidade(new BigDecimal(i * 10));
			socios.add(socio);
		}
		return socios;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SocioTableModelTest().setVisible(true);
			}
		});
	}

}
