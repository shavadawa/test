package hotelSystem.dao.system;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import hotelSystem.dao.setting.DBConnection;
import hotelSystem.ui.system.SystemMain;

/**
 * @author misaka
 * @Date 2019-06-12 12:32:07
 * @Description 获取房间类型
 */
public class LoadRoomType {

	// 获得房间类型
	public static String sqlOfGetRoomType = "select roomType from tb_room_type;";
	// 获得房间名字
	public static String sqlOfSelectRoomInfo = "select roomNumber from tb_room_info where roomType=?;";

	public LoadRoomType(SystemMain sys) {
		Object[][] roomType = DBConnection.selectResult(sqlOfGetRoomType).getRowsByIndex();
		for (int i = 0; i < roomType.length; i++) {
			String tName = roomType[i][0].toString();
			JPanel panel = new JPanel();
			panel.setLayout(new FlowLayout(0, 50, 30));
			sys.tabbedPane_room.add(tName, panel);
			Object[][] roomName = DBConnection.selectResult(sqlOfSelectRoomInfo, tName).getRowsByIndex();
			for (int j = 0; j < roomName.length; j++) {
				JButton button = new JButton(roomName[j][0].toString());
				button.setPreferredSize(new Dimension(80, 60));
				panel.add(button);
			}
		}
	}
}
