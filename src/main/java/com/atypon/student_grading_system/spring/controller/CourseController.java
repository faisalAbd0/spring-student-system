����   A %
      java/lang/Object <init> ()V	  	 
   Dcom/atypon/student_grading_system/spring/controller/CourseController courseService @Lcom/atypon/student_grading_system/spring/service/CourseService;
      >com/atypon/student_grading_system/spring/service/CourseService getAllCourses ()Ljava/util/List; C(Lcom/atypon/student_grading_system/spring/service/CourseService;)V Code LineNumberTable LocalVariableTable this FLcom/atypon/student_grading_system/spring/controller/CourseController; MethodParameters RuntimeVisibleAnnotations 8Lorg/springframework/beans/factory/annotation/Autowired; 	Signature R()Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/CourseSpring;>; 4Lorg/springframework/web/bind/annotation/GetMapping; 
SourceFile CourseController.java 8Lorg/springframework/web/bind/annotation/RestController; 8Lorg/springframework/web/bind/annotation/RequestMapping; value 
api/course !                   F     
*� *+� �              	         
       
                          2     *� � �                                                 !   "  #[ s $