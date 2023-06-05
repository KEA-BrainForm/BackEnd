package kakao99.brainform.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QBrainwaveResult is a Querydsl query type for BrainwaveResult
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBrainwaveResult extends EntityPathBase<BrainwaveResult> {

    private static final long serialVersionUID = 1376961760L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QBrainwaveResult brainwaveResult = new QBrainwaveResult("brainwaveResult");

    public final NumberPath<Float> attAvg = createNumber("attAvg", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath img = createString("img");

    public final NumberPath<Float> meditAvg = createNumber("meditAvg", Float.class);

    public final QMemberSurvey memberSurvey;

    public QBrainwaveResult(String variable) {
        this(BrainwaveResult.class, forVariable(variable), INITS);
    }

    public QBrainwaveResult(Path<? extends BrainwaveResult> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QBrainwaveResult(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QBrainwaveResult(PathMetadata metadata, PathInits inits) {
        this(BrainwaveResult.class, metadata, inits);
    }

    public QBrainwaveResult(Class<? extends BrainwaveResult> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.memberSurvey = inits.isInitialized("memberSurvey") ? new QMemberSurvey(forProperty("memberSurvey"), inits.get("memberSurvey")) : null;
    }

}

