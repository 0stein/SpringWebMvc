# Spring 을 통해 매우 간단한 로그인 만들어보기.

우선 설정파일을 조금 살펴보면  
servlet-context.xml
```
<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
	<beans:property name="prefix" value="/WEB-INF/views/" />
	<beans:property name="suffix" value=".jsp" />
</beans:bean>
  
<context:component-scan base-package="com.com.commm" >
	<context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
</context:component-scan>
```
+ view resolver
  뷰 를 어떻게 찾을 것인지에 대한 규칙을 정의한다. prefix 와 suffix를 조합하여 파일을 찾는다. 위 내용에 따르면
  /WEB-INF/views/(..).jsp 파일들을 뷰로써 사용한다.
+ component-scan
  com.com.commm 패키지 를 base-package로 하여 빈들을 탐색하여 자동으로 등록해준다.  

root-context.xml
```
<bean id="dataSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
...
</bean>
