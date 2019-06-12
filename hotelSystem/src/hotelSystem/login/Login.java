package hotelSystem.login;

import javax.swing.JOptionPane;

import hotelSystem.dao.setting.DBConnection;
import hotelSystem.ui.system.SystemMain;

public class Login {

	// 查询用户名
	public static String sqlOfSelectUser = "select userID from tb_user;";

	// 查询指定用户名的密码
	public static String sqlOfCheckUserPw = "select password from tb_user where userID=?;";

	// 获取用户名
	public static void getUser(LoginUi login) {
		Object[][] user = DBConnection.selectResult(sqlOfSelectUser).getRowsByIndex();
		for (int i = 0; i < user.length; i++) {
			login.comboBox_user.addItem(user[i][0].toString());
		}

	}

	// 判断登录
	public static void login(LoginUi login) {
		String user = login.comboBox_user.getSelectedItem().toString();
		String pw = String.valueOf(login.pwText_login.getPassword());
		Object[][] check = DBConnection.selectResult(sqlOfCheckUserPw, user).getRowsByIndex();
		if ((check[0][0].toString()).equals(pw)) {
			new SystemMain().setVisible(true);
			login.dispose();
		} else {
			JOptionPane.showMessageDialog(login, "登录失败", "提示", 0);
		}
	}
}
