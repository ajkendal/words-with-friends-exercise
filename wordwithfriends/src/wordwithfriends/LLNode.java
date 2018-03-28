/*Amanda J. Kendal-Brown
 *Words With Friends
 *LLNode.java
 */
package wordwithfriends;
 
public class LLNode{
   
   private LLNode link;
   private Repository info;
   
   public LLNode(Repository info){
      this.info = info;
      link = null;
   }
   
   public void setInfo(Repository info){
      this.info = info;
   }
   
   public Repository getInfo(){
      return info;
   }
   
   public void setLink(LLNode link){
      this.link = link;
   }
   
   public LLNode getLink(){
      return link;
   }  
   
   @Override
   public String toString(){
      return(info.toString());
   }
}