package hotelSystem.ui.setting.roomSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextField;

import hotelSystem.dao.setting.RoomSetting;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 
 * 添加房间类型窗口
 */
public class AddRoomType extends JFrame {

	public JTextField text_type_id;
	public JTextField text_room_type;
	public JTextField text_bed_amount;
	public JTextField text_prePrice;
	public JTextField text_preMoney;
	public JTextField text_oclock_price;
	public JRadioButton radio_allow_oclock;

	public AddRoomType() {

		setResizable(false);
		setSize(530, 630);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("新增房间类型");
		getContentPane().setLayout(null);

		{
			JLabel label = new JLabel("类型编号");
			label.setBounds(68, 79, 108, 29);
			getContentPane().add(label);

			JLabel label_1 = new JLabel("房间类型");
			label_1.setBounds(68, 126, 108, 29);
			getContentPane().add(label_1);

			JLabel label_2 = new JLabel("床位数量");
			label_2.setBounds(68, 176, 108, 29);
			getContentPane().add(label_2);

			JLabel label_3 = new JLabel("预设单价");
			label_3.setBounds(68, 226, 108, 29);
			getContentPane().add(label_3);

			JLabel label_4 = new JLabel("预缴押金");
			label_4.setBounds(68, 276, 108, 29);
			getContentPane().add(label_4);

			JLabel label_5 = new JLabel("钟点价格");
			label_5.setBounds(68, 326, 108, 29);
			getContentPane().add(label_5);

			radio_allow_oclock = new JRadioButton("允许开钟点房");
			radio_allow_oclock.setBounds(68, 372, 231, 37);
			getContentPane().add(radio_allow_oclock);

			JButton button_enter_new = new JButton("保存");
			button_enter_new.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new RoomSetting().addRoomType(AddRoomType.this);// 保存添加的房间类型
				}
			});
			button_enter_new.setBounds(68, 475, 153, 37);
			getContentPane().add(button_enter_new);

			JButton button_cancel = new JButton("取消");
			button_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_cancel.setBounds(279, 475, 153, 37);
			getContentPane().add(button_cancel);

			text_type_id = new JTextField();
			text_type_id.setBounds(173, 76, 237, 35);
			getContentPane().add(text_type_id);
			text_type_id.setColumns(10);

			text_room_type = new JTextField();
			text_room_type.setColumns(10);
			text_room_type.setBounds(173, 123, 237, 35);
			getContentPane().add(text_room_type);

			text_bed_amount = new JTextField();
			text_bed_amount.setColumns(10);
			text_bed_amount.setBounds(173, 173, 237, 35);
			getContentPane().add(text_bed_amount);

			text_prePrice = new JTextField();
			text_prePrice.setColumns(10);
			text_prePrice.setBounds(173, 223, 237, 35);
			getContentPane().add(text_prePrice);

			text_preMoney = new JTextField();
			text_preMoney.setColumns(10);
			text_preMoney.setBounds(173, 273, 237, 35);
			getContentPane().add(text_preMoney);

			text_oclock_price = new JTextField();
			text_oclock_price.setColumns(10);
			text_oclock_price.setBounds(173, 323, 237, 35);
			getContentPane().add(text_oclock_price);
		}
	}

}
