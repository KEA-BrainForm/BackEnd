package kakao99.brainform.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QBrainwaveResult is a Querydsl query type for BrainwaveResult
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QBrainwaveResult extends EntityPathBase<BrainwaveResult> {

    private static final long serialVersionUID = 1376961760L;

    public static final QBrainwaveResult brainwaveResult = new QBrainwaveResult("brainwaveResult");

    public final NumberPath<Float> attAvg = createNumber("attAvg", Float.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath img = createString("img");

    public final NumberPath<Float> meditAvg = createNumber("meditAvg", Float.class);

    public QBrainwaveResult(String variable) {
        super(BrainwaveResult.class, forVariable(variable));
    }

    public QBrainwaveResult(Path<? extends BrainwaveResult> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBrainwaveResult(PathMetadata metadata) {
        super(BrainwaveResult.class, metadata);
    }

}

