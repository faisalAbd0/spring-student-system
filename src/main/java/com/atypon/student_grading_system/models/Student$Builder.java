����   A 5
      java/lang/Object <init> ()V	  	 
   8com/atypon/student_grading_system/models/Student$Builder id I	     age	     username Ljava/lang/String;	     password	     gpa D  0com/atypon/student_grading_system/models/Student
     *(Ljava/lang/String;Ljava/lang/String;IDI)V Code LineNumberTable LocalVariableTable this :Lcom/atypon/student_grading_system/models/Student$Builder; setId =(I)Lcom/atypon/student_grading_system/models/Student$Builder; MethodParameters setAge setUsername N(Ljava/lang/String;)Lcom/atypon/student_grading_system/models/Student$Builder; setPassword setGpa =(D)Lcom/atypon/student_grading_system/models/Student$Builder; build 4()Lcom/atypon/student_grading_system/models/Student; 
SourceFile Student.java NestHost InnerClasses Builder !                                        /     *� �    !        "        # $    % &      ?     *� *�    !   
        "        # $         '        ( &      ?     *� *�    !   
    #  $ "        # $         '        ) *      ?     *+� *�    !   
    '  ( "        # $         '        + *      ?     *+� *�    !   
    +  , "        # $         '        , -      ?     *'� *�    !   
    /  0 "        # $         '        . /      F     � Y*� *� *� *� *� � �    !       3 "        # $    0    1 2     3   
    4 	