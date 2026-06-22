# Spring Core Interview Questions (4+ Years)

## IoC and Dependency Injection

1. What is IoC (Inversion of Control)?
2. What is Dependency Injection?
3. What are the benefits of Dependency Injection?
4. What are the types of Dependency Injection?
5. Constructor Injection vs Setter Injection?
6. Why is Constructor Injection preferred?
7. Can Spring perform Dependency Injection without annotations?
8. What happens if a required dependency is not available?
9. How does Spring resolve dependencies?
10. What is dependency lookup?

---

## Spring Container

11. What is a Spring Container?
12. What is BeanFactory?
13. What is ApplicationContext?
14. Difference between BeanFactory and ApplicationContext?
15. What are the responsibilities of the Spring Container?
16. How does Spring Container create beans?
17. What happens during ApplicationContext initialization?

---

## Beans

18. What is a Spring Bean?
19. How are beans created in Spring?
20. What is bean definition?
21. What is bean wiring?
22. What are bean scopes?
23. Explain Singleton scope.
24. Explain Prototype scope.
25. Explain Request scope.
26. Explain Session scope.
27. Explain Application scope.
28. Which scope is default in Spring?
29. Is Singleton bean thread-safe?
30. Difference between Singleton and Prototype bean?

---

## Bean Lifecycle

31. Explain the Spring Bean Lifecycle.
32. What is @PostConstruct?
33. What is @PreDestroy?
34. What is InitializingBean?
35. What is DisposableBean?
36. What is init-method?
37. What is destroy-method?
38. What is BeanPostProcessor?
39. When are BeanPostProcessors executed?
40. What is BeanFactoryPostProcessor?
41. Difference between BeanPostProcessor and BeanFactoryPostProcessor?

---

## Bean Configuration

42. What is @Configuration?
43. What is @Bean?
44. Difference between @Bean and @Component?
45. What is component scanning?
46. What is @ComponentScan?
47. What packages are scanned by default?
48. What happens if a bean is not found during scanning?

---

## Stereotype Annotations

49. What is @Component?
50. What is @Service?
51. What is @Repository?
52. What is @Controller?
53. Difference between @Component and @Service?
54. Why use @Repository instead of @Component?
55. What exception translation happens in @Repository?

---

## Dependency Resolution

56. How does @Autowired work internally?
57. By default, does @Autowired inject by type or name?
58. What happens if multiple beans of the same type exist?
59. What is @Qualifier?
60. What is @Primary?
61. Difference between @Primary and @Qualifier?
62. Can @Autowired be used on constructors?
63. Can @Autowired be used on private fields?
64. What are drawbacks of field injection?

---

## Advanced Bean Concepts

65. What is @Lazy?
66. How does lazy initialization work?
67. What is eager initialization?
68. What is circular dependency?
69. How does Spring handle circular dependencies?
70. Why does constructor-based circular dependency fail?
71. What is ObjectFactory?
72. What is Provider?
73. What is scoped proxy?

---

## Profiles and Environment

74. What are Spring Profiles?
75. Why are profiles used?
76. How do you activate a profile?
77. What is @Profile?
78. How can multiple profiles be activated?
79. How does Spring determine active profiles?

---

## Spring AOP

80. What is AOP?
81. Why is AOP needed?
82. What are cross-cutting concerns?
83. What is an Aspect?
84. What is Advice?
85. Types of Advice?
86. What is a Join Point?
87. What is a Pointcut?
88. What is Weaving?
89. What is Around Advice?
90. Difference between Before and Around Advice?
91. How does Spring AOP work internally?
92. What is proxy-based AOP?
93. What is self-invocation problem in AOP?
94. Difference between Spring AOP and AspectJ?

---

## Spring Proxy Questions

95. What is a proxy?
96. What is JDK Dynamic Proxy?
97. What is CGLIB Proxy?
98. Difference between JDK Proxy and CGLIB?
99. When does Spring use JDK Proxy?
100. When does Spring use CGLIB?
101. Can final methods be proxied?
102. Can private methods be advised by Spring AOP?

---

## Spring Internals (Frequently Asked for 4+ Years)

103. How does Spring create singleton beans?
104. What is singleton cache?
105. Explain Spring's three-level cache.
106. Why does Spring use three-level cache?
107. How does Spring resolve circular dependency internally?
108. How does component scanning work internally?
109. How does Spring process annotations?
110. What happens during application startup?
111. How does Spring register beans?
112. What is DefaultListableBeanFactory?
113. What is BeanDefinition?
114. How are bean definitions loaded?

