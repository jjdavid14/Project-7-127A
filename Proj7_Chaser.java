/* ==========================================================
 * Assignment:  Proj7_Chaser (Project #7)
 *      Author:  Jamie John David (jjdavid14@email.arizona.edu)
 * 
 *      Course:  CSc 127A, Fall 2015
 *  Instructor:  R. Lewis
 * 
 *Sect. Leader:  Sujan Patel
 *    Due Date:  10/27/2015, 9:00PM
 * 
 *    Packages:  java.util.Random
 * ----------------------------------------------------------
 * Description:  This program draws circles filled with different colors.
 *               The circles form a trail chasing the mouse cursor.
 * 
 *       Input:  None
 * 
 *       Ouput:  The program will display a filled circle that is
 *               changing into random colors and leave a trail of 
 *               colored circles. All output is displayed on 
 *               StdDraw canvas.
 * 
 *  Known Bugs:  None; the program operates as intended.
 * ==========================================================
 */

import java.util.Random;       //For access to random integers.

public class Proj7_Chaser{
    public static void main(String[] args){
        
        final int SCALE_MIN = -100;  //minimum range for scale
        final int SCALE_MAX = 100;   //maximum range for scale
        
        //Draws the StdDraw canvas
        StdDraw.setScale(SCALE_MIN,SCALE_MAX);
        
        double xCoord = (SCALE_MAX + SCALE_MIN)/2;  //sets x coord. at middle
        double yCoord = (SCALE_MAX + SCALE_MIN)/2;  //sets y coord. at middle
        
        //Random object for generating random integers
        Random rand = new Random();
        
        //starts the infinite loop
        while(true){
            /*
             * Increase/decrease x and y coordinate accordingly by 1
             * each iteration until x and y coordinates of the circle
             * are equals to the x and y coordinates of the cursor.
             */
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
                //Clears the screen if mouse is pressed
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
