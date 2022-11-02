import java.util.*;
class tic
{
    public static void main(String ...s) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        String user1,user2;
        int us1,us2;
        int arr[][] = new int[3][3];
        System.out.println("Emter name of Player 1");
        user1 =  sc.nextLine();
        System.out.println("Choose your Symbol O or X");
        while(true)
        {
            char c = sc.next().charAt(0);
            if(c!='X' && c!='x' && c!='O' && c!='o')
                System.out.println("Wrong symbol please choose O or X");
            else
            {
                if(c=='X' || c=='x')
                us1=1;
                else
                us1=2;
                break;
            }
        }
        System.out.println("Emter name of Player 2");
        user2 =  sc.next();
        if(us1==1)
        {
            System.out.println("Your Sysmbol is O");
            us2=2;
        }
        else
        {
            System.out.println("Your Symbol is X");
            us2=1;
        }
        System.out.println("Lets Start");
        Thread.sleep(3000);
        boolean win=false;
        for(int a=1;a<=9;a++)
        {
            display(arr);
            if(a%2==1)
            System.out.println(user1+" Enter number where you want to mark");
            else
            System.out.println(user2+" Enter number where you want to mark");
            while(true)
            {
                int n = sc.nextInt();
                if(isValidMove(n, arr))
                {
                    if(a%2==1)
                    update(us1,n,arr);
                    else
                    update(us2,n,arr);
                    break;
                }
                else
                    System.out.println("Invalid move!! please enter valid move");
            }
            if(checkWin(us1,arr))
            {
                System.out.println("\f");
                display(arr);
                System.out.println("Congrats " + user1 + " you won");
                win=true;
                break;
            }
            if(checkWin(us2,arr))
            {
                System.out.println("\f");
                display(arr);
                System.out.println("Congrats " + user2 + " you won");
                win=true;
                break;
            }
        }
        System.out.println("Game over");
        if(!win)
        System.out.println("Round Draw");
            
    }
    public static boolean checkWin(int n, int arr[][])
    {
        int c=0;
        for(int a=0;a<3;a++)
            for(int b=0;b<3;b++)
                if( (arr[a][0]==n && arr[a][1]==n && arr[a][2]==n) || (arr[0][a]==n && arr[1][a]==n && arr[2][a]==n))
                    return true;
        if(arr[0][0]==n && arr[1][1]==n && arr[2][2]==n) return true;
        if(arr[0][2]==n && arr[1][1]==n && arr[2][0]==n) return true;
        return false;
    }
    public static void display(int arr[][])
    {
        System.out.println("\f");
        int c=0;
        for(int a=0;a<3;a++)
        {
            System.out.print("\t\t\t");
            for(int b=0;b<3;b++)
            {
                c++;
                if(arr[a][b]==1)
                System.out.print("X ");
                else if(arr[a][b]==2)
                System.out.print("O ");
                else
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
    public static void update(int n , int p , int arr[][])
    {
         if(p==1)
         arr[0][0]=n;
         if(p==2)
         arr[0][1]=n;
         if(p==3)
         arr[0][2]=n;
         if(p==4)
         arr[1][0]=n;
         if(p==5)
         arr[1][1]=n;
         if(p==6)
         arr[1][2]=n;
         if(p==7)
         arr[2][0]=n;
         if(p==8)
         arr[2][1]=n;
         if(p==9)
         arr[2][2]=n;
    }
    public static boolean isValidMove(int n , int arr[][])
    {
        if(n<1 || n>9)
        return false;
        if(n==1)
        if(arr[0][0]!=0) return false;
        if(n==2)
        if(arr[0][1]!=0) return false;
        if(n==3)
        if(arr[0][2]!=0) return false;
        if(n==4)
        if(arr[1][0]!=0) return false;
        if(n==5)
        if(arr[1][1]!=0) return false;
        if(n==6)
        if(arr[1][2]!=0) return false;
        if(n==7)
        if(arr[2][0]!=0) return false;
        if(n==8)
        if(arr[2][1]!=0) return false;
        if(n==9)
        if(arr[2][2]!=0) return false;
        return true;        
    }
}