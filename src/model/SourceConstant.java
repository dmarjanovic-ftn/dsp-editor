package model;

public class SourceConstant extends Component {
	private double value;

	public SourceConstant() {
	}

	public SourceConstant(String name, String description, double value) {
		super(name, description);
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double newValue) {
		value = newValue;
	}
	

	public void update(String name, String value) {
		super.update(name);
		if (!value.equals("")) {
			try {
				this.value = Double.parseDouble(value);
			} catch (Exception e) {

			}
		}
	}
}
