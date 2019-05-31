package GUI;

public class Main {

	public static void main(String[] args) {
		try {
			VentanaCajero v = new VentanaCajero();
			v.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
