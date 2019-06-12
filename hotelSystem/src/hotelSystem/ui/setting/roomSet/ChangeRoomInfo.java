package hotelSystem.ui.setting.roomSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hotelSystem.dao.setting.RoomSetting;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 修改房间信息界面
 * 
 */
public class ChangeRoomInfo extends JFrame {

	public JTextField text_room_number;
	public JTextField text_room_area;
	public JTextField text_room_phone;
	private RoomSetting logic = new RoomSetting();
	public JTextField text_room_type;

	public ChangeRoomInfo() {

		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(520, 520);
		setLocationRelativeTo(null);
		setTitle("修改房间信息");
		getContentPane().setLayout(null);

		{
			JLabel label = new JLabel("房间类型");
			label.setBounds(71, 36, 108, 29);
			getContentPane().add(label);

			JLabel label_1 = new JLabel("房间号码");
			label_1.setBounds(71, 129, 108, 29);
			getContentPane().add(label_1);

			JLabel label_2 = new JLabel("所属区域");
			label_2.setBounds(71, 217, 108, 29);
			getContentPane().add(label_2);

			JLabel label_3 = new JLabel("房间电话");
			label_3.setBounds(71, 296, 108, 29);
			getContentPane().add(label_3);

			text_room_type = new JTextField();
			text_room_type.setEditable(false);
			text_room_type.setColumns(10);
			text_room_type.setBounds(181, 33, 243, 35);
			getContentPane().add(text_room_type);

			text_room_number = new JTextField();
			text_room_number.setEditable(false);
			text_room_number.setColumns(10);
			text_room_number.setBounds(181, 126, 243, 35);
			getContentPane().add(text_room_number);

			text_room_area = new JTextField();
			text_room_area.setColumns(10);
			text_room_area.setBounds(181, 214, 243, 35);
			getContentPane().add(text_room_area);

			text_room_phone = new JTextField();
			text_room_phone.setColumns(10);
			text_room_phone.setBounds(181, 293, 243, 35);
			getContentPane().add(text_room_phone);

			JButton button_enter = new JButton("保存");
			button_enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 保存修改后的房间信息
					logic.setRoomInfo(ChangeRoomInfo.this);
				}
			});
			button_enter.setBounds(61, 381, 153, 37);
			getContentPane().add(button_enter);

			JButton button_cancel = new JButton("取消");
			button_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_cancel.setBounds(292, 381, 153, 37);
			getContentPane().add(button_cancel);
		}

		// 获得被修改的房间信息
		logic.getRoomInfo(ChangeRoomInfo.this);
	}
}
