package kakao99.brainform.repository;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import kakao99.brainform.dto.FilterDTO;
import kakao99.brainform.dto.SurveyDTO;
import kakao99.brainform.dto.SurveyFilterResultDTO;
import kakao99.brainform.entity.MemberSurvey;
import kakao99.brainform.entity.Survey;
import kakao99.brainform.entity.question.MultipleChoiceQuestion;
import kakao99.brainform.service.MemberSurveyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
class MemberSurveyRepositoryTest {

    @Autowired
    private MemberSurveyService surveyService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void  통계_필터_성별_querydsl() throws Exception {

        //given

        List<String> genders = new ArrayList<>();
        //genders.add("female");

        List<String> ages = new ArrayList<>();
        ages.add("20대");

        List<String> jobs = new ArrayList<>();
        //jobs.add("student");


        FilterDTO dto = new FilterDTO(1L,genders, ages, jobs);

        //when
        Survey dataWithFilter = surveyService.getDataWithFilter(dto);

        //then
        String s = mapper.writeValueAsString(dataWithFilter);
        System.out.println(s);
    }

}