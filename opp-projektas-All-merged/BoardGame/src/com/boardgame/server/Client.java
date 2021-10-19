package com.boardgame.server;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.boardgame.GameWindow.Logic.BoardLayout;
import com.boardgame.GameWindow.Logic.PlayerIcon;
import com.boardgame.GameWindow.Logic.Square;
import com.boardgame.GameWindow.Logic.SingletonPattern.ErrorLogger;
import com.boardgame.GameWindow.Logic.StatePattern.StepsCounter;
import com.boardgame.GameWindow.utils.DicePanel;
import com.boardgame.GameWindow.utils.Die;




public class Client extends JPanel{

	static class GameAccess implements Subject {
		private Socket socket;
		private OutputStream outputStream;
		private ArrayList<Observer> list = new ArrayList<>();
		private Object asd = "";
		public int playerID;

		public void attach(Observer o) {
			list.add(o);
		}

		public void detach(Observer o) {
			list.remove(o);
		}

		//@Override
		public void notifyClients(Object asd){
			for (Observer o : list){
				o.update(asd);
			}
		}

		public void InitSocket(String server, int port, GameAccess access) throws IOException {
			socket = new Socket(server, port);
			outputStream = socket.getOutputStream();
			
			JFrame game = new JFrame();
			GameFrame cb = new GameFrame(access);
			JPanel frame = new ChatFrame(access);

			Thread receivingThread = new Thread() {
				//@Override
				public void run() {
					try {
						BufferedReader reader = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
							String temp = reader.readLine();
							System.out.println("Connected");
							int ID = Integer.parseInt(temp);
							cb.createPlayer(ID);
							game.add(cb.getGui());
							game.add(frame, BorderLayout.EAST);
							game.setTitle("StrategyBoardGame: Player " +  ID);
							game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							game.setLocationByPlatform(true);
							game.pack();
							game.setMinimumSize(game.getSize());
       						game.setLocationRelativeTo(null);
        					game.setResizable(false);
							game.setVisible(true);
							playerID = ID;
						String line;
						while ((line = reader.readLine()) != null)
						{
							asd = line;
							notifyClients(asd);
						}
					} catch (IOException x) {
						asd = x;
						notifyClients(asd);
					}
				}
			};
			receivingThread.start();
		}
		private static final String CRLF = "\r\n"; // newline

		public void send(String text) {
            try {
                outputStream.write((text + CRLF).getBytes());
                outputStream.flush();
            } catch (IOException ex) {
				asd = ex;
                notifyClients(asd);
            }
		}
		
		public void close() {
            try {
                socket.close();
            } catch (IOException ex) {
				asd = ex;
                notifyClients(asd);
            }
        }
	}

	static class ChatFrame extends JPanel implements Observer {
		private JTextArea textArea;
        private JTextField inputTextField;
        private JButton sendButton;
		private GameAccess chatAccess;
		private InterpreterContext ic = new InterpreterContext();

        public ChatFrame(GameAccess chatAccess) {
            this.chatAccess = chatAccess;
            chatAccess.attach(this);
            buildGUI();
        }

