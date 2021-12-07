package com.application.itunessong.responsemodel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\br\b\u0086\b\u0018\u00002\u00020\u0001B\u00d5\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u0006\u0010\u001e\u001a\u00020\u0005\u0012\u0006\u0010\u001f\u001a\u00020\u0005\u0012\u0006\u0010 \u001a\u00020\u0005\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\u0006\u0010#\u001a\u00020\u0005\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u0006\u0010%\u001a\u00020\u0005\u0012\u0006\u0010&\u001a\u00020\u0010\u0012\u0006\u0010\'\u001a\u00020\u0010\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\u0006\u0010)\u001a\u00020\u0005\u0012\u0006\u0010*\u001a\u00020\u0003\u0012\u0006\u0010+\u001a\u00020\u0010\u0012\u0006\u0010,\u001a\u00020\u0010\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0005\u0012\u0006\u0010/\u001a\u00020\u0005\u00a2\u0006\u0002\u00100J\t\u0010^\u001a\u00020\u0003H\u00c6\u0003J\t\u0010_\u001a\u00020\u0005H\u00c6\u0003J\t\u0010`\u001a\u00020\u0005H\u00c6\u0003J\t\u0010a\u001a\u00020\u0010H\u00c6\u0003J\t\u0010b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010d\u001a\u00020\u0010H\u00c6\u0003J\t\u0010e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010f\u001a\u00020\u0005H\u00c6\u0003J\t\u0010g\u001a\u00020\u0005H\u00c6\u0003J\t\u0010h\u001a\u00020\u0005H\u00c6\u0003J\t\u0010i\u001a\u00020\u0005H\u00c6\u0003J\t\u0010j\u001a\u00020\u0003H\u00c6\u0003J\t\u0010k\u001a\u00020\u0003H\u00c6\u0003J\t\u0010l\u001a\u00020\u001bH\u00c6\u0003J\t\u0010m\u001a\u00020\u001bH\u00c6\u0003J\t\u0010n\u001a\u00020\u0005H\u00c6\u0003J\t\u0010o\u001a\u00020\u0005H\u00c6\u0003J\t\u0010p\u001a\u00020\u0005H\u00c6\u0003J\t\u0010q\u001a\u00020\u0005H\u00c6\u0003J\t\u0010r\u001a\u00020\u0005H\u00c6\u0003J\t\u0010s\u001a\u00020\u0005H\u00c6\u0003J\t\u0010t\u001a\u00020\u0005H\u00c6\u0003J\t\u0010u\u001a\u00020\u0005H\u00c6\u0003J\t\u0010v\u001a\u00020\u0003H\u00c6\u0003J\t\u0010w\u001a\u00020\u0005H\u00c6\u0003J\t\u0010x\u001a\u00020\u0010H\u00c6\u0003J\t\u0010y\u001a\u00020\u0010H\u00c6\u0003J\t\u0010z\u001a\u00020\u0003H\u00c6\u0003J\t\u0010{\u001a\u00020\u0005H\u00c6\u0003J\t\u0010|\u001a\u00020\u0003H\u00c6\u0003J\t\u0010}\u001a\u00020\u0010H\u00c6\u0003J\t\u0010~\u001a\u00020\u0010H\u00c6\u0003J\t\u0010\u007f\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0081\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0082\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0084\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0085\u0001\u001a\u00020\u0003H\u00c6\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005H\u00c6\u0003J\n\u0010\u0087\u0001\u001a\u00020\u0005H\u00c6\u0003J\u00ae\u0003\u0010\u0088\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u001b2\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010&\u001a\u00020\u00102\b\b\u0002\u0010\'\u001a\u00020\u00102\b\b\u0002\u0010(\u001a\u00020\u00032\b\b\u0002\u0010)\u001a\u00020\u00052\b\b\u0002\u0010*\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020\u00102\b\b\u0002\u0010,\u001a\u00020\u00102\b\b\u0002\u0010-\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u00052\b\b\u0002\u0010/\u001a\u00020\u0005H\u00c6\u0001J\u0015\u0010\u0089\u0001\u001a\u00020\u001b2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\n\u0010\u008b\u0001\u001a\u00020\u0003H\u00d6\u0001J\n\u0010\u008c\u0001\u001a\u00020\u0005H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00104R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u00104R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00104R\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u00104R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u00102R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00104R\u0016\u0010\f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00104R\u0016\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00104R\u0016\u0010\u000e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u00104R\u0016\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00102R\u0016\u0010\u0012\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u00104R\u0016\u0010\u0013\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010?R\u0016\u0010\u0014\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u00104R\u0016\u0010\u0015\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u00104R\u0016\u0010\u0016\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u00104R\u0016\u0010\u0017\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u00104R\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bG\u00102R\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u00102R\u0016\u0010\u001a\u001a\u00020\u001b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0016\u0010\u001c\u001a\u00020\u001b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010JR\u0016\u0010\u001d\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bK\u00104R\u0016\u0010\u001e\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u00104R\u0016\u0010\u001f\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bM\u00104R\u0016\u0010 \u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u00104R\u0016\u0010!\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bO\u00104R\u0016\u0010\"\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bP\u00104R\u0016\u0010#\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bQ\u00104R\u0016\u0010$\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bR\u00102R\u0016\u0010%\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bS\u00104R\u0016\u0010&\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bT\u0010?R\u0016\u0010\'\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bU\u0010?R\u0016\u0010(\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bV\u00102R\u0016\u0010)\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bW\u00104R\u0016\u0010*\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bX\u00102R\u0016\u0010+\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bY\u0010?R\u0016\u0010,\u001a\u00020\u00108\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010?R\u0016\u0010-\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b[\u00102R\u0016\u0010.\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\\\u00104R\u0016\u0010/\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b]\u00104\u00a8\u0006\u008d\u0001"}, d2 = {"Lcom/application/itunessong/responsemodel/Result;", "", "artistId", "", "artistName", "", "artistViewUrl", "artworkUrl100", "artworkUrl30", "artworkUrl60", "collectionArtistId", "collectionArtistName", "collectionArtistViewUrl", "collectionCensoredName", "collectionExplicitness", "collectionHdPrice", "", "collectionId", "collectionName", "collectionPrice", "collectionViewUrl", "contentAdvisoryRating", "country", "currency", "discCount", "discNumber", "hasITunesExtras", "", "isStreamable", "kind", "longDescription", "previewUrl", "primaryGenreName", "releaseDate", "shortDescription", "trackCensoredName", "trackCount", "trackExplicitness", "trackHdPrice", "trackHdRentalPrice", "trackId", "trackName", "trackNumber", "trackPrice", "trackRentalPrice", "trackTimeMillis", "trackViewUrl", "wrapperType", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DILjava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;DDILjava/lang/String;IDDILjava/lang/String;Ljava/lang/String;)V", "getArtistId", "()I", "getArtistName", "()Ljava/lang/String;", "getArtistViewUrl", "getArtworkUrl100", "getArtworkUrl30", "getArtworkUrl60", "getCollectionArtistId", "getCollectionArtistName", "getCollectionArtistViewUrl", "getCollectionCensoredName", "getCollectionExplicitness", "getCollectionHdPrice", "()D", "getCollectionId", "getCollectionName", "getCollectionPrice", "getCollectionViewUrl", "getContentAdvisoryRating", "getCountry", "getCurrency", "getDiscCount", "getDiscNumber", "getHasITunesExtras", "()Z", "getKind", "getLongDescription", "getPreviewUrl", "getPrimaryGenreName", "getReleaseDate", "getShortDescription", "getTrackCensoredName", "getTrackCount", "getTrackExplicitness", "getTrackHdPrice", "getTrackHdRentalPrice", "getTrackId", "getTrackName", "getTrackNumber", "getTrackPrice", "getTrackRentalPrice", "getTrackTimeMillis", "getTrackViewUrl", "getWrapperType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component40", "component41", "component42", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Result {
    @com.google.gson.annotations.SerializedName(value = "artistId")
    private final int artistId = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "artistName")
    private final java.lang.String artistName = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "artistViewUrl")
    private final java.lang.String artistViewUrl = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "artworkUrl100")
    private final java.lang.String artworkUrl100 = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "artworkUrl30")
    private final java.lang.String artworkUrl30 = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "artworkUrl60")
    private final java.lang.String artworkUrl60 = null;
    @com.google.gson.annotations.SerializedName(value = "collectionArtistId")
    private final int collectionArtistId = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "collectionArtistName")
    private final java.lang.String collectionArtistName = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "collectionArtistViewUrl")
    private final java.lang.String collectionArtistViewUrl = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "collectionCensoredName")
    private final java.lang.String collectionCensoredName = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "collectionExplicitness")
    private final java.lang.String collectionExplicitness = null;
    @com.google.gson.annotations.SerializedName(value = "collectionHdPrice")
    private final double collectionHdPrice = 0.0;
    @com.google.gson.annotations.SerializedName(value = "collectionId")
    private final int collectionId = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "collectionName")
    private final java.lang.String collectionName = null;
    @com.google.gson.annotations.SerializedName(value = "collectionPrice")
    private final double collectionPrice = 0.0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "collectionViewUrl")
    private final java.lang.String collectionViewUrl = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "contentAdvisoryRating")
    private final java.lang.String contentAdvisoryRating = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "country")
    private final java.lang.String country = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "currency")
    private final java.lang.String currency = null;
    @com.google.gson.annotations.SerializedName(value = "discCount")
    private final int discCount = 0;
    @com.google.gson.annotations.SerializedName(value = "discNumber")
    private final int discNumber = 0;
    @com.google.gson.annotations.SerializedName(value = "hasITunesExtras")
    private final boolean hasITunesExtras = false;
    @com.google.gson.annotations.SerializedName(value = "isStreamable")
    private final boolean isStreamable = false;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "kind")
    private final java.lang.String kind = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "longDescription")
    private final java.lang.String longDescription = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "previewUrl")
    private final java.lang.String previewUrl = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "primaryGenreName")
    private final java.lang.String primaryGenreName = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "releaseDate")
    private final java.lang.String releaseDate = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "shortDescription")
    private final java.lang.String shortDescription = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "trackCensoredName")
    private final java.lang.String trackCensoredName = null;
    @com.google.gson.annotations.SerializedName(value = "trackCount")
    private final int trackCount = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "trackExplicitness")
    private final java.lang.String trackExplicitness = null;
    @com.google.gson.annotations.SerializedName(value = "trackHdPrice")
    private final double trackHdPrice = 0.0;
    @com.google.gson.annotations.SerializedName(value = "trackHdRentalPrice")
    private final double trackHdRentalPrice = 0.0;
    @com.google.gson.annotations.SerializedName(value = "trackId")
    private final int trackId = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "trackName")
    private final java.lang.String trackName = null;
    @com.google.gson.annotations.SerializedName(value = "trackNumber")
    private final int trackNumber = 0;
    @com.google.gson.annotations.SerializedName(value = "trackPrice")
    private final double trackPrice = 0.0;
    @com.google.gson.annotations.SerializedName(value = "trackRentalPrice")
    private final double trackRentalPrice = 0.0;
    @com.google.gson.annotations.SerializedName(value = "trackTimeMillis")
    private final int trackTimeMillis = 0;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "trackViewUrl")
    private final java.lang.String trackViewUrl = null;
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "wrapperType")
    private final java.lang.String wrapperType = null;
    
    @org.jetbrains.annotations.NotNull
    public final com.application.itunessong.responsemodel.Result copy(int artistId, @org.jetbrains.annotations.NotNull
    java.lang.String artistName, @org.jetbrains.annotations.NotNull
    java.lang.String artistViewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String artworkUrl100, @org.jetbrains.annotations.NotNull
    java.lang.String artworkUrl30, @org.jetbrains.annotations.NotNull
    java.lang.String artworkUrl60, int collectionArtistId, @org.jetbrains.annotations.NotNull
    java.lang.String collectionArtistName, @org.jetbrains.annotations.NotNull
    java.lang.String collectionArtistViewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String collectionCensoredName, @org.jetbrains.annotations.NotNull
    java.lang.String collectionExplicitness, double collectionHdPrice, int collectionId, @org.jetbrains.annotations.NotNull
    java.lang.String collectionName, double collectionPrice, @org.jetbrains.annotations.NotNull
    java.lang.String collectionViewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String contentAdvisoryRating, @org.jetbrains.annotations.NotNull
    java.lang.String country, @org.jetbrains.annotations.NotNull
    java.lang.String currency, int discCount, int discNumber, boolean hasITunesExtras, boolean isStreamable, @org.jetbrains.annotations.NotNull
    java.lang.String kind, @org.jetbrains.annotations.NotNull
    java.lang.String longDescription, @org.jetbrains.annotations.NotNull
    java.lang.String previewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String primaryGenreName, @org.jetbrains.annotations.NotNull
    java.lang.String releaseDate, @org.jetbrains.annotations.NotNull
    java.lang.String shortDescription, @org.jetbrains.annotations.NotNull
    java.lang.String trackCensoredName, int trackCount, @org.jetbrains.annotations.NotNull
    java.lang.String trackExplicitness, double trackHdPrice, double trackHdRentalPrice, int trackId, @org.jetbrains.annotations.NotNull
    java.lang.String trackName, int trackNumber, double trackPrice, double trackRentalPrice, int trackTimeMillis, @org.jetbrains.annotations.NotNull
    java.lang.String trackViewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String wrapperType) {
        return null;
    }
    
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Result(int artistId, @org.jetbrains.annotations.NotNull
    java.lang.String artistName, @org.jetbrains.annotations.NotNull
    java.lang.String artistViewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String artworkUrl100, @org.jetbrains.annotations.NotNull
    java.lang.String artworkUrl30, @org.jetbrains.annotations.NotNull
    java.lang.String artworkUrl60, int collectionArtistId, @org.jetbrains.annotations.NotNull
    java.lang.String collectionArtistName, @org.jetbrains.annotations.NotNull
    java.lang.String collectionArtistViewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String collectionCensoredName, @org.jetbrains.annotations.NotNull
    java.lang.String collectionExplicitness, double collectionHdPrice, int collectionId, @org.jetbrains.annotations.NotNull
    java.lang.String collectionName, double collectionPrice, @org.jetbrains.annotations.NotNull
    java.lang.String collectionViewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String contentAdvisoryRating, @org.jetbrains.annotations.NotNull
    java.lang.String country, @org.jetbrains.annotations.NotNull
    java.lang.String currency, int discCount, int discNumber, boolean hasITunesExtras, boolean isStreamable, @org.jetbrains.annotations.NotNull
    java.lang.String kind, @org.jetbrains.annotations.NotNull
    java.lang.String longDescription, @org.jetbrains.annotations.NotNull
    java.lang.String previewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String primaryGenreName, @org.jetbrains.annotations.NotNull
    java.lang.String releaseDate, @org.jetbrains.annotations.NotNull
    java.lang.String shortDescription, @org.jetbrains.annotations.NotNull
    java.lang.String trackCensoredName, int trackCount, @org.jetbrains.annotations.NotNull
    java.lang.String trackExplicitness, double trackHdPrice, double trackHdRentalPrice, int trackId, @org.jetbrains.annotations.NotNull
    java.lang.String trackName, int trackNumber, double trackPrice, double trackRentalPrice, int trackTimeMillis, @org.jetbrains.annotations.NotNull
    java.lang.String trackViewUrl, @org.jetbrains.annotations.NotNull
    java.lang.String wrapperType) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int getArtistId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getArtistName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getArtistViewUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getArtworkUrl100() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getArtworkUrl30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getArtworkUrl60() {
        return null;
    }
    
    public final int component7() {
        return 0;
    }
    
    public final int getCollectionArtistId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCollectionArtistName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCollectionArtistViewUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCollectionCensoredName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCollectionExplicitness() {
        return null;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    public final double getCollectionHdPrice() {
        return 0.0;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int getCollectionId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCollectionName() {
        return null;
    }
    
    public final double component15() {
        return 0.0;
    }
    
    public final double getCollectionPrice() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCollectionViewUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getContentAdvisoryRating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component18() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCountry() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component19() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getCurrency() {
        return null;
    }
    
    public final int component20() {
        return 0;
    }
    
    public final int getDiscCount() {
        return 0;
    }
    
    public final int component21() {
        return 0;
    }
    
    public final int getDiscNumber() {
        return 0;
    }
    
    public final boolean component22() {
        return false;
    }
    
    public final boolean getHasITunesExtras() {
        return false;
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final boolean isStreamable() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component24() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getKind() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component25() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLongDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPreviewUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component27() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPrimaryGenreName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component28() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getReleaseDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getShortDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTrackCensoredName() {
        return null;
    }
    
    public final int component31() {
        return 0;
    }
    
    public final int getTrackCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component32() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTrackExplicitness() {
        return null;
    }
    
    public final double component33() {
        return 0.0;
    }
    
    public final double getTrackHdPrice() {
        return 0.0;
    }
    
    public final double component34() {
        return 0.0;
    }
    
    public final double getTrackHdRentalPrice() {
        return 0.0;
    }
    
    public final int component35() {
        return 0;
    }
    
    public final int getTrackId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component36() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTrackName() {
        return null;
    }
    
    public final int component37() {
        return 0;
    }
    
    public final int getTrackNumber() {
        return 0;
    }
    
    public final double component38() {
        return 0.0;
    }
    
    public final double getTrackPrice() {
        return 0.0;
    }
    
    public final double component39() {
        return 0.0;
    }
    
    public final double getTrackRentalPrice() {
        return 0.0;
    }
    
    public final int component40() {
        return 0;
    }
    
    public final int getTrackTimeMillis() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component41() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTrackViewUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component42() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWrapperType() {
        return null;
    }
}