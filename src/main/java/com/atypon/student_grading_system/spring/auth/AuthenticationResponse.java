����   A M  bcom/atypon/student_grading_system/spring/auth/AuthenticationResponse$AuthenticationResponseBuilder
     <init> ()V	  	 
   Dcom/atypon/student_grading_system/spring/auth/AuthenticationResponse token Ljava/lang/String;
     canEqual (Ljava/lang/Object;)Z
     getToken ()Ljava/lang/String;
      java/lang/Object equals
     hashCode ()I      ! makeConcatWithConstants &(Ljava/lang/String;)Ljava/lang/String;
   builder f()Lcom/atypon/student_grading_system/spring/auth/AuthenticationResponse$AuthenticationResponseBuilder; Code LineNumberTable RuntimeInvisibleAnnotations Llombok/Generated; LocalVariableTable this FLcom/atypon/student_grading_system/spring/auth/AuthenticationResponse; setToken (Ljava/lang/String;)V MethodParameters o Ljava/lang/Object; other 
this$token other$token StackMapTable PRIME I result $token toString 
SourceFile AuthenticationResponse.java NestMembers BootstrapMethods ? AuthenticationResponse(token=) A
 B C D   E $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses AuthenticationResponseBuilder I %java/lang/invoke/MethodHandles$Lookup K java/lang/invoke/MethodHandles Lookup !           	 	 # $  %          � Y� �    &        '     (       %   /     *� �    &        )        * +   '     (    , -  %   :     *+� �    &       
 )        * +         .      '     (       %   �     C+*� �+� � �+� M,*� � �*� N,� :-� � � -� � ��    &       
 )   4    C * +     C / 0   . 1 +  $  2 0  *  3 0  4    �  �    .    /  '     (       %   9     +� �    &       
 )        * +      1 0  .    1  '     (       %   �     ;<=*� N;h-� +� -� `=�    &       
 )   *     * +     5 6    7 6  
  8 0  4   # �     �      '     (    9   %   4     
*� �   �    &       
 )       
 * +   '     (     -  %   >     
*� "*+� �    &        )       
 * +     
    .      '     (       %   /     *� "�    &        )        * +   '     (    :    ; <      =     @  > F       G 	 H J L 