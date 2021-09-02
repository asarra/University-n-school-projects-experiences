package a;

import java.util.ArrayList;
import java.util.Random;

public class Karten {
    String[] a = {
            "AC","KC","DC","BC","ZC","9C","8C","7C", //AC = Ass Kreuz(Cross)
            "AQ","KQ","DQ","BQ","ZQ","9Q","8Q","7Q", //AQ = Ass Karo
            "AH","KH","DH","BH","ZH","9H","8H","7H", //AH = Ass Herz
            "AP","KP","DP","BP","ZP","9P","8P","7P" //ZP = 10 Pik
    };

    Karten(){
    }

    public String[] getA() {
        return a;
    }

    public Float calcPunktzahl(ArrayList<String> hand){
        int c,q,h,p;
        c=0;q=0;h=0;p=0;
        float punktzahl=0;

        for(int x=0;x<hand.size();x++){
            if(hand.get(x).endsWith("C")){
            c++;}
            if(hand.get(x).endsWith("Q")){
            q++;}
            if(hand.get(x).endsWith("H")){
            h++;}
            if(hand.get(x).endsWith("P")){
            p++;}
            }
        //Debugging - Still does not work as expected
        System.out.println(c);
        System.out.println(q);
        System.out.println(h);
        System.out.println(p);


        //Wenn c mehrmals vorkommt, durchgehen!
        int a,k,d,b,z,neun,acht,sieben;
        if(c>1){
            a=0;k=0;d=0;b=0;z=0;neun=0;acht=0;sieben=0;

            for(int x=0;x<hand.size();x++){
                if(hand.get(x).startsWith("A")){
                    a++;}
                if(hand.get(x).startsWith("K")){
                    k++;}
                if(hand.get(x).startsWith("D")){
                    d++;}
                if(hand.get(x).startsWith("B")){
                    b++;}
                if(hand.get(x).startsWith("Z")){
                    z++;}
                if(hand.get(x).startsWith("9")){
                    neun++;}
                if(hand.get(x).startsWith("8")){
                    acht++;}
                if(hand.get(x).startsWith("7")){
                    sieben++;}
            }
            if(a>1){
                punktzahl=punktzahl+a*11;
            }
            if(k>1){
                punktzahl=punktzahl+k*10;
            }
            if(d>1){
                punktzahl=punktzahl+d*10;
            }
            if(b>1){
                punktzahl=punktzahl+b*10;
            }
            if(z>1){
                punktzahl=punktzahl+z*10;
            }
            if(neun>1){
                punktzahl=punktzahl+neun*9;
            }
            if(acht>1){
                punktzahl=punktzahl+acht*8;
            }
            if(sieben>1){
                punktzahl=punktzahl+sieben*7;
            }









            //Falls es nur einzelne Karten vom selben Zeichen gibt!
            float l=0;ArrayList where = new ArrayList();

            if(a==1){l++;where.add("a");}
            if(k==1){l++;where.add("k");}
            if(d==1){l++;where.add("d");}
            if(b==1){l++;where.add("b");}
            if(z==1){l++;where.add("z");}
            if(neun==1){l++;where.add("neun");}
            if(acht==1){l++;where.add("acht");}
            if(sieben==1){l++;where.add("sieben");}
            if(l>1){
                punktzahl=0;
                for(int x=0;x<where.size();x++){
                    if(hand.get(x).equals("a")){
                        punktzahl+=11;
                    }
                    if(hand.get(x).equals("k")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("d")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("b")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("z")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("neun")){
                        punktzahl+=9;
                    }
                    if(hand.get(x).equals("acht")){
                        punktzahl+=8;
                    }
                    if(hand.get(x).equals("sieben")){
                        punktzahl+=7;
                    }
            }}














        }
        if(q>1){
            a=0;k=0;d=0;b=0;z=0;neun=0;acht=0;sieben=0;

            for(int x=0;x<hand.size();x++){
                if(hand.get(x).startsWith("A")){;
                    a++;}
                if(hand.get(x).startsWith("K")){
                    k++;}
                if(hand.get(x).startsWith("D")){
                    d++;}
                if(hand.get(x).startsWith("B")){
                    b++;}
                if(hand.get(x).startsWith("Z")){
                    z++;}
                if(hand.get(x).startsWith("9")){
                    neun++;}
                if(hand.get(x).startsWith("8")){
                    acht++;}
                if(hand.get(x).startsWith("7")){
                    sieben++;}
            }
            if(a>1){
                punktzahl=punktzahl+a*11;
            }
            if(k>1){
                punktzahl=punktzahl+k*10;
            }
            if(d>1){
                punktzahl=punktzahl+d*10;
            }
            if(b>1){
                punktzahl=punktzahl+b*10;
            }
            if(z>1){
                punktzahl=punktzahl+z*10;
            }
            if(neun>1){
                punktzahl=punktzahl+neun*9;
            }
            if(acht>1){
                punktzahl=punktzahl+acht*8;
            }
            if(sieben>1){
                punktzahl=punktzahl+sieben*7;
            }











            //Falls es nur einzelne Karten vom selben Zeichen gibt!
            float l=0;ArrayList where = new ArrayList();

            if(a==1){l++;where.add("a");}
            if(k==1){l++;where.add("k");}
            if(d==1){l++;where.add("d");}
            if(b==1){l++;where.add("b");}
            if(z==1){l++;where.add("z");}
            if(neun==1){l++;where.add("neun");}
            if(acht==1){l++;where.add("acht");}
            if(sieben==1){l++;where.add("sieben");}
            if(l>1){
                punktzahl=0;
                for(int x=0;x<where.size();x++){
                    if(hand.get(x).equals("a")){
                        punktzahl+=11;
                    }
                    if(hand.get(x).equals("k")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("d")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("b")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("z")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("neun")){
                        punktzahl+=9;
                    }
                    if(hand.get(x).equals("acht")){
                        punktzahl+=8;
                    }
                    if(hand.get(x).equals("sieben")){
                        punktzahl+=7;
                    }
                }}

















        }
        if(h>1){
            a=0;k=0;d=0;b=0;z=0;neun=0;acht=0;sieben=0;

            for(int x=0;x<hand.size();x++){
                if(hand.get(x).startsWith("A")){;
                    a++;}
                if(hand.get(x).startsWith("K")){
                    k++;}
                if(hand.get(x).startsWith("D")){
                    d++;}
                if(hand.get(x).startsWith("B")){
                    b++;}
                if(hand.get(x).startsWith("Z")){
                    z++;}
                if(hand.get(x).startsWith("9")){
                    neun++;}
                if(hand.get(x).startsWith("8")){
                    acht++;}
                if(hand.get(x).startsWith("7")){
                    sieben++;}
            }
            if(a>1){
                punktzahl=punktzahl+a*11;
            }
            if(k>1){
                punktzahl=punktzahl+k*10;
            }
            if(d>1){
                punktzahl=punktzahl+d*10;
            }
            if(b>1){
                punktzahl=punktzahl+b*10;
            }
            if(z>1){
                punktzahl=punktzahl+z*10;
            }
            if(neun>1){
                punktzahl=punktzahl+neun*9;
            }
            if(acht>1){
                punktzahl=punktzahl+acht*8;
            }
            if(sieben>1){
                punktzahl=punktzahl+sieben*7;
            }
            //Falls es nur einzelne Karten vom selben Zeichen gibt!
            float l=0;ArrayList where = new ArrayList();

            if(a==1){l++;where.add("a");}
            if(k==1){l++;where.add("k");}
            if(d==1){l++;where.add("d");}
            if(b==1){l++;where.add("b");}
            if(z==1){l++;where.add("z");}
            if(neun==1){l++;where.add("neun");}
            if(acht==1){l++;where.add("acht");}
            if(sieben==1){l++;where.add("sieben");}
            if(l>1){
                punktzahl=0;
                for(int x=0;x<where.size();x++){
                    if(hand.get(x).equals("a")){
                        punktzahl+=11;
                    }
                    if(hand.get(x).equals("k")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("d")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("b")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("z")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("neun")){
                        punktzahl+=9;
                    }
                    if(hand.get(x).equals("acht")){
                        punktzahl+=8;
                    }
                    if(hand.get(x).equals("sieben")){
                        punktzahl+=7;
                    }
                }}











        }
        if(p>1){
            a=0;k=0;d=0;b=0;z=0;neun=0;acht=0;sieben=0;

            for(int x=0;x<hand.size();x++){
                if(hand.get(x).startsWith("A")){;
                    a++;}
                if(hand.get(x).startsWith("K")){
                    k++;}
                if(hand.get(x).startsWith("D")){
                    d++;}
                if(hand.get(x).startsWith("B")){
                    b++;}
                if(hand.get(x).startsWith("Z")){
                    z++;}
                if(hand.get(x).startsWith("9")){
                    neun++;}
                if(hand.get(x).startsWith("8")){
                    acht++;}
                if(hand.get(x).startsWith("7")){
                    sieben++;}
            }
            if(a>1){
                punktzahl=punktzahl+a*11;
            }
            if(k>1){
                punktzahl=punktzahl+k*10;
            }
            if(d>1){
                punktzahl=punktzahl+d*10;
            }
            if(b>1){
                punktzahl=punktzahl+b*10;
            }
            if(z>1){
                punktzahl=punktzahl+z*10;
            }
            if(neun>1){
                punktzahl=punktzahl+neun*9;
            }
            if(acht>1){
                punktzahl=punktzahl+acht*8;
            }
            if(sieben>1){
                punktzahl=punktzahl+sieben*7;
            }


            //Falls es nur einzelne Karten vom selben Zeichen gibt!
            float l=0;ArrayList where = new ArrayList();

            if(a==1){l++;where.add("a");}
            if(k==1){l++;where.add("k");}
            if(d==1){l++;where.add("d");}
            if(b==1){l++;where.add("b");}
            if(z==1){l++;where.add("z");}
            if(neun==1){l++;where.add("neun");}
            if(acht==1){l++;where.add("acht");}
            if(sieben==1){l++;where.add("sieben");}
            if(l>1){
                punktzahl=0;
                for(int x=0;x<where.size();x++){
                    if(hand.get(x).equals("a")){
                        punktzahl+=11;
                    }
                    if(hand.get(x).equals("k")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("d")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("b")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("z")){
                        punktzahl+=10;
                    }
                    if(hand.get(x).equals("neun")){
                        punktzahl+=9;
                    }
                    if(hand.get(x).equals("acht")){
                        punktzahl+=8;
                    }
                    if(hand.get(x).equals("sieben")){
                        punktzahl+=7;
                    }
                }}





        }

        //Überprüfung auf 3 Karten mit den selben Werten = 30 1/2 Punkte
        a=0;k=0;d=0;b=0;z=0;neun=0;acht=0;sieben=0;
        for(int x=0;x<hand.size();x++){
            if(hand.get(x).startsWith("A")){;
            a++;}
            if(hand.get(x).startsWith("K")){
            k++;}
            if(hand.get(x).startsWith("D")){
            d++;}
            if(hand.get(x).startsWith("B")){
            b++;}
            if(hand.get(x).startsWith("Z")){
            z++;}
            if(hand.get(x).startsWith("9")){
            neun++;}
            if(hand.get(x).startsWith("8")){
            acht++;}
            if(hand.get(x).startsWith("7")){
            sieben++;}
        }
        if(a>2){
            punktzahl=30.5f;
        }
        if(k>2){
            punktzahl=30.5f;
        }
        if(d>2){
            punktzahl=30.5f;
        }
        if(b>2){
            punktzahl=30.5f;
        }
        if(z>2){
            punktzahl=30.5f;
        }
        if(neun>2){
            punktzahl=30.5f;
        }
        if(acht>2){
            punktzahl=30.5f;
        }
        if(sieben>2){
            punktzahl=30.5f;
        }

        return punktzahl;

    }

}
