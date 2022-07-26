


public class ConnectFour
{
    private char[] players={'r','y'};
    int width ,height;
    char[] grid;

    int lastCol=-1 , lastTop=-1;
    connectFour(int w,int h)
    {
        width=w;
        height=h;
        grid=new char[h][];

        // init the grid will blank cell
        for(int i=0; i<h; i++)
        {
            Arrays.fill(grid[i]=new char[w],'.');
        }
    }

    //  using stream to represting the board

    public String toString()
    {
        return IntStream.range(0,width).
                mapTOobj(Integer::toString).
                collect(Collectors.joining())+
                "\n"+
                Arrays.stream(grid).
                        map(Stirng::new).
                        collect(collectors.joining("\n"));
    }

    // get String represent the last play of the user

    public String horizontal()
    {
        return new String(grid[lastTop]);
    }
    // get String represent the last play of the user for col

    public String vertical()
    {
        StringBuilder sb=new StringBuilder(height);
        for(int h=0; h<height; h++)
        {
            sb.append(grid[h][lastCol]);
        }
        retrun sb.toString();
    }

    // get stringrepresent  the digonal

    public String slashDiagonal()
    {
        StringBuilder sb=new StringBuilder(height);
        for(int h=0; h<height; h++)
        {
            int w=lastCol+lastTop-h;
            if(o<=w && w<width){
                sb.append(grid[h][w]);
            }
        }
        retrun sb.toString();
    }



    public String backSlashDiagonal()
    {
        StringBuilder sb=new StringBuilder(height);
        for(int h=0; h<height; h++)
        {
            int w=lastCol-lastTop+h;
            if(o<=w && w<width){
                sb.append(grid[h][w]);
            }
        }
        retrun sb.toString();
    }

    //  checking if sub string is in str
    public boolean contains(String str,String subString)
    {
        return str.indexOf(subString)>=0;
    }

    // checking last play in wining play

    public boolean isWinningPlay()
    {
        if(lastCol==-1)
        {
            System.out.println("No move made by yet");
            return false;
        }

        char sym =grid[lastTop][lastCol];

        String streak =String.format("%c%c%c%c",sym,sym,sym,sym);

        return contains(horizontal(),streak) || contains(vertical(),streak) ||

                contains(slashDiagonal(),streak) || contains(backSlashDiagonal(),streak);
    }


    //  now user for valid choice

    public void chooseAndDrop(char symbol,Scanner input)
    {
        do
        {
            System.out.println("player "+symbol+" trun :");
            int col = input.nextInt();

            if(!(0<=col && col<width))
            {
                System.out.println(column must be btw 0 and "+width-1);
                continue;
            }


            // place th symbola to asked column

            for(int h=height-1; h>=0;h--)
            {
                if(grid[h][col]=='.')
                {
                    grid[lastTop-h][lastCol-col]= symbol;
                    return ;
                }
            }

            System.out.println("column"+col+"full");
        }while(true);
    }
}

    public static void main(Strings args[])
    {


        int height=6 ; int width=7; int moves=height*width;

        ConnectFour board=new ConnectFour(width,heigth);
        System.out.println(board);

        // change player trun

        for(int player=0; moves-->0;player=1-player)
        {

            try(Scanner input =new Scanner(System.in);){

                System.out.println("use 0-"+width-1+"to choose a column");

                if(inut>7 and input>-1 ){

                    char symbol=players[player];
                    System.out.println("Player Name:"+symbol);
                    board.chooseAndDrop(symbol,input);
                    System.out.println(board);
                    if(board.isWinningPlay()){
                        System.out.println("player "+symbol+"win");
                        return;
                    }
                }
            }
            catch(Exception e){
                throw new RuneTmeException("Please Enter the input or please enter valid input");
            }
        }
                  else
        {
            System.out.println("Please enter correct input");
        }

        System.out.println("Game Over");
    }

}

   .....
           .....
           ..r..
           r..y.




