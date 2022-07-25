# 📚도서 온라인 쇼핑몰 구현 프로젝트

## [TEAM : Bossbabies]

## [Babies🍼]

| 팀원 | 천예원 | 안채영 | 최규진 | 오명주 | 이성은 | 김혜연 |
| --- | --- | --- | --- | --- | --- | --- |
| 담당 파트 | 조장, 상품 상세 페이지, 페이지 디자인 총괄 | 관리자 페이지 , AWS RDS 연동 | 로그인, 회원가입, 카카오 API 연동, 통계 알고리즘 구현 | 관리자 통계 페이지, 멤버 소개 페이지, 서버 배포 | 회원 마이 페이지, 서버 배포, ERD 구현 | 도서 API 데이터 크롤링, 메인 페이지, 공용 UI/UX 작업 |
| Github | https://github.com/jikimomo | https://github.com/hellochaeyoung | https://github.com/kjchoi1997 | https://github.com/omj9803 | https://github.com/lse99 | https://github.com/devpoooh |
| Email | jikimomo@gmail.com | cyahn0831@gmail.com | kjchoi199780@gmail.com | myeongju0316@gmail.com | nifer0@naver.com | huhu708@naver.com |

## [📆제작 과정]

|  | 2022.07.15 | 2022.07.16 | 2022.07.18 | 2022.07.19 | 2022.07.20 | 2022.07.21 | 2022.07.22 | 2022.07.23 |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| 요구사항 정의 |             O |             O |  |  |  |  |  |  |
| 기획 및 설계 |  |             O |  |  |  |  |  |  |
| 개발환경 구성 |  |             O |             O |  |  |  |  |  |
| 기능 구현 작업 |  |  |             O |             O |             O |             O |             O |  |
| 테스트 작업 |  |  |  |             O |             O |             O |             O |  |
| 문서 정리 |  |  |  |  |  |             O |             O |  |
| 배포 및 발표 |  |  |  |  |  |             O |  |             O |

# 1. MZ BOOK

