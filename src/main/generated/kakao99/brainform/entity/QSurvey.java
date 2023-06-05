package kakao99.brainform.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSurvey is a Querydsl query type for Survey
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSurvey extends EntityPathBase<Survey> {

    private static final long serialVersionUID = -119883802L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSurvey survey = new QSurvey("survey");

    public final DateTimePath<java.util.Date> answerPeriod = createDateTime("answerPeriod", java.util.Date.class);

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath isBrainwave = createString("isBrainwave");

    public final StringPath isOpen = createString("isOpen");

    public final QMember member;

    public final ListPath<MemberSurvey, QMemberSurvey> memberSurveys = this.<MemberSurvey, QMemberSurvey>createList("memberSurveys", MemberSurvey.class, QMemberSurvey.class, PathInits.DIRECT2);

    public final ListPath<kakao99.brainform.entity.question.MultipleChoiceQuestion, kakao99.brainform.entity.question.QMultipleChoiceQuestion> multipleChoiceQuestions = this.<kakao99.brainform.entity.question.MultipleChoiceQuestion, kakao99.brainform.entity.question.QMultipleChoiceQuestion>createList("multipleChoiceQuestions", kakao99.brainform.entity.question.MultipleChoiceQuestion.class, kakao99.brainform.entity.question.QMultipleChoiceQuestion.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> startDate = createDateTime("startDate", java.util.Date.class);

    public final ListPath<kakao99.brainform.entity.question.SubjectiveQuestion, kakao99.brainform.entity.question.QSubjectiveQuestion> subjectiveQuestions = this.<kakao99.brainform.entity.question.SubjectiveQuestion, kakao99.brainform.entity.question.QSubjectiveQuestion>createList("subjectiveQuestions", kakao99.brainform.entity.question.SubjectiveQuestion.class, kakao99.brainform.entity.question.QSubjectiveQuestion.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public final ListPath<kakao99.brainform.entity.question.YesOrNoQuestion, kakao99.brainform.entity.question.QYesOrNoQuestion> yesOrNoQuestions = this.<kakao99.brainform.entity.question.YesOrNoQuestion, kakao99.brainform.entity.question.QYesOrNoQuestion>createList("yesOrNoQuestions", kakao99.brainform.entity.question.YesOrNoQuestion.class, kakao99.brainform.entity.question.QYesOrNoQuestion.class, PathInits.DIRECT2);

    public QSurvey(String variable) {
        this(Survey.class, forVariable(variable), INITS);
    }

    public QSurvey(Path<? extends Survey> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSurvey(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSurvey(PathMetadata metadata, PathInits inits) {
        this(Survey.class, metadata, inits);
    }

    public QSurvey(Class<? extends Survey> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

