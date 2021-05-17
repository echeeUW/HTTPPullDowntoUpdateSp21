package edu.uw.echee.httppulldowntoupdate_sp21.manager

import edu.uw.echee.httppulldowntoupdate_sp21.model.Inbox

class EmailManager {

    private var inbox: Inbox? = null


    private var numOfEmailsClick = 0

    fun onEmailClicked() {
        numOfEmailsClick++
    }

    fun updateInbox(inbox: Inbox) {
        this.inbox = inbox
    }
}
