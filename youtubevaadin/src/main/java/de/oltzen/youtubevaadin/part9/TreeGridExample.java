package de.oltzen.youtubevaadin.part9;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.*;

public class TreeGridExample extends HorizontalLayout {
	
	
	public TreeGridExample() {
		TreeGrid<TreeFile> dir = new TreeGrid<>();
		this.setSizeFull();
		dir.setSizeFull();
		this.addComponent(dir);
		
		dir.addColumn(TreeFile::getName).setCaption("Name");
		dir.addColumn(TreeFile::getLength).setCaption("Length");
		dir.addColumn(TreeFile::getModDate).setCaption("Change Date");
		
		TreeFile root = new TreeFile(new File("."));
		dir.setItems(root.getList(), TreeFile::getList);
	}

	class TreeFile {
		File file;
		
		TreeFile(File f){
			file = f;
		}
		
		String getName() {
			return file.getName();
		}

		long getLength() {
			return file.length();
		}
		
		Date getModDate() {
			return new Date(file.lastModified());
		}

		
		List<TreeFile> getList(){
			List<TreeFile> dir = new ArrayList<>();
			if (file .isDirectory()) {
				for (File f : file.listFiles()) {
					dir.add(new TreeFile(f));
				}
			} 
			return dir;
		}
	}
}
