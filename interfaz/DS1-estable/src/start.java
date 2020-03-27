
import Vista.loading;
import Vista.login2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carban
 */
public class start {
    
    public static void main(String[] args){
        loading ll = new loading();
        ll.setLocationRelativeTo(null);
        ll.setVisible(true);
        try {
            for (int i = 0; i < 100; i++) {
                Thread.sleep(40);
                ll.setBar(i);
            }
            ll.dispose();
            login2 log = new login2();
            log.setLocationRelativeTo(null);
            log.setVisible(true);
        } catch (Exception e) {
        }
    }

}
