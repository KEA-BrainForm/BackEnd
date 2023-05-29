package kakao99.brainform.entity.question;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubjectiveQuestion is a Querydsl query type for SubjectiveQuestion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubjectiveQuestion extends EntityPathBase<SubjectiveQuestion> {

    private static final long serialVersionUID = 1045412462L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubjectiveQuestion subjectiveQuestion = new QSubjectiveQuestion("subjectiveQuestion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final StringPath question = createString("question");

    public final ListPath<kakao99.brainform.entity.anwer.SubjectiveAnswer, kakao99.brainform.entity.anwer.QSubjectiveAnswer> subjectiveAnswers = this.<kakao99.brainform.entity.anwer.SubjectiveAnswer, kakao99.brainform.entity.anwer.QSubjectiveAnswer>createList("subjectiveAnswers", kakao99.brainform.entity.anwer.SubjectiveAnswer.class, kakao99.brainform.entity.anwer.QSubjectiveAnswer.class, PathInits.DIRECT2);

    public final kakao99.brainform.entity.QSurvey survey;

    public QSubjectiveQuestion(String variable) {
        this(SubjectiveQuestion.class, forVariable(variable), INITS);
    }

    public QSubjectiveQuestion(Path<? extends SubjectiveQuestion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubjectiveQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubjectiveQuestion(PathMetadata metadata, PathInits inits) {
        this(SubjectiveQuestion.class, metadata, inits);
    }

    public QSubjectiveQuestion(Class<? extends SubjectiveQuestion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.survey = inits.isInitialized("survey") ? new kakao99.brainform.entity.QSurvey(forProperty("survey"), inits.get("survey")) : null;
    }

}

