package hotelSystem.ui.setting.setting;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.border.LineBorder;

import hotelSystem.dao.setting.CustomerSetting;
import hotelSystem.dao.setting.OperatorSetting;
import hotelSystem.dao.setting.RoomSetting;
import hotelSystem.ui.setting.customerSet.AddCustomerType;
import hotelSystem.ui.setting.customerSet.ChangeCustomerType;
import hotelSystem.ui.setting.roomSet.AddRoomInfo;
import hotelSystem.ui.setting.roomSet.AddRoomType;
import hotelSystem.ui.setting.roomSet.AddRoomsInfo;
import hotelSystem.ui.setting.roomSet.ChangeRoomInfo;
import hotelSystem.ui.setting.roomSet.ChangeRoomType;
import hotelSystem.ui.system.SystemMain;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

/*
 * 所有设置界面
 * 
 * */
public class SettingFrame extends JFrame {

	private JPanel contentPane;
	public JTextField text_new_day;
	public JTextField text_half_day;
	public JTextField text_day;
	public JTextField text_start_pay;
	public JTextField text_last_pay;
	public JTextField text_over30;
	public JTextField text_over10;
	public JRadioButton radio_new_day;
	public static JTable table_customer_type;
	public static JTable table_room_discount;
	public static JTable table_operator_list;
	public JTextField text_userID;
	public JTextField text_old_password;
	public JTextField text_new_password;
	public JTextField text_again_password;
	public JTextField text_after_pay;
	public static JTable table_room_type;
	public static JTable table_room_selectByType;
	public JComboBox<Object> comboBox_room_status;
	public static JComboBox<Object> comboBox_select_by_type;
	public JRadioButton radio_new_user;
	public JRadioButton radio_change_password;
	public JRadioButton radio_delete_user;
	public JRadioButton radio_normal_operator;
	public JRadioButton radio_admin_operator;
	private RoomSetting roomSetting = new RoomSetting();
	private CustomerSetting customerSetting = new CustomerSetting();
	private OperatorSetting operatorSetting = new OperatorSetting();

