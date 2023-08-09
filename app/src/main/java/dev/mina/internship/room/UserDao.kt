package dev.mina.internship.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Query("SELECT * FROM Users_table")
    fun getALlUsers(): List<User>

    @Query("SELECT * FROM Users_table WHERE id = :id")
    fun getUserByID(id: Int): User

    @Query("SELECT * FROM Users_table WHERE age < :minAge")
    fun getUserByMinimumAge(minAge: Int): List<User>

    @Insert
    fun addUser(user: User)

    @Insert
    fun addUserList(users: List<User>)

    @Update
    fun updateUser(user: User)

    @Query("UPDATE Users_table SET age = :age , name = :name WHERE id =:id ")
    fun updateUserManually(id: Int, name: String, age: Int)

    @Query("UPDATE Users_table SET age = :age WHERE name = :name")
    fun updateUserByName(name: String, age: Int)

    @Delete
    fun deleteUser(user: User)

    @Query("DELETE FROM Users_table WHERE name =:name ")
    fun deleteUserManually(name: String)

}