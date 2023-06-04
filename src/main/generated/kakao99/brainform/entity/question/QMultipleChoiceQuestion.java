package kakao99.brainform.entity.question;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMultipleChoiceQuestion is a Querydsl query type for MultipleChoiceQuestion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMultipleChoiceQuestion extends EntityPathBase<MultipleChoiceQuestion> {

    private static final long serialVersionUID = 1363396371L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMultipleChoiceQuestion multipleChoiceQuestion = new QMultipleChoiceQuestion("multipleChoiceQuestion");

    public final StringPath choice1 = createString("choice1");

    public final StringPath choice2 = createString("choice2");

    public final StringPath choice3 = createString("choice3");

    public final StringPath choice4 = createString("choice4");

    public final StringPath choice5 = createString("choice5");

    public final NumberPath<Integer> count = createNumber("count", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<kakao99.brainform.entity.anwer.MultipleChoiceAnswer, kakao99.brainform.entity.anwer.QMultipleChoiceAnswer> multipleChoiceAnswers = this.<kakao99.brainform.entity.anwer.MultipleChoiceAnswer, kakao99.brainform.entity.anwer.QMultipleChoiceAnswer>createList("multipleChoiceAnswers", kakao99.brainform.entity.anwer.MultipleChoiceAnswer.class, kakao99.brainform.entity.anwer.QMultipleChoiceAnswer.class, PathInits.DIRECT2);

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final kakao99.brainform.entity.QSurvey survey;

    public final StringPath title = createString("title");

    public QMultipleChoiceQuestion(String variable) {
        this(MultipleChoiceQuestion.class, forVariable(variable), INITS);
    }

    public QMultipleChoiceQuestion(Path<? extends MultipleChoiceQuestion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMultipleChoiceQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMultipleChoiceQuestion(PathMetadata metadata, PathInits inits) {
        this(MultipleChoiceQuestion.class, metadata, inits);
    }

    public QMultipleChoiceQuestion(Class<? extends MultipleChoiceQuestion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.survey = inits.isInitialized("survey") ? new kakao99.brainform.entity.QSurvey(forProperty("survey"), inits.get("survey")) : null;
    }

}

