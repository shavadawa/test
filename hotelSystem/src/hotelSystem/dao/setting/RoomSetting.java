package hotelSystem.dao.setting;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import hotelSystem.ui.setting.roomSet.AddRoomInfo;
import hotelSystem.ui.setting.roomSet.AddRoomType;
import hotelSystem.ui.setting.roomSet.AddRoomsInfo;
import hotelSystem.ui.setting.roomSet.ChangeRoomInfo;
import hotelSystem.ui.setting.roomSet.ChangeRoomType;
import hotelSystem.ui.setting.setting.SettingFrame;

public class RoomSetting {
	/*
	 * 
	 * 
	 * 房间项目设置
	 */

	// 查询房间类型
	public static String sqlOfSelectRoomType = "select roomType,prePrice,oclockPrice,bedAmount,oclockWhether from tb_room_type;";
	// 删除房间类型
	public static String sqlOfDeleteRoomType = "delete from tb_room_type where roomType=?;";
	// 获得被修改的房间类型
	public static String sqlOfGetRoomType = "select * from tb_room_type where roomType=?;";
	// 修改房间类型
	public static String sqlOfSetRoomType = "update tb_room_info_type set roomNumber=?,roomArea=?,roomPhone=? where roomType=?;";
	// 增加房间类型
	public static String sqlOfAddRoomType = "insert into tb_room_type values(?,?,?,?,?,?,?);";
	// 只获得房间类型
	public static String sqlOfSelectRoomTypeOnly = "select roomType from tb_room_type;";
	// 修改房间类型
	public static String sqlOfUpdateRoomType = "update tb_room_type set roomType=?,bedAmount=?,prePrice=?,preMoney=?,oclockPrice=?,oclockWhether=? where roomTypeID=?;";
	// 根据类型筛选房间
	public static String sqlOfSelectByType = "select * from tb_room_info where roomType=?;";
	// 添加房间信息
	public static String sqlOfAddRoomInfo = "insert into tb_room_info values(?,?,?,?,?);";
	// 获得所有房间信息
	public static String sqlOfSelectRoomInfo = "select * from tb_room_info;";
	// 删除房间信息
	public static String sqlOfDeleteRoomInfo = "delete from tb_room_info where roomNumber=?;";
	// 批量添加房间信息
	public static String sqlOfAddRoomsInfo = "insert into tb_room_info values(?,?,?,?,?);";
	// 修改房间状态
	public static String sqlOfUpdateRoomStatus = "update tb_room_info set roomStatu=? where roomNumber=?;";
	// 获得被修改的房间信息
	public static String sqlOfGetRoomInfo = "select * from tb_room_info where roomNumber=?;";
	// 修改房间信息
	public static String sqlOfSetRoomInfo = "update tb_room_info set roomArea=?,roomPhone=? where roomNumber=?;";

	// 查询房间类型
	public void selectRoomType(JTable table, String sql) {
		String[] cName = { "房间类型", "预设单价", "钟点价格/H", "床位数量", "钟点计费Y/N" };
		Object[][] roomData = DBConnection.selectResult(sql).getRowsByIndex();
		DefaultTableModel model = new DefaultTableModel(roomData, cName);
		table.setModel(model);
	}

	// 查询所有房间信息
	public void selectRoomInfo(JTable table, String sql) {
		String[] cName = { "房间号码", "房间类型", "房间状态", "所在区域", "房间电话" };
		Object[][] roomData = DBConnection.selectResult(sql).getRowsByIndex();
		DefaultTableModel model = new DefaultTableModel(roomData, cName);
		table.setModel(model);
	}

	// 根据房间类型查询房间信息
	public void selectRoomType(JTable table, String sql, String index) {
		if (index.equals("所有房间")) {
			selectRoomInfo(table, RoomSetting.sqlOfSelectRoomInfo);
		} else {
			String[] cName = { "房间号码", "房间类型", "房间状态", "所在区域", "房间电话" };
			Object[][] roomData = DBConnection.selectResult(sql, index).getRowsByIndex();
			DefaultTableModel model = new DefaultTableModel(roomData, cName);
			table.setModel(model);
		}
	}

