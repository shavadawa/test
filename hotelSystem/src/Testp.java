import java.awt.Color;
import java.awt.Graphics;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author misaka
 * @Date 2019-06-12 17:23:19
 * @Description
 *
 */
public class Testp extends JPanel {

	/**
	 * 
	 */
	public Testp() {
		// TODO Auto-generated constructor stub
		setBounds(0, 0, 80, 80);
		repaint();
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.BLUE);
		g.drawString("tese", 40, 40);
		g.drawLine(10, 30, 60, 30);
	}

	static Timer timer = new Timer();

	public static void main(String[] args) {
		JFrame frame = new JFrame();
//		Testp panelTestp = new Testp();
		frame.setSize(200, 200);
		frame.setLayout(null);
//		frame.add(panelTestp);
		JLabel label = new JLabel();
		label.setBounds(0, 0, 180, 80);

		frame.getContentPane().add(label);

		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				label.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			}
		}, 1000, 1000);

		frame.setVisible(true);
	}
}
