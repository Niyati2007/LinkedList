import java.util.*;

public class LLNode_Batra<T> implements Node<T> {
  private T data;
  private LLNode_Batra<T> next;
    
  public LLNode_Batra(T data)
  {
    this.data = data;
    this.next = null;
  }

  public LLNode_Batra<T> getNext(){
    return next;
  }
  
  public void setNext(Node<T> newNext){
    next = (LLNode_Batra) newNext;
  }
  
  public T getData(){
      return data;
  }
  
  public void setData(T newData){
    data = newData;
  }
  
}