package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.TranslateTransition;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
class Plant
{
	float health;
	Plant()
	{
		health=5;
	}
}
class level
{
	
	int numofzombie;
	int num;
	int point;
	level(int numofzombie,int num)
	{
		this.numofzombie=numofzombie;
		this.num=num;
		point=50;
	}
}
class Zombie
{
	double health;
	int zombierunner;
	Zombie()
	{
		health=4;
	}
}
class PeaShooter extends Plant
{
	
}
class Sunflower extends Plant
{
	
}
class Wallnut extends Plant
{
	
}
class PotatoMine extends Plant
{
	
}
class Player
{
	
}
class Game
{
	
}
public class Main extends Application {
	TranslateTransition[] translate = new TranslateTransition[20];

	level l=null;
	int w=0;
	int min=100,count=0;
	Boolean p=true;
	TextField name;
	int zombierunner=0;
	Label tester=null;
	Label sunpoint;
	int sunpoints = 50;
	GridPane gridpane = null;
	int countzombie=0;
	Button sunflower,peashooter=null,wallnut=null,potatomine=null;
	Timeline[][] forpea=new Timeline[5][9];	
	ImageView peaview=new ImageView();
	ImageView sunfromplant=new ImageView();
	int q=0;
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = new AnchorPane();
			Scene scene = new Scene(root,1000,540);
			ArrayList<Image> im;
			Image image =new Image(new FileInputStream("p.jpg"));
			ImageView imageview=new ImageView(image);
			imageview.setFitHeight(600);	imageview.setFitWidth(1000);
			
