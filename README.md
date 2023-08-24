## Environment
minSdkVersion : 23

targetSdkVersion : 33

gradle plugin : 7.3.0
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

## Architecture



- `Di using  Hilt`
- `UDF using AAC ViewModel`
- `Multi-Module`
- `Clean Architecture`

| 즐겨찾기 기능 |   페이징    | 네트워크 에러 대응  |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| ![favortie](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/f0105f84-a478-4434-88ae-ed45449fc0ef)| ![ezgif com-video-to-gif](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/2343d934-b32a-4564-888b-f8e06a254ce7) | ![ezgif com-video-to-gif (1)](https://github.com/EvergreenTree97/itunes-tracklist/assets/70064912/1a94f94a-3782-46ab-838b-3e5f2701c2d3)

## Edge case
- 화면 세로 모드로 고정
- 활동 유지 안함 모드에서 탭 상태 보존
- 네트워크 에러 대응
