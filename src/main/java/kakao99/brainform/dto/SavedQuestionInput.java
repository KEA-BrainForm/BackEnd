package kakao99.brainform.dto;

import lombok.Data;

import java.util.List;
@Data
public class SavedQuestionInput {
    private Long id;

    private int num;
    private String title;


    private String type;
    private List<Object> options;


}
