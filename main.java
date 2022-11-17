import java.util.Scanner;
import java.util.Random;

public class main{

    public static String sex = "man";
    public static String disinfect;
    public static String playername;
    public static boolean[][] order = new boolean[3][3];
    public static String menu[][] = {
                                 {"醤油ラーメン","塩ラーメン","味噌ラーメン"},
                                 {"ネギご飯","チャーシューご飯","チャーマヨご飯"},
                                 {"餃子","",""}
                                };

    public static void main(){
        character_by_output("魂心家アドベンチャー",500,true);
        System.out.print("名前を入力してください>>");

        Scanner sc = new Scanner(System.in);
    
        String playername = sc.next();
        if(playername != "Michael" || playername != "micheal"){
            System.out.println("知らない名前だ。");
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            sc.close();
            return;
        }

        Random random = new Random();
        int sex_num = random.nextInt(3);
        if(sex_num <= 1){
            sex = "女";
        }
        
        select_ramen(sex);

        System.out.print("いらっしゃいませ！！");

    
        sc.close();
        return;
    }
    public static void character_by_output(String message,long interval,boolean ln){
        int length = message.length();
        for(int i = 0; i < length; i++){
            System.out.print(message.charAt(i));
            try {
                Thread.sleep(interval);
            } catch(InterruptedException e){
                e.printStackTrace();
            }     
        }
        if(ln) System.out.println();
        return;
    }

    public static void select_ramen(String sex){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                order[i][j] = false;
            }
        }
        sex += "の定員";
        System.out.println(cs("いらっしゃいませ！！"));
        System.out.println(cs("消毒をなさってから、食券の購入をお願いします！！"));

        Scanner sc = new Scanner(System.in);

        System.out.print("消毒をする(y/n)>>");

        while(disinfect != "y" || disinfect != "n"){
            disinfect = sc.next();
        }

        System.out.println("食券機の前に着いた。");

        System.out.println("食券を買う。");
        while(true){
            int select = 0;
            while(!(select <= 0 && select > 4)){
                System.out.print("1:ラーメン\n" + 
                                "2:ご飯\n" + 
                                "3:餃子\n" +
                                "4:注文をやめる\n");
                System.out.print(">>");
                select = sc.nextInt();
            }

            if(select == 4){
                sc.close();
                return;
            }

            switch(select){
                case 1:
                select = 0;
                while(!(select <= 0 && select > 3)){
                    System.out.println("ラーメンを選ぶ");
                    System.out.print("1:醤油ラーメン\n" + 
                                    "2:塩ラーメン\n" + 
                                    "3:味噌ラーメン\n");
                    System.out.print(">>");
                    select = sc.nextInt();
                }
                order[0][select - 1] = true;
                break;


                case 2:
                select = 0;
                while(!(select <= 0 && select > 3)){
                    System.out.println("ご飯を選ぶ");
                    System.out.print("1:ネギご飯\n" + 
                                     "2:チャーシューご飯\n" + 
                                     "3:チャー―マヨご飯\n");
                    System.out.print(">>");
                    select = sc.nextInt();
                }
                order[1][select - 1] = true;
                break;


                case 3:
                order[2][0] = true;
                break;
            }
        }
    }

    public static String cs(String message){
        String clerksay = sex + "「" + message + "」";
        return clerksay;
    }

}