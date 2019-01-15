
package GameDevelopment;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//We are using swing framework here
// for makin a frame we will be using a JFrame
public class tictac extends JFrame implements ActionListener {
	public static int BoardSize = 3;

	public static enum GameStatus { // enum is basicly we have taken different variables but in same name
		incomplete, Xwins, Zwins, Tie
	}

	private JButton[][] buttons = new JButton[BoardSize][BoardSize];
	boolean crossTurn = true; // when we click any button a time a cros will be made there.

	public tictac() {

		super.setTitle("TicTacToe");
		super.setSize(800, 800);
		GridLayout grid = new GridLayout(BoardSize, BoardSize); // This sets a layout of 3*3.
		super.setLayout(grid);
		super.setResizable(false);// this doest let the frame to de resized.
		Font font = new Font("Comic Sans", 1, 150);
		for (int i = 0; i < BoardSize; i++) {
			for (int j = 0; j < BoardSize; j++) {
				JButton button = new JButton("");
				buttons[i][j] = button;
				button.setFont(font);
				button.addActionListener(this);// attach every button with a listner.
				super.add(button);
			}
		}
		super.setVisible(true); // make frame visible on the desktop.
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		JButton clickedButton = (JButton) e.getSource();
		makeMove(clickedButton);// making move
		// Now check if someone has win the game or not.
		GameStatus gs = this.getGameStatus();
		if(gs==GameStatus.incomplete)
		{
			return;
		}
		
		declareWinner(gs);
		int choice = JOptionPane.showConfirmDialog(this, "Do you want to restart the game");
		if(choice==JOptionPane.YES_OPTION)
		{
			for (int i = 0; i < BoardSize; i++) {
				for (int j = 0; j < BoardSize; j++) {
					buttons[i][j].setText("");
				}
			}
			
			crossTurn=true;
		}
		else {
			super.dispose();
		}
	}

	private void declareWinner(GameStatus gs) {
		if(gs==GameStatus.Xwins)
		{
			JOptionPane.showMessageDialog(this, "X Wins");//To show a Message dialoge
		}else if(gs==GameStatus.Zwins)
		{
			JOptionPane.showMessageDialog(this, "Z Wins");
		}else {
			JOptionPane.showMessageDialog(this, "It is a Tie!!!");
		}
		
	}

	private GameStatus getGameStatus() {

		String text1 = "", text2 = "";

		int row = 0, col = 0;

		// text inside rows
		row = 0;
		while (row < BoardSize - 1) {
			col=0;
			while(col<BoardSize - 1) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row][col + 1].getText();
			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}

			col++;
		}
		if(col==BoardSize-1) {
			if(text1.equals("X")) {
				return GameStatus.Xwins;
			}else {
				return GameStatus.Zwins;
			}
		}
		row++;
		}
		// text inside colms
		col=0;
		while (col< BoardSize - 1) {
			row=0;
			while(row<BoardSize - 1) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row+1][col].getText();
			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}

			row++;
		}
		if(row==BoardSize-1) {
			if(text1.equals("X")) {
				return GameStatus.Xwins;
			}else {
				return GameStatus.Zwins;
			}
		}
		col++;
		}
		//Text in diagonal 1;
		
		row=0;
		col=0;
		while(row<BoardSize-1) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row+1][col+1].getText();
			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}
			row++;
			col++;
		}
		if(row==BoardSize-1)
		{
			if(text1.equals("X")) {
				return GameStatus.Xwins;
			}else {
				return GameStatus.Zwins;
			}
		}
		
		//test in diagonal2
		row=BoardSize-1;
		col=0;
		while(row>0) {
			text1 = buttons[row][col].getText();
			text2 = buttons[row-1][col+1].getText();
			if (!text1.equals(text2) || text1.length() == 0) {
				break;
			}
			row--;
			col++;
		}
		if(row==0)
		{
			if(text1.equals("X")) {
				return GameStatus.Xwins;
			}else {
				return GameStatus.Zwins;
			}
		}
		
		String txt ="";
		for(row=0;row<BoardSize;row++)
		{
			for(col=0;col<BoardSize;col++)
			{
				txt=buttons[row][col].getText();
				if(txt.length()==0)
				{
					return GameStatus.incomplete;
				}
				
			}
		}
		
		return GameStatus.Tie;
		
		
		
	}

	private void makeMove(JButton clickedButton) {
		String btntext = clickedButton.getText();

		if (btntext.length() > 0) {
			JOptionPane.showMessageDialog(this, "Invalid Move");// clicking more than once;

		} else {
			if (crossTurn) {
				clickedButton.setText("X");
			} else {
				clickedButton.setText("0");
			}

			crossTurn = !crossTurn;
		}
	}
}
