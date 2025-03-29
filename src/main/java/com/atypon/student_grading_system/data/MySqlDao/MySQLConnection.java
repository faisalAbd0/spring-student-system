����   A P
      java/lang/Object <init> ()V	  	 
   ?com/atypon/student_grading_system/data/MySqlDao/MySQLConnection instance Ljava/sql/Connection;  *jdbc:mysql://localhost:3306/student_system  root  123456
      java/sql/DriverManager getConnection M(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/sql/Connection;	      java/lang/System out Ljava/io/PrintStream;   $✅ Connected to MySQL successfully!
 " # $ % & java/io/PrintStream println (Ljava/lang/String;)V ( java/sql/SQLException * java/lang/RuntimeException , ❌ Failed to connect to MySQL
 ) .  / *(Ljava/lang/String;Ljava/lang/Throwable;)V 1 2 3 4  java/sql/Connection close 6 ✅ MySQL connection closed. 8 $❌ Failed to close MySQL connection : java/io/Closeable URL Ljava/lang/String; ConstantValue USER PASSWORD Code LineNumberTable LocalVariableTable this ALcom/atypon/student_grading_system/data/MySqlDao/MySQLConnection; ()Ljava/sql/Connection; e Ljava/sql/SQLException; StackMapTable J java/lang/Throwable 
Exceptions M java/io/IOException 
SourceFile MySQLConnection.java!    9   ; <  =      > <  =      ? <  =     
          @   3     *� �    A   
       B        C D   	  E  @   �     <� � 5YK�� � *ç L*�+�� � !� K� )Y+*� -�� �             ) , '  A   & 	          !  )  ,  -  8  B     -  F G   H    �     I� J '  4   @   �     1� � -� � 0 � 5� !� � L� )Y7+� -�M� ,��     '   )    * )    A   * 
   $  &  '  +  ,  (  ) ) + . , 0 . B       F G    1 C D   H    ] 'K I K     L  N    O