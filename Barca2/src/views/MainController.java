package views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import domain.InfoVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController {
	
	@FXML
	private ListView<InfoVO> titleList;
	
	private ObservableList<InfoVO> historyList;
	private ObservableList<InfoVO> playerList;
	private ObservableList<InfoVO> RelationList;
	
	@FXML
	private Label contentLabel; 
	
	@FXML
	private ImageView imgLogo;
	
	
	private int mode = -1;
	
	@FXML
	private void initialize() {
		File hFile = new File(getClass().getResource("/resources/historyData.txt").getFile());
		File pFile = new File(getClass().getResource("/resources/playerData.txt").getFile());
		File mFile = new File(getClass().getResource("/resources/RelationData.txt").getFile());
		historyList = FXCollections.observableArrayList();
		playerList = FXCollections.observableArrayList();
		RelationList = FXCollections.observableArrayList();
		
		try {
			FileInputStream fis = new FileInputStream(hFile);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader br = new BufferedReader(isr);
			
			while(true) {
				String line = br.readLine();
				if(line == null) break;
				String[] infoStr = line.split("#");
				
				Image img = new Image(getClass().getResource("/imgs/" + infoStr[1]).toString());
				InfoVO temp = new InfoVO(infoStr[0], infoStr[2], img );
				
				historyList.add(temp);
			}
			
			FileInputStream fis2 = new FileInputStream(pFile);
			InputStreamReader isr2 = new InputStreamReader(fis2);
			BufferedReader br2 = new BufferedReader(isr2);
			while(true) {
				String line2 = br2.readLine();
				if(line2 == null) break;
				String[] infoStr2 = line2.split("#");
				
				Image img = new Image(getClass().getResource("/imgs/" + infoStr2[1]).toString());
				InfoVO temp = new InfoVO(infoStr2[0], infoStr2[2], img );
				
				playerList.add(temp);
			}
			FileInputStream fis3 = new FileInputStream(mFile);
			InputStreamReader isr3 = new InputStreamReader(fis3);
			BufferedReader br3 = new BufferedReader(isr3);
			while(true) {
				String line3 = br3.readLine();
				if(line3 == null) break;
				String[] infoStr3 = line3.split("#");
				
				Image img = new Image(getClass().getResource("/imgs/" + infoStr3[1]).toString());
				InfoVO temp = new InfoVO(infoStr3[0], infoStr3[2], img );
				
				RelationList.add(temp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 입력중 오류 발생");
		}
	}
	
	
	public void teamhistory() {
		mode = 0;
		titleList.setItems(historyList);
	}
	
	public void SPlayer() {
		mode =1;
		titleList.setItems(playerList);
	}
	
	public void Rs() {
		mode =2;
		titleList.setItems(RelationList);
	}
	
	public void view() {
		if(mode < 0) return;
		
		if(mode == 0) {
			int idx = titleList.getSelectionModel().getSelectedIndex();
			if(idx >= 0) {
				InfoVO item = historyList.get(idx);
				contentLabel.setText(item.getContent().replace("\\n", "\n"));
				imgLogo.setImage(item.getImg());
			}
		}else if(mode == 1) {
			int idx2 = titleList.getSelectionModel().getSelectedIndex();
			if(idx2 >= 0) {
				InfoVO item = playerList.get(idx2);
				contentLabel.setText(item.getContent().replace("\\n", "\n"));
				imgLogo.setImage(item.getImg());
			}
		}else if(mode == 2) {
			int idx3 = titleList.getSelectionModel().getSelectedIndex();
			if(idx3 >= 0) {
				InfoVO item = RelationList.get(idx3);
				contentLabel.setText(item.getContent().replace("\\n", "\n"));
				imgLogo.setImage(item.getImg());
			}		
		}
	
	}
}

