����   A I
      java/lang/Object <init> ()V	  	 
   Tcom/atypon/student_grading_system/spring/auth/RegisterRequest$RegisterRequestBuilder username Ljava/lang/String;	     password	     role 6Lcom/atypon/student_grading_system/spring/models/Role;	     dateOfBirth Ljava/time/LocalDate;  =com/atypon/student_grading_system/spring/auth/RegisterRequest
     r(Ljava/lang/String;Ljava/lang/String;Lcom/atypon/student_grading_system/spring/models/Role;Ljava/time/LocalDate;)V
     ! " java/lang/String valueOf &(Ljava/lang/Object;)Ljava/lang/String;   $ % & makeConcatWithConstants \(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String; RuntimeInvisibleAnnotations Llombok/Generated; Code LineNumberTable LocalVariableTable this VLcom/atypon/student_grading_system/spring/auth/RegisterRequest$RegisterRequestBuilder; j(Ljava/lang/String;)Lcom/atypon/student_grading_system/spring/auth/RegisterRequest$RegisterRequestBuilder; MethodParameters �(Lcom/atypon/student_grading_system/spring/models/Role;)Lcom/atypon/student_grading_system/spring/auth/RegisterRequest$RegisterRequestBuilder; m(Ljava/time/LocalDate;)Lcom/atypon/student_grading_system/spring/auth/RegisterRequest$RegisterRequestBuilder; build A()Lcom/atypon/student_grading_system/spring/auth/RegisterRequest; toString ()Ljava/lang/String; 
SourceFile RegisterRequest.java NestHost BootstrapMethods ; URegisterRequest.RegisterRequestBuilder(username=, password=, role=, dateOfBirth=) =
 > ? @ % A $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses RegisterRequestBuilder E %java/lang/invoke/MethodHandles$Lookup G java/lang/invoke/MethodHandles Lookup !          '     (       '     (       '     (       '     (         )   /     *� �    *        +        , -   '     (     .  )   ;     *+� *�    *        +        , -         /      '     (     .  )   ;     *+� *�    *        +        , -         /      '     (     0  )   ;     *+� *�    *        +        , -         /      '     (     1  )   ;     *+� *�    *        +        , -         /      '     (    2 3  )   B     � Y*� *� *� *� � �    *        +        , -   '     (    4 5  )   F     *� *� *� � *� � � #  �    *        +        , -   '     (    6    7 '     (   8     9     <  : B       C 	 D F H 