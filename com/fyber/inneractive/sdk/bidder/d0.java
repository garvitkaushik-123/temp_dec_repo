package com.fyber.inneractive.sdk.bidder;

import com.fyber.inneractive.sdk.protobuf.d1;
import com.fyber.inneractive.sdk.protobuf.e1;

/* loaded from: classes4.dex */
public enum d0 implements d1 {
    UNSECURE(0),
    SECURE(1),
    PARTIALLYSECURE(2),
    UNRECOGNIZED(-1);

    public static final int PARTIALLYSECURE_VALUE = 2;
    public static final int SECURE_VALUE = 1;
    public static final int UNSECURE_VALUE = 0;
    private static final e1 internalValueMap = new e1() { // from class: com.fyber.inneractive.sdk.bidder.c0
        @Override // com.fyber.inneractive.sdk.protobuf.e1
        public final d1 a(int i) {
            if (i == 0) {
                return d0.UNSECURE;
            }
            if (i == 1) {
                return d0.SECURE;
            }
            if (i != 2) {
                return null;
            }
            return d0.PARTIALLYSECURE;
        }
    };
    private final int value;

    d0(int i) {
        this.value = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.d1
    public final int a() {
        if (this != UNRECOGNIZED) {
            return this.value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
