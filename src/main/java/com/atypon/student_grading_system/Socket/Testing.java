����   A X
      java/lang/Object <init> ()V
  	 
   ?com/atypon/student_grading_system/data/MySqlDao/StudentDaoMySql getInstance C()Lcom/atypon/student_grading_system/data/MySqlDao/StudentDaoMySql;
     getAllStudents ()Ljava/util/List;      java/util/List iterator ()Ljava/util/Iterator;      java/util/Iterator hasNext ()Z      next ()Ljava/lang/Object; " 0com/atypon/student_grading_system/models/Student	 $ % & ' ( java/lang/System out Ljava/io/PrintStream;
 * + , - . java/io/PrintStream println (Ljava/lang/Object;)V
 0 1 2  3 >com/atypon/student_grading_system/data/MySqlDao/CourseDaoMySql B()Lcom/atypon/student_grading_system/data/MySqlDao/CourseDaoMySql;
 0 5 6 7 getStudentCourseById (I)Ljava/util/List; 9 /com/atypon/student_grading_system/models/Course ; 0com/atypon/student_grading_system/Socket/Testing Code LineNumberTable LocalVariableTable this 2Lcom/atypon/student_grading_system/Socket/Testing; main ([Ljava/lang/String;)V student 2Lcom/atypon/student_grading_system/models/Student; c 1Lcom/atypon/student_grading_system/models/Course; args [Ljava/lang/String; 
studentDao ALcom/atypon/student_grading_system/data/MySqlDao/StudentDaoMySql; students Ljava/util/List; course LocalVariableTypeTable DLjava/util/List<Lcom/atypon/student_grading_system/models/Student;>; CLjava/util/List<Lcom/atypon/student_grading_system/models/Course;>; StackMapTable 
Exceptions T java/sql/SQLException MethodParameters 
SourceFile Testing.java ! :           <   /     *� �    =        >        ? @   	 A B  <        a� L+� M,�  N-�  � -�  � !:� #� )��� /� 4N-�  :�  � �  � 8:� #� )���    =   * 
      	  $  ,  /  7  U  ]  `  >   >  $  C D  U  E F    a G H    ] I J  	 X K L  7 * M L  N     	 X K O  7 * M P  Q    �    � �   �   R     S U    G    V    W