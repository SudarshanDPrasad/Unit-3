package com.application.itunessong.apicall;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\u0012\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0007\u00a8\u0006\f"}, d2 = {"Lcom/application/itunessong/apicall/SongModule;", "", "()V", "provideApiService", "Lcom/application/itunessong/apicall/ApiSong;", "provideRoomDB", "Lcom/application/itunessong/roomdatabase/SongDataBase;", "context", "Landroid/content/Context;", "provideTaskDAO", "Lcom/application/itunessong/roomdatabase/SongDao;", "db", "app_debug"})
@dagger.Module
public final class SongModule {
    @org.jetbrains.annotations.NotNull
    public static final com.application.itunessong.apicall.SongModule INSTANCE = null;
    
    private SongModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.application.itunessong.apicall.ApiSong provideApiService() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.application.itunessong.roomdatabase.SongDataBase provideRoomDB(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @dagger.Provides
    @javax.inject.Singleton
    public final com.application.itunessong.roomdatabase.SongDao provideTaskDAO(@org.jetbrains.annotations.NotNull
    com.application.itunessong.roomdatabase.SongDataBase db) {
        return null;
    }
}