			Button newgame=new Button();
			newgame.setLayoutX(435);	newgame.setLayoutY(130);
			Image a=new Image(new FileInputStream("button_new-game.png"));
			ImageView imageviewa=new ImageView(a);
			imageviewa.setFitHeight(45); 	imageviewa.setFitWidth(200);
			newgame.setGraphic(imageviewa);
			newgame.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent Event){
					
					AnchorPane root =new AnchorPane();
					Scene newgamescene=new Scene(root,1000,540);
					Image image;
					try {
						image = new Image(new FileInputStream("house.jpg"));
						ImageView imageview=new ImageView(image);
						imageview.setFitHeight(600);	imageview.setFitWidth(1000);
						
						Button enter=new Button();
						enter.setLayoutX(684); 		enter.setLayoutY(133);
						image = new Image(new FileInputStream("button_enter.png"));
						ImageView a=new ImageView(image);
						a.setFitHeight(31); 	a.setFitWidth(101);
						enter.setGraphic(a);
						enter.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) 
							{
								if(name.getText().contentEquals(""))
									name.setPromptText("Name cannot be empty");
								else
								{
									Button level1=new Button("LEVEL 1");
									level1.setTranslateX(500);	level1.setTranslateY(100);
									Button level2=new Button("LEVEL 2");
									level2.setTranslateX(500);	level2.setTranslateY(200);
									Button level3=new Button("LEVEL 3");
									level3.setTranslateX(500); level3.setTranslateY(300);
									Button level4=new Button("LEVEL 4");
									level4.setTranslateX(500);level4.setTranslateY(400);
									Button level5=new Button("LEVEL 5");
									level5.setTranslateX(500);level5.setTranslateY(500);
									AnchorPane root=new AnchorPane();
									Scene levels=new Scene(root, 900,600);
									levels.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
									Image image;
									try {
										image = new Image(new FileInputStream("level.jpg"));
										ImageView imageviewc =new ImageView(image);
										root.getChildren().add(imageviewc);
									} catch (FileNotFoundException e1) {
										e1.printStackTrace();
									}
									root.getChildren().addAll(level1,level2,level3,level4,level5);
									Stage window =(Stage)(((Node) event.getSource()).getScene().getWindow());
									window.setScene(levels);
									window.show();
									level1.setOnAction(new EventHandler<ActionEvent>() {
										@Override
										public void handle(ActionEvent events) {
											try {
												l=new level(5,1);
												level1(primaryStage,l);
												
											} catch (FileNotFoundException e) {
												e.printStackTrace();
											}
										}
									});
									level2.setOnAction(new EventHandler<ActionEvent>() {
										@Override
										public void handle(ActionEvent events) {
											try {
												l=new level(8,2);
												level1(primaryStage,l);
												
											} catch (FileNotFoundException e) {
												e.printStackTrace();
											}
										}
									});
									level3.setOnAction(new EventHandler<ActionEvent>() {
										@Override
										public void handle(ActionEvent events) {
											try {
												l=new level(12,3);
												level1(primaryStage,l);
												
											} catch (FileNotFoundException e) {
												e.printStackTrace();
											}
										}
									});
									level4.setOnAction(new EventHandler<ActionEvent>() {
										@Override
										public void handle(ActionEvent events) {
											try {
												l=new level(15,4);
												level1(primaryStage,l);
												
											} catch (FileNotFoundException e) {
												e.printStackTrace();
											}
										}
									});
									level5.setOnAction(new EventHandler<ActionEvent>() {
										@Override
										public void handle(ActionEvent events) {
											try {
												l=new level(17,5);
												level1(primaryStage,l);
												
											} catch (FileNotFoundException e) {
												e.printStackTrace();
											}
										}
									});
									}
							}
						});
						
						Button back =new Button();
						back.setLayoutX(840); 		back.setLayoutY(133);
						image = new Image(new FileInputStream("button_back.png"));
						ImageView b=new ImageView(image);
						b.setFitHeight(34); 	b.setFitWidth(89);
						back.setGraphic(b);
						back.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent arg0) {
								start(primaryStage);
							}
						});
						Label s=new Label("CREATE YOUR OWN HOUSE");
						s.setLayoutX(546); 		s.setId("start");		
						
						name=new TextField();
						name.setPromptText("ENTER YOUR NAME");
						name.setLayoutX(684); 		name.setLayoutY(56);
						name.setMinHeight(40);  	name.setMinWidth(300);
						
						newgamescene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
						root.getChildren().addAll(imageview,enter,s,name,back);
						primaryStage.setScene(newgamescene);
						primaryStage.show();
						
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}	
				}
			});
			
			Button loadgame=new Button();
			loadgame.setLayoutX(435);	loadgame.setLayoutY(213);
			Image b=new Image(new FileInputStream("button_load-game.png"));
			ImageView imageviewb=new ImageView(b);
			imageviewb.setFitHeight(42); 	imageviewb.setFitWidth(205);
			loadgame.setGraphic(imageviewb);
			loadgame.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent Event) {
					loadgame(primaryStage);
					
				}
			});
			
			Button exit=new Button();
			exit.setLayoutX(435);	exit.setLayoutY(289);
			Image c=new Image(new FileInputStream("button_exit.png"));
			ImageView imageviewc=new ImageView(c);
			imageviewc.setFitHeight(45); 	imageviewc.setFitWidth(139);
			exit.setGraphic(imageviewc);
			exit.setOnAction(e->{System.exit(0);});
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			root.getChildren().add(imageview);
			root.getChildren().addAll(newgame,loadgame,exit);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadgame(Stage stage) 
	{
		AnchorPane root =new AnchorPane();
		Scene newgamescene=new Scene(root,1000,540);
		Image image;
		try{
			image = new Image(new FileInputStream("house.jpg"));
			ImageView imageview=new ImageView(image);
			imageview.setFitHeight(600);	imageview.setFitWidth(1000);
			
			Button enter=new Button();
			enter.setLayoutX(684); 		enter.setLayoutY(133);
			image = new Image(new FileInputStream("button_enter.png"));
			ImageView a=new ImageView(image);
			enter.setGraphic(a);
			stage.setScene(newgamescene);
			stage.show();
		}
		catch(Exception e)
		{
		}
	}
	public void level1(Stage stage, level l) throws FileNotFoundException
	{
		Plant[][] plants=new Plant[5][9]; 
		int[] zombieviewy=new int[l.numofzombie];
		class helper extends TimerTask
		{
			Button x;
			helper(Button x)
			{
				this.x=x;
			}
			@Override
			public void run() {
				x.setDisable(false);
			}
		}
		sunpoint=new Label();
		TranslateTransition[] translatezombie=new TranslateTransition[l.numofzombie];
		Zombie[] z=new Zombie[l.numofzombie];
		AnchorPane root=new AnchorPane();
		Scene scene=new Scene(root,1000,540);
		ImageView sunview=new ImageView(new Image(new FileInputStream("sun.png")));;
		sunview.setVisible(false);
		Image image,shovelimage,menuimage,sunflowericon,peashootericon,wallnuticon,potatomineicon;
		ImageView imageview=null,menuview=null,sunflowerview=null,peashooterview=null,wallnutview=null,potatomineview=null,scoreview=null,gameprogress=null;
		Button timerbutton=null;
		Timeline t5;
		ImageView[] lawnmover=new ImageView[5];
		ImageView[][] images=new ImageView[5][9];
		ImageView[][] smallimages=new ImageView[5][9];
		ImageView[] zombieview=new ImageView[l.numofzombie];
		for(int i=0;i<l.numofzombie;i++)
		{
			zombieview[i]=new ImageView();
			translatezombie[i]=new TranslateTransition();
		}
		sunpoint.setText(String.valueOf(l.point));

////////////////////////////////////////////////////////////////////////////////////////////////
		Timeline t=new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try
				{
					sunview.setVisible(true);
					sunview.setLayoutY(0);
					Random rand=new Random();
					int x=rand.nextInt(640)+225;
					int y=rand.nextInt(400)+60;
					sunview.setFitHeight(90); 	sunview.setFitWidth(90);
					sunview.setLayoutX(x);
					TranslateTransition translate=new TranslateTransition();
					translate.setFromY(0);
					translate.setByY(y);
					translate.setDuration(Duration.millis(7000));
					translate.setCycleCount(1);
					translate.setNode(sunview);
					translate.play();
					root.getChildren().add(sunview);
				}
				catch(Exception e) {	}
			}
		}));	
		sunview.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				sunview.setVisible(false);
				sunpoints+=50;
				sunpoint.setText(String.valueOf(sunpoints));
			}
		});
		l.point=sunpoints;
		t.setCycleCount(t.INDEFINITE);
		t.play();

