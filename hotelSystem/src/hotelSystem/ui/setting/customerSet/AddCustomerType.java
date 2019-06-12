package hotelSystem.ui.setting.customerSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hotelSystem.dao.setting.CustomerSetting;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 添加客户类型界面
 * */
public class AddCustomerType extends JFrame {
	public JTextField text_customer_typeID;
	public JTextField text_customer_type;
	public JTextField text_price_discount;
	private CustomerSetting customerSetLogic = new CustomerSetting();

	public AddCustomerType() {

		setResizable(false);
		setSize(460, 390);
		setLocationRelativeTo(null);
		setTitle("客户类型");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		{
			JLabel lblLz = new JLabel("类型编号");
			lblLz.setBounds(69, 35, 108, 29);
			getContentPane().add(lblLz);

			text_customer_typeID = new JTextField();
			text_customer_typeID.setBounds(178, 32, 195, 35);
			getContentPane().add(text_customer_typeID);
			text_customer_typeID.setColumns(10);

			text_customer_type = new JTextField();
			text_customer_type.setColumns(10);
			text_customer_type.setBounds(178, 90, 195, 35);
			getContentPane().add(text_customer_type);

			JLabel label = new JLabel("客户类型");
			label.setBounds(69, 93, 108, 29);
			getContentPane().add(label);

			text_price_discount = new JTextField();
			text_price_discount.setColumns(10);
			text_price_discount.setBounds(178, 146, 195, 35);
			getContentPane().add(text_price_discount);

			JLabel label_1 = new JLabel("打折比例");
			label_1.setBounds(69, 149, 108, 29);
			getContentPane().add(label_1);

			JButton button_enter = new JButton("确认");
			button_enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 确认添加
					customerSetLogic.addCustomerType(AddCustomerType.this);
				}
			});
			button_enter.setBounds(48, 282, 153, 37);
			getContentPane().add(button_enter);

			JButton button_cancel = new JButton("取消");
			button_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_cancel.setBounds(249, 282, 153, 37);
			getContentPane().add(button_cancel);

			JLabel label_2 = new JLabel("注：此打折比例仅适用于商品项目！");
			label_2.setFont(new Font("宋体", Font.PLAIN, 15));
			label_2.setBounds(106, 211, 248, 25);
			getContentPane().add(label_2);

			JLabel label_3 = new JLabel("10为不打折");
			label_3.setFont(new Font("宋体", Font.PLAIN, 15));
			label_3.setBounds(135, 240, 78, 25);
			getContentPane().add(label_3);
		}

	}
}
