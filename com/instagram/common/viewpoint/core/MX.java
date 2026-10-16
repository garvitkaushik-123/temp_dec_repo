package com.instagram.common.viewpoint.core;

import android.net.Uri;

/* loaded from: assets/audience_network/classes2.dex */
public abstract /* synthetic */ class MX {
    public static String[] A00 = {"kAVLkaOPTenDjNStg3AqGnsJ6mUxlh", "fdMZ5FC2", "RcZfMO7G0A", "D26EIYlb", "rGLz93weyR", "", "QBfYKUrTqNlMcNacns9hu", ""};

    public static /* synthetic */ String A00(C07495i c07495i) {
        if (c07495i.A08 != null) {
            return c07495i.A08;
        }
        Uri uri = c07495i.A06;
        String[] strArr = A00;
        if (strArr[5].length() != strArr[7].length()) {
            throw new RuntimeException();
        }
        A00[6] = "qSUHhmHVZn4hNc1KXxuwz";
        return uri.toString();
    }
}
