package kakao99.brainform.entity.question;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QYesOrNoQuestion is a Querydsl query type for YesOrNoQuestion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QYesOrNoQuestion extends EntityPathBase<YesOrNoQuestion> {

    private static final long serialVersionUID = 501822165L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QYesOrNoQuestion yesOrNoQuestion = new QYesOrNoQuestion("yesOrNoQuestion");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> num = createNumber("num", Integer.class);

    public final kakao99.brainform.entity.QSurvey survey;

    public final StringPath title = createString("title");

    public final ListPath<kakao99.brainform.entity.anwer.YesOrNoAnswer, kakao99.brainform.entity.anwer.QYesOrNoAnswer> yesOrNoAnswer = this.<kakao99.brainform.entity.anwer.YesOrNoAnswer, kakao99.brainform.entity.anwer.QYesOrNoAnswer>createList("yesOrNoAnswer", kakao99.brainform.entity.anwer.YesOrNoAnswer.class, kakao99.brainform.entity.anwer.QYesOrNoAnswer.class, PathInits.DIRECT2);

    public QYesOrNoQuestion(String variable) {
        this(YesOrNoQuestion.class, forVariable(variable), INITS);
    }

    public QYesOrNoQuestion(Path<? extends YesOrNoQuestion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QYesOrNoQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QYesOrNoQuestion(PathMetadata metadata, PathInits inits) {
        this(YesOrNoQuestion.class, metadata, inits);
    }

    public QYesOrNoQuestion(Class<? extends YesOrNoQuestion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.survey = inits.isInitialized("survey") ? new kakao99.brainform.entity.QSurvey(forProperty("survey"), inits.get("survey")) : null;
    }

}

