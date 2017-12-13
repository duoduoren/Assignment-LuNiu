package assignment7;

// 3.
class Device { // score 2
	
    public void startup() {  
    		System.out.println("Deveice started");
    }
    
    public void shutdown() {
    		System.out.println("Device shutting down due to maintanance");
	}
}
    
class Sensor extends Thread {
    private final Device device;
    //private Sensor heat, pressure;
    private double value;
    public Sensor(Device device) {
        this.device = device;
    }
    
    public double getValue() {
        return value;
    }
    
    public void updateValue() { 
        this.value += 0.001;
    }
    
    public void run() {
        	while(true) {
        		synchronized (this) {
        			this.updateValue();
        			notify();
        		}        		
        	}
    }     
}

class Controller extends Thread {
    	Device device;
    	Sensor heat, pressure;
  
    public static void main(String[] args) {
        Device device = new Device();
        Sensor heat = new Sensor(device);
        Sensor pressure = new Sensor(device);

        Controller controller = new Controller(device, heat, pressure);

        controller.start();
        heat.start();
        pressure.start();
    }
        
    	public Controller(Device device, Sensor heat, Sensor pressure) {
        this.device = device;
        this.heat = heat;
        this.pressure = pressure;
       
    	}
    	
    	public void run() {
    		device.startup();
    		while (true) {
			synchronized(this.heat) {
				try {
					this.heat.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (this.heat.getValue() > 70 || this.pressure.getValue() >= 100) {
					device.shutdown();
					return;
				}
				
				System.out.println("heat -> " + this.heat.getValue() + "," + " pressure -> " + this.pressure.getValue());
			}
			
			synchronized(this.pressure) {
				try {
					this.pressure.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (this.heat.getValue() > 70 || this.pressure.getValue() >= 100) {
					device.shutdown();
					return;
				}
				
				System.out.println("heat -> " + this.heat.getValue() + "," + " pressure -> " + this.pressure.getValue());
			}
    		}
    	}
}	
