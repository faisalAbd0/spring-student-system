����   A
      java/lang/Object <init> ()V	  	 
   6com/atypon/student_grading_system/Socket/ClientHandler clientSocket Ljava/net/Socket;	      -com/atypon/student_grading_system/models/USER STUDENT /Lcom/atypon/student_grading_system/models/USER;  Ccom/atypon/student_grading_system/Socket/userHandler/StudentHandler	     
studentDao 7Lcom/atypon/student_grading_system/data/DAO/StudentDao;	     	courseDao 6Lcom/atypon/student_grading_system/data/DAO/CourseDao;	      gradeDao 5Lcom/atypon/student_grading_system/data/DAO/GradeDao;
  "  # �(Lcom/atypon/student_grading_system/data/DAO/StudentDao;Lcom/atypon/student_grading_system/data/DAO/CourseDao;Lcom/atypon/student_grading_system/data/DAO/GradeDao;)V	  % &  
INSTRUCTOR ( Fcom/atypon/student_grading_system/Socket/userHandler/InstructorHandler	  * + , instructorDao :Lcom/atypon/student_grading_system/data/DAO/InstructorDao;
 ' .  / r(Lcom/atypon/student_grading_system/data/DAO/InstructorDao;Lcom/atypon/student_grading_system/data/DAO/GradeDao;)V	  1 2  ADMIN 4 Acom/atypon/student_grading_system/Socket/userHandler/AdminHandler	  6 7 8 adminDao 5Lcom/atypon/student_grading_system/data/DAO/AdminDao;
 3 :  ; �(Lcom/atypon/student_grading_system/data/DAO/AdminDao;Lcom/atypon/student_grading_system/data/DAO/StudentDao;Lcom/atypon/student_grading_system/data/DAO/CourseDao;Lcom/atypon/student_grading_system/data/DAO/InstructorDao;)V	  = > ? out Ljava/io/PrintWriter;	  A B C in Ljava/io/BufferedReader; E F G H I @com/atypon/student_grading_system/Socket/userHandler/UserHandler handleUserRequest `(Lcom/atypon/student_grading_system/models/IUser;Ljava/io/PrintWriter;Ljava/io/BufferedReader;)V
 K L M N O ;com/atypon/student_grading_system/global/ValidateCredential checkUserCredentials i(Ljava/lang/String;Ljava/lang/String;Lcom/atypon/student_grading_system/models/USER;)Ljava/util/Optional;
 Q R S T U java/util/Optional 	isPresent ()Z W true
 Y Z [ \ ] java/io/PrintWriter println (Ljava/lang/String;)V _ Your password is correct	 a b c > d java/lang/System Ljava/io/PrintStream; f [%s] Login successful: %s%n
 h i j k l java/io/PrintStream printf <(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
 Q n o p get ()Ljava/lang/Object; r .com/atypon/student_grading_system/models/IUser
  t u v getUserMenu b(Lcom/atypon/student_grading_system/models/USER;Lcom/atypon/student_grading_system/models/IUser;)V x false z Your password is incorrect | ,[%s] Login failed: %s (Incorrect password)%n
 ~  � � � java/io/BufferedReader readLine ()Ljava/lang/String; �  
 � � � � � java/lang/String split '(Ljava/lang/String;)[Ljava/lang/String; � 5Invalid input. Expected format: <username> <password>
 � � � � � java/lang/Character 	charValue ()C
  � � � handleUserCredentials V(Ljava/lang/String;Ljava/lang/String;Lcom/atypon/student_grading_system/models/USER;)V � Invalid selection.
 � � � � � java/net/Socket getOutputStream ()Ljava/io/OutputStream;
 Y �  � (Ljava/io/OutputStream;Z)V � java/io/InputStreamReader
 � � � � getInputStream ()Ljava/io/InputStream;
 � �  � (Ljava/io/InputStream;)V
 ~ �  � (Ljava/io/Reader;)V � exit
 � � � � equalsIgnoreCase (Ljava/lang/String;)Z
 � � � � charAt (I)C
 � � � � valueOf (C)Ljava/lang/Character;
  � � � handleInput (Ljava/lang/Character;)V
  � �  close � java/io/IOException
 � � �  printStackTrace
 Y �
 ~ �
 � � � U isClosed
 � � � Client disconnected.
 h Z
 � � � � � ?com/atypon/student_grading_system/data/MySqlDao/StudentDaoMySql getInstance C()Lcom/atypon/student_grading_system/data/MySqlDao/StudentDaoMySql;
 � � � � � Bcom/atypon/student_grading_system/data/MySqlDao/InstructorDaoMySql F()Lcom/atypon/student_grading_system/data/MySqlDao/InstructorDaoMySql;
 � � � � � =com/atypon/student_grading_system/data/MySqlDao/AdminDaoMySql A()Lcom/atypon/student_grading_system/data/MySqlDao/AdminDaoMySql;
 � � � � � >com/atypon/student_grading_system/data/MySqlDao/CourseDaoMySql B()Lcom/atypon/student_grading_system/data/MySqlDao/CourseDaoMySql;
 � � � � � =com/atypon/student_grading_system/data/MySqlDao/GradeDaoMySql A()Lcom/atypon/student_grading_system/data/MySqlDao/GradeDaoMySql; � java/lang/Runnable � java/lang/AutoCloseable (Ljava/net/Socket;)V Code LineNumberTable LocalVariableTable this 8Lcom/atypon/student_grading_system/Socket/ClientHandler; socket MethodParameters userType user 0Lcom/atypon/student_grading_system/models/IUser; userHandler BLcom/atypon/student_grading_system/Socket/userHandler/UserHandler; StackMapTable 
Exceptions username Ljava/lang/String; password Ljava/util/Optional; LocalVariableTypeTable FLjava/util/Optional<Lcom/atypon/student_grading_system/models/IUser;>; c Ljava/lang/Character; input [Ljava/lang/String; run line e Ljava/io/IOException; java/lang/Throwable <clinit> 
SourceFile ClientHandler.java      � �        > ?    B C         + ,    7 8                 �  �   F     
*� *+� �    �          	  �       
 � �     
 �   �    �    u v  �   �     dN+� � � Y� � � � !N� 6+� $� � 'Y� )� � -N� +� 0� � 3Y� 5� � � )� 9N-� -,*� <*� @� D �    �   * 
       	 !  " $ # 5 $ < % P ( T ) c + �   *    d � �     d �     d � �   b � �  �    �  E �     � �   	 �   �    � �  �       o+,-� J:� P� :*� <V� X*� <^� X� `e� Y-SY+S� gW*-� m� q� s� **� <w� X*� <y� X� `{� Y-SY+S� gW�    �   * 
   /  1  2  3 " 4 7 5 G 7 P 8 Y 9 n < �   4    o � �     o � �    o  �    o �    g �       g �  �   	 � G Q& �     � �    �      �    � �  �  '     �*� @� }�� �M,�� *� <w� X*� <�� X�,2N,2:+� ��   @   1   3      &   3*-� � �� /*-� $� �� "*-� 0� �� *� <w� X*� <�� X�    �   :    ?  @  A  B % C & F * G / I L J Y K f L s N | O � R �   4    � � �     �   y  * \ � �  / W  �  �    � &� % � � �     � �      	   �       k*� YY*� � �� �� <*� ~Y� �Y*� � �� �� �� @*� @� }YL� +�� �� *+� �� �� ����*� �� L+� �*� �� 
M*� �,��    P W �   P c   W \ c    �   6    W  X , [ A \ P a T b W ^ X _ \ a ` b c a h b j c �      5 
 �  X     k � �   �    ,#F �K  �   �   �     E*� <� 
*� <� �*� @� 
*� @� �*� � *� � ʚ *� � Ͳ `ζ Ч L+� ű    < ? �  �   & 	   h  i  j - k 4 l < p ? n @ o D q �     @     E � �   �   
 B �    �   G      � ѳ � ׳ )� ܳ 5� � � � �    �                   