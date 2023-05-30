package kakao99.brainform.entity.anwer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultipleChoiceAnswer is a Querydsl query type for MultipleChoiceAnswer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMultipleChoiceAnswer extends EntityPathBase<MultipleChoiceAnswer> {

    private static final long serialVersionUID = 1771833074L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultipleChoiceAnswer multipleChoiceAnswer = new QMultipleChoiceAnswer("multipleChoiceAnswer");

    public final StringPath answer = createString("answer");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final kakao99.brainform.entity.QMemberSurvey memberSurvey;

    public final kakao99.brainform.entity.question.QMultipleChoiceQuestion multipleChoiceQuestion;

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public QMultipleChoiceAnswer(String variable) {
        this(MultipleChoiceAnswer.class, forVariable(variable), INITS);
    }

    public QMultipleChoiceAnswer(Path<? extends MultipleChoiceAnswer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultipleChoiceAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultipleChoiceAnswer(PathMetadata metadata, PathInits inits) {
        this(MultipleChoiceAnswer.class, metadata, inits);
    }

    public QMultipleChoiceAnswer(Class<? extends MultipleChoiceAnswer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberSurvey = inits.isInitialized("memberSurvey") ? new kakao99.brainform.entity.QMemberSurvey(forProperty("memberSurvey"), inits.get("memberSurvey")) : null;
        this.multipleChoiceQuestion = inits.isInitialized("multipleChoiceQuestion") ? new kakao99.brainform.entity.question.QMultipleChoiceQuestion(forProperty("multipleChoiceQuestion"), inits.get("multipleChoiceQuestion")) : null;
    }

}