////////////////////////////////////////////////////////////////////////////////////////////////	
		Timeline t1=new Timeline(new KeyFrame(Duration.seconds(25), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try
				{ 
					z[0]=new Zombie();
					z[0].zombierunner=countzombie;
					zombieview[countzombie].setImage(new Image(new FileInputStream("zombie_normal.gif")));
					Random rand=new Random();
					int randomy=rand.nextInt(5)+1;
					//System.out.println(randomy);
					zombieview[countzombie].setLayoutY(((randomy-1)*100)+80);
					zombieviewy[countzombie]=randomy*100;
					zombieview[countzombie].setFitHeight(100); 	zombieview[countzombie].setFitWidth(100);
					translatezombie[countzombie].setInterpolator(Interpolator.LINEAR);
					translatezombie[countzombie].setFromX(890);
					translatezombie[countzombie].setByX(-700);
					translatezombie[countzombie].setRate(.01);
					translatezombie[countzombie].setCycleCount(1);
					translatezombie[countzombie].setNode(zombieview[countzombie]);
					translatezombie[countzombie].play();
					//zombierunner=countzombie;
/////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					//zombierunner++;
////////////////////////////////////////////////////////////////////////////////////////////////////////
					
					countzombie++;
					zombierunner++;
					//gridpane.getChildren().add(zombieview[countzombie-1]);
					root.getChildren().add(zombieview[countzombie-1]);
				}
				catch(Exception e) {}
			}
		}));
		t1.setCycleCount(l.numofzombie);
		t1.play();
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		t5=new Timeline(new KeyFrame(Duration.seconds(0.5),new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				//int abcd;
				for(int k=0;k<l.numofzombie;k++)
				{
					if(zombieview[k].getImage()!=null)
					{
						int j=(zombieviewy[k]/100)-1;
						for(int i=0;i<9;i++)
						{
							//System.out.println);
							System.out.println(k+" "+(zombieview[k].getTranslateX())+" "+images[j][i].getLayoutX());

							if(images[j][i].getImage()!=null &&((zombieview[k].getTranslateX()+160 )<(images[j][i].getLayoutX())))
							{ 
								//abcd=i;
								//System.out.println(abcd+" "+j);
								//System.out.println(k+" "+(zombieview[k].getTranslateX())+" "+images[j][i].getLayoutX());
								translatezombie[k].pause();
								/*plants[j][i].health--;
								System.out.println(plants[j][i].health);
								if(plants[j][i].health==0)
								{
									images[j][i].setImage(null);
									translatezombie[k].play();
								}*/
								
							}
						}
					}
				}
			}
			
		}));
		t5.setCycleCount(t5.INDEFINITE);
		t5.play();
		
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Button shovel=null,menu=null;
		try
		{
			image =new Image(new FileInputStream("lawn1.png"));
			imageview=new ImageView(image);
			imageview.setFitHeight(600); 	imageview.setFitWidth(1000);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
			menuimage=new Image(new FileInputStream("button_menu.png"));
			menuview=new ImageView(menuimage);
			menu=new Button();
			menu.setGraphic(menuview);
			menu.setLayoutY(15); 	menu.setLayoutX(815);
			menu.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent Event) {
					
					Stage stage1=new Stage();
					AnchorPane root=new AnchorPane();
					try {
						ImageView screen1=new ImageView(new Image(new FileInputStream("first_screen.jpg")));
						screen1.setFitHeight(600); 	screen1.setFitWidth(600);
						Button save =new Button();
						save.setLayoutX(200); 	save.setLayoutY(100);
						save.setPrefSize(100,70);
						save.setGraphic(new ImageView(new Image(new FileInputStream("button_save.png"))));
						save.setOnAction(e->{
							t1.stop();
							//translatezombie.pause();
							t.stop();
						});
						
						Button Exit =new Button();
						Exit.setGraphic(new ImageView(new Image(new FileInputStream("button_exit.png"))));
						Exit.setOnAction(e->{translatezombie[0].play();/*System.exit(0);*/});
						Exit.setLayoutX(230); 	Exit.setLayoutY(200);
						Exit.setPrefSize(100,70);
						
						Button mainmenu=new Button();
						mainmenu.setGraphic(new ImageView(new Image(new FileInputStream("button_menu.png"))));
						mainmenu.setOnAction(e->{
							start(stage);
							stage1.close();
						});
						mainmenu.setLayoutX(230); 	mainmenu.setLayoutY(300);
						
						mainmenu.setPrefSize(100,70);	
						root.getChildren().addAll(screen1,save,Exit,mainmenu);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}	
					Scene scene1=new Scene(root,600,600);
					stage1.setScene(scene1);
					stage1.show();
				}
			});
