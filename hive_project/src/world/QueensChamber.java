package world;
import bee.Drone;
import bee.Bee;
import java.util.concurrent.ConcurrentLinkedQueue;
/**
 * Class QueensChamber
 * methods of this class are used to facilitate Queen and Drone thread Synchronization
 * to create child threads.
 */
public class QueensChamber {
    // collection to add drones in sequence to wait for mating
    private ConcurrentLinkedQueue <Drone> drones;
    // this flag is set to false once the queen is ready to mate in chamber
    private boolean chamberOccupied = true;

    public QueensChamber(){
        this.drones = new ConcurrentLinkedQueue<>();
    }

    public ConcurrentLinkedQueue<Drone> getDrones() {
        return drones;
    }
    public synchronized  void putDrones(Drone drone){
        drones.add(drone);
    };
    /*
    enterChamber() is called by drone to mate, if the bed is not occupied and the drone is in the start
    of the queue it will mate and exit the chamber
     */
    public synchronized void  enterChamber(Drone drone){
        System.out.println("*QC* "+(Bee)drone+" enters chamber");
        this.putDrones(drone);

        while(hasDrone()||drones.peek()!=drone){
            try{
                this.wait();
            }catch(InterruptedException e){
            }
        }
        this.chamberOccupied = true;
        System.out.println("*QC* Queen mates with "+(Bee)drone+"!");
        this.drones.poll();
        System.out.println("*QC* "+(Bee)drone+" leaves the chamber!");

    }
    /*
    terminate remaining drone threads on inactivity
     */
    public void dismissDrone(){
        for(Drone drone:drones){
            drone.stop();
            System.out.println("*QC* "+drone.toString() + " leaves chamber");
        }
    }
    /*
    true if drone and bee are mating , else false
     */
    public boolean hasDrone(){
        return chamberOccupied;
    }
    /*
    notify all drones that queen is ready for mating
     */
    public synchronized void summonDrone(){
        this.notifyAll();
        this.chamberOccupied = false;
    }
}
