/*
Using Groovy to read email form GMail.
Just for development purposes, GMail will not allow in first time the login, so I enabled the option to log from non secure apps
SSL it's necessary
Another good tutorial coudl be find here using SSL:
http://agileice.blogspot.mx/2008/10/using-groovy-to-connect-to-gmail.html
*/

@Grab(group='javax.mail', module='mail', version='1.4.7')

import javax.mail.*
import javax.mail.internet.*;
import javax.mail.search.*;

def host = "imap.gmail.com"
def port = "993"
def username = "bkrexample@gmail.com"
def password = "bkr12345"

Properties props = new Properties()
props.setProperty("mail.store.protocol", "imaps")
props.setProperty("mail.imap.host", host)
props.setProperty("mail.imap.port", port)
props.setProperty("mail.imap.ssl.enable", "true");

def session = Session.getDefaultInstance(props, null)
def store = session.getStore("imaps")

store.connect(host, username, password)
def folder = store.getFolder("INBOX")

folder.open(Folder.READ_ONLY)

Flags seen = new Flags(Flags.Flag.SEEN);
FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
Message[] msgs = folder.search(unseenFlagTerm);
//
FetchProfile fetchProfile = new FetchProfile()
fetchProfile.add(FetchProfile.Item.ENVELOPE)
folder.fetch(msgs,fetchProfile)
//


//for ( i in 0..(msgs.length -1) ) {
    println "***************************************************"
    println "***************************************************"
    println "date   =  ${msgs[msgs.length -1].receivedDate}"
    println "sender =${msgs[msgs.length -1].sender}"
    println "from   =${msgs[msgs.length -1].from}"
    println "subject=${msgs[msgs.length -1].subject}"
    //msgs[msgs.length -1].writeTo(System.out)

    def fan = msgs[msgs.length -1]
    println "***************************************************"
    println (fan.writeTo(System.out))
    println "***************************************************"
//}