package hotelSystem.ui.system;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import hotelSystem.dao.system.LoadRoomType;
import hotelSystem.ui.setting.setting.SettingFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class SystemMain extends JFrame {
	private JButton button_refresh;
	private JComboBox<Object> comboBox;
	private JButton button_show_all;
	private JScrollPane scrollPane_info;
	public JPanel panel_time;
	public JTabbedPane tabbedPane_room;

	public SystemMain() {

		setSize(1700, 1000);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("酒店管理系统");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		{
			JPanel panel_menu = new JPanel();
			panel_menu.setBounds(0, 0, 1694, 25);
			getContentPane().add(panel_menu);
			panel_menu.setLayout(null);

			JMenuBar menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 1734, 21);
			panel_menu.add(menuBar);

			JMenu mnb = new JMenu("来宾登记(B)");
			mnb.setMnemonic('B');
			menuBar.add(mnb);

			JMenuItem mntmg = new JMenuItem("散客开单(G)");
			mntmg.setMnemonic('G');
			mnb.add(mntmg);

			JMenuItem mntmm = new JMenuItem("团体开单(M)");
			mntmm.setMnemonic('M');
			mnb.add(mntmm);

			JMenuItem mntmz = new JMenuItem("宾客续住(Z)");
			mntmz.setMnemonic('Z');
			mnb.add(mntmz);

			JMenuItem mntma = new JMenuItem("更换房间(A)");
			mntma.setMnemonic('A');
			mnb.add(mntma);

			JMenuItem mntmj = new JMenuItem("修改登记(J)");
			mntmj.setMnemonic('J');
			mnb.add(mntmj);

			JMenuItem mntms = new JMenuItem("房间状态(S)");
			mntms.setMnemonic('S');
			mnb.add(mntms);

			mnb.addSeparator();

			JMenuItem mntmt = new JMenuItem("预定管理(T)");
			mntmt.setMnemonic('T');
			mnb.add(mntmt);

			JMenuItem mntml = new JMenuItem("电子提醒(L)");
			mntml.setMnemonic('L');
			mnb.add(mntml);

			mnb.addSeparator();

			JMenuItem mntmx = new JMenuItem("退出系统(X)");
			mntmx.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			mntmx.setMnemonic('X');
			mnb.add(mntmx);

			JMenu mns = new JMenu("收银结算(S)");
			mns.setMnemonic('W');
			menuBar.add(mns);

			JMenuItem mntmNewMenuItem = new JMenuItem("宾客结账(J)");
			mntmNewMenuItem.setMnemonic('J');
			mns.add(mntmNewMenuItem);

			JMenuItem mntmNewMenuItem_1 = new JMenuItem("合并账单(E)");
			mntmNewMenuItem_1.setMnemonic('E');
			mns.add(mntmNewMenuItem_1);

			JMenuItem mntmNewMenuItem_2 = new JMenuItem("拆分账单(F)");
			mntmNewMenuItem_2.setMnemonic('F');
			mns.add(mntmNewMenuItem_2);

			JMenu mnw = new JMenu("系统维护(W)");
			menuBar.add(mnw);

			JMenuItem mntmNewMenuItem_3 = new JMenuItem("网络设置(N)");
			mntmNewMenuItem_3.setMnemonic('N');
			mnw.add(mntmNewMenuItem_3);

			JMenuItem mntmx_1 = new JMenuItem("系统设置(X)");
			mntmx_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SettingFrame().setVisible(true);
				}
			});
			mntmx_1.setMnemonic('X');
			mnw.add(mntmx_1);

			JMenuItem mntmz_1 = new JMenuItem("系统日志(Z)");
			mntmz_1.setMnemonic('Z');
			mnw.add(mntmz_1);

			mnw.addSeparator();

			JMenuItem mntmb = new JMenuItem("数据备份(B)");
			mntmb.setMnemonic('B');
			mnw.add(mntmb);

			mnw.addSeparator();

			JMenuItem mntmh = new JMenuItem("系统帮助(H)");
			mntmh.setMnemonic('H');
			mnw.add(mntmh);

			JMenuItem mntma_1 = new JMenuItem("关于我们(A)");
			mntma_1.setMnemonic('A');
			mnw.add(mntma_1);

			JPanel panel_system = new JPanel();
			panel_system.setBounds(0, 23, 1082, 89);
			getContentPane().add(panel_system);
			panel_system.setLayout(null);

			JButton button_person_order = new JButton("散客开单");
			button_person_order.setBounds(10, 10, 90, 69);
			panel_system.add(button_person_order);

			JButton button_group_order = new JButton("团体开单");
			button_group_order.setBounds(110, 10, 90, 69);
			panel_system.add(button_group_order);

			JButton button_result = new JButton("宾客结账");
			button_result.setBounds(210, 10, 90, 69);
			panel_system.add(button_result);

			JButton button_room_pre = new JButton("客房预订");
			button_room_pre.setBounds(310, 10, 90, 69);
			panel_system.add(button_room_pre);

			JButton button_bill_select = new JButton("营业查询");
			button_bill_select.setBounds(410, 10, 90, 69);
			panel_system.add(button_bill_select);

			JButton button_customer_management = new JButton("客户管理");
			button_customer_management.setBounds(510, 10, 90, 69);
			panel_system.add(button_customer_management);

			JButton button_network = new JButton("网络设置");
			button_network.setBounds(610, 10, 90, 69);
			panel_system.add(button_network);

			JButton button_setting = new JButton("系统设置");
			button_setting.setBounds(710, 10, 90, 69);
			button_setting.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new SettingFrame().setVisible(true);
				}
			});
			panel_system.add(button_setting);

			JButton button_about = new JButton("关于我们");
			button_about.setBounds(810, 10, 90, 69);
			panel_system.add(button_about);

			JButton button_exit = new JButton("退出系统");
			button_exit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
			button_exit.setBounds(910, 10, 90, 69);
			panel_system.add(button_exit);

			JTabbedPane tabbedPane_info = new JTabbedPane(JTabbedPane.BOTTOM);
			tabbedPane_info.setBounds(0, 153, 363, 676);
			getContentPane().add(tabbedPane_info);

			JPanel panel_status = new JPanel();
			tabbedPane_info.addTab("状态", null, panel_status, null);
			panel_status.setLayout(null);

			JLabel label = new JLabel("宾客姓名：");
			label.setFont(new Font("宋体", Font.PLAIN, 16));
			label.setBounds(46, 46, 86, 34);
			panel_status.add(label);

			JLabel label_1 = new JLabel("预设单价：");
			label_1.setFont(new Font("宋体", Font.PLAIN, 16));
			label_1.setBounds(46, 85, 86, 34);
			panel_status.add(label_1);

			JLabel label_2 = new JLabel("房间电话：");
			label_2.setFont(new Font("宋体", Font.PLAIN, 16));
			label_2.setBounds(46, 125, 86, 34);
			panel_status.add(label_2);

			JLabel label_3 = new JLabel("所在区域：");
			label_3.setFont(new Font("宋体", Font.PLAIN, 16));
			label_3.setBounds(46, 169, 86, 34);
			panel_status.add(label_3);

			JLabel label_4 = new JLabel("入住时间：");
			label_4.setFont(new Font("宋体", Font.PLAIN, 16));
			label_4.setBounds(46, 213, 86, 34);
			panel_status.add(label_4);

			JLabel label_5 = new JLabel("已用时间：");
			label_5.setFont(new Font("宋体", Font.PLAIN, 16));
			label_5.setBounds(46, 257, 86, 34);
			panel_status.add(label_5);

			JLabel label_6 = new JLabel("已交押金：");
			label_6.setFont(new Font("宋体", Font.PLAIN, 16));
			label_6.setBounds(46, 301, 86, 34);
			panel_status.add(label_6);

			JLabel label_7 = new JLabel("应收金额：");
			label_7.setFont(new Font("宋体", Font.PLAIN, 16));
			label_7.setBounds(46, 345, 86, 34);
			panel_status.add(label_7);

			JLabel label_8 = new JLabel("当前占用：");
			label_8.setFont(new Font("宋体", Font.PLAIN, 16));
			label_8.setBounds(46, 471, 86, 34);
			panel_status.add(label_8);

			JLabel label_9 = new JLabel("当前可供：");
			label_9.setFont(new Font("宋体", Font.PLAIN, 16));
			label_9.setBounds(46, 515, 86, 34);
			panel_status.add(label_9);

			JLabel label_10 = new JLabel("当前预定：");
			label_10.setFont(new Font("宋体", Font.PLAIN, 16));
			label_10.setBounds(46, 559, 86, 34);
			panel_status.add(label_10);

			JLabel label_11 = new JLabel("当前停用：");
			label_11.setFont(new Font("宋体", Font.PLAIN, 16));
			label_11.setBounds(46, 603, 86, 34);
			panel_status.add(label_11);

			JLabel label_12 = new JLabel("房间总数：");
			label_12.setFont(new Font("宋体", Font.PLAIN, 16));
			label_12.setBounds(46, 427, 86, 34);
			panel_status.add(label_12);

			JLabel label_room_type = new JLabel("房间类型：");
			label_room_type.setFont(new Font("宋体", Font.PLAIN, 23));
			label_room_type.setBounds(46, 10, 137, 26);
			panel_status.add(label_room_type);

			JLabel label_13 = new JLabel("房间总状态：");
			label_13.setFont(new Font("宋体", Font.PLAIN, 23));
			label_13.setBounds(46, 391, 168, 26);
			panel_status.add(label_13);

			JPanel panel_note = new JPanel();
			tabbedPane_info.addTab("便签", null, panel_note, null);
			panel_note.setLayout(null);

			JTextArea textArea_note = new JTextArea();
			textArea_note.setBounds(10, 10, 338, 637);
			panel_note.add(textArea_note);

			tabbedPane_room = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_room.setBounds(373, 122, 1311, 640);
			getContentPane().add(tabbedPane_room);

			JPanel panel_info = new JPanel();
			panel_info.setBounds(386, 807, 1298, 154);
			getContentPane().add(panel_info);
			panel_info.setLayout(null);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 1298, 154);
			panel_info.add(scrollPane);

			scrollPane_info = new JScrollPane();
			scrollPane.setViewportView(scrollPane_info);

			JPanel panel_ad = new JPanel();
			panel_ad.setBounds(10, 839, 353, 122);
			getContentPane().add(panel_ad);

			panel_time = new JPanel();
			panel_time.setBounds(0, 116, 363, 36);
			getContentPane().add(panel_time);
			panel_time.setLayout(null);

			button_show_all = new JButton("显示全部");
			button_show_all.setBounds(1138, 774, 93, 23);
			getContentPane().add(button_show_all);

			comboBox = new JComboBox<Object>();
			comboBox.setToolTipText("过滤状态");
			comboBox.setName("");
			comboBox.setBounds(1291, 776, 93, 21);
			getContentPane().add(comboBox);

			button_refresh = new JButton("刷新");
			button_refresh.setBounds(1455, 774, 93, 23);
			getContentPane().add(button_refresh);
		}
		new LoadRoomType(SystemMain.this);
	}
}
