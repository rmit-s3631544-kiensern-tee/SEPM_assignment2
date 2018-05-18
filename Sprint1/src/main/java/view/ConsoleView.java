package main.java.view;

import java.util.ArrayList;

public class ConsoleView {
	public void DrawIntroView() {
		DrawDivider();
		System.out.println("Movie Plaza Theatre - ABC Cineplex corp.");
		System.out.println("jMoSS - Java-Based Movie Search System");
		DrawDivider();
	}
	
	public void DrawDivider() {
		System.out.println("----------------------------------------");
	}
	
	public void DrawListDivider() {
		System.out.println("---");
	}
	
	public void DrawLineBreak(int count) {
		for (int i = 0; i < count; i++) {
			System.out.println();
		}
	}
	
	public void DrawAlert(String alertString) {
		System.out.println("!-- "+alertString+" --!");
	}
	
	public void DrawTitle(String title) {
		DrawDivider();
		System.out.println("jMoSS - "+title);
		DrawDivider();
	}
}
