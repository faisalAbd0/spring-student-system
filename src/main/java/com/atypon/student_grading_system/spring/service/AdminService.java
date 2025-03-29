����   A *
      java/lang/Object <init> ()V	  	 
   =com/atypon/student_grading_system/spring/service/AdminService 	adminRepo :Lcom/atypon/student_grading_system/spring/repos/AdminRepo;      8com/atypon/student_grading_system/spring/repos/AdminRepo save &(Ljava/lang/Object;)Ljava/lang/Object;     findAll ()Ljava/util/List; =(Lcom/atypon/student_grading_system/spring/repos/AdminRepo;)V Code LineNumberTable LocalVariableTable this ?Lcom/atypon/student_grading_system/spring/service/AdminService; MethodParameters RuntimeVisibleAnnotations 8Lorg/springframework/beans/factory/annotation/Autowired; addAdmin @(Lcom/atypon/student_grading_system/spring/models/AdminSpring;)V admin =Lcom/atypon/student_grading_system/spring/models/AdminSpring; 	getAdmins 	Signature Q()Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/AdminSpring;>; 
SourceFile AdminService.java (Lorg/springframework/stereotype/Service; !                   F     
*� *+� �              	         
       
                      !     D     *� +�  W�       
                      " #      "    $      4     
*� �  �                   
     %    &  '    (      )  