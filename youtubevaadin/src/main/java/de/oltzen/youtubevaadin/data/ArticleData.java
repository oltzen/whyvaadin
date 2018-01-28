package de.oltzen.youtubevaadin.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArticleData {
	
	private String name;
	
	private String articleNo;
	
	private double cost;
	
	private boolean available;
	
	public ArticleData(String n, String a, double c, boolean av) {
		name = n;
		articleNo = a;
		cost = c;
		available = av;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(String articleNo) {
		this.articleNo = articleNo;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	
	
	public static List<ArticleData> getExampleList(){
		ArrayList<ArticleData> list = new ArrayList<>();
		list.add(new ArticleData("Camera", "686-90", 400, true));
		list.add(new ArticleData("Table", "122-11", 89, true));
		list.add(new ArticleData("Chair", "686-90", 29.50, true));
		list.add(new ArticleData("Computer", "802-90", 899.99, true));
		list.add(new ArticleData("Clock", "1-01", 8.99, false));
		list.add(new ArticleData("Frog", "67-90", 1.99, false));
		
		Random r = new Random();
		for (int i = 0; i< 1000; i++) {
			list.add(new ArticleData("Thing-"+i, i+"-99-4", r.nextInt(99800)*0.01+1.99, true));
		}
		
		return list;
	}

}
