package com.explorestack.protobuf;

import com.explorestack.protobuf.Descriptors;

/* loaded from: classes3.dex */
public interface BlockingRpcChannel {
    Message callBlockingMethod(Descriptors.MethodDescriptor methodDescriptor, RpcController rpcController, Message message, Message message2) throws ServiceException;
}
