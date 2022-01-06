package ui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.PrintWriter;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;

public class UI {
	// main frame
	public static JFrame mf;
	// main panel
	public static JPanel mp;
	// notice label (top)
	public static JLabel notice_top;
	// notice label (middle)
	public static JLabel notice_middle;
	// player seat (A~G)
	public static JPanel player_A; // me
	public static JPanel player_B; // bottom-left
	public static JPanel player_C; // middle-left
	public static JPanel player_D; // top-left
	public static JPanel player_E; // top-right
	public static JPanel player_F; // middle-right
	public static JPanel player_G; // bottom-right
	// playerNames in each seat
	public static JLabel player_A_name;
	public static JLabel player_B_name;
	public static JLabel player_C_name;
	public static JLabel player_D_name;
	public static JLabel player_E_name;
	public static JLabel player_F_name;
	public static JLabel player_G_name;
	// playerCharacter in each seat
	public static JButton player_A_character;
	public static JButton player_B_character;
	public static JButton player_C_character;
	public static JButton player_D_character;
	public static JButton player_E_character;
	public static JButton player_F_character;
	public static JButton player_G_character;
	// playerRole in each seat
	public static JButton player_A_role;
	public static JButton player_B_role;
	public static JButton player_C_role;
	public static JButton player_D_role;
	public static JButton player_E_role;
	public static JButton player_F_role;
	public static JButton player_G_role;
	// playerGun in each seat
	public static JButton player_A_gun;
	public static JButton player_B_gun;
	public static JButton player_C_gun;
	public static JButton player_D_gun;
	public static JButton player_E_gun;
	public static JButton player_F_gun;
	public static JButton player_G_gun;
	// scenario(turn/wildWest)
	public static JButton scenario_turn_back;
	public static JButton scenario_turn_front;
	public static JButton scenario_wild_back;
	public static JButton scenario_wild_front;
	// scenario notice (next,now)
	public static JLabel scenario_turn_next;
	public static JLabel scenario_turn_now;
	// select panel (role)
	public static JPanel select_panel_role;
	// select panel (character)
	public static JPanel select_panel_character;
	// select panel (scenario)
	public static JPanel select_panel_scenario;
	// select remain
	public static int select_chance = 0;
	
