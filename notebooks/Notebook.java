package homework.notebooks;

// import javax.net.ssl.HandshakeCompletedEvent;

public class Notebook {
    private int ram;
    private int ssd;
    private int hdd;
    private String model;
    private String brand;
    private String color;
    private String os;

    public Notebook(int ram,
                    int ssd,
                    int hdd,
                    String model, 
                    String brand,
                    String color,
                    String os){
        this.ram=ram;
        this.ssd=ssd;
        this.hdd=hdd;
        this.model=model;
        this.brand=brand;
        this.color=color;
        this.os=os;
    }

    public int getRam() {
        return ram;
    }
    public int getHdd() {
        return hdd;
    }
    public int getSsd() {
        return ssd;
    }
    public String getBrand() {
        return brand;
    }
    public String getColor() {
        return color;
    }
    public String getModel() {
        return model;
    }
    public String getOs() {
        return os;
    }


    @Override
    public int hashCode(){
        int first=1;
        int second=1;
        int last=0;
        for(int i=0;i<model.length();i++){
            first+=model.charAt(i);
        }
        for(int i=0;i<brand.length();i++){
            second+=brand.charAt(i);
        }
        last=first*second;
        return last;
    }


    @Override
    public String toString(){
        return "brand: "+brand+"\t model: "+model+"\t os:"+os+"\t ram: "+ram+"\t hdd: "+hdd+"\t ssd: "+ssd;
    }


    @Override
    public boolean equals(Object obj){
        if(obj==this){
            return true;
        }
        if(obj==null || obj.getClass()!=this.getClass()){

        }
        Notebook note=(Notebook) obj;
        if(brand.equals(note.brand)&&
            color.equals(note.color)&&
            hdd == note.hdd &&
            ssd == note.ssd &&
            ram == note.ram &&
            os.equals(note.os) &&
            model.equals(note.model)
        ){
            return true;
        }
        else return false;
    }

}
