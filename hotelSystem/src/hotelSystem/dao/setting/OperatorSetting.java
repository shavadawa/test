package hotelSystem.dao.setting;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import hotelSystem.ui.setting.setting.SettingFrame;

/*
 * 
 * 操作员设置界面
 * */
public class OperatorSetting {

	// 查询用户
	public static String sqlOfSelectUser = "select userID,power from tb_user;";
	// 添加用户
	public static String sqlOfAddUser = "insert into tb_user values(?,?,?);";
	// 删除用户
	public static String sqlOfDeleteUser = "delete from tb_user where userID=?;";
	// 查询用户名
	public static String sqlOfSelectUserID = "select userID from tb_user;";
	// 查询密码
	public static String sqlOfSelectPW = "select password from tb_user where userID=?;";
	// 修改密码
	public static String sqlOfChangePW = "update tb_user set password=? where userID=?;";

	// 查询用户
	public void selectUser() {
		String[] cName = { "用户ID", "用户权限" };
		Object[][] objects = DBConnection.selectResult(sqlOfSelectUser).getRowsByIndex();
		for (int i = 0; i < objects.length; i++) {
			if (Integer.parseInt(objects[i][1].toString()) == 1) {
				objects[i][1] = "管理员";
			} else if (Integer.parseInt(objects[i][1].toString()) == 0) {
				objects[i][1] = "操作员";
			}
		}
		DefaultTableModel tableModel = new DefaultTableModel(objects, cName);
		SettingFrame.table_operator_list.setModel(tableModel);
	}

	// 用户注册
	public void addUser(SettingFrame mainFrame) {
		String user = mainFrame.text_userID.getText();
		String pw = mainFrame.text_new_password.getText();
		String pw2 = mainFrame.text_again_password.getText();
		int power = mainFrame.radio_admin_operator.isSelected() ? 1 : 0;
		if (!pw.equals(pw2)) {
			JOptionPane.showMessageDialog(mainFrame, "密码不一致", "提示", 0);
		} else {
			if (DBConnection.selectBoolean(sqlOfAddUser, user, pw2, power)) {
				JOptionPane.showMessageDialog(mainFrame, "注册成功", "提示", 1);
				selectUser();
			} else {
				JOptionPane.showMessageDialog(mainFrame, "注册失败", "提示", 0);
			}
		}
	}

	// 修改用户密码
	public void changeUserPw(SettingFrame mainFrame) {
		String user = mainFrame.text_userID.getText();
		String oldP = mainFrame.text_old_password.getText();
		String newP = mainFrame.text_new_password.getText();
		String newP2 = mainFrame.text_again_password.getText();
		Object[][] userID = DBConnection.selectResult(sqlOfSelectUserID).getRowsByIndex();
		String ID = null;
		boolean exists = false;
		for (int i = 0; i < userID.length; i++) {
			exists = userID[i][0].toString().equals(user);
			if (exists == true) {
				ID = userID[i][0].toString();
				break;
			}
		}
		if (!exists) {
			JOptionPane.showMessageDialog(mainFrame, "无此用户", "提示", 0);
		} else {
			String PW = DBConnection.selectResult(sqlOfSelectPW, ID).getRowsByIndex()[0][0].toString();
			if (!PW.equals(oldP)) {
				JOptionPane.showMessageDialog(mainFrame, "原密码有误", "提示", 0);
			} else {
				if (!newP.equals(newP2)) {
					JOptionPane.showMessageDialog(mainFrame, "新密码不一致", "提示", 0);
				} else {
					if (DBConnection.selectBoolean(sqlOfChangePW, newP2, ID)) {
						JOptionPane.showMessageDialog(SettingFrame.table_operator_list, "修改成功", "提示", 1);
					} else {
						JOptionPane.showMessageDialog(SettingFrame.table_operator_list, "修改失败", "提示", 0);
					}
				}
			}
		}
	}

	// 删除用户
	public void deleteUser() {
		if (JOptionPane.showConfirmDialog(SettingFrame.table_operator_list, "确认删除？", "警告", 0) == 0) {
			if (DBConnection.selectBoolean(sqlOfDeleteUser, SettingFrame.table_operator_list
					.getValueAt(SettingFrame.table_operator_list.getSelectedRow(), 0))) {
				JOptionPane.showMessageDialog(SettingFrame.table_operator_list, "删除成功", "提示", 1);
				selectUser();
			} else {
				JOptionPane.showMessageDialog(SettingFrame.table_operator_list, "删除失败", "提示", 0);
			}
		}
	}

}