////////////////////////////////////////////////////////////////////////////////////////////////
			gameprogress=new ImageView(new Image(new FileInputStream("timer.png")));
			gameprogress.setLayoutX(550); 	gameprogress.setLayoutY(15);
			gameprogress.setFitHeight(50); 	gameprogress.setFitWidth(250);
////////////////////////////////////////////////////////////////////////////////////////////////	
			gridpane =new GridPane();
			gridpane.setLayoutX(160);	gridpane.setLayoutY(80);
			for (int i = 0; i < 10; i++) {
		            ColumnConstraints colConst = new ColumnConstraints();
		            	colConst.setPrefWidth(80);
		            colConst.setPercentWidth(50);
		            gridpane.getColumnConstraints().add(colConst);
		        }
			 for (int i = 0; i < 5; i++) {
		            RowConstraints rowConst = new RowConstraints();
		            rowConst.setPrefHeight(100);
		            gridpane.getRowConstraints().add(rowConst);       
		        }
			for(int i=0;i<5;i++)
			{
				for(int j=1;j<10;j++)
				{
					images[i][j-1]=new ImageView();
					smallimages[i][j-1]=new ImageView();
					smallimages[i][j-1].setFitHeight(70); 	smallimages[i][j-1].setFitWidth(70);
					images[i][j-1].setFitHeight(100); 	images[i][j-1].setFitWidth(80);
					gridpane.add(images[i][j-1],j, i);
					//System.out.println(images[i][j-1].getX()+" "+images[i][j-1].getY());
				}
			}	
			for(int i=0;i<5;i++)
			{
				lawnmover[i]=new ImageView(new Image(new FileInputStream("lawnmower.png")));
				lawnmover[i].setFitHeight(70); 	lawnmover[i].setFitWidth(70);
				gridpane.add(lawnmover[i], 0, i);
			}
