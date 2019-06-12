package hotelSystem.ui.setting.customerSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import hotelSystem.dao.setting.CustomerSetting;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/*
 * 修改客户类型
 * */
public class ChangeCustomerType extends JFrame {

	public JTextField text_customer_typeID;
	public JTextField text_customer_type;
	public JTextField text_customer_price_discount;
	private CustomerSetting customerSetLogic = new CustomerSetting();

	public ChangeCustomerType() {

		setTitle("修改客户类型");
		setResizable(false);
		setSize(500, 390);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);

		{
			JLabel label = new JLabel("类型编号");
			label.setBounds(95, 24, 108, 29);
			getContentPane().add(label);

			text_customer_typeID = new JTextField();
			text_customer_typeID.setColumns(10);
			text_customer_typeID.setBounds(204, 21, 195, 35);
			getContentPane().add(text_customer_typeID);

			JLabel label_1 = new JLabel("客户类型");
			label_1.setBounds(95, 82, 108, 29);
			getContentPane().add(label_1);

			text_customer_type = new JTextField();
			text_customer_type.setColumns(10);
			text_customer_type.setBounds(204, 79, 195, 35);
			getContentPane().add(text_customer_type);

			JLabel label_2 = new JLabel("打折比例");
			label_2.setBounds(95, 138, 108, 29);
			getContentPane().add(label_2);

			text_customer_price_discount = new JTextField();
			text_customer_price_discount.setColumns(10);
			text_customer_price_discount.setBounds(204, 135, 195, 35);
			getContentPane().add(text_customer_price_discount);

			JLabel label_3 = new JLabel("注：此打折比例仅适用于商品项目！");
			label_3.setFont(new Font("宋体", Font.PLAIN, 15));
			label_3.setBounds(132, 200, 248, 25);
			getContentPane().add(label_3);

			JLabel label_4 = new JLabel("10为不打折");
			label_4.setFont(new Font("宋体", Font.PLAIN, 15));
			label_4.setBounds(161, 229, 78, 25);
			getContentPane().add(label_4);

			JButton button_enter = new JButton("确认");
			button_enter.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 确认修改
					customerSetLogic.setCustomerType(ChangeCustomerType.this);
				}
			});
			button_enter.setBounds(74, 271, 153, 37);
			getContentPane().add(button_enter);

			JButton button_cancel = new JButton("取消");
			button_cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			button_cancel.setBounds(275, 271, 153, 37);
			getContentPane().add(button_cancel);
		}
		// 获得被修改的客户类型
		customerSetLogic.getCustomerType(ChangeCustomerType.this);
	}

}
