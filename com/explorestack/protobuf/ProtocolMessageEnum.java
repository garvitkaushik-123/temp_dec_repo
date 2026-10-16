package com.explorestack.protobuf;

import com.explorestack.protobuf.Descriptors;
import com.explorestack.protobuf.Internal;

/* loaded from: classes3.dex */
public interface ProtocolMessageEnum extends Internal.EnumLite {
    Descriptors.EnumDescriptor getDescriptorForType();

    @Override // com.explorestack.protobuf.Internal.EnumLite
    int getNumber();

    Descriptors.EnumValueDescriptor getValueDescriptor();
}
