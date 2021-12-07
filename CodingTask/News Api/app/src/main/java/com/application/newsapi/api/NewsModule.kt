package com.application.newsapi.api

import android.content.Context
import androidx.room.Room
import com.application.newsapi.data.NewsDao
import com.application.newsapi.data.NewsRoomDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsModule {

    @Singleton
    @Provides
    fun ProvidesApiService(): ApiNews {
        val builder = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return builder.create(ApiNews::class.java)
    }

    @Singleton
    @Provides
    fun ProvidesRoomDataBase(@ApplicationContext context: Context): NewsRoomDataBase {

        val builder = Room.databaseBuilder(
            context, NewsRoomDataBase::class.java,
            "News_db"
        )
        builder.fallbackToDestructiveMigration()
            return builder.build()

    }

    @Singleton
    @Provides
    fun ProvidesDatatoDb(db: NewsRoomDataBase): NewsDao {
        return db.getDao()
    }
}