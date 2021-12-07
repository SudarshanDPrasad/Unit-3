package com.application.itunessong.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0014\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0018"}, d2 = {"Lcom/application/itunessong/data/SongRepo;", "", "songDao", "Lcom/application/itunessong/roomdatabase/SongDao;", "(Lcom/application/itunessong/roomdatabase/SongDao;)V", "apiClient", "Lcom/application/itunessong/apicall/ApiSong;", "responseHandler", "Lcom/application/itunessong/data/ResponseHandler;", "getResponseHandler", "()Lcom/application/itunessong/data/ResponseHandler;", "getSongDao", "()Lcom/application/itunessong/roomdatabase/SongDao;", "getResponse", "", "result", "", "Lcom/application/itunessong/responsemodel/Result;", "getSong", "Lcom/application/itunessong/data/Resource;", "Lcom/application/itunessong/responsemodel/ResponseDTO;", "query", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class SongRepo {
    @org.jetbrains.annotations.NotNull
    private final com.application.itunessong.roomdatabase.SongDao songDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.application.itunessong.data.ResponseHandler responseHandler = null;
    private com.application.itunessong.apicall.ApiSong apiClient;
    
    @javax.inject.Inject
    public SongRepo(@org.jetbrains.annotations.NotNull
    com.application.itunessong.roomdatabase.SongDao songDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.application.itunessong.roomdatabase.SongDao getSongDao() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.application.itunessong.data.ResponseHandler getResponseHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getSong(@org.jetbrains.annotations.NotNull
    java.lang.String query, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.application.itunessong.data.Resource<com.application.itunessong.responsemodel.ResponseDTO>> continuation) {
        return null;
    }
    
    public final void getResponse(@org.jetbrains.annotations.NotNull
    java.util.List<com.application.itunessong.responsemodel.Result> result) {
    }
}