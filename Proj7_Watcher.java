/* ==========================================================
 * Assignment:  Proj7_Watcher (Project #7)
 *      Author:  Jamie John David (jjdavid14@email.arizona.edu)
 * 
 *      Course:  CSc 127A, Fall 2015
 *  Instructor:  R. Lewis
 * 
 *Sect. Leader:  Sujan Patel
 *    Due Date:  10/27/2015, 9:00PM
 * ----------------------------------------------------------
 * Description:  This program simulates two eyeballs looking
 *               at the cursor by drawing two eyeballs. 
 *               The pupil of the eyeballs tracks the cursor.
 * 
 *       Input:  None
 * 
 *       Ouput:  The program will draw two eyeballs. The pupil
 *               of each eyeball will 'look' at the mouse. 
 *               Eyeballs are displayed on StdDraw canvas.
 * 
 *  Known Bugs:  None; the program operates as intended.
 * ==========================================================
 */

public class Proj7_Watcher{
    
    static final double PUPIL_RADIUS = 5;    //radius of the pupil
    
    public static void main(String[] args){
        double xCenterOfEye = 35;       //x coord of center of the eye
        double yCenterOfEye = 0;        //y coord of center of the eye
        StdDraw.setScale(-200,200);     //draws canvas with specified scale
        double radiusOfEye = 25;        //radius of the eyeball
        
        //start the infinite loop
        while(true) {
            //draws two eyeballs relatively spaced from each other
            drawEye((-1*xCenterOfEye),yCenterOfEye,radiusOfEye);
            drawEye(xCenterOfEye,yCenterOfEye,radiusOfEye);
            StdDraw.show(0);
            StdDraw.clear();
        }
        
    }
    
     /*
     * Draws an eye with a pupil. The pupil's location
     * is determined by the location of the mouse cursor.
     * 
     * @param x  :  The x-coord. for the center of eye.
     * @param y  :  The y-coord. for the center of eye.
     * @param rad:  The radius of the eye.
     */
    public static void drawEye(double x, double y, double rad) {
        //X-vector of distance from center of eye to mouse
        double xVector = StdDraw.mouseX() - x;
        //Y-vector of distance from center of eye to mouse
        double yVector = StdDraw.mouseY() - y;
        //Actual distance from center of eye to mouse (hypotenuse)
        double dist = calcDist(xVector,yVector);    
        //Distance from center of eye to center of pupil
        double pupilTargDist = rad - PUPIL_RADIUS;
        
        /*Checks if the mouse cursor is inside the eye
         *if so, draw the pupil where the mouse is.
         *if not, follow the mouse within the boundary
         *of the eye.
         */
        if(Math.abs(xVector) < pupilTargDist-PUPIL_RADIUS && 
           Math.abs(yVector) < pupilTargDist-PUPIL_RADIUS) {
            StdDraw.circle(x,y,rad);
            StdDraw.filledCircle(StdDraw.mouseX(),StdDraw.mouseY(),
                                 PUPIL_RADIUS);    
        } else {  
            xVector *= pupilTargDist/dist;
            yVector *= pupilTargDist/dist;
            StdDraw.circle(x,y,rad);
            StdDraw.filledCircle(xVector+x,yVector+y,PUPIL_RADIUS);
        }
    }
    
     /*
     * Calculates the hypotenuse of a triangle
     * 
     * @param x: X-vector of triangle
     * @param y: Y-vector of triangle
     * @returns: square root of x^2 + y^2
     */
    public static double calcDist(double x, double y) {
        double xSquare = Math.pow(x,2);     //x^2
        double ySquare = Math.pow(y,2);     //y^2
        
        return Math.sqrt(xSquare + ySquare);
    }
}
