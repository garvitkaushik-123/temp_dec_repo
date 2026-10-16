package io.adn.sdk.internal.common.utils;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: List.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0080\u0002\u001a0\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\u0080\u0002¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\b0\u0001H\u0000¨\u0006\t"}, d2 = {"plus", "", "T", FirebaseAnalytics.Param.ITEMS, "item", "(Ljava/util/List;Ljava/lang/Object;)Ljava/util/List;", "isNotEmptyOrBlank", "", "", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ListKt {
    public static final <T> List<T> plus(List<? extends T> list, List<? extends T> list2) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            CollectionsKt.addAll(arrayList, list);
        }
        if (list2 != null) {
            CollectionsKt.addAll(arrayList, list2);
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> List<T> plus(List<? extends T> list, T t) {
        List<T> plus;
        return (t == null || (plus = plus((List) list, CollectionsKt.listOf(t))) == null) ? list == 0 ? CollectionsKt.emptyList() : list : plus;
    }

    public static final boolean isNotEmptyOrBlank(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list.isEmpty()) {
            return false;
        }
        List<String> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return true;
        }
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            if (StringsKt.isBlank((String) it.next())) {
                return false;
            }
        }
        return true;
    }
}
