����   A E
      java/lang/Object <init> ()V    	 
 run h(Lcom/atypon/student_grading_system/spring/repos/AdminRepo;)Lorg/springframework/boot/CommandLineRunner;  ;com/atypon/student_grading_system/spring/models/AdminSpring  admin  <$2a$12$pAq4PnXQDv75vcDrlUxafeVVbXRcnC9y3wK3xGYbCjl9eG/NKNiB2
     '(Ljava/lang/String;Ljava/lang/String;)V      8com/atypon/student_grading_system/spring/repos/AdminRepo save &(Ljava/lang/Object;)Ljava/lang/Object;  9com/atypon/student_grading_system/spring/conf/AdminConfig Code LineNumberTable LocalVariableTable this ;Lcom/atypon/student_grading_system/spring/conf/AdminConfig; commandLineRunner3 	adminRepo :Lcom/atypon/student_grading_system/spring/repos/AdminRepo; MethodParameters RuntimeVisibleAnnotations -Lorg/springframework/context/annotation/Bean; lambda$commandLineRunner3$0 P(Lcom/atypon/student_grading_system/spring/repos/AdminRepo;[Ljava/lang/String;)V args [Ljava/lang/String; =Lcom/atypon/student_grading_system/spring/models/AdminSpring; 
Exceptions . java/lang/Exception 
SourceFile AdminConfig.java 6Lorg/springframework/context/annotation/Configuration; BootstrapMethods 4 ([Ljava/lang/String;)V 6
  7 ' ( 9
 : ; < = > "java/lang/invoke/LambdaMetafactory metafactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; InnerClasses A %java/lang/invoke/MethodHandles$Lookup C java/lang/invoke/MethodHandles Lookup !               /     *� �                           ! 
     ;     +�   �                            " #  $    "   %     &  
 ' (     [     � Y� M*,�  W�                         " #      ) *   	  +  ,     -  /    0 %     1   2     8  3 5 3 ?   
  @ B D 