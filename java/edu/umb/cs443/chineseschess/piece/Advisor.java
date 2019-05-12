package edu.umb.cs443.chinese_chess.piece;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;

import java.util.LinkedList;

import edu.umb.cs443.chinese_chess.Board;
import edu.umb.cs443.chinese_chess.Point2D;
import edu.umb.cs443.chinese_chess.R;

public class Advisor extends Piece {
    public Advisor(boolean isRed, int X, int Y, int id){
        super(isRed, X, Y, id);
    }

    @Override
    public boolean move(int X, int Y, Board board){
        LinkedList<Point2D> movelist = getMoveList(board);
        if(movelist.contains(new Point2D(X,Y))){
            int oldX = this.X;
            int oldY = this.Y;
            this.X = X;
            this.Y = Y;
            board.updatePos(this, oldX, oldY);
            return true;
        }else
            return false;
    }

    public LinkedList<Point2D> getMoveList(Board board){
        LinkedList<Point2D> list = new LinkedList<Point2D>();
        if (isRed){
            if (board.isInRedPalace(X + 1, Y + 1))
                list.add(new Point2D(X + 1, Y + 1));
            if (board.isInRedPalace(X - 1, Y - 1))
                list.add(new Point2D(X - 1, Y - 1));
            if (board.isInRedPalace(X + 1, Y - 1))
                list.add(new Point2D(X + 1, Y - 1));
            if (board.isInRedPalace(X - 1, Y + 1))
                list.add(new Point2D(X - 1, Y + 1));
        }
        else{
            if (board.isInBlackPalace(X + 1, Y + 1))
                list.add(new Point2D(X + 1, Y + 1));
            if (board.isInBlackPalace(X - 1, Y - 1))
                list.add(new Point2D(X - 1, Y - 1));
            if (board.isInBlackPalace(X + 1, Y - 1))
                list.add(new Point2D(X + 1, Y - 1));
            if (board.isInBlackPalace(X - 1, Y + 1))
                list.add(new Point2D(X - 1, Y + 1));
        }
        return list;
    }

    public static boolean checkPos(int X, int Y,boolean isRed){
        if (isRed && (X == 4 && Y == 0) || (X == 5 && Y == 1) || (X == 6 && Y == 0) || (X == 4 && Y == 2) || (X == 6 && Y == 2))
            return true;
        else if (!isRed && (X == 4 && Y == 9) || (X == 5 && Y == 8) || (X == 6 && Y == 9) || (X == 4 && Y == 7) || (X == 6 && Y == 7))
            return true;
        return false;
    }
/*
    public class display extends Activity {
        ImageView red;
        ImageView black;

        public void displays(){
            red = (ImageView) findViewById(R.id.image_advisor_red);
            black = (ImageView) findViewById(R.id.image_advisor_black);
        }
    }
*/
    @Override
    public String toString(){
        if(isRed)
            return "仕";
        else
            return "士";
    }
}
