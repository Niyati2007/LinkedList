//------------------------- Day 1 -------------------------
import java.util.*;

public class LL_Batra<T> implements LinkedListInterface<T>
  {
    LLNode_Batra<T> first;

    public LL_Batra()
    {
      first = null;
    }

//----------------------- contains() ------------------------
    
    public boolean contains (T element)
    {
      LLNode_Batra<T> current = first;
      
      while (current != null)
        {
          if(element.equals(current.getData()))
          {
            return true;
          }
          current = current.getNext();
        }
      
      return false;
    }

//----------------------- indexOf() ------------------------

    public int indexOf(T element)
    {
      int index = 0;
      LLNode_Batra<T> current = first;
      
      while(current != null)
        {
          if(element.equals(current.getData()))
          {
            return index;
          }

          current = current.getNext();
          index++;
        }
      
      return -1;
    }

//--------------------- lastIndexOf() -----------------------

    public int lastIndexOf(T element)
    {
      int index = 0;
      int lastIndex = -1;
      LLNode_Batra<T> current = first;

      while(current != null)
        {
          if(element.equals(current.getData()))
             {
            lastIndex = index;
             }

          current = current.getNext();
          index++;
        }

      return lastIndex;
    }

//----------------------- isEmpty() -------------------------

    public boolean isEmpty()
    {
      return first == null;
    }
//------------------------- size() --------------------------
    
    public int size()
    {
      int count = 0;
      LLNode_Batra<T> current = first;

      while (current != null)
        {
          count++;
          current = current.getNext();
        }
      return count;
    }

//-------------------------- get() --------------------------

  public T get(int index)
    {
      if (index < 0 || index >= size())
      {
        throw new IndexOutOfBoundsException();
      }

      LLNode_Batra<T> current = first;
      
      for(int i = 0; i < index; i++)
        {
          current = current.getNext();
        }
       return current.getData();     
    }

//-------------------------- set() --------------------------

    public void set(int index, T element)
    {
      if (index < 0 || index >= size())
      {
        throw new IndexOutOfBoundsException();
      }

      
      LLNode_Batra<T> current = first;
      
      for(int i = 0; i < index; i++)
        {
          current = current.getNext();
        }
      current.setData(element);
 
    }

//------------------------- clear() -------------------------

    public void clear()
    {
      first = null;
    }

//------------------------ add(E e) -------------------------

    public void add(T element)
    {
      LLNode_Batra<T> newNode = new LLNode_Batra<>(element);

      if (first == null)
      {
        first = newNode;
      }
      else
      {
        LLNode_Batra<T> current = first;
        
        while(current.getNext() != null)
          {
            current = current.getNext();
          }
        
        current.setNext(newNode);
      }
    }
    
//---------------- add(int index, E element) ----------------

    public void add(int index, T element)
    {
      if (index < 0 || index > size())
      {
        throw new IndexOutOfBoundsException();
      }

      LLNode_Batra<T> newNode = new LLNode_Batra<>(element);

      if(index == 0)
      {
        newNode.setNext(first);
        first = newNode;
      }
      else
      {
        LLNode_Batra<T> current = first;

        for(int i = 0; i < index - 1; i++)
          {
            current = current.getNext();
          }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
      }
      
    }

//--------------------- remove(int index) --------------------
    
    public T remove(int index)
    {
      if (index < 0 || index >= size())
      {
        throw new IndexOutOfBoundsException();
      }

      LLNode_Batra<T> removedElem;

      if(index == 0)
      {
        removedElem = first;
        first = first.getNext();
      }
      else
      {
        LLNode_Batra<T> current = first;

        for(int i = 0; i < index - 1; i++)
          {
            current = current.getNext();
          }

        removedElem = current.getNext();
        current.setNext(removedElem.getNext());
      }

      return removedElem.getData();
    }

//--------------------- remove(T element) --------------------

    public boolean remove(T element)
    {
      LLNode_Batra<T> nextNode = first;
      LLNode_Batra<T> prevNode = null;

      while (nextNode != null)
        {
          if(nextNode.getData().equals(element))
          {
            if (prevNode == null)
            {
              first = nextNode.getNext();
            }
            else
            {
              prevNode.setNext(nextNode.getNext());
            }
            return true;
          }

          prevNode = nextNode;
          nextNode = nextNode.getNext();
        }
        return false;
        }
  }