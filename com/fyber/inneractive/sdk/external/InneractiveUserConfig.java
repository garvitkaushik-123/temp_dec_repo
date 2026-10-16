package com.fyber.inneractive.sdk.external;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class InneractiveUserConfig {

    /* renamed from: a, reason: collision with root package name */
    public int f1161a = -1;
    public Gender b = null;
    public String c = null;

    public enum Gender {
        MALE,
        FEMALE
    }

    public static boolean ageIsValid(int i) {
        return i >= 1 && i <= 120;
    }

    public int getAge() {
        return this.f1161a;
    }

    public Gender getGender() {
        return this.b;
    }

    @Deprecated
    public String getZipCode() {
        return this.c;
    }

    public InneractiveUserConfig setAge(int i) {
        if (ageIsValid(i)) {
            this.f1161a = i;
            return this;
        }
        IAlog.f("The Age is invalid. Please use a number between 1 and 120", new Object[0]);
        return this;
    }

    public InneractiveUserConfig setGender(Gender gender) {
        if (gender != null) {
            this.b = gender;
            return this;
        }
        IAlog.f("The gender is invalid. Please use one of the suggested InneractiveAdView.Gender", new Object[0]);
        return this;
    }

    @Deprecated
    public InneractiveUserConfig setZipCode(String str) {
        if (str == null || !Pattern.compile("(^\\d{5}$)|(^\\d{5}-\\d{4}$)").matcher(str).matches()) {
            IAlog.c("The zipcode format is invalid. Please use a valid value.", new Object[0]);
            return this;
        }
        this.c = str;
        return this;
    }
}
