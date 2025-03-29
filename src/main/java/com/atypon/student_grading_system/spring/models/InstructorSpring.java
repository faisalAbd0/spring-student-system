����   A �
      java/lang/Object <init> ()V  java/util/ArrayList
  	      @com/atypon/student_grading_system/spring/models/InstructorSpring instructorCourseEnrollments Ljava/util/List;	     username Ljava/lang/String;	     password  Borg/springframework/security/core/authority/SimpleGrantedAuthority	      4com/atypon/student_grading_system/spring/models/Role 
Instructor 6Lcom/atypon/student_grading_system/spring/models/Role;
    ! " name ()Ljava/lang/String;
  $  % (Ljava/lang/String;)V ' ( ) * + java/util/List of $(Ljava/lang/Object;)Ljava/util/List;	  - . / id J
  1 2 3 getId ()J
  5 6 " getUsername
  8 9 " getPassword
  ; < = getInstructorCourseEnrollments ()Ljava/util/List;
 ? @ A B C java/lang/String valueOf &(Ljava/lang/Object;)Ljava/lang/String;   E F G makeConcatWithConstants K(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; I 9org/springframework/security/core/userdetails/UserDetails RuntimeVisibleAnnotations Ljakarta/persistence/Id; $Ljakarta/persistence/GeneratedValue; strategy $Ljakarta/persistence/GenerationType; SEQUENCE 	Signature ^Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/InstructorCourseEnrollment;>; Ljakarta/persistence/OneToMany; mappedBy 
instructor cascade !Ljakarta/persistence/CascadeType; ALL orphanRemoval    '(Ljava/lang/String;Ljava/lang/String;)V Code LineNumberTable LocalVariableTable this BLcom/atypon/student_grading_system/spring/models/InstructorSpring; MethodParameters getAuthorities ()Ljava/util/Collection; O()Ljava/util/Collection<+Lorg/springframework/security/core/GrantedAuthority;>; setId (J)V RuntimeInvisibleAnnotations Llombok/Generated; setUsername setPassword setInstructorCourseEnrollments (Ljava/util/List;)V LocalVariableTypeTable a(Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/InstructorCourseEnrollment;>;)V `()Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/InstructorCourseEnrollment;>; 8(JLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V �(JLjava/lang/String;Ljava/lang/String;Ljava/util/List<Lcom/atypon/student_grading_system/spring/models/InstructorCourseEnrollment;>;)V toString 
SourceFile InstructorSpring.java Ljakarta/persistence/Entity; Ljakarta/persistence/Table; BootstrapMethods x MInstructorSpring(id=, username=, password=, instructorCourseEnrollments=) z
 { | } F ~ $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses � %java/lang/invoke/MethodHandles$Lookup � java/lang/invoke/MethodHandles Lookup !    H   . /  J     K   L  Me N O               P    Q J     R  Ss T U[ e V W XZ Y    Z  [   h     *� *� Y� 	� 
*+� *,� �    \            !  "  # ]         ^ _               `   	        a b  [   ;     � Y� � � #� &�    \       ' ]        ^ _   P    c  d e  [   :     *� ,�    \        ]        ^ _      . /  `    .  f     g    h %  [   :     *+� �    \        ]        ^ _         `      f     g    i %  [   :     *+� �    \        ]        ^ _         `      f     g    j k  [   L     *+� 
�    \        ]        ^ _         l         Q  `      P    m f     g    2 3  [   /     *� ,�    \        ]        ^ _   f     g    6 "  [   /     *� �    \        ]        ^ _   f     g    9 "  [   /     *� �    \        ]        ^ _   f     g    < =  [   /     *� 
�    \        ]        ^ _   P    n f     g       [   >     *� *� Y� 	� 
�    \   
       ]        ^ _   f     g     o  [   �     &*� *� Y� 	� 
*� ,*-� *� *� 
�    \            ]   4    & ^ _     & . /    &      &      &    l       &  Q  `    .        P    p f     g    q "  [   C     *� 0*� 4*� 7*� :� >� D  �    \        ]        ^ _   f     g    r    s J   
  t   u   v     y  w    
  � � � 