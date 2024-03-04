package kam.amir.omidpay.dagger

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kam.amir.omidpay.OmidPayApp
import kam.amir.omidpay.repositories.Repository
import kam.amir.omidpay.repositories.RepositoryImpl
import kam.amir.omidpay.retrofit.ApiServiceProduct
import kam.amir.omidpay.room.Database
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DI {


    @Provides
    @Singleton
    fun provideRepository(
        database: Database,
        apiServiceProduct: ApiServiceProduct,
    ): Repository {
        return RepositoryImpl(database, apiServiceProduct)
    }

    @Provides
    @Singleton
    fun provideApiServiceProduct(): ApiServiceProduct {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServiceProduct::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(app: Application): Database {
        val db by lazy {
            Room.databaseBuilder(
                app,
                Database::class.java,
                "user_database"
            ).fallbackToDestructiveMigration()
                .build()
        }
        return db
    }

    @Provides
    @Singleton
    fun provideApplication() = OmidPayApp()
}