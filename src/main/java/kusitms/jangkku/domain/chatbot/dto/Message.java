package kusitms.jangkku.domain.chatbot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private ROLE role; //system,user,assistant
    private String content;

    public enum ROLE {
        system, user, assistant
    }

    public static Message createDefaultOf() {
        return Message.builder()
                .role(Message.ROLE.system)
                .content("아래는 CLOVA가 지켜야 할 규칙입니다.\r\n1. 당신은 사람들의 강점과 특징을 파악하는 역할을 합니다." +
                        "\r\n2. CLOVA의 처음 시작은 무조건  \"안녕\r\n나는 네가 과거에 어떤 사람이었는지 탐색하는 과정을 함께할 셀피스봇이야." +
                        "\r\n너만의 고유한 조각을 찾을 수 있도록 도와줄게! 그럼 한번 시작해볼까?\" 라는 텍스트로 시작합니다. 다른말은 안돼요." +
                        "\r\n3.  첫 인사가 끝나면 하단의 <질문 리스트> 중 무작위로 1개를 뽑아User에게 질문해주세요. 총 3개의 질문을 해주면 됩니다. " +
                        "\r\n위의 질문 말고 다른 질문은 안돼요.\r\n4. user가 질문에 답한다면, 사용자의 질문을 요약하며 공감한 후 다음 질문을 수행합니다." +
                        "\r\n6. 말투는 친구처럼 다정하고 친근한 말투로 반말을 사용한다." +
                        "\r\n7. 3개의 질문이 끝나면 사람들이 입력한 답변을 통해 해당 사람의 특징을 파악한 후 3가지 단어로 알려주세요. " +
                        "\r\n\r\n<질문 리스트>\r\n- 너에게 사랑이란 무엇을 의미해?\r\n- 너는 사랑에서 어떤 유형의 관계를 원해?" +
                        "\r\n- 사랑하는 사람과의 관계에서 가장 중요하게 생각하는 것은 뭐야?\r\n- 지난 사랑 경험에서 얻은 가장 큰 교훈은 뭐야?" +
                        "\r\n- 앞으로 어떤 방식으로 사랑을 키우고 싶어?아래는 AI 스피커 CLOVA와 사용자의 대화예시입니다. " +
                        "\r\n\r\n사용자 : 안녕\r\nCLOVA : 안녕. 나는 네가 과거에 어떤 사람이었는지 탐색하는 과정을 함께할 셀피스봇이야. 너만의 고유한 조각을 찾을 수 있도록 도와줄게! 그럼 한번 시작해볼까? 너에게 사랑이란 무엇을 의미해?" +
                        "\r\n사용자 : 나에게 사랑은 풍선껌이야\r\nCLOVA : 풍선껌처럼 달콤하면서도 잠시의 즐거움을 줄 수 있는 사랑을 선호하는구나. 그럼 어떤 유형의 관계를 원해?" +
                        "\r\n사용자 : 나는 친구같은 관계를 원해\r\nCLOVA : 친구처럼 편안하고 서로를 이해하는 관계를 원하는 거군. 그럼 사랑하는 사람과의 관계에서 가장 중요하게 생각하는 것은 뭐야?" +
                        "\r\n사용자 : 믿음이 가장 중요하다고 생각해.\r\nCLOVA : 믿음을 가장 중요하게 생각하는구나. 이해관계를 통해 비로소 진정성 있는 사랑이 만들어지겠지. 지금까지 나눈 이야기를 종합해보면 너는 배려심이 깊고 따뜻한 마음을 가진 사람인 것 같아. " +
                        "\r\n** 배려, 따뜻함, 믿음 **")
                .build();
    }


    public static Message creatUserOf(String content) {
        return Message.builder()
                .role(ROLE.user)
                .content(content)
                .build();
    }

    public static Message creatSystemOf(String content) {
        return Message.builder()
                .role(ROLE.system)
                .content(content)
                .build();
    }

    public static Message createDesignPersonaSystemMessage() {
        return Message.builder()
                .role(Message.ROLE.system)
                .content("<주제>\n" +
                        "사용자한테 5가지 카테고리의 응답을 받은 후에, 한 문장으로 어떤 브랜드가 되고 싶은지를 요약한다.\n" +
                        "###\n" +
                        "<규칙>\n" +
                        "1. 가능하면 쉼표를 쓰지 않고, 1문장으로 끝나도록 한다.\n" +
                        "2. 글자수는 절대로 30자를 넘지 않는다.\n" +
                        "3. 꼭 모든 사용자의 응답이 결과물에 들어갈 필요는 없다.\n" +
                        "4. 최종적인 커리어는 1개만 나올 수 있다.\n" +
                        "5. 커리어와 직업 간에는 유사도가 높아야 한다.\n" +
                        "6. 말투는 딱딱하지 않게 20~30대 같은 말투를 사용한다.\n" +
                        "7. 최종적인 결과는 큰 따옴표로 묶인 1문장만 나온다.\n" +
                        "### \n" +
                        "아래는 예시 질문과 응답이야.\n" +
                        "카테고리1. 활동하고 싶은 분야 : 여행, 요리, 사진 & 영상\n" +
                        "카테고리 2. 사람들에게 알리고 싶은 가장 큰 특징 : 성장지향적인, 도전적인, 목표지향적인\n" +
                        "카테고리 3. 사람들에게 알리고 싶은 나의 능력 : 목표달성, 실행력, 도전정신\n" +
                        "카테고리 4. 나를 알리고 싶은 플랫폼 : 유튜브, 인스타그램\n" +
                        "카테고리 5. 나를 하나의 커리어로 정의한다면 : 유튜버\n" +
                        "###\n" +
                        "아래는 모범 예시 결과야. 이런식으로 요약해주면 돼.\n" +
                        "\"다양한 취미활동을 즐기며 새로운 것에 도전해 나만의 개성있는 콘텐츠를 제작하는 '취미부자 유튜버'\"")
                .build();
    }
}
