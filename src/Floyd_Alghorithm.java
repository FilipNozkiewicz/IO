public class Floyd_Alghorithm {


    static int[][] P;
    static final int N = 4;

    public static void main(String[] args){

        // 999 is infinity
        // my matrix
        int[][] M1 = {{0,5,999,999},{50,0,15,5},{30 , 999 , 0 , 15},{15,999,5,0}};  // 0 is on the diagonal
        int[][] M = {{0,5,1,2},{5,0,3,999},{1,3,0,4},{2,999,4,0}};

        P = new int[N][N];
        startpath ();
        System.out.println ("Matrix to find the shortest path of");
        printMatrix(M);
        System.out.println ("Shortest Path Matrix");
        printMatrix ( Floyd ( M ) );
        System.out.println ("Path Matrix");
        printMatrix ( P );

    }
    public static void printMatrix(int[][] M){

        System.out.println ("\n\t");
        System.out.print ("\t");
        for(int j = 0 ; j < N ; j++){
            System.out.print (j + "|\t");
        }
        System.out.println ();
        for(int j = 0 ; j < 35 ; j++){
            System.out.print ("-");
        }
        System.out.println ();
        for(int i = 0 ; i < N ; i++){
            System.out.print (i + "|\t");
            for(int j = 0 ; j < N ; j++){
                if(i == j)
                    System.out.print ("-");
                else
                System.out.print (M[i][j]);
                System.out.print ("\t");
            }
            System.out.println ("\n");
        }
        System.out.println ("\n");
    }

    public static int[][] Floyd(int[][] M){

        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(M[i][k] + M[k][j] < M[i][j]){
                        M[i][j] = M[i][k] + M[k][j];
                        P[i][j] = k;

                    }

                }
            }
        }
        return M;
    }
    public static void startpath(){
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(i != j){
                    P[i][j] = j;
                }
            }
        }
    }

    public static int min(int i , int j){
        if(i > j) return j;
        return i;
    }
}
