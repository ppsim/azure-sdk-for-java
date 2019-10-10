/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.network.v2019_08_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.network.v2019_08_01.VirtualRouterPeerings;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.network.v2019_08_01.VirtualRouterPeering;

class VirtualRouterPeeringsImpl extends WrapperImpl<VirtualRouterPeeringsInner> implements VirtualRouterPeerings {
    private final NetworkManager manager;

    VirtualRouterPeeringsImpl(NetworkManager manager) {
        super(manager.inner().virtualRouterPeerings());
        this.manager = manager;
    }

    public NetworkManager manager() {
        return this.manager;
    }

    @Override
    public VirtualRouterPeeringImpl define(String name) {
        return wrapModel(name);
    }

    private VirtualRouterPeeringImpl wrapModel(VirtualRouterPeeringInner inner) {
        return  new VirtualRouterPeeringImpl(inner, manager());
    }

    private VirtualRouterPeeringImpl wrapModel(String name) {
        return new VirtualRouterPeeringImpl(name, this.manager());
    }

    @Override
    public Observable<VirtualRouterPeering> listAsync(final String resourceGroupName, final String virtualRouterName) {
        VirtualRouterPeeringsInner client = this.inner();
        return client.listAsync(resourceGroupName, virtualRouterName)
        .flatMapIterable(new Func1<Page<VirtualRouterPeeringInner>, Iterable<VirtualRouterPeeringInner>>() {
            @Override
            public Iterable<VirtualRouterPeeringInner> call(Page<VirtualRouterPeeringInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VirtualRouterPeeringInner, VirtualRouterPeering>() {
            @Override
            public VirtualRouterPeering call(VirtualRouterPeeringInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<VirtualRouterPeering> getAsync(String resourceGroupName, String virtualRouterName, String peeringName) {
        VirtualRouterPeeringsInner client = this.inner();
        return client.getAsync(resourceGroupName, virtualRouterName, peeringName)
        .flatMap(new Func1<VirtualRouterPeeringInner, Observable<VirtualRouterPeering>>() {
            @Override
            public Observable<VirtualRouterPeering> call(VirtualRouterPeeringInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((VirtualRouterPeering)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String virtualRouterName, String peeringName) {
        VirtualRouterPeeringsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, virtualRouterName, peeringName).toCompletable();
    }

}