////////////////////////////////////////////////////////////////////////////////////////////////	
			shovelimage=new Image(new FileInputStream("shovel.png"));
			ImageView shovelview=new ImageView(shovelimage);
			shovelview.setFitHeight(33); 	shovelview.setFitWidth(29);
			shovel=new Button();
			shovel.setLayoutX(290); 	shovel.setLayoutY(15);
			shovel.setMaxSize(33, 29);
			shovel.setGraphic(shovelview);
			shovel.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event)
				{
					int x=(int) ((event.getSceneX()-160)/80);
					int y=(int) ((event.getSceneY()-80)/100);
					if(images[y][x-1].getImage()==null)
					{
						tester.setText("no plant on the block");
						
					}
					else
					{
						images[y][x-1].setImage(null);
					}
				}
			});
////////////////////////////////////////////////////////////////////////////////////////////////

			sunflowericon =new Image(new FileInputStream("sunflowericon.png"));
			sunflowerview=new ImageView(sunflowericon);
			sunflower=new Button();
			sunflower.setGraphic(sunflowerview);
			sunflower.setLayoutX(14); 		sunflower.setLayoutY(14);
			sunflowerview.setFitHeight(56); 	sunflowerview.setFitWidth(77);
			sunflower.setOnAction(e->{});
			//System.out.println(l.num+" "+l.numofzombie);

			//if(l.point>50)
			{
				sunflower.setOnMouseReleased(new EventHandler<MouseEvent>() {
					@Override
					public void handle(MouseEvent event) {
						int x=(int) ((event.getSceneX()-160)/80);
						int y=(int) ((event.getSceneY()-80)/100);
						try {
							if(images[y][x-1].getImage()==null)
							{	
								
								//System.out.println((images[y][x-1].getLayoutY()+100)+" "+(images[y][x-1].getLayoutX()+160));
								//System.out.println(images[y][x-1].getLayoutY()+" "+images[y][x-1].getLayoutX());
							images[y][x-1].setImage(new Image(new FileInputStream("sun_flower.gif")));
							images[y][x-1].setFitHeight(70);
							sunflower.setDisable(true);
							TimerTask tasknew =new helper(sunflower);
							Timer timer=new Timer();
							timer.schedule(tasknew,7000,17000);
							forpea[y][x-1]=new Timeline(new KeyFrame(Duration.seconds(10), new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									try
									{
										Image im=new Image(new FileInputStream("sun.png"));
										//tester.setText(null);
										smallimages[y][x-1].setImage(im);
										smallimages[y][x-1].setVisible(true);
										smallimages[y][x-1].setFitHeight(70); 	smallimages[y][x-1].setFitWidth(70);
										smallimages[y][x-1].setImage(im);
										smallimages[y][x-1].setLayoutY(images[y][x-1].getLayoutY()+100);
										smallimages[y][x-1].setLayoutX(images[y][x-1].getLayoutX()+160);
										smallimages[y][x-1].addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
											@Override
											public void handle(MouseEvent event) {
												smallimages[y][x-1].setVisible(false);
												sunpoints+=50;
												sunpoint.setText(String.valueOf(sunpoints));
											}
										});
									}
									catch(Exception e) { 	}
								}
							}));
							forpea[y][x-1].setCycleCount(forpea[y][x-1].INDEFINITE);
							forpea[y][x-1].play();
							}
							else 
							{
								tester.setText("A plant is already planted");
							}
						}
						catch(ArrayIndexOutOfBoundsException e)
						{
							tester.setText("plant cannot be put here");
						}
						catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}	
				});
			}


			if(l.num==1)
			{
				sunflower.setVisible(false);
				//sunflower.setDisable(true);
			}
