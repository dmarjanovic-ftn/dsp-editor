package model;

public class SourceSine extends Component {
	private double amplitude;
	private double offset;
	private double frequency;
	private double phase;

	public SourceSine() {
		super();
	}

	public SourceSine(String name, String description, double amplitude,
			double offset, double frequency, double phase) {
		super(name, description);
		this.amplitude = amplitude;
		this.offset = offset;
		this.frequency = frequency;
		this.phase = phase;
	}

	public double getAmplitude() {
		return amplitude;
	}

	public void setAmplitude(double newAmplitude) {
		amplitude = newAmplitude;
	}

	public double getOffset() {
		return offset;
	}

	public void setOffset(double newOffset) {
		offset = newOffset;
	}

	public double getFrequency() {
		return frequency;
	}

	public void setFrequency(double newFrequency) {
		frequency = newFrequency;
	}

	public double getPhase() {
		return phase;
	}

	public void setPhase(double newPhase) {
		phase = newPhase;
	}
	

	public void update(String name, String amplitude, String offset, String frequency, String phase) {
		super.update(name);
		if (!amplitude.equals("")) {
			try {
				this.amplitude = Double.parseDouble(amplitude);
			} catch (Exception e) {
			}
		}
		if (!offset.equals("")) {
			try {
				this.offset = Double.parseDouble(offset);
			} catch (Exception e) {
			}
		}
		if (!amplitude.equals("")) {
			try {
				this.frequency = Double.parseDouble(frequency);
			} catch (Exception e) {
			}
		}
		if (!phase.equals("")) {
			try {
				this.phase = Double.parseDouble(phase);
			} catch (Exception e) {
			}
		}
	}
}