	public SettingFrame() {

		setResizable(false);
		setTitle("设置");
		setSize(1585, 905);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		{
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBounds(0, 0, 1574, 851);
			contentPane.add(tabbedPane);

			JPanel panel_roomSet = new JPanel();
			tabbedPane.addTab("房间项目设置", null, panel_roomSet, null);
			panel_roomSet.setLayout(null);

			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_1.setBounds(10, 10, 1549, 90);
			panel_roomSet.add(panel_1);
			panel_1.setLayout(null);

			JLabel label_13 = new JLabel("结账后房间状态变为");
			label_13.setBounds(74, 34, 126, 15);
			panel_1.add(label_13);

			comboBox_room_status = new JComboBox<Object>();
			comboBox_room_status.setModel(new DefaultComboBoxModel<Object>(new String[] { "可供", "不可供" }));
			comboBox_room_status.setBounds(209, 31, 112, 18);
			panel_1.add(comboBox_room_status);

			JLabel label_14 = new JLabel("结账后");
			label_14.setBounds(530, 34, 42, 15);
			panel_1.add(label_14);

			text_after_pay = new JTextField();
			text_after_pay.setBounds(582, 31, 66, 21);
			panel_1.add(text_after_pay);
			text_after_pay.setColumns(10);

			JLabel label_15 = new JLabel("分钟变为可供状态");
			label_15.setBounds(658, 34, 126, 15);
			panel_1.add(label_15);

			JButton button_save_status = new JButton("保存");
			button_save_status.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					roomSetting.saveRoomStatus(SettingFrame.this);
				}
			});
			button_save_status.setBounds(830, 30, 93, 23);
			panel_1.add(button_save_status);

			JPanel panel_room_type = new JPanel();
			panel_room_type.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_room_type.setBounds(10, 150, 1549, 299);
			panel_roomSet.add(panel_room_type);
			panel_room_type.setLayout(null);

			JScrollPane scrollPane_room_type = new JScrollPane();
			scrollPane_room_type.setBounds(10, 10, 1529, 246);
			panel_room_type.add(scrollPane_room_type);

			table_room_type = new JTable();
			scrollPane_room_type.setViewportView(table_room_type);

			JButton button_add_room_type = new JButton("添加类型");
			button_add_room_type.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddRoomType().setVisible(true);// 添加房间类型
				}
			});
			button_add_room_type.setBounds(279, 266, 93, 23);
			panel_room_type.add(button_add_room_type);

			JButton button_change_room_type = new JButton("修改类型");
			button_change_room_type.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (SettingFrame.table_room_type.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(SettingFrame.table_room_type, "请选择", "提示", 0);
					} else {
						new ChangeRoomType().setVisible(true);// 修改房间类型
					}
				}
			});
			button_change_room_type.setBounds(442, 266, 93, 23);
			panel_room_type.add(button_change_room_type);

			JButton button_delete_delete_type = new JButton("删除类型");
			button_delete_delete_type.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					roomSetting.deleteRoomType(table_room_type);// 删除房间类型
				}
			});
			button_delete_delete_type.setBounds(610, 266, 93, 23);
			panel_room_type.add(button_delete_delete_type);

			JButton button_type_room_pay_cut = new JButton("房费打折");
			button_type_room_pay_cut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new RoomPriceDiscount().setVisible(true);
				}
			});
			button_type_room_pay_cut.setBounds(778, 266, 93, 23);
			panel_room_type.add(button_type_room_pay_cut);

			JPanel panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_3.setBounds(10, 506, 1549, 306);
			panel_roomSet.add(panel_3);
			panel_3.setLayout(null);

			JScrollPane scrollPane_room_select = new JScrollPane();
			scrollPane_room_select.setBounds(10, 10, 1529, 245);
			panel_3.add(scrollPane_room_select);

			table_room_selectByType = new JTable();
			scrollPane_room_select.setViewportView(table_room_selectByType);

			JButton button_add_once = new JButton("单个添加");
			button_add_once.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddRoomInfo().setVisible(true);// 添加房间信息
				}
			});
			button_add_once.setBounds(285, 273, 93, 23);
			panel_3.add(button_add_once);

			JButton button_add_group = new JButton("批量添加");
			button_add_group.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AddRoomsInfo().setVisible(true);// 批量添加房间信息
				}
			});
			button_add_group.setBounds(443, 273, 93, 23);
			panel_3.add(button_add_group);

			JButton button_delete_room = new JButton("删除房间");
			button_delete_room.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int index = table_room_selectByType.getSelectedRow();
					if (index == -1) {
						JOptionPane.showMessageDialog(table_room_selectByType, "请选择", "提示", 0);
					} else {
						// 删除房间信息
						roomSetting.deleteRoomInfo(table_room_selectByType,
								table_room_selectByType.getValueAt(index, 0));
					}
				}
			});
			button_delete_room.setBounds(588, 273, 93, 23);
			panel_3.add(button_delete_room);

			JButton button_change_room = new JButton("修改房间");
			button_change_room.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table_room_selectByType.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(table_room_selectByType, "请选择", "提示", 0);
					} else {
						// 修改房间信息
						new ChangeRoomInfo().setVisible(true);
					}

				}
			});
			button_change_room.setBounds(732, 273, 93, 23);
			panel_3.add(button_change_room);

			JLabel label_16 = new JLabel("房间类型");
			label_16.setBounds(22, 125, 54, 15);
			panel_roomSet.add(label_16);

			JLabel label_17 = new JLabel("按房间类型过滤");
			label_17.setBounds(22, 481, 124, 15);
			panel_roomSet.add(label_17);

			comboBox_select_by_type = new JComboBox<Object>();
			comboBox_select_by_type.setBounds(157, 475, 161, 21);
			panel_roomSet.add(comboBox_select_by_type);

			JButton button_select_by_type = new JButton("筛选");
			button_select_by_type.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 筛选房间信息
					roomSetting.selectRoomType(table_room_selectByType, RoomSetting.sqlOfSelectByType,
							comboBox_select_by_type.getSelectedItem().toString());
				}
			});
			button_select_by_type.setBounds(389, 473, 93, 23);
			panel_roomSet.add(button_select_by_type);

			JPanel panel_customerSet = new JPanel();
			tabbedPane.addTab("客户类型设置", null, panel_customerSet, null);
			panel_customerSet.setLayout(null);

			JPanel panel_customer_type = new JPanel();
			panel_customer_type.setLayout(null);
			panel_customer_type.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_customer_type.setBounds(21, 45, 1538, 270);
			panel_customerSet.add(panel_customer_type);

			JScrollPane scrollPane_customer_type = new JScrollPane();
			scrollPane_customer_type.setBounds(10, 10, 1518, 250);
			panel_customer_type.add(scrollPane_customer_type);

			table_customer_type = new JTable();
			scrollPane_customer_type.setViewportView(table_customer_type);

			JPanel panel_room_pay_cut = new JPanel();
			panel_room_pay_cut.setBounds(21, 415, 1538, 317);
			panel_customerSet.add(panel_room_pay_cut);
			panel_room_pay_cut.setLayout(null);
			panel_room_pay_cut.setBorder(new LineBorder(new Color(0, 0, 0)));

			JScrollPane scrollPane_room = new JScrollPane();
			scrollPane_room.setBounds(10, 10, 1518, 297);
			panel_room_pay_cut.add(scrollPane_room);

			table_room_discount = new JTable();
			scrollPane_room.setViewportView(table_room_discount);

			JLabel lable_customer_type = new JLabel("客户类型");
			lable_customer_type.setBounds(35, 20, 54, 15);
			panel_customerSet.add(lable_customer_type);

			JLabel label_room_pay_cut = new JLabel("房间费打折");
			label_room_pay_cut.setBounds(35, 387, 70, 15);
			panel_customerSet.add(label_room_pay_cut);

			JButton button_add_type = new JButton("添加类型");
			button_add_type.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AddCustomerType().setVisible(true);// 添加客户类型
				}
			});
			button_add_type.setBounds(505, 341, 93, 23);
			panel_customerSet.add(button_add_type);

			JButton button_change_type = new JButton("修改类型");
			button_change_type.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table_customer_type.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(SettingFrame.table_customer_type, "请选择", "提示", 0);
					} else {
						new ChangeCustomerType().setVisible(true);// 修改客户类型
					}

				}
			});
			button_change_type.setBounds(661, 341, 93, 23);
			panel_customerSet.add(button_change_type);

			JButton button_delete_type = new JButton("删除类型");
			button_delete_type.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table_customer_type.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(SettingFrame.table_customer_type, "请选择", "提示", 0);
					} else {
						customerSetting.deleteCustomerType();// 删除客户类型
					}
				}
			});
			button_delete_type.setBounds(811, 341, 93, 23);
			panel_customerSet.add(button_delete_type);

			JButton button_room_pay_cut = new JButton("房间费打折");
			button_room_pay_cut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new RoomPriceDiscount().setVisible(true);
				}
			});
			button_room_pay_cut.setBounds(661, 760, 104, 23);
			panel_customerSet.add(button_room_pay_cut);

			JPanel panel_operatorSet = new JPanel();
			tabbedPane.addTab("操作员设置", null, panel_operatorSet, null);
			panel_operatorSet.setLayout(null);

			JPanel panel_operator = new JPanel();
			panel_operator.setLayout(null);
			panel_operator.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_operator.setBounds(10, 52, 1538, 317);
			panel_operatorSet.add(panel_operator);

			JScrollPane scrollPane_operator = new JScrollPane();
			scrollPane_operator.setBounds(10, 10, 1518, 297);
			panel_operator.add(scrollPane_operator);

			table_operator_list = new JTable();
			scrollPane_operator.setViewportView(table_operator_list);

			JPanel panel_operator_info = new JPanel();
			panel_operator_info.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_operator_info.setBounds(10, 391, 789, 337);
			panel_operatorSet.add(panel_operator_info);
			panel_operator_info.setLayout(null);

			JLabel label_info = new JLabel("详细信息");
			label_info.setBounds(21, 10, 54, 15);
			panel_operator_info.add(label_info);

			JLabel lable_user = new JLabel("用户名");
			lable_user.setBounds(122, 86, 54, 15);
			panel_operator_info.add(lable_user);

			JLabel label_old_password = new JLabel("原密码");
			label_old_password.setBounds(122, 123, 54, 15);
			panel_operator_info.add(label_old_password);

			JLabel label_new_password = new JLabel("新密码");
			label_new_password.setBounds(122, 163, 54, 15);
			panel_operator_info.add(label_new_password);

			JLabel label_enter_password = new JLabel("确认密码");
			label_enter_password.setBounds(122, 199, 54, 15);
			panel_operator_info.add(label_enter_password);

			text_old_password = new JTextField();
			text_old_password.setBounds(221, 120, 225, 21);
			panel_operator_info.add(text_old_password);
			text_old_password.setColumns(10);

			text_new_password = new JTextField();
			text_new_password.setColumns(10);
			text_new_password.setBounds(221, 160, 225, 21);
			panel_operator_info.add(text_new_password);

			text_again_password = new JTextField();
			text_again_password.setColumns(10);
			text_again_password.setBounds(221, 196, 225, 21);
			panel_operator_info.add(text_again_password);

			text_userID = new JTextField();
			text_userID.setColumns(10);
			text_userID.setBounds(220, 82, 225, 21);
			panel_operator_info.add(text_userID);

			JPanel panel_operator_scope = new JPanel();
			panel_operator_scope.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_operator_scope.setBounds(809, 391, 750, 163);
			panel_operatorSet.add(panel_operator_scope);
			panel_operator_scope.setLayout(null);

			JLabel label_operator_scope = new JLabel("操作范围");
			label_operator_scope.setBounds(10, 10, 54, 15);
			panel_operator_scope.add(label_operator_scope);

			radio_new_user = new JRadioButton("新用户登记");
			radio_new_user.setSelected(true);
			radio_new_user.setBounds(102, 77, 121, 23);
			panel_operator_scope.add(radio_new_user);

			radio_change_password = new JRadioButton("修改密码");
			radio_change_password.setBounds(288, 77, 121, 23);
			panel_operator_scope.add(radio_change_password);

			radio_delete_user = new JRadioButton("删除用户");
			radio_delete_user.setBounds(481, 77, 121, 23);
			panel_operator_scope.add(radio_delete_user);

			ButtonGroup group_scope = new ButtonGroup();
			group_scope.add(radio_new_user);
			group_scope.add(radio_change_password);
			group_scope.add(radio_delete_user);

			JPanel panel_operator_power = new JPanel();
			panel_operator_power.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_operator_power.setBounds(809, 564, 750, 163);
			panel_operatorSet.add(panel_operator_power);
			panel_operator_power.setLayout(null);

			JLabel label_operator_power = new JLabel("操作权限");
			label_operator_power.setBounds(10, 10, 54, 15);
			panel_operator_power.add(label_operator_power);

			radio_normal_operator = new JRadioButton("普通操作员");
			radio_normal_operator.setSelected(true);
			radio_normal_operator.setBounds(166, 61, 121, 23);
			panel_operator_power.add(radio_normal_operator);

			radio_admin_operator = new JRadioButton("管理员");
			radio_admin_operator.setBounds(393, 61, 121, 23);
			panel_operator_power.add(radio_admin_operator);

			ButtonGroup group_power = new ButtonGroup();
			group_power.add(radio_normal_operator);
			group_power.add(radio_admin_operator);

			JButton button_registe_operator = new JButton("登记");
			button_registe_operator.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					operatorSetting.addUser(SettingFrame.this);// 用户注册
				}
			});
			button_registe_operator.setBounds(477, 763, 93, 23);
			panel_operatorSet.add(button_registe_operator);

			JButton button_change_operator = new JButton("修改");
			button_change_operator.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					operatorSetting.changeUserPw(SettingFrame.this);
				}
			});
			button_change_operator.setBounds(693, 763, 93, 23);
			panel_operatorSet.add(button_change_operator);

			JButton button_delete_operator = new JButton("删除");
			button_delete_operator.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table_operator_list.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(SettingFrame.table_operator_list, "请选择", "提示", 0);
					} else {
						operatorSetting.deleteUser();
					}

				}
			});
			button_delete_operator.setBounds(942, 763, 93, 23);
			panel_operatorSet.add(button_delete_operator);

			JPanel panel_pay = new JPanel();
			tabbedPane.addTab("计费设置", null, panel_pay, null);
			panel_pay.setLayout(null);

			JPanel panel_roomPay = new JPanel();
			panel_roomPay.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_roomPay.setBounds(21, 45, 1538, 311);
			panel_pay.add(panel_roomPay);
			panel_roomPay.setLayout(null);

			radio_new_day = new JRadioButton("入住不足一天按一天计费");
			radio_new_day.setBounds(24, 252, 314, 37);
			panel_roomPay.add(radio_new_day);

			text_new_day = new JTextField();
			text_new_day.setBounds(160, 62, 88, 21);
			panel_roomPay.add(text_new_day);
			text_new_day.setColumns(10);

			text_half_day = new JTextField();
			text_half_day.setColumns(10);
			text_half_day.setBounds(160, 97, 88, 21);
			panel_roomPay.add(text_half_day);

			text_day = new JTextField();
			text_day.setColumns(10);
			text_day.setBounds(160, 128, 88, 21);
			panel_roomPay.add(text_day);

			JLabel label = new JLabel("客人开房时间在");
			label.setBounds(56, 65, 94, 15);
			panel_roomPay.add(label);

			JLabel label_1 = new JLabel("客人退房时间在");
			label_1.setBounds(56, 100, 94, 15);
			panel_roomPay.add(label_1);

			JLabel label_2 = new JLabel("客人退房时间在");
			label_2.setBounds(56, 131, 94, 15);
			panel_roomPay.add(label_2);

			JLabel lblD = new JLabel("点之后按新的一天计算");
			lblD.setBounds(258, 65, 148, 15);
			panel_roomPay.add(lblD);

			JLabel label_3 = new JLabel("点之后计价天数自动追加半天");
			label_3.setBounds(258, 100, 180, 15);
			panel_roomPay.add(label_3);

			JLabel label_4 = new JLabel("点之后计价天数自动追加一天");
			label_4.setBounds(258, 131, 180, 15);
			panel_roomPay.add(label_4);

			JPanel panel_oclockPay = new JPanel();
			panel_oclockPay.setLayout(null);
			panel_oclockPay.setBorder(new LineBorder(new Color(0, 0, 0)));
			panel_oclockPay.setBounds(21, 415, 1538, 317);
			panel_pay.add(panel_oclockPay);

			text_start_pay = new JTextField();
			text_start_pay.setColumns(10);
			text_start_pay.setBounds(162, 77, 88, 21);
			panel_oclockPay.add(text_start_pay);

			text_last_pay = new JTextField();
			text_last_pay.setColumns(10);
			text_last_pay.setBounds(162, 126, 88, 21);
			panel_oclockPay.add(text_last_pay);

			text_over30 = new JTextField();
			text_over30.setColumns(10);
			text_over30.setBounds(162, 169, 88, 21);
			panel_oclockPay.add(text_over30);

			text_over10 = new JTextField();
			text_over10.setColumns(10);
			text_over10.setBounds(162, 219, 88, 21);
			panel_oclockPay.add(text_over10);

			JLabel label_5 = new JLabel("开房后");
			label_5.setBounds(104, 80, 48, 15);
			panel_oclockPay.add(label_5);

			JLabel label_7 = new JLabel("若不足一小时但超过");
			label_7.setBounds(28, 172, 124, 15);
			panel_oclockPay.add(label_7);

			JLabel label_6 = new JLabel("最少按");
			label_6.setBounds(104, 129, 48, 15);
			panel_oclockPay.add(label_6);

			JLabel label_8 = new JLabel("不足上面时间但超过");
			label_8.setBounds(28, 222, 124, 15);
			panel_oclockPay.add(label_8);

			JLabel lblNewLabel = new JLabel("分钟开始计费");
			lblNewLabel.setBounds(255, 80, 88, 15);
			panel_oclockPay.add(lblNewLabel);

			JLabel label_9 = new JLabel("小时计费，小于这个时间按此时间计费");
			label_9.setBounds(255, 129, 234, 15);
			panel_oclockPay.add(label_9);

			JLabel label_10 = new JLabel("分钟的部分按一小时计费");
			label_10.setBounds(255, 172, 204, 15);
			panel_oclockPay.add(label_10);

			JLabel label_11 = new JLabel("分钟的部分按半小时计费");
			label_11.setBounds(255, 222, 204, 15);
			panel_oclockPay.add(label_11);

			JLabel label_12 = new JLabel("注：此设置仅限于标准计费的钟点房");
			label_12.setBounds(513, 266, 267, 15);
			panel_oclockPay.add(label_12);

			JLabel label_roomPay = new JLabel("普通房间标准计费");
			label_roomPay.setBounds(21, 10, 198, 29);
			panel_pay.add(label_roomPay);

			JLabel label_oclockPay = new JLabel("钟点房间标准计费");
			label_oclockPay.setBounds(21, 389, 198, 29);
			panel_pay.add(label_oclockPay);

			JButton button_pay_enter = new JButton("确认");
			button_pay_enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

				}
			});
			button_pay_enter.setBounds(1193, 777, 93, 23);
			panel_pay.add(button_pay_enter);

			JButton button_pay_cancel = new JButton("取消");
			button_pay_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SettingFrame.this.dispose();
				}
			});
			button_pay_cancel.setBounds(1352, 777, 93, 23);
			panel_pay.add(button_pay_cancel);
		}
		{
			// 房间设置
			roomSetting.selectRoomType(table_room_type, RoomSetting.sqlOfSelectRoomType);// 加载房间类型
			roomSetting.selectRoomInfo(table_room_selectByType, RoomSetting.sqlOfSelectRoomInfo);// 加载所有房间信息
			roomSetting.selectByRoomType(comboBox_select_by_type);// 加载筛选项目
		}
		{
			// 客户设置
			customerSetting.selectCustomerType(table_customer_type, CustomerSetting.sqlOfSelectCustomerType);// 加载客户类型
			customerSetting.selectRoomPriceDiscount();// 查询打折项目
		}
		{
			// 操作员设置
			operatorSetting.selectUser();// 加载用户
		}
		{
			// 计费设置
		}
	}
}