////////////////////////////////////////////////////////////////////////////////////////////////
			peashootericon =new Image(new FileInputStream("peashootericon.png"));
			peashooterview=new ImageView(peashootericon);
			peashooter=new Button();
			peashooter.setOnAction(e->{});
			peashooter.setGraphic(peashooterview);
			peashooter.setLayoutX(14); 		peashooter.setLayoutY(86);
			peashooterview.setFitHeight(56); 	peashooterview.setFitWidth(77);	
			peashooter.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					System.out.println(sunpoints);
					if(sunpoints>=100)
					{
						sunpoints=sunpoints-100;
						sunpoint.setText(String.valueOf(sunpoints));
						int x=(int) ((event.getSceneX()-160)/80);
						int y=(int) ((event.getSceneY()-80)/100);
						try {
							if(images[y][x-1].getImage()==null)
							{
								plants[y][x-1]=new Plant();
								//System.out.println(images[y][x-1].getLayoutY()+" "+images[y][x-1].getLayoutX());

							Image i=new Image(new FileInputStream("pea_shooter.gif"));
							images[y][x-1].setImage(i);
							images[y][x-1].setFitHeight(70);
							peashooter.setDisable(true);
							TimerTask tasknew =new helper(peashooter);
							Timer timer=new Timer();
							timer.schedule(tasknew,7000,17000);
							
							forpea[y][x-1]=new Timeline(new KeyFrame(Duration.seconds(2), new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									try
									{									
										p=true;
										w=0;
										while(w<l.numofzombie)
										{
											if(zombieview[w].getImage()!=null &&( (int)(zombieviewy[w]/100)-1)==y&& zombieview[w].getTranslateX()!=190)
											{
												p=false;//
												Image im=new Image(new FileInputStream("Pea.png"));
												smallimages[y][x-1].setImage(im);
												smallimages[y][x-1].setFitHeight(30); 	smallimages[y][x-1].setFitWidth(30);
												Random rand=new Random();
												//int xy=rand.nextInt(200)+400;
												smallimages[y][x-1].setImage(im);
												smallimages[y][x-1].setLayoutY(images[y][x-1].getLayoutY()+80);
												translate[w]=new TranslateTransition();
												//translate.
												translate[w].setRate(0.2);
												translate[w].setInterpolator(Interpolator.LINEAR);
												//System.out.println((images[y][x-1].getLayoutX()+240)+" "+(zombieview[w].getTranslateX()));
												translate[w].setFromX(images[y][x-1].getLayoutX()+240);
												translate[w].setByX(zombieview[w].getTranslateX()-320);
												//System.out.println("hell" +smallimages[y][x-1].getTranslateX()+" "+zombieview[w].getTranslateX());
												/*if(Math.abs(smallimages[y][x-1].getTranslateX()+20-zombieview[w].getTranslateX())<100)
												{
													
													System.out.println("true "+z[w].health);
													z[w].health--;
													if(z[w].health==0)
													{
														
														zombieview[w].setImage(null);
														smallimages[y][x-1].setImage(null);
													}
													//

												}*/

												//forpea[y][x-1].wait();
												//if(zombieview[w].)
												translate[w].setCycleCount(1);
												translate[w].setNode(smallimages[y][x-1]);
												translate[w].play();
												//forpea[y][x-1].notifyAll();
												
											}
											if(p==false)break;
											w++;
											
										}
										
									}
									catch(ArrayIndexOutOfBoundsException e)
									{ 
										tester.setText("plant cannot be put here");
									}
									catch(Exception e) {	}
									
									

								}
								
							}));
							forpea[y][x-1].setCycleCount(t1.INDEFINITE);
							forpea[y][x-1].play();
							}

						
							else
							{
								tester.setText("A Plant is already Planted");
							}
						}
						catch (FileNotFoundException e) {	e.printStackTrace();	}
						catch(ArrayIndexOutOfBoundsException e)
						{
							tester.setText("plant cannot be put here");
						}
					}

				}
			});


