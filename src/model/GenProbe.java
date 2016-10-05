package model;

public class GenProbe extends Component {
	private String address;

	public GenProbe() {
	}

	public GenProbe(String name, String description, String address) {
		super(name, description);
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String newAddress) {
		address = newAddress;
	}

	public void update(String name, String addr) {
		super.update(name);
		if (!addr.equals("")) {
			this.address = addr;
		}
	}
}