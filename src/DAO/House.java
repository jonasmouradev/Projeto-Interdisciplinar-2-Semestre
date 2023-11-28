package DAO;

public class House {
    
    private int id;
    private String name;
    private int totCircuit;
    private int totRoom;
    private int totConsumption;
    private int totDevices;
    private int totPower;
    private int totCharge;
    private double maximumDemand;
    private double totDemand;
    private double demandFactor;
    private byte totPhase;
    private int fk_house;
    
    
    //Constructor Method
    public House() {
        this.id=this.totDevices=this.totPower=this.totCharge=this.totRoom=this.totConsumption=this.totCircuit=0;
        this.name=null;
        this.maximumDemand=this.totDemand=this.demandFactor=0;
        this.totPhase=0;
    }
    public House (int id,String name,int totDevices,int totPower,int totCharge,int totRoom,double maximumDemand,double totalDemand,double demandFactor,int totCircuit,int totConsumption,byte totPhase){
        this.id=id;
        this.name=name;
        this.totDevices=totDevices;
        this.totPower=totPower;
        this.totCharge=totCharge;
        this.totRoom=totRoom;
        this.totConsumption=totConsumption;
        this.totCircuit=totCircuit;
        this.maximumDemand=maximumDemand;
        this.totDemand=totalDemand;
        this.demandFactor=demandFactor;
        this.totPhase=totPhase;
    }
    
    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    // Getter and Setter for name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    
    // Getter and Setter for totCircuit
    public int getTotCircuit() {
        return totCircuit;
    }
    public void setTotCircuit(int totCircuit) {
        this.totCircuit = totCircuit;
    }
    
    // Getter and Setter for totRoom
    public int getTotRoom() {
        return totRoom;
    }
    public void setTotRoom(int totRoom) {
        this.totRoom = totRoom;
    }
    
    // Getter and Setter for totConsumption
    public int getTotConsumption() {
        return totConsumption;
    }
    public void setTotConsumption(int totConsumption) {
        this.totConsumption = totConsumption;
    }
    
    // Getter and Setter for totDevices
    public int getTotDevices() {
        return totDevices;
    }
    public void setTotDevices(int totDevices) {
        this.totDevices = totDevices;
    }
    
    // Getter and Setter for totPower
    public int getTotPower() {
        return totPower;
    }
    public void setTotPower(int power) {
        this.totPower = power;
    }
    
    // Getter and Setter for totCharge
    public int getTotCharge() {
        return totCharge;
    }
    public void setTotCharge(int charge) {
        this.totCharge = charge;
    }
    
    // Getter and Setter for maximumDemand
    public double getMaximumDemand() {
        return maximumDemand;
    }
    public void setMaximumDemand(double maximumDemand) {
        this.maximumDemand = maximumDemand;
    }

    // Getter and Setter for totDemand
    public double getTotDemand() {
        return totDemand;
    }
    public void setTotDemand(double totalDemand) {
        this.totDemand = totalDemand;
    }

    // Getter and Setter for demandFactor
    public double getDemandFactor() {
        return demandFactor;
    }
    public void setDemandFactor(double demandFactor) {
        this.demandFactor = demandFactor;
    }
    
    //Getter and Setter for totPhase
    public int getTotPhase() {
        return totPhase;
    }
    public void setTotPhase(int totPhase) {
        this.totPhase = (byte) totPhase;
    }

    //Getter and Setter for fk_house
    public int getFk_house() {
        return fk_house;
    }
    public void setFk_house(int fk_house) {
        this.fk_house = fk_house;
    }
}
