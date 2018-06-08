/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;

/**
 *
 * @author ozan
 */
import javax.swing.JFrame;

public class Main
{
   //-----------------------------------------------------------------
       //  Creates and displays the temperature converter GUI.
   //-----------------------------------------------------------------
   public static void main (String[] args)
   {
      JFrame frame = new JFrame ("Distance Founder by OZ TECHNOLOGIES");
      frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

      MapPanel panel = new MapPanel();

      frame.getContentPane().add(panel);
      frame.pack();
      frame.setVisible(true);
   }
}
