public class ImprovedArrayList implements MyList
{
    private int size;
    private Object[] data;
    
    public ImprovedArrayList()
    {
        // Let the other constructor do the work!
        this(0);
    }

    public ImprovedArrayList(int x)
    {
        size = 0;
        data = new Object[x];

    }

        
    public boolean add(Object obj){
        if(size + 1 > data.length){
            addTwice();
            data[size ] = obj;
            size ++;
        
        }
        else{
            data[size] = obj;
            size ++;
        }
            
        return true;
        
    }
    
    /**
     *  Add obj to the specified index of the list.
     *  If index is too big, then add obj to the end of the list
     *  If index is too small, then add obj to the start of the list
     */
    public void add(int index, Object obj){
       if(size + 1 > data.length){
            addTwice();
        }
       if(index > size){
           data[index] = obj;
           size ++;
           
       } else if(index <= 0){
             Object d[] = new Object[data.length + 1];
             d[0] = obj;
             
             for(int i = 1; i <= data.length; i++){
               d[i] = data[i-1];
            }
     
            data = d;
        }
        else{
            Object d[] = new Object[data.length + 1];
            for(int i = 0; i < index; i++){
               d[i] = data[i];
            }
            d[index] = obj;
            for(int i = index + 1; i < d.length; i++){
                d[i] = data[i-1];
            }
            data = d; 
        }
    }
    
    /**
     *  Return true is this list contains something that is .equals() to obj
     */
    public boolean contains(Object obj){
           for(Object ob : data){
               if(obj.equals(ob) && ob != null){
                   return true;
                }
            }
           
           return false;
       }
    
    /**
     *  Return the Object located at the specified index
     *  If index is too big or too small, return null
     */
    public Object get(int index){
          
          return index > size || index < 0 ? null : data[index];
       }
    
    /**
     *  Return true if there are no elements in the list
     */
    public boolean isEmpty(){
           
           return size <= 0;
       }
    
    /**
     *  Remove the Object at the specified index from the list
     *  Return the Object that was removed
     *  If index is too big or to small, do not remove anything from the list and return null
     *  If the list is empty, return null
     */
    public Object remove(int index){
        
           if( index < 0 || index > data.length -1)
            return null;
           if(data.length == 0)
            return null;
           Object old = null;
           Object[] d = new Object[data.length - 1];

           for(int i = 0 ; i < data.length; i++){
               if(i != index){ // 1 30 , 1, 23, 12  /// 1, 30, 23, 12 
                   if(i<index)
                    d[i] = data[i];
                   if(i > index)
                    d[i -1] = data[i];
               }
               else{
                   old = data[i];
                   size --;
               }

           }

           data = d;
           return old;
     
       }

    /**
     *  Remove the first Object that is .equals() to obj
     *  Return true if an object was removed
     */
    public boolean remove(Object obj){ /// 
           
           int  i = 0;
         
           for(i = 0; i < data.length; i++){
               if(data[i] != null && data[i].equals(obj)){
             
                   remove(i);
                   return true;
                }
              
            }
            size++;
            return false;
       }
    
    /**
     *  Change the value stored at index to obj
     *  Return the value that was replaced
     *  If index is too big or too smalll, do not change and values and return null
     */
    public Object set(int index, Object obj){
        if(index > data.length - 1 || index < 0)
            return null;
        Object old = null;
        if(data[index] == null){
            return null;
        }
        old = data[index];
        data[index] = obj;
        return old;
       }
    
    /**
     *  Return the number of elements that are in the list
     */
    public int size(){
        
        int s = 0;
        for(int i = 0; i < data.length; i++){if(data[i] != null) s++; }
           return s;
       }
       private void addTwice(){
           Object[] d = new Object[(data.length + 1) * 2];
            for(int i = 0; i<data.length; i++ ){
                d[i] = data[i];
                
            }
            data = d; 
        }
}