	public UI(String userName, PrintWriter os) {
		// init main frame & main panel
		init_main(userName);
		// init notices
		init_notices();
		// init seats
		init_seats();
		// init select panel
		init_select_panel_role();
		init_select_panel_character();
		init_select_panel_scenario();
		// init scenario & scenario_notice
		init_scenario();
		init_scenario_notice();
		
//		// test (show players panels)
//		mp.add(player_A);
//		mp.add(player_B);
//		mp.add(player_C);
//		mp.add(player_D);
//		mp.add(player_E);
//		mp.add(player_F);
//		mp.add(player_G);
//		mp.repaint();
//		// test (이름넣어주기)
//		player_B_name.setText("B");
//		player_C_name.setText("C");
//		player_D_name.setText("D");
//		player_E_name.setText("E");
//		player_F_name.setText("F");
//		player_G_name.setText("G");
		
//		// test (직업 선택 완료)
//		CardMaker.make_card_handField_role(player_A_name.getText(), "vice", true);
//		CardMaker.make_card_handField_role(player_B_name.getText(), "sceriffo", true);
//		CardMaker.make_card_handField_role(player_C_name.getText(), "vice", true);
//		CardMaker.make_card_handField_role(player_D_name.getText(), "vice", false);
//		CardMaker.make_card_handField_role(player_E_name.getText(), "vice", true);
//		CardMaker.make_card_handField_role(player_F_name.getText(), "vice", false);
//		CardMaker.make_card_handField_role(player_G_name.getText(), "vice", true);
//		// test (직업 이미지 보이게)
//		Setter.setPlayerRoleImageAvailable("A", true);
//		Setter.setPlayerRoleImageAvailable("B", true);
//		Setter.setPlayerRoleImageAvailable("C", true);
//		Setter.setPlayerRoleImageAvailable("D", true);
//		Setter.setPlayerRoleImageAvailable("E", true);
//		Setter.setPlayerRoleImageAvailable("F", true);
//		Setter.setPlayerRoleImageAvailable("G", true);
		
//		// test (캐릭터 선택 완료)
//		CardMaker.make_card_handField_character(player_A_name.getText(), "dodge_city", "vera_custer");
//		CardMaker.make_card_handField_character(player_B_name.getText(), "dodge_city", "vera_custer");
//		CardMaker.make_card_handField_character(player_C_name.getText(), "dodge_city", "vera_custer");
//		CardMaker.make_card_handField_character(player_D_name.getText(), "dodge_city", "vera_custer");
//		CardMaker.make_card_handField_character(player_E_name.getText(), "dodge_city", "vera_custer");
//		CardMaker.make_card_handField_character(player_F_name.getText(), "dodge_city", "vera_custer");
//		CardMaker.make_card_handField_character(player_G_name.getText(), "dodge_city", "vera_custer");
//		// test (캐릭터 이미지 보이게)
//		Setter.setPlayerCharacterImageAvailable(player_A_name.getText(), true);
//		Setter.setPlayerCharacterImageAvailable(player_B_name.getText(), true);
//		Setter.setPlayerCharacterImageAvailable(player_C_name.getText(), true);
//		Setter.setPlayerCharacterImageAvailable(player_D_name.getText(), true);
//		Setter.setPlayerCharacterImageAvailable(player_E_name.getText(), true);
//		Setter.setPlayerCharacterImageAvailable(player_F_name.getText(), true);
//		Setter.setPlayerCharacterImageAvailable(player_G_name.getText(), true);

//		// test (캐릭터 선택창 만들기)
//		select_panel_character.removeAll();
//		select_panel_character.add(CardMaker.make_card_select_panel_character("original", "bart_cassidy"));
//		select_panel_character.add(CardMaker.make_card_select_panel_character("original", "bart_cassidy"));
//		select_panel_character.add(CardMaker.make_card_select_panel_character("original", "bart_cassidy"));
//		select_panel_character.add(CardMaker.make_card_select_panel_character("original", "bart_cassidy"));
//		select_panel_character.setVisible(true);
		
//		// test (시나리오 선택창 만들기)
//		select_panel_scenario.removeAll();
//		select_panel_scenario.setVisible(true);

//		// test (선택창 만들기)
//		select_panel_role.removeAll();
//		select_panel_role.add(CardMaker.make_card_select_panel_character("original", "bart_cassidy"));
//		select_panel_role.add(CardMaker.make_card_select_panel_playing("brown", "bang", 'C', '2'));
//		select_panel_role.setVisible(true);
		
		
//		select_chance = 1;
//		select_panel.add(CardMaker.make_card_select_panel_role("vice",os,1));
	}
	
	// init scenario
	private void init_scenario() {
		// init buttons
		scenario_turn_back = new JButton();
		scenario_turn_front = new JButton();
		scenario_wild_back = new JButton();
		scenario_wild_front = new JButton();
		// set bounds
		scenario_turn_back.setBounds(460,435,87,135);
		scenario_turn_front.setBounds(550,435,87,135);
		scenario_wild_back.setBounds(640,435,87,135);
		scenario_wild_front.setBounds(730,435,87,135);
		// set button fill false
		scenario_turn_back.setContentAreaFilled(false);
		scenario_turn_front.setContentAreaFilled(false);
		scenario_wild_back.setContentAreaFilled(false);
		scenario_wild_front.setContentAreaFilled(false);
		// set image icon
		scenario_turn_back.setIcon(new ImageIcon(".\\.\\resources\\card\\empty_87.png"));
		scenario_turn_front.setIcon(new ImageIcon(".\\.\\resources\\card\\empty_87.png"));
		scenario_wild_back.setIcon(new ImageIcon(".\\.\\resources\\card\\empty_87.png"));
		scenario_wild_front.setIcon(new ImageIcon(".\\.\\resources\\card\\empty_87.png"));
		// set visible = false
		scenario_turn_back.setVisible(false);
		scenario_turn_front.setVisible(false);
		scenario_wild_back.setVisible(false);
		scenario_wild_front.setVisible(false);
		//add into main_panel
		mp.add(scenario_turn_back);
		mp.add(scenario_turn_front);
		mp.add(scenario_wild_back);
		mp.add(scenario_wild_front);
	}
	
