package co.tiagoaguiar.course.instagram.commom.model

import java.util.*

object Database {

    val usersAuth = hashSetOf<UserAuth>()

    val photos = hashSetOf<Photo>()
    val posts = hashMapOf<String, MutableSet<Post>>()
    val feeds = hashMapOf<String, MutableSet<Post>>()
    var sessionAuth: UserAuth? = null
    val followers = hashMapOf<String, Set<String>>()

    init {
        val userA = UserAuth(UUID.randomUUID().toString(), "UserA","userA@gmail.com", "12345678")
        val userB = UserAuth(UUID.randomUUID().toString(), "UserB","userB@gmail.com", "87654321")
        usersAuth.add(userA)
        usersAuth.add(userB)

        followers[userA.uuid] = hashSetOf()
        posts[userA.uuid] = hashSetOf()
        feeds[userA.uuid] = hashSetOf()

        followers[userB.uuid] = hashSetOf()
        posts[userB.uuid] = hashSetOf()
        feeds[userB.uuid] = hashSetOf()

        sessionAuth = usersAuth.first()
    }
}