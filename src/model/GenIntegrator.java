package model;

public class GenIntegrator extends Component {
	private double initValue;

	public GenIntegrator() {
		super();
	}

	public GenIntegrator(String name, String description, double initValue) {
		super(name, description);
		this.initValue = initValue;
	}

	public double getInitValue() {
		return initValue;
	}

	public void setInitValue(double newInitValue) {
		initValue = newInitValue;
	}

	public void update(String name, String initValue) {
		super.update(name);
		if (!initValue.equals("")) {
			try {
				this.initValue = Double.parseDouble(initValue);
			} catch (Exception e) {

			}
		}
	}
}