package edu.uw.echee.httppulldowntoupdate_sp21.repository

import edu.uw.echee.httppulldowntoupdate_sp21.model.Email
import edu.uw.echee.httppulldowntoupdate_sp21.model.Inbox
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * https://raw.githubusercontent.com/echeeUW/codesnippets/master/email.json
 *
 * https://raw.githubusercontent.com/echeeUW/codesnippets/master/emails.json
 */

class DataRepository {

    private val emailService = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(EmailService::class.java)


    suspend fun getEmail(): Email = emailService.getEmail()

    suspend fun getInbox() = emailService.getInbox()

//    suspend fun getUser(userId: String, apiKey: String) = emailService.getUser(userId, apiKey)

}

interface EmailService {

    @GET("echeeUW/codesnippets/master/email.json")
    suspend fun getEmail(): Email


    @GET("echeeUW/codesnippets/master/emails.json")
    suspend fun getInbox(): Inbox

/*
    @GET("echeeUW/codesnippets/master/emails.json")
    suspend fun getUser(
        @Header("apiKey") apiKey: String,
        @Query("userId") userId: String,
    ): Inbox
*/


}
