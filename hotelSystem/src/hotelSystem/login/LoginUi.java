package hotelSystem.login;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 登陆界面
 * */
public class LoginUi extends JFrame {

	public JPasswordField pwText_login;
	public JComboBox<Object> comboBox_user;

	public LoginUi() {

		setSize(570, 470);
		setLocationRelativeTo(null);
		setTitle("系统登陆");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		{
			JLabel label = new JLabel("用户名");
			label.setBounds(79, 158, 85, 29);
			getContentPane().add(label);

			JLabel label_1 = new JLabel("密  码");
			label_1.setBounds(79, 215, 85, 29);
			getContentPane().add(label_1);

			comboBox_user = new JComboBox<Object>();
			comboBox_user.setBounds(198, 155, 235, 35);
			getContentPane().add(comboBox_user);

			pwText_login = new JPasswordField();
			pwText_login.setBounds(198, 212, 235, 35);
			getContentPane().add(pwText_login);

			JButton button_login = new JButton("登录");
			button_login.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Login.login(LoginUi.this);
				}
			});
			button_login.setBounds(79, 324, 153, 37);
			getContentPane().add(button_login);

			JButton button_exit = new JButton("退出");
			button_exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			button_exit.setBounds(330, 324, 153, 37);
			getContentPane().add(button_exit);
		}
		Login.getUser(LoginUi.this);
	}
}
