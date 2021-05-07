package edu.uw.echee.httppulldowntoupdate_sp21

import android.app.Application
import edu.uw.echee.httppulldowntoupdate_sp21.manager.EmailManager
import edu.uw.echee.httppulldowntoupdate_sp21.repository.DataRepository

class HPDUApplication: Application() {

    lateinit var dataRepository: DataRepository

    val  emailManager: EmailManager by lazy { EmailManager() }


    override fun onCreate() {
        super.onCreate()

        dataRepository = DataRepository()
    }
}
