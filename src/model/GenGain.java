package model;

public class GenGain extends Component {
	private double gain;
	
	public GenGain() {
		super();
	}

	public GenGain(String name, String description, double gain) {
		super(name, description);
		this.gain = gain;
	}

	public double getGain() {
		return gain;
	}

	public void setGain(double gain) {
		this.gain = gain;
	}

	public void update(String name, String gain) {
		super.update(name);
		if (!gain.equals("")) {
			try {
				this.gain = Double.parseDouble(gain);
			} catch (Exception e) {

			}
		}
	}
}
