package com.example.chatbot.common.databases.user_database

interface UserRepository {

    /**
     * Adds a new user to the repository.
     *
     * @param user The user to be added.
     * @return Result indicating success or failure with associated data of type Unit.
     */
    suspend fun addUser(user: User): Result<Unit>

    /**
     * Deletes a user from the repository.
     *
     * @param user The user to be deleted.
     * @return Result indicating success or failure with associated data of type Unit.
     */
    suspend fun deleteUser(user: User): Result<Unit>

    /**
     * Updates an existing user in the repository.
     *
     * @param user The updated user information.
     * @return Result indicating success or failure with associated data of type Unit.
     */
    suspend fun updateUser(user: User): Result<Unit>

    /**
     * Retrieves a user by their unique identifier (uid).
     *
     * @param userUid The unique identifier (uid) of the user to be retrieved.
     * @return Result containing the user information or null if not found.
     */
    suspend fun getUserByUid(userUid: String): Result<User?>
}