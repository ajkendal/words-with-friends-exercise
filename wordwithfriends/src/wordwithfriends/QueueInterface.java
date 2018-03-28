/*Amanda J. Kendal-Brown
 *Words With Friends Problem
 *QueueInterface.java
 */
package wordwithfriends;

public interface QueueInterface{

   public Repository dequeue() throws QueueUnderflowException;
   //Throws QueueUnderflowException if the queue is empty
   //If it is not empty, will remove front Repository and return it.
   
   public boolean isEmpty();
   //if queue is empty will return true, else will return false;
   
}