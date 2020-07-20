import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vending {
    static int money = 0;
    public static void main(String[] args){
        List<String> arrDrink = new ArrayList<>();
        arrDrink.add("coca");
        arrDrink.add("pepsi");
        arrDrink.add("7up");
        List<Integer> arrPrice = new ArrayList<>();
        arrPrice.add(5000);
        arrPrice.add(10000);
        arrPrice.add(15000);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhap vao so tien: ");
            money = scanner.nextInt();
        }while (money < lowestPrice(arrPrice));


        System.out.println("1. Coca: 5000");
        System.out.println("2. Pepsi: 10000");
        System.out.println("3. 7up: 15000");


        boolean checkMoney = true;
        while (checkMoney){
            System.out.println("Chon mon ban muon mua theo so:");
            int drinkNum = scanner.nextInt();
            switch (drinkNum){
                case 1:
                    if(money >= arrPrice.get(0)){
                        money -= arrPrice.get(0);
                        System.out.println("Ban da mua coca voi gia"+ arrPrice.get(0)+". So tien con lai la: "+money);
                    }else{
                        System.out.println("Ban khong du dieu kien de mua mon nay!");
                        //10break;
                        return;
                    }
                    break;
                case 2:
                    if(money >= arrPrice.get(1)){
                        money -= arrPrice.get(1);
                        System.out.println("Ban da mua pepsi voi gia"+ arrPrice.get(1)+". So tien con lai la: "+money);
                    }else{
                        System.out.println("Ban khong du dieu kien de mua mon nay!");
                        //10break;
                        return;
                    }
                    break;
                case 3:
                    if(money >= arrPrice.get(2)){
                        money -= arrPrice.get(2);
                        System.out.println("Ban da mua 7up voi gia"+ arrPrice.get(2)+". So tien con lai la: "+money);
                    }else{
                        System.out.println("Ban khong du dieu kien de mua mon nay!");
                        //10break;
                        return;
                    }
                    break;
            }
            if(money >= lowestPrice(arrPrice)){
                System.out.println("Ban co muon tiep tuc? Y/N");
                String cont = scanner.next();
                if(cont.equalsIgnoreCase("Y")){
                    checkMoney = true;
                }
                else{
                    checkMoney = false;
                }
            }
            else{
                checkMoney = false;
            }
        }
    }
    public static int lowestPrice(List<Integer> arr){
        int min = arr.get(0);
        for (int i = 0;i < arr.size();i++){
            if (min > arr.get(i)){
                min = arr.get(i);
            }
        }
        return min;
    }
}
