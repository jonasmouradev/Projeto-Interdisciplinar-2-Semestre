package DAO;

public class Materials {
    private int id,totDR,totDTM,totDPS,totLamp,totTUG,switchboard,totTUE,wireGauge,fk_users_id;
    
    //Constructor Method
    public Materials(){
        this.totTUE=this.switchboard=this.totTUG=this.totLamp=this.totDPS=this.totDTM=this.totDR=this.wireGauge=this.fk_users_id=0;
    }
    public Materials(int fk_users_id, int totDR,int totDTM,int totDPS,int totLamp,int totTUG,int switchboard,int totTUE,int wireGauge){
        this.wireGauge=wireGauge;
        this.totTUE=totTUE;
        this.switchboard=switchboard;
        this.totTUG=totTUG;
        this.totLamp=totLamp;
        this.totDPS=totDPS;
        this.totDTM=totDTM;
        this.totDR=totDR;
        this.fk_users_id=fk_users_id;
    }
    
    // Getter and Setter for id
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for fkId
    public int getFkId() {
        return fk_users_id;
    }
    public void setFkId(int fk_users_id) {
        this.fk_users_id = fk_users_id;
    }
    
     // Getter and setter for totDR
    public int getTotDR() {
        return totDR;
    }
    public void setTotDR(int totDR) {
        this.totDR = totDR;
    }

    // Getter and setter for totDTM
    public int getTotDTM() {
        return totDTM;
    }
    public void setTotDTM(int totDTM) {
        this.totDTM = totDTM;
    }

    // Getter and setter for totDPS
    public int getTotDPS() {
        return totDPS;
    }
    public void setTotDPS(int totDPS) {
        this.totDPS = totDPS;
    }

    // Getter and setter for totLamp
    public int getTotLamp() {
        return totLamp;
    }
    public void setTotLamp(int totLamp) {
        this.totLamp = totLamp;
    }

    // Getter and setter for totTUG
    public int getTotTUG() {
        return totTUG;
    }
    public void setTotTUG(int totTUG) {
        this.totTUG = totTUG;
    }

    // Getter and setter for switchboard
    public int getSwitchboard() {
        return switchboard;
    }
    public void setSwitchboard(int switchboard) {
        this.switchboard = switchboard;
    }

    // Getter and setter for totTUE
    public int getTotTUE() {
        return totTUE;
    }
    public void setTotTUE(int totTUE) {
        this.totTUE = totTUE;
    }
    
    // Getter and setter for wireGauge
    public int getWireGauge() {
        return wireGauge;
    }
    public void setWireGauge(int wireGauge) {
        this.wireGauge = wireGauge;
    }
}
