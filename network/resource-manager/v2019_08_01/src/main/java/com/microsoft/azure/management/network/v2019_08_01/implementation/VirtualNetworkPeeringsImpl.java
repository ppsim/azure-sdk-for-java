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
import com.microsoft.azure.management.network.v2019_08_01.VirtualNetworkPeerings;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.network.v2019_08_01.VirtualNetworkPeering;

class VirtualNetworkPeeringsImpl extends WrapperImpl<VirtualNetworkPeeringsInner> implements VirtualNetworkPeerings {
    private final NetworkManager manager;

    VirtualNetworkPeeringsImpl(NetworkManager manager) {
        super(manager.inner().virtualNetworkPeerings());
        this.manager = manager;
    }

    public NetworkManager manager() {
        return this.manager;
    }

    @Override
    public VirtualNetworkPeeringImpl define(String name) {
        return wrapModel(name);
    }

    private VirtualNetworkPeeringImpl wrapModel(VirtualNetworkPeeringInner inner) {
        return  new VirtualNetworkPeeringImpl(inner, manager());
    }

    private VirtualNetworkPeeringImpl wrapModel(String name) {
        return new VirtualNetworkPeeringImpl(name, this.manager());
    }

    @Override
    public Observable<VirtualNetworkPeering> listAsync(final String resourceGroupName, final String virtualNetworkName) {
        VirtualNetworkPeeringsInner client = this.inner();
        return client.listAsync(resourceGroupName, virtualNetworkName)
        .flatMapIterable(new Func1<Page<VirtualNetworkPeeringInner>, Iterable<VirtualNetworkPeeringInner>>() {
            @Override
            public Iterable<VirtualNetworkPeeringInner> call(Page<VirtualNetworkPeeringInner> page) {
                return page.items();
            }
        })
        .map(new Func1<VirtualNetworkPeeringInner, VirtualNetworkPeering>() {
            @Override
            public VirtualNetworkPeering call(VirtualNetworkPeeringInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<VirtualNetworkPeering> getAsync(String resourceGroupName, String virtualNetworkName, String virtualNetworkPeeringName) {
        VirtualNetworkPeeringsInner client = this.inner();
        return client.getAsync(resourceGroupName, virtualNetworkName, virtualNetworkPeeringName)
        .flatMap(new Func1<VirtualNetworkPeeringInner, Observable<VirtualNetworkPeering>>() {
            @Override
            public Observable<VirtualNetworkPeering> call(VirtualNetworkPeeringInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((VirtualNetworkPeering)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String virtualNetworkName, String virtualNetworkPeeringName) {
        VirtualNetworkPeeringsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, virtualNetworkName, virtualNetworkPeeringName).toCompletable();
    }

}
