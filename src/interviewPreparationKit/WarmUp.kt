package interviewPreparationKit

object WarmUp {
    fun countingValleys(n: Int, s: String): Int {
        var valleyCounter = 0
        var seeLevel = 0
        var wasOnSeeLevel = true
        for(i in 0 until n) {
            when (s[i]) {
                'U' -> seeLevel++
                'D' -> seeLevel--
            }
            if (seeLevel == -1 && wasOnSeeLevel) {
                valleyCounter++
                wasOnSeeLevel = false
            }
            if (seeLevel == 0) {
                wasOnSeeLevel = true
            }
        }

        return valleyCounter
    }

    fun jumpingOnClouds(c: Array<Int>): Int {
        var i = 0
        var jumpCount = 0
        while(i < c.size-1) {
            if (i < c.size-2 && c[i+2] == 0) {
                i+=2
                jumpCount++
            } else if (c[i+1] == 0) {
                i++
                jumpCount++
            }
        }
        return jumpCount
    }
}

fun repeatedString(s: String, n: Long): Long {
    var counter = 0L

    var circles = n/s.length
    if (circles > 0) {
        for(i in 0 until s.length) {
            if (s[i] == 'a') {
                counter++
            }
        }
        counter = circles*counter
    }

    for(i in 0 until (n%s.length).toInt()) {
        if (s[i] == 'a') {
            counter++
        }
    }

    return counter
}