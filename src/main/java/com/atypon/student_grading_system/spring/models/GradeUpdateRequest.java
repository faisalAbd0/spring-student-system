����   A h	      Bcom/atypon/student_grading_system/spring/models/GradeUpdateRequest newGrade D	   	 
 courseId Ljava/lang/Long;	    
 	studentId
      java/lang/Object <init> ()V
     canEqual (Ljava/lang/Object;)Z
     getNewGrade ()D
      ! java/lang/Double compare (DD)I
  # $ % getCourseId ()Ljava/lang/Long;
  ' (  equals
  * + % getStudentId
  - . / doubleToLongBits (D)J
  1 2 3 hashCode ()I   5 6 7 makeConcatWithConstants 5(DLjava/lang/Long;Ljava/lang/Long;)Ljava/lang/String; setNewGrade (D)V Code LineNumberTable LocalVariableTable this DLcom/atypon/student_grading_system/spring/models/GradeUpdateRequest; MethodParameters RuntimeInvisibleAnnotations Llombok/Generated; setCourseId (Ljava/lang/Long;)V setStudentId $(DLjava/lang/Long;Ljava/lang/Long;)V o Ljava/lang/Object; other this$courseId other$courseId this$studentId other$studentId StackMapTable PRIME I result 	$newGrade J 	$courseId 
$studentId toString ()Ljava/lang/String; 
SourceFile GradeUpdateRequest.java BootstrapMethods [ 7GradeUpdateRequest(newGrade=, courseId=, studentId=) ]
 ^ _ ` 6 a $java/lang/invoke/StringConcatFactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; InnerClasses d %java/lang/invoke/MethodHandles$Lookup f java/lang/invoke/MethodHandles Lookup !            	 
     
     8 9  :   :     *'� �    ;        <        = >         ?      @     A    B C  :   :     *+� �    ;        <        = >      	 
  ?    	  @     A    D C  :   :     *+� �    ;        <        = >       
  ?      @     A       :   /     *� �    ;        <        = >   @     A    $ %  :   /     *� �    ;        <        = >   @     A    + %  :   /     *� �    ;        <        = >   @     A     E  :   ]     *� *'� *-� *� �    ;        <   *     = >            	 
      
  ?      	    @     A       :   /     *� �    ;       	 <        = >   @     A    (   :       x+*� �+� � �+� M,*� � �*� ,� � � �*� "N,� ":-� � � -� &� �*� ):,� ):� � � � &� ��    ;       
 <   H    x = >     x F G   c H >  4 D I G  : > J G  W ! K G  ]  L G  M   ! 
�  �   �   	 ?    F  @     A       :   9     +� �    ;       
 <        = >      H G  ?    H  @     A    2 3  :       R;<=*� � ,B;h! }!��`=*� ":;h� +� � 0`=*� ):;h� +� � 0`=�    ;       
 <   >    R = >    O N O   M P O   E Q R    2 S G  ;  T G  M   N � .    �     �      �       @     A    U V  :   <     *� *� "*� )� 4  �    ;       
 <        = >   @     A    W    X Y     \  Z b   
  c e g 