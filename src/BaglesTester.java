
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jake
 */
public class BaglesTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String input = null;
        
        Bagels game = new Bagels();
        
        do
        {
        game.play();
        
        input = JOptionPane.showInputDialog("Play another game? Press Y"
                + " to continue playing. Press any other key to quit.");
        
        
            }
        while (input.equalsIgnoreCase("Y"));
        
        System.out.println("Thank you for playing!");
        
        System.exit(0);
        
        
        
    }
    
}
