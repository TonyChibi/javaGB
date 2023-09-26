package homework.notebooks;
import java.util.*;


public class program {
    public static void main(String []args){
        

   
    Notebook pavilion = new Notebook(16, 256, 0, "xs234", "hp", "black", "none");
    Notebook jora = new Notebook(2, 0, 500, "ewew", "hp", "grey", "windows" );
    Notebook fedor = new Notebook( 12, 0, 1000, "kwas", "haier", "purple", "linux");
    Notebook senya = new Notebook (8, 128,  500, "liter", "asus", "black", "windows");
    Notebook mentor = new Notebook( 6, 256, 0, "asiris", "apple", "white", "macOS");
    Notebook ilia = new Notebook(4, 500, 500, "baunty", "lenovo", "yellow", "linux");

    Notebook igor = new Notebook(16, 256, 0, "xs234", "hp", "black", "none");
    Notebook vanila = new Notebook( 12, 256, 0, "asiris", "apple", "white", "macOS");

    Set <Notebook> notebooks = new HashSet<>();
    notebooks.add(pavilion);
    notebooks.add(jora);
    notebooks.add(fedor);
    notebooks.add(senya);
    notebooks.add(mentor);
    notebooks.add(ilia);
    notebooks.add(igor);
    notebooks.add(vanila);

    Set <Notebook> filteredSet= new HashSet<>();
    filteredSet.addAll(notebooks);

    for(Object item: filteredSet){
        System.out.println(item.toString());
    }

    Scanner scanner= new Scanner(System.in);
    
    
    while(state){
        filterApi(filteredSet, scanner);
    }
    scanner.close();

    }
    // there goes the program
  
   public static boolean isRam(Notebook note, int ram){
        if(note.getRam()>=ram) return true;
        else return false;
    }
    public static boolean isSSd(Notebook note, int ssd){
        if(note.getSsd()>=ssd) return true;
        else return false;
    }
     public static boolean isHdd(Notebook note, int hdd){
        if(note.getHdd()>=hdd) return true;
        else return false;
    }
     public static boolean isModel(Notebook note, String model){
        if(note.getModel().toLowerCase().equals(model)) return true;
        else return false;
    }
    public static boolean isBrand(Notebook note, String brand){
        if(note.getBrand().toLowerCase().equals(brand)) return true;
        else return false;
    }
    public static boolean isOs(Notebook note, String os){
        if(note.getOs().toLowerCase().equals(os)) return true;
        else return false;
    }
    public static boolean isColor(Notebook note, String color){
        if(note.getColor().toLowerCase().equals(color)) return true;
        else return false;
    }

    static boolean state=true;

