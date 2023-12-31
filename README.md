## Environment
- minSdkVersion : 23

- targetSdkVersion : 33

- gradle plugin : 7.3.0
  - android studio 최소 버전 : `Dolphin | 2021.3.1`

## Tech Stack

- `Compose` : 선언형 UI 구성
- `ViewModel` : 데이터 홀더로서의 역할 및 configuration change 대응
- `Coil` : 비동기 이미지 로딩
- `Coroutine, Flow` : 비동기 통신 및 반응형 프로그래밍 
- `Paging3` : 데이터 페이징 처리
- `Hilt` : Repository, Interface 등 의존성 주입
- `Room` : Favorite 트랙들을 보존하기 위해 사용
- `Retrofit, Okhttp` : 네트워크 통신

<br>

## Architecture

- `Di using  Hilt`
- `UDF using AAC ViewModel`
- `Multi-Module`
- `Clean Architecture`

| 즐겨찾기 기능 |   페이징    | 네트워크 에러 대응  |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![favortie](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/f0105f84-a478-4434-88ae-ed45449fc0ef)| ![ezgif com-video-to-gif](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/2343d934-b32a-4564-888b-f8e06a254ce7) |![ezgif com-video-to-gif](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/14128ab9-94d3-4e43-a547-1135a5a55a79)


## Bug
- 현재 Itunes API offset을 사용할 때 중복된 데이터를 내려주고 있음

참고 링크: https://stackoverflow.com/questions/44177089/itunes-search-api-page-number-for-the-query

<br>

## Edge case
- 화면 세로 모드로 고정
- 활동 유지 안함 모드에서 탭 상태 보존
- 네트워크 에러 대응
