/*** ///stack type
 * x = 3  , y = widest Disc ,width = current Widest Disc , status = true if it is not == "" 
 
     .  * 
     y  *    =
     .  *   = =
     .  *  = = =    --status        if (ocupied)? = true : = false ;
        * = = = =   <--wdith-->
    x :    *    0        1         2     
 
 
 **/
/***
     0      1       2
  -----------------------
 0|     |        |       |
  -----------------------
 1|     |        |       |
  -----------------------
 2|     |        |       |
  -----------------------
 3|     |        |       |
 **/
/***
     0      1       2
  -----------------------
 0|  =  |        |       |
  -----------------------
 1| ==  |        |       |
  -----------------------
 2| === |        |       |
  -----------------------
 3|==== |        |       |
 **/

/***
 //////discType Class is to have a width , a set of static functions 
 * functions such as such 
 * move to stack (int ){
 * //there should be a function to cheak wither the stack that's to be 
 * sent to has a currentWidth  less than or equal"which shouldn't exist 
 * in the first place" than the disc to be moved to it
 * }
 * ////there should be a function for the stack it self so that it can 'draw' 
 * the game such as
 * 
 *    =
 *   = =
 *  = = =
 * = = = =
 *    0        1         2
 * also there start making a static game of 4 discs then when you're 
 * done upgrade it so that u ask the user how many discs he/she wants 
 * to play with
 
 
 
 */
package towersofhanoi_v1.pkg01;

import java.util.Scanner;

public class TowersOfHanoi_V101 {
    
    static int size;    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        size = 4 ;//input.nextInt();
        String[][] disc = new String[3][size];///this is to be a user input after the game is made
        start(disc);
        System.out.println("out of start function");
        System.out.println(disc[0].length);
        
        printStack(disc);
        int from , to ;
        for ( ; ; ){
            
            from = input.nextInt();
            to = input.nextInt();
            move (from , to , disc);
            printStack(disc);
            System.out.println(smallestDiscInStack(disc[1]));
        }
         ///print the start of the game
            /*
             *    0        1         2
          0  *    =
          1  *   = =
          2  *  = = =
          3  * = = = =
            
            ///then aske the user what to move , the player only moves the top part and can only move it to a stack
            ///that has a bigger width than the disc he/she is moving
            int moveFROM = input.nextInt() , 
                    moveTO = input.nextInt();
            
           //if stack[moveTO][].width > disc[moveFROM].width then MOVE!! else JUST Reprint the whole thing
        }*/
    }
    
    /****
     * logic for moving in the game
     * if the stack to be moved to is free you can move it
     * if the stack TO has a bigger disk than the one From then you can move it
     
     */
    static void move (int from , int to , String [][] disc ){
        if ((whereIsFreeInStack(disc[to]) == disc[0].length-1)){
            rlyMove(disc ,from,to);
    }else if (smallestDiscInStack(disc[from]) < smallestDiscInStack(disc[to])){
            rlyMove(disc , from , to);
        }else{
        System.out.println("move :: Function ERRoR :: line 113");
    }
    }
    static void rlyMove(String [][] disc, int from , int to){
        disc[to][whereIsFreeInStack(disc[to])] = disc[from][whereIsFreeInStack(disc[from])+1];
        disc[from][whereIsFreeInStack(disc[from])+1] = "" ;
    }
    static int whereIsFreeInStack(String [] disc ){
        int location = -1 ;//if full
        for (int x = disc.length-1 ; x >= 0 ; x--){
            if (  disc[x].equals("")){
                location = x;
                return location;
            }
        }
        return location;
    }
    static void start(String [][] disc){
        for (int x = 0 ; x < disc.length ; x++){
            for(int y = 0 ; y < disc[0].length; y++){
                disc[x][y] = new String();
            }
        }
        String temp = "";
        for (int x = 0 ; x < disc[0].length ; x++){
            temp += " =";
            disc[0][x] = temp; 
            System.out.println("temp :" + temp + " : disc : " + disc[0][x]  + "  : x :" + x);
        }
        for(int x= 1 ; x < disc.length ; x++){
            for(int y = 0 ; y < disc[0].length ;y++){
                disc[x][y]= "";
            }
        }
    }
    static int smallestDiscInStack(String [] disc ){
        int min = disc.length;
        for (int x = disc.length-1 ; x >= 0 ; x--){
                if (disc[x].length()/2 == 0){
                    break;
                }else if (disc[x].length()/2 < min){
                    min = disc[x].length()/2;
                }
        }
        return min;
    }
    static void printStack(String [][] disc){
        System.out.println("\n\t 0  \t||\t 1  \t ||\t  2  ");
            for (int y = 0  ; y < disc[0].length ; y++){
                //System.out.print("x : " + x + " : y : " + y + "  ::  ");
                System.out.print("y:"+y+"|" ); 
                for(int x = 0 ; x < disc.length ; x++){
                    System.out.printf("%-17s" , disc[x][y]);
                }
                System.out.println();
            }
    }
    
}
