
package sample;

/*
 * BoxLayoutDemo.java requires no other files.
 */

public class Main {


    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Login()).setVisible(true);
            }
        });
    }

}