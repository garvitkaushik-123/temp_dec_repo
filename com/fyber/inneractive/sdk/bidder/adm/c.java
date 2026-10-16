package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.protobuf.d1;
import com.fyber.inneractive.sdk.protobuf.e1;

/* loaded from: classes4.dex */
public enum c implements d1 {
    OTHER(0),
    HTML(4),
    MRAID(6),
    VAST(8),
    DV360(15),
    UNRECOGNIZED(-1);

    public static final int DV360_VALUE = 15;
    public static final int HTML_VALUE = 4;
    public static final int MRAID_VALUE = 6;
    public static final int OTHER_VALUE = 0;
    public static final int VAST_VALUE = 8;
    private static final e1 internalValueMap = new e1() { // from class: com.fyber.inneractive.sdk.bidder.adm.b
        @Override // com.fyber.inneractive.sdk.protobuf.e1
        public final d1 a(int i) {
            if (i == 0) {
                return c.OTHER;
            }
            if (i == 4) {
                return c.HTML;
            }
            if (i == 6) {
                return c.MRAID;
            }
            if (i == 8) {
                return c.VAST;
            }
            if (i != 15) {
                return null;
            }
            return c.DV360;
        }
    };
    private final int value;

    c(int i) {
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
