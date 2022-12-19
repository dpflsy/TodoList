# TodoList
**스프링부트 투두리스트 연습**
+ Project : Gradle-Groovy
+ Language : Java
+ Spring Boot : 2.7.6
+ Java : 11
+ Package
  + Lombok
  + Spring Web Framework
  + MyBatis
+ **특이사항**
  + 주로 인터페이스로 구현되는 서비스 영역을 그냥 클래스 하나로 구현함
  + MyBatis를 이용해 SQL Mapper형태로 구현
  + 데이터 수정시 @PutMapping이 아닌 **@PatchMapping**을 사용하였음
    + PutMapping의 경우 수정하려는 컬럼을 제외한 나머지는 NULL로 전달되기 때문에
    + 일부 데이터만 수정할 경우 @PatchMapping을 사용하는 것이 좋다
  
+ **구성**
  + **Presentation Layer**
    + Client로부터 요청 받아 Application Layer에 처리를 위임
    + Application의 결과를 최종 Client로 전달
      + Client 종류에는 view(@Controller, html 파일)
                      data(@RestController, 문자열/Json/xml) 로 나뉜다.
    + 대표 어노테이션
      + @Controller : 요청을 받아 처리하고 view로 응답 (html 파일)
      + @RestController : 요청을 받아 처리하고 data로 응답 (문자열/JSON/XML)
      + @RequestMapping : 특정 Request를 처리하는 메소드를 지정, 클래스 또는 메소드 상단에 명시한다.
      
  + **Application Layer**
    + 특정 목적 위한 다양한 비즈니스 로직을 처리
    + 시스템의 핵심 비즈니스 로직을 구현하는 계층
    + view의 종류나 Database종류에 영향을 받지 않는 독립적인 계층이며 또한 그에 맞춰 설계해야한다.
    + 대표 어노테이션 : @Service
      + 파라미터로 전달된 데이터들의 검증 작업을 수행
      + Repository 계층을 활용하여 Database에 접근하며 Service계층의 단일 메소드가 트랜잭션 단위가 됨
      + 어플리케이션의 세부영역(User, Post...)별로 클래스를 생성하여 구현한다.
      + 주로 인터페이스로 구현 (다형성을 활용하여 기능확장을 하지 않을 경우에는 인터페이스로 구현하지 않음, 해당 프로젝트는 클래스로 구현함) 
     
  + **Data Access Layer**
    + DB에 접근하여 데이터를 조회하거나 저장하는 역할
    + Service와 Database사이의 추상화된 계층
    + DB 기술이 변경되면 해당 레이어의 코드는 변경되며 Service는 변경되지 않음
    + 대표 어노테이션 : @Repository
    + 데이터를 접근하기 위한 기술
      + JDBC (Java Database Connectivity)
        + DB에 접근하기 위한 JAVA 표준 API
      + JDBC Template
        + JDBC를 효율적으로 사용하기 위한 Spring API
      + SQL Mapper
        + SQL과 JAVA를 매핑하는 기술
        + SQL의 input 또는 output을 JAVA 객체와 매핑
        + 예) MyBatis
        + 해당 프로젝트는 SQL Mapper를 사용
      + ORM (Object Relational Mapping)
        + RDBMS의 테이블과 JAVA객체를 매핑하는 기술
        + ORM Framework이 객체와 테이블을 매핑하는 역할을 수행
        + ORM Framework이 SQL을 자동으로 실행
        + 예) hibernate, Spring Data...
        
        
        
        
    
  