        /** Builds the user interface */
        private void buildGUI() {
            textArea = new JTextArea(50, 50);
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            add(new JScrollPane(textArea), BorderLayout.SOUTH);

            Box box = Box.createVerticalBox();
            add(box, BorderLayout.SOUTH);
            inputTextField = new JTextField();
            sendButton = new JButton("Send message");
            box.add(inputTextField, BorderLayout.SOUTH);
            box.add(sendButton, BorderLayout.SOUTH);

            // Action for the inputTextField and the goButton
            ActionListener sendListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String str = inputTextField.getText();
					if (str != null && str.trim().length() > 0)
					{
						makeChatExp message = new makeChatExp(str, chatAccess.playerID);
						//System.out.println("interpreter message done");
						String send = message.write(ic);
						//System.out.println("interpreter message after making: " + send);
						chatAccess.send(send);
					}
                    inputTextField.selectAll();
                    inputTextField.requestFocus();
                    inputTextField.setText("");
                }
            };
            inputTextField.addActionListener(sendListener);
			sendButton.addActionListener(sendListener);
        }

		/** Updates the UI depending on the Object argument */		
		public void update(Object arg) {
			final Object finalArg = arg;
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					char check = finalArg.toString().charAt(0);
					if(check == '@')
					{
						char Rolled = finalArg.toString().charAt(1);
						char ID = finalArg.toString().charAt(3);
						textArea.append("Player" + ID + " rolled " + Rolled + "!");
                    	textArea.append("\n");
					}
					else if(check != '$')
					{
						textArea.append(finalArg.toString());
						textArea.append("\n");
					}
				}
			});
		}
	}

	public static class GameFrame extends JPanel implements ActionListener, Observer  {
    

		private static final long serialVersionUID = 1L;
		// =============================================== instance variables
	private Die _left; // component for one die
	private int player_ID;
	private int P1Rolled = 0;
	private int P2Rolled = 0;
	//private JButton rollButton = new JButton("Roll");
	//private JButton undoButton = new JButton("Undo");
	//private JButton endButton = new JButton("End");
	private Buttons roll;
	private Buttons undo;
	private Buttons end;
	private StepsCounter counter = new StepsCounter(30);
	private JButton stepsLeft = new JButton("30");
	private final int maxSteps = 30;
	private int Dimensions = 16;
	private final JPanel top = new JPanel(new GridLayout(1,5,0,0));
	private JPanel Board;
	private Square[] boardSquares;
	private BoardLayout boardLayout;
	private PlayerIcon player1;
	private PlayerIcon player2;
	public boolean moveCheck = false;
	private GameAccess chatAccess;
	private InterpreterContext ic = new InterpreterContext();

	public PlayerIcon getp1(){
		return player1;
	}
	public PlayerIcon getp2(){
		return player2;
	}
	public int getID(){
		return this.player_ID;
	}
	//IF turn = 1 whites turn, if = 2 black turn
	private int turn = 1;
	//====================================================== constructor
	/** Create border layout panel with two Die's and one button. */
	public GameFrame(GameAccess chatAccess) {
		this.chatAccess = chatAccess;
		chatAccess.attach(this);
	
	//--- Create the dice
	_left = new Die();
	DicePanel dice = new DicePanel();
 
	//--- Create the button to roll the dice
	//JButton rollButton = new JButton("Roll");
	//rollButton.setFont(new Font("Sansserif", Font.PLAIN, 12));
	//rollButton.addActionListener(this);
	//undoButton.setFont(new Font("Sansserif", Font.PLAIN, 20));
	//undoButton.addActionListener(this);
	//endButton.setFont(new Font("Sansserif", Font.PLAIN, 20));
	//endButton.addActionListener(this);
	System.out.println(_left.getValue());
	//--- Create panel for two dice
	JPanel dicePanel = new JPanel();
	dicePanel.setLayout(new GridLayout(1, 2, 4, 0));
	dicePanel.add(_left);
	//--- Add components to content pane
	
	dice.setLayout(new BorderLayout());
	dice.setSize( 300, 300 );
	//dice.add(rollButton, BorderLayout.NORTH);
	//dice.add(undoButton, BorderLayout.CENTER);
	//dice.add(endButton, BorderLayout.EAST);
	roll = new ProxyButton("Roll", dice);
	undo = new ProxyButton("Undo", dice);
	end = new ProxyButton("End", dice);
	roll.addToGame(this);
	undo.addToGame(this);
	end.addToGame(this);
	dice.add(dicePanel , BorderLayout.SOUTH);
	roll.on();
	undo.off();
	end.on();
	
	
	this.setLayout(new BorderLayout());
	this.setBorder(new EmptyBorder(10, 10, 10, 10));
	JToolBar tools = new JToolBar();
	tools.setFloatable(false);
	
	top.add(dice);
	top.add(new JPanel());
	top.add(new JPanel());
	top.add(new JPanel());
	top.add(new JPanel());
	this.add(top, BorderLayout.PAGE_START);
	Board = new JPanel(new GridLayout(Dimensions, Dimensions));
	Board.setBorder(new LineBorder(Color.BLACK));
	this.add(Board);
	boardSquares = new Square[Dimensions*Dimensions];
	boardLayout = new BoardLayout(boardSquares, Board);
	// create the map board squares
	
	
	}//end constructor
	/////////////////////////////////// inner listener class RollListener
	/** Inner listener class for Roll button. */
	
	CommandHandler asdasd = new CommandHandler();
	Move mov = new Move(this);

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == roll.getButton()) {
			asdasd.addCommand(mov, player_ID);
			asdasd.doCommand();
		}
		else if(e.getSource() == undo.getButton()) {
			asdasd.addCommand(mov, player_ID);
			asdasd.undoCommand();
		}
		else if(e.getSource() == end.getButton()){
			makeCommandExp message = new makeCommandExp(String.valueOf(_left.getValue()), String.valueOf(player_ID));
			String send = message.write(ic);
			chatAccess.send(send);
			chatAccess.send("$" + player_ID);			
			int howManySteps = maxSteps - player1.getSumRolled();
			counter.setSteps(howManySteps);
			stepsLeft.setText(Integer.toString(howManySteps));
			if(counter.getState().toString() == "Red")
			{
				stepsLeft.setBackground(Color.red);
			}
			else if(counter.getState().toString()== "Green")
			{
				stepsLeft.setBackground(Color.green);
			}
			else
			{
				stepsLeft.setBackground(Color.yellow);
			}
			roll.off();
			undo.off();
			end.off();
		}
	}

	public void move(){
		if(player_ID == 0)
			{
				Board.repaint();
				_left.roll();
				P1Rolled += _left.getValue();
				//chatAccess.send("@" + String.valueOf(_left.getValue()) + " " + String.valueOf(player_ID));
				update("@" + String.valueOf(_left.getValue()) + " " + String.valueOf(player_ID));
				roll.off();
				//rollButton.setText("End turn on undo");
				//chatAccess.send("$" + player_ID);
				undo.on();
			}
			else
			{
				Board.repaint();
				_left.roll();
				P2Rolled += _left.getValue();
				//chatAccess.send("@" + String.valueOf(_left.getValue()) + " " + String.valueOf(player_ID));
				update("@" + String.valueOf(_left.getValue()) + " " + String.valueOf(player_ID));
				roll.off();				
				//chatAccess.send("$" + player_ID);
				undo.on();
			}
	}

	public void undo(int[] player, int id){
		if(id == 0){
			this.player1.setSumRolled(player[0]);
			//this.player1.setX(player[1]);
			//this.player1.setY(player[2]);
			this.player1.setRolled(0);
			//player1.setSumRolled(player1.getSumRolled()-p1);
			boardLayout.initializeBoard(player1, player2, 0);
			roll.on();
			undo.off();
		}
		else{
			this.player2.setSumRolled(player[0]);
			//this.player2.setX(player[1]);
			//this.player2.setY(player[2]);
			this.player2.setRolled(0);
			//player2.setSumRolled(player2.getSumRolled()-p2);
			boardLayout.initializeBoard(player1, player2, 1);
			roll.on();
			undo.off();
		}

	}
	
	public void createPlayer(int ID)
	{
		
		if(ID == 0)
		{
			player1 = new PlayerIcon(0,0,ID);
			player2 = new PlayerIcon(0,0,1);
			roll.on();
		}
		else{
			player1 = new PlayerIcon(0,0,0);
			player2 = new PlayerIcon(0,0,ID);
			roll.off();
			end.off();
		}
		
		this.player_ID = ID;
		System.out.println("Player ID is: " + player_ID);
		boardLayout.fillMatrix();
		boardLayout.initializeBoard(player1, player2, ID);
	}
	
	public final JComponent getGui() {
		return this;
	}
	public void update(Object arg) {
		final Object finalArg = arg;
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				char check = finalArg.toString().charAt(0);
				if (check == '@')
				{
					char Rolled = finalArg.toString().charAt(1);
					char ID = finalArg.toString().charAt(3);
					int Rl = Character.getNumericValue(Rolled);
					int id = Character.getNumericValue(ID);
					if(id == 0)
					{
						player1.setRolled(Rl);
					}
					else
					{
						player2.setRolled(Rl);
					}
					boardLayout.initializeBoard(player1, player2, id);
				}
				else if(check == '$') {
					roll.on();
					end.on();
				}
			}
		});
	}
		
	}
	
	private static int ID = 0;
	private static final String address = "127.0.0.1";
	private static final int port = 4200;

	private static final long serialVersionUID = 1L;

	public JButton     sendMessage;
	public JTextField  messageBox;
	public JTextArea   chatBox;


	public static void main(String args[]) throws IOException
	{
		GameAccess access = new GameAccess();
        try {
			access.InitSocket(address,port, access);
        } catch (IOException ex) {
			ErrorLogger.log("Cannot connect to " + address + ":" + port);
            System.out.println("Cannot connect to " + address + ":" + port);
            ex.printStackTrace();
            System.exit(0);
        }
	}
	
}
