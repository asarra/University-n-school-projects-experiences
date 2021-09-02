package mine;

import given.Gui;

import java.awt.*;

public class Main {


    public void column(Gui gui) {
        int height = gui.getHeight();
        int width = gui.getWidth();

        int[] arrayx = new int[height];
        int[] arrayy = new int[width];

        for(int a=0;a<width;a++) {
            arrayx[a] = 1;
            arrayy[a] = a;
        }
        gui.rectangleAt(arrayx,arrayy,Color.BLACK);

        for(int x=0;x < height;x++){
            for(int y=0;y < width;y++){
                if(x==width-2){
                    gui.rectangleAt(x, y, Color.black);
                }
            }
        }

    }

    public void row(Gui gui) { //Einziger Unterschied zu column(): X und Y vertauscht!
        int height = gui.getHeight();
        int width = gui.getWidth();

        int[] arrayx = new int[height];
        int[] arrayy = new int[width];

        for(int a=0;a<width;a++) {
            arrayx[a] = 1;
            arrayy[a] = a;
        }
        gui.rectangleAt(arrayy,arrayx,Color.BLACK);

        for(int x=0;x < height;x++){
            for(int y=0;y < width;y++){
                if(x==gui.getWidth()-2){
                    gui.rectangleAt(y, x, Color.black);
                }
            }
        }

    }

    public void diagonal(Gui gui) { //difference: handle x as y or y as x
        int height = gui.getHeight();
        int width = gui.getWidth();

        for(int x=0;x < height;x++){
            for(int y=0;y < width;y++){
                if(x==y)
                    gui.rectangleAt(y, y, Color.magenta);
                else
                    gui.rectangleAt(x,y,Color.black);
            }
        }
    }

    public void diagonalLeftRight(Gui gui) { //difference: x becomes height-(x+1)
        int height = gui.getHeight();
        int width = gui.getWidth();

        for(int x=0;x < height;x++){
            for(int y=0;y < width;y++){
                if(x==y){
                    gui.rectangleAt(y, y, Color.magenta);
                    gui.rectangleAt(height-(x+1),y,Color.magenta);
                }
                else
                    gui.rectangleAt(x,y,Color.black);

            }
        }
    }

    public void everySecondRow(Gui gui) { //Einziger Unterschied zu row(): x % 4 == 2 für jede 2. Reihe und x % 4 == 0 für die 1. Reihe!
        int height = gui.getHeight();
        int width = gui.getWidth();

        int[] arrayx = new int[width];
        int[] arrayy = new int[height];

        for (int x = 0; x < width; x++) {
            arrayx[x] = x;
        }

        int counter=0;
        for(int x=0;x < height;x++){
            for(int y=0;y < width;y++){
                if((y % 4)==0){
                    gui.rectangleAt(x, y, Color.black);
                }
                if((y % 4)==2){//wie oft kann ich das sofortige Zeichnen der jeden 2. Reihe ausführen
                    for(counter=0;counter<arrayy.length;counter++)
                        arrayy[counter]=y;
                    gui.rectangleAt(arrayx, arrayy, Color.BLACK); //Alles funktioniert. Nur das nicht. Es lässt nicht die Langsamen zu Ende zeichnen
                }
            }
        }

    }

    public void rectangle(Gui gui) {
        int height = gui.getHeight();
        int width = gui.getWidth();

        for(int x=0;x < height;x++){
            for(int y=0;y < width;y++){
                if(x<width-1 & x>0 & y<height-1 & y>0){
                    gui.rectangleAt(x, y, Color.black);
                }
            }
        }

    }

    public void checkerPattern(Gui gui) {
        int height = gui.getHeight();
        int width = gui.getWidth();
        int counter=0;

        for(int x=0;x < height;x++){
            for(int y=0;y < width;y++){
                if((x%2)==0){
                    gui.rectangleAt((x+counter)%width, y, Color.black);
                    counter++;
                }
            }
        }

    }

    public void checkerPatternArray(Gui gui){
        gui.setDiscardOldDrawings();
        int height = gui.getHeight();
        int width = gui.getWidth();
        int x_counter=0;
        int[] ax,ay;
        ax=new int[(width)];
        ay=new int[(height)];

        for (int y=0;y<height;y++){
            for (int x=0;x<width;x++) {
                if ((y%2==0 && x%2==0) | (y%2==1 && x%2==1)) {

                    ax[x_counter]=x;
                    ay[x_counter]=y;
                    x_counter+=1;

                    if (x_counter%(width/2)==0){{
                        gui.rectangleAt(ax,ay,Color.BLACK);
                        x_counter=0;
                    }
                    //gui.rectangleAt(x,y,Color.black);
                }
            }
        }

        /*
        Strange result:
        for(int x=0;x < height;x++){
        for(int y=0;y < width;y++){
            if((y%2)==0){
                gui.rectangleAt((x+counter)%width, y, Color.black);
                counter++;
            }
        }
        }
        */
    }}

