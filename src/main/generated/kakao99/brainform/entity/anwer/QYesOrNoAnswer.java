package kakao99.brainform.entity.anwer;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QYesOrNoAnswer is a Querydsl query type for YesOrNoAnswer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QYesOrNoAnswer extends EntityPathBase<YesOrNoAnswer> {

    private static final long serialVersionUID = 1510708102L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QYesOrNoAnswer yesOrNoAnswer = new QYesOrNoAnswer("yesOrNoAnswer");

    public final BooleanPath answer = createBoolean("answer");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final kakao99.brainform.entity.QMemberSurvey memberSurvey;

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final kakao99.brainform.entity.question.QYesOrNoQuestion yesOrNoQuestion;

    public QYesOrNoAnswer(String variable) {
        this(YesOrNoAnswer.class, forVariable(variable), INITS);
    }

    public QYesOrNoAnswer(Path<? extends YesOrNoAnswer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QYesOrNoAnswer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QYesOrNoAnswer(PathMetadata metadata, PathInits inits) {
        this(YesOrNoAnswer.class, metadata, inits);
    }

    public QYesOrNoAnswer(Class<? extends YesOrNoAnswer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberSurvey = inits.isInitialized("memberSurvey") ? new kakao99.brainform.entity.QMemberSurvey(forProperty("memberSurvey"), inits.get("memberSurvey")) : null;
        this.yesOrNoQuestion = inits.isInitialized("yesOrNoQuestion") ? new kakao99.brainform.entity.question.QYesOrNoQuestion(forProperty("yesOrNoQuestion"), inits.get("yesOrNoQuestion")) : null;
    }

}

