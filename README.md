# HTTP API 학습을 위한 리포
spring boot를 이용해 HTTP API를 학습합니다.


시나리오 :

기존에 회원 API의 URL로 /user* 를 사용하다가

/member*로 이전한 상황

api 문서를 업데이트하고 사용자들이 그에 맞춰 개발하는 것이 맞다고 생각하지만,

이번만 예외로 기존 URL로 접속해도 redirect를 통해 서버 단에서 이를 해결해주기로 함.

주의 : CORS 정책을 열어줘야한다.