---

# Spring Web / Spring MVC Interview Questions

## Spring MVC Architecture

115. What is Spring MVC?
116. Explain Spring MVC architecture.
117. What is DispatcherServlet?
118. Why is DispatcherServlet called Front Controller?
119. Explain request flow in Spring MVC.
120. What is HandlerMapping?
121. What is HandlerAdapter?
122. What is ViewResolver?
123. What is ModelAndView?
124. What is Model?

---

## Controllers

125. What is @Controller?
126. What is @RestController?
127. Difference between @Controller and @RestController?
128. What is @ResponseBody?
129. What happens internally when a request reaches a controller?
130. How does Spring find the correct controller method?

---

## Request Handling

131. What is @RequestMapping?
132. Difference between @GetMapping and @RequestMapping?
133. What is @PostMapping?
134. What is @PutMapping?
135. What is @DeleteMapping?
136. What is @PatchMapping?
137. How are URL mappings resolved?

---

## Request Parameters

138. What is @RequestParam?
139. What is @PathVariable?
140. Difference between @RequestParam and @PathVariable?
141. What is @RequestBody?
142. What is @RequestHeader?
143. What is @CookieValue?
144. What is @ModelAttribute?
145. Difference between @RequestBody and @ModelAttribute?

---

## Response Handling

146. How does Spring convert Java objects to JSON?
147. What are HttpMessageConverters?
148. What is MappingJackson2HttpMessageConverter?
149. What is content negotiation?
150. How does Spring determine response format?
151. What is ResponseEntity?
152. Why use ResponseEntity?

---

## Validation

153. What is Bean Validation?
154. What is @Valid?
155. What is @Validated?
156. Difference between @Valid and @Validated?
157. What validation annotations are commonly used?
158. How do you create custom validation?
159. How are validation errors handled?

---

## Exception Handling

160. What is @ExceptionHandler?
161. What is @ControllerAdvice?
162. What is @RestControllerAdvice?
163. Difference between @ControllerAdvice and @ExceptionHandler?
164. How do you implement global exception handling?
165. How do you return custom error responses?

---

## Filters and Interceptors

166. What is a Servlet Filter?
167. What is a Spring Interceptor?
168. Difference between Filter and Interceptor?
169. When should Filter be used?
170. When should Interceptor be used?
171. What methods are available in HandlerInterceptor?
172. Explain preHandle().
173. Explain postHandle().
174. Explain afterCompletion().
175. How are Filters executed in request flow?
176. How are Interceptors executed in request flow?

---

## File Uploads

177. How do you upload files in Spring MVC?
178. What is MultipartFile?
179. How do you upload multiple files?
180. How do you validate uploaded files?

---

## REST API Concepts

181. What is REST?
182. REST vs SOAP?
183. What is statelessness?
184. What are HTTP methods?
185. What is idempotency?
186. Difference between PUT and PATCH?
187. Difference between POST and PUT?
188. Common HTTP status codes?
189. What is API versioning?
190. How do you implement API versioning?

---

## Web Security Related Questions

191. How do you secure REST APIs?
192. How do you implement authentication?
193. What is JWT?
194. What is OAuth2?
195. Authentication vs Authorization?
196. How do you validate JWT tokens?

---

# Frequently Asked Scenario-Based Questions

197. A bean is not getting injected. How will you troubleshoot?
198. Multiple beans of the same type exist. How will you resolve it?
199. Circular dependency issue occurs. What will you do?
200. Application startup is very slow. How will you analyze it?
201. REST API response is taking 10 seconds. How will you troubleshoot?
202. Global exception handling is not working. What could be the reason?
203. JSON response is not getting generated. What could be the issue?
204. Interceptor is not getting executed. What could be wrong?
205. Validation annotations are not working. How will you debug?
206. AOP advice is not getting triggered. Why?
207. @Transactional is not working due to self-invocation. Why?
208. A singleton bean is accessed by multiple threads. What precautions are needed?
209. Prototype bean injected into singleton bean is not creating new instances. Why?
210. How would you design a large Spring Web application with multiple modules?

These 210 questions cover almost everything commonly asked around **Spring Core and Spring Web/MVC** for developers with 4–6 years of experience. The highest-priority topics are **Bean Lifecycle, Dependency Injection, @Autowired internals, Bean Scopes, AOP Proxies, DispatcherServlet flow, Filters vs Interceptors, Exception Handling, Validation, and Spring internals (three-level cache and circular dependency resolution)**.
