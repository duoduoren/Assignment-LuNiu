package assignment4;

class IpAddress { // score 2
	int[] octets;
	String dottedDecimal;
	String IpAddress;
	
	// Suppose ip is well formatted dotted-decimal ip.
	public IpAddress(String ip) {
		this.IpAddress = ip;
		
		String[] octets = ip.split(".");

		// Initializes array before using it.
		this.octets = new int[4];
		
		// Put each octet to an Array.
		this.octets[0] = Integer.parseInt(octets[0]);
		this.octets[1] = Integer.parseInt(octets[1]);
		this.octets[2] = Integer.parseInt(octets[2]);
		this.octets[3] = Integer.parseInt(octets[3]);
	}
	
	public void setDottedDecimal(String IpAdress) {
		this.IpAddress = IpAdress;
	}

	public String getDottedDecimal() {
	    	return this.IpAddress; 	
	}
	
	// Gets the octet according to the position.
	public int getOctet(int position) {
		return this.octets[position - 1];
	}


	static void main(String[] args){
		IpAddress ip = new IpAddress("216.27.6.136");
		System.out.println(ip.getDottedDecimal());
		System.out.println(ip.getOctet(4));
		System.out.println(ip.getOctet(1));
		System.out.println(ip.getOctet(3));
		System.out.println(ip.getOctet(2));
	}
}

