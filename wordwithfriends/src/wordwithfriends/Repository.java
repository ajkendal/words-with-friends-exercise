/*Amanda J. Kendal-Brown
 *Words With Friends
 *Repository.java
 */
package wordwithfriends;
public class Repository{

   protected String word;
   
   public Repository(String content){
      this.word = content;
   }
   
   public void setWord(String c){
      this.word = c;
   }
   
   public String getWord(){
      return(this.word);
   }
   
   @Override
   public String toString(){
      return(this.word);
   }
}