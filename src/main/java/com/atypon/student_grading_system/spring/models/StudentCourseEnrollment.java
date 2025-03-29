����   A o
      java/lang/Object <init> ()V  Hcom/atypon/student_grading_system/spring/models/StudentCourseEnrolmentId
  
   #(Ljava/lang/Long;Ljava/lang/Long;)V	      Gcom/atypon/student_grading_system/spring/models/StudentCourseEnrollment id JLcom/atypon/student_grading_system/spring/models/StudentCourseEnrolmentId;	     grade D	     student ?Lcom/atypon/student_grading_system/spring/models/StudentSpring;	     course >Lcom/atypon/student_grading_system/spring/models/CourseSpring;
     ! getId L()Lcom/atypon/student_grading_system/spring/models/StudentCourseEnrolmentId;
 # $ % & ' java/lang/String valueOf &(Ljava/lang/Object;)Ljava/lang/String;
  ) * + 
getStudent A()Lcom/atypon/student_grading_system/spring/models/StudentSpring;
  - . / 	getCourse @()Lcom/atypon/student_grading_system/spring/models/CourseSpring;
  1 2 3 getGrade ()D   5 6 7 makeConcatWithConstants K(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;D)Ljava/lang/String; RuntimeVisibleAnnotations  Ljakarta/persistence/EmbeddedId; Ljakarta/persistence/ManyToOne; Ljakarta/persistence/MapsId; value 	studentId  Ljakarta/persistence/JoinColumn; name 
student_id 
insertable     	updatable -Lcom/fasterxml/jackson/annotation/JsonIgnore; courseId 	course_id $(Ljava/lang/Long;Ljava/lang/Long;D)V Code LineNumberTable LocalVariableTable this ILcom/atypon/student_grading_system/spring/models/StudentCourseEnrollment; Ljava/lang/Long; MethodParameters setId M(Lcom/atypon/student_grading_system/spring/models/StudentCourseEnrolmentId;)V RuntimeInvisibleAnnotations Llombok/Generated; 
setStudent B(Lcom/atypon/student_grading_system/spring/models/StudentSpring;)V 	setCourse A(Lcom/atypon/student_grading_system/spring/models/CourseSpring;)V setGrade (D)V �(Lcom/atypon/student_grading_system/spring/models/StudentCourseEnrolmentId;Lcom/atypon/student_grading_system/spring/models/StudentSpring;Lcom/atypon/student_grading_system/spring/models/CourseSpring;D)V toString ()Ljava/lang/String; 
SourceFile StudentCourseEnrollment.java Ljakarta/persistence/Entity; Ljakarta/persistence/Table; BootstrapMethods b ;StudentCourseEnrollment(id=, student=, course=, grade=) d
 e f g 6 h $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses k %java/lang/invoke/MethodHandles$Lookup m java/lang/invoke/MethodHandles Lookup !          8     9       8   &  :   ;  <s = >  ?s @ AZ B CZ B D       8   &  :   ;  <s E >  ?s F AZ B CZ B D           G  H   k     *� *� Y+,� 	� *)� �    I       !  "  #  $ J   *     K L      = M     E M        N    =   E       O P  H   :     *+� �    I       
 J        K L         N      Q     R    S T  H   :     *+� �    I       
 J        K L         N      8     D   Q     R    U V  H   :     *+� �    I       
 J        K L         N      8     D   Q     R    W X  H   :     *'� �    I       
 J        K L         N      Q     R      !  H   /     *� �    I        J        K L   Q     R    * +  H   /     *� �    I        J        K L   Q     R    . /  H   /     *� �    I        J        K L   Q     R    2 3  H   /     *� �    I        J        K L   Q     R       H   /     *� �    I        J        K L   Q     R     Y  H   l     *� *+� *,� *-� *� �    I        J   4     K L                           N            Q     R    Z [  H   I     *� � "*� (� "*� ,� "*� 0� 4  �    I        J        K L   Q     R    \    ] 8   
  ^   _   `     c  a i   
  j l n 