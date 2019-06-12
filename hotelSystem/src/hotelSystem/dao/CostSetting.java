package hotelSystem.dao;

import hotelSystem.ui.setting.setting.SettingFrame;

/*
 * 计费设置
 * */
public class CostSetting {

	private SettingFrame mainFrame = new SettingFrame();

	@SuppressWarnings("unused")
	public void getCost() {
		mainFrame.text_new_day.getText();
		mainFrame.text_half_day.getText();
		mainFrame.text_day.getText();
		mainFrame.text_start_pay.getText();
		mainFrame.text_last_pay.getText();
		mainFrame.text_over30.getText();
		mainFrame.text_over10.getText();
		String newDay = mainFrame.radio_new_day.isSelected() ? "	" : "	";
	}
}
