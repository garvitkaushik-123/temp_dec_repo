package com.applovin.sdk;

/* loaded from: classes2.dex */
public interface AppLovinCmpError {

    public enum Code {
        UNSPECIFIED(-1),
        INTEGRATION_ERROR(1),
        FORM_UNAVAILABLE(2),
        FORM_NOT_REQUIRED(3);


        /* renamed from: a, reason: collision with root package name */
        private final int f845a;

        Code(int i) {
            this.f845a = i;
        }

        public int getValue() {
            return this.f845a;
        }
    }

    int getCmpCode();

    String getCmpMessage();

    Code getCode();

    String getMessage();
}
