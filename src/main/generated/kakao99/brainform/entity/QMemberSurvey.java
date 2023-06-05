package kakao99.brainform.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMemberSurvey is a Querydsl query type for MemberSurvey
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberSurvey extends EntityPathBase<MemberSurvey> {

    private static final long serialVersionUID = -749815264L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMemberSurvey memberSurvey = new QMemberSurvey("memberSurvey");

    public final QBrainwaveResult brainwaveResult;

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QMember member;

    public final ListPath<kakao99.brainform.entity.anwer.MultipleChoiceAnswer, kakao99.brainform.entity.anwer.QMultipleChoiceAnswer> multipleChoiceAnswers = this.<kakao99.brainform.entity.anwer.MultipleChoiceAnswer, kakao99.brainform.entity.anwer.QMultipleChoiceAnswer>createList("multipleChoiceAnswers", kakao99.brainform.entity.anwer.MultipleChoiceAnswer.class, kakao99.brainform.entity.anwer.QMultipleChoiceAnswer.class, PathInits.DIRECT2);

    public final ListPath<kakao99.brainform.entity.anwer.SubjectiveAnswer, kakao99.brainform.entity.anwer.QSubjectiveAnswer> subjectiveAnswers = this.<kakao99.brainform.entity.anwer.SubjectiveAnswer, kakao99.brainform.entity.anwer.QSubjectiveAnswer>createList("subjectiveAnswers", kakao99.brainform.entity.anwer.SubjectiveAnswer.class, kakao99.brainform.entity.anwer.QSubjectiveAnswer.class, PathInits.DIRECT2);

    public final QSurvey survey;

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public final ListPath<kakao99.brainform.entity.anwer.YesOrNoAnswer, kakao99.brainform.entity.anwer.QYesOrNoAnswer> yesOrNoAnswers = this.<kakao99.brainform.entity.anwer.YesOrNoAnswer, kakao99.brainform.entity.anwer.QYesOrNoAnswer>createList("yesOrNoAnswers", kakao99.brainform.entity.anwer.YesOrNoAnswer.class, kakao99.brainform.entity.anwer.QYesOrNoAnswer.class, PathInits.DIRECT2);

    public QMemberSurvey(String variable) {
        this(MemberSurvey.class, forVariable(variable), INITS);
    }

    public QMemberSurvey(Path<? extends MemberSurvey> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMemberSurvey(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMemberSurvey(PathMetadata metadata, PathInits inits) {
        this(MemberSurvey.class, metadata, inits);
    }

    public QMemberSurvey(Class<? extends MemberSurvey> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.brainwaveResult = inits.isInitialized("brainwaveResult") ? new QBrainwaveResult(forProperty("brainwaveResult")) : null;
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.survey = inits.isInitialized("survey") ? new QSurvey(forProperty("survey"), inits.get("survey")) : null;
    }

}

