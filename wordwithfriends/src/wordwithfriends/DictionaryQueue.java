/*Amanda J. Kendal-Brown
 *Words With Friends
 *DictionaryQueue.java
 */
package wordwithfriends;
public class DictionaryQueue implements UnboundedQueueInterface{
   
   protected LLNode front;
   protected LLNode rear;
   
   public DictionaryQueue(){
      front = null;
      rear = null;
   }
   
   public void enqueue(Repository word){
      LLNode newNode = new LLNode(word);
      if(rear == null)
         front = newNode;
      else
         rear.setLink(newNode);
      rear = newNode;
   }
   
   public Repository dequeue() throws QueueUnderflowException{
      if(isEmpty())
         throw new QueueUnderflowException("Dictionary is Empty.");
      else{
         Repository temp;
         temp = front.getInfo();
         if(front == null)
            rear = null;
         return temp;
      }
   }
   
   public boolean isEmpty(){
      return(front == null);
   }
   
   public int size(){
      int count = 0;
      LLNode node;
      node = front;
      while(node != null){
         count++;
         node = node.getLink();
      }
      return count;
   }
   
   public void containChar(String text){
      String tempString = "";
      int instanceCount = 0;
      
      LLNode node;
      node = front;
      
      while(node != null){
         tempString = tempString + node.getInfo();
         
         for(int outerCount = text.length()-1; outerCount >= 0; outerCount --){
            for(int innerCount = tempString.length()-1;   innerCount >= 0; innerCount--){
               if(tempString.charAt(innerCount) == text.charAt(outerCount)){
                  instanceCount++;
                  
                  if(instanceCount == 1)
                     System.out.print(tempString + "\n");
               }
            }   
         }
         tempString = "";
         instanceCount = 0;
         node = node.getLink();
      }
   }
   
   public void containsPrefix(String text){
      String tempString = "";
      boolean isEqual = true;
      
      LLNode node;
      node = front;
      
      while(node != null){
         tempString = tempString + node.getInfo();
         
         for(int textCount = 0; textCount < text.length(); textCount++){
            if(text.charAt(textCount) != tempString.charAt(textCount)){
               isEqual = false;
               textCount = text.length();
            }
            else if(tempString.contains(text) == false){
               isEqual = false;
               textCount = text.length();
            }
            else if(text.length() > tempString.length()){
               isEqual = false;
               textCount = text.length();
            }
            else
               isEqual = true;
         }
         
         if(isEqual == true){
            System.out.print(tempString + "\n");
         }
             
         tempString = "";
         node = node.getLink();
      }
   }
   
   
   public void containsSuffix(String text){
      String tempString = "";
      
      LLNode node;
      node = front;
      
       while(node != null){
         tempString = tempString + node.getInfo();
         tempString = tempString.trim();
  

         if(tempString.endsWith(text) == true)
             System.out.println(tempString);
             
         tempString = "";
         node = node.getLink();
      }
   }

   
   @Override
   public String toString(){
      String tempString = null;
      int count = 1;
      
      LLNode node;
      node = front;
      
      while (node != null){
         if(count % 6 == 0){
            System.out.println(tempString);
            tempString = "";
         }
         else{
            tempString = String.format("%s %-20s", tempString, node.getInfo());
         }
         count++;
         node = node.getLink();
      }
      
      return ("\nAll " + size() + " words in the Dictionary.");
   }
}