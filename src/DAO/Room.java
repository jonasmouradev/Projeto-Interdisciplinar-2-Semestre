package DAO;

public class Room {

    private int id;
    private String name;
    private String type;
    private float area;
    private float perimeter;
    private int totTUG;
    private int totTUE;
    private int totLamp;
    private int fk_house_id; 

    //Constructor Method
    public Room() {
        this.name = null;
        this.id  = this.totTUG = this.totTUE = this.totLamp = 0;
        this.area = this.perimeter = 0.0f;
    }
    public Room(String name,String type,float area,float perimeter,int totLamp,int totTUG,int totTUE,int totIlu) {
        this.name = name;
        this.type = type;
        this.area = area;
        this.perimeter = perimeter;
        this.totLamp = totLamp;
        this.totTUG =  totTUG;
        this.totTUE = totTUE;
        this.fk_house_id=fk_house_id;
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
    
    // Getter and Setter for type
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for area
    public float getArea() {
        return area;
    }
    public void setArea(float area) {
        this.area = area;
    }

    // Getter and Setter for perimeter
    public float getPerimeter() {
        return perimeter;
    }
    public void setPerimeter(float perimeter) {
        this.perimeter = perimeter;
    }
    
    // Getter and Setter for total TUG
    public int getTotTUG() {
        return totTUG;
    }
    public void setTotTUG(float totTUG) {
        this.totTUG = (int) totTUG;
    }

    // Getter and Setter for total TUE
    public int getTotTUE() {
        return totTUE;
    }
    public void setTotTUE(float totTUE) {
        this.totTUE = (int) totTUE;
    }

    // Getter and Setter for total Lamp
    public int getTotLamp() {
        return totLamp;
    }
    public void setTotLamp(float totLamp) {
        this.totLamp = (int) totLamp;
    }
    
    // Getter and Setter for fkId
    public int getFkId() {
        return fk_house_id;
    }
    public void setFkId(int fk_house_id) {
        this.fk_house_id = fk_house_id;
    }
}
