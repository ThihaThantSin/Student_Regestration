package com.soft.login;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController {
	@FXML
	private TextField tf;
	@FXML
	private PasswordField pf;

	@FXML
	private TextField tf1;
	@FXML
	private PasswordField pf1;
	@FXML
	private Label lb;
	@FXML
	private Label lb1;

	static String text;
	static String pass;
	static String new_text;
	static String new_pass;
	Stage primaryStage1 = new Stage();
	Scene scene1;
	VBox root1 = new VBox();

	public void newStage() {
		try {
			VBox root1 = (VBox) FXMLLoader.load(getClass().getResource("newLogin.fxml"));
			Scene scene1 = new Scene(root1);
			primaryStage1.setTitle("Login Form");
			primaryStage1.setResizable(false);
			primaryStage1.setScene(scene1);
			primaryStage1.show();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void checkSaveCondition() {
		if (tf.getText().isEmpty() && pf.getText().isEmpty()) {
			lb1.setText("ERROR!,Creat your Account!");
		} else if (tf.getText().isEmpty() && !pf.getText().isEmpty()) {
			lb1.setText("ERROR!,Creat your Username!");
		} else if (!tf.getText().isEmpty() && pf.getText().isEmpty()) {
			lb1.setText("ERROR!,Creat your Password!");
		} else if (text.length() < 8 && pass.length() < 8) {
			lb1.setText("ERROR!,Input both of them at least 8!");
		} else if (text.length() >= 8 && pass.length() < 8) {
			lb1.setText("ERROR!,Input Password at least 8!");
		} else if (text.length() < 8 && pass.length() >= 8) {
			lb1.setText("ERROR!,Input Username at least 8!");
		} else if (text.length() >= 8 && pass.length() >= 8) {
			System.out.println("Save Successfully!");
			System.out.println("UserName- " + text + "\n" + "Password- " + pass);
			newStage();
		}
	}

	public void save_and_login() {
		text = tf.getText();
		pass = pf.getText();
		checkSaveCondition();
	}

	public void clearSave() {
		tf.setText("");
		pf.setText("");
		lb1.setText("");
	}

	public void clearLogin() {
		tf1.setText("");
		pf1.setText("");
		lb.setText("");
	}

	public void exit() {
		System.exit(0);
	}

	public void checkLoginCondition() {
		if (new_text.equals(text) && new_pass.equals(pass)) {
			System.out.println("Welcome! Mrs.Thiha");
		} else if (tf1.getText().isEmpty() && pf1.getText().isEmpty()) {
			lb.setText("ERROR!,Put your Account!");
		} else if (tf1.getText().isEmpty()) {
			lb.setText("ERROR!,Put your Username!");
			pf1.clear();
		} else if (pf1.getText().isEmpty()) {
			lb.setText("ERROR!,Put your Password!");
			tf1.clear();
		} else if (!new_text.equals(text) || !new_pass.equals(pass)
				|| !new_pass.equals(pass) && !new_text.equals(text)) {
			System.out.println("You are not Mrs.Thiha." + "\n" + "Make again your password!");
			exit();
		}
	}

	public void user() {
		new_text = tf1.getText();
		new_pass = pf1.getText();
		checkLoginCondition();
	}
}
