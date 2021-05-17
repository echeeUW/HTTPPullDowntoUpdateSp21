package edu.uw.echee.httppulldowntoupdate_sp21.manager

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import edu.uw.echee.httppulldowntoupdate_sp21.HPDUApplication
import java.lang.Exception

class EmailSyncWorker(
    private val context: Context, workerParameters: WorkerParameters
): CoroutineWorker(context, workerParameters) {

    private val app by lazy { context.applicationContext as HPDUApplication }
    private val dataRepository by lazy { app.dataRepository }
    private val emailManager by lazy { app.emailManager }


    override suspend fun doWork(): Result {
        return try {
            val inbox = dataRepository.getInbox()

            // NotificationManager, notify new emails have arrived

            emailManager.updateInbox(inbox)

            Result.success()
        } catch (ex: Exception) {
            Result.failure()
        }
    }


}
