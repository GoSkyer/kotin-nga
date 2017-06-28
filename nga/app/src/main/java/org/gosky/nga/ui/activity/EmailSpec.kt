package org.gosky.nga.ui.activity;

class EmailSpec {
    fun from(from: String) = println("From: $from")
    fun to(to: String) = println("To: $to")
    fun subject(subject: String) = println("Subject: $subject")
    fun body(init: BodySpec.() -> Unit): BodySpec {
        val body = BodySpec()
        body.init()
        return body
    }
}

class BodySpec {
    fun p(p: String) = println("P: $p")
}

fun String.email(init: EmailSpec.() -> Unit): Unit {
        
}