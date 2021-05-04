package edu.uw.echee.httppulldowntoupdate_sp21.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Email(
        val from: String,
        val content: String
): Parcelable
