package de.oltzen.youtubevaadin.part9;

import java.util.Optional;

import com.vaadin.data.TreeData;
import com.vaadin.event.selection.SelectionEvent;
import com.vaadin.ui.*;

public class TreeExample extends HorizontalLayout {
	
	TextField output = new TextField("Select");
	
	public TreeExample() {
		Tree<Data> tree = new Tree();
		
		tree.setItemCaptionGenerator(data -> data.name+" "+data.cost);
		
		tree.addSelectionListener(e->select(e));
		
		tree.setTreeData(createTree());
		
		addComponents(tree, output);
	}
	
	private void select(SelectionEvent<Data> e) {
		Optional<Data> optData = e.getFirstSelectedItem();
		if (optData.isPresent()) {
			output.setValue(optData.get().name);
		}
	}

	public TreeData<Data> createTree() {
		TreeData<Data> tree = new TreeData<>();
		Data hier = new Data("Animal", 0);
		tree.addItem(null, hier);
		tree.addItem(hier, new Data("Cat", 10));
		tree.addItem(hier, new Data("Dog", 20));
		tree.addItem(hier, new Data("Mouse", 1));
		
		hier = new Data("Object", 0);
		tree.addItem(null, hier);
		tree.addItem(hier, new Data("Computer", 10));
		tree.addItem(hier, new Data("Chair", 20));
		tree.addItem(hier, new Data("Monitor", 1));

		hier = new Data("Plant", 0);
		tree.addItem(null, hier);
		tree.addItem(hier, new Data("Gras", 10));
		tree.addItem(hier, new Data("Tree", 20));
		tree.addItem(hier, new Data("Flower", 1));
		return tree;
	}
	
	class Data {
		String name;
		double cost;
		
		Data(String n, double c) {
			name = n;
			cost = c;
		}
		
		
	}
}
