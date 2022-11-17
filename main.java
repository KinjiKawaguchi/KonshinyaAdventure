import java.util.Scanner;

public class main{
    public static void main(){
        character_by_output("魂心家アドベンチャー",500,true);
        System.out.print("名前を入力してください>>");

        Scanner sc = new Scanner(System.in);
    
        String username = sc.next();
        if(username != "Michael"){
            System.out.println("知らない名前だ。");
            try{
                Thread.sleep(1000);
            } catch(InterruptedException e){
                e.printStackTrace();
            }
            return;
        }

        System.out.print("いらっしゃいませ！！");

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
}