![Untitled](https://user-images.githubusercontent.com/75598246/180710584-33b1086b-5ec9-4995-bdc5-aa1c5c84fd8c.png)

Spring Framework & JSP를 활용하여 온라인 도서 쇼핑몰 구현 프로젝트를 진행

# 2. 프로젝트 배경

## 2 - (1) 배경

![Untitled 1](https://user-images.githubusercontent.com/75598246/180710637-58b91fc8-a8a9-4465-a80c-5073a626af26.png)

## 2 - (2). 구조

![Untitled 2](https://user-images.githubusercontent.com/75598246/180710665-7d4b960d-c26c-4caf-b4ee-b13de903501a.png)

## 2 - (3). 기술 스택

![Untitled 3](https://user-images.githubusercontent.com/75598246/180710738-4508c0b3-e89e-406e-b45f-54fdc460e5fb.png)

# 2. 협업 방식

- **Github**
    
    [https://github.com/Lotte-BossBabies/Boss-Book-Project.git](https://github.com/Lotte-BossBabies/Boss-Book-Project.git)
    
    ![Untitled 4](https://user-images.githubusercontent.com/75598246/180710815-540043f9-da08-4a69-97a6-f7583866a677.png)
    

- **Issue**
    - Github의 Issue 기능을 활용하여 팀원 각자 맡은 파트와 기능 상세, 업무 구현 진행 정도를 파악하고 개발 과정을 기록으로 남길 수 있게 하였습니다.

![Untitled 5](https://user-images.githubusercontent.com/75598246/180710836-649a2c33-fa6d-4e9e-a579-2ef56d970169.png)

- Branch
    - 팀원별, 기능별 브랜치와 dev 브랜치를 활용하여 형상 관리를 진행했습니다.

![Untitled 6](https://user-images.githubusercontent.com/75598246/180710854-dd97a8fb-01a8-4b03-8d52-48f5ee04c49b.png)

- Notion
    - 하루에 적어도 한 번씩 스크럼 회의를 통해 작업 진행 상황과 어려운 점, 해결한 점을 팀원들과 공유하고 필요한 자료들을 노션을 통해 공유하였습니다.
    - [https://evening-gooseberry-9aa.notion.site/743d728456b64355acfd5e08d9b54869](https://www.notion.so/743d728456b64355acfd5e08d9b54869)

# 3. UI 작업

- Figma를 활용하여 요구사항 명세 및 설계 단계 진행 시 화면의 UI를 미리 작업하여 전체적인 프로젝트의 흐름을 파악하고 구현해야 할 기능을 다시 한 번 정리하였습니다.
    
    ![Untitled 7](https://user-images.githubusercontent.com/75598246/180710880-b3d06370-2219-46d8-aa3e-00a62ed2011a.png)
    

# 4. 페이지 계층 구조

![Untitled 8](https://user-images.githubusercontent.com/75598246/180710930-053802a7-7113-40b2-b71f-6596e14b18b4.png)


# 4. ERD

- ERD-CLOUD 툴을 사용하여 ERD 작업을 진행하고 팀원들과 공유 작업을 하였습니다.

![Untitled 9](https://user-images.githubusercontent.com/75598246/180710954-c402d8a7-6533-41f8-be63-61b82994f970.png)


# 5. 데이터베이스

- 데이터베이스를 공유하여 사용하기 위해서 AWS RDS - MySQL을 연동하여 사용하였습니다.
    
    ![Untitled 10](https://user-images.githubusercontent.com/75598246/180710980-529cee35-ff00-4b60-9b68-a72da57019ba.png)
    

# 7. 구현 기능

### 7 - (1) 회원가입

- 일반, 판매자 권한 회원가입 구분
    
    ![join-main](https://user-images.githubusercontent.com/75598246/180711024-6d6c81a9-7b64-4401-aadb-e116b5075c58.png)
    
- 일반 회원가입
    
    ![join-member-%EC%95%84%EC%9D%B4%EB%94%94_%EC%97%86](https://user-images.githubusercontent.com/75598246/180711161-3fd748d1-fd12-46d3-b1bd-bfcffc2798ad.png)
    
    - 아이디 중복 확인 가능
        
        ![join-member-%EC%A4%91%EB%B3%B5%EC%95%84%EC%9D%B4%EB%94%94](https://user-images.githubusercontent.com/75598246/180711236-baa61875-af30-4475-a41b-12880f7b796a.png)
        
    - 비밀번호, 이름, 이메일, 휴대폰, 주소 입력
        
        ![join-member-%EC%9E%85%EB%A0%A5%EC%99%84%EB%A3%8C](https://user-images.githubusercontent.com/75598246/180711307-e6c01396-44af-4547-85ff-6288bd889569.png)
        
    - 전체 항목 미기입시 회원가입 불가
    
- 판매자 회원가입
    
    ![join-seller-form%EB%A7%8C](https://user-images.githubusercontent.com/75598246/180711362-6155bd79-1d97-4e79-a4b3-58ce566772d3.png)
    
    - 아이디 중복 확인 가능
    - 비밀번호, 이름, 이메일, 휴대폰, 스토어 이름 입력
    - 전체 항목 미기입시 회원가입 불가

### 7 - (2) 로그인

![login](https://user-images.githubusercontent.com/75598246/180711390-3b33b982-2d6d-44a7-ba30-91a352a7f478.png)

- 로그인 전 header — 로그인/회원가입
    
    ![main_-_%EB%B3%B5%EC%82%AC%EB%B3%B8](https://user-images.githubusercontent.com/75598246/180711452-1f7c6149-e84e-4d7b-8d4e-1c478a40b2f7.png)
    
- 로그인 후 header — 로그아웃/마이페이지
    
    ![login%ED%9B%84_main](https://user-images.githubusercontent.com/75598246/180711495-a572c4e9-755d-4212-ae46-fde6dfcd6cdb.png)
    
- 아이디 저장 가능
    
    ![login-%EC%9E%85%EB%A0%A5](https://user-images.githubusercontent.com/75598246/180711567-86fc81bb-3416-4fcc-8e8c-b201750c0f45.png)

    
- 회원가입, 아이디 찾기, 비밀번호 찾기 페이지로 이동 가능
    
    <img width="1267" alt="%EC%95%84%EC%9D%B4%EB%94%94%EC%B0%BE%EA%B8%B0" src="https://user-images.githubusercontent.com/75598246/180711658-35ab1a6e-12d8-4deb-b4cf-df1fb248c554.png">
    
    <img width="1164" alt="%EB%B9%84%EB%B2%88%EC%B0%BE%EA%B8%B0" src="https://user-images.githubusercontent.com/75598246/180711765-41d66862-bac2-4e4c-8bfe-6104f34c765f.png">
    
- 카카오 로그인
    - 카카오 계정으로 로그인 후 카카오 계정의 이메일로 회원가입 진행

<img width="1151" alt="%EC%B9%B4%EC%B9%B4%EC%98%A4%EB%A1%9C%EA%B7%B8%EC%9D%B8" src="https://user-images.githubusercontent.com/75598246/180711811-cc42a5cd-8028-4139-9448-4136d4535514.png">

<img width="599" alt="%EC%B9%B4%EC%B9%B4%EC%98%A4%EB%A1%9C%EA%B7%B8%EC%9D%B8_%EB%8F%99%EC%9D%98" src="https://user-images.githubusercontent.com/75598246/180711835-b978aaf6-2917-4d7e-afe3-04297efdf4e6.png">

### 7 - (3) 메인 화면

- 인기 도서 — 판매량 순으로 정렬된 도서 확인 가능
- 작가 마켓 — 판매자가 판매 등록한 도서 확인 가능
- 배너 및 인기 도서, 작가 마켓 자동 스와이프 기능 적용

![main](https://user-images.githubusercontent.com/75598246/180711894-406e5a02-4bd5-4de1-9435-1e8c3f000d36.png)

### 7 - (4) 상품 상세 화면

![bookdetail-heart](https://user-images.githubusercontent.com/75598246/180711995-8efc5269-362f-4f94-8f2c-55040045ca3d.png)


- 판매자별 가격 할인 정보 적용
- 구매
    
    ![%EA%B5%AC%EB%A7%A4](https://user-images.githubusercontent.com/75598246/180712077-24b09769-6b7f-4e20-8450-29d7e03309c1.png)
    
    - 배송지 입력 — 주소 입력시 카카오 주소 찾기 이용
        
        ![%EC%B9%B4%EC%B9%B4%EC%98%A4%EC%A3%BC%EC%86%8C](https://user-images.githubusercontent.com/75598246/180712137-84c7e331-3fc7-4a7d-b716-0be56ada26a8.png)
        
    - 구매 완료시 주문 내역 확인 또는 계속 쇼핑 가능
        
        ![%EA%B5%AC%EB%A7%A4%EC%84%B1%EA%B3%B5](https://user-images.githubusercontent.com/75598246/180712181-83de96a2-4da6-47aa-af18-cc9572c4e96c.png)
        
    - 판매자 계정은 구매 불가
- 좋아요
    - 좋아요 클릭시 마이페이지-좋아요한 상품 탭에서 확인 가능
    - 한 번 더 클릭시 좋아요 취소

![bookdetail-yesheart](https://user-images.githubusercontent.com/75598246/180712205-0bdf533c-6c44-4c5b-a5f0-354c9857b715.png)

![bookdetail-noheart](https://user-images.githubusercontent.com/75598246/180712244-f63074c1-b44a-49f1-a92f-84d567dcfa3d.png)

- 리뷰
    - 상품별 리뷰 확인 가능
        
        ![bookdetail-review](https://user-images.githubusercontent.com/75598246/180712280-003b177d-8f73-4de1-b8f6-36f4a7873b0c.png)

        

### 7 - (5) 마이페이지(회원)

![Untitled 11](https://user-images.githubusercontent.com/75598246/180712314-d3a127e8-c789-48d7-aa32-98dddc4a9f1e.png)

- 개인정보 수정 페이지로 이동 가능
![Untitled 12](https://user-images.githubusercontent.com/75598246/180712354-0ead5036-85ee-41f2-a5cb-a9078fb5ae38.png)

- 구매한 상품
    
    ![member-mypage](https://user-images.githubusercontent.com/75598246/180712439-1edc193d-8958-4be4-b392-bbe54a9db1e2.png)
    
    - 구매한 상품 조회
    - 배송이 완료되지 않은 상품은 주문 취소 가능
    - 배송이 완료된 상품은 리뷰 작성 가능 — 리뷰 중복 작성 불가
        
        ![member-mypage-review](https://user-images.githubusercontent.com/75598246/180712489-51e7d7a4-7265-4992-9576-903624746eb1.png)
        
    
- 좋아요한 상품
    
    ![member-mypage 1](https://user-images.githubusercontent.com/75598246/180712518-64490821-7eed-4548-b48d-23cad6fb7a8a.png)
    
    - 상품 상세 페이지에서 좋아요 표시한 상품 조회
    - 좋아요 취소 가능
- 나의 리뷰
    
    ![member-mypage 2](https://user-images.githubusercontent.com/75598246/180712552-cabf252c-3444-4783-83e3-40aba7d2ac2c.png)
    
    - 내가 작성한 리뷰 조회
    - 리뷰 삭제 가능

### 7 - (6) 관리자 페이지

![Untitled 13](https://user-images.githubusercontent.com/75598246/180712587-aaccada9-d47d-4546-8f20-0c476eef615a.png)

- 개인정보 수정 가능 (스토어 이름 포함)

![Untitled 14](https://user-images.githubusercontent.com/75598246/180712605-fc55cd94-e356-4d0b-aa77-bc8613294c33.png)

- 내가 등록한 책
    - 카테고리 별, 키워드 검색 및 판매량 순으로 조회 가능
        
        ![seller-mypage-%EA%B2%80%EC%83%89](https://user-images.githubusercontent.com/75598246/180712657-a8d9ba87-20af-4565-86a8-0f35da75582c.png)
        
    - 판매 등록한 책 목록 확인 및 재고 관리 가능
        
        ![seller-mypage-%ED%8C%90%EB%A7%A4%EC%A0%95%EB%B3%B4%EC%88%98%EC%A0%95](https://user-images.githubusercontent.com/75598246/180712725-3c70c4d5-c8ae-419f-8f99-de6040db29f0.png)
        
- 실적 통계
    - 목차 `7 - (7)`
- 배송관리
    - 주문 들어온 상품 — 구매자 및 상품 표시
        
        ![seller-mypage-%EB%B0%B0%EC%86%A1%EA%B4%80%EB%A6%AC_-_%EB%B3%B5%EC%82%AC%EB%B3%B8](https://user-images.githubusercontent.com/75598246/180712794-0e6aaede-51da-4b2f-95f7-e693a49d114d.png)
        
    - 배송 완료 처리 가능 — 배송 완료 처리시, 구매자는 마이페이지에서 리뷰 작성 가능
    - 배송 완료된 상품은 기간별 조회 가능
        
        ![seller-mypage-%EB%B0%B0%EC%86%A1%EA%B4%80%EB%A6%AC](https://user-images.githubusercontent.com/75598246/180712835-418c4d28-e9fa-45ad-a47d-a0f5b78c5848.png)
        
- 상품등록
    - 판매 등록하고자 하는 책 검색 가능 — 카테고리별, 키워드별
        
        ![seller-mypage-%EC%B1%85%EB%93%B1%EB%A1%9D](https://user-images.githubusercontent.com/75598246/180712945-dee7b4e2-c856-4b0f-9113-7db584cceb95.png)
        
    - 재고량 및 할인율 설정 후 판매 등록
        
        ![seller-mypage-%EC%B1%85%EB%93%B1%EB%A1%9D2](https://user-images.githubusercontent.com/75598246/180712896-59c9aaa0-9ff3-46f7-8f26-6286826c68a8.png)
        
    - 설정한 재고량 초과 주문시 품절 처리

### 7 - (7) 실적 통계 페이지

- 상품 별 총 판매량
    - pie chart 로 표시
    - 모든 책 판매량에 대한 카테고리 비율을 그래프로 표시

![Untitled 15](https://user-images.githubusercontent.com/75598246/180712987-8d9b0737-8188-4e2d-9a03-ce21e5c13a0f.png)

- 기간 별 매출 현황
    - line chart 로 표시
    - 첫 페이지는 전체 기간에 대한 책 판매량 그래프 표시
    - 날짜 설정하면 해당 기간에 대한 판매량 그래프 표시

![Untitled 16](https://user-images.githubusercontent.com/75598246/180713014-940ded84-1cbe-4c20-8b82-ade9ece8956b.png)

### 7 - (8) 멤버 소개 페이지

- card 형식으로 멤버 소개
<img width="590" alt="%E1%84~1" src="https://user-images.githubusercontent.com/75598246/180713071-9d79fb75-d86f-46b2-9c48-50a856131717.PNG">

## 8. URL

- [https://mz-bookstore.herokuapp.com](https://mz-bookstore.herokuapp.com/)
