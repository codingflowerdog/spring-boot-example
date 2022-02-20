# 스프링부트 예제

스프링부트로 프로젝트를 진행함에 있어 참고할 수 있도록 예제를 작성했습니다.
프로젝트 진행시 도움이 될 수 있도록 지속해서 개선해 나갈 예정입니다.

## 스펙

----
- Language
  - AWS corretto 11
- Framework
  - Spring boot 2.6.1
- Database
  - MySQL 5.7
  - QueryDSL
  - JPA
- CI/CD
  - Github Action
  - AWS ECR

## 구조

---
- annotation : 커스텀 어노테이션
- aspect : AOP 로직
- component : 컨트롤러에 의존하지 않는 컴포넌트
- controller : 라우트 컨트롤러
- data
  - dto
    - request : 리퀘스트 DTO
    - response : 리스폰스 DTO
  - entity : JPA entity
  - enums : enum
  - mapper : DTO 및 entity 맵퍼
- exception : 전역 예외 처리
- interceptor : 인터셉터 처리
- repository : JPA repository
- service : 비즈니스 메인 로직
- utils : 유틸리티

## 실행

---

```shell
docker build -t spring-boot-example .
docker run -it -d -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" --name spring-boot-example spring-boot-example
```