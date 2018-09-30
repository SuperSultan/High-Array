/* Afnan Sultan (n01154597)
   Dr. Martin
   Date Last Modified: 8/31/18
   
   This program is the HighArray program by LaFore,
   but there are getMin() and getMax() methods to
   find the minimum value and maximum values, respectively
   in the array.
   
*/
   
// highArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
   //-----------------------------------------------------------
   public HighArray(int max)         // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
   //-----------------------------------------------------------
   public boolean find(long searchKey)
      {                              // find specified value
      int j;
      for(j=0; j<nElems; j++)            // for each element,
         if(a[j] == searchKey)           // found item?
            break;                       // exit loop before end
      if(j == nElems)                    // gone to end?
         return false;                   // yes, can't find it
      else
         return true;                    // no, found it
      }  // end find()
   //-----------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
   //-----------------------------------------------------------
   public boolean delete(long value)
      {
      int j;
      for(j=0; j<nElems; j++)        // look for it
         if( value == a[j] )
            break;
      if(j==nElems)                  // can't find it
         return false;
      else                           // found it
         {
         for(int k=j; k<nElems; k++) // move higher ones down
            a[k] = a[k+1];
         nElems--;                   // decrement size
         return true;
         }
      }  // end delete()
   //-----------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
   //----------------------------------------------------------
   public int getMin()		        	// gets min, returns as int
      {
      long min;			               // elements are longs
      min = a[0];			               // initialize min 
      for (int j=1; j<nElems; j++) {	// for each element,
         if (a[j] < min) {	      	// compare jth index to min
            min = a[j];		     	// set lowest jth index to min
            } 	
      }   
      return (int) min;			// returns min value as an int
      } 
   //----------------------------------------------------------
   public int getMax()			      // gets max, returns as int
      {
      long max;				            // elements are longs
      max = a[0];			               // initialize max 
      for (int j=1; j<nElems; j++) {	// for each element,
         if (a[j] > max) {		       // compare jth index to max
            max = a[j];			   // set highest jth index to max
            }
      }
      return (int) max;			// return max as int
      }      
   //-----------------------------------------------------------
   }  // end class HighArray
////////////////////////////////////////////////////////////////
class HighArrayApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      HighArray arr;                // reference to array
      arr = new HighArray(maxSize); // create the array
      int y;			               // max value
      int z;			               // min value

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      int searchKey = 35;           // search for item
      if( arr.find(searchKey) )
         System.out.println("Found " + searchKey);
      else
         System.out.println("Can't find " + searchKey);

      arr.delete(00);               // delete 3 items
      arr.delete(55);
      arr.delete(99);

      arr.display();                // display items again
      
      y=arr.getMax(); 
      System.out.println(y);
      z=arr.getMin();
      System.out.println(z); 
      
      }  // end main()
   }  // end class HighArrayApp
