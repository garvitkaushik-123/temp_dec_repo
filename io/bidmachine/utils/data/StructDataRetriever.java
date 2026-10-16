package io.bidmachine.utils.data;

import com.explorestack.protobuf.Struct;
import io.bidmachine.utils.ProtoUtils;

/* loaded from: classes8.dex */
public class StructDataRetriever extends MapDataRetriever<String> {
    public void setStruct(Struct struct) {
        setParams(ProtoUtils.toMapOrNull(struct));
    }
}