	// 获得房间信息填充表单
	public void getRoomInfo(ChangeRoomInfo roomInfo) {
		Object data[][] = DBConnection.selectResult(sqlOfGetRoomInfo, SettingFrame.table_room_selectByType
				.getValueAt(SettingFrame.table_room_selectByType.getSelectedRow(), 0)).getRowsByIndex();
		roomInfo.text_room_type.setText(data[0][1].toString());
		roomInfo.text_room_number.setText(data[0][0].toString());
		roomInfo.text_room_area.setText(data[0][3].toString());
		roomInfo.text_room_phone.setText(data[0][4].toString());
	}

	// 以表单中数据修改房间信息
	public void setRoomInfo(ChangeRoomInfo roomInfo) {
		String roomNumber = roomInfo.text_room_number.getText();
		String roomArea = roomInfo.text_room_area.getText();
		String roomPhone = roomInfo.text_room_phone.getText();
		if (DBConnection.selectBoolean(sqlOfSetRoomInfo, roomArea, roomPhone, roomNumber)) {
			JOptionPane.showMessageDialog(roomInfo, "修改成功", "提示", 1);
			roomInfo.dispose();
			// 刷新所有房间信息
			selectRoomInfo(SettingFrame.table_room_selectByType, sqlOfSelectRoomInfo);
		} else {
			JOptionPane.showMessageDialog(roomInfo, "修改失败", "提示", 0);
		}
	}

