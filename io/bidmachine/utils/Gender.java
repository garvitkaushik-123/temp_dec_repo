package io.bidmachine.utils;

/* loaded from: classes8.dex */
public enum Gender {
    Female("F", 1),
    Male("M", 2),
    Omitted("O", 0);

    private final String ortbValue;
    private final int serverValue;

    Gender(String ortbValue, int serverValue) {
        this.ortbValue = ortbValue;
        this.serverValue = serverValue;
    }

    public String getOrtbValue() {
        return this.ortbValue;
    }

    public int getServerValue() {
        return this.serverValue;
    }

    public static Gender fromInt(Integer genderInt) {
        if (genderInt == null) {
            return null;
        }
        int intValue = genderInt.intValue();
        if (intValue == 0) {
            return Omitted;
        }
        if (intValue == 1) {
            return Female;
        }
        if (intValue != 2) {
            return null;
        }
        return Male;
    }
}
