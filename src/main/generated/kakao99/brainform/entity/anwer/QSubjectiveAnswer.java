package kakao99.brainform.entity.anwer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubjectiveAnswer is a Querydsl query type for SubjectiveAnswer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubjectiveAnswer extends EntityPathBase<SubjectiveAnswer> {

    private static final long serialVersionUID = -416116595L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubjectiveAnswer subjectiveAnswer = new QSubjectiveAnswer("subjectiveAnswer");

    public final StringPath answer = createString("answer");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final kakao99.brainform.entity.QMemberSurvey memberSurvey;

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final kakao99.brainform.entity.question.QSubjectiveQuestion subjectiveQuestion;

    public QSubjectiveAnswer(String variable) {
        this(SubjectiveAnswer.class, forVariable(variable), INITS);
    }

    public QSubjectiveAnswer(Path<? extends SubjectiveAnswer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubjectiveAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubjectiveAnswer(PathMetadata metadata, PathInits inits) {
        this(SubjectiveAnswer.class, metadata, inits);
    }

    public QSubjectiveAnswer(Class<? extends SubjectiveAnswer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberSurvey = inits.isInitialized("memberSurvey") ? new kakao99.brainform.entity.QMemberSurvey(forProperty("memberSurvey"), inits.get("memberSurvey")) : null;
        this.subjectiveQuestion = inits.isInitialized("subjectiveQuestion") ? new kakao99.brainform.entity.question.QSubjectiveQuestion(forProperty("subjectiveQuestion"), inits.get("subjectiveQuestion")) : null;
    }

}

