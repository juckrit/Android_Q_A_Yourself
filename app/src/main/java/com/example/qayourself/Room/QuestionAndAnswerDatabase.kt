package com.example.qayourself.Room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.qayourself.Util.DB_NAME


@Database(entities = [(Question::class), (Choice::class)], version = 2)
abstract class QuestionAndAnswerDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    abstract fun choiceDao(): ChoiceDao

    companion object {
        @Volatile
        private var instance: QuestionAndAnswerDatabase? = null

        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL(
                    "CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
                            "PRIMARY KEY(`id`))"
                )
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Book ADD COLUMN pub_year INTEGER")
            }
        }

        fun getInstance(context: Context): QuestionAndAnswerDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): QuestionAndAnswerDatabase {
            return Room.databaseBuilder(
                context
                , QuestionAndAnswerDatabase::class.java
                , DB_NAME
            ).build()


//            Room.databaseBuilder(context, QuestionAndAnswerDatabase::class.java, DB_NAME)
//                .addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()
        }
    }


}