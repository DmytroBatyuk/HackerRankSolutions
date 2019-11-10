package interviewPreparationKit

object Arrays {
    fun hourglassSum(array: Array<Array<Int>>): Int {
        var maxSum = Integer.MIN_VALUE
        for(y in 0 until array.size-2) {
            for(x in 0 until array[y].size-2) {
                val sum =
                    array[y][x] + array[y][x+1] + array[y][x+2] +
                            array[y+1][x+1] +
                            array[y+2][x] + array[y+2][x+1] + array[y+2][x+2]
                if (sum > maxSum) {
                    maxSum = sum
                }
            }
        }

        return maxSum
    }

    fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
        val cpy = Array<Int>(a.size) { 0 }
        var fi = d
        for(i in 0 until a.size) {
            cpy[i] = a[fi]
            fi = (fi+1)%a.size
        }

        return cpy
    }

    fun minimumSwaps(arr: Array<Int>): Int {
        var temp = Array<Int>(arr.size, { i -> i + 1})
        var count = 0

        for (i in 0 until arr.size-1) {
            val actual = arr[i]
            val expected = i + 1
            val actualI = i
            val expectedI = temp[expected]
            if (actual != expected) {
                arr[actualI] = expected
                arr[expectedI] = actual
                temp[actual] = expectedI
                temp[expected] = actualI
                count++
            }
        }


        return count
    }

    fun minimumBribes(q: Array<Int>): Unit {
        var counter = 0
        for(i in q.size-1 downTo 1) {
            val expected = i+1
            if (expected != q[i]) {
                if (expected == q[i-1]) {
                    downShift(q, i-1, 1)
                    counter +=1
                } else if (expected == q[i-2]) {
                    downShift(q, i-2, 2)
                    counter += 2
                } else {
                    println("Too chaotic")
                    return
                }
            }
        }
        println(counter)
    }
    private fun downShift(q: Array<Int>, pos: Int, shifts: Int) {
        val tmp = q[pos]

        var shiftPos = pos
        for(i in 0 until shifts) {
            q[shiftPos] = q[shiftPos+1]
            shiftPos++
        }
        q[pos+shifts] = tmp
    }
}