import java.lang.IllegalArgumentException
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.round
import kotlin.math.sqrt
import kotlin.random.Random

fun number223() {
    var successGeneral = 0
    var successExtra = 0
    var successAll = 0
    val experiments = 100000
    for (j in 1..experiments) {
        for (i in 1..10) {
            val randomGeneral1 = List(170) { Random.nextInt(1, 100000) }
            val randomGeneral2 = List(170) { Random.nextInt(1, 100000) }
            val randomGeneral3 = List(170) { Random.nextInt(1, 100000) }
            val randomGeneral4 = List(170) { Random.nextInt(1, 100000) }
            val randomGeneral5 = List(170) { Random.nextInt(1, 100000) }
            val randomGeneral6 = List(170) { Random.nextInt(1, 100000) }
            val randomExtra = List(230) { Random.nextInt(1, 100000) }

            val obligation = (1..100000).random()

            if (obligation in randomGeneral1 || obligation in randomGeneral2 || obligation in randomGeneral3 ||
                obligation in randomGeneral4 || obligation in randomGeneral5 || obligation in randomGeneral6 ||
                obligation in randomExtra
            ) {
                successAll++
            }
            if (obligation in randomGeneral1 || obligation in randomGeneral2 || obligation in randomGeneral3 ||
                obligation in randomGeneral4 || obligation in randomGeneral5 || obligation in randomGeneral6
            ) {
                successGeneral++
            }
            if (obligation in randomExtra) {
                successExtra++
            }
        }
    }
    val winGeneral = successGeneral.toDouble() / experiments
    val winExtra = successExtra.toDouble() / experiments
    val winAll = successAll.toDouble() / experiments
    println("General: $winGeneral")
    println("Extra: $winExtra")
    println("All: $winAll")
}

fun number317(t: Int, T: Int) {
    var success = 0
    val experiments = 1000000000
    for (i in 1..experiments) {
        val person1 = (0..T).random()
        val person2 = (0..T).random()
        if (abs(person1 - person2) <= t) success++
    }
    val p = success.toDouble() / experiments
    println("P = $p")
}

fun number49(r: Double) {
    var success = 0
    val experiments = 10000000

    //определяем координаты вершин треугольника
    val tx1 = 0.0
    val ty1 = r

    val ty2 = -r / 2
    val ty3 = -r / 2

    val tx2 = sqrt(r.pow(2) - ty2.pow(2))
    val tx3 = -sqrt(r.pow(2) - ty3.pow(2))

    for (i in 1..experiments) {
        var experiment = 0
        for (j in 1..4) {
            var x = round(Random.nextDouble(-r, r) * 100) / 100
            var y = round(Random.nextDouble(-r, r) * 100) / 100
            while (x.pow(2) + y.pow(2) > r.pow(2)) {
                x = round(Random.nextDouble(-r, r) * 100) / 100
                y = round(Random.nextDouble(-r, r) * 100) / 100
            }

            //определяем, что точка внутри треугольника
            val p1 = (tx1 - x) * (ty2 - ty1) - (tx2 - tx1) * (ty1 - y)
            val p2 = (tx2 - x) * (ty3 - ty2) - (tx3 - tx2) * (ty2 - y)
            val p3 = (tx3 - x) * (ty1 - ty3) - (tx1 - tx3) * (ty3 - y)

            if (p1 >= 0 && p2 >= 0 && p3 >= 0 || p1 <= 0 && p2 <= 0 && p3 <= 0) experiment++
        }
        if (experiment == 4) success++
    }
    val p = success.toDouble() / experiments
    println("P = $p")
}

fun number517() {
    var successA = 0
    var successB = 0
    val experiments = 10000000
    for (i in 1..experiments) {
        if ((1..10).random() in (1..3)) {
            successA++
            continue
        }
        if ((1..10).random() in (1..5)) {
            successB++
            continue
        }
        if ((1..10).random() in (1..4)) {
            successA++
            continue
        }
    }
    val pA = successA.toDouble() / experiments
    val pB = successB.toDouble() / experiments
    println("A: $pA")
    println("B: $pB")
}

fun number65() {
    var success = 0
    val experiments = 100000000
    for (i in 1..experiments) {
        val number = (1..5).random()
        val shot = (1..10).random()
        when (number) {
            1 -> if (shot <= 5) success++
            2 -> if (shot <= 6) success++
            3 -> if (shot <= 7) success++
            4 -> if (shot <= 8) success++
            5 -> if (shot <= 9) success++
            else -> continue
        }
    }
    val p = success.toDouble() / experiments
    println("P = $p")
}

fun number72(k1: Int, m1: Int, n1: Int, k2: Int, m2: Int, n2: Int) {
    var shar: String
    var urn: String
    var success = 0
    val experiments = 10000000
    for (i in 1..experiments) {
        do {
            val urnNumber = (1..(k1 + k2)).random()
            if (urnNumber <= k1) {
                shar = if ((1..(m1 + n1)).random() <= m1) "White"
                else "Black"
                urn = "k1"
            } else {
                shar = if ((1..(m2 + n2)).random() <= m2) "White"
                else "Black"
                urn = "k2"
            }
        } while (shar != "White")
        if (urn == "k1") success++
    }
    val p = success.toDouble() / experiments
    println("P = $p")
}

fun number841() {
    val list = mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    var success = 0
    val experiments = 10000000
    for (i in 1..experiments) {
        var goals = 0
        for (j in 0..9) {
            if ((1..10).random() <= 4) goals++
        }
        list[goals]++
    }
    val p = list.indexOf(list.maxOrNull())
    println("Вероятнейшее число попаданий: $p")
    for (i in 1..experiments) {
        var goals = 0
        for (j in 0..9) {
            if ((1..10).random() <= 4) goals++
        }
        if (goals == p) success++
    }
    val pX = success.toDouble() / experiments
    println("Соответствующая вероятность: $pX")
}

fun main() {
    number841()
}





