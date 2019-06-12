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
 * 批量添加房间信息窗口
 * 
 */
public class AddRoomsInfo extends JFrame {

	public JTextField text_start_number;
	public JTextField text_end_number;
	public JTextField text_mark_char;
	public JTextField text_room_area;
	public JComboBox<Object> comboBox_room_type;
	private RoomSetting logic = new RoomSetting();

	public AddRoomsInfo() {

		setTitle("批量添加房间");
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setSize(520, 520);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		{
			JLabel label = new JLabel("房间类型");
			label.setBounds(68, 45, 108, 29);
			getContentPane().add(label);

			JLabel label_1 = new JLabel("起始号码");
			label_1.setBounds(67, 112, 108, 29);
			getContentPane().add(label_1);

			JLabel label_2 = new JLabel("终止号码");
			label_2.setBounds(68, 173, 108, 29);
			getContentPane().add(label_2);

			JLabel label_3 = new JLabel("标记字符");
			label_3.setBounds(68, 237, 108, 29);
			getContentPane().add(label_3);

			JLabel label_4 = new JLabel("所在区域");
			label_4.setBounds(68, 297, 108, 29);
			getContentPane().add(label_4);

			comboBox_room_type = new JComboBox<Object>();
			comboBox_room_type.setEditable(true);
			comboBox_room_type.setBounds(178, 42, 242, 35);
			getContentPane().add(comboBox_room_type);

			text_start_number = new JTextField();
			text_start_number.setColumns(10);
			text_start_number.setBounds(177, 109, 243, 35);
			getContentPane().add(text_start_number);

			text_end_number = new JTextField();
			text_end_number.setColumns(10);
			text_end_number.setBounds(178, 170, 243, 35);
			getContentPane().add(text_end_number);

			text_mark_char = new JTextField();
			text_mark_char.setColumns(10);
			text_mark_char.setBounds(178, 234, 243, 35);
			getContentPane().add(text_mark_char);

			text_room_area = new JTextField();
			text_room_area.setColumns(10);
			text_room_area.setBounds(178, 294, 243, 35);
			getContentPane().add(text_room_area);

			JButton button_enter = new JButton("保存");
			button_enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					logic.addRoomsInfo(AddRoomsInfo.this);// 批量添加房间信息
				}
			});
			button_enter.setBounds(60, 392, 153, 37);
			getContentPane().add(button_enter);

			JButton button_cancel = new JButton("取消");
			button_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_cancel.setBounds(291, 392, 153, 37);
			getContentPane().add(button_cancel);
		}
		// 刷新筛选框房间类型
		logic.selectByRoomType(comboBox_room_type);
		// 筛选框例外项目
		comboBox_room_type.removeItem("所有房间");
	}
}
