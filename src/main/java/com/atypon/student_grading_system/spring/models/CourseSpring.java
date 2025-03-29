����   A z
      java/lang/Object <init> ()V  java/util/ArrayList
  	      <com/atypon/student_grading_system/spring/models/CourseSpring studentCourseEnrollments Ljava/util/List;	     instructorCourseEnrollments	     
courseName Ljava/lang/String;	     courseLimit I	     id J
    ! " getId ()J
  $ % & getCourseName ()Ljava/lang/String;
  ( ) * getCourseLimit ()I
  , - . getStudentCourseEnrollments ()Ljava/util/List;
 0 1 2 3 4 java/lang/String valueOf &(Ljava/lang/Object;)Ljava/lang/String;
  6 7 . getInstructorCourseEnrollments   9 : ; makeConcatWithConstants L(JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String; RuntimeVisibleAnnotations Ljakarta/persistence/Id; $Ljakarta/persistence/GeneratedValue; strategy $Ljakarta/persistence/GenerationType; SEQUENCE 	Signature [Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/StudentCourseEnrollment;>; Ljakarta/persistence/OneToMany; mappedBy course cascade !Ljakarta/persistence/CascadeType; ALL orphanRemoval    ^Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/InstructorCourseEnrollment;>; (Ljava/lang/String;I)V Code LineNumberTable LocalVariableTable this >Lcom/atypon/student_grading_system/spring/models/CourseSpring; MethodParameters setId (J)V RuntimeInvisibleAnnotations Llombok/Generated; setCourseName (Ljava/lang/String;)V setCourseLimit (I)V setStudentCourseEnrollments (Ljava/util/List;)V LocalVariableTypeTable ^(Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/StudentCourseEnrollment;>;)V setInstructorCourseEnrollments a(Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/InstructorCourseEnrollment;>;)V ]()Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/StudentCourseEnrollment;>; `()Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/InstructorCourseEnrollment;>; toString 7(JLjava/lang/String;ILjava/util/List;Ljava/util/List;)V �(JLjava/lang/String;ILjava/util/List<Lcom/atypon/student_grading_system/spring/models/StudentCourseEnrollment;>;Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/InstructorCourseEnrollment;>;)V 
SourceFile CourseSpring.java Ljakarta/persistence/Table; Ljakarta/persistence/Entity; BootstrapMethods m jCourseSpring(id=, courseName=, courseLimit=, studentCourseEnrollments=, instructorCourseEnrollments=) o
 p q r : s $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses v %java/lang/invoke/MethodHandles$Lookup x java/lang/invoke/MethodHandles Lookup !          <     =   >  ?e @ A               B    C <     D  Es F G[ e H I JZ K     B    L <     D  Es F G[ e H I JZ K    M  N   w     %*� *� Y� 	� 
*� Y� 	� *+� *� �    O                ! $ " P        % Q R     %      %    S   	        T U  N   :     *� �    O        P        Q R         S      V     W    X Y  N   :     *+� �    O        P        Q R         S      V     W    Z [  N   :     *� �    O        P        Q R         S      V     W    \ ]  N   L     *+� 
�    O        P        Q R         ^         C  S      B    _ V     W    ` ]  N   L     *+� �    O        P        Q R         ^         L  S      B    a V     W    ! "  N   /     *� �    O        P        Q R   V     W    % &  N   /     *� �    O        P        Q R   V     W    ) *  N   /     *� �    O        P        Q R   V     W    - .  N   /     *� 
�    O        P        Q R   B    b V     W    7 .  N   /     *� �    O        P        Q R   B    c V     W       N   M     *� *� Y� 	� 
*� Y� 	� �    O            P        Q R   V     W    d &  N   J      *� *� #*� '*� +� /*� 5� /� 8  �    O        P         Q R   V     W     e  N   �     7*� *� Y� 	� 
*� Y� 	� *� *-� *� *� 
*� �    O              P   >    7 Q R     7      7      7      7      7    ^       7  C    7  L  S              B    f V     W    g    h <   
  i   j   k     n  l t   
  u w y 