package DAO;

public class Device {
    
    private int id;
    private String name;
    private int power;
    private int voltage;
    private double totConsumption;
    private double usedHours;
    private int fk_users_id;
    
    //Constructor Method
    public Device(){
        this.fk_users_id=this.id=this.power=this.voltage=0;
        this.name=null;
        this.totConsumption=this.usedHours=0.0;
    }
    public Device(int id,String name,int power,int voltage,double totConsumption,double usedHours){
        this.id=id;
        this.power=power;
        this.voltage=id;
        this.name=name;
        this.totConsumption= totConsumption;
        this.usedHours=usedHours;
        this.fk_users_id=fk_users_id;
    }
    
    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter and Setter for fkId
    public int getFkId() {
        return fk_users_id;
    }
    public void setFkId(int fk_user_id) {
        this.fk_users_id = fk_user_id;
    }
    
    // Getter and Setter for name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // Getter and Setter for power
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }
    
    // Getter and Setter for voltage
    public int getVoltage() {
        return voltage;
    }
    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
    
     // Getter and Setter for totConsumption
    public double getTotConsumption() {
        return totConsumption;
    }
    public void setTotConsumption(double totConsumption) {
        this.totConsumption = totConsumption;
    }
    
     // Getter and Setter for usedHours
    public double getUsedHours() {
        return usedHours;
    }
    public void setUsedHours(double usedHours) {
        this.usedHours = usedHours;
    }
}
