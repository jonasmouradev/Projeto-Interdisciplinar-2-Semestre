package DAO;
public class Circuit {
    
    private int id;
    private String name;
    private double electricCharge;
    private int voltage;
    private int breaker;
    private double current;
    private double wireGauge;
    private int fk_users_id;;
    
    //Constructor Method
    public Circuit() {
        this.name=null;
        this.electricCharge = this.current = this.wireGauge = 0.0;
        this.id = this.voltage = this.breaker = 0;
    }
    public Circuit(int id,String name, double electricCharge, byte voltage, double current, double wireGauge) {
        this.name = name;
        this.electricCharge = electricCharge;
        this.current = current;
        this.wireGauge = wireGauge;
        this.voltage = voltage;
        this.fk_users_id=fk_users_id;
    }
    
    // Getter and Setter for fkId
    public int getFkId() {
        return fk_users_id;
    }
    public void setFkId(int fk_users_id) {
        this.fk_users_id = fk_users_id;
    }
    
    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
     // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    // Getter and Setter for electricCharge
    public double getElectricCharge() {
        return electricCharge;
    }
    public void setElectricCharge(double electricCharge) {
        this.electricCharge = electricCharge;
    }

    // Getter and Setter for voltage
    public int getVoltage() {
        return voltage;
    }
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    
    // Getter and Setter for breaker
    public int getBreaker() {
        return voltage;
    }
    public void setBreaker(int breaker) {
        this.breaker = breaker;
    }

    // Getter and Setter for current
    public double getCurrent() {
        return current;
    }
    public void setCurrent(double current) {
        this.current = current;
    }

    // Getter and Setter for wireGauge
    public double getWireGauge() {
        return wireGauge;
    }
    public void setWireGauge(double wireGauge) {
        this.wireGauge = wireGauge;
    }
}
