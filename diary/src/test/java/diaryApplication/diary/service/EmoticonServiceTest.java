package diaryApplication.diary.service;

import diaryApplication.diary.domain.emoticon.EmoticonDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmoticonServiceTest {

    @Autowired
    EmoticonService emoticonService;

    @Test
    @Transactional
    void register() {
        EmoticonDto emoticonDto = new EmoticonDto("potato",1,"angry");
        emoticonService.register(emoticonDto);
    }
}