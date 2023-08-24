## Tech Stack

- Compose : 선언형 UI 구성
- ViewModel : 데이터 홀더로서의 역할 및 configuration change 대응
- Coil : 비동기 이미지 로딩
- Coroutine, Flow : 비동기 통신 및 반응형 프로그래밍 
- Paging3 : 데이터 페이징 처리
- Hilt : Repository, Interface 등 의존성 주입
- Room : Favorite 트랙들을 보존하기 위해 사용
- Retrofit, Okhttp : 네트워크 통신

## Architecture

- Di using  Hilt
- UDF using AAC ViewModel 
- Multi-Module
- Clean Architecture

| 즐겨찾기 기능 |   페이징    | 네트워크 에러 대응  |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![ezgif com-video-to-gif](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/9eca9adb-eaca-4ef1-aeaf-db308ba7ea7f) | ![ezgif com-video-to-gif (1)](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/eb47a1d1-e00f-4861-a8a7-59c37770885a) | ![ezgif com-video-to-gif (1)](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/e18027c3-d7c2-4140-8ee0-ebbd2850a7d2)
 

## Issue Tracking

<b>페이징 데이터가 중복되어 내려오는 현상 해결<b>

발생 경로 : LazyColumn에 key 속성을 적용하여, 아이템 추가/삭제에 대한 리컴포지션을 개선하기 위해 key 속성을 trackId로 지정하였으나, unique key가 중복되었다는 에러 발견

해결 과정
1. PagingSource의 load 메서드를 디버깅 하여, 초기 60개의 페이지, 이후 20개의 페이지가 의도한 대로 내려오는 지 확인하고, 정상적으로 내려옴을 확인
2. API에서 내려주는 데이터에 문제가 있다고 판단, Postman을 활용하여 limit과 offset을 바꿔보면서 호출함
3. 일반적으로 offset 의 경우, 다음 offset은 limit을 더한 offset+limit 이어야 하는데, 그렇지 않음을 확인

결과 : 과제에서 사용하는 API는 offset을 page의 개념처럼 사용하고 있음을 알아내었고, page의 개념으로 paging을 적용하고 unique key 중복 문제를 해결
