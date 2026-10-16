package io.ktor.http;

import com.ironsource.C3040d4;
import io.ktor.http.ContentRange;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Ranges.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\b\u0012\u0004\u0012\u00020\b0\u00052\u0006\u0010\t\u001a\u00020\nH\u0000¨\u0006\u000b"}, d2 = {"parseRangesSpecifier", "Lio/ktor/http/RangesSpecifier;", "rangeSpec", "", "mergeRangesKeepOrder", "", "Lkotlin/ranges/LongRange;", "toLongRanges", "Lio/ktor/http/ContentRange;", "contentLength", "", "ktor-http"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class RangesKt {
    public static final RangesSpecifier parseRangesSpecifier(String rangeSpec) {
        int indexOf$default;
        Pair pair;
        ContentRange bounded;
        Intrinsics.checkNotNullParameter(rangeSpec, "rangeSpec");
        try {
            indexOf$default = StringsKt.indexOf$default((CharSequence) rangeSpec, C3040d4.i.b, 0, false, 6, (Object) null);
        } catch (Throwable unused) {
        }
        if (indexOf$default == -1) {
            return null;
        }
        String substring = rangeSpec.substring(0, indexOf$default);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = rangeSpec.substring(indexOf$default + 1);
        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
        Pair pair2 = TuplesKt.to(substring, substring2);
        String str = (String) pair2.component1();
        List<String> split$default = StringsKt.split$default((CharSequence) pair2.component2(), new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
        for (String str2 : split$default) {
            if (StringsKt.startsWith$default(str2, "-", false, 2, (Object) null)) {
                bounded = new ContentRange.Suffix(Long.parseLong(StringsKt.removePrefix(str2, (CharSequence) "-")));
            } else {
                int indexOf$default2 = StringsKt.indexOf$default((CharSequence) str2, "-", 0, false, 6, (Object) null);
                if (indexOf$default2 == -1) {
                    pair = TuplesKt.to("", "");
                } else {
                    String substring3 = str2.substring(0, indexOf$default2);
                    Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                    String substring4 = str2.substring(indexOf$default2 + 1);
                    Intrinsics.checkNotNullExpressionValue(substring4, "this as java.lang.String).substring(startIndex)");
                    pair = TuplesKt.to(substring3, substring4);
                }
                String str3 = (String) pair.component1();
                String str4 = (String) pair.component2();
                bounded = str4.length() > 0 ? new ContentRange.Bounded(Long.parseLong(str3), Long.parseLong(str4)) : new ContentRange.TailFrom(Long.parseLong(str3));
            }
            arrayList.add(bounded);
        }
        ArrayList arrayList2 = arrayList;
        if (!arrayList2.isEmpty() && str.length() != 0) {
            RangesSpecifier rangesSpecifier = new RangesSpecifier(str, arrayList2);
            if (RangesSpecifier.isValid$default(rangesSpecifier, null, 1, null)) {
                return rangesSpecifier;
            }
        }
        return null;
    }

    public static final List<LongRange> toLongRanges(List<? extends ContentRange> list, long j) {
        LongRange until;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<? extends ContentRange> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (ContentRange contentRange : list2) {
            if (contentRange instanceof ContentRange.Bounded) {
                ContentRange.Bounded bounded = (ContentRange.Bounded) contentRange;
                until = new LongRange(bounded.getFrom(), kotlin.ranges.RangesKt.coerceAtMost(bounded.getTo(), j - 1));
            } else if (contentRange instanceof ContentRange.TailFrom) {
                until = kotlin.ranges.RangesKt.until(((ContentRange.TailFrom) contentRange).getFrom(), j);
            } else {
                if (!(contentRange instanceof ContentRange.Suffix)) {
                    throw new NoWhenBranchMatchedException();
                }
                until = kotlin.ranges.RangesKt.until(kotlin.ranges.RangesKt.coerceAtLeast(j - ((ContentRange.Suffix) contentRange).getLastCount(), 0L), j);
            }
            arrayList.add(until);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!((LongRange) obj).isEmpty()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final List<LongRange> mergeRangesKeepOrder(List<LongRange> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<LongRange> sortedWith = CollectionsKt.sortedWith(list, new Comparator() { // from class: io.ktor.http.RangesKt$mergeRangesKeepOrder$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((LongRange) t).getStart(), ((LongRange) t2).getStart());
            }
        });
        ArrayList arrayList = new ArrayList(list.size());
        for (LongRange longRange : sortedWith) {
            if (arrayList.isEmpty()) {
                arrayList.add(longRange);
            } else {
                ArrayList arrayList2 = arrayList;
                if (((LongRange) CollectionsKt.last((List) arrayList2)).getEndInclusive().longValue() < longRange.getStart().longValue() - 1) {
                    arrayList.add(longRange);
                } else {
                    LongRange longRange2 = (LongRange) CollectionsKt.last((List) arrayList2);
                    arrayList.set(CollectionsKt.getLastIndex(arrayList2), new LongRange(longRange2.getStart().longValue(), Math.max(longRange2.getEndInclusive().longValue(), longRange.getEndInclusive().longValue())));
                }
            }
        }
        LongRange[] longRangeArr = new LongRange[list.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            LongRange range = (LongRange) it.next();
            int size = list.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    Intrinsics.checkNotNullExpressionValue(range, "range");
                    if (io.ktor.util.RangesKt.contains(range, list.get(i))) {
                        longRangeArr[i] = range;
                        break;
                    }
                    i++;
                }
            }
        }
        return ArraysKt.filterNotNull(longRangeArr);
    }
}
