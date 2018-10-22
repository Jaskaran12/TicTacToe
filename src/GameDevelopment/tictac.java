
package GameDevelopment;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

//We are using swing framework here
// for makin a frame we will be using a JFrame
public class tictac extends JFrame {
	public static int BoardSize = 3;
	
	public static enum Gamestatus{ //enum is basicly we have taken different variables but in same name
		incomplete,Xwins,Zwins,Tie
	}
	private JButton[][] buttons = new JButton[BoardSize][BoardSize];
	boolean crossTurn = true; // when we click any button a time a cros will be made there.
	public tictac(){
		
		super.setTitle("TicTacToe");
		super.setSize(800, 800);
		GridLayout grid = new GridLayout(3,3); // This sets a layout of 3*3.
		super.setLayout(grid);
		super.setResizable(false);//this doest let the frame to de resized.
		Font font = new Font("Comic Sans",1,150);
		for (int i =0;i<BoardSize;i++)
		{
			for(int j = 0 ;j<BoardSize;j++)
			{
				JButton button = new JButton("");
				buttons[i][j] = button;
				button.setFont(font);
				super.add(button);
			}
		}
		super.setVisible(true); //make frame visible on the desktop.
	}
	

}
