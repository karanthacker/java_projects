package world;
import bee.Worker;
import bee.Bee;


/**class Flower Field
 *monitor lock - for worker threads to access limited flower spots
 *
 */


public class FlowerField {
    public static int  MAX_WORKERS=10;
    private int maxWorkers = 0;
    public FlowerField(){
        this.maxWorkers = FlowerField.MAX_WORKERS;
    }

    public   void incMaxWorkers() {
        this.maxWorkers +=1;
    }

    public  void decMaxWorkers() {
        this.maxWorkers -= 1;
    }
    /*
        takes in worker thread as parameter,
        lets through wait state if the flower counter is not zero
     */
    public   synchronized void enterField(Worker worker) {
        System.out.println("*FF* "+(Bee)worker+" enters field");
            while (this.maxWorkers == 0) {
                System.out.println("waiting");
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.decMaxWorkers();
        }



    /*
        exitField method increments counter and
        notify's one other bee to reach the flower
    */

    public  synchronized void exitField(Worker worker) {
        System.out.println("*FF* " + (Bee) worker + " leaves field");

        this.incMaxWorkers();
        this.notify();


    }
}