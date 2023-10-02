package homework.oopN1;

import java.util.ArrayList;
import java.util.Scanner;

public class program {
    public void main(String[]args){

        Category brushes=new Category("brushes");
        Product brush = new Product("brush", 12.0);
        Product brush1 = new Product("brush", 12.1);
        Product brush2 = new Product("brush", 12.0);
        Product brush3 = new Product("brush", 12.3);
        Product brush4 = new Product("brush", 12.0);
        brushes.add(brush);
        brushes.add(brush1);
        brushes.add(brush2);
        brushes.add(brush3);
        brushes.add(brush4);

        Category cats=new Category("cats");
        Product cat=new Product("tom", 21.10);
        Product cat1=new Product("tommy", 21.13);
        Product cat2=new Product("tomas", 21234.10);
        Product cat3=new Product("tomchik", 1.10);
        Product cat4=new Product("toma", 22.10);
        cats.add(cat);
        cats.add(cat1);
        cats.add(cat2);
        cats.add(cat3);
        cats.add(cat4);

        greetings();
    }
//    The end of a main
//    The Program is below
    Scanner scanner=new Scanner(System.in);
    ArrayList<User> users;
    ArrayList<Product> prods;
    ArrayList<Category> categories;
    public void greetings(){
        System.out.println("hello! login - 1 \nnew account - 2 \nexit - 3");
        int answer=0;
        while (answer==0){
        answer=getAnswer(1,3);
        }
        switch (answer){
            case 1:
                login(users);
                break;
            case 2:
                User user=newUser();
                mainMenu(user);
                break;
            case 3:
                System.out.println("see ya!");


        }
    }

    /**
     * method to login
      * @param users the array of users
     * @return true if the login exist and the password is rigth otherwise false
     */
    public void login(ArrayList<User> users){
        System.out.println("type the login of a user: ");
        String login=scanner.nextLine();
        for(User item: users){
            if (item.getLogin().equals(login)){
                System.out.println("type the password");
                String password=scanner.nextLine();
                if(item.password.equals(password)){
                    mainMenu(item);
                }
            }
        }


    }
    public int getAnswer(int a, int o){
        if(scanner.hasNextInt()){
            int answer= scanner.nextInt();
            if (answer<a || answer>o){
                System.out.printf("incorrect \n insert the number between %d and %d", a, o);
                return 0;
            }
            else return answer;
        }
        else {
            System.out.printf("incorrect \n insert the number between %d and %d", a, o);
            return 0;
        }
    }

    /**
     * Creates a new user and adds it to a list of users
     */
    public User newUser(){
        boolean valid=false;
        String login="";
        do{
            valid=false;
            System.out.println("type your login");
            login = scanner.nextLine();
            for (User item: users) {
                if(item.login.equals(login)){
                    valid=true;
                    System.out.println("the login name is already taken");
                    break;
                }

            }

        } while(valid);
        System.out.println("type your password");
        String password=scanner.nextLine();
        User user=new User(login, password);
        users.add(user);
        return user;
    }


    public void mainMenu(User user){
        System.out.println("1 - choose category \n2 - show all products \n3 - exit");
        int answer=getAnswer(1, 3);
        switch(answer){
            case 1:
                showCategories(categories);
                answer=getAnswer(1,categories.size());
                Category cat=categories.get(answer-1);
                System.out.println("type the number of a product you want to buy");
                showProds(cat.getProds());
                answer=getAnswer(1,cat.getProds().size());
                buyProd(cat.getProds().get(answer-1),categories,prods,user);
                break;

            case 2:
                System.out.println("type the number of a product you want to buy");
                showProds(prods);
                answer=getAnswer(1,prods.size());
                Product prod=prods.get(answer-1);
                buyProd(prod,categories,prods,user);
                break;

            case 3:
                System.out.println("see ya!");
        }

    }


    public void fillAllProds(ArrayList<Category>cats, ArrayList<Product>prods){
        for (Category cat:cats) {
            prods.addAll(cat.getProds());
        }
    }
    public void showProds(ArrayList<Product> prods)
    {
        for (int i=0; i<prods.size();i++) {
            System.out.printf("%d - %s", i+1, prods.get(i));
        }
    }
    public void showCategories(ArrayList<Category>cats){
        for (int i=0; i<cats.size();i++){
            System.out.printf("%d - %s\n",i+1,cats.get(i));
        }
    }

    public void buyProd(Product prod, ArrayList <Category> cats, ArrayList<Product> prods, User user){
        for (Category cat: cats) {
            if(cat.prods.contains(prod))cat.prods.remove(prod);
        }

        prods.remove(prod);
        user.basket.add(prod);
    }

}
