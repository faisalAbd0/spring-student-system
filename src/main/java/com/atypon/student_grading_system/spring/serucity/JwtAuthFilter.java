Êþº¾   A   java/lang/NullPointerException  &request is marked non-null but is null
     <init> (Ljava/lang/String;)V 
 'response is marked non-null but is null  *filterChain is marked non-null but is null  Authorization      'jakarta/servlet/http/HttpServletRequest 	getHeader &(Ljava/lang/String;)Ljava/lang/String;  Bearer 
      java/lang/String 
startsWith (Ljava/lang/String;)Z     ! " jakarta/servlet/FilterChain doFilter D(Ljakarta/servlet/ServletRequest;Ljakarta/servlet/ServletResponse;)V
  $ % & 	substring (I)Ljava/lang/String;	 ( ) * + , ?com/atypon/student_grading_system/spring/serucity/JwtAuthFilter 
jwtService >Lcom/atypon/student_grading_system/spring/serucity/JwtService;
 . / 0 1  <com/atypon/student_grading_system/spring/serucity/JwtService extractUsername
 3 4 5 6 7 ?org/springframework/security/core/context/SecurityContextHolder 
getContext =()Lorg/springframework/security/core/context/SecurityContext; 9 : ; < = 9org/springframework/security/core/context/SecurityContext getAuthentication 4()Lorg/springframework/security/core/Authentication;	 ( ? @ A userDetailsService BLorg/springframework/security/core/userdetails/UserDetailsService; C D E F G @org/springframework/security/core/userdetails/UserDetailsService loadUserByUsername O(Ljava/lang/String;)Lorg/springframework/security/core/userdetails/UserDetails;
 . I J K isTokenValid P(Ljava/lang/String;Lorg/springframework/security/core/userdetails/UserDetails;)Z
 . M N  isTokenExpired P Oorg/springframework/security/authentication/UsernamePasswordAuthenticationToken R S T U V 9org/springframework/security/core/userdetails/UserDetails getAuthorities ()Ljava/util/Collection;
 O X  Y =(Ljava/lang/Object;Ljava/lang/Object;Ljava/util/Collection;)V [ Horg/springframework/security/web/authentication/WebAuthenticationDetails
 Z ]  ^ ,(Ljakarta/servlet/http/HttpServletRequest;)V
 O ` a b 
setDetails (Ljava/lang/Object;)V 9 d e f setAuthentication 5(Lorg/springframework/security/core/Authentication;)V
 h i j  k 3org/springframework/web/filter/OncePerRequestFilter ()V doFilterInternal s(Ljakarta/servlet/http/HttpServletRequest;Ljakarta/servlet/http/HttpServletResponse;Ljakarta/servlet/FilterChain;)V Code LineNumberTable LocalVariableTable 	authToken QLorg/springframework/security/authentication/UsernamePasswordAuthenticationToken; userDetails ;Lorg/springframework/security/core/userdetails/UserDetails; this ALcom/atypon/student_grading_system/spring/serucity/JwtAuthFilter; request )Ljakarta/servlet/http/HttpServletRequest; response *Ljakarta/servlet/http/HttpServletResponse; filterChain Ljakarta/servlet/FilterChain; authorizationHeader Ljava/lang/String; jwt username StackMapTable 
Exceptions   jakarta/servlet/ServletException  java/io/IOException MethodParameters RuntimeInvisibleTypeAnnotations Llombok/NonNull; $RuntimeInvisibleParameterAnnotations (Lcom/atypon/student_grading_system/spring/serucity/JwtService;Lorg/springframework/security/core/userdetails/UserDetailsService;)V RuntimeInvisibleAnnotations Llombok/Generated; 
SourceFile JwtAuthFilter.java RuntimeVisibleAnnotations *Lorg/springframework/stereotype/Component; ! ( h     + ,    @ A     l m  n  ©  	   Ê+Ç » Y· ¿,Ç » Y	· ¿-Ç » Y· ¿+¹  :Æ ¶  -+,¹  ±¶ #:*´ '¶ -:Æ g¸ 2¹ 8 Ç \*´ >¹ B :*´ '¶ H 9*´ '¶ L -» OY¹ Q · W:» ZY+· \¶ _¸ 2¹ c -+,¹  ±    o   J         *   4 " C # K $ L ' U ( ` ) p * } +  ,   0 ª 2 · 5 Á 9 É = p   \ 	 ª  q r  } L s t    Ê u v     Ê w x    Ê y z    Ê { |  4  } ~  U u  ~  ` j  ~      ü  þ t   Rú             w   y   {                                         n   M     *· g*+µ '*,µ >±    o        p         u v      + ,     @ A     	 +  @                       