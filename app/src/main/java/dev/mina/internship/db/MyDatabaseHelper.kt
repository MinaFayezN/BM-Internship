package dev.mina.internship.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DATABASE_NAME = "MyDatabase"
const val DATABASE_VERSION = 1
const val USERS_TABLE = "USERS"
const val USER_ID_COLUMN = "USER_ID"
const val USER_NAME_COLUMN = "USER_NAME"
const val USER_AGE_COLUMN = "USER_AGE"

class MyDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase) {
        // write query to create table
        val createQuery =
            "CREATE TABLE $USERS_TABLE ($USER_ID_COLUMN INTEGER PRIMARY KEY AUTOINCREMENT,$USER_NAME_COLUMN TEXT NOT NULL,$USER_AGE_COLUMN INTEGER)"
        db.execSQL(createQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // delete everything
        onCreate(db)
    }


    fun insertUserData(username: String, userAge: Int): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(USER_NAME_COLUMN, username)
        values.put(USER_AGE_COLUMN, userAge)
        return db.insert(USERS_TABLE, "NO NAME ADDED", values).let {
            db.close()
            it != -1L
        }
    }


    fun updateUserData(id: Int, username: String, userAge: Int): Boolean {
        val db = writableDatabase
        val values = ContentValues()
        values.put(USER_NAME_COLUMN, username)
        values.put(USER_AGE_COLUMN, userAge)
        return db.update(USERS_TABLE, values, "$USER_ID_COLUMN = ?", arrayOf(id.toString())).let {
            db.close()
            it != 0
        }
    }
    fun deleteUserDataWithMinimumAge(minAge :Int): Boolean {
        val db = writableDatabase
        return db.delete(USERS_TABLE, "$USER_AGE_COLUMN < ?", arrayOf(minAge.toString())).let {
            db.close()
            it != 0
        }
    }


    fun getAllNames(): List<String> {
        val names = mutableListOf<String>()
        val query = "SELECT * FROM $USERS_TABLE"
        val db = readableDatabase
        val cursor = db.rawQuery(query, emptyArray())
        if (cursor.moveToFirst())
            do {
                val usernameIndex = cursor.getColumnIndex(USER_NAME_COLUMN)
                val name = cursor.getString(usernameIndex)
                names.add(name)
            } while (cursor.moveToNext())
        cursor.close()
        db.close()
        return names
    }


    fun retrieveNamesWithMinimumAge(minAge: Int): List<User> {
        val names = mutableListOf<User>()
        val db = readableDatabase
        val cursor = db.query(
            /*Distinct*/
            true,
            /*Table Name*/
            USERS_TABLE,
            /*Columns (null in case we need all)*/
            arrayOf(USER_ID_COLUMN, USER_NAME_COLUMN, USER_AGE_COLUMN),
            /*Selection*/
            "$USER_AGE_COLUMN > ?",
            /*Selection Args*/
            arrayOf(minAge.toString()),
            /*Group By*/
            null,
            /*Having*/
            null,
            /*Order By*/
            null,
            /*Limit*/
            null
        )
        if (cursor.moveToFirst())
            do {
                val userIDIndex = cursor.getColumnIndex(USER_ID_COLUMN)
                val userNameIndex = cursor.getColumnIndex(USER_NAME_COLUMN)
                val userAgeIndex = cursor.getColumnIndex(USER_AGE_COLUMN)
                val id = cursor.getInt(userIDIndex)
                val name = cursor.getString(userNameIndex)
                val age = cursor.getInt(userAgeIndex)
                names.add(User(id = id, name = name, age = age))
            } while (cursor.moveToNext())
        cursor.close()
        db.close()
        return names
    }


}