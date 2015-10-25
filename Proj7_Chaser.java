import java.util.Random;

public class Proj7_Chaser{
    public static void main(String[] args){
        
        final int SCALE_MIN = -100;
        final int SCALE_MAX = 100;
        
        StdDraw.setScale(SCALE_MIN,SCALE_MAX);
        
        double xCoord = (SCALE_MAX + SCALE_MIN)/2;
        double yCoord = (SCALE_MAX + SCALE_MIN)/2;
        Random rand = new Random();
        
        while(true){
            while(xCoord != StdDraw.mouseX() && yCoord != StdDraw.mouseY()){
                StdDraw.setPenColor(rand.nextInt(255),rand.nextInt(255),
                                        rand.nextInt(255));
                StdDraw.filledCircle(xCoord,yCoord,5);
                if(StdDraw.mouseX()-xCoord < 0){
                    xCoord--;
                } else {
                    xCoord++;
                }
                if(StdDraw.mouseY()-yCoord < 0){
                    yCoord--;
                } else {
                    yCoord++;
                }
                if(StdDraw.mousePressed()){
                    StdDraw.clear();
                    xCoord = (SCALE_MAX + SCALE_MIN)/2;
                    yCoord = (SCALE_MAX + SCALE_MIN)/2;
                }
                StdDraw.show(50);
            }
        }
    }
}