    public void cromatic(Gui gui){
        /**
         * cromatic: Ein Farbverlauf von oben links nach unten rechts wird dargestellt. Die Farbe
         * jedes Rechtecks wird komponentenweise (RGB: Rot, Grün, Blau) berechnet, indem je ein
         * Parameter mit den folgenden Formeln multipliziert wird. Dieser Parameter ist so zu bestimmen,
         * das das Rechteck oben links schwarz (r=g=b=0.0f), das unten rechts weiß ist
         * (r=g=b=1.0f).
         * • Rotwert: Zeilenposition + Spaltenposition
         * • Grünwert: Zeilenposition ∗ Spaltenposition
         * • Blauwert: 0.3 · Zeilenposition + Spaltenposition
         * Die berechnete Farbe soll auch ausgegeben werden (println(color), mit color vom Typ
         * java.awt.Color).1
         */
        Color color;
        int height= gui.getHeight();
        int width=gui.getWidth();

        float rMax=((width-1)+(height-1)); //-1 weil, sonst über den Rahmen gegangen wird und wir nur die höchstmögliche Stelle brauchen!
        float gMax=(width-1)*(height-1); //Diese Maxs sind dasselbe wie die Formeln da oben. Nur mit dem Unterschied, dass wir jeweils den maximalen Wert von x und y brauchen (Weiß = RGB(255,255,255))
        float bMax=0.3f*((width-1)+(height-1));

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                color = new Color((x+y)/rMax,(x*y)/gMax,(0.3f*(x+y))/bMax);
                gui.rectangleAt(x,y,color);
                System.out.println(color);
            }
        }
    }

    public void contrapoints(Gui gui){
        gui.setDiscardOldDrawings();
        int height=gui.getHeight();
        int width=gui.getWidth();
        //wir erschaffen ein quadrat. Feld, damit die Ränder gleichzeitig berührt werden
        int spielfeld = width<height ? width : height;
        Point magenta, blue, green, red;

        for (int x=0;x<spielfeld;x++) { //breite
                if (x%2==0){ //1.Schritt/Reihe
                    for (int y = 0; y < spielfeld; y++) { //höhe //y wird erhöht "um nach unten zu gehen"
                        //von oben-links nach unten-links
                        red=new Point(x,y,Color.red);
                        //von unten-links nach unten-rechts
                        magenta=new Point(y,spielfeld-1-x,Color.magenta);
                        //nach unten-rechts nach oben-rechts
                        blue=new Point(spielfeld-1-x,spielfeld-1-y,Color.blue);
                        //nach oben-rechts nach oben-links
                        green=new Point(spielfeld-1-y,x,Color.green);

                        gui.rectangleAt(
                                new int[]{magenta.getX(),red.getX(),blue.getX(),green.getX()},
                                new int[]{magenta.getY(),red.getY(),blue.getY(),green.getY()},
                                new Color[]{magenta.getColor(),red.getColor(),blue.getColor(),green.getColor()}
                        );
                    }
                }
                else { //2. Schritt/Reihe
                    for (int y = spielfeld-1; y >= 0; y--) { //höhe //y wird weniger "um nach oben zu gehen"
                        //Gegenteil vom obigen red
                        red = new Point(x, y, Color.red);
                        //Gegenteil vom obigen magenta
                        magenta = new Point(y, spielfeld - 1 - x, Color.magenta);
                        //Gegenteil vom obigen blue
                        blue = new Point(spielfeld - 1 - x, spielfeld - 1 - y, Color.blue);
                        //Gegenteil vom obigen green
                        green = new Point(spielfeld - 1 - y, x, Color.green);

                        gui.rectangleAt(
                                new int[]{magenta.getX(), red.getX(), blue.getX(), green.getX()},
                                new int[]{magenta.getY(), red.getY(), blue.getY(), green.getY()},
                                new Color[]{magenta.getColor(), red.getColor(), blue.getColor(), green.getColor()}
                        );
                    }
                }
            }
        }

    public void generate(Gui gui){
        gui.setInitialWaitMs(10);
        gui.setWaitMs(200);

        //column(gui);
        //row(gui);
        //diagonal(gui);
        //diagonalLeftRight(gui);
        //everySecondRow(gui);
        //rectangle(gui);
        //checkerPattern(gui);
        //checkerPatternArray(gui);
        //cromatic(gui);
        //contrapoints(gui);
    }

    public static void main(String[] args){
        Gui gui = new Gui(new Main(), 10, 10);
        gui.start();

    }
}