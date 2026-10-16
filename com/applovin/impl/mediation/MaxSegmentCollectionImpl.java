package com.applovin.impl.mediation;

import com.applovin.mediation.MaxSegment;
import com.applovin.mediation.MaxSegmentCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class MaxSegmentCollectionImpl extends MaxSegmentCollection {

    /* renamed from: a, reason: collision with root package name */
    private final List f558a;
    private final Map b;

    public static class BuilderImpl implements MaxSegmentCollection.Builder {

        /* renamed from: a, reason: collision with root package name */
        private final List f559a = new ArrayList();

        @Override // com.applovin.mediation.MaxSegmentCollection.Builder
        public MaxSegmentCollection.Builder addSegment(MaxSegment maxSegment) {
            this.f559a.add(maxSegment);
            return this;
        }

        @Override // com.applovin.mediation.MaxSegmentCollection.Builder
        public MaxSegmentCollection build() {
            return new MaxSegmentCollectionImpl(this);
        }
    }

    public Map<String, List<Integer>> getJsonData() {
        return this.b;
    }

    @Override // com.applovin.mediation.MaxSegmentCollection
    public List<MaxSegment> getSegments() {
        return this.f558a;
    }

    public String toString() {
        return "MaxSegmentColletionImpl{segments=" + this.f558a + "}";
    }

    private MaxSegmentCollectionImpl(BuilderImpl builderImpl) {
        List<MaxSegment> list = builderImpl.f559a;
        this.f558a = list;
        this.b = new HashMap();
        for (MaxSegment maxSegment : list) {
            this.b.put("segment_" + maxSegment.getKey(), maxSegment.getValues());
        }
    }
}
