package com.ironsource;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class Sa {

    /* renamed from: a, reason: collision with root package name */
    private final String f3049a;
    private final int b;

    public Sa(String str, int i) {
        this.f3049a = str;
        this.b = i;
    }

    private final String b() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "stackTrace");
        String a2 = a(stackTrace, 4);
        String b = b(stackTrace, 4);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%s %s", Arrays.copyOf(new Object[]{a2, b}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public final int a() {
        return this.b;
    }

    public final String c() {
        String str = this.f3049a;
        if (str == null || str.length() == 0) {
            return b();
        }
        return b() + " - " + this.f3049a;
    }

    private final String a(StackTraceElement[] stackTraceElementArr, int i) {
        List emptyList;
        List emptyList2;
        if (stackTraceElementArr.length <= i) {
            return "";
        }
        String className = stackTraceElementArr[i].getClassName();
        Intrinsics.checkNotNullExpressionValue(className, "stackTrace[depth]\n              .className");
        List<String> split = new Regex("\\.").split(className, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (listIterator.hasPrevious()) {
                if (listIterator.previous().length() != 0) {
                    emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList = CollectionsKt.emptyList();
        String str = ((String[]) emptyList.toArray(new String[0]))[r4.length - 1];
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) "$", false, 2, (Object) null)) {
            return str;
        }
        List<String> split2 = new Regex("\\$").split(str, 0);
        if (!split2.isEmpty()) {
            ListIterator<String> listIterator2 = split2.listIterator(split2.size());
            while (listIterator2.hasPrevious()) {
                if (listIterator2.previous().length() != 0) {
                    emptyList2 = CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                    break;
                }
            }
        }
        emptyList2 = CollectionsKt.emptyList();
        return ((String[]) emptyList2.toArray(new String[0]))[0];
    }

    private final String b(StackTraceElement[] stackTraceElementArr, int i) {
        List emptyList;
        int i2;
        List emptyList2;
        List emptyList3;
        if (stackTraceElementArr.length > i) {
            String className = stackTraceElementArr[i].getClassName();
            Intrinsics.checkNotNullExpressionValue(className, "stackTrace[depth]\n              .className");
            List<String> split = new Regex("\\.").split(className, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() != 0) {
                        emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList = CollectionsKt.emptyList();
            String[] strArr = (String[]) emptyList.toArray(new String[0]);
            String str = strArr[strArr.length - 1];
            if (StringsKt.contains$default((CharSequence) str, (CharSequence) "$", false, 2, (Object) null)) {
                List<String> split2 = new Regex("\\$").split(str, 0);
                if (!split2.isEmpty()) {
                    ListIterator<String> listIterator2 = split2.listIterator(split2.size());
                    while (listIterator2.hasPrevious()) {
                        if (listIterator2.previous().length() != 0) {
                            emptyList3 = CollectionsKt.take(split2, listIterator2.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList3 = CollectionsKt.emptyList();
                return ((String[]) emptyList3.toArray(new String[0]))[1] + "." + stackTraceElementArr[i].getMethodName();
            }
            String methodName = stackTraceElementArr[i].getMethodName();
            Intrinsics.checkNotNullExpressionValue(methodName, "stackTrace[depth].methodName");
            if (StringsKt.contains$default((CharSequence) methodName, (CharSequence) "$", false, 2, (Object) null) && stackTraceElementArr.length > (i2 = i + 1)) {
                String className2 = stackTraceElementArr[i2].getClassName();
                Intrinsics.checkNotNullExpressionValue(className2, "stackTrace[depth + 1]\n                .className");
                List<String> split3 = new Regex("\\$").split(className2, 0);
                if (!split3.isEmpty()) {
                    ListIterator<String> listIterator3 = split3.listIterator(split3.size());
                    while (listIterator3.hasPrevious()) {
                        if (listIterator3.previous().length() != 0) {
                            emptyList2 = CollectionsKt.take(split3, listIterator3.nextIndex() + 1);
                            break;
                        }
                    }
                }
                emptyList2 = CollectionsKt.emptyList();
                String[] strArr2 = (String[]) emptyList2.toArray(new String[0]);
                if (strArr2.length > 1) {
                    return strArr2[1] + "." + stackTraceElementArr[i2].getMethodName();
                }
                String methodName2 = stackTraceElementArr[i2].getMethodName();
                Intrinsics.checkNotNullExpressionValue(methodName2, "{\n              stackTra….methodName\n            }");
                return methodName2;
            }
            String methodName3 = stackTraceElementArr[i].getMethodName();
            Intrinsics.checkNotNullExpressionValue(methodName3, "stackTrace[depth].methodName");
            return methodName3;
        }
        return "";
    }
}