    public static void filterApi(Set<Notebook> ntbks, Scanner scanner){
        String [] options={"show","filter","stop"};
        String [] filters={"ram","ssd","hdd","brand","color","model","os"};
        Set<Notebook> tempSet=new HashSet<>();
        

        System.out.println("what you gonna do? \ninsert the number");
        for(int i=0; i<Arrays.asList(options).size();i++){
            System.out.printf("[%d] - %s\n", 1+i, options[i]);
        }
        String option=scanner.next();
        switch(option){
            case "3":
                state=false;
                break;
            case "1":
                for(Object item: ntbks){
                System.out.println(item.toString());
                }
                break;
            case "2":
            
                System.out.println("which filter do you want to imply? \nprint the number");
                for(int i=0; i<Arrays.asList(filters).size();i++){
                    System.out.printf("[%d] - %s\n", 1+i, filters[i]);
                }
                String choise=scanner.next();
                switch(choise){
                    case "1": 
                        
                        for(Notebook item: ntbks){
                            System.out.printf("%d\t", item.getRam());
                            
                        }
                        System.out.println();
                        System.out.println("print the number of lesser parameter");
                        if(scanner.hasNextInt()){
                            choise=scanner.next();
                        
                            
                            for(Notebook item: ntbks){
                                if(isRam(item, Integer.parseInt(choise))){
                                    tempSet.add(item);
                                }
                            }
                            if(tempSet.isEmpty()){
                                System.out.println("sorry, we cannot match "+choise);
                            }else{
                                ntbks.clear();
                                ntbks.addAll(tempSet);
                            }
                        }
                        else
                        break;
                    case "2": 
                       
                        for(Notebook item: ntbks){
                            System.out.printf("%d\t", item.getSsd());
                            
                        }
                        System.out.println();
                         System.out.println("print the number of lesser parameter");
                        choise=scanner.next();
                        for(Notebook item: ntbks){
                            if(isSSd(item, Integer.parseInt(choise))){
                                tempSet.add(item);
                            }
                        }
                        if(tempSet.isEmpty()){
                            System.out.println("sorry, we cannot match "+choise);
                        }else{
                            ntbks.clear();
                            ntbks.addAll(tempSet);
                        }
                        break;
                    case "3": 
                        
                        for(Notebook item: ntbks){
                            System.out.printf("%d\t", item.getHdd());
                            
                        }

                        System.out.println();
                        System.out.println("print the number of lesser parameter");
                        choise=scanner.next();

                        for(Notebook item: ntbks){
                            if(isHdd(item, Integer.parseInt(choise))){
                                tempSet.add(item);
                            }
                        }
                        if(tempSet.isEmpty()){
                            System.out.println("sorry, we cannot match "+choise);
                        }else{
                            ntbks.clear();
                            ntbks.addAll(tempSet);
                        }
                        break;
                    case "4": 
                       
                        for(Notebook item: ntbks){
                            System.out.printf("%s\t", item.getColor());
                            
                        }
                        System.out.println();
                         System.out.println("print the color ");
                        choise=scanner.next().toLowerCase();
                        for(Notebook item: ntbks){
                            if(isColor(item, choise)){
                                tempSet.add(item);
                            }
                        }
                        if(tempSet.isEmpty()){
                            System.out.println("sorry, we cannot match "+choise);
                        }else{
                            ntbks.clear();
                            ntbks.addAll(tempSet);
                        }
                        break;
                    case "5": 
                        
                        for(Notebook item: ntbks){
                            System.out.printf("%s\t", item.getBrand());
                            
                        }
                            System.out.println();
                            System.out.println("print the brand");
                        choise=scanner.next().toLowerCase();
                        for(Notebook item: ntbks){
                            if(isBrand(item, choise)){
                                tempSet.add(item);
                            }
                        }
                        if(tempSet.isEmpty()){
                            System.out.println("sorry, we cannot match "+choise);
                        }else{
                            ntbks.clear();
                            ntbks.addAll(tempSet);
                        }
                        break;
                    case "6": 
                        
                        for(Notebook item: ntbks){
                            System.out.printf("%s\t", item.getModel());
                            
                        }
                            System.out.println();
                            System.out.println("print the model");
                        choise=scanner.next().toLowerCase();
                        for(Notebook item: ntbks){
                            if(isModel(item, choise)){
                                tempSet.add(item);
                            }
                        }if(tempSet.isEmpty()){
                            System.out.println("sorry, we cannot match "+choise);
                        }else{
                            ntbks.clear();
                            ntbks.addAll(tempSet);
                        }
                        break;
                    case "7": 
                        
                        for(Notebook item: ntbks){
                            System.out.printf("%s\t", item.getOs());
                            
                        }
                        System.out.println();
                        System.out.println("print the os");
                        choise=scanner.next().toLowerCase();
                        for(Notebook item: ntbks){
                            if(isOs(item, choise)){
                                tempSet.add(item);
                            }
                        }
                        if(tempSet.isEmpty()){
                            System.out.println("sorry, we cannot match "+choise);
                        }else{
                            ntbks.clear();
                            ntbks.addAll(tempSet);
                        }
                        break;
                    default:
                        state=false;
                        break;
                }
                
                break;

            default:
                state=false;
                break;
                
        }
       

     
    }

  public void showConjunction(Notebook note, String param){
    
    
}
}
