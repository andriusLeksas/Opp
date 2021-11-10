package NotYetDone.inProgress.IteratorPattern;

import com.boardgame.GameWindow.Logic.Square;

public class BoardRepository  implements Container {

    public Square[] squares;
    int index;

    public BoardRepository(int size)
    {
        squares = new Square[size];
    }

    public void print()
    {
        for (int jj = 0; jj < squares.length; jj++) {
            System.out.println(squares[jj].returnX());
        }
    }

   @Override
   public Iterator getIterator() {
      return new SquaresIterator();
   }

   public void addSquare(Square newSquare)
   {
      squares[index++] = newSquare;
   }


   private class SquaresIterator implements Iterator {

        int indx = 0;
    
      @Override
      public boolean hasNext() {
      
         if(indx < squares.length){
            return true;
         }
         return false;
      }

      @Override
      public Object next() {
      
         if(this.hasNext()){
            return squares[indx++];
         }
         return null;
      }		
   }
}
