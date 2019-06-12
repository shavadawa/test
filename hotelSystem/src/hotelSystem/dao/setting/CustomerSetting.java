package hotelSystem.dao.setting;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import hotelSystem.ui.setting.customerSet.AddCustomerType;
import hotelSystem.ui.setting.customerSet.ChangeCustomerType;
import hotelSystem.ui.setting.setting.SettingFrame;

public class CustomerSetting {

	// 查询客户类型
	public static String sqlOfSelectCustomerType = "select * from tb_customer_type;";
	// 添加客户类型
	public static String sqlOfAddCustomerType = "insert into tb_customer_type values(?,?,?);";
	// 获得被修改的客户类型
	public static String sqlOfGetCustomerType = "select * from tb_customer_type where customerTypeID=?;";
	// 修改客户类型
	public static String sqlOfSetCustomerType = "update tb_customer_type set customerType=?,priceDiscount=? where customerTypeID=?;";
	// 删除客户类型
	public static String sqlOfDeleteCustomerType = "delete from tb_customer_type where customerTypeID=?;";
	// 查询房间打折
	public static String sqlOfSelectRoomDiscount = "select roomType,prePrice from tb_room_type;";

	// 查询客户类型
	public void selectCustomerType(JTable table, String sql) {
		String[] cName = { "客户类型编号", "客户类型", "打折比例" };
		Object[][] customerTypeData = DBConnection.selectResult(sql).getRowsByIndex();
		DefaultTableModel tableModel = new DefaultTableModel(customerTypeData, cName);
		table.setModel(tableModel);
	}

	// 查询打折项目
	public void selectRoomPriceDiscount() {
		String[] cName = { "房间类型", "预设单价" };
		Object[][] objects = DBConnection.selectResult(sqlOfSelectRoomDiscount).getRowsByIndex();
		DefaultTableModel tableModel = new DefaultTableModel(objects, cName);
		SettingFrame.table_room_discount.setModel(tableModel);
	}

	// 获得被修改的客户类型
	public void getCustomerType(ChangeCustomerType customerType) {
		Object[][] objects = DBConnection.selectResult(sqlOfGetCustomerType,
				SettingFrame.table_customer_type.getValueAt(SettingFrame.table_customer_type.getSelectedRow(), 0))
				.getRowsByIndex();
		customerType.text_customer_typeID.setText(objects[0][0].toString());
		customerType.text_customer_type.setText(objects[0][1].toString());
		customerType.text_customer_price_discount.setText(objects[0][2].toString());
	}

	// 添加客户类型
	public void addCustomerType(AddCustomerType customerType) {
		String ID = customerType.text_customer_typeID.getText();
		String type = customerType.text_customer_type.getText();
		int price = Integer.parseInt(customerType.text_price_discount.getText());
		if (DBConnection.selectBoolean(sqlOfAddCustomerType, ID, type, price)) {
			JOptionPane.showMessageDialog(customerType, "添加成功", "提示", 1);
			customerType.dispose();
			selectCustomerType(SettingFrame.table_customer_type, sqlOfSelectCustomerType);
		} else {
			JOptionPane.showMessageDialog(customerType, "添加失败", "提示", 0);
		}
	}

	// 修改客户类型
	public void setCustomerType(ChangeCustomerType customerType) {
		String ID = customerType.text_customer_typeID.getText();
		String type = customerType.text_customer_type.getText();
		int price = Integer.parseInt(customerType.text_customer_price_discount.getText());
		if (DBConnection.selectBoolean(sqlOfSetCustomerType, type, price, ID)) {
			JOptionPane.showMessageDialog(customerType, "修改成功", "提示", 1);
			customerType.dispose();
			selectCustomerType(SettingFrame.table_customer_type, sqlOfSelectCustomerType);
		} else {
			JOptionPane.showMessageDialog(customerType, "修改失败", "提示", 0);
		}
	}

	// 删除客户类型
	public void deleteCustomerType() {
		if (JOptionPane.showConfirmDialog(SettingFrame.table_customer_type, "删除？", "警告", 0, 2) == 0) {
			if (DBConnection.selectBoolean(sqlOfDeleteCustomerType, SettingFrame.table_customer_type
					.getValueAt(SettingFrame.table_customer_type.getSelectedRow(), 0))) {
				JOptionPane.showMessageDialog(SettingFrame.table_customer_type, "删除成功", "提示", 1);
				selectCustomerType(SettingFrame.table_customer_type, sqlOfSelectCustomerType);
			} else {
				JOptionPane.showMessageDialog(SettingFrame.table_customer_type, "删除失败", "提示", 0);
			}
		}
	}

}
