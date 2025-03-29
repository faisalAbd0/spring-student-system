����   A x  Tcom/atypon/student_grading_system/spring/auth/RegisterRequest$RegisterRequestBuilder
     <init> ()V	  	 
   =com/atypon/student_grading_system/spring/auth/RegisterRequest username Ljava/lang/String;	     password	     role 6Lcom/atypon/student_grading_system/spring/models/Role;	     dateOfBirth Ljava/time/LocalDate;
     canEqual (Ljava/lang/Object;)Z
     getUsername ()Ljava/lang/String;
 ! " # $  java/lang/Object equals
  & '  getPassword
  ) * + getRole 8()Lcom/atypon/student_grading_system/spring/models/Role;
  - . / getDateOfBirth ()Ljava/time/LocalDate;
 ! 1 2 3 hashCode ()I
 5 6 7 8 9 java/lang/String valueOf &(Ljava/lang/Object;)Ljava/lang/String;   ; < = makeConcatWithConstants \(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
 !  builder X()Lcom/atypon/student_grading_system/spring/auth/RegisterRequest$RegisterRequestBuilder; Code LineNumberTable RuntimeInvisibleAnnotations Llombok/Generated; LocalVariableTable this ?Lcom/atypon/student_grading_system/spring/auth/RegisterRequest; setUsername (Ljava/lang/String;)V MethodParameters setPassword setRole 9(Lcom/atypon/student_grading_system/spring/models/Role;)V setDateOfBirth (Ljava/time/LocalDate;)V o Ljava/lang/Object; other this$username other$username this$password other$password 	this$role 
other$role this$dateOfBirth other$dateOfBirth StackMapTable PRIME I result 	$username 	$password $role $dateOfBirth toString r(Ljava/lang/String;Ljava/lang/String;Lcom/atypon/student_grading_system/spring/models/Role;Ljava/time/LocalDate;)V 
SourceFile RegisterRequest.java NestMembers BootstrapMethods j >RegisterRequest(username=, password=, role=, dateOfBirth=) l
 m n o < p $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses RegisterRequestBuilder t %java/lang/invoke/MethodHandles$Lookup v java/lang/invoke/MethodHandles Lookup !  !                         	 ? @  A          � Y� �    B        C     D       A   /     *� �    B        E        F G   C     D    '   A   /     *� �    B        E        F G   C     D    * +  A   /     *� �    B        E        F G   C     D    . /  A   /     *� �    B        E        F G   C     D    H I  A   :     *+� �    B        E        F G         J      C     D    K I  A   :     *+� �    B        E        F G         J      C     D    L M  A   :     *+� �    B        E        F G         J      C     D    N O  A   :     *+� �    B        E        F G         J      C     D    $   A  |     �+*� �+� � �+� M,*� � �*� N,� :-� � � -�  � �*� %:,� %:� � � �  � �*� (:,� (:� � � �  � �*� ,:	,� ,:
	� 
� � 	
�  � ��    B        E   p    � F G     � P Q   � R G  $ � S Q  * � T Q  G k U Q  M e V Q  l F W Q  r @ X Q  � ! Y Q 	 �  Z Q 
 [   6 �  �  ! !�  ! !	�  ! !	�  ! !	 J    P  C     D       A   9     +� �    B        E        F G      R Q  J    R  C     D    2 3  A  �     p;<=*� N;h-� +� -� 0`=*� %:;h� +� � 0`=*� (:;h� +� � 0`=*� ,:;h� +� � 0`=�    B        E   H    p F G    m \ ]   k ^ ]  
 f _ Q  # M ` Q  > 2 a Q  Y  b Q  [   � �    ! �    ! �    ! ! �    ! ! �    ! ! ! �    ! ! ! �    ! ! ! ! �    ! ! ! !  C     D    c   A   F     *� *� %*� (� 4*� ,� 4� :  �    B        E        F G   C     D       A   /     *� >�    B        E        F G   C     D     d  A   l     *� >*+� *,� *-� *� �    B        E   4     F G                           J            C     D    e    f g      h     k  i q       r 	 s u w 