public class Proj7_Watcher{
    
    static final double PUPIL_RADIUS = 5;
    
    public static void main(String[] args){
        double xCenterOfEye = 35;
        double yCenterOfEye = 0;
        StdDraw.setScale(-200,200);
        double radiusOfEye = 25;
        
        
        while(true) {
            
            drawEye((-1*xCenterOfEye),yCenterOfEye,radiusOfEye);
            drawEye(xCenterOfEye,yCenterOfEye,radiusOfEye);
            
            StdDraw.clear();
            
        }
        
    }
    
    public static void drawEye(double x, double y, double rad) {
        
        double xVector = StdDraw.mouseX() - x;
        double yVector = StdDraw.mouseY() - y;
        double dist = calcDist(xVector,yVector);
        double pupilTargDist = rad - PUPIL_RADIUS;    
        xVector *= pupilTargDist/dist;
        yVector *= pupilTargDist/dist; 
        
        StdDraw.circle(x,y,rad);
        StdDraw.filledCircle(xVector+x,yVector+y,PUPIL_RADIUS);
    }
    
    public static double calcDist(double x, double y) {
        double xSquare = Math.pow(x,2);
        double ySquare = Math.pow(y,2);
        
        return Math.sqrt(xSquare + ySquare);
    }
}
