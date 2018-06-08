/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs;
import java.awt.Color;
import java.awt.Dimension;

/**
 *
 * @author ozan
 */
//820 550
public class mapBackgorund extends javax.swing.JPanel
{
    int i = 0;
    int j = 0;
   public mapBackgorund()
   {
   }
   
   protected void draw(java.awt.Graphics g)
   {
       while(i <= 820)
       {
           g.drawLine(i, 0, i, 550);
           i = i + 20;
       }  
       
       while(j <= 560)
       {
           g.drawLine(0, j, 820, j);
           i = i + 20;
       }  
       
       
   }
   
   
    
}
