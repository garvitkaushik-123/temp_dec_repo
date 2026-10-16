package com.sourcepoint.cmplibrary.core.layout.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NativeMessageDto.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toTextViewConfigDto", "Lcom/sourcepoint/cmplibrary/core/layout/model/TextViewConfigDto;", "Lcom/sourcepoint/cmplibrary/core/layout/model/ActionDto;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class NativeMessageDtoKt {
    public static final TextViewConfigDto toTextViewConfigDto(ActionDto actionDto) {
        Intrinsics.checkNotNullParameter(actionDto, "<this>");
        return new TextViewConfigDto(actionDto.getCustomFields(), actionDto.getStyle(), actionDto.getText());
    }
}