	// init scenario notice
	private void init_scenario_notice() {
		// init
		scenario_turn_next = new JLabel("Next(+12)");
		scenario_turn_now = new JLabel("Now");
		// set font
		scenario_turn_next.setFont(new Font("Serif",1,25));
		scenario_turn_now.setFont(new Font("Serif",1,25));
		// set text color
		scenario_turn_next.setForeground(Color.WHITE);
		scenario_turn_now.setForeground(Color.WHITE);
		// set bound
		scenario_turn_next.setBounds(439,395,130,50);
		scenario_turn_now.setBounds(545,395,100,50);
		// set text center
		scenario_turn_next.setHorizontalAlignment(SwingConstants.CENTER);
		scenario_turn_now.setHorizontalAlignment(SwingConstants.CENTER);
		// set invisible
		scenario_turn_next.setVisible(false);
		scenario_turn_now.setVisible(false);
		// add those into main panel
		mp.add(scenario_turn_next);
		mp.add(scenario_turn_now);
	}
	
	// init seats things
	private void init_seats() {
		// seats image
		init_seats_image();
		// player name label
		init_playerName();
	}
	
	// init main frame & main panel
	private void init_main(String userName) {
		// set title
		mf = new JFrame("Bang! - Board Game ("+userName+")");
		// set close operation
		mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set screen size
		mf.setSize(1920,1040);
		// set resize false
		mf.setResizable(false);
		// if mouse moved, repaint
		mf.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				mf.repaint();
			}
		});
		
		// set main panel
		mp = new JPanel(){
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_sample1.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set no layout
		mp.setLayout(null);
		// add main panel into main frame
		mf.setContentPane(mp);
	}
	
	// init select role panel
	private void init_select_panel_role() {
		// set select_panel image
		select_panel_role = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_select_panel_role.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		select_panel_role.setBounds(300,180,1300,553);
		// set border
		// select_panel_role.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout (flow layout) & align center & hgap & vgap
		select_panel_role.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 284));
		// add select_panel into main_panel
		mp.add(select_panel_role);
		// disable select_panel
		select_panel_role.setVisible(false);
	}
	
	// init select character panel
	private void init_select_panel_character() {
		// set select_panel_character image
		select_panel_character = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_select_panel_character.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		select_panel_character.setBounds(451,93,1002,753);
		// set border
		// select_panel_character.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout (flow layout) & align center & hgap & vgap
		select_panel_character.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 284));
		// add select_panel_character into main_panel
		mp.add(select_panel_character);
		// disable select_panel_character
		select_panel_character.setVisible(false);
	}
	
	// init select scenario panel
	private void init_select_panel_scenario() {
		// set select_panel image
		select_panel_scenario = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_select_panel_scenario.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		select_panel_scenario.setBounds(300,180,1300,553);
		// set border
		// select_panel_scenario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout (flow layout) & align center & hgap & vgap
		select_panel_scenario.setLayout(new FlowLayout(FlowLayout.CENTER, 25, 284));
		// add select_panel into main_panel
		mp.add(select_panel_scenario);
		// disable select_panel
		select_panel_scenario.setVisible(false);
	}
	
	
	// init seats image
	private void init_seats_image() {
		// set player_A image(me)
		player_A = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_player.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_A.setBounds(722,585,470,277);
		// set border
		// player_A.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_A.setLayout(null);
		
		// set player_B image(bottom-left)
		player_B = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_player.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_B.setBounds(205,615,470,277);
		// set border
		// player_B.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_B.setLayout(null);
		
		// set player_C image(middle-left)
		player_C = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_player_C.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_C.setBounds(150,130,277,470);
		// set border
		// player_C.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_C.setLayout(null);

		// set player_D image(top-left)
		player_D = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_player_DE.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_D.setBounds(440,120,470,277);
		// set border
		// player_D.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_D.setLayout(null);

		// set player_E image(top-right)
		player_E = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_player_DE.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_E.setBounds(995,120,470,277);
		// set border
		// player_E.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_E.setLayout(null);
		
		// set player_F image(middle-right)
		player_F = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_player_F.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_F.setBounds(1480,130,277,470);
		// set border
		// player_F.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_F.setLayout(null);
		
		// set player_G image(bottom-right)
		player_G = new JPanel() {
			private static final long serialVersionUID = 1L;
			Image background = new ImageIcon(".\\.\\resources\\background\\background_player.png").getImage();
			// drawing background
			protected void paintComponent(Graphics g) {
				g.drawImage(background, 0, 0, null);
			}
		};
		// set bound
		player_G.setBounds(1240,615,470,277);
		// set border
		// player_G.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		// set layout
		player_G.setLayout(null);
	}
	
	private void init_playerName() {
		// set playerName_A label
		player_A_name = new JLabel();
		// set font
		player_A_name.setFont(new Font("Serif",1,25));
		// set text color
		player_A_name.setForeground(Color.WHITE);
		// set bound
		player_A_name.setBounds(808,690,300,50);
		// set text align center
		player_A_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_A_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_B label
		player_B_name = new JLabel();
		// set font
		player_B_name.setFont(new Font("Serif",1,25));
		// set text color
		player_B_name.setForeground(Color.WHITE);
		// set bound
		player_B_name.setBounds(290,725,300,50);
		// set text align center
		player_B_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_B_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_C label
		player_C_name = new JLabel();
		// set font
		player_C_name.setFont(new Font("Serif",1,25));
		// set text color
		player_C_name.setForeground(Color.WHITE);
		// set bound
		player_C_name.setBounds(135,340,300,50);
		// set text align center
		player_C_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_C_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_D label
		player_D_name = new JLabel();
		// set font
		player_D_name.setFont(new Font("Serif",1,25));
		// set text color
		player_D_name.setForeground(Color.WHITE);
		// set bound
		player_D_name.setBounds(525,230,300,50);
		// set text align center
		player_D_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_D_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_E label
		player_E_name = new JLabel();
		// set font
		player_E_name.setFont(new Font("Serif",1,25));
		// set text color
		player_E_name.setForeground(Color.WHITE);
		// set bound
		player_E_name.setBounds(1080,230,300,50);
		// set text align center
		player_E_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_E_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_F label
		player_F_name = new JLabel();
		// set font
		player_F_name.setFont(new Font("Serif",1,25));
		// set text color
		player_F_name.setForeground(Color.WHITE);
		// set bound
		player_F_name.setBounds(1465,340,300,50);
		// set text align center
		player_F_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_F_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		
		// set playerName_G label
		player_G_name = new JLabel();
		// set font
		player_G_name.setFont(new Font("Serif",1,25));
		// set text color
		player_G_name.setForeground(Color.WHITE);
		// set bound
		player_G_name.setBounds(1325,725,300,50);
		// set text align center
		player_G_name.setHorizontalAlignment(SwingConstants.CENTER);
		// set border
		// player_G_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	// init notices label properties
	private void init_notices() {
		// top
		// set notice label
		notice_top = new JLabel();
		// set font
		notice_top.setFont(new Font("Serif",1,50));
		// set text color
		notice_top.setForeground(Color.BLACK);
		// set bound
		notice_top.setBounds(460,170,1000,100);
		// set text center
		notice_top.setHorizontalAlignment(SwingConstants.CENTER);
		
		// middle
		// set notice label
		notice_middle = new JLabel();
		// set font
		notice_middle.setFont(new Font("Serif",1,50));
		// set text color
		notice_middle.setForeground(Color.BLACK);
		// set bound
		notice_middle.setBounds(460,440,1000,100);
		// set text center
		notice_middle.setHorizontalAlignment(SwingConstants.CENTER);
		
		// set notice available (middle) -> That is default
		Setter.setNoticeAvailable(2,true);
	}
	
	// set visible
	public void setVisible(boolean b) {
		mf.setVisible(b);
	}

}