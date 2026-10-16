package com.explorestack.protobuf;

/* loaded from: classes3.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = new MutabilityOracle() { // from class: com.explorestack.protobuf.MutabilityOracle.1
        @Override // com.explorestack.protobuf.MutabilityOracle
        public void ensureMutable() {
            throw new UnsupportedOperationException();
        }
    };

    void ensureMutable();
}
