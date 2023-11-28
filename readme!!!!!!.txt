build.gradle 파일 내용추가
//websocket, //view

config 폴더 및 파일 추가

controller에 chatRoomController,MessageController 추가

jpa에 chatMessage,ChatRoom 추가 (model역할인데 일단 jpa에 넣었습니다)

service에 chatService 추가

resource폴더에 templates.chat 추가 (html 파일입니다. 
웹브라우저에 http://localhost:40045/chat/room 로 들어가시면 기능 테스트 가능)