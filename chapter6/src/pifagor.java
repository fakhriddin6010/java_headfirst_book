public class pifagor {
        public static void main(String[] args){
            int a, b, c, n=0;
            for(a = 1; a <=100; a++)
                for(b = 1; b <=100; b++)
                    for(c = 1; c <=100; c++)
                        if((a < b) && (a * a + b*b == c*c)){
                            n++;
                            System.out.println("("+n+") a = " +a+", b="+b+", c=" +c+ "");
                        }
            System.out.println("fakhriddin");
        }
    }