////////////////////////////////////////////////////////////////////////////////////////////////		

			wallnuticon =new Image(new FileInputStream("wallnuticon.png"));
			wallnutview=new ImageView(wallnuticon);
			wallnut=new Button();
			wallnut.setOnAction(e->{});
			wallnut.setGraphic(wallnutview);
			wallnut.setLayoutX(14); 		wallnut.setLayoutY(158);
			wallnutview.setFitHeight(56); 	wallnutview.setFitWidth(77);
			wallnut.setOnMouseReleased(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					int x=(int) ((event.getSceneX()-160)/80);
					int y=(int) ((event.getSceneY()-80)/100);
					try {
						images[y][x-1].setImage(new Image(new FileInputStream("wallnut.png")));
						wallnut.setDisable(true);
						TimerTask tasknew =new helper(wallnut);
						Timer timer=new Timer();
						timer.schedule(tasknew,7000,17000);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					catch(ArrayIndexOutOfBoundsException e)
					{
						tester.setText("plant cannot be put here");
					}
				}	
			});
			if(l.num<=2)
			{
				wallnut.setVisible(false);
				wallnut.setDisable(true);
			}
////////////////////////////////////////////////////////////////////////////////////////////////	

			potatomineicon =new Image(new FileInputStream("potatomine.png"));
			potatomineview=new ImageView(potatomineicon);
			potatomine=new Button();
			potatomine.setGraphic(potatomineview);
			potatomine.setLayoutX(14); 		potatomine.setLayoutY(228);
			potatomineview.setFitHeight(56); 	potatomineview.setFitWidth(77);
			potatomine.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent Event) {
					
					potatomine.setDisable(true);
					TimerTask tasknew = new helper(potatomine);
					Timer timer=new Timer();
					timer.schedule(tasknew,7000,7000);	
				}
			});
			if(l.num<=3)
			{
				potatomine.setVisible(false);
				potatomine.setDisable(true);
			}
////////////////////////////////////////////////////////////////////////////////////////////////
			scoreview=new ImageView(new Image(new FileInputStream("score.png")));
			scoreview.setFitHeight(44); 	scoreview.setFitWidth(170);
			scoreview.setLayoutX(118); 		scoreview.setLayoutY(14);
////////////////////////////////////////////////////////////////////////////////////////////////
			sunpoint=new Label();
			sunpoint.setLayoutX(190); 	sunpoint.setLayoutY(19);
			sunpoint.setPrefHeight(35); 	sunpoint.setPrefWidth(76);
////////////////////////////////////////////////////////////////////////////////////////////////	
			tester=new Label();
			tester.setLayoutX(400); tester.setLayoutY(15);
////////////////////////////////////////////////////////////////////////////////////////////////
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			root.getChildren().addAll(imageview,shovel,menu,gameprogress,sunflower,peashooter,wallnut,potatomine,scoreview,sunpoint,gridpane,sunview,peaview,tester);
			for(int i=0;i<5;i++)
			{
				for(int j=1;j<10;j++)
				{
					root.getChildren().add(smallimages[i][j-1]);	
				}
			}
			stage.setScene(scene);
			stage.show();
		}
	}
	public static void main(String[] args) {
		launch(args);//
	}
}