	// 删除房间类型
	public void deleteRoomType(JTable table) {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(table, "请选择", "提示", 0);
		} else {
			if (JOptionPane.showConfirmDialog(table, "确认删除？", "警告", 0) == 0) {
				if (DBConnection.selectBoolean(sqlOfDeleteRoomType,
						table.getValueAt(SettingFrame.table_room_type.getSelectedRow(), 0))) {
					JOptionPane.showMessageDialog(table, "删除成功", "提示", 1);
					selectByRoomType(SettingFrame.comboBox_select_by_type);
					selectRoomType(SettingFrame.table_room_type, RoomSetting.sqlOfSelectRoomType);
				} else {
					JOptionPane.showMessageDialog(table, "删除失败", "提示", 0);
				}
			}
		}
	}

	// 删除房间信息
	public void deleteRoomInfo(JTable table, Object index) {
		if (table.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(table, "请选择", "提示", 0);
		} else {
			if (JOptionPane.showConfirmDialog(table, "确认删除？", "警告", 0) == 0) {
				if (DBConnection.selectBoolean(sqlOfDeleteRoomInfo, index.toString())) {
					JOptionPane.showMessageDialog(table, "删除成功", "提示", 1);
					selectRoomInfo(SettingFrame.table_room_selectByType, RoomSetting.sqlOfSelectRoomInfo);
				} else {
					JOptionPane.showMessageDialog(table, "删除失败", "提示", 0);
				}
			}
		}
	}

	// 添加房间类型
	public void addRoomType(AddRoomType roomType) {
		int type_id = Integer.parseInt(roomType.text_type_id.getText());
		String room_typr = roomType.text_room_type.getText();
		int bed_amount = Integer.parseInt(roomType.text_bed_amount.getText());
		double prePrice = Double.parseDouble(roomType.text_prePrice.getText());
		double preMoney = Double.parseDouble(roomType.text_preMoney.getText());
		double oclock_price = Double.parseDouble(roomType.text_oclock_price.getText());
		String allow_oclock = roomType.radio_allow_oclock.isSelected() ? "Y" : "N";
		if (DBConnection.selectBoolean(sqlOfAddRoomType, type_id, room_typr, bed_amount, prePrice, preMoney,
				oclock_price, allow_oclock)) {
			JOptionPane.showMessageDialog(roomType, "添加成功", "提示", 1);
			roomType.dispose();
			selectByRoomType(SettingFrame.comboBox_select_by_type);
			// 刷新所有房间类型
			selectRoomType(SettingFrame.table_room_type, RoomSetting.sqlOfSelectRoomType);
		} else {
			JOptionPane.showMessageDialog(roomType, "修改失败", "提示", 0);
		}
	}

	// 获得被修改的房间类型
	public void getRoomType(ChangeRoomType roomType) {
		Object data[][] = DBConnection
				.selectResult(sqlOfGetRoomType,
						SettingFrame.table_room_type.getValueAt(SettingFrame.table_room_type.getSelectedRow(), 0))
				.getRowsByIndex();
		roomType.text_type_id.setText(data[0][0].toString());
		roomType.text_room_type.setText(data[0][1].toString());
		roomType.text_bed_amount.setText(data[0][2].toString());
		roomType.text_prePrice.setText(data[0][3].toString());
		roomType.text_preMoney.setText(data[0][4].toString());
		roomType.text_oclock_price.setText(data[0][5].toString());
		roomType.radio_allow_oclock.setSelected((data[0][6].toString().equals("Y") ? true : false));
	}

	// 以表单中数据修改房间类型
	public void setRoomType(ChangeRoomType roomType) {
		int id = Integer.parseInt(roomType.text_type_id.getText());
		String type = roomType.text_room_type.getText();
		int bed = Integer.parseInt(roomType.text_bed_amount.getText());
		double price = Double.parseDouble(roomType.text_prePrice.getText());
		double money = Double.parseDouble(roomType.text_preMoney.getText());
		double oPrice = Double.parseDouble(roomType.text_oclock_price.getText());
		String allow = roomType.radio_allow_oclock.isSelected() ? "Y" : "N";
		if (DBConnection.selectBoolean(sqlOfUpdateRoomType, type, bed, price, money, oPrice, allow, id)) {
			JOptionPane.showMessageDialog(roomType, "修改成功", "提示", 1);
			roomType.dispose();
			// 刷新所有房间类型
			selectRoomType(SettingFrame.table_room_type, RoomSetting.sqlOfSelectRoomType);
		} else {
			JOptionPane.showMessageDialog(roomType, "修改失败", "提示", 0);
		}
	}

	// 仅获得房间类型
	public void selectByRoomType(JComboBox<Object> comboBox) {
		if (!comboBox.equals(null)) {
			comboBox.removeAllItems();
		}
		Object[][] type = DBConnection.selectResult(sqlOfSelectRoomTypeOnly).getRowsByIndex();
		for (int i = 0; i < type.length; i++) {
			comboBox.addItem(type[i][0].toString());
		}
		comboBox.addItem("所有房间");
	}

	// 添加房间信息
	public void addRoomInfo(AddRoomInfo roomInfo) {
		String type = roomInfo.comboBox_room_type.getSelectedItem().toString();
		String number = roomInfo.text_room_number.getText();
		String area = roomInfo.text_area.getText();
		String phone = roomInfo.text_room_phone.getText();
		if (DBConnection.selectBoolean(sqlOfAddRoomInfo, number, type, "可供", area, phone)) {
			JOptionPane.showMessageDialog(roomInfo, "添加成功", "提示", 1);
			roomInfo.dispose();
			// 刷新所有房间信息
			selectRoomInfo(SettingFrame.table_room_selectByType, RoomSetting.sqlOfSelectRoomInfo);
		} else {
			JOptionPane.showMessageDialog(roomInfo, "添加失败", "提示", 0);
		}
	}

	// 批量添加房间信息
	public void addRoomsInfo(AddRoomsInfo roomsInfo) {
		Boolean result = false;
		String type = roomsInfo.comboBox_room_type.getSelectedItem().toString();
		int start = Integer.parseInt(roomsInfo.text_start_number.getText());
		int end = Integer.parseInt(roomsInfo.text_end_number.getText());
		String mark = roomsInfo.text_mark_char.getText();
		String area = roomsInfo.text_room_area.getText();
		for (; start <= end; start++) {
			String number = mark + start;
			result = DBConnection.selectBoolean(sqlOfAddRoomsInfo, number, type, "可供", area, start);
		}
		if (result) {
			JOptionPane.showMessageDialog(roomsInfo, "添加成功", "提示", 1);
			roomsInfo.dispose();
			selectRoomInfo(SettingFrame.table_room_selectByType, RoomSetting.sqlOfSelectRoomInfo);
		} else {
			JOptionPane.showMessageDialog(roomsInfo, "添加失败", "提示", 0);
		}
	}

	// 结账后房间状态
	public void saveRoomStatus(SettingFrame setFrame) {
		// 单位分钟
		int timing = Integer.parseInt(setFrame.text_after_pay.getText());
		String status = setFrame.comboBox_room_status.getSelectedItem().toString();
		// 倒计时
		{
			int s = timing * 60;
			while (s > 0) {
				--s;
				try {
					Thread.sleep(1000);
					System.out.println(s + "秒");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		// 时间到
		/*
		 * 参数需要结账后房间号 roomNumber
		 */
		if (!DBConnection.selectBoolean(sqlOfUpdateRoomStatus, status, "roomNumber")) {
			JOptionPane.showMessageDialog(setFrame, "房间状态更新失败", "错误", 0);
		}
	}

}