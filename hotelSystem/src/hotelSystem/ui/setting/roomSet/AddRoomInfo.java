package hotelSystem.ui.setting.roomSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import hotelSystem.dao.setting.RoomSetting;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 添加房间信息窗口
 * 
 */
public class AddRoomInfo extends JFrame {

	public JTextField text_room_number;
	public JTextField text_area;
	public JTextField text_room_phone;
	private RoomSetting logic = new RoomSetting();
	public JComboBox<Object> comboBox_room_type;

	public AddRoomInfo() {

		setResizable(false);
		setTitle("添加房间");
		getContentPane().setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(450, 350);
		setLocationRelativeTo(null);

		{
			JLabel label = new JLabel("房间类型");
			label.setBounds(73, 47, 108, 29);
			getContentPane().add(label);

			JLabel label_1 = new JLabel("房间号码");
			label_1.setBounds(73, 140, 108, 29);
			getContentPane().add(label_1);

			JLabel label_2 = new JLabel("所属区域");
			label_2.setBounds(73, 228, 108, 29);
			getContentPane().add(label_2);

			JLabel label_3 = new JLabel("房间电话");
			label_3.setBounds(73, 307, 108, 29);
			getContentPane().add(label_3);

			comboBox_room_type = new JComboBox<Object>();
			comboBox_room_type.setEditable(true);
			comboBox_room_type.setBounds(183, 44, 242, 35);
			getContentPane().add(comboBox_room_type);

			text_room_number = new JTextField();
			text_room_number.setColumns(10);
			text_room_number.setBounds(183, 137, 243, 35);
			getContentPane().add(text_room_number);

			text_area = new JTextField();
			text_area.setColumns(10);
			text_area.setBounds(183, 225, 243, 35);
			getContentPane().add(text_area);

			text_room_phone = new JTextField();
			text_room_phone.setColumns(10);
			text_room_phone.setBounds(183, 304, 243, 35);
			getContentPane().add(text_room_phone);

			JButton button_enter = new JButton("保存");
			button_enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logic.addRoomInfo(AddRoomInfo.this);// 添加房间信息
				}
			});
			button_enter.setBounds(63, 392, 153, 37);
			getContentPane().add(button_enter);

			JButton button_cancel = new JButton("取消");
			button_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_cancel.setBounds(294, 392, 153, 37);
			getContentPane().add(button_cancel);
		}

		// 刷新筛选框房间类型
		logic.selectByRoomType(comboBox_room_type);
		// 筛选框例外项目
		comboBox_room_type.removeItem("所有房间");
	}
}
