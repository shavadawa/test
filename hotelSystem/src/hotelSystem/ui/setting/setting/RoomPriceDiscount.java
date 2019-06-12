package hotelSystem.ui.setting.setting;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import hotelSystem.dao.setting.CustomerSetting;
import hotelSystem.dao.setting.DBConnection;
import hotelSystem.dao.setting.RoomSetting;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

/*
 * 房间设置界面及客户类型设置界面，房间单价打折*/
public class RoomPriceDiscount extends JFrame {

	// 获得被修改打折房间
	public static String sqlOfGetRoomDiscount = "select roomType,prePrice from tb_room_type;";
	// 修改打折房间
	public static String sqlOfSetRoomDiscount = "update tb_room_type set prePrice=? where roomType=?;";

	private JComboBox<Object> comboBox_room_type;
	private JTextField text_room_discount;

	public RoomPriceDiscount() {

		setTitle("房间费打折");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setSize(453, 370);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		{
			JLabel label = new JLabel("房间类型");
			label.setBounds(69, 47, 108, 29);
			getContentPane().add(label);

			JLabel label_1 = new JLabel("折扣比例");
			label_1.setBounds(69, 135, 108, 29);
			getContentPane().add(label_1);

			text_room_discount = new JTextField();
			text_room_discount.setColumns(10);
			text_room_discount.setBounds(183, 132, 192, 35);
			getContentPane().add(text_room_discount);

			JButton button_enter = new JButton("确认");
			button_enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setDiscount();
				}
			});
			button_enter.setBounds(47, 236, 153, 37);
			getContentPane().add(button_enter);

			JButton button_cancel = new JButton("取消");
			button_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_cancel.setBounds(248, 236, 153, 37);
			getContentPane().add(button_cancel);

			comboBox_room_type = new JComboBox<Object>();
			comboBox_room_type.setBounds(183, 44, 192, 35);
			getContentPane().add(comboBox_room_type);
		}
		getDiscount();
	}

	// 获得打折项目
	public void getDiscount() {

		Object[][] objects = DBConnection.selectResult(sqlOfGetRoomDiscount).getRowsByIndex();
		for (int i = 0; i < objects.length; i++) {
			this.comboBox_room_type.addItem(objects[i][0].toString());
		}
		this.text_room_discount.setText(objects[0][1].toString());
	}

	// 修改打折项目
	public void setDiscount() {
		String type = this.comboBox_room_type.getSelectedItem().toString();
		Double priceNow = Double
				.parseDouble(DBConnection.selectResult("select prePrice from tb_room_type where roomType=?;", type)
						.getRowsByIndex()[0][0].toString());
		Double price = priceNow * (Double.parseDouble(this.text_room_discount.getText()) / 10);
		if (DBConnection.selectBoolean(sqlOfSetRoomDiscount, price, type)) {
			JOptionPane.showMessageDialog(this, "修改成功", "提示", 1);
			dispose();
			// 刷新所有房间信息
			new RoomSetting().selectRoomType(SettingFrame.table_room_type, RoomSetting.sqlOfSelectRoomType);
			new CustomerSetting().selectRoomPriceDiscount();
		} else {
			JOptionPane.showMessageDialog(this, "修改失败", "提示", 0);
		}
	}
}
