## 체크 리스트

[ ] JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**  
[ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.  
[ ] `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.  
[ ] [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.  
[ ] 프로그램 종료 시 `System.exit()`를 호출하지 않는다.  
[ ] 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**  
[ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.  
[ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

[ ] 3항 연산자를 쓰지 않는다.  
[ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

[ ] JUnit 5와 AssertJ를 이용하여 본인이 정리한 기능 목록이 정상 동작함을 테스트 코드로 확인한다.  
[ ] else 예약어를 쓰지 않는다.
- 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.

[ ] 도메인 로직에 단위 테스트를 구현해야 한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 분리해 구현한다.

[ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

[ ] 아래 있는 `InputView`, `OutputView` 클래스를 참고하여 입출력 클래스를 구현한다.
- 입력과 출력을 담당하는 클래스를 별도로 구현한다.
- 해당 클래스의 패키지, 클래스명, 메서드의 반환 타입과 시그니처는 자유롭게 구현할 수 있다.
  ```java
  public class InputView {
      public int readDate() {
          System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
          String input = Console.readLine();    
          // ...
      }
      // ...
  }
  ```
  ```java
  public class OutputView {
      public void printMenu() {
          System.out.println("<주문 메뉴>");
          // ...
      }
      // ...
  }
  ```
  
## 기능 요구사항 정리
### 도메인
1. 자동차
- 입력받은 **랜덤 값**에 따라 전진하거나 정지한다. (행위이자 비즈니스 로직)
- 각 자동차는 이름과 이동한 거리를 상태로 갖고 있다.

## 예외 상황 정리
### 입력
1. [ ] `,`를 기준으로 분리했을 때, 공백이 있을 경우
    - `a,b, `와 같이 입력했을 때 발생할 수 있는 예외
2. [ ] `,`를 기준으로 분리했을 때, 각 이름이 올바르지 않을 경우
    - [ ] 분리된 자동차 이름이 5자를 초과했을 때
3. [ ] 시도 횟수 입력 시, 숫자가 아닌 다른 값을 입력했을 경우

## 구현 순서
1. View 구현 및 Parser, Exception Handler를 구현한다.
    - [ ] 입력한 값에 대한 예외가 발생할 경우, 재입력을 받는지 테스트
   
