import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Введите здоровье дракона: ");
      int DragonHealth1 = scanner.nextInt();
      System.out.print("Введите атаку дракона: ");
      int DragonAttack1 = scanner.nextInt();
      System.out.print("Введите здоровье одного копейщика: ");
      int KopHealth1 = scanner.nextInt();
       System.out.print("Введите атаку одного копейщика: ");
       int KopAttack1 = scanner.nextInt();



        int Min = 0;

         for (int Min_KopNumber = 1; Min_KopNumber < 23; Min_KopNumber++) {
             int KopNumber = Min_KopNumber;

             int DragonHealth =DragonHealth1;
             int DragonAttack = DragonAttack1;
             int KopHealth = KopHealth1;
             int KopAttack = KopAttack1;
             int Count = 1;

             int SumKopHealth = 200;




            int k=0;
            for (; ; ) {
                int[] State = DragonAttack_To_Kop(DragonHealth, DragonAttack, KopNumber, KopAttack, KopHealth, SumKopHealth, Count);
               // int [] State1 = State;
               // State = DragonAttack_To_Kop(DragonHealth, DragonAttack, KopNumber, KopAttack, KopHealth, SumKopHealth, Count);
                DragonHealth = State[0];
                KopNumber = State[1];
                SumKopHealth = State[2];
                Count = State[3];
               // System.out.println( Arrays.toString(State));


                if (DragonHealth > 0 && KopNumber <= 0 && SumKopHealth <= 0)
                {
                  //  System.out.println("Дракон победил. Число копейщиков " + Min_KopNumber);
                  //  System.out.println("k= " + k);
                    break;
                }


                if (DragonHealth <= 0 || KopNumber <=0 || SumKopHealth <= 0)
                {
                  //  System.out.println("Число копейщиков " + Min_KopNumber);
                 //   System.out.println("k= " + k);
                    break;
                }







                k++;

            }


            if ((k>0 && DragonHealth <= 0 && KopNumber > 0 && SumKopHealth > 0) ||
                    ((k>0 && (DragonHealth <= 0 && KopNumber <=0 && SumKopHealth <= 0)) && KopNumber*KopAttack>=DragonHealth)) {

                System.out.println("Минимальное число копейщиков для победы " + Min_KopNumber);
               break;

            }
  }




//
        }


    private static int [] DragonAttack_To_Kop(int DragonHealth, int DragonAttack,
                                           int KopNumber, int KopAttack,
                                           int KopHealth, int SumKopHealth, int Count)
    {

        int [] State  = new int[4];
        DragonHealth = DragonHealth - KopNumber*KopAttack;
        if (Count % 2 != 0 ) {
               int N_Kop_murdered = DragonAttack/KopHealth;
                 KopNumber = KopNumber - N_Kop_murdered;
                 SumKopHealth = KopNumber*KopHealth - 5;}
        else {
            int N_Kop_murdered = DragonAttack/KopHealth+1;
            KopNumber = KopNumber - N_Kop_murdered;
            SumKopHealth = KopNumber*KopHealth;
        }
        Count++;
        State [0] = DragonHealth;
        State [1] = KopNumber;
        State [2] = SumKopHealth;
        State [3] = Count;



  return State; }

}
